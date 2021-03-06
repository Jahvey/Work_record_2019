var options6={
  "title": {
    "subtext": "呵呵哒",
    "textStyle": {
      "color": "#181619",
      "fontSize": 35,
      "fontFamily": "微软雅黑",
      "fontWeight": "bolder"
    },
    "x": "center",
    "y": "top"
  },
  "tooltip": {
    "formatter": "{a} <br/>{b} : {c} ({d}%)",
    "show": true
  },
  "legend": {
    "orient": "vertical",
    "data": [
      "直达",
      "营销广告",
      "搜索引擎",
      "邮件营销",
      "联盟广告",
      "视频广告",
      "百度",
      "谷歌",
      "必应",
      "其他"
    ],
    "x": "left"
  },
  "series": [
  
    {
		
      "radius": [
        0,100
      ],
      "name": "呵呵哒",
      "type": "pie",
      "label": {
        "normal": {
          "color": "#fff",
          "formatter": "{b}:{c} \n {d}%",
          "position": "center",
		  //backgroundColor:'#000'
        }
      },
      "data": [
        {
          "name": "直达",
          "value": 335
        }
      ]
    },
    {
      "radius": [
        100,150
      ],
      "name": "呵呵哒",
      "type": "pie",
      "label": {
        "normal": {
          "formatter": " {b}:{d}% "
        }
      },
      "data": [
        {
          "name": "直达",
          "value": 335
        },
        {
          "name": "邮件营销",
          "value": 310
        },
        {
          "name": "联盟广告",
          "value": 234
        },
        {
          "name": "视频广告",
          "value": 135
        },
        {
          "name": "百度",
          "value": 1048
        },
        {
          "name": "谷歌",
          "value": 251
        },
        {
          "name": "必应",
          "value": 147
        },
        {
          "name": "其他",
          "value": 102
        }
      ]
    }
  ]
};