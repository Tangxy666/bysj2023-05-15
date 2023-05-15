<template>
    <div id="background">
      <div id="logo">基于SpringBoot的汽车交易交流系统</div>
      <div id="mylogin">
        <el-card class="box-card">
          <div id="form">
            <el-input v-model="userName" placeholder="请输入账号"></el-input>
            <el-input placeholder="请输入密码" v-model="password" show-password></el-input>

            <el-input placeholder="请输入邮箱" v-model="email"></el-input>
            <el-button type="primary" v-on:click="fsyzm" id="fsyzm">发送邮箱验证码</el-button>
            <el-input placeholder="请输入邮箱验证码" v-model="emailyzm"></el-input>
            <el-button type="primary" v-on:click="zhuci" id="zhuci">注册</el-button>
          </div>
  
        </el-card>
      </div>
      <div id="clock">
        <div id="date">{{date}}</div>
        <div id="time">{{time}}</div>
      </div>
  
      <div id="copyright">Copyright © 2023 广东海洋大学 唐禧洋</div>
    </div>
    
  </template>
  
  <style scoped>
  /* #background{
    position: fixed;
    height: 100%;
    width: 100%;
    top: 0;
    left: 0;
    background-image: linear-gradient(
      90deg,
      cyan,
      purple
    );
    background-size: 400%;
    animation: myanimation 10s infinite;
  }
  @keyframes myanimation {
    0%{
      background-position: 0% 50%;
    }
    50%{
      background-position: 100% 50%;
    }
    100%{
      background-position: 0% 50%;
    }
  } */
  #background{
  width: 100vw;
  height: 100vh;
  background: url("https://txy6666.oss-cn-guangzhou.aliyuncs.com/images/gdou.jpg") no-repeat center;
  background-attachment: fixed;
  background-size: cover;
}
  #logo{
    color: aliceblue;
    font-size: 25px;
    font-weight: 800;
    text-transform: uppercase;
    position: absolute;
    top: 10%;
    left: 10%;
  }
  #mylogin{
    position: absolute;
    top: 20%;
    left: 38%;
  }
  .el-card{
    width: 500px;
    height: 430px;
    background-color: rgba(255,255,2555,0.4);
    border-radius: 15px;
  }
  #form{
    line-height: 60px;
    padding-left: 15px;
    padding-right: 15px;
  
  }
  
  #clock{
    color:aliceblue;
    position: absolute;
    top: 70%;
    left: 10%;
    text-align: left;
  }

  #imageyzm{
    width: 35%;
  }
  
  #time{
    font-size: 100px;
  }
  
  #date{
    font-size: 35px;
  }
  
  #copyright{
    color:aliceblue;
    position: absolute;
    top:95%;
    left: 43%;
  }

  
  
  </style>
  
  <script>

  export default {
    data() {
        return {
            userName: "",
            password: "",
            time: "",
            date: "",
            yzm: "",
            email: "",
            emailyzm:"",
        };
    },
    mounted() {
        this.$nextTick(() => {
            setInterval(this.update_clock, 1000);
        });
    },
    methods: {
        update_clock: function (e) {
            var d = new Date();
            var year = d.getFullYear();
            var month = d.getMonth();
            var day = d.getDate();
            var hour = d.getHours();
            var minute = d.getMinutes();
            if (month < 10) {
                month = "0" + month;
            }
            if (day < 10) {
                day = "0" + day;
            }
            this.time = hour + ":" + minute;
            this.date = year + "/" + month + "/" + day;
        },
        fsyzm:function (e) {
            this.$axios({
                url: "http://localhost:8090/loginRegister/sendmail",
                method: "post",
                data: {
                    userName:this.userName,
                    email:this.email
                },
            })
                .then((res) => {
                alert("发送验证码成功！");
            })
                .catch((err) => {
                console.log(err);
            });
        },

        zhuci:function (e) {
            this.$axios({
                url: "http://localhost:8090/loginRegister/zhuceLoginUser",
                method: "post",
                data: {
                    userName:this.userName,
                    password:this.password,
                    code:this.emailyzm,
                    email:this.email
                },
            })
                .then((res) => {

              if(res.data.code!==200){
                alert(res.data.message);
              }
              else{
                alert("注册成功");
                this.$router.push("/");
              }
            })
                .catch((err) => {
                console.log(err);
            });
        }

    },
}
  </script>