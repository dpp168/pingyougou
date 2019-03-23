app.controller("indexController",function ($scope, loginService) {
    $scope.showName=function () {
        loginService.showName().success(function (response) {
             $scope.loginName=response.username;
        })
    }

    /* 显示当前登陆时间*/
    $scope.data = new Date().toLocaleString()
})