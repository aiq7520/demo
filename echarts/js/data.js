Array.prototype.contains = function ( arr ) {
  for (i in this) {
    if (this[i] == arr) return i;
  }
  return 0;
}

var convertData = function (data) {
    var res = [];
    for (var i = 0; i < data.length; i++) {
        var geoCoord = data[i].coordinate;
        if (geoCoord) {
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value)
            });
        }
    }
    return res;
};
	
//描绘地图省会的点（有车库所在省会）
function initData(name,values,coordinates){
	var data =new Array(name.length);//[{name:'天津',value:1000,coordinate:[117.2,39.13]]
	$.each(name,function(i,n){
		data[i]={};
		data[i].name=n;
		data[i].value=values[i];
		data[i].coordinate=coordinates[i];
	})
	//console.log(data)
	return data;
}
var zooms =[1,1.2,20,50,100];//地图放大级别  第一个数用来记录放大了多少次

var province = ['天津','上海','广州'];//车库所在省份
var values=[1000,9000,2000];//省份共有的车辆总数 和省份一一对应
var coordinates = [[117.2,39.13],[121.48,31.22],[113.23,23.16]];//省份所在省会坐标  和省份一一对应
var data = initData(province,values,coordinates);//数据点对象信息


var storages = ['VPC库','八号库','分部','七号库','芦潮库','南沙库'];
var carCount = [10000,8000,5000,7000,500,2564];
var storageCoordinates = [[117.76,39.01],[117.76,39.06],[117.23,39.08],[117.75,39.06],[121.85,30.89],[113.55,22.86]];
var detailData = initData(storages,carCount,storageCoordinates);//数据点对象信息


var seriesData={
			name: '车库',
            type: 'scatter',
            coordinateSystem: 'geo',
            data: convertData(detailData),
            symbolSize: function (val) {
                return 15;
            },
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: false//是否显示 data.name
                },
                emphasis: {
                    show: false
                }
            },
            itemStyle: {
                normal: {
                    color:function(series){
					//console.log(series.data.value[2]);
					//colordata = 
					return "rgba(255, 255, 0,0.5)";
					}//ddb926
                }
            }
}
