@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.UNIC512840;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesMyMy : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(_: OnLoadOptions) {
            this.loadAdsenses();
        }
        , instance);
        onPageShow(fun() {
            getUserInfo(false);
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_status_bar = resolveEasyComponent("status-bar", GenComponentsStatusBarStatusBarClass);
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        val _component_navigator = resolveComponent("navigator");
        val _component_cell = resolveEasyComponent("cell", GenComponentsCellCellClass);
        val _component_icon_btn = resolveEasyComponent("icon-btn", GenComponentsIconBtnIconBtnClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_status_bar),
            createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
                if (isTrue(!_ctx.loginState)) {
                    createElementVNode(Fragment, utsMapOf("key" to 0), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "my-panel"), utsArrayOf(
                            createElementVNode("view", null, utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "nologin-title"), "欢迎来到帝莎编程社区"),
                                createElementVNode("text", utsMapOf("class" to "nologin-info"), "马上登录跟大家一起嗨"),
                                createVNode(_component_main_btn, utsMapOf("onClick" to fun(){
                                    _ctx.open("user-login");
                                }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        "登录/注册"
                                    );
                                }), "_" to 1), 8, utsArrayOf(
                                    "onClick"
                                ))
                            )),
                            createElementVNode("image", utsMapOf("src" to default5, "mode" to "aspectFill", "fade-show" to true, "class" to "nologin-img"))
                        )),
                        createElementVNode("view", utsMapOf("class" to "divider"))
                    ), 64);
                } else {
                    createElementVNode(Fragment, utsMapOf("key" to 1), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "my-panel"), utsArrayOf(
                            createVNode(_component_avatar, utsMapOf("src" to _ctx.avatar, "width" to "148rpx", "height" to "148rpx", "style" to normalizeStyle(utsMapOf("margin-right" to "25rpx")), "onClick" to fun(){
                                _ctx.openMySpace();
                            }
                            ), null, 8, utsArrayOf(
                                "src",
                                "style",
                                "onClick"
                            )),
                            createElementVNode("view", utsMapOf("class" to "my-panel-box"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "my-nickname", "onClick" to fun(){
                                    _ctx.openMySpace();
                                }
                                ), toDisplayString(_ctx.name), 9, utsArrayOf(
                                    "onClick"
                                )),
                                createElementVNode("view", utsMapOf("class" to "my-info"), utsArrayOf(
                                    createVNode(_component_navigator, utsMapOf("class" to "flex", "url" to ("/pages/user-follow-list/user-follow-list?user_id=" + _ctx.id)), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "my-info-label"), "关注"),
                                            createElementVNode("text", utsMapOf("class" to "my-info-value"), toDisplayString(_ctx.follows_count), 1)
                                        );
                                    }
                                    ), "_" to 1), 8, utsArrayOf(
                                        "url"
                                    )),
                                    createVNode(_component_navigator, utsMapOf("class" to "flex", "url" to ("/pages/user-fans-list/user-fans-list?user_id=" + _ctx.id)), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "my-info-label"), "粉丝"),
                                            createElementVNode("text", utsMapOf("class" to "my-info-value"), toDisplayString(_ctx.fans_count), 1)
                                        );
                                    }
                                    ), "_" to 1), 8, utsArrayOf(
                                        "url"
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "flex", "onClick" to fun(){
                                        _ctx.openMySpace();
                                    }
                                    ), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "my-info-label"), "帖子"),
                                        createElementVNode("text", utsMapOf("class" to "my-info-value"), toDisplayString(_ctx.articles_count), 1)
                                    ), 8, utsArrayOf(
                                        "onClick"
                                    ))
                                ))
                            )),
                            createElementVNode("text", utsMapOf("class" to "my-panel-btn", "onClick" to fun(){
                                _ctx.openMySpace();
                            }
                            ), "个人主页", 8, utsArrayOf(
                                "onClick"
                            ))
                        )),
                        createElementVNode("view", utsMapOf("class" to "my-card-section"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "my-card", "onClick" to _ctx.openMySpace), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "my-card-title"), "帖子"),
                                createElementVNode("text", utsMapOf("class" to "my-card-info"), "我发布的"),
                                createElementVNode("image", utsMapOf("src" to default6, "mode" to "aspectFill", "class" to "my-card-img"))
                            ), 8, utsArrayOf(
                                "onClick"
                            )),
                            createElementVNode("view", utsMapOf("class" to "my-card", "onClick" to _ctx.openMySpace), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "my-card-title"), "评论"),
                                createElementVNode("text", utsMapOf("class" to "my-card-info"), "我发布的"),
                                createElementVNode("image", utsMapOf("src" to default7, "mode" to "aspectFill", "class" to "my-card-img"))
                            ), 8, utsArrayOf(
                                "onClick"
                            )),
                            createElementVNode("view", utsMapOf("class" to "my-card", "onClick" to fun(){
                                _ctx.open("my-collection");
                            }
                            ), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "my-card-title"), "收藏"),
                                createElementVNode("text", utsMapOf("class" to "my-card-info"), "我收藏的"),
                                createElementVNode("image", utsMapOf("src" to default8, "mode" to "aspectFill", "class" to "my-card-img"))
                            ), 8, utsArrayOf(
                                "onClick"
                            ))
                        ))
                    ), 64);
                }
                ,
                createElementVNode("swiper", utsMapOf("indicator-dots" to true, "autoplay" to true, "interval" to 3000, "duration" to 1000, "circular" to true), utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.adsenses, fun(item, index, _, _): VNode {
                        return createElementVNode("swiper-item", utsMapOf("style" to normalizeStyle(utsMapOf("padding" to "15rpx 30rpx")), "key" to index, "onClick" to fun(){
                            _ctx.openWebview(item.url);
                        }
                        ), utsArrayOf(
                            createElementVNode("image", utsMapOf("src" to item.src, "mode" to "aspectFill", "fade-show" to true, "class" to "my-swiper-img"), null, 8, utsArrayOf(
                                "src"
                            ))
                        ), 12, utsArrayOf(
                            "onClick"
                        ));
                    }
                    ), 128)
                )),
                createVNode(_component_cell, utsMapOf("title" to "历史记录", "onClick" to fun(){
                    _ctx.open("user-history");
                }
                ), null, 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("view", utsMapOf("class" to "divider")),
                createVNode(_component_cell, utsMapOf("title" to "福利中心", "onClick" to _ctx.test), null, 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("view", utsMapOf("class" to "divider")),
                createVNode(_component_cell, utsMapOf("title" to "创作中心", "onClick" to _ctx.test), null, 8, utsArrayOf(
                    "onClick"
                )),
                createVNode(_component_cell, utsMapOf("title" to "原创特权", "onClick" to _ctx.test), null, 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("view", utsMapOf("class" to "divider")),
                createVNode(_component_cell, utsMapOf("title" to "更多功能", "hover" to false, "show-arrow" to false)),
                createElementVNode("view", utsMapOf("class" to "more"), utsArrayOf(
                    createVNode(_component_icon_btn, utsMapOf("column" to true, "icon" to "\ue62e", "label" to "黑名单", "width" to "187.5rpx", "style" to normalizeStyle(utsMapOf("margin-bottom" to "30rpx")), "onClick" to fun(){
                        _ctx.open("user-blacklist");
                    }
                    ), null, 8, utsArrayOf(
                        "style",
                        "onClick"
                    )),
                    createVNode(_component_icon_btn, utsMapOf("column" to true, "icon" to "\ue6f8", "label" to "意见反馈", "width" to "187.5rpx", "style" to normalizeStyle(utsMapOf("margin-bottom" to "30rpx")), "onClick" to fun(){
                        _ctx.open("user-feedback");
                    }
                    ), null, 8, utsArrayOf(
                        "style",
                        "onClick"
                    )),
                    createVNode(_component_icon_btn, utsMapOf("column" to true, "icon" to "\ue608", "label" to "设置", "width" to "187.5rpx", "style" to normalizeStyle(utsMapOf("margin-bottom" to "30rpx")), "onClick" to fun(){
                        _ctx.open("user-setting");
                    }
                    ), null, 8, utsArrayOf(
                        "style",
                        "onClick"
                    )),
                    createVNode(_component_icon_btn, utsMapOf("column" to true, "icon" to "\ueb97", "label" to "隐私设置", "width" to "187.5rpx", "style" to normalizeStyle(utsMapOf("margin-bottom" to "30rpx")), "onClick" to fun(){
                        _ctx.open("user-safe");
                    }
                    ), null, 8, utsArrayOf(
                        "style",
                        "onClick"
                    )),
                    createVNode(_component_icon_btn, utsMapOf("column" to true, "icon" to "\ue6f9", "label" to "神评鉴定", "width" to "187.5rpx", "style" to normalizeStyle(utsMapOf("margin-bottom" to "30rpx")), "onClick" to _ctx.test), null, 8, utsArrayOf(
                        "style",
                        "onClick"
                    ))
                ))
            ), 4)
        ), 64);
    }
    open var adsenses: UTSArray<AdsenseItem> by `$data`;
    open var loginState: Boolean by `$data`;
    open var id: Number by `$data`;
    open var name: String? by `$data`;
    open var avatar: String? by `$data`;
    open var fans_count: Number by `$data`;
    open var follows_count: Number by `$data`;
    open var articles_count: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("adsenses" to utsArrayOf<AdsenseItem>(), "loginState" to computed<Boolean>(fun(): Boolean {
            return uni.UNIC512840.loginState.value;
        }
        ), "id" to computed<Number>(fun(): Number {
            return userState.id;
        }
        ), "name" to computed<String?>(fun(): String? {
            return userState.name;
        }
        ), "avatar" to computed<String?>(fun(): String? {
            return userState.avatar;
        }
        ), "fans_count" to computed<Number>(fun(): Number {
            return userState.fans_count;
        }
        ), "follows_count" to computed<Number>(fun(): Number {
            return userState.follows_count;
        }
        ), "articles_count" to computed<Number>(fun(): Number {
            return userState.articles_count;
        }
        ));
    }
    override fun `$initMethods`() {
        this.test = fun() {
            uni_showToast(ShowToastOptions(title = "学完之后自己扩展", icon = "none"));
        }
        ;
        this.openMySpace = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/user-space/user-space?user_id=" + this.id));
        }
        ;
        this.loadAdsenses = fun() {
            uni_request<Result<UTSArray<AdsenseItem>>>(RequestOptions(url = getURL("/adsense/my"), success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                this.adsenses = r.data as UTSArray<AdsenseItem>;
            }
            , fail = fun(err){
                uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
            }
            ));
        }
        ;
        this.openWebview = fun(url: String) {
            uni_navigateTo(NavigateToOptions(url = "/pages/webview/webview?url=" + url));
        }
        ;
        this.open = fun(p: String) {
            var url = "/pages/" + p + "/" + p;
            if (p == "my-collection" || p == "user-history" || p == "user-feedback" || p == "user-blacklist" || p == "user-safe") {
                AuthNavigateTo("" + url + "?user_id=" + this.id);
                return;
            }
            uni_navigateTo(NavigateToOptions(url = url));
        }
        ;
    }
    open lateinit var test: () -> Unit;
    open lateinit var openMySpace: () -> Unit;
    open lateinit var loadAdsenses: () -> Unit;
    open lateinit var openWebview: (url: String) -> Unit;
    open lateinit var open: (p: String) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("my-panel" to padStyleMapOf(utsMapOf("flexDirection" to "row", "marginTop" to "65rpx", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "alignItems" to "center")), "nologin-title" to padStyleMapOf(utsMapOf("fontWeight" to "bold", "fontSize" to 20, "color" to "#171717", "marginBottom" to "20rpx")), "nologin-info" to padStyleMapOf(utsMapOf("color" to "#818181", "fontSize" to 13, "marginBottom" to "35rpx")), "nologin-img" to padStyleMapOf(utsMapOf("width" to "290rpx", "height" to "240rpx", "marginLeft" to "auto")), "my-swiper-img" to padStyleMapOf(utsMapOf("width" to "690rpx", "height" to "135rpx", "borderRadius" to 5)), "more" to padStyleMapOf(utsMapOf("flexDirection" to "row", "flexWrap" to "wrap", "paddingBottom" to "50rpx")), "my-panel-btn" to padStyleMapOf(utsMapOf("backgroundColor" to "#f7f6fb", "color" to "#333237", "fontSize" to 13, "borderTopLeftRadius" to 20, "borderBottomLeftRadius" to 20, "paddingTop" to "15rpx", "paddingRight" to "20rpx", "paddingBottom" to "15rpx", "paddingLeft" to "20rpx", "marginRight" to "-30rpx")), "my-panel-box" to padStyleMapOf(utsMapOf("flex" to 1)), "my-nickname" to padStyleMapOf(utsMapOf("fontSize" to 18, "fontWeight" to "bold", "marginBottom" to "20rpx", "color" to "#333333")), "my-info" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center")), "my-info-label" to padStyleMapOf(utsMapOf("fontSize" to 14)), "my-info-value" to padStyleMapOf(utsMapOf("fontSize" to 14, "fontWeight" to "bold", "marginLeft" to "12rpx", "marginRight" to "20rpx")), "my-card-section" to padStyleMapOf(utsMapOf("flexDirection" to "row", "paddingTop" to "38rpx", "paddingRight" to "30rpx", "paddingBottom" to "38rpx", "paddingLeft" to "30rpx")), "my-card" to padStyleMapOf(utsMapOf("height" to "115rpx", "flex" to 1, "borderRadius" to "5rpx", "paddingTop" to 0, "paddingRight" to "20rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx", "marginLeft" to "10rpx", "marginRight" to "10rpx", "boxShadow" to "0px 0px 6px rgba(0, 0, 0, 0.1)", "backgroundColor" to "#ffffff", "position" to "relative", "justifyContent" to "center")), "my-card-title" to padStyleMapOf(utsMapOf("fontSize" to 18, "fontWeight" to "bold", "color" to "#333333", "marginBottom" to "10rpx")), "my-card-info" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#686868")), "my-card-img" to padStyleMapOf(utsMapOf("position" to "absolute", "width" to "70rpx", "height" to "70rpx", "bottom" to "-15rpx", "right" to "-15rpx", "opacity" to 0.2)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
