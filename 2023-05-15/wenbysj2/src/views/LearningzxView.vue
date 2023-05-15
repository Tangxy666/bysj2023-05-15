<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="12" :offset="4">
              <el-col :span="16" :offset="1">
                <div v-if="videourl===''" style="
                    line-height: 36px;
                    font-size: 26px;
                    color: #131B26;
                    font-weight: 500;
                    text-align: left;
                    overflow: hidden;">
                  请点击右方知识点
                </div>
                <div style="
                    line-height: 36px;
                    font-size: 26px;
                    color: #131B26;
                    font-weight: 500;
                    text-align: left;
                    overflow: hidden;">{{ spbq }}
                </div>
              </el-col>

              <el-col :span="16" :offset="1">
                <div>
                    <video style="width: 1000;height: 500px;" v-if="videourl!==''" controls :src="require('../components/videos/'+videourl)"></video>
                </div>
              </el-col>




            </el-col>

            <el-col :span="6" :offset="0">
                <el-row class="tac">
                <el-col :span="24">
                    <el-menu
                    default-active="2"
                    class="el-menu-vertical-demo"
                    background-color="#F2F6FC">
                    <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
                    </el-menu>
                </el-col>
                </el-row>
            
            </el-col>
</el-row>
    </div>
</template>

<style>
  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>

<script>
  export default {
    data() {
      return {
        data: [],
        defaultProps: {
          children: 'children',
          label: 'label'
        },
        videourl:'',
        spbq:'',


      };
    },
    mounted(){
      this.hqxxsx();
    }
    ,
    methods: {
      handleNodeClick(data) {
         if(data.children.length===0){
            this.videourl=data.videourl
            // console.log(this.videourl)
            console.log(data)
            let fgh=data.videourl.split("/")
            console.log(fgh)
            this.spbq=fgh[fgh.length-2]
            let files =new File([""], this.videourl); 
            let url = window.webkitURL.createObjectURL(files) ;
            this.$refs.videoDom.src = url;

        }
        
      },
      hqxxsx:function(e){
      this.$axios({
                url: "http://localhost:8090/LearningVideo/videofindALL",
                method: "get",
                data: {
                },
            })
            .then((res) => {
            if(res.data.code!==200){
              alert("账号或密码输入错误！");
            }
            else{
                this.data=res.data.data
                console.log(res);
                console.log(res.data);
            }
          })
            .catch((err) => {
                console.log(err);
            });
    },
    chooseLocaleFile(file){
    let files = document.getElementById("chooseFile").files[0];
    console.log(files)
    let url = window.webkitURL.createObjectURL(files) ;
    console.log()
    this.$refs.videoDom.src = url;
    }

    }
  };
</script>