package com.example.lyl.wandroid.modle.bean;

import java.util.List;

/**
 * Created by dllo on 18/1/11.
 */

public class HomeArticalBean {

    @Override
    public String toString() {
        return "HomeArticalBean{" +
                "errorCode=" + errorCode +
                ", errorMsg=" + errorMsg +
                ", data=" + data +
                '}';
    }

    /**
     * errorCode : 0
     * errorMsg : null
     * data : {"datas":[{"id":2038,"title":"尼古拉斯.赵四","chapterId":274,"chapterName":"个人博客","envelopePic":null,"link":"http://www.wjdiankong.cn/","author":"小编","origin":null,"publishTime":1515642561000,"zan":null,"desc":null,"visible":1,"niceDate":"6小时前","courseId":13,"collect":false},{"id":2037,"title":"推荐几个优质完整项目","chapterId":249,"chapterName":"干货资源","envelopePic":null,"link":"https://mp.weixin.qq.com/s/7ffZB0_RB90i5c60bEYRWg","author":"鸿洋","origin":null,"publishTime":1515642240000,"zan":null,"desc":null,"visible":1,"niceDate":"6小时前","courseId":13,"collect":false},{"id":2036,"title":"剖析Activity、Window、ViewRootImpl和View之间的关系","chapterId":10,"chapterName":"Activity","envelopePic":null,"link":"https://mp.weixin.qq.com/s/-5lyASIaSFV6wG3wfMS9Yg","author":"豆沙包67","origin":null,"publishTime":1515642222000,"zan":null,"desc":null,"visible":1,"niceDate":"6小时前","courseId":13,"collect":false},{"id":2035,"title":"我的2017总结的笔记","chapterId":249,"chapterName":"干货资源","envelopePic":null,"link":"https://mp.weixin.qq.com/s/bhCnPcQ1klgR-GHXpwihIA","author":"请叫我大苏","origin":null,"publishTime":1515642198000,"zan":null,"desc":null,"visible":1,"niceDate":"6小时前","courseId":13,"collect":false},{"id":2034,"title":"仿新版微信的小程序下拉栏","chapterId":99,"chapterName":"具体案例","envelopePic":null,"link":"https://mp.weixin.qq.com/s/YQq2-K7Tbr7Q4zogJcPdJw","author":"大头呆","origin":null,"publishTime":1515642172000,"zan":null,"desc":null,"visible":1,"niceDate":"6小时前","courseId":13,"collect":false},{"id":1990,"title":"天猫客户端组件动态化的方案\u2014\u2014VirtualView 上手体验","chapterId":79,"chapterName":"黑科技","envelopePic":null,"link":"https://juejin.im/post/5a54a44a6fb9a01cc1223399","author":"Longerian","origin":null,"publishTime":1515510819000,"zan":null,"desc":null,"visible":1,"niceDate":"1天前","courseId":13,"collect":true},{"id":1989,"title":"Android 弧形ViewPager 和弧形HeaderView（升级版）","chapterId":121,"chapterName":"ViewPager","envelopePic":null,"link":"https://juejin.im/post/5a537bf4518825734a7489bd","author":"依然饭特稀西","origin":null,"publishTime":1515510726000,"zan":null,"desc":null,"visible":1,"niceDate":"1天前","courseId":13,"collect":true},{"id":1956,"title":"被后台杀死后，Android应用如何重新走闪屏逻辑","chapterId":268,"chapterName":"优秀的设计","envelopePic":null,"link":"http://www.jianshu.com/p/4fc10026c1f8","author":"看书的小蜗牛","origin":null,"publishTime":1515510687000,"zan":null,"desc":null,"visible":1,"niceDate":"1天前","courseId":13,"collect":true},{"id":1955,"title":"WebView想说爱你不容易啊","chapterId":98,"chapterName":"WebView","envelopePic":null,"link":"http://www.jianshu.com/p/79d79b8cbcfc","author":"Me豪","origin":null,"publishTime":1515510671000,"zan":null,"desc":null,"visible":1,"niceDate":"1天前","courseId":13,"collect":true},{"id":1638,"title":"微博的文本编辑和显示(emoji表情，@某人、链接高亮点击)","chapterId":26,"chapterName":"基础UI控件","envelopePic":null,"link":"http://www.jianshu.com/p/cd9e197a5c04","author":"恋猫月亮","origin":null,"publishTime":1515510626000,"zan":null,"desc":null,"visible":1,"niceDate":"1天前","courseId":13,"collect":true},{"id":1986,"title":"Android6.0权限适配及兼容库的实现","chapterId":192,"chapterName":"权限管理","envelopePic":null,"link":"http://www.jianshu.com/p/feb6dd8d2212","author":"看书的小蜗牛","origin":null,"publishTime":1515422087000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":true},{"id":1981,"title":"Android后台杀死系列之三：LowMemoryKiller原理（4.3-6.0）","chapterId":171,"chapterName":"binder","envelopePic":null,"link":"http://www.jianshu.com/p/23cf3199f606","author":"看书的小蜗牛","origin":null,"publishTime":1515422086000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":true},{"id":1982,"title":"Android后台杀死系列之二：ActivityManagerService与App现场恢复机制","chapterId":233,"chapterName":"framework-四大组件","envelopePic":null,"link":"http://www.jianshu.com/p/e3612a9b1af3","author":"看书的小蜗牛","origin":null,"publishTime":1515422086000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":true},{"id":1983,"title":"Android后台杀死系列之一：FragmentActivity及PhoneWindow后台杀死处理机制","chapterId":233,"chapterName":"framework-四大组件","envelopePic":null,"link":"http://www.jianshu.com/p/00fef8872b68","author":"看书的小蜗牛","origin":null,"publishTime":1515422086000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1984,"title":"RecyclerView定制：通用ItemDecoration及全展开RecyclerView的实现","chapterId":100,"chapterName":"RecyclerView","envelopePic":null,"link":"http://www.jianshu.com/p/4f554aba2bec","author":"看书的小蜗牛","origin":null,"publishTime":1515422086000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1979,"title":"听说你Binder机制学的不错，来面试下这几个问题（二）","chapterId":171,"chapterName":"binder","envelopePic":null,"link":"http://www.jianshu.com/p/fa652f57a552","author":"看书的小蜗牛","origin":null,"publishTime":1515422083000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1980,"title":"听说你Binder机制学的不错，来面试下这几个问题（一）","chapterId":171,"chapterName":"binder","envelopePic":null,"link":"http://www.jianshu.com/p/adaa1a39a274","author":"看书的小蜗牛","origin":null,"publishTime":1515422083000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1977,"title":"Android后台杀死系列之四：Binder讣告原理","chapterId":171,"chapterName":"binder","envelopePic":null,"link":"http://www.jianshu.com/p/2a46eec33c5c","author":"看书的小蜗牛","origin":null,"publishTime":1515422082000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1978,"title":"听说你Binder机制学的不错，来面试下这几个问题（三）","chapterId":171,"chapterName":"binder","envelopePic":null,"link":"http://www.jianshu.com/p/9128f1b65586","author":"看书的小蜗牛","origin":null,"publishTime":1515422082000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1953,"title":"我们一起来聊聊内存优化","chapterId":78,"chapterName":"性能优化","envelopePic":null,"link":"http://www.jianshu.com/p/6d578b64c39c","author":"Me豪","origin":null,"publishTime":1515422071000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false}],"offset":0,"size":20,"total":963,"pageCount":49,"curPage":1,"over":false}
     */

