<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="4" :offset="4">
        <div
          style="font-size: 36px; height: 50px; border-bottom: 5px solid #c00"
        >
          新闻
        </div>
      </el-col>
      <el-col :span="14">
        <div
          style="
            border-bottom: 5px solid #555;
            height: 50px;
            font-size: 18px;
            color: #c00;
            text-align: right;
            line-height: 70px;
          "
        ></div>

      </el-col>
    </el-row>
    <br><br>
    <el-row :gutter="20">

    <el-col :span="24" :offset="4" class="xwwc">
      <el-col :span="10" :offset="0" class="xwleft">
        <el-row>
          <el-col :span="24" :offset="0" class="xclefttop">
            <el-col :span="11" :offset="0" class="xclefttopleft">
              <div style="font-size: 22px">资讯</div>
              <br />
              <div v-for="(item, index) in datazx" :key="index">
                <a
                  :href="'xinwenzhenwen?id='+(index+17)"
                  style="text-decoration: none; color: #000"
                >
                  {{ item.biaoti }}
                </a>
                <br /><br />
              </div>
            </el-col>

            <el-col :span="11" :offset="2" class="xclefttopright">
              <div style="font-size: 22px">&nbsp;</div>
              <br />
              <a :href="'xinwenzhenwen?id='+54">
              <img
                :src=dataxwyt[0].imageurl
                class="image"
              /><span style="position:absolute;left:420px; top:200px; color: #fff;text-indent: 18px;">{{ dataxwyt[0].biaoti }}</span>
            </a>
            </el-col>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="24" :offset="0" class="xcleftdown">
            <el-col :span="11" :offset="0" class="xcleftdownleft">
              <div style="font-size: 22px">评论</div>
              <br />
              <a
                v-for="(item,index) in datapl"
                :key="index"
                :href="'xinwenzhenwen?id='+(index+22)"
                style="text-decoration: none; color: #000"
              >
                {{ item.biaoti }}
                <br><br>
              </a>
            </el-col>

            <el-col :span="11" :offset="2" class="xcleftdownright">
              <a :href="'xinwenzhenwen?id='+55">
              <img
                :src=dataxwyt[1].imageurl
                class="image"
              /><div style="position:absolute;left:420px; top:170px; color: #fff;text-indent: 18px;">{{ dataxwyt[1].biaoti }}</div>
            </a>
            </el-col>
          </el-col>
        </el-row>
      </el-col>

      <el-col :span="6" :offset="1" class="xwright">
        <div>
          <div style="font-size: 22px">热点新闻</div>
          <br />
          <a
            v-for="(item, index) in dataredian"
            :key="index"
            :href="'xinwenzhenwen?id='+(index+27)"
            style="
              font-size: 16px;
              list-style: none;
              color: #000;
              text-decoration: none;
            "
          >
            <h v-if="index<=12"
              style="
                font-size: 16px;
                font-style: italic;
                font-weight: bold;
                margin-right: 10px;
              "
              >{{ index+1 }}</h
            ><h v-if="index<=12" style="color: #666; font-size: 14px">{{ item.biaoti }}</h> <br /><br />
          </a>
        </div>
      </el-col>
    </el-col>
  </el-row>

    <el-row :gutter="20">
      <el-col :span="4" :offset="4">
        <div style="font-size: 22px">人物<br><br></div>
      </el-col>
    </el-row>
    <el-row>
    <el-col :span="20" :offset="4">
      <el-col :span="6" :offset="0">
        <a :href="'xinwenzhenwen?id='+(56)">
        <img
          :src=datarw[0].imageurl />
      </a><div style="position:absolute;left:315px; top:200px; color: #fff;text-indent: 18px;">{{datarw[0].biaoti}}</div>
      </el-col>

      <el-col :span="6" :offset="0">
        <a :href="'xinwenzhenwen?id='+(57)">
        <img
        :src=datarw[1].imageurl />
        <div style="position:absolute;left:720px; top:200px; color: #fff;text-indent: 18px;"> {{datarw[1].biaoti}}</div>
      </a>

      </el-col>
      <el-col :span="6" :offset="0">
        <a :href="'xinwenzhenwen?id='+(58)">
        <img
        :src=datarw[2].imageurl />
        <div style="position:absolute;left:1100px; top:200px; color: #fff;text-indent: 18px;list-style: none;"> {{ datarw[2].biaoti }}</div>
        
      </a>
        <br><br><br><br>
      </el-col>
    </el-col>
  </el-row>

    <el-row :gutter="20"> 

      <el-col :span="4" :offset="4">
        
        <div
          style="font-size: 36px; height: 50px; border-bottom: 5px solid #c00"
        >
          新车
        </div>
      </el-col>
      <el-col :span="14">
        <div
          style="
            border-bottom: 5px solid #555;
            height: 50px;
            font-size: 18px;
            color: #c00;
            text-align: right;
            line-height: 70px;
          "
        ></div>
      </el-col>
    </el-row>
    <el-row :gutter="20">
    <el-col :span="24" :offset="4" class="xcwmc">
      <el-col :span="10" :offset="0" class="xcleft">
        <el-row>
          <el-col :span="24" :offset="0" class="xclefttop">

            <el-col :span="11" :offset="0" class="xclefttopleft">
              <!-- <div class="grid-content bg-purple"> -->
              <div style="font-size: 22px"><br>国内</div>
              <br />
              <a :href="'xinwenzhenwen?id='+(49)" >
                <img
                  :src=datagn[0].imageurl
                  class="image"
                />                
                <div style="position:absolute;left:0px; top:250px; color: #fff;text-indent: 18px;"> {{datagn[0].biaoti}}</div>
              </a>

              <!-- </div> -->
            </el-col>

            <el-col :span="11" :offset="2" class="xclefttopright">
              <!-- <div class="grid-content bg-purple"> -->
              <div style="font-size: 22px"><br>&nbsp;</div>
              <br />
              <a :href="'xinwenzhenwen?id='+(50)" >
                <img
                :src=datagn[1].imageurl
                  class="image"
                /><div style="position:absolute;left:410px; top:240px; color: #fff;text-indent: 18px;"> {{datagn[1].biaoti}}</div>
              </a>
              <!-- </div> -->
            </el-col>

            <el-col :span="11" :offset="0" class="xclefttopleft">
              <!-- <div class="grid-content bg-purple"> -->
              <div style="font-size: 22px"><br>国际</div>

              <br />
              <a :href="'xinwenzhenwen?id='+(51)" >
                <img
                  :src=datagj[0].imageurl
                  class="image"
                />                
                <div style="position:absolute;left:0px; top:550px; color: #fff;text-indent: 18px;"> {{datagj[0].biaoti}}.99万</div>
              </a>

              <!-- </div> -->
            </el-col>

            <el-col :span="11" :offset="2" class="xclefttopright">
              
              <!-- <div class="grid-content bg-purple"> -->
              <div style="font-size: 22px"><br>&nbsp;</div>
              <br />
              <a :href="'xinwenzhenwen?id='+(52)">
                <img
                  :src=datagj[1].imageurl
                  class="image"
                /><div style="position:absolute;left:410px; top:550px; color: #fff;text-indent: 18px;"> {{datagj[1].biaoti}}</div>
              </a>
              <!-- </div> -->
            </el-col>

          </el-col>
        </el-row>
      </el-col>

      <el-col :span="6" :offset="1" class="xcright">
          <el-col :span="18" :offset="0" class="xcrighttop">
          <div>
            <div style="font-size: 22px"><br><br>热点新车</div>
            <br />
            <a
              v-for="(item, index) in datardxc"
              :key="index"
              :href="'xinwenzhenwen?id='+(index+41)"
              style="
                font-size: 16px;
                list-style: none;
                color: #000;
                text-decoration: none;
              "
            >
              <h
                style="
                  font-size: 16px;
                  font-style: italic;
                  font-weight: bold;
                  margin-right: 10px;
                "
                >{{ index }}</h
              ><h style="color: #666; font-size: 14px">{{ item.biaoti }}</h> <br /><br />
            </a>
          </div>
        </el-col>
        <el-col :span="12" :offset="0" class="xcrightdown">
              <!-- <div class="grid-content bg-purple"> -->
              <div style="font-size: 22px">导购</div>
              <a :href="'xinwenzhenwen?id='+(53)" >
                <img style="width: 300px;"
                  :src=datadg[0].imageurl
                  class="image"
                />                
                <div style="position:absolute;left:1210px; top:570px; color: #fff;text-indent: 12px; font-size: 13px;"> {{datadg[0].biaoti}}</div>
              </a>

        </el-col>

      </el-col>
    </el-col>
  </el-row>
  </div>
