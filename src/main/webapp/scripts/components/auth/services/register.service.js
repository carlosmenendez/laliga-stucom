'use strict';

angular.module('laligaStucomApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


