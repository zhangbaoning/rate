import Vue from 'vue'
import Router from 'vue-router'

const Home = () => import(/* webpackChunkName: "Home" */'@/home/Index.vue')
const List = () => import(/* webpackChunkName: "List" */'@/list/Index.vue')
const Detail = () => import(/* webpackChunkName: "Detail" */'@/detail/Index.vue')
const Index = () => import(/* webpackChunkName: "Index" */'@/index/index.vue')
const Create = () => import(/* webpackChunkName: "Index" */'@/index/create.vue')
const Statistics = () => import(/* webpackChunkName: "Index" */'@/index/statistics.vue')

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [{
    path: '/(home|index)?',
    name: 'Home',
    component: Home,
  }, {
    path: '/index.html',
    name: 'HomeHtml',
    component: Home,
  }, {
    path: '/test/list/:id',
    name: 'List',
    component: List,
  }, {
    path: '/test/detail/:id',
    name: 'Detail',
    component: Detail,
  }, {
    path: '/test/index',
    name: 'Index',
    component: Index,
  }, {
    path: '/test/create',
    name: 'Create',
    component: Create,
  }, {
    path: '/test/statistics',
    name: 'Statistics',
    component: Statistics,
  }],
})
