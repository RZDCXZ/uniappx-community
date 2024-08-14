@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.UNIE905653;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.unicloud.*;
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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh;
open class GenPagesMsgMsg : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(_: OnLoadOptions) {
            this.refreshData(null);
            uni__on("onUpdateConversation", this.onUpdateConversation);
            uni__on("onUpdateNoReadCount", this.onUpdateNoReadCount);
        }
        , instance);
        onPageShow(fun() {
            if (this.loginState) {
                openSocket();
            }
        }
        , instance);
        onUnload(fun() {
            uni__off("onUpdateConversation", this.onUpdateConversation);
            uni__off("onUpdateNoReadCount", this.onUpdateNoReadCount);
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
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        val _component_tip = resolveEasyComponent("tip", GenComponentsTipTipClass);
        val _component_loading_more = resolveEasyComponent("loading-more", GenComponentsLoadingMoreLoadingMoreClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(item, index, _, _): VNode {
                return createElementVNode("view", utsMapOf("class" to "msg-item", "hover-class" to "msg-item-hover", "key" to index, "onClick" to fun(){
                    _ctx.openChat(item);
                }
                ), utsArrayOf(
                    createVNode(_component_avatar, utsMapOf("src" to item.avatar, "width" to "100rpx", "height" to "100rpx", "style" to normalizeStyle(utsMapOf("margin-right" to "20rpx"))), null, 8, utsArrayOf(
                        "src",
                        "style"
                    )),
                    createElementVNode("view", utsMapOf("class" to "msg-item-body"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "msg-item-nickname"), toDisplayString(item.name), 1),
                        createElementVNode("text", utsMapOf("class" to "msg-item-content"), toDisplayString(item.last_msg_note), 1)
                    )),
                    createElementVNode("view", utsMapOf("class" to "msg-item-info"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "msg-item-time"), toDisplayString(item.update_time), 1),
                        if (item.unread_count > 0) {
                            createElementVNode("text", utsMapOf("key" to 0, "class" to "msg-item-badge"), toDisplayString(if (item.unread_count > 99) {
                                "99+";
                            } else {
                                item.unread_count;
                            }), 1);
                        } else {
                            createCommentVNode("v-if", true);
                        }
                    ))
                ), 8, utsArrayOf(
                    "onClick"
                ));
            }
            ), 128),
            if (isTrue(!_ctx.isFirstLoad && _ctx.list.length == 0)) {
                createVNode(_component_tip, utsMapOf("key" to 0));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            if (isTrue(_ctx.isFirstLoad || _ctx.list.length > 0)) {
                createVNode(_component_loading_more, utsMapOf("key" to 1, "loading" to _ctx.loading, "isEnded" to _ctx.isEnded), null, 8, utsArrayOf(
                    "loading",
                    "isEnded"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ), 4);
    }
    open var list: UTSArray<Conversation> by `$data`;
    open var loading: Boolean by `$data`;
    open var isEnded: Boolean by `$data`;
    open var currentPage: Number by `$data`;
    open var isFirstLoad: Boolean by `$data`;
    open var loginState: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("list" to utsArrayOf<Conversation>(), "loading" to false, "isEnded" to false, "currentPage" to 1, "isFirstLoad" to true, "loginState" to computed<Boolean>(fun(): Boolean {
            return uni.UNIE905653.loginState.value;
        }
        ));
    }
    override fun `$initMethods`() {
        this.onUpdateNoReadCount = fun(id: Number) {
            var item = this.list.find(fun(o: Conversation): Boolean {
                return o.id == id;
            }
            );
            if (item != null) {
                item.unread_count = 0;
            }
        }
        ;
        this.onUpdateConversation = fun(e: Conversation?) {
            if (e == null) {
                if (this.loginState) {
                    this.refreshData(null);
                } else {
                    this.list.length = 0;
                }
                return;
            }
            var i = this.list.findIndex(fun(o: Conversation): Boolean {
                return o.id == e.id;
            }
            );
            if (i == -1) {
                this.refreshData(null);
                return;
            }
            this.list[i].avatar = e.avatar;
            this.list[i].name = e.name;
            this.list[i].last_msg_note = e.last_msg_note;
            this.list[i].unread_count = e.unread_count;
            this.list[i].update_time = e.update_time;
            this._toFirst(this.list, i);
        }
        ;
        this._toFirst = fun(arr: UTSArray<Conversation>, index: Number): UTSArray<Conversation> {
            if (index != 0) {
                arr.unshift(arr.splice(index, 1)[0]);
            }
            return arr;
        }
        ;
        this.openChat = fun(item: Conversation) {
            uni_navigateTo(NavigateToOptions(url = "/pages/chat/chat?id=" + item.id + "&target_id=" + item.target_id + "&title=" + item.name));
        }
        ;
        this.refreshData = fun(loadComplete: (() -> Unit)?) {
            this.list.length = 0;
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
            uni_request<Result<ConversationResult>>(RequestOptions(url = getURL("/im/conversation/" + Math.floor(this.currentPage)), header = object : UTSJSONObject() {
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
                val resData = r.data as ConversationResult?;
                if (resData == null) {
                    return;
                }
                this.isEnded = resData.last_page <= resData.current_page;
                if (this.currentPage == 1) {
                    this.list = resData.data;
                } else {
                    this.list.push(*resData.data.toTypedArray());
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
    open lateinit var onUpdateNoReadCount: (id: Number) -> Unit;
    open lateinit var onUpdateConversation: (e: Conversation?) -> Unit;
    open lateinit var _toFirst: (arr: UTSArray<Conversation>, index: Number) -> UTSArray<Conversation>;
    open lateinit var openChat: (item: Conversation) -> Unit;
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
                return utsMapOf("msg-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "stretch", "paddingTop" to "20rpx", "paddingRight" to "30rpx", "paddingBottom" to "20rpx", "paddingLeft" to "30rpx")), "msg-item-hover" to padStyleMapOf(utsMapOf("backgroundColor" to "#f4f4f4")), "msg-item-body" to padStyleMapOf(utsMapOf("maxWidth" to "420rpx")), "msg-item-nickname" to padStyleMapOf(utsMapOf("fontSize" to 17, "fontWeight" to "bold", "marginTop" to "10rpx", "marginRight" to 0, "marginBottom" to "10rpx", "marginLeft" to 0, "lines" to 1)), "msg-item-content" to padStyleMapOf(utsMapOf("fontSize" to 14, "color" to "#727272", "lines" to 1)), "msg-item-info" to padStyleMapOf(utsMapOf("marginLeft" to "auto", "alignItems" to "flex-end", "flexShrink" to 0)), "msg-item-time" to padStyleMapOf(utsMapOf("fontSize" to 12, "color" to "#777777", "marginTop" to "10rpx", "marginRight" to 0, "marginBottom" to "10rpx", "marginLeft" to 0)), "msg-item-badge" to padStyleMapOf(utsMapOf("color" to "#ffffff", "backgroundColor" to "#f84c2f", "fontSize" to 11, "paddingTop" to "4rpx", "paddingRight" to "8rpx", "paddingBottom" to "4rpx", "paddingLeft" to "8rpx", "borderRadius" to "30rpx", "fontWeight" to "bold")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
