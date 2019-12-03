import Vue from 'vue'
import Router from 'vue-router'
import Units from "../components/Units";
import Items from "../components/Items";

Vue.use(Router)

const Foo = {template: '<div>foo div</div>'}
const Bar = {template: '<div>bar div</div>'}
const User = {
  //输出当前用户的id
  template: '<div>User {{$route.params.id}}</div>'
}

// 注入路由器
export default new Router({
  routes: [
    {
      path: '/items',
      name: 'Items',
      component: Items
    },
    {
      path: '/units/:id',
      name: 'Units',
      props: true,
      component: Units,
    }
  ]
})
