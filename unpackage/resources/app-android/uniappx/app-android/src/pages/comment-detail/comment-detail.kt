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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesCommentDetailCommentDetail : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(options: OnLoadOptions) {
            if (options.has("id")) {
                this.item.id = parseInt(options.get("id") as String);
                this.loadCommentDetail();
            }
            uni__on("onSendCommentSuccess", this.onSendCommentSuccess);
            uni__on("onUpdateArticleChange", this.onUpdateArticleChange);
        }
        , instance);
        onUnload(fun() {
            uni__off("onSendCommentSuccess", this.onSendCommentSuccess);
            uni__off("onUpdateArticleChange", this.onUpdateArticleChange);
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        val _component_follow_button = resolveEasyComponent("follow-button", GenComponentsFollowButtonFollowButtonClass);
        val _component_comment = resolveEasyComponent("comment", GenComponentsCommentCommentClass);
        val _component_comment_popup = resolveEasyComponent("comment-popup", GenComponentsCommentPopupCommentPopupClass);
        return createElementVNode("scroll-view", utsMapOf("scroll-into-view" to _ctx.scrollIntoView, "scroll-with-animation" to true, "style" to normalizeStyle(utsMapOf("flex" to "1", "background-color" to "#f9f9f9")), "onScrolltolower" to _ctx.onScrollBottom), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "list-item-header"), utsArrayOf(
                createVNode(_component_avatar, utsMapOf("src" to _ctx.item.avatar, "style" to normalizeStyle(utsMapOf("margin-right" to "27rpx")), "onClick" to fun(){
                    _ctx.openUserSpace(_ctx.item.user_id);
                }
                ), null, 8, utsArrayOf(
                    "src",
                    "style",
                    "onClick"
                )),
                createElementVNode("view", utsMapOf("onClick" to fun(){
                    _ctx.openUserSpace(_ctx.item.user_id);
                }
                ), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "nickname"), toDisplayString(_ctx.item.name), 1),
                    createElementVNode("text", utsMapOf("class" to "time"), toDisplayString(_ctx.item.create_time), 1)
                ), 8, utsArrayOf(
                    "onClick"
                )),
                createVNode(_component_follow_button, utsMapOf("type" to "button", "modelValue" to _ctx.isfollow, "onUpdate:modelValue" to fun(`$event`: Boolean){
                    _ctx.isfollow = `$event`;
                }
                , "user_id" to _ctx.item.user_id), null, 8, utsArrayOf(
                    "modelValue",
                    "onUpdate:modelValue",
                    "user_id"
                ))
            )),
            createElementVNode("text", utsMapOf("class" to "content"), toDisplayString(_ctx.item.content), 1),
            createElementVNode("view", utsMapOf("class" to "divider", "id" to "divider")),
            createVNode(_component_comment, utsMapOf("ref" to "comment", "isreply" to true, "comment_id" to _ctx.item.id, "support_count" to _ctx.reply_count, "onReply" to _ctx.handleReply), null, 8, utsArrayOf(
                "comment_id",
                "support_count",
                "onReply"
            )),
            createElementVNode("view", utsMapOf("class" to "action-bar"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "action-input", "onClick" to fun(){
                    _ctx.toggleCommentPopup(true);
                }
                ), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "placeholder"), "说点什么..."),
                    createElementVNode("text", utsMapOf("class" to "iconfont emotion"), toDisplayString("\ue64e"))
                ), 8, utsArrayOf(
                    "onClick"
                ))
            )),
            createVNode(_component_comment_popup, utsMapOf("ref" to "popup"), null, 512)
        ), 44, utsArrayOf(
            "scroll-into-view",
            "onScrolltolower"
        ));
    }
    open var isfollow: Boolean by `$data`;
    open var reply_count: Number by `$data`;
    open var scrollIntoView: String by `$data`;
    open var item: CommentDetail by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("isfollow" to false, "reply_count" to 0, "scrollIntoView" to "", "item" to CommentDetail(id = 1766, article_id = 1034, user_id = 1108, reply_count = 0, content = "阿里健康", comment_id = null, create_time = "2021-04-15 17:40:53", avatar = null, name = "13163224966", isfollow = false));
    }
    override fun `$initMethods`() {
        this.onUpdateArticleChange = fun(e: updateArticleChangeEvent) {
            if (e.key == "updateFollow" && this.item.user_id == e.id) {
                this.isfollow = if (e.value == "true") {
                    true;
                } else {
                    false;
                }
                ;
            }
        }
        ;
        this.onSendCommentSuccess = fun(e: CommentItem) {
            if (e.comment_id == null) {
                return;
            }
            this.reply_count = Math.floor(this.reply_count + 1);
            this.scrollIntoView = "";
            this.`$nextTick`(fun(){
                this.scrollIntoView = "divider";
            }
            );
        }
        ;
        this.toggleCommentPopup = fun(show: Boolean) {
            AuthAction(fun(){
                var popup = this.`$refs`["popup"] as ComponentPublicInstance;
                popup.`$callMethod`("toggleCommentPopup", show, null, this.item.id);
            }
            );
        }
        ;
        this.handleReply = fun(e: ReplyEmit) {
            AuthAction(fun(){
                var popup = this.`$refs`["popup"] as ComponentPublicInstance;
                popup.`$callMethod`("toggleCommentPopup", true, e.placeholder, e.reply_id);
            }
            );
        }
        ;
        this.onScrollBottom = fun() {
            (this.`$refs`["comment"] as ComponentPublicInstance).`$callMethod`("loadCommentList");
        }
        ;
        this.openUserSpace = fun(user_id: Number) {
            uni_navigateTo(NavigateToOptions(url = "/pages/user-space/user-space?user_id=" + user_id));
        }
        ;
        this.loadCommentDetail = fun() {
            uni_showLoading(ShowLoadingOptions(title = "加载中...", mask = false));
            uni_request<Result<CommentDetail>>(RequestOptions(url = getURL("/comment/" + this.item.id), header = object : UTSJSONObject() {
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
                this.item = r.data as CommentDetail;
                this.isfollow = this.item.isfollow;
                this.reply_count = this.item.reply_count;
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
    }
    open lateinit var onUpdateArticleChange: (e: updateArticleChangeEvent) -> Unit;
    open lateinit var onSendCommentSuccess: (e: CommentItem) -> Unit;
    open lateinit var toggleCommentPopup: (show: Boolean) -> Unit;
    open lateinit var handleReply: (e: ReplyEmit) -> Unit;
    open lateinit var onScrollBottom: () -> Unit;
    open lateinit var openUserSpace: (user_id: Number) -> Unit;
    open lateinit var loadCommentDetail: () -> Unit;
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
                return utsMapOf("list-item-header" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "26rpx", "paddingLeft" to "33rpx", "paddingRight" to "33rpx", "backgroundColor" to "#ffffff")), "time" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#a7a7a7", "marginTop" to "10rpx")), "nickname" to padStyleMapOf(utsMapOf("color" to "#050505", "textOverflow" to "ellipsis", "maxWidth" to "240rpx", "height" to "34rpx", "fontSize" to 15, "fontWeight" to "bold")), "content" to padStyleMapOf(utsMapOf("paddingTop" to "25rpx", "paddingLeft" to "33rpx", "paddingRight" to "33rpx", "fontSize" to 16, "lineHeight" to 1.5, "paddingBottom" to "20rpx", "backgroundColor" to "#ffffff")), "content-image" to padStyleMapOf(utsMapOf("width" to "750rpx", "backgroundColor" to "#f0f0f0")), "action-bar" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "borderTopWidth" to "1rpx", "borderTopStyle" to "solid", "borderTopColor" to "#f2f2f2", "zIndex" to 100, "height" to "103rpx", "paddingLeft" to "28rpx", "paddingRight" to "28rpx", "flexDirection" to "row", "alignItems" to "center")), "action-input" to padStyleMapOf(utsMapOf("flexDirection" to "row", "backgroundColor" to "#f4f4f4", "height" to "73rpx", "flex" to 1, "borderRadius" to 5, "alignItems" to "center", "justifyContent" to "space-between", "paddingTop" to 0, "paddingRight" to "20rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx")), "placeholder" to padStyleMapOf(utsMapOf("fontSize" to 14, "color" to "#949494")), "emotion" to padStyleMapOf(utsMapOf("fontSize" to 20, "color" to "#191919")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
