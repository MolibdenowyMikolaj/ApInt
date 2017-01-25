'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.user={id_zolnierza:null,stopien:'',imie:'',nazwisko:''};
    self.users=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllUsers();

    function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

    function createUser(user){
        UserService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }

    function updateUser(user, id){
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function deleteUser(id){
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    function submit() {
        if(self.user.id_zolnierza===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id_zolnierza);
            console.log('User updated with id ', self.user.id_zolnierza);
        }
        reset();
    }

    function edit(id_zolnierza){
        console.log('id to be edited', id_zolnierza);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id_zolnierza === id_zolnierza) {
                self.user = angular.copy(self.users[i]);
                updateUser(self.user, self.user.id_zolnierza);
                console.log(self.user.l4);
                break;
            }
        }
    }
    
    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id_zolnierza === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.user={id_zolnierza:null,stopien:'',imie:'',nazwisko:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
