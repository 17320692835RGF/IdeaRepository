// 侧边导航
// noinspection JSUnusedGlobalSymbols
let slideNav = {
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        tap(e) {
            let id = `#section${e.index}`;
            for (let i = 1; i <= 3; i++) {
                $(`#section${i}`).hide();
            }
            $(id).show();
        }
    }
};
// noinspection JSUnresolvedVariable
let CtorSlideNav = Vue.extend(slideNav);
new CtorSlideNav().$mount('#slide-nav');


// 新闻管理
// noinspection JSUnusedGlobalSymbols,ES6ShorthandObjectProperty
let newsTable = {
    data() {
        return {
            newsData: [{
                "newsName": "正在获取...",
                "newsFrom": "正在获取...",
                "newsUrl": "正在获取...",
                "newsFace": "正在获取...",

            }],
            inputName: '',
            inputFrom: '',
            inputUrl: '',
            inputCoverUrl: '',
        }
    },
    created() {
        this.refresh();
    },
    methods: {
        handleClick(a) {
            console.log(a);
        },

        refresh() {
            let that = this;
            (async function () {
                let url = API.NEWS_API.ALL;
                let data = await get(url);
                if (data.status !== 200) {
                    that.newsData = [{
                        "newsName": "暂无数据",
                        "newsFrom": "暂无数据",
                        "newsUrl": "暂无数据",
                        "newsFace": "暂无数据"
                    }];
                    return;
                }
                that.newsData = data.data;
            })();
        },

        deleteNews(id) {
            let that = this;
            let flag = confirm(`确定删除 ${id}`);
            if (flag) {
                let url = API.NEWS_API.DELETE;
                post(url, {
                    newsId: id
                }).then(e => {
                    console.log(e);
                    // noinspection JSUnresolvedFunction
                    that.$message({
                        type: 'success',
                        showClose: true,
                        message: '删除成功'
                    });
                    that.refresh();
                }).catch(e => {
                    console.log(e);
                    // noinspection JSUnresolvedFunction
                    that.$message({
                        type: 'error',
                        showClose: true,
                        message: '删除失败：服务器异常'
                    });
                });
            } else {
                // noinspection JSUnresolvedFunction
                that.$message({
                    showClose: true,
                    message: '操作取消'
                });
            }
        },
        addNews() {
            let that = this;
            let name = that.inputName;
            let from = that.inputFrom;
            let url = that.inputUrl;
            let coverUrl = that.inputCoverUrl;
            if (name.trim() === '' || url.trim() === '' || from.trim() === '' || coverUrl.trim() === '') {
                // noinspection JSUnresolvedFunction
                this.$message({
                    showClose: true,
                    message: `请输入`
                });
            } else {
                post(API.NEWS_API.ADD, {
                    newsName: name,
                    newsFrom: from,
                    newsUrl: url,
                    newsFace: coverUrl
                }).then(e => {
                    if (e.status === 200) {
                        // noinspection JSUnresolvedFunction
                        that.$message({
                            type: 'success',
                            showClose: true,
                            message: '添加成功'
                        });
                        that.refresh();
                        that.inputName = '';
                        that.inputFrom = '';
                        that.inputUrl = '';
                        that.inputCoverUrl = '';
                    } else {
                        // noinspection JSUnresolvedFunction
                        that.$message({
                            type: 'error',
                            showClose: true,
                            message: '添加失败：服务器异常'
                        });
                    }
                }).catch(e => {
                    console.log(e);
                    // noinspection JSUnresolvedFunction
                    that.$message({
                        type: 'error',
                        showClose: true,
                        message: '添加失败：服务器异常'
                    });
                });
            }
        }
    }
};
// noinspection JSUnresolvedVariable
let CtorNewsTable = Vue.extend(newsTable);
new CtorNewsTable().$mount('#news-table');


