$(function() {	
	$(".add").click(function(e) {
		$('#modalTitle').html("Add book");
		var dataset = e.currentTarget.dataset;
		var bookid = dataset.bookid;
		var userid = dataset.userid;
		$("input[name='amount']").val(1);
		$("#save").attr("data-bookid", dataset.bookid);
		$("#save").attr("data-userid", dataset.userid);
		$("#save").attr("data-user", dataset.user);
		$('#modal').modal('show');
	});
	
/*	$("#modal").validate({
		rules : {
			amount : {
				required : true,
				digits : true,
				min : 0
			}
		},
		messages : {
			password : {
				required : "请输入数量",
				digits : "请输入数字",
				min : "输入应大于零"
			}
		}
	});*/
	
	$("#save").click(function(e) {
		var amount = $("input[name='amount']").val();
		var dataset = e.currentTarget.dataset;
		var bookid = dataset.bookid;
		var userid = dataset.userid;
		var user = dataset.user;
		if(user != "null"){
			jQuery.ajax({
				url : 'addToCart',
				processData : true,
				dataType : "text",
				data : {
					bookid : bookid,
					userid : userid,
					amount : amount
				},
				success : function(data) {
					bootbox.alert({
						message : "Add Successfully!"
					});
				}
			});
	
			$('#modal').modal('hide');
		} else {
			bootbox.alert({
				message : 'Please log in',
				callback : function() {
					location.reload();
				}
			});
		}
	});
});