<
<template>
  <b-container>
    <b-form-group id="to-do-input">
      <b-container fluid>
        <b-row class="my-1">
          <b-col sm="9" class="p-0">
            <b-form-input block v-model="newTodoItemRequest.title" type="text" placeholder="I want to ..."
                          v-on:keyup.enter="createTodo"/>
          </b-col>
          <b-col sm="3" class="p-0">
            <b-button block variant="primary" v-on:click="createTodo">Add Task</b-button>
          </b-col>
        </b-row>
      </b-container>
    </b-form-group>

    <b-card
      header="All Tasks"
      no-body
      v-if="todoItems && todoItems.length">
      <b-list-group flush
                    class="border-top-0">
        <b-list-group-item>
          <b-container fluid>
            <b-row class="my-1"
                   align-v="center"
                   v-for="todoItem of todoItems"
                   v-bind:key="todoItem.id"
                   v-bind:data="todoItem.title">
              <b-col sm="11">
                <b-row>
                  <b-form-checkbox
                    v-model="todoItem.done"
                    v-on:change="changeMark(todoItem)">
                  </b-form-checkbox>
                  <span v-if="todoItem.done" style="text-decoration: line-through; color: #d3d3de;">
                  {{todoItem.title}}
                </span>
                  <span v-else>
                  {{todoItem.title}}
                </span>
                </b-row>

              </b-col>
              <b-col sm="1" class="p-0" align="right">
                <b-button variant="outline-danger" class="py-1"
                          v-on:click="deleteTodo(todoItem.id)">
                  X
                </b-button>
              </b-col>
            </b-row>
          </b-container>
        </b-list-group-item>
      </b-list-group>
    </b-card>
  </b-container>
</template>

<script>
  import axios from 'axios'

  const baseUrl = 'http://127.0.0.1:5000/todo/'
  export default {
    name: 'hello',
    data: () => {
      return {
        todoItems: [], // 초기화
        newTodoItemRequest: {}
      }
    },
    methods: {
      initTodoList: function () {
        let vm = this
        axios.get(baseUrl)
          .then(response => {
            vm.todoItems = response.data.map(r => r.data)
          })
          .catch(e => {
            console.log('error : ', e)
          })
      },
      createTodo: function (e) {
        e.preventDefault()
        let vm = this
        if (!vm.newTodoItemRequest.title) return // 제목이 없을 경우 리턴
        axios.post(baseUrl, vm.newTodoItemRequest)
          .then(response => {
            vm.initTodoList()
            vm.newTodoItemRequest = {}
          })
          .catch(e => {
            console.log('error : ', e)
          })
      },
      changeMark: function (todoItem) {
        if (!todoItem) return
        let vm = this
        todoItem.done = !todoItem.done
        axios.put(baseUrl, todoItem)
          .then(response => {
            vm.initTodoList()
          })
          .catch(e => {
            console.log('error : ', e)
          })
      },
      deleteTodo: function (id) {
        if (!id) return
        let vm = this
        axios.delete(baseUrl + id)
          .then(response => {
            vm.initTodoList()
          })
          .catch(e => {
            console.log('error : ', e)
          })
      }
    },
    created () {
      this.initTodoList()
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #35495E;
  }
</style>
>
