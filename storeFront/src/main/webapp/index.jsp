<html>
<head>
	<title>Shop</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="../../../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="../resources/css/app.css" rel="stylesheet" media="screen">

</head>

<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<div class="navbar-form navbar-right">
					<button type="submit" class="btn btn-default">Panier</button>
				</div>
			</div>
		</div>
	</nav>

	<script type="text/mustache" id="articleList">
		<div class="container">
			<table class="table table-hover">
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
					<tr>
					<td>{{name}}</td>
						<td>{{description}}</td>
						<td>{{price}}</td>
						<td>
							<div class="col-lg-6" style="padding-left: 0px;">
								<select class="form-control" id="sel1">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
						</td>
						<td>
							<button type="button" class="btn btn-primary">Ajouter au panier</button>
						</td>
					</tr>
					<tr>
						<td>Mary</td>
						<td>Moe</td>
						<td>mary@example.com</td>
						<td>
							<div class="col-lg-6" style="padding-left: 0px;">
								<select class="form-control" id="sel1">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
						</td>
						<td>
							<button type="button" class="btn btn-primary">Ajouter au panier</button>
						</td>
					</tr>
					<tr>
						<td>July</td>
						<td>Dooley</td>
						<td>july@example.com</td>
						<td>
							<div class="col-lg-6" style="padding-left: 0px;">
								<select class="form-control" id="sel1">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</td>
							<td>
								<button type="button" class="btn btn-primary">Ajouter au panier</button>
							</td>
						</tr>
						<tr>


						</tr>
					</tbody>
				</table>
			</div>
		</script>

		<div class="container">
			<table class="table table-hover">
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
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td>
							<div class="col-lg-6" style="padding-left: 0px;">
								<select class="form-control" id="sel1">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
						</td>
						<td>
							<button type="button" class="btn btn-primary">Ajouter au panier</button>
						</td>
					</tr>
					<tr>
						<td>Mary</td>
						<td>Moe</td>
						<td>mary@example.com</td>
						<td>
							<div class="col-lg-6" style="padding-left: 0px;">
								<select class="form-control" id="sel1">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
						</td>
						<td>
							<button type="button" class="btn btn-primary">Ajouter au panier</button>
						</td>
					</tr>
					<tr>
						<td>July</td>
						<td>Dooley</td>
						<td>july@example.com</td>
						<td>
							<div class="col-lg-6" style="padding-left: 0px;">
								<select class="form-control" id="sel1">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</td>
							<td>
								<button type="button" class="btn btn-primary">Ajouter au panier</button>
							</td>
						</tr>
						<tr>


						</tr>
					</tbody>
				</table>
			</div>

			<script type="text/javascript" src="../../../bower_components/jquery/dist/jquery.min.js"></script>
			<script type="text/javascript" src="../../../bower_components/jquery.soap/jquery.soap.js"></script>
			<script type="text/javascript" src="../../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		</body>
		</html>
