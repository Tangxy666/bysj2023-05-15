<template>
  <div class="header">
    <div class="top">
      <div class="container">
        <div class="loginList">
          <p>宠物社区欢迎您！</p>
          <p>
            <span>请</span>
            <router-link to="/login">登录</router-link>
            <router-link to="/register" class="register">注册</router-link>
          </p>
        </div>
        <nav class="typeList">
          <a href="###">首页</a>
          <a href="###">我的购物车</a>
          <a href="###">我的尚品汇</a>
          <a href="###">尚品汇会员</a>
          <a href="###">企业采购</a>
          <a href="###">关注尚品汇</a>
          <a href="###">合作招商</a>
          <a href="###">商家后台</a>
        </nav>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
 .header {
  background-color: #ffffff;
  top: 0;
}

* {
  box-sizing: border-box;
  text-align: center;
  margin: 0;
  padding: 0;
}

 .header .top {
  background-color: #bababa;
  height: 40px;
  line-height: 40px;
}

 .header .top .container {
  width: 1200px;
  margin: 0 auto;
  overflow: hidden;
  font-family: "楷体";
}

 .header .top .container .loginList {
  float: left;
}

 .header .top .container .loginList a {
  text-decoration: none;
  color: #050f99;
  padding: 0 10px;
}

 .header .top .container .loginList a:hover {
  color: hotpink;
}

 .header .top .container .loginList p {
  float: left;
  margin-left: 10px;
}

 .header .top .container .loginList p .register {
  border-left: 1px solid #696868;
}

 .header .top .container .typeList {
  float: right;
}

 .header .top .container .typeList a {  
  text-decoration: none;
  color: #050f99;
  padding: 0 7px;
}

 .header .top .container .typeList a:hover {
  color: hotpink;
}

 .header .top .container .typeList a + a {
  border-left: 1px solid #464444;
}
</style>