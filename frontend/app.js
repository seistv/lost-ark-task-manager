var app = angular.module("LostArkApp", []);

app.controller("TaskController", function ($scope, TaskService) {
    $scope.dailyTasks = [];
    $scope.weeklyTasks = [];

    // Fetch tasks from backend
    TaskService.getTasks().then(function (response) {
        $scope.dailyTasks = response.data.dailyTasks;
        $scope.weeklyTasks = response.data.weeklyTasks;
    });
});
