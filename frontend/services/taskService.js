app.service("TaskService", function ($http) {
    this.getTasks = function () {
        return $http.get("http://localhost:8080/api/tasks");
    };
});