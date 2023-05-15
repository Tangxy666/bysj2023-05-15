<template>
  <div>
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="天气" name="first">
        <div>
          
          <el-row :gutter="20">

            <el-col :span="15" :offset="6">
              <br>
              <br>
              <div
                style="
                  width: 800px;
                  height: 700px;
                  border: 1px solid black;
                  border-radius: 5px;
                "
              >
              
                <el-row :gutter="20">

                  <el-col :span="15" :offset="1">
                    <br />

                    <div
                      style="
                        color: #252525;
                        display: block;
                        float: left;
                        font-size: 25px;
                        height: 40px;
                        overflow: hidden;
                        white-space: nowrap;
                        text-overflow: ellipsis;
                        max-width: 100px;
                      "
                    >
                      <i class="el-icon-location-outline"></i>{{city}}
                    </div>
                    <template>
                      <el-button type="text" @click="open" ><div class="zyan"></div></el-button>
                    </template>
                  </el-col>
                  <el-col :span="4" :offset="0">
                    <div
                      style="
                        width: 100%;
                        height: 20px;
                        line-height: 20px;
                        text-align: right;
                        font-size: 18px;
                        color: #7d7d7d;
                        margin-top: 5px;
                      "
                    >
                      <br />{{reporttime}}更新
                    </div>
                  </el-col>
                </el-row>
                  <el-row :gutter="20">

                    <el-col :span="6" :offset="2">
                      <div
                        style="
                          width: 200px;
                          height: 100px;
                          font-size: 80px;
                          color: #043567;
                          float: none;
                          text-align: right;
                        "
                      >
                        {{ temperature }}
                      </div>

                      <!-- <div class="grid-content bg-purple"></div> -->
                    </el-col>
                    <el-col :span="2" :offset="0">
                      <!-- <div style="width: 200px;height: 100px; border: 1px solid black;"></div>
                             -->
                      <div
                        style="
                          font-size: 45px;
                          color: #043567;
                          float: none;
                        "
                      >
                        ℃
                      </div>
                    </el-col>
                    <el-col :span="14" :offset="2">
                      <el-row :gutter="14">
                        <el-col :span="4">
                          <div
                            style="
                              text-align: right;
                              font-size: 16px;
                            "
                          >
                            <i class="el-icon-wind-power"></i>
                          </div>
                        </el-col>
                        <el-col :span="4">
                          <div
                            style="
                              text-align: center;
                              font-size: 16px;
                            "
                          >
                            {{ winddirection }}风
                          </div>
                        </el-col>
                        <el-col :span="4">
                          <div
                            style="
                              text-align: left;
                              font-size: 16px;
                            "
                          >
                            {{ windpower }}级
                          </div>
                        </el-col>
                      </el-row>
                      <el-row :gutter="14">
                        <el-col :span="4">
                          <div
                            style="
                              text-align: right;
                              font-size: 16px;
                            "
                          >
                            <img style="width: 13px;" src="@/components/images/blur.png">
                          </div>
                        </el-col>
                        <el-col :span="4">
                          <div
                            style="
                              text-align: center;
                              font-size: 16px;
                            "
                          >
                            空气湿度
                          </div>
                        </el-col>
                        <el-col :span="4">
                          <div
                            style="
                              text-align: left;
                              font-size: 16px;
                            "
                          >
                            {{ humidity }}%
                          </div>
                        </el-col>
                      </el-row>
                    </el-col>
                </el-row>

                <el-divider></el-divider>

                <el-row :gutter="20">
                  <el-col
                    :span="4"
                    :offset="2"
                    v-for="(item, index) in tqdata"
                    :key="index"
                    ><div>{{ zidian[tqdata[index].week] }}</div>
                    <br>



                    <div>{{tqdata[index].dayweather}}</div>
                    <br>
                    <div
                            style="
                              font-size: 35px;
                            "
                          >
                          <i :class="dytp[tqdata[index].dayweather]"></i>
                    </div>
                    </el-col>
                    <el-col
                    :span="20"
                    :offset="0">
                    <div>
                        <e-charts class="chart"
                        :option="option"
                        >
                        </e-charts>
                    </div>
                  </el-col>
                  <el-col
                    :span="20"
                    :offset="0">
                    <div>
                        <e-charts class="chart"
                        :option="option1"
                        >
                        </e-charts>
                    </div>
                  </el-col>
                  <el-col
                    :span="4"
                    :offset="2"
                    v-for="(item, index) in tqdata"
                    :key="index"
                    >
                    <div>{{tqdata[index].nightweather}}</div>
                    <br>
                    <div
                            style="
                              font-size: 35px;
                            "
                          >
                          <i :class="dytp[tqdata[index].nightweather]"></i>
                    </div>
                    </el-col>
                </el-row>
              </div>
            </el-col>
          </el-row>
        </div>
      </el-tab-pane>
      <el-tab-pane label="出行推荐" name="second"> </el-tab-pane>
    </el-tabs>
  </div>
