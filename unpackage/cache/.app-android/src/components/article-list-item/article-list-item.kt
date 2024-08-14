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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenComponentsArticleListItemArticleListItem : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onCreated(fun() {
            this.isfollow = this.item.isfollow;
            this.action = this.item.user_support_action;
            this.ding_count = this.item.ding_count;
            this.cai_count = this.item.cai_count;
            this.read_count = this.item.read_count;
            this.comment_count = this.item.comment_count;
        }
        , instance);
        onCreated(fun() {
            this.isfollow = this.item.isfollow;
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        val _component_follow_button = resolveEasyComponent("follow-button", GenComponentsFollowButtonFollowButtonClass);
        val _component_icon_btn = resolveEasyComponent("icon-btn", GenComponentsIconBtnIconBtnClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "list-item-header", "onClick" to withModifiers(_ctx.openDetail, utsArrayOf(
                "stop"
            ))), utsArrayOf(
                createVNode(_component_avatar, utsMapOf("src" to _ctx.item.avatar, "style" to normalizeStyle(utsMapOf("margin-right" to "27rpx")), "onClick" to withModifiers(_ctx.openUserSpace, utsArrayOf(
                    "stop"
                ))), null, 8, utsArrayOf(
                    "src",
                    "style",
                    "onClick"
                )),
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "nickname", "onClick" to withModifiers(_ctx.openUserSpace, utsArrayOf(
                        "stop"
                    ))), toDisplayString(_ctx.item.name), 9, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("text", utsMapOf("class" to "time"), toDisplayString(_ctx.item.create_time) + " · " + toDisplayString(_ctx.read_count) + "次阅读", 1)
                )),
                if (isTrue(_ctx.isAdmin)) {
                    createElementVNode("text", utsMapOf("key" to 0, "class" to "iconfont delete-icon", "onClick" to withModifiers(_ctx.deleteItem, utsArrayOf(
                        "stop"
                    ))), toDisplayString("\ue605"), 8, utsArrayOf(
                        "onClick"
                    ));
                } else {
                    createVNode(_component_follow_button, utsMapOf("key" to 1, "modelValue" to _ctx.isfollow, "onUpdate:modelValue" to fun(`$event`: Boolean){
                        _ctx.isfollow = `$event`;
                    }
                    , "user_id" to _ctx.item.user_id), null, 8, utsArrayOf(
                        "modelValue",
                        "onUpdate:modelValue",
                        "user_id"
                    ));
                }
            ), 8, utsArrayOf(
                "onClick"
            )),
            createElementVNode("text", utsMapOf("class" to "content", "onClick" to withModifiers(_ctx.openDetail, utsArrayOf(
                "stop"
            ))), toDisplayString(_ctx.item.title), 9, utsArrayOf(
                "onClick"
            )),
            createElementVNode("view", utsMapOf("class" to "content-media", "onClick" to withModifiers(_ctx.openDetail, utsArrayOf(
                "stop"
            ))), utsArrayOf(
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.item.images, fun(img, imgI, _, _): VNode {
                    return createElementVNode("image", utsMapOf("key" to imgI, "src" to img, "fade-show" to true, "mode" to "aspectFill", "class" to normalizeClass(utsArrayOf(
                        "content-image",
                        _ctx.imageClass
                    ))), null, 10, utsArrayOf(
                        "src"
                    ));
                }
                ), 128)
            ), 8, utsArrayOf(
                "onClick"
            )),
            if (_ctx.item.topic_name != null) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "topic-tag", "onClick" to withModifiers(_ctx.openTopicDetail, utsArrayOf(
                    "stop"
                ))), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "topic-tag-icon"), "#"),
                    createElementVNode("text", utsMapOf("class" to "topic-tag-title"), toDisplayString(_ctx.item.topic_name), 1),
                    createElementVNode("text", utsMapOf("class" to "iconfont topic-tag-more"), toDisplayString("\ue60c"))
                ), 8, utsArrayOf(
                    "onClick"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode("view", utsMapOf("class" to "actions"), utsArrayOf(
                createVNode(_component_icon_btn, utsMapOf("label" to "赞", "icon" to "\ue6eb", "count" to _ctx.ding_count, "active" to (_ctx.action == "ding"), "onClick" to fun(){
                    _ctx.handleSupport("ding");
                }
                ), null, 8, utsArrayOf(
                    "count",
                    "active",
                    "onClick"
                )),
                createVNode(_component_icon_btn, utsMapOf("label" to "踩", "icon" to "\ue701", "count" to _ctx.cai_count, "active" to (_ctx.action == "cai"), "onClick" to fun(){
                    _ctx.handleSupport("cai");
                }
                ), null, 8, utsArrayOf(
                    "count",
                    "active",
                    "onClick"
                )),
                createVNode(_component_icon_btn, utsMapOf("label" to "评论", "icon" to "\ue648", "count" to _ctx.comment_count, "onClick" to _ctx.openDetail), null, 8, utsArrayOf(
                    "count",
                    "onClick"
                )),
                createVNode(_component_icon_btn, utsMapOf("label" to "分享", "icon" to "\ue633", "count" to _ctx.item.share_count, "onClick" to _ctx.openDetail), null, 8, utsArrayOf(
                    "count",
                    "onClick"
                ))
            )),
            createElementVNode("view", utsMapOf("class" to "divider"))
        ), 64);
    }
    open var item: ListItem by `$props`;
    open var inTopicDetail: Boolean by `$props`;
    open var inUserSpace: Boolean by `$props`;
    open var isAdmin: Boolean by `$props`;
    open var isfollow: Boolean by `$data`;
    open var action: String by `$data`;
    open var ding_count: Number by `$data`;
    open var ding_loading: Boolean by `$data`;
    open var cai_count: Number by `$data`;
    open var cai_loading: Boolean by `$data`;
    open var read_count: Number by `$data`;
    open var comment_count: Number by `$data`;
    open var imageClass: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("isfollow" to false, "action" to "", "ding_count" to 0, "ding_loading" to false, "cai_count" to 0, "cai_loading" to false, "read_count" to 0, "comment_count" to 0, "imageClass" to computed<String>(fun(): String {
            val count = this.item.images.length;
            if (count == 1) {
                return "one-image";
            } else if (count == 2) {
                return "two-image";
            } else {
                return "more-image";
            }
        }
        ));
    }
    override fun `$initMethods`() {
        this.deleteItem = fun() {
            uni_showModal(ShowModalOptions(title = "", content = "是否要删除该帖子？", confirmText = "删除", success = fun(res){
                if (!res.confirm) {
                    return;
                }
                uni_showLoading(ShowLoadingOptions(title = "删除中...", mask = true));
                uni_request<defaultResult>(RequestOptions(url = getURL("/article/delete/" + this.item.id), method = "POST", header = object : UTSJSONObject() {
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
        this.openUserSpace = fun() {
            if (this.inUserSpace) {
                return;
            }
            uni_navigateTo(NavigateToOptions(url = "/pages/user-space/user-space?user_id=" + this.item.user_id));
        }
        ;
        this.updateCommentCount = fun(count: Number) {
            this.comment_count = count;
        }
        ;
        this.updateReadCount = fun(count: Number) {
            this.read_count = count;
        }
        ;
        this.openTopicDetail = fun() {
            if (this.inTopicDetail) {
                return;
            }
            uni_navigateTo(NavigateToOptions(url = "/pages/topic-detail/topic-detail?id=" + this.item.topic_id));
        }
        ;
        this.openDetail = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/detail/detail?id=" + this.item.id));
        }
        ;
        this.updateFollow = fun(value: Boolean) {
            this.isfollow = value;
        }
        ;
        this.updateSupport = fun(e: updateSupportEvent) {
            this.action = e.action;
            this.ding_count = e.ding_count;
            this.cai_count = e.cai_count;
        }
        ;
        this.handleSupport = fun(type: String) {
            AuthAction(fun(){
                if (this.ding_loading || this.cai_loading) {
                    return;
                }
                if (type == "ding") {
                    this.ding_loading = true;
                } else {
                    this.cai_loading = true;
                }
                uni_request<defaultResult>(RequestOptions(url = getURL("/support/" + type + "/" + this.item.id), method = "POST", header = object : UTSJSONObject() {
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
                    if (this.action == "") {
                        if (type == "ding") {
                            this.ding_count = stepInt(this.ding_count);
                        } else {
                            this.cai_count = stepInt(this.cai_count);
                        }
                        this.action = type;
                    } else if (this.action == type) {
                        if (type == "ding") {
                            this.ding_count = stepInt(this.ding_count, "-");
                        } else {
                            this.cai_count = stepInt(this.cai_count, "-");
                        }
                        this.action = "";
                    } else {
                        if (type == "ding") {
                            this.ding_count = stepInt(this.ding_count);
                            this.cai_count = stepInt(this.cai_count, "-");
                        } else {
                            this.cai_count = stepInt(this.cai_count);
                            this.ding_count = stepInt(this.ding_count, "-");
                        }
                        this.action = type;
                    }
                    uni__emit("onUpdateArticleChange", updateArticleChangeEvent(id = this.item.id, key = "updateSupport", value = JSON.stringify(updateSupportEvent(ding_count = this.ding_count, cai_count = this.cai_count, action = this.action))));
                }
                , fail = fun(err){
                    uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
                }
                , complete = fun(_){
                    this.ding_loading = false;
                    this.cai_loading = false;
                }
                ));
            }
            );
        }
        ;
    }
    open lateinit var deleteItem: () -> Unit;
    open lateinit var openUserSpace: () -> Unit;
    open lateinit var updateCommentCount: (count: Number) -> Unit;
    open lateinit var updateReadCount: (count: Number) -> Unit;
    open lateinit var openTopicDetail: () -> Unit;
    open lateinit var openDetail: () -> Unit;
    open lateinit var updateFollow: (value: Boolean) -> Unit;
    open lateinit var updateSupport: (e: updateSupportEvent) -> Unit;
    open lateinit var handleSupport: (type: String) -> Unit;
    companion object {
        var name = "article-list-item";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("list-item-header" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "26rpx", "paddingLeft" to "33rpx", "paddingRight" to "33rpx")), "time" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#a7a7a7", "marginTop" to "10rpx")), "nickname" to padStyleMapOf(utsMapOf("color" to "#050505", "textOverflow" to "ellipsis", "maxWidth" to "240rpx", "height" to "34rpx", "fontSize" to 15, "fontWeight" to "bold")), "content" to padStyleMapOf(utsMapOf("paddingTop" to "25rpx", "paddingLeft" to "33rpx", "paddingRight" to "33rpx", "fontSize" to 16, "lineHeight" to 1.5)), "content-media" to padStyleMapOf(utsMapOf("flexDirection" to "row", "flexWrap" to "wrap", "paddingLeft" to "10rpx")), "content-image" to padStyleMapOf(utsMapOf("marginTop" to "10rpx", "marginRight" to "10rpx", "backgroundColor" to "#f0f0f0")), "one-image" to padStyleMapOf(utsMapOf("width" to "730rpx", "height" to "730rpx")), "two-image" to padStyleMapOf(utsMapOf("width" to "360rpx", "height" to "360rpx")), "more-image" to padStyleMapOf(utsMapOf("height" to "236rpx", "width" to "236rpx")), "topic-tag" to padStyleMapOf(utsMapOf("flexDirection" to "row", "marginTop" to "25rpx", "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "backgroundColor" to "#fff3f7", "borderRadius" to 50, "paddingTop" to "8rpx", "paddingRight" to "20rpx", "paddingBottom" to "8rpx", "paddingLeft" to "20rpx", "alignItems" to "center", "alignSelf" to "flex-start")), "topic-tag-icon" to padStyleMapOf(utsMapOf("fontWeight" to "bold", "marginTop" to 0, "marginRight" to "10rpx", "marginBottom" to 0, "marginLeft" to "10rpx", "fontSize" to 18, "color" to "#fb5e7d")), "topic-tag-title" to padStyleMapOf(utsMapOf("color" to "#000000", "fontSize" to 14)), "actions" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "height" to "105rpx")), "delete-icon" to padStyleMapOf(utsMapOf("marginLeft" to "auto", "paddingTop" to "10rpx", "paddingRight" to "10rpx", "paddingBottom" to "10rpx", "paddingLeft" to "10rpx", "color" to "#999999")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("onDeleteSuccess" to null);
        var props = normalizePropsOptions(utsMapOf("item" to utsMapOf("type" to "Object", "required" to true), "inTopicDetail" to utsMapOf("type" to "Boolean", "default" to false), "inUserSpace" to utsMapOf("type" to "Boolean", "default" to false), "isAdmin" to utsMapOf("type" to "Boolean", "default" to false)));
        var propsNeedCastKeys = utsArrayOf(
            "inTopicDetail",
            "inUserSpace",
            "isAdmin"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
