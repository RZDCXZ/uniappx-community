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
import io.dcloud.uniapp.extapi.`$off` as uni__off;
import io.dcloud.uniapp.extapi.`$on` as uni__on;
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh;
open class GenPagesTopicDetailTopicDetail : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(options: OnLoadOptions) {
            this.statusBarHeight = uni_getSystemInfoSync().statusBarHeight;
            this.marginTop = this.statusBarHeight + 45;
            if (options.has("id")) {
                this.topic.id = parseInt(options.get("id") as String);
                this.loadTopicDetail();
                this.loadList(null);
            }
            uni__on("onAddArticleSuccess", this.onAddArticleSuccess);
        }
        , instance);
        onUnload(fun() {
            uni__off("onAddArticleSuccess", this.onAddArticleSuccess);
        }
        , instance);
        onReady(fun() {
            this.`$navbarView` = this.`$refs`["navbar"] as UniElement;
            this.`$navbarTitle` = this.`$refs`["navbarTitle"] as UniElement;
            this.`$headerHeight` = (this.`$refs`["header"] as UniElement).offsetHeight;
        }
        , instance);
        onPullDownRefresh(fun() {
            this.refreshData(fun(){
                uni_showToast(ShowToastOptions(title = "刷新成功", icon = "none"));
                uni_stopPullDownRefresh();
            }
            );
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_loading = resolveEasyComponent("loading", GenComponentsLoadingLoadingClass);
        val _component_tip = resolveEasyComponent("tip", GenComponentsTipTipClass);
        val _component_article_list_item = resolveEasyComponent("article-list-item", GenComponentsArticleListItemArticleListItemClass);
        val _component_loading_more = resolveEasyComponent("loading-more", GenComponentsLoadingMoreLoadingMoreClass);
        val _component_add_post_btn = resolveEasyComponent("add-post-btn", GenComponentsAddPostBtnAddPostBtnClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("list-view", utsMapOf("class" to "flex-1", "onScroll" to _ctx.handleScroll, "onScrolltolower" to _ctx.loadMore, "scroll-top" to _ctx.scrollTop), utsArrayOf(
                createElementVNode("sticky-header", null, utsArrayOf(
                    createElementVNode("view", utsMapOf("ref" to "navbar", "class" to "navbar"), utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("height:" + _ctx.statusBarHeight + "px;")), null, 4),
                        createElementVNode("view", utsMapOf("class" to "navbar-box"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "navbar-icon", "onClick" to _ctx.back), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "iconfont"), toDisplayString("\ue60d"))
                            ), 8, utsArrayOf(
                                "onClick"
                            )),
                            createElementVNode("text", utsMapOf("ref" to "navbarTitle", "class" to "navbar-title"), "话题标题", 512)
                        ))
                    ), 512)
                )),
                createElementVNode("list-item", utsMapOf("ref" to "header", "style" to normalizeStyle(utsArrayOf(
                    "margin-top: -" + _ctx.marginTop + "px;",
                    utsMapOf("height" to "590rpx")
                )), "type" to 1), utsArrayOf(
                    createElementVNode("image", utsMapOf("ref" to "banner", "class" to "banner-img", "src" to _ctx.topic.cover, "mode" to "aspectFill"), null, 8, utsArrayOf(
                        "src"
                    )),
                    createElementVNode("view", utsMapOf("class" to "topic-title-box"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "topic-title"), toDisplayString(_ctx.topic.title), 1),
                        createElementVNode("text", utsMapOf("class" to "topic-nav"), toDisplayString(_ctx.topic.category_name), 1)
                    )),
                    createElementVNode("text", utsMapOf("class" to "topic-desc"), toDisplayString(_ctx.topic.desc), 1),
                    createElementVNode("text", utsMapOf("class" to "topic-info"), "动态：" + toDisplayString(_ctx.topic.article_count) + "条 · 今日：" + toDisplayString(_ctx.topic.today_article_count) + "条", 1),
                    createElementVNode("view", utsMapOf("class" to "divider"))
                ), 4),
                createElementVNode("sticky-header", null, utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "tab"), utsArrayOf(
                        createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.tabs, fun(item, index, _, _): VNode {
                            return createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                                "tab-item",
                                if (_ctx.tabActiveId == item.id) {
                                    "tab-item-active";
                                } else {
                                    "";
                                }
                            )), "key" to index, "onClick" to fun(){
                                _ctx.onTabClick(item.id);
                            }
                            ), toDisplayString(item.name), 11, utsArrayOf(
                                "onClick"
                            ));
                        }
                        ), 128)
                    ))
                )),
                if (_ctx.list.length == 0) {
                    createElementVNode("list-item", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("height" to "1200px")), "type" to 2), utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "400px"))), utsArrayOf(
                            if (isTrue(_ctx.loading)) {
                                createVNode(_component_loading, utsMapOf("key" to 0, "circle" to true));
                            } else {
                                createVNode(_component_tip, utsMapOf("key" to 1, "title" to "暂无数据~"));
                            }
                        ), 4)
                    ), 4);
                } else {
                    createCommentVNode("v-if", true);
                }
                ,
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(item, index, _, _): VNode {
                    return createElementVNode("list-item", utsMapOf("key" to index, "type" to 0), utsArrayOf(
                        createVNode(_component_article_list_item, utsMapOf("inTopicDetail" to true, "item" to item), null, 8, utsArrayOf(
                            "item"
                        ))
                    ));
                }
                ), 128),
                createElementVNode("list-item", utsMapOf("type" to 4), utsArrayOf(
                    createVNode(_component_loading_more, utsMapOf("loading" to _ctx.loading, "isEnded" to _ctx.isEnded), null, 8, utsArrayOf(
                        "loading",
                        "isEnded"
                    ))
                ))
            ), 40, utsArrayOf(
                "onScroll",
                "onScrolltolower",
                "scroll-top"
            )),
            createVNode(_component_add_post_btn, utsMapOf("topic_id" to _ctx.topic.id, "topic_title" to _ctx.topic.title), null, 8, utsArrayOf(
                "topic_id",
                "topic_title"
            ))
        ), 64);
    }
    open var statusBarHeight: Number by `$data`;
    open var marginTop: Number by `$data`;
    open var `$headerHeight`: Number by `$data`;
    open var `$navbarView`: UniElement? by `$data`;
    open var `$navbarTitle`: UniElement? by `$data`;
    open var tabs: UTSArray<tab> by `$data`;
    open var tabActiveId: String by `$data`;
    open var topic: TopicDetail by `$data`;
    open var list: UTSArray<ListItem> by `$data`;
    open var page: Number by `$data`;
    open var isEnded: Boolean by `$data`;
    open var loading: Boolean by `$data`;
    open var currentScrollTop: Number by `$data`;
    open var scrollTop: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("statusBarHeight" to 0, "marginTop" to 0, "\$headerHeight" to 0, "\$navbarView" to null as UniElement?, "\$navbarTitle" to null as UniElement?, "tabs" to utsArrayOf<tab>(tab(type = "hot", name = "热门", id = "hot"), tab(type = "new", name = "最新", id = "new")), "tabActiveId" to "hot", "topic" to TopicDetail(id = 0, title = "", cover = "", desc = "", create_time = null, update_time = "", category_id = 7, article_count = 0, today_article_count = 0, category_name = "分类"), "list" to utsArrayOf<ListItem>(), "page" to 1, "isEnded" to false, "loading" to false, "currentScrollTop" to 0, "scrollTop" to 0);
    }
    override fun `$initMethods`() {
        this.onAddArticleSuccess = fun(_: onAddArticleSuccessEvent) {
            this.loadTopicDetail();
            this.loadList(null);
        }
        ;
        this.refreshData = fun(loadComplete: (() -> Unit)?) {
            this.list.length = 0;
            this.page = 1;
            this.isEnded = false;
            this.loadList(loadComplete);
        }
        ;
        this.loadMore = fun() {
            if (this.loading || this.isEnded) {
                return;
            }
            this.loadList(null);
        }
        ;
        this.loadList = fun(loadComplete: (() -> Unit)?) {
            this.loading = true;
            uni_request<Result<ListResult>>(RequestOptions(url = getURL("/topic/" + this.topic.id + "/article/" + this.page + "?order=" + this.tabActiveId), header = object : UTSJSONObject() {
                var token = getToken()
            }, success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                val resData = r.data as ListResult?;
                if (resData == null) {
                    return;
                }
                this.isEnded = resData.last_page <= resData.current_page;
                if (this.page == 1) {
                    this.list = resData.data;
                } else {
                    this.list.push(*resData.data.toTypedArray());
                }
                this.page = if (this.isEnded) {
                    resData.current_page;
                } else {
                    Math.floor(resData.current_page + 1);
                }
                ;
            }
            , fail = fun(err){
                uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
            }
            , complete = fun(_){
                this.loading = false;
                if (loadComplete != null) {
                    loadComplete();
                }
            }
            ));
        }
        ;
        this.loadTopicDetail = fun() {
            uni_showLoading(ShowLoadingOptions(title = "加载中...", mask = false));
            uni_request<Result<TopicDetail>>(RequestOptions(url = getURL("/topic/" + this.topic.id), success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                this.topic = r.data as TopicDetail;
            }
            , fail = fun(err){
                uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
            }
            , complete = fun(_){
                setTimeout(fun() {
                    uni_hideLoading();
                }
                , 200);
            }
            ));
        }
        ;
        this.onTabClick = fun(id: String) {
            if (this.tabActiveId == id) {
                return;
            }
            this.tabActiveId = id;
            this.page = 1;
            this.isEnded = false;
            this.list.length = 0;
            var h = this.`$headerHeight`;
            if (this.currentScrollTop > h) {
                var bannerRef = this.`$refs`["banner"] as UniElement;
                bannerRef.style.setProperty("opacity", 0);
                this.`$nextTick`(fun(){
                    this.scrollTop = if (this.scrollTop == h) {
                        h + 1;
                    } else {
                        h;
                    }
                    ;
                    setTimeout(fun(){
                        bannerRef.style.setProperty("opacity", 1);
                    }
                    , 200);
                }
                );
            }
            this.loadList(null);
        }
        ;
        this.back = fun() {
            uni_navigateBack(NavigateBackOptions(delta = 1));
        }
        ;
        this.handleScroll = fun(e: UniScrollEvent) {
            val scrollTop = e.detail.scrollTop;
            this.currentScrollTop = scrollTop;
            val colorStart: Number = 0.8;
            val colorEnd: Number = 0;
            var colorStartChange = 1 - (1 - colorStart) / this.`$headerHeight` * (this.`$headerHeight` - scrollTop);
            if (colorStartChange > 1) {
                colorStartChange = 1;
            }
            var colorEndChange = 1 - (1 - colorEnd) / this.`$headerHeight` * (this.`$headerHeight` - scrollTop);
            if (colorEndChange > 1) {
                colorEndChange = 1;
            }
            this.`$navbarView`?.style?.setProperty("background-image", "linear-gradient(to bottom,rgba(255,255,255," + colorStartChange + "),rgba(255,255,255," + colorEndChange + "))");
            this.`$navbarTitle`?.style?.setProperty("opacity", if (colorEndChange == 1) {
                1;
            } else {
                0;
            }
            );
        }
        ;
    }
    open lateinit var onAddArticleSuccess: (_: onAddArticleSuccessEvent) -> Unit;
    open lateinit var refreshData: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadMore: () -> Unit;
    open lateinit var loadList: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadTopicDetail: () -> Unit;
    open lateinit var onTabClick: (id: String) -> Unit;
    open lateinit var back: () -> Unit;
    open lateinit var handleScroll: (e: UniScrollEvent) -> Unit;
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
                return utsMapOf("navbar" to padStyleMapOf(utsMapOf("backgroundImage" to "linear-gradient(to bottom,rgba(255,255,255,0.8),rgba(255,255,255,0))")), "navbar-box" to padStyleMapOf(utsMapOf("height" to 45, "flexDirection" to "row", "alignItems" to "center")), "navbar-icon" to padStyleMapOf(utsMapOf("width" to 45, "height" to 45, "alignItems" to "center", "justifyContent" to "center")), "navbar-title" to padStyleMapOf(utsMapOf("opacity" to 0)), "banner-img" to padStyleMapOf(utsMapOf("height" to "335rpx", "width" to "750rpx")), "topic-title-box" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "marginTop" to "30rpx", "paddingTop" to 0, "paddingRight" to "35rpx", "paddingBottom" to 0, "paddingLeft" to "35rpx")), "topic-title" to padStyleMapOf(utsMapOf("fontSize" to 19, "fontWeight" to "bold", "color" to "#202020")), "topic-nav" to padStyleMapOf(utsMapOf("backgroundColor" to "#fff1f4", "color" to "#f96a88", "fontSize" to 14, "borderRadius" to 5, "paddingTop" to "10rpx", "paddingRight" to "10rpx", "paddingBottom" to "10rpx", "paddingLeft" to "10rpx")), "topic-desc" to padStyleMapOf(utsMapOf("color" to "#888888", "fontSize" to 16, "marginTop" to "20rpx", "paddingTop" to 0, "paddingRight" to "35rpx", "paddingBottom" to 0, "paddingLeft" to "35rpx")), "topic-info" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#000000", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "paddingTop" to 0, "paddingRight" to "35rpx", "paddingBottom" to 0, "paddingLeft" to "35rpx")), "tab" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "center", "alignItems" to "stretch", "backgroundColor" to "#ffffff")), "tab-item" to padStyleMapOf(utsMapOf("color" to "#414141", "fontSize" to 17, "paddingTop" to 12, "paddingRight" to 25, "paddingBottom" to 12, "paddingLeft" to 25)), "tab-item-active" to padStyleMapOf(utsMapOf("color" to "#f96a88")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
