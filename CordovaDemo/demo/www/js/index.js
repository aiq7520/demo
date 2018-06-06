$(function(){
    $.ajax({
        type:'POST',
        url:'http://192.168.2.111:8081/ssm/CordovaDemo/loginpage.html',
        dataType: 'text',
        success:function(data){
            $("body").html(data);
        }
    });
})