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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenComponentsCommentPopupCommentPopup : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            if (isTrue(_ctx.comment_popup_show)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "comment-popup-mask", "onClick" to fun(){
                    _ctx.toggleCommentPopup(false, null, null);
                }), null, 8, utsArrayOf(
                    "onClick"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                "comment-popup",
                if (_ctx.comment_popup_show) {
                    "comment-popup-show";
                } else {
                    "";
                }
            ))), utsArrayOf(
                createElementVNode("textarea", utsMapOf("focus" to _ctx.focus, "class" to "comment-textarea", "auto-height" to true, "modelValue" to _ctx.comment_data, "onInput" to fun(`$event`: InputEvent){
                    _ctx.comment_data = `$event`.detail.value;
                }
                , "placeholder" to _ctx.placeholder), null, 40, utsArrayOf(
                    "focus",
                    "modelValue",
                    "onInput",
                    "placeholder"
                )),
                createVNode(_component_main_btn, utsMapOf("width" to "100rpx", "height" to "60rpx", "font-size" to "14px", "disabled" to (_ctx.comment_data == ""), "onClick" to _ctx.sendComment, "style" to normalizeStyle(utsMapOf("margin-left" to "10rpx", "margin-bottom" to "10rpx"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        "发送"
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "disabled",
                    "onClick",
                    "style"
                ))
            ), 2)
        ), 64);
    }
    open var article_id: Number by `$props`;
    open var comment_popup_show: Boolean by `$data`;
    open var focus: Boolean by `$data`;
    open var comment_data: String by `$data`;
    open var placeholder: String by `$data`;
    open var reply_id: Number? by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("comment_popup_show" to false, "focus" to false, "comment_data" to "", "placeholder" to "说点什么...", "reply_id" to null as Number?);
    }
    override fun `$initMethods`() {
        this.toggleCommentPopup = fun(show: Boolean, placeholder: String?, reply_id: Number?) {
            this.comment_popup_show = show;
            this.placeholder = if (placeholder == null) {
                "说点什么...";
            } else {
                placeholder;
            }
            ;
            this.reply_id = reply_id;
            this.focus = show;
        }
        ;
        this.sendComment = fun() {
            uni_showLoading(ShowLoadingOptions(title = "发布中...", mask = true));
            var isreply = if (this.reply_id == null) {
                false;
            } else {
                true;
            }
            ;
            var url = "/comment/save";
            var data: UTSJSONObject = let {
                object : UTSJSONObject() {
                    var content = it.comment_data
                }
            };
            if (isreply) {
                url = "/comment/reply";
                data.set("reply_id", this.reply_id);
            } else {
                data.set("article_id", this.article_id);
            }
            uni_request<Result<CommentItem>>(RequestOptions(url = getURL(url), method = "POST", header = object : UTSJSONObject() {
                var token = getToken()
            }, data = data, success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                uni__emit("onSendCommentSuccess", r.data);
                this.toggleCommentPopup(false, null, null);
                this.comment_data = "";
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
    }
    open lateinit var toggleCommentPopup: (show: Boolean, placeholder: String?, reply_id: Number?) -> Unit;
    open lateinit var sendComment: () -> Unit;
    companion object {
        var name = "comment-popup";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("comment-popup-mask" to padStyleMapOf(utsMapOf("position" to "fixed", "top" to 0, "left" to 0, "right" to 0, "bottom" to 0, "zIndex" to 101)), "comment-popup" to padStyleMapOf(utsMapOf("zIndex" to 1000, "backgroundColor" to "#ffffff", "position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "borderTopWidth" to "1rpx", "borderTopStyle" to "solid", "borderTopColor" to "#f2f2f2", "minHeight" to "83rpx", "paddingLeft" to "28rpx", "paddingRight" to "28rpx", "flexDirection" to "row", "alignItems" to "flex-end", "paddingBottom" to "20rpx", "transform" to "translateY(500rpx)", "transitionProperty" to "transform", "transitionDuration" to "300ms")), "comment-popup-show" to padStyleMapOf(utsMapOf("transform" to "translateY(0)")), "comment-textarea" to padStyleMapOf(utsMapOf("width" to "590rpx", "backgroundColor" to "#f4f4f4", "borderRadius" to 5, "paddingTop" to "16rpx", "paddingRight" to "20rpx", "paddingBottom" to "16rpx", "paddingLeft" to "20rpx", "marginTop" to "20rpx", "maxHeight" to "500rpx")), "@TRANSITION" to utsMapOf("comment-popup" to utsMapOf("property" to "transform", "duration" to "300ms")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("article_id" to utsMapOf("type" to "Number", "default" to 0)));
        var propsNeedCastKeys = utsArrayOf(
            "article_id"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
