<template>
    <div class="cnt">
        <van-form @submit="onSubmit">
            <van-field
                    v-model="project_name"
                    name="name"
                    label="项目名"
                    placeholder="项目名"
                    :rules="[{ required: true, message: '请填写项目名' }]"
            />
          <!--  <van-field
                    v-model="rate"
                    name="密码"
                    label="被评价者"
                    placeholder="被评价者"
                    :rules="[{ required: true, message: '请填写被评价者' }]"
            />-->
            <div style="margin: 16px;">
                <van-button round block type="info" native-type="submit">
                    提交
                </van-button>
            </div>
        </van-form>
    </div>
</template>

<script>
import Vue from 'vue'


export default Vue.extend({
  name: 'Create',
  data() {
    return {
      project_name: '',
      // rate: '',
    }
  },
  components: {
  },
  created() {
  },
  methods: {
    onSubmit(values) {
      console.log('submit', values)
      this.$axios.post('/api/project/add', values).then((resp) => {
        console.log(resp)
      })
    },
  },
})
</script>

<style lang="less">
</style>
