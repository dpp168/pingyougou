
app.controller("baseController",function ($scope) {

    //分页控件
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.loadPage();
        }
    };

    //分页
    $scope.loadPage=function () {
        $scope.findByPage();
    }

    //定义搜索条件对象
    $scope.searchMsg={};


    //根据主键删除用户
    //定义选中的集合
    $scope.checkList=[];
    //选择一个添加一个id
    $scope.checkThis=function ($event,id) {
        if($event.target.checked){
            $scope.checkList.push(id);
        }else{
            //获取点击id
            var index = $scope.checkList.indexOf(id);
            $scope.checkList.splice(index,1);
        }
    }



})