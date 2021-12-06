/**
 * 接口
 */
const API = {

    // 空气质量
    Air_Quality: 'http://120.26.163.105/interface/getData',


    // 新闻api
    NEWS_API: {
        ALL: 'http://120.26.163.105/interface/selectNews',

        ADD: 'http://120.26.163.105/interface/insertNews',

        DELETE: 'http://120.26.163.105/interface/deleteNews'
    },

    // 视频api
    VIDEO_API: {
        ALL: 'http://120.26.163.105/interface/selectAllVideo',

        ADD: 'http://120.26.163.105/interface/insertVideo',

        DELETE: 'http://120.26.163.105/interface/deleteVideo'
    },

    // 节日api
    FESTIVAL_API: {
        ALL: 'http://120.26.163.105/interface/selectHolidays',

        ADD: 'http://120.26.163.105/interface/insertHoliday',

        DELETE: 'http://120.26.163.105/interface/deleteHoliday'
    }

};