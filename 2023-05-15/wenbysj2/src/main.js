import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import ECharts from 'vue-echarts'
import "echarts";

Vue.component('ECharts', ECharts)
Vue.use(ElementUI);
Vue.config.productionTip = false;
Vue.prototype.$axios = axios;

new Vue({
  router,
  render: function (h) { return h(App) }
}).$mount('#app')
