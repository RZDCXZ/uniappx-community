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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesTopicTopic : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(_: OnLoadOptions) {
            this.loadCategories();
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_loading = resolveEasyComponent("loading", GenComponentsLoadingLoadingClass);
        val _component_tip = resolveEasyComponent("tip", GenComponentsTipTipClass);
        val _component_topic_list_item = resolveEasyComponent("topic-list-item", GenComponentsTopicListItemTopicListItemClass);
        val _component_loading_more = resolveEasyComponent("loading-more", GenComponentsLoadingMoreLoadingMoreClass);
        return createElementVNode("view", utsMapOf("class" to "flex-1 flex", "style" to normalizeStyle(utsMapOf("border-top" to "1rpx solid #f2f2f2"))), utsArrayOf(
            createElementVNode("scroll-view", utsMapOf("scroll-y" to "true", "class" to "topic-navs"), utsArrayOf(
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.topic_navs, fun(tn, _, _, _): VNode {
                    return createElementVNode("view", utsMapOf("key" to tn.id, "class" to "topic-nav-item", "style" to normalizeStyle(if (_ctx.navActiveId == tn.id) {
                        "background-color:#ffffff;";
                    } else {
                        "";
                    }
                    ), "onClick" to fun(){
                        _ctx.chooseTopicNav(tn.id);
                    }
                    ), utsArrayOf(
                        createElementVNode("text", utsMapOf("style" to normalizeStyle(if (_ctx.navActiveId == tn.id) {
                            "color:#e95e6f";
                        } else {
                            "color:#0c0c0c";
                        }
                        )), toDisplayString(tn.title), 5)
                    ), 12, utsArrayOf(
                        "onClick"
                    ));
                }
                ), 128)
            )),
            if (_ctx.topic_list.length == 0) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "flex-1"), utsArrayOf(
                    if (isTrue(_ctx.loading)) {
                        createVNode(_component_loading, utsMapOf("key" to 0, "circle" to true));
                    } else {
                        createVNode(_component_tip, utsMapOf("key" to 1, "title" to "暂无话题~"));
                    }
                ));
            } else {
                createElementVNode("list-view", utsMapOf("key" to 1, "class" to "flex-1", "style" to normalizeStyle(utsMapOf("padding-left" to "34rpx")), "onScrolltolower" to _ctx.loadMore), utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.topic_list, fun(item, _, _, _): VNode {
                        return createVNode(_component_topic_list_item, utsMapOf("key" to item.id, "item" to item), null, 8, utsArrayOf(
                            "item"
                        ));
                    }
                    ), 128),
                    createElementVNode("list-item", utsMapOf("type" to 4), utsArrayOf(
                        createVNode(_component_loading_more, utsMapOf("loading" to _ctx.loading, "isEnded" to _ctx.isEnded), null, 8, utsArrayOf(
                            "loading",
                            "isEnded"
                        ))
                    ))
                ), 44, utsArrayOf(
                    "onScrolltolower"
                ));
            }
        ), 4);
    }
    open var navActiveId: Number by `$data`;
    open var topic_navs: UTSArray<TopicNav> by `$data`;
    open var topic_list: UTSArray<Topic> by `$data`;
    open var page: Number by `$data`;
    open var isEnded: Boolean by `$data`;
    open var loading: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("navActiveId" to 2, "topic_navs" to utsArrayOf<TopicNav>(), "topic_list" to utsArrayOf<Topic>(), "page" to 1, "isEnded" to false, "loading" to false);
    }
    override fun `$initMethods`() {
        this.loadCategories = fun() {
            uni_showLoading(ShowLoadingOptions(title = "加载中...", mask = false));
            uni_request<Result<UTSArray<TopicNav>>>(RequestOptions(url = getURL("/category/topic"), success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                this.topic_navs = r.data as UTSArray<TopicNav>;
                if (this.topic_navs.length > 0) {
                    this.chooseTopicNav(this.topic_navs[0].id);
                }
            }
            , fail = fun(err){
                uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
            }
            , complete = fun(_){
                uni_hideLoading();
            }
            ));
        }
        ;
        this.loadTopicList = fun() {
            this.loading = true;
            uni_request<Result<TopicResult>>(RequestOptions(url = getURL("/category/" + this.navActiveId + "/topic/" + this.page), success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                val resData = r.data as TopicResult?;
                if (resData == null) {
                    return;
                }
                this.isEnded = resData.last_page <= resData.current_page;
                if (this.page == 1) {
                    this.topic_list = resData.data;
                } else {
                    this.topic_list.push(*resData.data.toTypedArray());
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
            }
            ));
        }
        ;
        this.chooseTopicNav = fun(id: Number) {
            this.navActiveId = id;
            this.isEnded = false;
            this.page = 1;
            this.topic_list.length = 0;
            this.loadTopicList();
        }
        ;
        this.loadMore = fun() {
            if (this.loading || this.isEnded) {
                return;
            }
            this.loadTopicList();
        }
        ;
    }
    open lateinit var loadCategories: () -> Unit;
    open lateinit var loadTopicList: () -> Unit;
    open lateinit var chooseTopicNav: (id: Number) -> Unit;
    open lateinit var loadMore: () -> Unit;
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
                return utsMapOf("topic-navs" to padStyleMapOf(utsMapOf("width" to "165rpx", "backgroundColor" to "#f9f9f9")), "topic-nav-item" to padStyleMapOf(utsMapOf("height" to "100rpx", "alignItems" to "center", "justifyContent" to "center")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
