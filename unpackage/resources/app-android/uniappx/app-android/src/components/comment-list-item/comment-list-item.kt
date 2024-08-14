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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenComponentsCommentListItemCommentListItem : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "list-item-header"), utsArrayOf(
                createVNode(_component_avatar, utsMapOf("src" to _ctx.item.avatar, "style" to normalizeStyle(utsMapOf("margin-right" to "27rpx"))), null, 8, utsArrayOf(
                    "src",
                    "style"
                )),
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "nickname"), toDisplayString(_ctx.item.name), 1),
                    createElementVNode("text", utsMapOf("class" to "time"), toDisplayString(_ctx.item.create_time), 1)
                )),
                if (isTrue(_ctx.isAdmin)) {
                    createElementVNode("text", utsMapOf("key" to 0, "class" to "iconfont delete-icon", "onClick" to withModifiers(_ctx.deleteItem, utsArrayOf(
                        "stop"
                    ))), toDisplayString("\ue605"), 8, utsArrayOf(
                        "onClick"
                    ));
                } else {
                    createCommentVNode("v-if", true);
                }
            )),
            createElementVNode("text", utsMapOf("class" to "content"), toDisplayString(_ctx.item.content), 1),
            createElementVNode("view", utsMapOf("class" to "quote", "onClick" to withModifiers(_ctx.openDetail, utsArrayOf(
                "stop"
            ))), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "quote-text"), toDisplayString(_ctx.item.article_title), 1),
                if (_ctx.item.article_cover != null) {
                    createElementVNode("image", utsMapOf("key" to 0, "src" to _ctx.item.article_cover, "mode" to "aspectFill", "class" to "quote-img"), null, 8, utsArrayOf(
                        "src"
                    ));
                } else {
                    createCommentVNode("v-if", true);
                }
            ), 8, utsArrayOf(
                "onClick"
            )),
            createElementVNode("view", utsMapOf("class" to "divider"))
        ), 64);
    }
    open var item: CommentItem by `$props`;
    open var isAdmin: Boolean by `$props`;
    override fun `$initMethods`() {
        this.openDetail = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/detail/detail?id=" + this.item.article_id));
        }
        ;
        this.deleteItem = fun() {
            uni_showModal(ShowModalOptions(title = "", content = "是否要删除该评论？", confirmText = "删除", success = fun(res){
                if (!res.confirm) {
                    return;
                }
                uni_showLoading(ShowLoadingOptions(title = "删除中...", mask = true));
                uni_request<defaultResult>(RequestOptions(url = getURL("/comment/delete/" + this.item.id), method = "POST", header = object : UTSJSONObject() {
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
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    this.`$emit`("onDeleteSuccess");
                }
                , fail = fun(err){
                    uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
                }
                , complete = fun(_){
                    uni_hideLoading();
                }
                ));
            }
            ));
        }
        ;
    }
    open lateinit var openDetail: () -> Unit;
    open lateinit var deleteItem: () -> Unit;
    companion object {
        var name = "comment-list-item";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("list-item-header" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "26rpx", "paddingLeft" to "33rpx", "paddingRight" to "33rpx")), "time" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#a7a7a7", "marginTop" to "10rpx")), "nickname" to padStyleMapOf(utsMapOf("color" to "#050505", "textOverflow" to "ellipsis", "maxWidth" to "240rpx", "height" to "34rpx", "fontSize" to 15, "fontWeight" to "bold")), "content" to padStyleMapOf(utsMapOf("paddingTop" to "25rpx", "paddingLeft" to "33rpx", "paddingRight" to "33rpx", "fontSize" to 16, "lineHeight" to 1.5)), "quote" to padStyleMapOf(utsMapOf("width" to "690rpx", "marginLeft" to "30rpx", "marginRight" to "30rpx", "height" to "96rpx", "flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "#f9f9f9", "borderRadius" to 5, "marginTop" to "30rpx", "marginBottom" to "30rpx")), "quote-text" to padStyleMapOf(utsMapOf("width" to "530rpx", "textOverflow" to "ellipsis", "height" to "35rpx", "marginRight" to "30rpx", "marginLeft" to "30rpx", "fontSize" to 15)), "quote-img" to padStyleMapOf(utsMapOf("width" to "96rpx", "height" to "96rpx", "marginLeft" to "auto")), "delete-icon" to padStyleMapOf(utsMapOf("marginLeft" to "auto", "paddingTop" to "10rpx", "paddingRight" to "10rpx", "paddingBottom" to "10rpx", "paddingLeft" to "10rpx", "color" to "#999999")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("onDeleteSuccess" to null);
        var props = normalizePropsOptions(utsMapOf("item" to utsMapOf("type" to "Object", "required" to true), "isAdmin" to utsMapOf("type" to "Boolean", "default" to false)));
        var propsNeedCastKeys = utsArrayOf(
            "isAdmin"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
