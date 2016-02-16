 'use strict';

angular.module('laligaStucomApp')
    .factory('notificationInterceptor', function ($q, AlertService) {
        return {
            response: function(response) {
                var alertKey = response.headers('X-laligaStucomApp-alert');
                if (angular.isString(alertKey)) {
                    AlertService.success(alertKey, { param : response.headers('X-laligaStucomApp-params')});
                }
                return response;
            }
        };
    });
