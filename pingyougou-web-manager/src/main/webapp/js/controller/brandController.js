app.controller("brandController",function ($scope,$controller,$http,brandService) {

    //定义当前controller继承baseController 指定数据共享域 伪继承
    $controller("baseController",{$scope:$scope});

    //分页请求
    $scope.findByPage = function () {
        brandService.findByPage(
            $scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage,
            $scope.searchMsg).success(
            function (pageInfo) {
                $scope.paginationConf.totalItems = pageInfo.total;
                $scope.list=pageInfo.list;
            }
        )
    };

    //带条件搜索点击事件
    $scope.search=function () {
        $scope.loadPage();//-->指向baseController
    };

    //添加数据
    $scope.add=function () {

        //插入数据
        var url=brandService.add($scope.entity);
        //更新数据
        if($scope.entity.id !=null){
            url=brandService.update($scope.entity);
        }

        url.success(
            function (response) {
                if(response.success){
                    alert(response.msg);
                    $scope.loadPage();
                }else{
                    alert(response.msg);
                }
            }
        )
    }

    //根据id查询品牌信息
    $scope.findById=function (id) {
        brandService.findById(id).success(function (response) {
            $scope.entity=response;
        })
    }

    //根据用户主键删除数据
    $scope.dele=function () {
        brandService.dele($scope.checkList).success(
            function (response) {
                if(response.success){
                    alert(response.msg);
                    $scope.loadPage();
                    $scope.checkList=[];
                }else{
                    alert(response.msg)
                }
            })
    }

});

