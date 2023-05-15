<template>
    <div>

        <div>
            <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/luntanView' }">文章</el-breadcrumb-item>
        <el-breadcrumb-item> 正文 </el-breadcrumb-item>
        </el-breadcrumb>
        <br>
        <br>
        <br>
        </div>

<el-row :gutter="20">
  <el-col :span="12" :offset="4">

    <div id="xinwenbiaoti" style="font-size: 25px;">{{wenzhan.biaoti}}</div><br>


    <el-divider content-position="left"></el-divider>
    <div style="font-family: '宋体';color: #999;font-size: 12px;margin-bottom: 20px;">发布人：{{ wenzhan.fromwhere }} &nbsp; &nbsp;发布时间:{{ wenzhan.fstime }}</div>
    <div  v-html=wenzhan.zwnr>
    </div>

</el-col>
</el-row>
</div>
    
</template>


<style scope>


</style>

<script>
export default {
  data() {
    return {
      wenzhan:'',
      id:'',
    }
  },
  mounted(){
    this.id = window.location.search.split('=')[1];
    console.log(this.id)
    this.$axios({
                url: "http://localhost:8090/wenzhan/findwenzhanbyid",
                method: "post",
                data: {
                  id:this.id
                },
            })
            .then((res) => {
            if(res.data.code!==200){
              alert("账号或密码输入错误！");
            }
            else{
                this.wenzhan=res.data.data[0]
                console.log(this.wenzhan)
            }
          })
            .catch((err) => {
                console.log(err);
            });

  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    }
  }
};
</script>


      