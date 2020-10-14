<template>
    <div>
        <div id="myChart" style="height: 200px"></div>
    </div>
</template>

<script>
import Vue from 'vue'

export default Vue.extend({
  name: 'Index',
  data() {
    return {
    }
  },
  mounted() {
    this.getByProject()
  },
  methods: {
    getByProject() {
      this.$axios.get('/api/grade/statistics/0').then((resp) => {
        // eslint-disable-next-line global-require
        const echarts = require('echarts')

        // 基于准备好的dom，初始化echarts实例
        const myChart = echarts.init(document.getElementById('myChart'))
        // 绘制图表
        myChart.setOption({
          title: {
            text: 'ECharts 入门示例'
          },
          tooltip: {},
          xAxis: {
            data: ['60分以下', '60-70', '71-80', '81-90', '91-100']
          },
          yAxis: {},
          series: [{
            name: '销量',
            type: 'bar',
            data: resp.data.scores
          }]
        })
      })
    },
  },
})
</script>

<style>
    .van-row{
        margin: 1rem;
    }
</style>
