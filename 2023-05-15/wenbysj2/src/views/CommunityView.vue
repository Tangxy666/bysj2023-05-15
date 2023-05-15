<template>

  <div>

  <el-row>
  <el-col :span="20" :offset="2" class="zltswc">
    <el-row>
      <el-col :span="6" :offset="0" class="zltsleft">
        <el-col :span="24">
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#FFFFFF">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>我的好友</span>
              </template>
              <el-menu-item-group>
                <el-menu-item v-for="(item, index) in haoyoudata" :key="index" @click="fasonxiaoxi(item.hyusername)" >

                  <div class="block">
                    <el-avatar :size="50"  :src="'https://txy6666.oss-cn-guangzhou.aliyuncs.com/images/'+item.hyimage">
                  </el-avatar>
                  {{ item.hyusername }}
                    <el-badge v-if="hywdxxliang[item.hyusername]!==0" :value=hywdxxliang[item.hyusername] class="item">
                    </el-badge>
                    <button v-if="item.hyusername in haoyousfzxdata" disabled>在线</button>
                    <button v-else disabled>离线</button>

                </div>
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-col>
            </el-col>
      
      <el-col :span="10" :offset="0" class="zltsright">


        <el-row>
          <el-col :span="20" :offset="0" class="zltsrighttop">

            <div style="width: 600px;height: 500px; border: 5%; border: 2px solid black ; overflow: auto; background-color:#DCDFE6 ">
              <div style="text-align: center;" >{{ ltdr }}</div>
              <div v-for="(item, index) in dqltcontext" :key="index">
                <el-row>
                  
                  <div v-if="item.from===myusername && item.to===dqxzdhy">
                    <el-divider content-position="center" style="font-size: 14px;color: #666;">{{ item.fstime }}</el-divider>
                  <el-col :span="2" :offset="0" class="zlstx">
                    
                    <div class="demo-type">
                      <el-avatar :size="50"  :src="'https://txy6666.oss-cn-guangzhou.aliyuncs.com/images/'+item.from+'.jpg'"></el-avatar>
                    </div>
                  </el-col>

                    <el-col :span="10" :offset="0" class="zlsnr">
                      
                      <div >
                        <button style="width: 300px;height: 50px;">{{item.text}}</button>
                      </div>

                    </el-col>
                  </div>

                  <div v-if="item.from===dqxzdhy && item.to===myusername">
                    <el-divider content-position="center" style="font-size: 14px;color: #666;">{{ item.fstime }}</el-divider>
                    <el-col :span="10" :offset="9" class="zlsnr">
                      
                      <div >
                        <button style="width: 300px;height: 50px;">{{item.text}}</button>
                      </div>

                    </el-col>
                  <el-col :span="3" :offset="2" class="zlstx">
                    
                    <div class="demo-type">
                      <el-avatar :size="50"  :src="'https://txy6666.oss-cn-guangzhou.aliyuncs.com/images/'+item.from+'.jpg'"></el-avatar>
                    </div>
                  </el-col>

                  </div>
                    
                  </el-row>


              </div>
            
            </div>


              
          </el-col>

          <el-col :span="20" :offset="0" class="zltsrightdown">
            <div style="width: 600px;height: 150px; border: 5%; border: 2px solid black ;">
              
              <input  v-model="shurudltrn" id="fasondeneiron" style="width: 600px;height: 150px; border: 1px solid black ;">

              <div>
                <el-button type="primary" @click="fasonneiron">发送</el-button>
              </div>

            
            </div>
          </el-col>

        </el-row>
      </el-col>
    </el-row>
    
  
  
  </el-col>




</el-row>

</div>

</template>


