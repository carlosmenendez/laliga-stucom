'use strict';

angular.module('laligaStucomApp')
    .factory('Equipo', function ($resource, DateUtils) {
        return $resource('api/equipos/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.fecha_fundacion = DateUtils.convertLocaleDateFromServer(data.fecha_fundacion);
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    data.fecha_fundacion = DateUtils.convertLocaleDateToServer(data.fecha_fundacion);
                    return angular.toJson(data);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    data.fecha_fundacion = DateUtils.convertLocaleDateToServer(data.fecha_fundacion);
                    return angular.toJson(data);
                }
            }
        });
    });
