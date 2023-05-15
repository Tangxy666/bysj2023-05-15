<template>
    <div class="header">
        <el-menu
  :default-active="activeIndex2"
  class="el-menu-demo"
  mode="horizontal"
  @select="handleSelect"
  background-color="#545c64"
  text-color="#fff"
  active-text-color="#ffd04b">
  <el-menu-item index="1" @click="fhsy">首页</el-menu-item>
  <el-menu-item index="2" @click="esctz">二手车</el-menu-item>
  <el-menu-item index="3" @click="qcxx">学习中心</el-menu-item>
  <el-menu-item index="4" @click="community">聊天室</el-menu-item>
  <el-menu-item v-if="myusername==='txy'" index="5" @click="glzxView">统计平台</el-menu-item>
  <el-menu-item index="10" @click="lthahaha">文章</el-menu-item>

  <el-menu-item index="7" @click="cxbkView">出行攻略</el-menu-item>
  <el-submenu index="6">
    <template slot="title"><div class="demo-type">
    <div>
        <el-avatar :size="50"  :src="'https://txy6666.oss-cn-guangzhou.aliyuncs.com/images/'+myusername+'.jpg'"></el-avatar>
    </div>
  </div></template>
    <el-menu-item index="6-1" @click="jrgrzx">个人信息</el-menu-item>
    <el-menu-item index="6-2" @click="fhdl">退出</el-menu-item>
  </el-submenu>
</el-menu>
    </div>
</template>

<style scoped>
#slbd{
    text-align:center;
    background-color: rgb(8, 25, 48);
}
</style>
 
<script>
    export default {
        name: 'common-header',
        data () {
            return {
                activeIndex: '1',
                activeIndex2: '1',
                myusername:'',
            }
        },
        mounted()
        {

            this.myusername=localStorage.getItem("userName");

        },
        methods:{
            handleSelect(key, keyPath) {
            console.log(key, keyPath);
            },
            fhdl:function(e){
                this.$router.push("/");
            },
            jrgrzx:function(e){
                this.$router.push("/permsg");
            },
            fhsy:function(e){
                this.$router.push("/menu");
            },
            esctz:function(e){
                this.$router.push("/usedCar");
            },
            qcxx:function(e){
                this.$router.push("/learningzxView");
            },
            community:function(e){
                this.$router.push("/communityView");
            },
            glzxView:function(e){
                this.$router.push("/glzxView");
            },
            cxbkView:function(e){
                this.$router.push("/cccView");
            },
            lthahaha:function(e){
                this.$router.push("/luntanView");
            },
            
            

        },
        created(){
        }
    }
</script>
