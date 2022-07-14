import Vue from 'vue'
import VueRouter from 'vue-router'
import home from "@/views/Home";
import  Logs from '../views/Log'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: "home",
    component: home,
  },
  {
    path: '/operateLog',
    name: "日志管理",
    component: Logs,
  },
]

/**
 * 路由暴露方式、否则前端会报错找不到改路由
 * */
const router = new VueRouter({
  routes
})

export default router
