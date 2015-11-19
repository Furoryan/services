<html>
<head>
	<title>Shop</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="../../../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="../resources/css/main.css" rel="stylesheet" media="screen">
	<script type="text/javascript" src="../../../bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="../../../bower_components/jquery.soap/jquery.soap.js"></script>
	<script type="text/javascript" src="../../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../resources/js/mustache.min.js"></script>

	<script type="text/javascript">
		var articles = 
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
		function loadPage(){

			var output = Mustache.render("<div class='container'>" +
				"<table class='table table-hover'>" +
					"<thead>" +
						"<tr>" +
							"<th>Name</th>" +
							"<th>Description</th>" +
							"<th>Price</th>" +
							"<th>Quantity</th>" +
							"<th></th>" +
						"</tr>" +
					"</thead>" +
					"<tbody>" +
						"{{#articles}}" +
						"<tr>" +
							"<td>{{name}}</td>" +
							"<td>{{description}}</td>" +
							"<td>{{price}}</td>" +
							"<td>" +
								"<div class='col-lg-6' style='padding-left: 0px;'>" +
									"<select class='form-control' id='sel1'>" +
										"<option>1</option>" +
										"<option>2</option>" +
										"<option>3</option>" +
										"<option>4</option> "+
									"</select>" +
								"</div>" +
							"</td>" +
							"<td>" +
								"<button type='button' onClick='addArticle()' class='btn btn-primary'>Ajouter au panier</button>" +
							"</td>" +
						"</tr>" +
						"{{/articles}}" +
					"</tbody>" +
				"</table>" +
			"</div>", articles);

			document.getElementById('articles').innerHTML = output;
		}

	</script>

</head>

<body onload="loadPage()">
	<nav class="navbar navbar-default">
		<div class="container-fluid">

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<div class="navbar-form navbar-right">
					<button type="submit" class="btn btn-default">Panier</button>
				</div>
			</div>
		</div>
	</nav>
	<div id="articles"></div>
	
</body>
</html>
