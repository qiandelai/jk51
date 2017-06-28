<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">	<meta name="description" content="">
	<title>3D 交互柱状图</title>
	<script src="${pageContext.request.contextPath }/components/chart/jquery-1.8.3.min.js"></script>
	<script src="${pageContext.request.contextPath }/components/chart/highcharts.js"></script>
	<script src="${pageContext.request.contextPath }/components/chart/highcharts-3d.js"></script>
	<script src="${pageContext.request.contextPath }/components/chart/exporting.js"></script>
	<script src="${pageContext.request.contextPath }/components/chart/highcharts-zh_CN.js"></script>
</head>
<body>
<!--
*************************************************************************
    Generated by HCODE at 2017-05-05 12:27:28
    From: https://code.hcharts.cn/demos/hhhhDo
*************************************************************************
-->
<div id="container"></div>
<div id="sliders">
    <table>
        <tbody><tr>
            <td>α 角（内旋转角）</td>
            <td><input id="alpha" type="range" min="0" max="45" value="15"> <span id="alpha-value" class="value"></span></td>
        </tr>
        <tr>
            <td>β 角（外旋转角）</td>
            <td><input id="beta" type="range" min="-45" max="45" value="15"> <span id="beta-value" class="value"></span></td>
        </tr>
        <tr>
            <td>深度</td>
            <td><input id="depth" type="range" min="20" max="100" value="50"> <span id="depth-value" class="value"></span></td>
        </tr>
    </tbody></table>
</div>

	<script>
	$(function () {
    // Set up the chart
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'container',
            type: 'column',
            options3d: {
                enabled: true,
                alpha: 15,
                beta: 15,
                depth: 50,
                viewDistance: 25
            }
        },
        title: {
            text: '产品价格排行榜'
        },
        /* subtitle: {
            text: '可通过滑动下方滑块测试'
        }, */
		 xAxis: {
            categories: ${listName}   /* ['苹果', '橘子', '梨', '葡萄', '香蕉']  */
        }, 
        plotOptions: {
            column: {
                depth: 25
            }
        },
        series: [{
            name:'图例1',
            data:${listData}   /* [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4] */
        }]
    });
    function showValues() {
        $('#alpha-value').html(chart.options.chart.options3d.alpha);
        $('#beta-value').html(chart.options.chart.options3d.beta);
        $('#depth-value').html(chart.options.chart.options3d.depth);
    }
    // Activate the sliders
    $('#sliders input').on('input change', function () {
        chart.options.chart.options3d[this.id] = this.value;
        showValues();
        chart.redraw(false);
    });
    showValues();
});
</script>

</body></html>