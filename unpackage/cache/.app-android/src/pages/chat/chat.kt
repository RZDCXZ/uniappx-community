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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit;
import io.dcloud.uniapp.extapi.`$off` as uni__off;
import io.dcloud.uniapp.extapi.`$on` as uni__on;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.setNavigationBarTitle as uni_setNavigationBarTitle;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesChatChat : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(options: OnLoadOptions) {
            if (options.has("id")) {
                this.id = parseInt(options.get("id") as String);
            }
            if (options.has("target_id")) {
                this.target_id = parseInt(options.get("target_id") as String);
            }
            if (options.has("title")) {
                val title = options.get("title") as String;
                uni_setNavigationBarTitle(SetNavigationBarTitleOptions(title = title));
            }
            setCurrentConversation(this.id, this.target_id);
            this.refreshData(null);
            uni__on("onMessage", this.onMessage);
            this.read();
        }
        , instance);
        onUnload(fun() {
            setCurrentConversation(0, 0);
            uni__off("onMessage", this.onMessage);
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_chat_item = resolveEasyComponent("chat-item", GenComponentsChatItemChatItemClass);
        val _component_loading_more = resolveEasyComponent("loading-more", GenComponentsLoadingMoreLoadingMoreClass);
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("scroll-view", utsMapOf("scroll-top" to _ctx.scrollTop, "class" to "chat-scroller", "scroll-with-animation" to true, "onScrolltolower" to fun(){
                _ctx.loadData(null);
            }
            ), utsArrayOf(
                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "auto"))), utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(item, index, _, _): VNode {
                        return createVNode(_component_chat_item, utsMapOf("key" to index, "item" to item), null, 8, utsArrayOf(
                            "item"
                        ));
                    }
                    ), 128),
                    if (_ctx.list.length > 5) {
                        createElementVNode("view", utsMapOf("key" to 0, "class" to "loadMore"), utsArrayOf(
                            createVNode(_component_loading_more, utsMapOf("isEnded" to _ctx.isEnded, "loading" to _ctx.loading), null, 8, utsArrayOf(
                                "isEnded",
                                "loading"
                            ))
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                ), 4)
            ), 40, utsArrayOf(
                "scroll-top",
                "onScrolltolower"
            )),
            createElementVNode("view", utsMapOf("class" to "chat-action"), utsArrayOf(
                createElementVNode("textarea", utsMapOf("auto-focus" to false, "class" to "chat-input", "auto-height" to true, "modelValue" to _ctx.content, "onInput" to fun(`$event`: InputEvent){
                    _ctx.content = `$event`.detail.value;
                }
                , "placeholder" to "说几句吧"), null, 40, utsArrayOf(
                    "modelValue",
                    "onInput"
                )),
                createVNode(_component_main_btn, utsMapOf("width" to "100rpx", "height" to "60rpx", "font-size" to "14px", "disabled" to (_ctx.content == "" || _ctx.sendLoading), "style" to normalizeStyle(utsMapOf("margin-left" to "10rpx", "margin-bottom" to "5rpx")), "onClick" to _ctx.send), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        toDisplayString(if (_ctx.sendLoading) {
                            "发送中";
                        } else {
                            "发送";
                        }
                        )
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "disabled",
                    "style",
                    "onClick"
                ))
            ))
        ), 64);
    }
    open var content: String by `$data`;
    open var list: UTSArray<ChatItem> by `$data`;
    open var isEnded: Boolean by `$data`;
    open var loading: Boolean by `$data`;
    open var currentPage: Number by `$data`;
    open var sendLoading: Boolean by `$data`;
    open var scrollTop: Number by `$data`;
    open var id: Number by `$data`;
    open var target_id: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("content" to "", "list" to utsArrayOf<ChatItem>(), "isEnded" to false, "loading" to false, "currentPage" to 1, "sendLoading" to false, "scrollTop" to 0, "id" to 0, "target_id" to 0);
    }
    override fun `$initMethods`() {
        this.onMessage = fun(e: ChatItem) {
            console.log("onMessage", e, " at pages/chat/chat.uvue:69");
            if (e.conversation_id == this.id) {
                this.addMessage(e);
                this.read();
            }
        }
        ;
        this.read = fun() {
            uni_request<Result<Conversation>>(RequestOptions(url = getURL("/im/read_conversation/" + this.id), method = "POST", header = object : UTSJSONObject() {
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
                val resData = r.data as Conversation?;
                if (resData == null) {
                    return;
                }
                uni__emit("onUpdateNoReadCount", resData.id);
            }
            , fail = fun(err){
                uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
            }
            ));
        }
        ;
        this.refreshData = fun(loadComplete: (() -> Unit)?) {
            this.list.length = 0;
            this.currentPage = 1;
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
            uni_request<Result<ChatItemResult>>(RequestOptions(url = getURL("/im/" + this.id + "/message/" + Math.floor(this.currentPage)), header = object : UTSJSONObject() {
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
                val resData = r.data as ChatItemResult?;
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
                if (loadComplete != null) {
                    loadComplete();
                }
            }
            ));
        }
        ;
        this.send = fun() {
            this.sendLoading = true;
            uni_request<Result<ChatItem>>(RequestOptions(url = getURL("/im/send"), method = "POST", header = object : UTSJSONObject() {
                var token = getToken()
            }, data = let {
                object : UTSJSONObject() {
                    var target_id = it.target_id
                    var type = "text"
                    var body = it.content
                    var client_create_time = Date.now()
                }
            }, success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                if (r.data == null) {
                    return;
                }
                var d = r.data as ChatItem;
                if (d.state != 100) {
                    var title = if (d.state_text != null) {
                        d.state_text as String;
                    } else {
                        "发送失败";
                    }
                    ;
                    uni_showToast(ShowToastOptions(title = title, icon = "none"));
                }
                this.addMessage(d);
                this.content = "";
            }
            , fail = fun(err){
                uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
            }
            , complete = fun(_){
                this.sendLoading = false;
            }
            ));
        }
        ;
        this.addMessage = fun(e: ChatItem) {
            this.list.unshift(e);
            this.goToBottom();
        }
        ;
        this.goToBottom = fun() {
            setTimeout(fun(){
                this.scrollTop = if (this.scrollTop == 1) {
                    0;
                } else {
                    1;
                }
                ;
            }
            , 300);
        }
        ;
    }
    open lateinit var onMessage: (e: ChatItem) -> Unit;
    open lateinit var read: () -> Unit;
    open lateinit var refreshData: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadData: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var send: () -> Unit;
    open lateinit var addMessage: (e: ChatItem) -> Unit;
    open lateinit var goToBottom: () -> Unit;
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
                return utsMapOf("chat-scroller" to padStyleMapOf(utsMapOf("flex" to 1, "boxSizing" to "border-box", "transform" to "rotate(180deg)")), "loadMore" to padStyleMapOf(utsMapOf("transform" to "rotate(180deg)")), "chat-action" to padStyleMapOf(utsMapOf("minHeight" to "95rpx", "flexDirection" to "row", "alignItems" to "flex-end", "backgroundColor" to "#ffffff", "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#eeeeee", "paddingLeft" to "28rpx", "paddingRight" to "28rpx", "paddingBottom" to "20rpx", "flexShrink" to 0)), "chat-input" to padStyleMapOf(utsMapOf("width" to "590rpx", "backgroundColor" to "#f4f4f4", "borderRadius" to 5, "paddingTop" to "16rpx", "paddingRight" to "20rpx", "paddingBottom" to "16rpx", "paddingLeft" to "20rpx", "marginTop" to "20rpx", "maxHeight" to "500rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
