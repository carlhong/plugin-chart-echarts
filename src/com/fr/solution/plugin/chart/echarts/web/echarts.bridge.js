/**
 * Created by richie on 16/1/29.
 */
EChartsFactory = function(options, $dom) {
    debugger;
    var myChart = echarts.init($dom[0], 'dark');
    var option = {
        title : {
            text: 'iphone����',
            subtext: '�����鹹',
            x:'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            x:'left',
            data:['iphone3','iphone4','iphone5']
        },
        dataRange: {
            min: 0,
            max: 2500,
            x: 'left',
            y: 'bottom',
            text:['��','��'],           // �ı���Ĭ��Ϊ��ֵ�ı�
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            x: 'right',
            y: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        roamController: {
            show: true,
            x: 'right',
            mapTypeControl: {
                'china': true
            }
        },
        series : [
            {
                name: 'iphone3',
                type: 'map',
                mapType: 'china',
                roam: false,
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data:[
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '���',value: Math.round(Math.random()*1000)},
                    {name: '�Ϻ�',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '�ӱ�',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '������',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: 'ɽ��',value: Math.round(Math.random()*1000)},
                    {name: '�½�',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '�㽭',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: 'ɽ��',value: Math.round(Math.random()*1000)},
                    {name: '���ɹ�',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '�㶫',value: Math.round(Math.random()*1000)},
                    {name: '�ຣ',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '�Ĵ�',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '̨��',value: Math.round(Math.random()*1000)},
                    {name: '���',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)}
                ]
            },
            {
                name: 'iphone4',
                type: 'map',
                mapType: 'china',
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data:[
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '���',value: Math.round(Math.random()*1000)},
                    {name: '�Ϻ�',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '�ӱ�',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '�½�',value: Math.round(Math.random()*1000)},
                    {name: '�㽭',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: 'ɽ��',value: Math.round(Math.random()*1000)},
                    {name: '���ɹ�',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '�㶫',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '�Ĵ�',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '���',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)}
                ]
            },
            {
                name: 'iphone5',
                type: 'map',
                mapType: 'china',
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data:[
                    {name: '����',value: Math.round(Math.random()*1000)},
                    {name: '���',value: Math.round(Math.random()*1000)},
                    {name: '�Ϻ�',value: Math.round(Math.random()*1000)},
                    {name: '�㶫',value: Math.round(Math.random()*1000)},
                    {name: '̨��',value: Math.round(Math.random()*1000)},
                    {name: '���',value: Math.round(Math.random()*1000)},
                    {name: '����',value: Math.round(Math.random()*1000)}
                ]
            }
        ]
    };

    myChart.setOption(option);
};