<template>
  <div id="background">
    <div id="logo">基于SpringBoot的汽车交易交流系统</div>
    <div id="mylogin">
      <el-card class="box-card">
        <div id="form">
          <el-input v-model="userName" placeholder="请输入账号"></el-input>
          <el-input placeholder="请输入密码" v-model="password" show-password></el-input>
          <el-button type="primary" v-on:click="login" id="dl">登录</el-button>
          <el-button type="primary" v-on:click="zhuci" id="zhuci">注册</el-button>
          <!-- Form -->
          <el-button type="text" @click="dialogFormVisible = true" id="xgmm">修改密码</el-button>

          <el-dialog title="修改密码" :visible.sync="dialogFormVisible">
            <el-form :model="form">
              <el-form-item label="账号" :label-width="formLabelWidth">
                <el-input v-model="form.userName" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="邮箱" :label-width="formLabelWidth">
                <el-input v-model="form.email" autocomplete="off"></el-input>
              </el-form-item>
              <el-button type="primary" v-on:click="fsyxyzm" id="fsyxyzm">发送邮箱验证码</el-button>
              <el-form-item label="邮箱验证码" :label-width="formLabelWidth">
                <el-input v-model="form.emailyzm" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="新密码" :label-width="formLabelWidth">
                <el-input v-model="form.newpassword" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="ksxgmm">确 定</el-button>
            </div>
          </el-dialog>
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

#fsyxyzm{
  position: absolute;
  left: 85%;
  top:37.5%;
}

#xgmm{
  position: absolute;
  left: 70%;
  top:70%;
  color: black;
}

#background{
  width: 100vw;
  height: 100vh;
  background: url("https://txy6666.oss-cn-guangzhou.aliyuncs.com/images/gdou.jpg") no-repeat center;
  background-attachment: fixed;
  background-size: cover;
}

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
  top: 30%;
  left: 38%;
}
.el-card{
  width: 373px;
  height: 210px;
  background-color: rgba(255, 255, 255, .6);
  border-radius: 15px;
}
#form{
  line-height: 60px;
  padding-left: 15px;
  padding-right: 15px;

}
#dl{
  position: absolute;
  top: 70%;
  left: 10%;
}

#zhuci{
  position: absolute;
  top: 70%;
  left: 30%;
}

#wjmm{
  position: absolute;
  top: 70%;
  left: 53%;
}
#clock{
  color:aliceblue;
  position: absolute;
  top: 70%;
  left: 10%;
  text-align: left;
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
  data(){
    return{
      userName:"",
      password:"",
      time:"",
      date:"",
      dialogTableVisible: false,
      dialogFormVisible: false,
        form: {
          userName: '',
          email: '',
          emailyzm:'',
          newpassword:'',
        },
        formLabelWidth: '120px'
    }
  },
  mounted(){
    this.$nextTick(()=>{
      setInterval(this.update_clock,1000);
    })
  },
  methods:{
    update_clock:function(e){
      var d=new Date();
      var year=d.getFullYear();
      var month=d.getMonth();
      var day=d.getDate();
      var hour=d.getHours();
      var minute=d.getMinutes();
      if (hour<10){
        hour="0"+hour;
      }
      if (minute<10){
        minute="0"+minute;
      }
      if (month<10){
        month="0"+month;
      }
      if (day<10){
        day="0"+day;
      }
      this.time=hour+":"+minute;
      this.date=year+"/"+month+"/"+day;
    },
    login:function(e){
      this.$axios({
          url: "http://localhost:8090/loginRegister/login",
          method: "post",
          data: {
            username: this.userName,
            password: this.password,
          },
        })
          .then((res) => {
            if(res.data.code!==200){
              alert("账号或密码输入错误！");
            }
            else{
            console.log(res);
            localStorage.setItem("toke", res.headers.token)
            localStorage.setItem("userName", this.userName)
            console.log(res.data);
            this.$router.push("./menu");
            }
          })
          .catch((err) => {
            console.log(err);
            
          });

    },
    zhuci:function(e){
      this.$router.push("./registration")
    },
    fsyxyzm:function(e){
      this.$axios({
                url: "http://localhost:8090/loginRegister/sendmail",
                method: "post",
                data: {
                    userName:this.form.userName,
                    email:this.form.email
                },
            })
                .then((res) => {
                alert("发送验证码成功！");
            })
                .catch((err) => {
                console.log(err);
            });
    },
    ksxgmm:function(e){
      this.$axios({
                url: "http://localhost:8090/loginRegister/uqdatemima",
                method: "post",
                data: {
                    userName:this.form.userName,
                    email:this.form.email,
                    password:this.form.newpassword,
                    code:this.form.emailyzm,
                },
            })
                .then((res) => {
                alert("修改密码成功！");
                this.dialogFormVisible=false;
            })
                .catch((err) => {
                console.log(err);
            });
    }
  }
}
</script>