</template>
  <script>
export default {
  data() {
    return {
      zidian: {
        1: "星期一",
        2: "星期二",
        3: "星期三",
        4: "星期四",
        5: "星期五",
        6: "星期六",
        7: "星期日",
      },
      dytp:{
        "中雨":"el-icon-light-rain",
        "小雨":"el-icon-light-rain",
        "阵雨":"el-icon-light-rain",
        "多云":"el-icon-cloudy",
        "阴":"el-icon-partly-cloudy",
        "晴":"el-icon-sunny",
        "大雨":"el-icon-heavy-rain",
      },
      city: "湛江市",
      tqdata: [],
      shishitqdata: "",
      temperature: "",
      winddirection: "",
      windpower: "",
      humidity: "",
      reporttime:"",
      zxbtime:[1,2,3,4
            ],
      zxbwd:[
            ],
      zxwdws:[

      ],

    };
  },
  computed:{
        option(){
            return{
              grid: {
                    x: -20, // 距离左边
                    x2: -20, // 距离右边
                    y: 20, // 距离上边
                    y2: 0 // 距离下边
                  },
                xAxis: {
                    show:false, 
                    type: 'category',
                    data: this.zxbtime,
                },
                yAxis: {
                    show:false, 
                    type: 'value',
                },
                series: [
                    {
                    symbolSize: 2,
                    data: this.zxbwd,
                    type: 'line',
                    lineStyle: {
                  color: "#FFA500", //改变折线颜色
                },
                    label: {
                        show: true,
                        formatter: '{c}' + '℃'
                    },
                    }
                ]
            }
            },
            option1(){
            return{
              grid: {
                    x: -20, // 距离左边
                    x2: -20, // 距离右边
                    y: 20, // 距离上边
                    y2: 0 // 距离下边
                  },
                xAxis: {
                    show:false, 
                    type: 'category',
                    data: this.zxbtime,
                },
                yAxis: {
                    show:false, 
                    type: 'value',
                },
                series: [
                    {
                    symbolSize: 2,
                    data: this.zxwdws,
                    type: 'line',
                    label: {
                        show: true,
                        formatter: '{c}' + '℃'
                    },
                    }
                ]
            }
            }

        },
  mounted() {
    this.fsqqhqtq();
    this.fsqqhqsstq();
  },
  methods: {
    open() {
        this.$prompt('请输入城市', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({ value }) => {
          this.$message({
            type: 'success',
            message: '你输入城市是: ' + value
          });
          this.city=value
          this.fsqqhqsstq()
          this.fsqqhqtq();

        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });       
        });
      },
    handleClick(tab, event) {},
    fsqqhqtq: function (e) {
      this.$axios({
        url: "http://localhost:8090/tianqi/findtianqi",
        method: "post",
        data: {
          city: this.city,
          
        },
      })
        .then((res) => {
          if (res.data.code !== 200) {
            alert("账号或密码输入错误！");
          } else {
            this.tqdata = res.data.data.forecasts[0].casts;
            this.zxbwd=[
                    this.tqdata[0].daytemp,
                    this.tqdata[1].daytemp,
                    this.tqdata[2].daytemp,
                    this.tqdata[3].daytemp,
            ]
            this.zxwdws=[
                    this.tqdata[0].nighttemp,
                    this.tqdata[1].nighttemp,
                    this.tqdata[2].nighttemp,
                    this.tqdata[3].nighttemp,
            ]
            console.log(this.tqdata);
            console.log(this.zxbdata);
            // console.log();
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    fsqqhqsstq: function (e) {
      this.$axios({
        url: "http://localhost:8090/tianqi/findtianqishishi",
        method: "post",
        data: {
          city: this.city,
        },
      })
        .then((res) => {
          if (res.data.code !== 200) {
            alert("账号或密码输入错误！");
          } else {
            this.shishitqdata = res.data.data.lives[0];
            console.log(this.shishitqdata);
            this.temperature = this.shishitqdata.temperature;
            this.winddirection = this.shishitqdata.winddirection;
            this.windpower = this.shishitqdata.windpower;
            this.humidity = this.shishitqdata.humidity;
            this.reporttime=this.shishitqdata.reporttime.split(" ")[1];
            console.log(this.reporttime)
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style>
.zyan {
  display: block;
  width: 35px;
  height: 20px;
  background: url("https://i.tq121.com.cn/i/weather2017/selectCityBtn.png")
    no-repeat;
  float: left;
  margin-top: 18px;
  margin-left: 5px;
}
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
.chart{
    height: 100px;
    width:800px
}
</style>