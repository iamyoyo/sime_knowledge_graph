
var basePath;
window.onload=function() {
    basePath = $("#basePath").val();
}

$("#search").click(function(){
    $("#main").css("display", "block")
    var myChart = echarts.init(document.getElementById('main'), 'vintage');
    myChart.showLoading();

    var title = $("#something").val()
    var data = {
        'titleName': title
    }
    var url = basePath + "search/findSomething.do"
    $.post(url,data,function(result){
        var num = 0
        for(var i in result){
            num++
        }
        if(num==0){
            alert("您输入的内容未在数据库中检索到！")
            myChart.hideLoading();
            $("#displaySomething").css("display", "none")
            $("#main").css("display", "none")
            $("#select").css("display","none")
        }
        else if(num == 1){
            graph(result[0],myChart)
        }else{
            $("#select").html("")
            alert("请选择您要检索的内容！")
            myChart.hideLoading();
            $("#displaySomething").css("display", "none")
            $("#main").css("display", "none")
            $("#select").css("display","block")
            //得到所有可以查询的
            for(var number in result){
                $("#select").append("<input type='button' class='select_title' id='input_" + number +"' value='" + result[number]["title"] + "'><br>")
            }
            select_title(result, myChart)
        }
    },'JSON')
})

function select_title(result, myChart){
    $(".select_title").click(function(){
        var val=$(this).attr("id");
        var id = val.split("_")[1]
        graph(result[id], myChart)
    })
}

function graph(jsontest, myChart){
    $("#main").css("display", "block")
    $("#displaySomething").css("display","block")
    $("#displaySomething").html(jsontest["summary"])
    $("#select").css("display","none")

        var series_data_array = []

        var series_links_array = []

        var series_data = '{"name":"' + jsontest["title"] +'","draggable": true}'

        var series_links = ''

        series_data = JSON.parse(series_data)

        series_data_array.push(series_data)

        var length = 0

        jsontest["relation"] = JSON.parse(jsontest["relation"])

        for(var i in jsontest["relation"]){
            if(jsontest["relation"][i]!=jsontest["title"]){
                length++
                series_data = '{"name":"' + jsontest["relation"][i] +'","category": 1,"draggable": "true"}'
                series_data = JSON.parse(series_data)
                series_data_array.push(series_data)
                series_links = '{"source": 0,"target":' +length+ ',"value":"' + i + '"}'
                series_links = JSON.parse(series_links)
                series_links_array.push(series_links)
            }
        }

        jsontest["tag"] = JSON.parse(jsontest["tag"])

        for(var i in jsontest["tag"]){
            length++
            series_data = '{"name":"' + jsontest["tag"][i] +'","category": 2,"draggable": true}'
            series_data = JSON.parse(series_data)
            series_data_array.push(series_data)
            series_links = '{"source": 0,"target":' +length+ ',"value":"标签"}'
            series_links = JSON.parse(series_links)
            series_links_array.push(series_links)
        }


        var option = {
            title: {
                text: jsontest["title"],
                bottom: '20px',
                right: 'center',
                textStyle: {
                    fontSize: 22
                },
            },
            tooltip: {},
            animationDurationUpdate: 1000,
            animationEasingUpdate: 'quinticInOut',
            label: {
                normal: {
                    show: true,
                    textStyle: {
                        fontSize: 12
                    },
                }
            },
            legend: {
                z: "center",
                show: false,
                data: ["BaiduCARD", "BaiduRelation", 'BaiduTAG']
            },
            series: [

                {
                    type: 'graph',
                    layout: 'force',
                    symbolSize: 66,
                    focusNodeAdjacency: true,
                    roam: true,
                    categories: [{
                        name: 'BaiduCARD',
                        itemStyle: {
                            normal: {
                                color: "#009800",
                            }
                        }
                    }, {
                        name: 'BaiduRelation',
                        itemStyle: {
                            normal: {
                                color: "#4592FF",
                            }
                        }
                    }, {
                        name: 'BaiduTAG',
                        itemStyle: {
                            normal: {
                                color: "#C0C0C0",
                            }
                        }
                    }],
                    label: {
                        normal: {
                            show: true,
                            textStyle: {
                                fontSize: 12
                            },
                            align: 'center'
                        }
                    },
                    force: {
                        repulsion: 2333
                    },
                    edgeSymbolSize: [4, 50],
                    edgeLabel: {
                        normal: {
                            show: true,
                            textStyle: {
                                fontSize: 12
                            },
                            formatter: "{c}"
                        }
                    },
                    data: series_data_array,
                    links: series_links_array,
                    lineStyle: {
                        normal: {
                            opacity: 0.9,
                            width: 1,
                            curveness: 0
                        }
                    }
                }
            ]
        };
        myChart.hideLoading();
        myChart.setOption(option);
}