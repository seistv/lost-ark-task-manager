var app = angular.module("LostArkApp", []); // Define AngularJS app

app.controller("TaskController", function ($scope, TaskService) {
    $scope.characters = [];
	$scope.tasks = [];
    $scope.raids = [];
    $scope.goldEarningRaids = {};
    $scope.taskStatus = {};
/*	$scope.uniqueTasks = [];*/

    // Fetch characters and their tasks
    TaskService.getCharacters().then(function (response) {
        $scope.characters = response.data;
        let taskMap = {};
        let raidMap = {};
		let uniqueTasksMap = {}; // Store unique tasks separately

        $scope.characters.forEach(character => {
            character.tasks = character.tasks || []; // Ensure tasks exist
            
            character.tasks.forEach(task => {
                if (task.taskType === "Weekly Raid") {
                    // Store raids separately
                    if (!raidMap[task.taskId]) {
                        raidMap[task.taskId] = task;
                    }
                } else {
                    // Store tasks separately
                    if (!taskMap[task.taskId]) {
                        taskMap[task.taskId] = task;
                    }
					
/*					if (!uniqueTasks[task.taskName]) {
					    uniqueTasks[task.taskName] = {
					        taskName: task.taskName
					    };
					}*/
                }

                // Ensure taskStatus object exists
                if (!$scope.taskStatus[character.characterId]) {
                    $scope.taskStatus[character.characterId] = {};
                }

                // Store task completion status
                $scope.taskStatus[character.characterId][task.taskId] = task.completed;
/*				console.log(uniqueTasks);*/
            });

            // Fetch gold-earning raids per character
            TaskService.getGoldEarningRaids(character.characterId).then(function (response) {
                if (!$scope.goldEarningRaids[character.characterId]) {
                    $scope.goldEarningRaids[character.characterId] = {};
                }

                response.data.forEach(raid => {
                    $scope.goldEarningRaids[character.characterId][raid.taskId] = raid.completed;
                });
            });
        });

        // Store unique tasks and raids separately
        $scope.tasks = Object.values(taskMap);
        $scope.raids = Object.values(raidMap);
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

    // Toggle gold-earning raid completion
    $scope.toggleGoldEarningRaid = function (characterId, raidId) {
        let newStatus = !$scope.goldEarningRaids[characterId][raidId];

        TaskService.updateGoldEarningRaidStatus(characterId, raidId, newStatus)
            .then(function () {
                console.log(`Updated Gold-Earning Raid ${raidId} for Character ${characterId} to:`, newStatus);
                $scope.goldEarningRaids[characterId][raidId] = newStatus;
            })
            .catch(function (error) {
                console.error("Error updating gold-earning raid status:", error);
            });
    };
});