<script>
import moment from 'moment'
export default {
  data() {
      return{
        
        username:'',
        haoyoudata:[],
        haoyousfzxdata:{},
        id:0,
        ltdr:'未选择聊天好友',
        shurudltrn:'',
        myusername:'',
        wdxiaoxiliang:1,
        dqltcontext:[],
        dqxzdhy:'',
        hywdxxliang:{},
        ltdmbss:'',
        socket:{},
      }

  },
  mounted()
  {

    this.fwjkhqsj();
    this.init();
  },

  created(){

    
  },

  methods: {
    handleOpen(key, keyPath) {

      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    init() {
      this.myusername=localStorage.getItem("userName");
    
    let socket;
    console.log(this.myusername)
    let username = localStorage.getItem("userName")
    let _this = this;
    if (typeof (WebSocket) == "undefined") {
    console.log("您的浏览器不支持WebSocket");
    } else {
    console.log("您的浏览器支持WebSocket");
    let socketUrl = "ws://localhost:8090/imserver/" + username;
    if (socket != null) {
        socket.close();
        socket = null;
    }
    // 开启一个websocket服务
    socket = new WebSocket(socketUrl);
    this.socket=socket
    //打开事件
    socket.onopen = function () {
        console.log("websocket已打开");
        _this.xsxhqsj();
        console.log("数据读入完成！")
    };
    //  浏览器端收消息，获得从服务端发送过来的文本消息
    socket.onmessage = function (msg) {
        console.log("收到数据====" + msg.data)

        let data = JSON.parse(msg.data)  // 对收到的json数据进行解析， 类似这样的： {"users": [{"username": "zhang"},{ "username": "admin"}]}
        if (data.users) {  // 获取在线人员信息
        _this.users = data.users.filter(user => user.username !== username)  // 获取当前连接的所有用户信息，并且排除自身，自己不会出现在自己的聊天列表里
        console.log("当前在线人员有变化！")
        _this.haoyousfzxdata={}
        for(let i=0;i<_this.users.length;i++){
          _this.haoyousfzxdata[_this.users[i].username]=1
        }
        console.log(_this.haoyousfzxdata)
        // console.log(_this.users)
        // for(let i=0;i<=_this.haoyoudata;i++){
        //   if (! _this.haoyoudata[i].hyusername  in _this.users){
        //     // _this.haoyoudata[i]._this.haoyoudata[i].hyusername=1
        //   }
        //   else{
        //     // _this.haoyoudata[i]._this.haoyoudata[i].hyusername=0
        //   }
        // }


        } else {
            console.log("有新的消息了！")
            // console.log(msg.data)
            let msgdatajson=JSON.parse(msg.data)
            // console.log(msgdatajson)
            // console.log(msgdatajson.from)
            _this.dqltcontext.push(
              {"from":msgdatajson.from,"text":msgdatajson.text,"fstime":new Date(),"to":username
            }
            )
            // console.log(_this.ltdmbss)
            if(_this.ltdmbss!==msgdatajson.from){
              _this.hywdxxliang[msgdatajson.from]+=1;
            }

            console.log(_this.dqltcontext)
            // console.log(_this.hywdxxliang)

        // 如果服务器端发送过来的json数据 不包含 users 这个key，那么发送过来的就是聊天文本json数据
        //  // {"from": "zhang", "text": "hello"}
        if (data.from === _this.chatUser) {

            _this.messages.push(data)
            // 构建消息内容
            _this.createContent(data.from, null, data.text)
        }
        }
    };
    //关闭事件
    socket.onclose = function () {
        console.log("websocket已关闭");
    };
    //发生了错误事件
    socket.onerror = function () {
        console.log("websocket发生了错误");
    }
    }
    }

    ,
    fsqqzltjl:function(e){
      this.$axios({
          url: "http://localhost:8090/Lts/LtsfindLtxingxi",
          method: "post",
          data: {
            ztun: this.myusername,
            dfun: e
          },
        })
          .then((res) => {
            if(res.data.code!==200){
              alert("账号或密码输入错误！");
            }
            else{
            this.dqltcontext=res.data.data;
            console.log(this.dqltcontext);
            }
          })
          .catch((err) => {
            console.log(err);
            
          });
        },
    fwjkhqsj:function(e){
      this.$axios({
          url: "http://localhost:8090/Lts/LtsfindHaoyou",
          method: "post",
          data: {
            username: localStorage.getItem("userName")
          },
        })
          .then((res) => {
            if(res.data.code!==200){
              alert("账号或密码输入错误！");
            }
            else{
            console.log(res);
            console.log(res.data);
            this.haoyoudata=res.data.data;
            console.log(this.haoyoudata);
            for(let i=0; i<this.haoyoudata.length;i++){
              this.hywdxxliang[this.haoyoudata[i]["hyusername"]]=0
              console.log(this.haoyoudata[i]["hyusername"])
              console.log(this.hywdxxliang)
            }
            }
          })
          .catch((err) => {
            console.log(err);
            
          });
    },

    fasonxiaoxi:function(e){
      this.dqxzdhy=e;
      this.ltdr="正在和"+e+"聊天";
      // this.fsqqzltjl(e);
      console.log(this.dqxzdhy)
      console.log(this.dqltcontext)

      this.hywdxxliang[e]=0
      console.log(this.hywdxxliang)
      this.ltdmbss=e



    },
    fasonneiron:function(){
      console.log(this.dqltcontext)
      this.$axios({
          url: "http://localhost:8090/Lts/LtssendMessage",
          method: "post",
          data: {
            
            xxfrom:localStorage.getItem("userName"),
            xxto:this.ltdmbss,
            context:this.shurudltrn
          },
        })
          .then((res) => {
            if(res.data.code!==200){
              alert("发送出错！");
            }
            else{
            }
          })
          .catch((err) => {
            console.log(err);
            
          });


      this.dqltcontext.push(
        {
          "from":localStorage.getItem("userName"),"text":this.shurudltrn,"fstime":new Date(),"to":this.ltdmbss,
        }
      )
      this.shurudltrn=''
      console.log(this.dqltcontext)

    },
    xsxhqsj:function(){
      this.$axios({
          url: "http://localhost:8090/Lts/Ltsxsx",
          method: "post",
          data: {
            xxto:localStorage.getItem("userName"),
          },
        })
          .then((res) => {
            if(res.data.code!==200){
              alert("发送出错！");
            }
            else{
              console.log("新上线！")
              if(res.data.data===null){
                console.log("没有未读消息")
              }
              else{
                console.log("获取数据！")
                for(let i=0;i<res.data.data.length;i++){
                  
                  // console.log(res.data.data[i])
                  // console.log(res.data.data[i]["xxfrom"])
                  // console.log(res.data.data[i]["context"])
                  // console.log(new Date(res.data.data[i]["fstime"]))
                  // console.log(res.data.data[i]["xxto"])

                this.dqltcontext.push(
                    {
                      "from":res.data.data[i]["xxfrom"],"text":res.data.data[i]["context"],"fstime":new Date(res.data.data[i]["fstime"]),"to":res.data.data[i]["xxto"]
                    }
              )
              this.hywdxxliang[res.data.data[i]["xxfrom"]]+=1
              console.log(this.dqltcontext)
              console.log(this.hywdxxliang)
            }
          }
          }
          })
          .catch((err) => {
            console.log(err);
            
          });

    }
  },
  destroyed(){
    this.socket.close();
    this.hywdxxliang={};
    this.dqltcontext=[];


  }

};
</script>