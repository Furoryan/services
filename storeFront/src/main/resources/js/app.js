var articles = [];


var getProducts = function()
{
	$.soap({
	    url: 'http://localhost:9763/services/ShopService/',
	    namespaceURL:'http://shop.service.alma.fr'
	});
	$.soap({
	    method: 'getProducts',
	    data: {
	    },
	    soap12: true,
	    success: function (soapResponse) {
	        updateProducts(soapResponse.toJSON());
	    },
	    error: function (soapResponse) {
	        console.error('that other server might be down... or the CORS...');
	        error();
	    }
	});
};






var updateProducts: function(){

};