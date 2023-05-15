<template>
    <div>
    <el-descriptions class="margin-top" title="" :column="1" :size="size" border>
        <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-user"></i>
        头像
      </template>
      <div class="demo-type" id="myimg">
    <div >
      <img style="border-radius: 50%;" :src="'https://txy6666.oss-cn-guangzhou.aliyuncs.com/images/'+tximage" alt="" width="48px">
    </div>
  </div>
  <!-- <el-upload
  class="upload-demo"
  action="https://jsonplaceholder.typicode.com/posts/"
  :on-preview="handlePreview"
  :on-remove="handleRemove"
  :file-list="fileList"
  list-type="picture">
  <el-button size="small" type="primary">点击上传</el-button>
</el-upload> -->
  
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-user"></i>
        用户名
      </template>
      {{userName}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-mobile-phone"></i>
        邮箱号
      </template>
      {{email}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-tickets"></i>
        备注
      </template>
      <el-tag size="small">{{desc}}</el-tag>
    </el-descriptions-item>

    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-mobile-phone"></i>
        好友数量
      </template>
      {{numofhy}}
    </el-descriptions-item>

    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-tickets"></i>
        注册时间
      </template>
      <el-tag size="small">{{zhuceTime }}</el-tag>
    </el-descriptions-item>

  </el-descriptions>
  <br>
  <br>

  <el-row :gutter="20">
    <el-col :span="24">
      <el-divider content-position="center"><div style="font-size: 25px;">统计图表</div></el-divider>
        <el-row :gutter="20">
            <el-col :span="12">
              <div class="block">
    <el-date-picker
      v-model="yfvalue"
      type="month"
      placeholder="选择月">
    </el-date-picker>
    <el-button type="primary" plain @click="kscx">查询</el-button>
  </div>
  
          <e-charts class="chart"
                :option="option1"
                
                >
          </e-charts>
        </el-col>
            <el-col :span="12">
              <div class="block">
                <el-date-picker
                  v-model="yfvalue2"
                  type="month"
                  placeholder="选择月"
                  >
                </el-date-picker>
                <el-button type="primary" plain @click="kscx">查询</el-button>
              </div>




              <e-charts class="chart"
                :option="option2"
                
                >
          </e-charts>
            
            </el-col>
          </el-row>

          <!-- <el-row :gutter="20">
            <el-col :span="12">
              <e-charts class="chart"
                :option="option1"
                
                >
          </e-charts>
            
            </el-col>
            <el-col :span="12">
              <e-charts class="chart"
                :option="option1"
                
                >
          </e-charts>
          </el-col>
</el-row>  -->
    </el-col>
  </el-row>


</div>
</template>

<style scoped>
#yhxxb{
    position: absolute;
    width: 400;
    height: 800;
    top: 20%;
    left: 20%;
    border-radius: 15px;
}
</style>

<script>
  export default {
    data() {
      return {
          userName: '',
          email:'',
          zhuceTime:'',
          numofhy:'',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: '',
          tximage:'',
          datadlxx:[],
          xffs:'本月登录情况',
          yfvalue:new Date(),
          xrbt:new Date().getFullYear()+'年'+(new Date().getMonth()+1),
          yfvalue2:new Date(),
          xrbt2:new Date().getFullYear()+'年'+(new Date().getMonth()+1),



      }
    },
    computed:{
      option1(){
            return{
                title:{
                  text: this.xrbt+'月个人登录次数情况',
                  left: 'center'
                },
                xAxis: {
                    type: 'category',
                    data: this.datadlxx.map(d=>d.logintime.split("T")[0])
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                    data: this.datadlxx.map(d=>d.dlcs),
                    type: 'line',
                    // areaStyle: {}
                    }
                ]
            }
            }
      ,
  option2(){
    return{
      title:{
                  text: this.xrbt2+'月好友聊天次数top4',
                  left: 'center'
                },
    tooltip: {
    trigger: 'item'
  },
  legend: {
    top: '90%',
    left: 'center'
  },
  
  series: [
    {
      name: 'Access From',
      type: 'pie',
      radius: ['40%', '70%'],
      avoidLabelOverlap: false,
      itemStyle: {
        borderRadius: 10,
        borderColor: '#fff',
        borderWidth: 2
      },
      label: {
        show: false,
        position: 'center'
      },
      
      emphasis: {
        label: {
          show: true,
          fontSize: 30,
          fontWeight: 'bold'
        }
      },
      labelLine: {
        show: false
      },
      
      data: [
        { value: 105, name: 'xxxx' },
        { value: 50, name: 'yyyy' },
        { value: 30, name: '躺洋洋' },
        { value: 10, name: 'tangxiyang' },
      ]
    }
  ]
      }
    }
    },
    mounted(){
      this.cxgrxx()
      this.cxdlxx()
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      },
      qffh:function(e){
                this.$router.push("/menu");
            },
      cxgrxx:function(e){
        this.$axios({
                url: "http://localhost:8090/Permsg/find",
                method: "post",
                data: {
                    username:localStorage.getItem("userName")
                },
                })
                    .then((res) => {
                      console.log(res.data.data)
                      this.userName=res.data.data.username,
                      this.email=res.data.data.email,
                      this.zhuceTime=res.data.data.zhucetime,
                      this.numofhy=res.data.data.numofhy,
                      this.desc=res.data.data.mydescribe,
                      this.tximage=res.data.data.image
                      console.log(this.tximage)
                })
                    .catch((err) => {
                    console.log(err);
                });
            },
      cxdlxx:function(e){
        this.$axios({
                url: "http://localhost:8090/Permsg/finddlxxsj",
                method: "post",
                data: {
                    username:localStorage.getItem("userName"),
                    "nianyuefen":this.yfvalue.getFullYear()+'-'+(this.yfvalue.getMonth()+1)
                },
                })
                    .then((res) => {
                      console.log(res.data.data)
                      this.datadlxx=res.data.data

                })
                    .catch((err) => {
                    console.log(err);
                });
            },

        kscx:function(e){
          this.cxdlxx()
          this.xrbt=this.yfvalue.getFullYear()+'年'+(this.yfvalue.getMonth()+1)
        }
      
    }
  }
</script>

<style scoped>
.chart{
    height: 400px;
}
.el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
    font-size: 18px;
  }
  .el-icon-arrow-down {
    font-size: 19px;
  }
  
</style>
