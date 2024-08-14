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
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh;
open class GenPagesUserHistoryUserHistory : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onPageShow(fun() {
            this.refreshData(null);
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
        onReachBottom(fun() {
            this.loadData(null);
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_tip = resolveEasyComponent("tip", GenComponentsTipTipClass);
        val _component_article_list_item = resolveEasyComponent("article-list-item", GenComponentsArticleListItemArticleListItemClass);
        val _component_loading_more = resolveEasyComponent("loading-more", GenComponentsLoadingMoreLoadingMoreClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            if (isTrue(!_ctx.isFirstLoad && _ctx.List.length == 0)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "flex-1"), utsArrayOf(
                    createVNode(_component_tip)
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.List, fun(item, index, _, _): VNode {
                return createVNode(_component_article_list_item, utsMapOf("key" to index, "item" to item), null, 8, utsArrayOf(
                    "item"
                ));
            }
            ), 128),
            if (isTrue(!_ctx.isFirstLoad && _ctx.List.length > 0)) {
                createVNode(_component_loading_more, utsMapOf("key" to 1, "loading" to _ctx.loading, "isEnded" to _ctx.isEnded), null, 8, utsArrayOf(
                    "loading",
                    "isEnded"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ), 4);
    }
    open var user_id: Number by `$data`;
    open var loading: Boolean by `$data`;
    open var List: UTSArray<ListItem> by `$data`;
    open var isEnded: Boolean by `$data`;
    open var currentPage: Number by `$data`;
    open var isFirstLoad: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("user_id" to 0, "loading" to false, "List" to utsArrayOf<ListItem>(), "isEnded" to false, "currentPage" to 1, "isFirstLoad" to true);
    }
    override fun `$initMethods`() {
        this.refreshData = fun(loadComplete: (() -> Unit)?) {
            this.List.length = 0;
            this.currentPage = 1;
            this.isFirstLoad = true;
            this.isEnded = false;
            this.loading = false;
            this.loadData(loadComplete);
        }
        ;
        this.loadData = fun(loadComplete: (() -> Unit)?) {
            if (this.loading || this.isEnded) {
                return;
            }
            this.loading = true;
            uni_request<Result<ListResult>>(RequestOptions(url = getURL("/article_read_log/" + Math.floor(this.currentPage)), header = object : UTSJSONObject() {
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
                if (this.currentPage == 1) {
                    this.List = resData.data;
                } else {
                    this.List.push(*resData.data.toTypedArray());
                }
                this.currentPage = if (this.isEnded) {
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
                this.isFirstLoad = false;
                if (loadComplete != null) {
                    loadComplete();
                }
            }
            ));
        }
        ;
    }
    open lateinit var refreshData: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadData: (loadComplete: (() -> Unit)?) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(), utsArrayOf(
                    GenApp.styles
                ));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
