$(function(){
	var lineLength =100;//线长
	var x=10,y=10;
	var font1  = {'font-family':'serif','font-size':'20px'}//字体样式
    var paper = Raphael("raphael", 1500,700);//在 raphael div中创建一个1000*1000的画布
    
    
    var aaa =  paper.circle(10, 10, 30).attr({"fill": "red"}).drag(move, start, end); //画圆 
    function start() {
        console.log('start '+aaa.attr("cx")+":"+aaa.attr("cy"));
    }
    function move(dx,dy,x,y,event) {
        console.log(dx+":"+dy+" "+x+":"+y);
        aaa.attr({"cx":x,"cy":y});
    }
    function end() {
        console.log('end '+aaa.attr("cx")+":"+aaa.attr("cy"));
    }
    
    
    
    var circle =  paper.circle(100, 350, 30).attr("name",'圆').data("name","圆"); //画圆 
    var cx = circle.attr("cx"),//开始圆的x坐标
        cy = circle.attr("cy");//开始圆的y坐标
    	r = circle.attr("r");//圆的半径
    var startText = paper.text(cx, cy, "Start").attr(font1);//text   //文字  开始
    var pathParams ="M"+(cx+r)+" "+(cy)/*起点坐标*/+"h"+lineLength/*水平100*/;
    paper.path(pathParams);//画路径 从10.10 移动到90.90
    pathParams ="M"+(cx+r+90)+" "+(cy+5)+"l10 -5l-10 -5  Z";
    paper.path(pathParams).attr({'stroke-width':2,"fill": "black"});  
    //长方形
    paper.rect(cx+lineLength+r, cy-50/*减去高的一半*/, 150, 100,10).data("name","提交申请")//画矩形(x,y,width,height,r),r代表矩形圆角，默认为0
    pathParams ="M"+(cx+lineLength+r+150)+" "+(cy)/*起点坐标*/+"h"+lineLength/*水平100*/;
    paper.path(pathParams);
    pathParams ="M"+(cx+lineLength+r+150+90)+" "+(cy+5)+"l10 -5l-10 -5  Z";
    paper.path(pathParams).attr({'stroke-width':2,"fill": "black"});  
    paper.text(cx+lineLength+r+75, cy, "提交申请")
    
    paper.rect(cx+lineLength*3.5+r, cy-50/*减去高的一半*/, 150, 100,10).data("name","组长审批");//画矩形(x,y,width,height,r),r代表矩形圆角，默认为0
    pathParams ="M"+(cx+lineLength*3.5+r+150)+" "+(cy)/*起点坐标*/+"h"+lineLength/*水平100*/;
    paper.path(pathParams);
    pathParams ="M"+(cx+lineLength*3.5+r+150+90)+" "+(cy+5)+"l10 -5l-10 -5  Z";
    paper.path(pathParams).attr({'stroke-width':2,"fill": "black"}); 
    pathParams ="M"+(cx+lineLength*3.5+r+75)+" "+(cy-50)+"l0 -50l-200 0l0 45l-5 0l5 5l5 -5l-5 0 ";
    paper.path(pathParams).attr({'stroke-width':2}); 
    paper.text(cx+lineLength*3.5+r+75, cy, "组长审批")

    paper.rect(cx+lineLength*6+r, cy-50/*减去高的一半*/, 150, 100,10).data("name","经理审批");//画矩形(x,y,width,height,r),r代表矩形圆角，默认为0  
    pathParams ="M"+(cx+lineLength*6+r+150)+" "+(cy)/*起点坐标*/+"h"+lineLength/*水平100*/;
    paper.path(pathParams);
    pathParams ="M"+(cx+lineLength*6+r+150+60)+" "+(cy+5)+"l10 -5l-10 -5  Z";
    paper.path(pathParams).attr({'stroke-width':2,"fill": "black"});
    pathParams ="M"+(cx+lineLength*6+r+75)+" "+(cy-50)+"l0 -50l-200 0l0 45l-5 0l5 5l5 -5l-5 0 ";
    paper.path(pathParams).attr({'stroke-width':2}); 
    paper.text(cx+lineLength*6+r+75, cy, "组长审批")
    
    paper.circle(cx+lineLength*6+r+150+100, 350, 30).data("name",'圆'); //画圆 
    var startText = paper.text(cx+lineLength*6+r+150+100, cy, "End").attr(font1);//text   //文字  开始
    paper.forEach(function(s){
    	var fill = s.attr("fill");
    	if(fill=='none')s.attr({"fill": "white"})
    	
    	if(s.data("name")){
    		s.node.onclick=function(){
    			if(s.node.nodeName=='circle')
    				alert(s.node.nodeName+"  x:"+s.attr("cx")+" y:"+s.attr("cy")+" "+s.data("name"))
    			else
    				alert(s.node.nodeName+"  x:"+s.attr("x")+" y:"+s.attr("y")+" "+s.data("name"))
    			
    		};
    	}
    }); 
  
})