</template>

<style>
</style>


<script>
export default {
  data() {
    return {
      datazx: [],
      datapl:[],
      dataredian: [
      ],
      datardxc: [
      ],
      datagn:[],
      datagj:[],
      datadg:[],
      datarw:[],
      dataxwyt:[],


    };
  },
  mounted(){
    this.hqxwff("资讯");
    this.hqxwff("评论");
    this.hqxwff("热点新闻");
    this.hqxwff("热点新车");
    this.hqxwff("人物");
    this.hqxwff("国内");
    this.hqxwff("国际");
    this.hqxwff("导购");
    this.hqxwff("新闻");
  },
  methods: {

    hqxwff:function(e){
      this.$axios({
                url: "http://localhost:8090/Hqxw/Findxinwen",
                method: "post",
                data: {
                  "fromwhere":e
                },
            })
            .then((res) => {
            if(res.data.code!==200){
              alert("账号或密码输入错误！");
            }
            else{
              if(e==="资讯"){this.datazx=res.data.data}
              if(e==="评论"){this.datapl=res.data.data}
              if(e==="热点新闻"){this.dataredian=res.data.data}
              if(e==="热点新车"){this.datardxc=res.data.data}
              if(e==="人物"){this.datarw=res.data.data}
              if(e==="国内"){this.datagn=res.data.data}
              if(e==="国际"){this.datagj=res.data.data}
              if(e==="导购"){this.datadg=res.data.data}
              if(e==="新闻"){this.dataxwyt=res.data.data}
              console.log(this.datardxc)
            }
          })
            .catch((err) => {
                console.log(err);
            });
    }

  },

};
</script>
