<template>
  <div id="app">
    <app-header v-if="this.$route.meta.isDisplay"></app-header>
    <router-view v-on:header="header" v-on:footer="footer"></router-view>
    <app-footer v-if="this.$route.meta.isDisplay" id="app-footer"></app-footer>
  </div>
</template>
 
<script>
import Header from './components/header'
import Footer from './components/footer'
export default {
  name: 'App',
  data(){
      return {
          header_show:true,
          footer_show:true,
      }
  },
  components: {
        'app-header':Header,
        'app-footer':Footer,
  },
  computed:{
 
  },
  methods:{
  }
}
</script>

<style scoped>
#app-footer{
    position: relative;
    bottom: 0;
    text-align: center;
}

html{
  margin: 0;
  padding: 0;
}

body{
  margin: 0 ;
  padding: 0 ;
}
</style>