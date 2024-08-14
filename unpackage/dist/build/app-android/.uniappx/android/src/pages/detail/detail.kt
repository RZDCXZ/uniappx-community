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
import io.dcloud.uniapp.extapi.`$off` as uni__off;
import io.dcloud.uniapp.extapi.`$on` as uni__on;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesDetailDetail : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(options: OnLoadOptions) {
            if (options.has("id")) {
                this.item.id = parseInt(options.get("id") as String);
                this.loadArticleDetail();
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
        val _component_navbar = resolveEasyComponent("navbar", GenComponentsNavbarNavbarClass);
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        val _component_follow_button = resolveEasyComponent("follow-button", GenComponentsFollowButtonFollowButtonClass);
        val _component_comment = resolveEasyComponent("comment", GenComponentsCommentCommentClass);
        val _component_icon_btn = resolveEasyComponent("icon-btn", GenComponentsIconBtnIconBtnClass);
        val _component_comment_popup = resolveEasyComponent("comment-popup", GenComponentsCommentPopupCommentPopupClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_navbar, utsMapOf("type" to "text", "title" to "社区交友", "right-icon" to "more", "onClickRight" to _ctx.handleShare), null, 8, utsArrayOf(
                "onClickRight"
            )),
            createElementVNode("scroll-view", utsMapOf("scroll-into-view" to _ctx.scrollIntoView, "scroll-with-animation" to true, "style" to normalizeStyle(utsMapOf("flex" to "1")), "onScrolltolower" to _ctx.onScrollBottom), utsArrayOf(
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
                        createElementVNode("text", utsMapOf("class" to "time"), toDisplayString(_ctx.item.create_time) + " · " + toDisplayString(_ctx.item.read_count) + "次阅读", 1)
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
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.item.images, fun(img, imgI, _, _): VNode {
                    return createElementVNode("image", utsMapOf("key" to imgI, "src" to img, "fade-show" to true, "mode" to "widthFix", "class" to "content-image", "onError" to _ctx.imageErrorEvent, "onClick" to withModifiers(fun(){
                        _ctx.previewImage(img);
                    }
                    , utsArrayOf(
                        "stop"
                    ))), null, 40, utsArrayOf(
                        "src",
                        "onError",
                        "onClick"
                    ));
                }
                ), 128),
                createElementVNode("view", utsMapOf("class" to "divider", "id" to "divider")),
                createVNode(_component_comment, utsMapOf("ref" to "comment", "article_id" to _ctx.item.id, "support_count" to _ctx.support_count, "onReply" to _ctx.handleReply), null, 8, utsArrayOf(
                    "article_id",
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
                    )),
                    createVNode(_component_icon_btn, utsMapOf("column" to true, "iconSize" to "18px", "label" to "赞", "icon" to "\ue6eb", "count" to _ctx.ding_count, "active" to (_ctx.action == "ding"), "onClick" to fun(){
                        _ctx.handleSupport("ding");
                    }
                    ), null, 8, utsArrayOf(
                        "count",
                        "active",
                        "onClick"
                    )),
                    createVNode(_component_icon_btn, utsMapOf("column" to true, "iconSize" to "16px", "label" to "踩", "icon" to "\ue701", "count" to _ctx.cai_count, "active" to (_ctx.action == "cai"), "onClick" to fun(){
                        _ctx.handleSupport("cai");
                    }
                    ), null, 8, utsArrayOf(
                        "count",
                        "active",
                        "onClick"
                    )),
                    createVNode(_component_icon_btn, utsMapOf("column" to true, "iconSize" to "18px", "label" to "收藏", "icon" to "\ue629", "count" to _ctx.collect_count, "active" to _ctx.isCollect, "onClick" to _ctx.handleCollect), null, 8, utsArrayOf(
                        "count",
                        "active",
                        "onClick"
                    )),
                    createVNode(_component_icon_btn, utsMapOf("column" to true, "iconSize" to "18px", "label" to "评论", "icon" to "\ue648", "count" to _ctx.comment_count, "onClick" to fun(){
                        _ctx.toggleCommentPopup(true);
                    }
                    ), null, 8, utsArrayOf(
                        "count",
                        "onClick"
                    )),
                    createVNode(_component_icon_btn, utsMapOf("column" to true, "iconSize" to "18px", "label" to "分享", "icon" to "\ue633", "count" to _ctx.share_count, "onClick" to fun(){
                        _ctx.handleShare();
                    }
                    ), null, 8, utsArrayOf(
                        "count",
                        "onClick"
                    ))
                )),
                createVNode(_component_comment_popup, utsMapOf("ref" to "popup", "article_id" to _ctx.item.id), null, 8, utsArrayOf(
                    "article_id"
                ))
            ), 44, utsArrayOf(
                "scroll-into-view",
                "onScrolltolower"
            ))
        ), 64);
    }
    open var isfollow: Boolean by `$data`;
    open var read_count: Number by `$data`;
    open var ding_count: Number by `$data`;
    open var cai_count: Number by `$data`;
    open var action: String by `$data`;
    open var collect_count: Number by `$data`;
    open var isCollect: Boolean by `$data`;
    open var comment_count: Number by `$data`;
    open var share_count: Number by `$data`;
    open var ding_loading: Boolean by `$data`;
    open var cai_loading: Boolean by `$data`;
    open var collectLoading: Boolean by `$data`;
    open var scrollIntoView: String by `$data`;
    open var item: ArticleDetail by `$data`;
    open var support_count: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("isfollow" to false, "read_count" to 0, "ding_count" to 0, "cai_count" to 0, "action" to "", "collect_count" to 0, "isCollect" to false, "comment_count" to 0, "share_count" to 0, "ding_loading" to false, "cai_loading" to false, "collectLoading" to false, "scrollIntoView" to "", "item" to ArticleDetail(id = 0, user_id = 0, title = "", content = "", images = utsArrayOf(), url = "", category_id = 0, topic_id = 0, share_count = 0, ding_count = 0, cai_count = 0, comment_count = 0, read_count = 0, collect_count = 0, create_time = "", update_time = "", name = "", avatar = null, user_status = 1, topic_name = "", user_support_action = "", isfollow = false, isCollect = false), "support_count" to computed<Number>(fun(): Number {
            return Math.floor(this.ding_count + this.cai_count);
        }
        ));
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
        this.handleReply = fun(e: ReplyEmit) {
            AuthAction(fun(){
                var popup = this.`$refs`["popup"] as ComponentPublicInstance;
                popup.`$callMethod`("toggleCommentPopup", true, e.placeholder, e.reply_id);
            }
            );
        }
        ;
        this.onSendCommentSuccess = fun(e: CommentItem) {
            if (e.comment_id != null) {
                return;
            }
            this.comment_count = Math.floor(this.comment_count + 1);
            uni__emit("onUpdateArticleChange", updateArticleChangeEvent(id = this.item.id, key = "updateCommentCount", value = this.comment_count.toString()));
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
                popup.`$callMethod`("toggleCommentPopup", show, null, null);
            }
            );
        }
        ;
        this.handleCollect = fun() {
            AuthAction(fun(){
                if (this.collectLoading) {
                    return;
                }
                this.collectLoading = true;
                var action = if (this.isCollect) {
                    "remove_collection";
                } else {
                    "add_collection";
                }
                ;
                uni_request<defaultResult>(RequestOptions(url = getURL("/" + action + "/" + this.item.id), method = "POST", header = object : UTSJSONObject() {
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
                    this.isCollect = !this.isCollect;
                    this.collect_count = r.data as Number;
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                }
                , fail = fun(err){
                    uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
                }
                , complete = fun(_){
                    this.collectLoading = false;
                }
                ));
            }
            );
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
        this.onScrollBottom = fun() {
            (this.`$refs`["comment"] as ComponentPublicInstance).`$callMethod`("loadCommentList");
        }
        ;
        this.loadArticleDetail = fun() {
            uni_showLoading(ShowLoadingOptions(title = "加载中...", mask = false));
            uni_request<Result<ArticleDetail>>(RequestOptions(url = getURL("/article/" + this.item.id), header = object : UTSJSONObject() {
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
                this.item = r.data as ArticleDetail;
                this.isfollow = this.item.isfollow;
                this.read_count = this.item.read_count;
                this.action = this.item.user_support_action;
                this.ding_count = this.item.ding_count;
                this.cai_count = this.item.cai_count;
                this.collect_count = this.item.collect_count;
                this.isCollect = this.item.isCollect;
                this.comment_count = this.item.comment_count;
                this.share_count = this.item.share_count;
                uni__emit("onUpdateArticleChange", updateArticleChangeEvent(id = this.item.id, key = "updateReadCount", value = this.item.read_count.toString()));
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
        this.handleShare = fun() {
            share("https://www.dishaxy.com");
        }
        ;
        this.openUserSpace = fun(user_id: Number) {
            uni_navigateTo(NavigateToOptions(url = "/pages/user-space/user-space?user_id=" + user_id));
        }
        ;
        this.previewImage = fun(img: String) {
            uni_previewImage(PreviewImageOptions(current = img, urls = this.item.images));
        }
        ;
        this.imageErrorEvent = fun(e: UniImageErrorEvent) {
            e.target?.setAttribute("src", "/static/error-picture.png");
        }
        ;
    }
    open lateinit var onUpdateArticleChange: (e: updateArticleChangeEvent) -> Unit;
    open lateinit var handleReply: (e: ReplyEmit) -> Unit;
    open lateinit var onSendCommentSuccess: (e: CommentItem) -> Unit;
    open lateinit var toggleCommentPopup: (show: Boolean) -> Unit;
    open lateinit var handleCollect: () -> Unit;
    open lateinit var handleSupport: (type: String) -> Unit;
    open lateinit var onScrollBottom: () -> Unit;
    open lateinit var loadArticleDetail: () -> Unit;
    open lateinit var handleShare: () -> Unit;
    open lateinit var openUserSpace: (user_id: Number) -> Unit;
    open lateinit var previewImage: (img: String) -> Unit;
    open lateinit var imageErrorEvent: (e: UniImageErrorEvent) -> Unit;
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
                return utsMapOf("list-item-header" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "26rpx", "paddingLeft" to "33rpx", "paddingRight" to "33rpx")), "time" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#a7a7a7", "marginTop" to "10rpx")), "nickname" to padStyleMapOf(utsMapOf("color" to "#050505", "textOverflow" to "ellipsis", "maxWidth" to "240rpx", "height" to "34rpx", "fontSize" to 15, "fontWeight" to "bold")), "content" to padStyleMapOf(utsMapOf("paddingTop" to "25rpx", "paddingLeft" to "33rpx", "paddingRight" to "33rpx", "fontSize" to 16, "lineHeight" to 1.5, "marginBottom" to "15rpx")), "content-image" to padStyleMapOf(utsMapOf("width" to "750rpx", "backgroundColor" to "#f0f0f0")), "action-bar" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "borderTopWidth" to "1rpx", "borderTopStyle" to "solid", "borderTopColor" to "#f2f2f2", "zIndex" to 100, "height" to "103rpx", "paddingLeft" to "28rpx", "paddingRight" to "28rpx", "flexDirection" to "row", "alignItems" to "center")), "action-input" to padStyleMapOf(utsMapOf("flexDirection" to "row", "backgroundColor" to "#f4f4f4", "height" to "73rpx", "width" to "250rpx", "borderRadius" to 5, "alignItems" to "center", "justifyContent" to "space-between", "paddingTop" to 0, "paddingRight" to "20rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx")), "placeholder" to padStyleMapOf(utsMapOf("fontSize" to 14, "color" to "#949494")), "emotion" to padStyleMapOf(utsMapOf("fontSize" to 20, "color" to "#191919")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
