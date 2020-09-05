GET: $(document).ready(
		function() {
			// GET REQUEST
			$("#getALl").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});
			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "products",
					success : function(result) {
						if (result.status == "success") {
							$('#getResultDiv ul').empty();
							var custList = "";
							$.each(result.data,
									function(i, product) {
										var user = "Product  Name  "
												+ product.name
												+ ", Price  = " + product.price
												+ ", Discount  = " + product.discount
												+ "<br>";
										$('#getResultDiv .list-group').append(
												user)
									});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})