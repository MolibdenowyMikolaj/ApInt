<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SystemEwidencjiPodchorazych</title>  
        <style>
            .username.ng-valid {
                background-color: lightgreen;
            }
            .username.ng-dirty.ng-invalid-required {
                background-color: red;
            }
            .username.ng-dirty.ng-invalid-minlength {
                background-color: yellow;
            }

            .email.ng-valid {
                background-color: lightgreen;
            }
            .email.ng-dirty.ng-invalid-required {
                background-color: red;
            }
            .email.ng-dirty.ng-invalid-email {
                background-color: yellow;
            }

        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>
    <body ng-app="myApp" class="ng-cloak">
        <div class="fluid-container generic-container" ng-controller="UserController as ctrl">
            <div class="panel panel-default">
                <div class="panel-heading"><span class="lead">System Ewidencji Podchor±¿ych </span></div>
                <div class="formcontainer">
                    <div id="donutchart" style="height: 400px;" ></div>
                    
                </div>

            </div>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">Rozliczenie podchor±¿ych </span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Stopieñ</th>
                                <th>Imiê</th>
                                <th>Nazwisko</th>
                                <th>Funkcja</th>
                                <th>Kompania</th>
                                <th>Pluton</th>
                                <th>Dru¿yna</th>
                                <th>Grupa</th>
                                <th>Wydzia³</th>
                                <th>L4</th>
                                <th>Szpital</th>
                                <th>Przepustka</th>
                                <th>S³u¿ba</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="u in ctrl.users">
                                <td><span ng-bind="u.stopien"></span></td>
                                <td><span ng-bind="u.imie"></span></td>
                                <td><span ng-bind="u.nazwisko"></span></td>
                                <td><span ng-bind="u.funkcja"></span></td>
                                <td><span ng-bind="u.kompania"></span></td>
                                <td><span ng-bind="u.pluton"></span></td>
                                <td><span ng-bind="u.druzyna"></span></td>
                                <td><span ng-bind="u.grupa_szkoleniowa"></span></td>
                                <td><span ng-bind="u.wydzial"></span></td>
                                <td>
                                    <div class="squaredOne">
                                        <input type="checkbox" id="{{u.id_zolnierza}}l4" name="{{u.id_zolnierza}}" ng-model="u.l4" ng-change="ctrl.edit(u.id_zolnierza)">
                                        <label for="{{u.id_zolnierza}}l4"></label>
                                    </div>
                                </td>
                                <td>
                                    <div class="squaredOne">
                                        <input type="checkbox" name="{{u.id_zolnierza}}" id="{{u.id_zolnierza}}szpital" ng-model="u.szpital" ng-change="ctrl.edit(u.id_zolnierza)">
                                        <label for="{{u.id_zolnierza}}szpital"></label>
                                    </div>
                                </td>
                                <td>
                                    <div class="squaredOne">
                                        <input type="checkbox" name="{{u.id_zolnierza}}" id="{{u.id_zolnierza}}przepustka" ng-model="u.przepustka" ng-change="ctrl.edit(u.id_zolnierza)">
                                        <label for="{{u.id_zolnierza}}przepustka"></label>
                                    </div>
                                </td>
                                <td>
                                    <div class="squaredOne">
                                        <input type="checkbox" name="{{u.id_zolnierza}}" id="{{u.id_zolnierza}}sluzba" ng-model="u.sluzba" ng-change="ctrl.edit(u.id_zolnierza)">
                                        <label for="{{u.id_zolnierza}}sluzba"></label>
                                    </div>
                                </td> 
                            </tr>
                        </tbody>
                    </table>
                </div>                
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
        <script src="<c:url value='/static/js/app.js' />"></script>
        <script src="<c:url value='/static/js/service/user_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
    </body>
</html>