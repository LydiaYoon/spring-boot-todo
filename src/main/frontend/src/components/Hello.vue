<
<template>
  <b-card
    header="All Tasks"
    style="max-width: 40rem; margin: auto; margin-top: 10vh;"
    class="mb-2"
    border-variant="info"
    align="left">

    <b-form-group id="to-do-input">
      <b-container fluid>
        <b-row class="my-1">
          <b-col sm="9">
            <b-form-input v-model="newTodoItemRequest.title" type="text" placeholder="I want to ..."
                          v-on:keyup.enter="createTodo"/>
          </b-col>
          <b-col sm="3">
            <b-button variant="primary" v-on:click="createTodo">Add Task</b-button>
          </b-col>
        </b-row>
      </b-container>
    </b-form-group>

    <b-list-group v-if="todoItems && todoItems.length">
      <b-list-group-item
        v-for="todoItem of todoItems"
        v-bind:key="todoItem.id"
        v-bind:data="todoItem.title">
        <b-form-checkbox
          v-model="todoItem.done">
          {{todoItem.title}}
        </b-form-checkbox>
      </b-list-group-item>
    </b-list-group>
  </b-card>
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
            console.log(response)
            vm.initTodoList()
            vm.newTodoItemRequest = {}
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
