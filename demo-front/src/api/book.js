import request from "@/utils/request";


/**
 * 封装增删改差四个api
 * */
export function bookList(param){
    //1.参数的get通过params来提交参数,带上return返回值
    return request.get("book/list",{
        params:{
            bookName:param
        }
    });
}

export function delBook(param){
    //3、restful配合后端restful风格
    return request.get("/book/delete/"+param);
}

export function saveBook(data){
    //2、post方式请求
    return request.post("/book/save",data);
}

export function getDetail(id){
    return request.get("/book/detail/"+id);
}