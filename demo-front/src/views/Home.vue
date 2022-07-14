<template>
  <div id="p1">

    <el-container style="height: 100%; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="['1', '2']">
          <el-submenu index="1">
<!--              路由跳转、实际上就是<a href>标签形势因此通过css简单修饰-->
            <template slot="title"><i class="el-icon-eleme"></i><router-link to="/operateLog">接口日志查询</router-link></template>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-box"></i><router-link to="/">图书服务查询</router-link></template>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header>
          <h3>简单的前后端分离demo项目</h3>
        </el-header>
        <el-main>
          <Book></Book>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>


<script>
import Book from '../component/Book'
export default {
  name: "home",
  components:{
    Book
  },
  data() {
    return {
    }
    }
}
</script>

<style scoped>
#p1{
  position: absolute;
  height: 100%;
  width: 100%;
}
*{
  margin: 0;
  padding: 0;
}
a{
  text-decoration:none;
  font-family: "Times New Roman";
  color: black;
}
a:hover{
  color: pink;
}
</style>