$(document).ready(
		function() {

			// SUBMIT FORM
			$("#productForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});
			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					bookId : $("#name").val(),
					bookName : $("#price").val(),
					author : $("#discount").val()
				}
				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "products",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
									"<h1>" + result.data.bookName+"</h1>"
											+ "<br>Post Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

			}

		})