    private int errorCode;
    private Object errorMsg;
    private DataBean data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "offset=" + offset +
                    ", size=" + size +
                    ", total=" + total +
                    ", pageCount=" + pageCount +
                    ", curPage=" + curPage +
                    ", over=" + over +
                    ", datas=" + datas +
                    '}';
        }

        /**
         * datas : [{"id":2038,"title":"尼古拉斯.赵四","chapterId":274,"chapterName":"个人博客","envelopePic":null,"link":"http://www.wjdiankong.cn/","author":"小编","origin":null,"publishTime":1515642561000,"zan":null,"desc":null,"visible":1,"niceDate":"6小时前","courseId":13,"collect":false},{"id":2037,"title":"推荐几个优质完整项目","chapterId":249,"chapterName":"干货资源","envelopePic":null,"link":"https://mp.weixin.qq.com/s/7ffZB0_RB90i5c60bEYRWg","author":"鸿洋","origin":null,"publishTime":1515642240000,"zan":null,"desc":null,"visible":1,"niceDate":"6小时前","courseId":13,"collect":false},{"id":2036,"title":"剖析Activity、Window、ViewRootImpl和View之间的关系","chapterId":10,"chapterName":"Activity","envelopePic":null,"link":"https://mp.weixin.qq.com/s/-5lyASIaSFV6wG3wfMS9Yg","author":"豆沙包67","origin":null,"publishTime":1515642222000,"zan":null,"desc":null,"visible":1,"niceDate":"6小时前","courseId":13,"collect":false},{"id":2035,"title":"我的2017总结的笔记","chapterId":249,"chapterName":"干货资源","envelopePic":null,"link":"https://mp.weixin.qq.com/s/bhCnPcQ1klgR-GHXpwihIA","author":"请叫我大苏","origin":null,"publishTime":1515642198000,"zan":null,"desc":null,"visible":1,"niceDate":"6小时前","courseId":13,"collect":false},{"id":2034,"title":"仿新版微信的小程序下拉栏","chapterId":99,"chapterName":"具体案例","envelopePic":null,"link":"https://mp.weixin.qq.com/s/YQq2-K7Tbr7Q4zogJcPdJw","author":"大头呆","origin":null,"publishTime":1515642172000,"zan":null,"desc":null,"visible":1,"niceDate":"6小时前","courseId":13,"collect":false},{"id":1990,"title":"天猫客户端组件动态化的方案\u2014\u2014VirtualView 上手体验","chapterId":79,"chapterName":"黑科技","envelopePic":null,"link":"https://juejin.im/post/5a54a44a6fb9a01cc1223399","author":"Longerian","origin":null,"publishTime":1515510819000,"zan":null,"desc":null,"visible":1,"niceDate":"1天前","courseId":13,"collect":true},{"id":1989,"title":"Android 弧形ViewPager 和弧形HeaderView（升级版）","chapterId":121,"chapterName":"ViewPager","envelopePic":null,"link":"https://juejin.im/post/5a537bf4518825734a7489bd","author":"依然饭特稀西","origin":null,"publishTime":1515510726000,"zan":null,"desc":null,"visible":1,"niceDate":"1天前","courseId":13,"collect":true},{"id":1956,"title":"被后台杀死后，Android应用如何重新走闪屏逻辑","chapterId":268,"chapterName":"优秀的设计","envelopePic":null,"link":"http://www.jianshu.com/p/4fc10026c1f8","author":"看书的小蜗牛","origin":null,"publishTime":1515510687000,"zan":null,"desc":null,"visible":1,"niceDate":"1天前","courseId":13,"collect":true},{"id":1955,"title":"WebView想说爱你不容易啊","chapterId":98,"chapterName":"WebView","envelopePic":null,"link":"http://www.jianshu.com/p/79d79b8cbcfc","author":"Me豪","origin":null,"publishTime":1515510671000,"zan":null,"desc":null,"visible":1,"niceDate":"1天前","courseId":13,"collect":true},{"id":1638,"title":"微博的文本编辑和显示(emoji表情，@某人、链接高亮点击)","chapterId":26,"chapterName":"基础UI控件","envelopePic":null,"link":"http://www.jianshu.com/p/cd9e197a5c04","author":"恋猫月亮","origin":null,"publishTime":1515510626000,"zan":null,"desc":null,"visible":1,"niceDate":"1天前","courseId":13,"collect":true},{"id":1986,"title":"Android6.0权限适配及兼容库的实现","chapterId":192,"chapterName":"权限管理","envelopePic":null,"link":"http://www.jianshu.com/p/feb6dd8d2212","author":"看书的小蜗牛","origin":null,"publishTime":1515422087000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":true},{"id":1981,"title":"Android后台杀死系列之三：LowMemoryKiller原理（4.3-6.0）","chapterId":171,"chapterName":"binder","envelopePic":null,"link":"http://www.jianshu.com/p/23cf3199f606","author":"看书的小蜗牛","origin":null,"publishTime":1515422086000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":true},{"id":1982,"title":"Android后台杀死系列之二：ActivityManagerService与App现场恢复机制","chapterId":233,"chapterName":"framework-四大组件","envelopePic":null,"link":"http://www.jianshu.com/p/e3612a9b1af3","author":"看书的小蜗牛","origin":null,"publishTime":1515422086000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":true},{"id":1983,"title":"Android后台杀死系列之一：FragmentActivity及PhoneWindow后台杀死处理机制","chapterId":233,"chapterName":"framework-四大组件","envelopePic":null,"link":"http://www.jianshu.com/p/00fef8872b68","author":"看书的小蜗牛","origin":null,"publishTime":1515422086000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1984,"title":"RecyclerView定制：通用ItemDecoration及全展开RecyclerView的实现","chapterId":100,"chapterName":"RecyclerView","envelopePic":null,"link":"http://www.jianshu.com/p/4f554aba2bec","author":"看书的小蜗牛","origin":null,"publishTime":1515422086000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1979,"title":"听说你Binder机制学的不错，来面试下这几个问题（二）","chapterId":171,"chapterName":"binder","envelopePic":null,"link":"http://www.jianshu.com/p/fa652f57a552","author":"看书的小蜗牛","origin":null,"publishTime":1515422083000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1980,"title":"听说你Binder机制学的不错，来面试下这几个问题（一）","chapterId":171,"chapterName":"binder","envelopePic":null,"link":"http://www.jianshu.com/p/adaa1a39a274","author":"看书的小蜗牛","origin":null,"publishTime":1515422083000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1977,"title":"Android后台杀死系列之四：Binder讣告原理","chapterId":171,"chapterName":"binder","envelopePic":null,"link":"http://www.jianshu.com/p/2a46eec33c5c","author":"看书的小蜗牛","origin":null,"publishTime":1515422082000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1978,"title":"听说你Binder机制学的不错，来面试下这几个问题（三）","chapterId":171,"chapterName":"binder","envelopePic":null,"link":"http://www.jianshu.com/p/9128f1b65586","author":"看书的小蜗牛","origin":null,"publishTime":1515422082000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false},{"id":1953,"title":"我们一起来聊聊内存优化","chapterId":78,"chapterName":"性能优化","envelopePic":null,"link":"http://www.jianshu.com/p/6d578b64c39c","author":"Me豪","origin":null,"publishTime":1515422071000,"zan":null,"desc":null,"visible":1,"niceDate":"2天前","courseId":13,"collect":false}]
         * offset : 0
         * size : 20
         * total : 963
         * pageCount : 49
         * curPage : 1
         * over : false
         */

        private int offset;
        private int size;
        private int total;
        private int pageCount;
        private int curPage;
        private boolean over;
        private List<DatasBean> datas;

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * id : 2038
             * title : 尼古拉斯.赵四
             * chapterId : 274
             * chapterName : 个人博客
             * envelopePic : null
             * link : http://www.wjdiankong.cn/
             * author : 小编
             * origin : null
             * publishTime : 1515642561000
             * zan : null
             * desc : null
             * visible : 1
             * niceDate : 6小时前
             * courseId : 13
             * collect : false
             */

            private int id;
            private String title;
            private int chapterId;
            private String chapterName;
            private Object envelopePic;
            private String link;
            private String author;
            private Object origin;
            private long publishTime;
            private Object zan;
            private Object desc;
            private int visible;
            private String niceDate;
            private int courseId;
            private boolean collect;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public Object getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(Object envelopePic) {
                this.envelopePic = envelopePic;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public Object getOrigin() {
                return origin;
            }

            public void setOrigin(Object origin) {
                this.origin = origin;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public Object getZan() {
                return zan;
            }

            public void setZan(Object zan) {
                this.zan = zan;
            }

            public Object getDesc() {
                return desc;
            }

            public void setDesc(Object desc) {
                this.desc = desc;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }
        }
    }
}
