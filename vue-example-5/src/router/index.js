import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '../components/HelloWorld'
import All from '../components/All'
import News from '../components/News'
import DuanZi from '../components/DuanZi'
import Detail from '../components/Detail'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/hw',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'All',
      component: All
    },
    {
      path: '/news',
      name: 'News',
      component: News
    },
    {
      path: '/duanZi',
      name: 'DuanZi',
      component: DuanZi
    },
    {
      path: '/detail',
      name: 'Detail',
      component: Detail
    },
  ]
  // routes: [
  //   {
  //     path: '/',
  //     name: 'home',
  //     redirect: '/home'
  //   },
  //   {
  //     path: '/home',
  //     name: 'Home',
  //     component: Home
  //   },
  //   {
  //     path: '/oneView/oneDetail',
  //     component: OneDetail,
  //     children: [{
  //       path: '/oneView/oneShow',
  //       component: OneShow
  //     }]
  //   }
  // ]
})
