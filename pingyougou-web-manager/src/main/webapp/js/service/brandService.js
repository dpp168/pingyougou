app.service('brandService',function ($http) {

    //条件查询
    this.findByPage = function (pageNum,pageSize,searchMsg) {
        return  $http.post("../brand/findByPage.do?pageNum="+pageNum+"&pageSize="+pageSize,searchMsg)
    }

    //添加数据
    this.add = function (entity) {
        return $http.post("../brand/add.do",entity)
    }

    //跟新数据
    this.update = function (entity) {
        return $http.post("../brand/updateByPrimikey.do",entity)
    }

    //回显品牌
    this.findById = function (id) {
        return $http.get("../brand/findById.do?id="+id)
    }

    //删除品牌
    this.dele = function (checkList) {
        return $http.post("../brand/deleteByPrimaryKey.do",checkList)
    }

})