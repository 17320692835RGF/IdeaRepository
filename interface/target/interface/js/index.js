// noinspection JSUnresolvedVariable

/**
 * 首页的js
 */

const $ = jQuery;

// 入口函数
$(function () {
    // 加载样式效果
    loadStyleEffect();

    // 加载环保新闻
    (async function () {
        await loadNews();
    })();

    // 加载环保视频
    (async function () {
        await loadVideo();
    })();

    // 加载环保数据
    (async function () {
        await loadData();
    })();

    // 加载小知识
    (async function () {
        await loadKnowledge();
    })();

    // 加载事件
    loadEvents();
});

// 加载环保新闻
async function loadNews() {
    let url = API.NEWS_API.ALL;
    let data = await get(url, {
        type: 'r',
        length: 3
    });
    data = data.data;
    let covers = $('.news-item img');
    let titles = $('.news-item a');
    let froms = $('.news-item .from');
    for (let i = 0; i < 3; i++) {
        $(covers[i]).attr('src', data[i]['newsFace']);
        $(titles[i]).attr('href', data[i]['newsUrl']);
        $(titles[i]).text(data[i]['newsName']);
        $(froms[i]).text(data[i]['newsFrom']);
    }
}


// 加载环保视频
async function loadVideo() {
    let url = API.VIDEO_API.ALL;
    let data = await get(url, {
        type: 'r',
        length: 2
    });
    data = data.data;
    let frames = $('.video-frame');
    let names = $('.video-name');
    for (let i = 0; i < 2; i++) {
        $(frames[i]).attr('src', data[i]['videoUrl']);
        $(names[i]).html(data[i]['videoName']);
    }
}


// 加载环保数据
async function loadData() {
    // 获取空气质量数据
    let data = await get(API.Air_Quality);
    data = data.data.slice(-24);

    let xAxis_data = [];
    let pm25_data = [];
    let pm10_data = [];

    data.forEach(item => {
        xAxis_data.push(formatDate(item['datatime']));
        pm25_data.push(item['pm25']);
        pm10_data.push(item['pm10']);
    });

    let option_pm25 = {
        title: {
            text: '平顶山市空气质量 - PM2.5 趋势图'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: xAxis_data
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: 'PM2.5',
                type: 'line',
                stack: '总量',
                areaStyle: {},
                data: pm25_data
            }
        ]
    };

    let option_pm10 = {
        title: {
            text: '平顶山市空气质量 - PM10 趋势图'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: xAxis_data
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: 'PM2.5',
                type: 'line',
                stack: '总量',
                areaStyle: {},
                data: pm10_data
            }
        ]
    };

    let chartAQI = echarts.init(document.getElementById('chart-aqi'));
    let chartPM25 = echarts.init(document.getElementById('chart-pm25'));
    chartAQI.setOption(option_pm25);
    chartPM25.setOption(option_pm10);


    window.onresize = function () {
        chartAQI.resize();
        chartPM25.resize();
    };

}


// 加载小知识
async function loadKnowledge() {
    let url = API.FESTIVAL_API.ALL;
    let data = await get(url, {
        type: 'r',
        length: 6
    });
    data = data.data;

    let titles = $('.knowledge-item h3');
    let contents = $('.knowledge-item p');

    for (let i = 0; i < 6; i++) {
        $(titles[i]).html(data[i]['holidayName']);
        $(contents[i]).html(`${data[i]['holidayDate']}<br>${data[i]['holidayReason']}`);
    }
}


// 加载事件
function loadEvents() {
    // 刷新新闻
    $('#refresh-news').click(() => {
        (async function () {
            await loadNews();
        })();
    });


    // 刷新视频
    $('#refresh-video').click(() => {
        (async function () {
            await loadVideo();
        })();
    });


    // 刷新小知识
    $('#refresh-knowledge').click(() => {
        (async function () {
            await loadKnowledge();
        })();
    });
}


// 加载样式效果
function loadStyleEffect() {

    // 加载时候的动图
    $(window).load(function () {
        // noinspection JSUnresolvedFunction
        $('#loading').fadeOut();
        // noinspection JSUnresolvedFunction
        $('#loadingDiv').delay(1000).fadeOut("slow");
    });

    // 滚动到30的时候，导航栏折叠
    // noinspection JSUnresolvedFunction
    $(window).on('ready , scroll', function () {
        if ($(window).scrollTop() > 30) {
            // noinspection JSUnresolvedFunction
            $('#navbar').addClass('minified');
        } else {
            // noinspection JSUnresolvedFunction
            $('#navbar').removeClass('minified');
        }
    });

    // 轮播图翻页效果
    // noinspection JSUnresolvedFunction
    $('#nav-menu').onePageNav({
        currentClass: 'active',
        scrollSpeed: 500,
        easing: 'linear'
    });

    // 动画效果
    // noinspection JSUnresolvedFunction
    let wow = new WOW(
        {
            boxClass: 'wow',
            animateClass: 'animated',
            offset: 250,
            mobile: true,
            live: true
        }
    );
    // noinspection JSUnresolvedFunction
    wow.init();


    // 视差效果
    // noinspection JSUnresolvedFunction
    $(window).stellar({
        responsive: true,
        positionProperty: 'position'
    });


    // 轮播图
    // noinspection JSUnresolvedFunction
    $('#slider').sliderPro({
        width: '100%',
        height: 768,
        fade: true,
        arrows: true,
        waitForLayers: true,
        buttons: true,
        autoplay: true,
        autoScaleLayers: false,
        imageScaleMode: 'cover',
        slideAnimationDuration: 1500,
        breakpoints: {
            600: {
                height: 480
            }
        }
    });


}
