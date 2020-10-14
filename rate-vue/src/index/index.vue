<template>
    <div>
        <van-cell-group>
            <van-cell title="项目" value="毕业答辩" />
            <van-cell title="被评价者" value="张三" />
        </van-cell-group>
        <van-row gutter="100" type="flex" justify="center">
            <van-col>
                <van-rate v-model="rateValue" :count="10" @change="rateChange"/>
            </van-col>
        </van-row>
        <van-row gutter="20" type="flex" justify="center">
            <van-col>
            <van-stepper v-model="stepperValue" @change="stepperChange" min="0" max="100" integer/>
            </van-col>
        </van-row>
        <van-row gutter="20" type="flex" justify="center">
            <van-button type="primary" @click="submit">提交</van-button>
        </van-row>
        <van-tabbar v-model="active">
            <van-tabbar-item icon="home-o">创建</van-tabbar-item>
            <van-tabbar-item icon="friends-o">评分</van-tabbar-item>
            <van-tabbar-item icon="setting-o">统计</van-tabbar-item>
        </van-tabbar>
    </div>
</template>

<script>
import Vue from 'vue'
import { Dialog } from 'vant'

export default Vue.extend({
  name: 'Index',
  data() {
    return {
      projectId: 0,
      rateValue: 0,
      stepperValue: 0,
      judge: 'admin',
      actor: 'admin',
      active: 0
    }
  },
  created() {
  },
  methods: {
    rateChange(rate) {
      this.stepperValue = rate * 10
    },
    stepperChange(stepper) {
      this.rateValue = stepper / 10
    },
    submit() {
      this.$axios.post('/api/grade/add', {
        scores: this.stepperValue,
        judge: this.judge,
        actor: this.actor,
        projectId: this.projectId,
      }).then((resp) => {
        if (resp.data.status === false) {
          Dialog.alert({
            title: '错误',
            message: resp.data.reason,
          }).then(() => {
            // on close
          })
        }
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
