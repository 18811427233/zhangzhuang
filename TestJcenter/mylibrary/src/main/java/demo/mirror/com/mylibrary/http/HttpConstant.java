package demo.mirror.com.mylibrary.http;

/**
 * 网络请求常量
 * Created by lihaotian on 2016/11/25.
 */

public class HttpConstant {

//    http://101.200.162.216:84/index.php?s=/home/user/login
//    cast_app_android
//    123456

//    http://115.29.43.27:8017/oam/account/login
//    admin
//    111111w

    //1
//    private static final String BASE_PATH = "http://115.29.43.27:8013/api/";

    //2
    private static final String BASE_PATH = "http://118.190.93.145:8017/api/";

//    private static final String BASE_PATH = "http://kxdgy.mirror-networks.com/api/";

    /* 首页接口 */
    //首页轮播图片
    public static final String PATH_CAROUSEL_LIST = BASE_PATH + "carousel/list";
    //首页类型列表
    public static final String PATH_MUSEUM_LIST_TYPE = BASE_PATH + "museum/list/type";
    //首页推荐列表
    public static final String PATH_MUSEUM_LIST_RECOMMEND = BASE_PATH + "museum/list/recommend";
    //活动详情
    public static final String PATH_ACTIVITY_RETRIEVE = BASE_PATH + "activity/retrieve/";
    //收藏活动
    public static final String PATH_COLLECT_ACTIVITY = BASE_PATH + "collect/activity";
    //点赞活动
    public static final String PATH_UP_ACTIVITY = BASE_PATH + "up/activity";

    /* 用户接口 */
    //登录
    public static final String PATH_USER_LOGIN = BASE_PATH + "user/login";
    //微信登录
    public static final String PATH_USER_LOGIN_WX = BASE_PATH + "user/login/wx";
    //QQ登录
    public static final String PATH_USER_LOGIN_QQ = BASE_PATH + "user/login/qq";
    //上传文件
    public static final String PATH_FILE_UPLOAD = BASE_PATH + "file/upload";
    //完善信息 注册
    public static final String PATH_USER_CREATE = BASE_PATH + "user/create";
    //获取短信验证码
    public static final String PATH_USER_CODE = BASE_PATH + "user/code";
    //验证验证码
    public static final String PATH_USER_CODE_CHECK = BASE_PATH + "user/code/check";
    //忘记密码 获取短信验证码
    public static final String PATH_USER_FORGET_CODE = BASE_PATH + "user/forget/code";
    //忘记密码 验证验证码
    public static final String PATH_USER_FORGET_CODE_CHECK = BASE_PATH + "user/forget/code/check";
    //重置密码
    public static final String PATH_USER_FORGET_PASSWORD = BASE_PATH + "user/forget/password";
    //退出登录
    public static final String PATH_USER_LOGOUT = BASE_PATH + "user/logout";

    /* 基地 */
    //基地搜索
    public static final String PATH_MUSEUM_LIST_NAME = BASE_PATH + "museum/list/name";
    //热搜
    public static final String PATH_KEYWORD_LIST = BASE_PATH + "keyword/list";
    //基地列表
    public static final String PATH_MUSEUM_LIST_CITY = BASE_PATH + "museum/list/city";
    //地图搜索
    public static final String PATH_MUSEUM_LIST_COORDINATE = BASE_PATH + "museum/list/coordinate";
    //地图基地详情
    public static final String PATH_MUSEUM_RETRIEVE_ADDRESS = BASE_PATH + "museum/retrieve/address/";
    //基地详情
    public static final String PATH_MUSEUM_RETRIEVE = BASE_PATH + "museum/retrieve/";
    //展览详情
    public static final String PATH_EXHIBITION_RETRIEVE = BASE_PATH + "exhibition/retrieve/";
    //收藏基地
    public static final String PATH_COLLECT_MUSEUM = BASE_PATH + "collect/museum";
    //点赞基地
    public static final String PATH_UP_MUSEUM = BASE_PATH + "up/museum";
    //收藏展览
    public static final String PATH_COLLECT_EXHIBITION = BASE_PATH + "collect/exhibition";
    //点赞展览
    public static final String PATH_UP_EXHIBITION = BASE_PATH + "up/exhibition";
    // 视频分类
    public static final String PATH_MUSEUM_LIST_VIDEO = BASE_PATH + "museum/list/video";

    /* 我的 */
    //修改头像
    public static final String PATH_USER_CHANGE_PORTRAIT = BASE_PATH + "user/change/portrait";
    //修改用户昵称
    public static final String PATH_USER_CHANGE_USERNAME = BASE_PATH + "user/change/username";
    //修改手机号
    public static final String PATH_USER_CHANGE_TELEPHONE = BASE_PATH + "user/change/telephone";
    //修改密码
    public static final String PATH_USER_CHANGE_PASSWORD = BASE_PATH + "user/change/password";
    //基地收藏列表
    public static final String PATH_COLLECT_LIST_MUSEUM = BASE_PATH + "collect/list/museum";
    //展览收藏列表
    public static final String PATH_COLLECT_LIST_EXHIBITION = BASE_PATH + "collect/list/exhibition";
    //活动收藏列表
    public static final String PATH_COLLECT_LIST_ACTIVITY = BASE_PATH + "collect/list/activity";
    //删除单个收藏
    public static final String PATH_COLLECT_DELETE = BASE_PATH + "collect/delete";
    //清空基地
    public static final String PATH_COLLECT_CLEAN_MUSEUM = BASE_PATH + "collect/clean/museum";
    //清空展览
    public static final String PATH_COLLECT_CLEAN_EXHIBITION = BASE_PATH + "collect/clean/exhibition";
    //清空活动
    public static final String PATH_COLLECT_CLEAN_ACTIVITY = BASE_PATH + "collect/clean/activity";
    //浏览记录
    public static final String PATH_SCAN_LIST_MUSEUM = BASE_PATH + "scan/list/museum";
    //意见反馈
    public static final String PATH_FEEDBACK_CREATE = BASE_PATH + "feedback/create";
}
