function newEmps(button,idFrom){$("#"+idFrom).show();$(button).hide();}
function hideNewEpmsFrom(idButton,idFrom){$("#"+idButton).show();$("#"+idFrom).hide();}
$(function(){
	$("form [type='submit']").on('click',function(){
		console.log($(this).parent())
		$(this).parent().ajaxForm(function(msg) { 
			$('#msg').text(msg).fadeTo(2000, 0.70,"linear",function(){$(this).hide()});//œ‘ æ…æ≥˝–≈œ¢
         }); 
	})
})
function myTask(){
	$("#myWorkFlowFrom").ajaxForm(function(mytasks){
		mytasks = eval(mytasks);
		$("#myTaskDiv").append("<span>id</span><span>name</span><span>createTime</span><br>");
		$.each(mytasks,function(i,task){
			$("#myTaskDiv").append("<span>"+task.id+"</span><span>"+task.name+"</span><span>"+task.createTime+"</span><br>");
		});
	}).submit();
}
