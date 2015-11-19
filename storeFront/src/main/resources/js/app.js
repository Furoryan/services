var articles = [];

var tmpArticles = 
{
	"articles" : [
		{
			"name" : "First Article",
			"description": "First Description",
			"price": 10.0,
			"quantity": 15
		},
		{
			"name" : "Second Article",
			"description": "Second Description",
			"price": 20.0,
			"quantity": 25
		},
		{
			"name" : "Third Article",
			"description": "Third Description",
			"price": 30.0,
			"quantity": 35
		}
	]
}

var getProducts = function()
{
	$.soap({
	    url: 'http://localhost:9763/services/StoreService/',
	    namespaceURL:'http://store.service.alma.fr'
	});
	$.soap({
	    method: 'getArticles',
	    data: {
	    },
	    soap12: true,
	    success: function (soapResponse) {
	        console.log(soapResponse.toJSON());
	    },
	    error: function (soapResponse) {
	        console.error('that other server might be down... or the CORS...');
	        error();
	    }
	});
};






var updateProducts = function(){

};


var loadPage = function(){

	var ouput = Mustache.render("<div class='container'>
			<table class='table table-hover'>
				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Quantity</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					{{#articles}}
					<tr>
						<td>{{name}}</td>
						<td>{{description}}</td>
						<td>{{price}}</td>
						<td>
							<div class='col-lg-6' style='padding-left: 0px;''>
								<select class='form-control' id='sel1'>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
						</td>
						<td>
							<button type='button' onClick='addArticle()' class='btn btn-primary'>Ajouter au panier</button>
						</td>
					</tr>
					{{/articles}}
				</tbody>
			</table>
		</div>")

	document.getElementById('articles').innerHTML = output;
}