// 视频管理
// noinspection JSUnusedGlobalSymbols,ES6ShorthandObjectProperty
let videoTable = {
    data() {
        return {
            videoData: [{
                "videoId": "id",
                "videoName": "正在获取...",
                "videoUrl": "正在获取..."
            }],
            inputName: '',
            inputUrl: ''
        }
    },
    created() {
        // 加载视频数据
        this.refresh();
    },
    methods: {
        async deleteVideo(id) {
            let that = this;
            let flag = confirm(`确定删除 ${id}`);
            if (flag) {
                let url = API.VIDEO_API.DELETE;
                get(url, {
                    videoId: id
                }).then(e => {
                    console.log(e);
                    // noinspection JSUnresolvedFunction
                    that.$message({
                        type: 'success',
                        showClose: true,
                        message: '删除成功'
                    });

                    that.refresh();
                }).catch(e => {
                    console.log(e);
                    // noinspection JSUnresolvedFunction
                    that.$message({
                        type: 'error',
                        showClose: true,
                        message: '删除失败：服务器异常'
                    });
                });
            } else {
                // noinspection JSUnresolvedFunction
                that.$message({
                    showClose: true,
                    message: '操作取消'
                });
            }
        },
        handleClick(a) {
            console.log(a);
        },
        refresh() {
            let that = this;
            (async function () {
                let url = API.VIDEO_API.ALL;
                let data = await get(url);
                that.videoData = data.data;
            })();
        },
        addVideo() {
            let that = this;
            let name = that.inputName;
            let url = that.inputUrl;
            if (name.trim() === '' || url.trim() === '') {
                // noinspection JSUnresolvedFunction
                this.$message({
                    showClose: true,
                    message: `请输入`
                });
            } else {
                post(API.VIDEO_API.ADD, {
                    videoName: name,
                    videoUrl: url
                }).then(e => {
                    if (e.status === 200) {
                        // noinspection JSUnresolvedFunction
                        that.$message({
                            type: 'success',
                            showClose: true,
                            message: '添加成功'
                        });
                        that.refresh();
                        that.inputName = '';
                        that.inputUrl = '';
                    } else {
                        // noinspection JSUnresolvedFunction
                        that.$message({
                            type: 'error',
                            showClose: true,
                            message: '添加失败：服务器异常'
                        });
                    }
                }).catch(e => {
                    console.log(e);
                    // noinspection JSUnresolvedFunction
                    that.$message({
                        type: 'error',
                        showClose: true,
                        message: '添加失败：服务器异常'
                    });
                });
            }
        }
    }
};
// noinspection JSUnresolvedVariable
let CtorVideoTable = Vue.extend(videoTable);
new CtorVideoTable().$mount('#video-table');


// 知识管理
// noinspection JSUnusedGlobalSymbols,ES6ShorthandObjectProperty
let festivalTable = {
    data() {
        return {
            festivalData: [{
                "holidayId": "id",
                "holidayName": "正在获取...",
                "holidayDate": "正在获取...",
                "holidayReason": "正在获取...",
            }],
            inputName: '',
            inputDate: '',
            inputDesc: '',
        }
    },
    created() {
        // 加载视频数据
        this.refresh();
    },
    methods: {
        handleClick(a) {
            console.log(a);
        },

        refresh() {
            let that = this;
            (async function () {
                let url = API.FESTIVAL_API.ALL;
                let data = await get(url);
                that.festivalData = data.data;
            })();
        },

        deleteFestival(id) {
            let _this = this;
            let flag = confirm(`确定删除 ${id}`);
            if (flag) {
                let url = API.FESTIVAL_API.DELETE;
                post(url, {
                    holidayId: id
                }).then(e => {
                    console.log(e);
                    // noinspection JSUnresolvedFunction
                    _this.$message({
                        type: 'success',
                        showClose: true,
                        message: '删除成功'
                    });

                    _this.refresh();
                }).catch(e => {
                    console.log(e);
                    // noinspection JSUnresolvedFunction
                    _this.$message({
                        type: 'error',
                        showClose: true,
                        message: '删除失败：服务器异常'
                    });
                });
            } else {
                // noinspection JSUnresolvedFunction
                _this.$message({
                    showClose: true,
                    message: '操作取消'
                });
            }
        },

        addFestival() {
            let that = this;
            let name = that.inputName;
            let date = that.inputDate;
            let desc = that.inputDesc;
            if (name.trim() === '' || date.trim() === '' || desc.trim() === '') {
                // noinspection JSUnresolvedFunction
                this.$message({
                    showClose: true,
                    message: `请输入`
                });
            } else {
                post(API.FESTIVAL_API.ADD, {
                    holidayName: name,
                    holidayDate: date,
                    holidayReason: desc,
                }).then(e => {
                    if (e.status === 200) {
                        // noinspection JSUnresolvedFunction
                        that.$message({
                            type: 'success',
                            showClose: true,
                            message: '添加成功'
                        });
                        that.refresh();
                        that.inputName = '';
                        that.inputDate = '';
                        that.inputDesc = '';
                    } else {
                        // noinspection JSUnresolvedFunction
                        that.$message({
                            type: 'error',
                            showClose: true,
                            message: '添加失败：服务器异常'
                        });
                    }
                }).catch(e => {
                    console.log(e);
                    // noinspection JSUnresolvedFunction
                    that.$message({
                        type: 'error',
                        showClose: true,
                        message: '添加失败：服务器异常'
                    });
                });
            }
        }

    }
};
// noinspection JSUnresolvedVariable
let CtorFestivalTable = Vue.extend(festivalTable);
new CtorFestivalTable().$mount('#festival-table');