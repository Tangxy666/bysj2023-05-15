<template>
    <div>
    <el-row :gutter="20">
        <el-col :span="12" :offset="6" class="zwchaha">
            <!-- <div class="grid-content bg-purple"></div> -->
            

            <el-row v-for="(item,index) in wzdata" :key="index" :gutter="20">
              <el-row   :gutter="20">
                <div >
                <el-divider content-position="left"></el-divider>
                <a :href="'wenzhanView?id='+(wzdata[index].id)" style="color: #606266;">
                <el-col  :span="5" class="tpquhaha">
                    <div v-if="wzdata[index].imageurl!==''" class="block" >
                        <el-image :src=wzdata[index].imageurl></el-image>
                    </div>
                    <div v-if="wzdata[index].imageurl===''" class="block" >
                      <img style="width: 100%;height: 100%;" src="@/components/images/wutu.jpg">  
                    </div>
                </el-col>
                
                <el-col :span="18" :offset="0" class="wenziheplquhaha" style="width: 600px; height: 130px;">
                    <el-row :gutter="20">
                        <el-col :span="22"><div>{{wzdata[index].biaoti}}</div><br><br></el-col>
                        <el-col :span="22" style="font-size: 12px;line-height: 18px;height: 36px;overflow: hidden;color: #757575;margin-bottom: 15px;"><div>{{wzdata[index].bfnr}}</div><br><br></el-col>
                        <el-col :span="6" :offset="10"><div style="float: right;color: #999;white-space: nowrap;text-align: right;overflow: hidden;">{{wzdata[index].liulanlian}}浏览量</div></el-col>
                        <el-col :span="6" :offset="2"><div style="float: right;color: #999;white-space: nowrap;text-align: right;overflow: hidden;">{{wzdata[index].dianzanshu}}点赞</div></el-col>
                    </el-row>
                </el-col>
              </a>
              </div>
              </el-row>
                
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
      activeName: 'first',
      imagename: '/gdou.jpg',
      wzdata:'',

    };
  },
  mounted(){
    this.fsqqhqwzsj()
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    fsqqhqwzsj:function(e){
      this.$axios({
          url: "http://localhost:8090/wenzhan/findwenzhan",
          method: "get",
          data: {
          },
        })
          .then((res) => {
            if(res.data.code!==200){
              alert("账号或密码输入错误！");
            }
            else{
            this.wzdata=res.data.data;
            console.log(this.wzdata);
            }
          })
          .catch((err) => {
            console.log(err);
            
          });
    }
  }
};
</script>