import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    meta:{
      isDisplay: false,
    },
    component: Login
  },
  {
    path: '/registration',
    name: 'registration',
    meta:{
      isDisplay: false,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/Registration.vue')
    }
  },
  {
    path: '/menu',
    name: 'menu',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/Menu.vue')
    }
  },
  {
    path: '/permsg',
    name: 'permsg',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/Permsg.vue')
    }
  },
  {
    path: '/usedCar',
    name: 'usedCar',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/UsedCar.vue')
    }
  }

  ,
  {
    path: '/head',
    name: 'head',
    component: function () {
      return import(/* webpackChunkName: "about" */  '../components/head')
    }
  },
  {
    path: '/learningbased',
    name: 'learningbased',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/LearningbasedView.vue')
    }
  },
  {
    path: '/learningzxView',
    name: 'learningzxView',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/LearningzxView.vue')
    }
  },
  {
    path: '/communityView',
    name: 'communityView',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/CommunityView.vue')
    }
  },
  {
    path: '/glzxView',
    name: 'glzxView',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/GlzxView.vue')
    }
  },
  {
    path: '/cccView',
    name: 'cccView',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/CccView.vue')
    }
  },
  {
    path: '/xinwenzhenwen',
    name: 'xinwenzhenwen',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/Xinwenzhenwen.vue')
    }
  },
  {
    path: '/luntanView',
    name: 'luntanView',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/LuntanView.vue')
    }
  },

  {
    path: '/testWebSocketView',
    name: 'testWebSocketView',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/TestWebSocketView.vue')
    }
  },
  {
    path: '/tianqiView',
    name: 'tianqiView',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/TianqiView.vue')
    }
  },
  {
    path: '/wenzhanView',
    name: 'wenzhanView',
    meta:{
      isDisplay: true,
    },
    component: function () {
      return import(/* webpackChunkName: "about" */  '../views/wenzhanView.vue')
    }
  },



,
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
