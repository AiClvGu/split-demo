import request from "@/utils/request";

export function getOperateLog(param){
    return request.get("/operateLog/list",{
        params:{
            localDateTime:param,
        }
    })
}

export function delOperateLog(param){
    return request.get("/operateLog/delete",{
        params:{
            ids:param
        }
    })
}