'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function ($scope, UserService) {
        var self = this;
        self.users = [];
        self.edit = edit;

        fetchAllUsers();

        function fetchAllUsers() {
            UserService.fetchAllUsers()
                    .then(
                            function (d) {
                                self.users = d;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Users');
                            }
                    );
        }

        function updateUser(user, id) {
            UserService.updateUser(user, id)
                    .then(
                            fetchAllUsers,
                            function (errResponse) {
                                console.error('Error while updating User');
                            }
                    );
        }

        function edit(id_zolnierza) {
            console.log('id to be edited', id_zolnierza);
            for (var i = 0; i < self.users.length; i++) {
                if (self.users[i].id_zolnierza === id_zolnierza) {
                    updateUser(self.users[i], self.users[i].id_zolnierza);
                    break;
                }
            }
        }


    }]);
