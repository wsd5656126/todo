<template>
  <div>
    <!--003响应式-->
    <div id="001">
      <!--{{message}}-->
    </div>
    <div id="002">
      <span v-bind:title="message">
        鼠标悬停查看动态绑定提示信息
      </span>
    </div>
    <!--004条件与循环-->
    <div id="003">
      <p v-if="seen">现在你看到了</p>
    </div>
    <div id="004">
      <ol>
        <li v-for="todo in todos">
          {{todo.text}}
        </li>
      </ol>
    </div>
    <!--005处理用户输入-->
    <div id="005">
      <p>{{message}}</p>
      <button v-on:click="reverseMessage()">反转消息</button>
    </div>
    <div id="006">
      <p>{{message}}</p>
      <input v-model="message">
    </div>
    <!--006组件化应用构建-->
    <div id="007">
      <ol>
        <todo-item
          v-for="item in todos"
          v-bind:todo="item"
          v-bind:key="item.id"
        ></todo-item>
      </ol>
    </div>
    <div id="0071">
      <app-nav></app-nav>
      <app-view>
        <app-sidebar></app-sidebar>
        <app-content></app-content>
      </app-view>
    </div>
  </div>
</template>
<script>
import Vue from 'vue'

export default {
  name: 'First',
  //非动态
  data() {
    return {
      todos: [
        {id: 1, text: '学习 JavaScript'},
        {id: 2, text: '学习 Vue'},
        {id: 3, text: '整个牛项目'},
      ],
      seen: false,
      message: 'Hello Vue!'
      // message: '页面加载于 ' + new Date().toLocaleString()
    }
  },
  methods: {
    reverseMessage: function () {
      this.message = this.message.split('').reverse().join('')
    }
  }
}
Vue.component('todo-item', {
  props: ['todo'],
  template: '<li>{{todo.text}}</li>'
});
</script>

<style scoped>
</style>
