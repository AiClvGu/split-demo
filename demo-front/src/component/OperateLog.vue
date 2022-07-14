<template>
  <div>
<!--带复选框的 表格-->
    <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange">
      <el-table-column
          type="selection"
          width="55">
      </el-table-column>
      <el-table-column
          prop="operateUser"
          label="操作用户"
          width="120">
      </el-table-column>
      <el-table-column
          prop="operateIp"
          label="ip地址"
          width="120">
      </el-table-column>
      <el-table-column
          prop="operateMethod"
          label="操作方法"
          width="120">
      </el-table-column>
      <el-table-column
          prop="operateUrl"
          label="地址"
          show-overflow-tooltip>
      </el-table-column>
      <el-table-column
          prop="createtimestamp"
          label="操作时间"
          show-overflow-tooltip>
      </el-table-column>
    </el-table>
    <div style="margin-top: 20px">
      <el-button type="primary" @click="toggleSelection">取消选择</el-button>
      <el-button type="danger" @click="delLog(multipleSelection)">删除选中</el-button>
    </div>
  </div>
</template>

<script>

import { getOperateLog ,delOperateLog } from '../api/operateLog'

export default {
  name: "OperateLog",
  data(){
    return{
      //定义表单数据
      tableData:[],
      //选中数据
      multipleSelection:''
    }
  },
  methods:{
    //定义选中功能
    handleSelectionChange(val){
        //转换为string操作
        this.multipleSelection=val.map(value=>(value.id)).toString();
    },
    //删除日志功能
    delLog(param){
      delOperateLog(param).then(res=>{
        console.log(res);
        //刷新数据刷新表单、
        getOperateLog().then(res=>{
            this.tableData=res.data.data;
            alert("删除成功")
        })
      }).catch(reason => {
        console.log(reason);
      })
    },
    //取消选择事件
    toggleSelection() {
        this.$refs.multipleTable.clearSelection();
    },
  },
  created() {
    getOperateLog().then(res=>{
      // console.log(res.data.data)
      this.tableData=res.data.data;
    })
  }
}
</script>

<style scoped>
a{
  text-decoration:none;
  font-family: "Times New Roman";
  color: black;
}
a:hover{
  color: pink;
}
</style>