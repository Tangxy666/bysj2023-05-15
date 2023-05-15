<template>
<div>
<el-form :inline="true" :model="formInline" class="demo-form-inline">
  <el-form-item label="品牌名">
    <el-input v-model="formInline.user" placeholder=""></el-input>
  </el-form-item>

  <el-form-item label="地区">
    <el-input v-model="formInline.address" placeholder=""></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">查询</el-button>
  </el-form-item>
</el-form>

<el-row :gutter="3">
  <el-col :span="6" v-for="item in data" :key="item">
    <el-card shadow="hover">
      <a href="www.baidu.com">
      <img :src=item.carmapaddress class="image">
      </a>
      <div style="padding: 14px;">
        <span>
          {{item.vehiclemodel}}<br>
          <span style="color:silver; font-size: 14px;">{{item.carcondition}}</span><br>
          <span style="color:red;font-size: 20px;">{{item.pricecar}}&nbsp;&nbsp;</span>
          原价：<span style="text-decoration: line-through"> {{item.originalprice}}</span>
        </span>&nbsp;&nbsp;&nbsp;
        <button style="width: 80px;height: 30px;">购买</button>
      </div>


    </el-card>
  </el-col>
</el-row>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="block">
    <el-pagination style="text-align: center;"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page.sync="currentPage3"
      :page-size="4"
      layout="prev, pager, next, jumper"
      :total=allcar>
    </el-pagination>
</div>




</div>


</template>


<style scoped>
#fy{
  margin: auto;
}
</style>



<script>


export default {
    name: 'demo',
    components:{
    },
    data () {
        return {
        formInline: {
          user: '',
          address: '',
        },
        data:[],
        allcar: '',
        vehiclemodel:'',
        address:'',
        }
    },
    mounted(){
      this.$axios({
                url: "http://localhost:8090/Car/carfindALL",
                method: "post",
                data: {
                  vehiclemodel: this.vehiclemodel,
                  pagenew: 1,
                  address:this.address,
                },
            })
                .then((res) => {
                  console.log(res.data.data[0])
                  this.data=res.data.data
                  this.allcar=parseInt(res.data.message)
            })
                .catch((err) => {
                console.log(err);
            });
    },
    methods: {
      onSubmit() {
        console.log('submit!');
        this.vehiclemodel=this.formInline.user
        console.log(this.vehiclemodel);
        this.address=this.formInline.address
        this.$axios({
                url: "http://localhost:8090/Car/carfindALL",
                method: "post",
                data: {
                  vehiclemodel: this.vehiclemodel,
                  address:this.address,
                  pagenew: 1,
                },
            })
                .then((res) => {
                  console.log(res.data.data[0])
                  this.data=res.data.data
                  this.allcar=parseInt(res.data.message)
            })
                .catch((err) => {
                console.log(err);
            });
      },
      handleSizeChange(val) {
        
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        this.$axios({
                url: "http://localhost:8090/Car/carfindALL",
                method: "post",
                data: {
                  vehiclemodel: this.vehiclemodel,
                  address:this.address,
                  pagenew: val,
                },
            })
                .then((res) => {
                  console.log(res.data.data[0])
                  this.data=res.data.data
                  this.allcar=parseInt(res.data.message)
                  console.log(this.allcar)
            })
                .catch((err) => {
                console.log(err);
            });
        console.log(`当前页: ${val}`);
      }
    },
    created:function () {
    }
}
</script>