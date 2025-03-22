app.service("TaskService", function ($http) {
    this.getTasks = function () {
        return $http.get("/api/tasks");
    };

    this.getCharacters = function () {
        return $http.get("/api/characters");
    };

    this.getRaids = function () {
        return $http.get("/api/raids");
    };

    this.getGoldEarningRaids = function (userId) {
        return $http.get(`/api/gold-earning-raids/${userId}`);
    };

	this.updateTaskStatus = function (characterId, taskId, completed) {
	    return $http.put("/api/tasks/update-status", {
	        characterId: characterId,
	        taskId: taskId,
	        completed: completed ? true : false // Ensure Boolean
	    });
	};
});
