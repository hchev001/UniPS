angular.module('message', []).controller('message', function($http) {
	var self = this;
	$http.get('/message').then(function(response) {
		console.log(response.data);
		self.greeting = response.data;
	});
});
