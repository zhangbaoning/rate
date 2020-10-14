import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { sync } from 'vuex-router-sync'
import { Stepper, Rate, Col, Row, Button, Cell, CellGroup, Tabbar, TabbarItem, Form, Field, Dialog } from 'vant'
import axios from 'axios'

Vue.prototype.$axios = axios
Vue.use(Rate)
Vue.use(Col)
Vue.use(Row)
Vue.use(Button)
Vue.use(Cell)
Vue.use(CellGroup)
Vue.use(Tabbar)
Vue.use(TabbarItem)
Vue.use(Form)
Vue.use(Field)
Vue.use(Dialog)

import 'vant/lib/index.css'

Vue.config.productionTip = false

sync(store, router)

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App),
})
Vue.use(Stepper)
