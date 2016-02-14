angular.module('money').filter('reais', function($filter) {
	return function(input) {
		if (input !== undefined) {
			var r = $filter('currency')(input, " ", 2).toString();
			r = r.replaceAll(",", ".");
			r = "R$ " + r.replaceAt(r.lastIndexOf("."), ",");

			return r;
		}
	}
});