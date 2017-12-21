function Point(x,y){this.x =x;this.y =y;}
function drowLine(p1,p2,pArr){
	var start = "M"+p1.x+" "+p1.y;
	var zhong ="";
	if(pArr&&pArr.length>0){
		$.each(pArr,function(i,p){
			zhong="L"+p.x+" "+p.y+zhong;
		});
	}
	
	var end = "L"+p2.x+" "+p2.y;
	return start+zhong+end+"l0 5l5 -5l-5 -5l0 5";
}
$(function(){
	var paper = Raphael("raphael", 1500,700);//在 raphael div中创建一个1000*1000的画布
	var startPoint = new Point(100,100);
	var endPoint = new Point(500,100);
	var  px=0,py=0;
    var aaa =  paper.circle(startPoint.x,startPoint.y, 30).attr({"fill": "red"}).data("name","startPoint"); //画圆
    var bbb =  paper.circle(endPoint.x,endPoint.y, 30).attr({"fill": "red"}).data("name","endPoint"); //画圆
    var line = paper.path(drowLine(startPoint,endPoint)).attr({stroke: "blue","stroke-width":5})
    .data({"startPoint":startPoint,"endPoint":endPoint,"pArr":[]})
    paper.forEach(function(element){
    	if(element.type=='circle')
    	element.drag(function(dx,dy,x,y){
    		element.attr({"cx":x,"cy":y});
    		if(element.data("name")=='startPoint'){
    			startPoint.x=x;
    			startPoint.y=y;
    		}
    		else{
    			endPoint.x=x;
    			endPoint.y=y;
    		}
    		line.attr({"path":drowLine(startPoint,endPoint)});
    	})
    }); 
   
    line.drag(function(dx,dy,x,y){
    	px=x;
    	py=y;
    	this.attr({"path":drowLine(this.data("startPoint"),this.data("endPoint"),[new Point(px,py)])});
    },null,function(){
    	var pArr = this.data("pArr");
    	/*if(pArr.length<=3)pArr.push(new Point(px,py));
    	else{
    		pArr.reverse().pop();
    		pArr.push(new Point(px,py))
    	}*/
    	//this.attr({"path":drowLine(this.data("startPoint"),this.data("endPoint"),pArr)});
	});
})