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
import io.dcloud.uniapp.extapi.pageScrollTo as uni_pageScrollTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh;
open class GenPagesUserFeedbackUserFeedback : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onPageShow(fun() {
            this.refreshData(fun(){
                this.`$nextTick`(fun(){
                    this.goToBottom();
                }
                );
            }
            );
        }
        , instance);
        onPullDownRefresh(fun() {
            this.loadData(fun(){
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
        val _component_feedback_item = resolveEasyComponent("feedback-item", GenComponentsFeedbackItemFeedbackItemClass);
        val _component_loading = resolveEasyComponent("loading", GenComponentsLoadingLoadingClass);
        val _component_tip = resolveEasyComponent("tip", GenComponentsTipTipClass);
        val _component_navigator = resolveComponent("navigator");
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.List, fun(item, index, _, _): VNode {
                return createVNode(_component_feedback_item, utsMapOf("key" to index, "item" to item), null, 8, utsArrayOf(
                    "item"
                ));
            }
            ), 128),
            if (isTrue(_ctx.loading && _ctx.List.length == 0)) {
                createVNode(_component_loading, utsMapOf("key" to 0, "circle" to true));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            if (isTrue(!_ctx.isFirstLoad && _ctx.List.length == 0)) {
                createElementVNode("view", utsMapOf("key" to 1, "class" to "flex-1"), utsArrayOf(
                    createVNode(_component_tip)
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode("view", utsMapOf("id" to "chat-bottom")),
            createVNode(_component_navigator, utsMapOf("url" to "/pages/user-feedback-form/user-feedback-form"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "feedback-action"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "iconfont feedback-action-icon"), toDisplayString("\ue668")),
                        createElementVNode("text", utsMapOf("class" to "feedback-action-text"), "意见反馈")
                    ))
                );
            }
            ), "_" to 1)),
            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "95rpx"))), null, 4)
        ), 4);
    }
    open var List: UTSArray<FeedbackItem> by `$data`;
    open var loading: Boolean by `$data`;
    open var isEnded: Boolean by `$data`;
    open var currentPage: Number by `$data`;
    open var isFirstLoad: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("List" to utsArrayOf<FeedbackItem>(), "loading" to false, "isEnded" to false, "currentPage" to 1, "isFirstLoad" to true);
    }
    override fun `$initMethods`() {
        this.goToBottom = fun() {
            uni_pageScrollTo(PageScrollToOptions(selector = "#chat-bottom", duration = 100));
        }
        ;
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
            uni_request<Result<FeedbackItemResult>>(RequestOptions(url = getURL("/feedback/" + Math.floor(this.currentPage)), header = object : UTSJSONObject() {
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
                val resData = r.data as FeedbackItemResult?;
                if (resData == null) {
                    return;
                }
                resData.data.sort(fun(a: FeedbackItem, b: FeedbackItem): Number {
                    return a.id - b.id;
                }
                );
                this.isEnded = resData.last_page <= resData.current_page;
                if (this.currentPage == 1) {
                    this.List = resData.data;
                } else {
                    this.List = resData.data.concat(this.List);
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
    open lateinit var goToBottom: () -> Unit;
    open lateinit var refreshData: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadData: (loadComplete: (() -> Unit)?) -> Unit;
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
                return utsMapOf("feedback-action" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "height" to "95rpx", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#ffffff", "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#eeeeee")), "feedback-action-icon" to padStyleMapOf(utsMapOf("marginRight" to "20rpx")), "feedback-action-text" to padStyleMapOf(utsMapOf("fontSize" to 16)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
