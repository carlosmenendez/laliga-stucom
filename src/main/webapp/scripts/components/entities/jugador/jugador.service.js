'use strict';

angular.module('laligaStucomApp')
    .factory('Jugador', function ($resource, DateUtils) {
        return $resource('api/jugadors/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.fecha_nacimiento = DateUtils.convertLocaleDateFromServer(data.fecha_nacimiento);
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    data.fecha_nacimiento = DateUtils.convertLocaleDateToServer(data.fecha_nacimiento);
                    return angular.toJson(data);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    data.fecha_nacimiento = DateUtils.convertLocaleDateToServer(data.fecha_nacimiento);
                    return angular.toJson(data);
                }
            }
        });
    });
