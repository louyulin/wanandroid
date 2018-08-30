# 利用鸿洋大神 Wandroid开放接口 制作手机端平台
### 真的很喜欢羊神做的这个网站,因此为了方便自己学习就动手做了一下 喜欢的给个start吧

#### 用现在比较流行的mvp+rxjava+retrofit设计

其实项目本身难度并不大 关键是做出来之后感觉确实很实用,更方便了自己的学习,再次感谢羊神做了这么好的网站

[同步博客地址:http://blog.csdn.net/louyulin/article/details/79074121](http://blog.csdn.net/louyulin/article/details/79074121)

[鸿洋大神的api接口,大家可以自己来动手做一个](http://www.wanandroid.com/blog/show/2)

#### 具体功能
* 用户登录注册本地化cookies
* 知识体系列表
* 关键字热词搜索
* 收藏与分享

不知道写啥了撸点截图吧:

![图片](http://img.blog.csdn.net/20180116140812278?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbG91eXVsaW4=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![图片](http://img.blog.csdn.net/20180116141514368)
![图片](http://img.blog.csdn.net/20180116141339462)
![图片](http://img.blog.csdn.net/20180116141423898)
![图片](http://img.blog.csdn.net/20180116141446853)

网络工具类:

    public class NetTool {
        public static NetTool instance;
        private Retrofit retrofit;
        private final Api api;


        public Api getApi() {
            return api;
        }


        private NetTool() {



            //初始化Retrofit
            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseContent.baseUrl)
                    .client(OkHttpClientManger.getOkHttpClient())
                    //给Retrofit添加Gson解析功能
                    .addConverterFactory(GsonConverterFactory.create())
                    //给Retrofit添加Rxjava功能
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            //初始化Retrofit的Api接口
            api = retrofit.create(Api.class);
        }

        //线程锁单例
        public static NetTool getInstance() {
            if (instance == null) {
                synchronized (NetTool.class) {
                    if (instance == null) {
                        instance = new NetTool();
                    }
                }
            }
            return instance;
        }
    }


cookie管理:

    public class WanAndroidCookieJar implements CookieJar {
        private static final String TAG = "WanAndroidCookieJar";

        private static HashMap<String, List<Cookie>> map = new HashMap<>();

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            Log.i(TAG, "saveFromResponse: " + url);
            Log.i(TAG, "saveFromResponse: " + cookies);
            map.put(url.host(), cookies);
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            List<Cookie> cookies = map.get(url.host());
            Log.i(TAG, "loadForRequest: " + url);
            Log.i(TAG, "loadForRequest: " + cookies);
            return cookies != null ? cookies : new ArrayList<Cookie>();
        }

        public static void clearCookie() {
            map.clear();
        }
    }


