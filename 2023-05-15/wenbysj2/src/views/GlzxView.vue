<template>
    <div>
        <e-charts class="chart"
        :option="option"
        
        >

        </e-charts>
    </div>
</template>


<script>
export default {
    data(){
        return {
            data:[
                {
                    time:'2018-01-01',
                    value:Math.random()*100
                },
                {
                    time:'2018-01-01',
                    value:Math.random()*100
                },
                {
                    time:'2018-01-01',
                    value:Math.random()*100
                },
                {
                    time:'2018-01-01',
                    value:Math.random()*100
                }
            ],
        }

    },
    computed:{
        option(){
            return{
                xAxis: {
                    show:false, 
                    type: 'category',
                    data: this.data.map(d=>d.time),
                },
                yAxis: {
                    show:false, 
                    type: 'value',
                },
                series: [
                    {
                    data: this.data.map(d=>d.value),
                    type: 'line',
                    areaStyle: {},
                    label: {
                        show: true,
                    },
                    }
                ]
            }
            }
        }
    }
</script>

<style scoped>
.chart{
    height: 400px;
}
</style>
