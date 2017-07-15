$(function() {	
	$("#add").click(function(e) {
		$('#modalTitle').html("Add book");
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
		var user = dataset.user;
		$("input[name='amount']").val(1);
		$("#save").attr("data-id", dataset.id);
		$("#save").attr("data-user", dataset.user);
		$('#modal').modal('show');
	});
	
	$("#save").click(function(e) {
		var amount = $("input[name='amount']").val();
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
		var user = dataset.user;
		if(user != "null" && amount > 0){
			jQuery.ajax({
				url : '#',       //todo
				processData : true,
				dataType : "text",
				data : {
					id : id,
					user : user,
					amount : amount
				},
				success : function(data) {
					bootbox.alert({
						message : "Add Successfully!",
						callback : function() {
							location.reload();
						}
					});
				}
			});
	
			$('#modal').modal('hide');
		} else if(user == "null") {
			bootbox.alert({
				message : 'Please log in',
				callback : function() {
					location.reload();
				}
			});
		} else {
			bootbox.alert({
				message : 'Please enter valid amount',
				callback : function() {
					location.reload();
				}
			});
		}
	});
});
