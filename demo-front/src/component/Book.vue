<template>
  <div>
    <el-input v-model='queryParam' placeholder="请输入内容" style="width: 250px"></el-input>
    <el-button type="primary" @click="get(queryParam)">查询</el-button>
<!--    数据现实内容-->
    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="bookName"
          label="书名"
          width="180">
      </el-table-column>
      <el-table-column
          prop="bookAuthor"
          label="作者"
          width="180">
      </el-table-column>
      <el-table-column
          prop="bookCatagory"
          label="分类"
          width="180">
      </el-table-column>
      <el-table-column
          prop="description"
          label="简述">
      </el-table-column>
      <el-table-column
          prop="createTimeStamp"
          label="上架时间">
      </el-table-column>
      <el-table-column
          label="操作">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="del(tableData[scope.$index].id)">删除</el-button>
          <!--          todo 编辑-->
          <el-button link type="primary" size="small" @click="(dialogFormEdit=true,detail(tableData[scope.$index].id))">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
<!--    添加新图书绑定dialog事件-->
    <el-button class="mt-4" style="width: 100%" @click="dialogFormVisible=true">添加新图书</el-button>
<!--    新增图书信息-->
    <el-dialog title="书籍信息" :visible.sync="dialogFormVisible" @close="createBook">
      <el-form :model="book">
        <el-form-item label="书籍名称" :label-width="book.bookName">
          <el-input v-model="book.bookName" placeholder="请填写书籍名称" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="作者名称" :label-width="book.bookAuthor">
          <el-input v-model="book.bookAuthor" placeholder="请填写作者名称" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="书籍分类" :label-width="book.bookCatagory">
          <el-input v-model="book.bookCatagory" placeholder='请填写书籍所属分类' autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="书籍简介" :label-width="book.description">
          <el-input v-model="book.description" placeholder= '输入书籍简介内容' autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="上架时间" :label-width="book.createTimeStamp">
          <el-date-picker type="datetime" placeholder="选择日期" v-model="book.createTimeStamp" style="width: 100%;" format="yyyy-MM-dd HH:mm:ss" value-format="yyyy-MM-dd HH:mm:ss">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save(book)">确 定</el-button>
      </div>
    </el-dialog>
    <el-dialog title="编辑信息" :visible.sync="dialogFormEdit">
      <el-form :model="book">
        <el-form-item label="书籍名称" :label-width="book.bookName">
          <el-input v-model="book.bookName"  placeholder="请填写书籍名称" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="作者名称" :label-width="book.bookAuthor">
          <el-input v-model="book.bookAuthor" placeholder="请填写作者名称" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="书籍分类" :label-width="book.bookCatagory">
          <el-input v-model="book.bookCatagory" placeholder='请填写书籍所属分类' autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="书籍简介" :label-width="book.description">
          <el-input v-model="book.description" placeholder= '输入书籍简介内容' autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="上架时间" :label-width="book.createTimeStamp">
          <el-date-picker type="datetime" placeholder="选择日期" v-model="book.createTimeStamp" style="width: 100%;" format="yyyy-MM-dd HH:mm:ss" value-format="yyyy-MM-dd HH:mm:ss">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormEdit = false">取 消</el-button>
        <el-button type="primary" @click="save(book)">更新</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
//引入crud的api
import {bookList,saveBook,delBook,getDetail} from '../api/book'

export default {
  name: "Book",
  data(){
    return{
      //控制书籍编辑内容
      dialogFormEdit: false,
      //控制dialog显示
      dialogFormVisible:false,
      //查询参数与button绑定
      queryParam:'',
      //表单数据展示
      tableData:[],
      //书籍详细信息
      book:{
        id:'',
        bookName:'',
        bookAuthor:'',
        bookCatagory:'',
        description:'',
        createTimeStamp:'',
      }
    }
  },
  methods:{
    //表单新增
    createBook(){
      this.book={
        id:'',
        bookName:'',
        bookAuthor:'',
        bookCatagory:'',
        description:'',
        createTimeStamp:'',
      }
    },
    //CRUD接口
    get:function (queryParam){
      bookList(queryParam).then(res=>{
        console.log("all"+res.data)
        if(res.data.code===200){
          this.tableData=res.data.data;
          console.log(this.tableData)
          return res.data.data;
        }else{
          return "not exit"
        }
      })
    },
    del:function (id){
      delBook(id).then(res=>{
        console.log(res.data);
        alert("删除成功")
        //todo 待优化
        this.tableData = this.get();
      },)
    },
    save:function (book){
      saveBook(book).then(res=>{
        console.log(res.data);
        this.dialogFormVisible=false
        this.dialogFormEdit=false
        //todo 待优化
        this.tableData = this.get();
      })
    },
    detail:function (id){
      getDetail(id).then(res=>{
          console.log(res.data.data);
          this.book=res.data.data;
      })
    }
  },
  //渲染html显示
  created() {
    show:{bookList().then(res=>{
      this.tableData=res.data.data;
    })
  }
  },}
</script>

<style scoped>

</style>