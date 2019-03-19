// 定义服务层:
app.service("brandService",function($http){

	//查询所有
	this.findAll = function(){
		return $http.get("../brand/findAll.do");
	}

	//无条件分页
	this.findPage = function(page,rows){
		return $http.get("../brand/findPage.do?pageNum="+page+"&pageSize="+rows);
	}

	//添加
	this.add = function(entity){
		return $http.post("../brand/add.do",entity);
	}

	//跟新
	this.update=function(entity){
		return $http.post("../brand/update.do",entity);
	}

	//回显数据
	this.findOne=function(id){
		return $http.get("../brand/findOne.do?id="+id);
	}

	//删除
	this.dele = function(ids){
		return $http.post("../brand/delete.do",ids);
	}

	//带条件查询分页
	this.search = function(page,rows,searchEntity){
		return $http.post("../brand/search.do?pageNum="+page+"&pageSize="+rows,searchEntity);
	}
	
	this.selectOptionList = function(){
		return $http.get("../brand/selectOptionList.do");
	}
});