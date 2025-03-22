var app = angular.module("LostArkApp", []);

app.controller("TaskController", function ($scope, TaskService) {
    $scope.characters = [];
    $scope.uniqueTasks = [];
    $scope.raids = [];
    $scope.goldEarningRaids = [];
    $scope.taskStatus = {};

    // Fetch characters and their tasks
    TaskService.getCharacters().then(function (response) {
        $scope.characters = response.data;
        let taskMap = {};

        $scope.characters.forEach(character => {
            character.tasks = character.tasks || []; // Ensure tasks exist
            
            character.tasks.forEach(task => {
                if (!taskMap[task.taskId]) {
                    taskMap[task.taskId] = task;
                }

                // Ensure taskStatus object exists
                if (!$scope.taskStatus[character.characterId]) {
                    $scope.taskStatus[character.characterId] = {};
                }

                // Store task completion status
                $scope.taskStatus[character.characterId][task.taskId] = task.completed;
            });
        });

        $scope.uniqueTasks = Object.values(taskMap);
    });

    // Fetch all raids
    TaskService.getRaids().then(function (response) {
        $scope.raids = response.data;
    });

    // Fetch gold-earning raids
    TaskService.getGoldEarningRaids(1).then(function (response) {
        $scope.goldEarningRaids = response.data;
    });

    // Toggle task completion and update backend
	$scope.toggleTask = function (characterId, taskId) {
	    let newStatus = !!$scope.taskStatus[characterId][taskId]; // Ensure Boolean

	    TaskService.updateTaskStatus(characterId, taskId, newStatus)
	        .then(function () {
	            console.log(`Updated Task ${taskId} for Character ${characterId} to:`, newStatus);
	        })
	        .catch(function (error) {
	            console.error("Error updating task status:", error);
	        });
	};
});