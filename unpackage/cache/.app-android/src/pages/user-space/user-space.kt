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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh;
open class GenPagesUserSpaceUserSpace : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(options: OnLoadOptions) {
            if (options.has("user_id")) {
                val uid = parseInt(options.get("user_id") as String);
                this.user.id = uid;
            }
            this.loadUserDetail();
            uni__on("onUpdateInfoSuccess", this.onUpdateInfoSuccess);
        }
        , instance);
        onUnload(fun() {
            uni__off("onUpdateInfoSuccess", this.onUpdateInfoSuccess);
        }
        , instance);
        onReady(fun() {
            this.popup = this.`$refs`["popup"] as ComponentPublicInstance;
            this.reportPopup = this.`$refs`["reportPopup"] as ComponentPublicInstance;
        }
        , instance);
        onPullDownRefresh(fun() {
            this.refreshData(fun(){
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
        val _component_navbar = resolveEasyComponent("navbar", GenComponentsNavbarNavbarClass);
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        val _component_navigator = resolveComponent("navigator");
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        val _component_follow_button = resolveEasyComponent("follow-button", GenComponentsFollowButtonFollowButtonClass);
        val _component_long_page = resolveComponent("long-page");
        val _component_head_tabs_swiper = resolveComponent("head-tabs-swiper");
        val _component_popup = resolveEasyComponent("popup", GenComponentsPopupPopupClass);
        val _component_radio = resolveComponent("radio");
        val _component_radio_group = resolveComponent("radio-group");
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_navbar, utsMapOf("type" to "text", "title" to _ctx.title, "right-icon" to "more", "onClickRight" to _ctx.openMore, "showRightIcon" to !_ctx.isSelf), null, 8, utsArrayOf(
                "title",
                "onClickRight",
                "showRightIcon"
            )),
            createVNode(_component_head_tabs_swiper, utsMapOf("tab-center" to true, "tabs" to _ctx.tabs, "onLoadData" to _ctx.loadData, "onChange" to _ctx.onSwiperChange), utsMapOf("header" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "space-header"), utsArrayOf(
                        createVNode(_component_avatar, utsMapOf("src" to _ctx.user.avatar, "width" to "162rpx", "height" to "162rpx", "style" to normalizeStyle(utsMapOf("margin-right" to "27rpx"))), null, 8, utsArrayOf(
                            "src",
                            "style"
                        )),
                        createElementVNode("view", utsMapOf("class" to "flex-1"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "space-data"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "space-data-item"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "space-data-value"), toDisplayString(_ctx.user.articles_count), 1),
                                    createElementVNode("text", utsMapOf("class" to "space-data-title"), "帖子")
                                )),
                                createVNode(_component_navigator, utsMapOf("class" to "space-data-item", "url" to ("/pages/user-follow-list/user-follow-list?user_id=" + _ctx.user.id)), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "space-data-value"), toDisplayString(_ctx.user.follows_count), 1),
                                        createElementVNode("text", utsMapOf("class" to "space-data-title"), "关注")
                                    );
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "url"
                                )),
                                createVNode(_component_navigator, utsMapOf("class" to "space-data-item", "url" to ("/pages/user-fans-list/user-fans-list?user_id=" + _ctx.user.id)), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "space-data-value"), toDisplayString(_ctx.user.fans_count), 1),
                                        createElementVNode("text", utsMapOf("class" to "space-data-title"), "粉丝")
                                    );
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "url"
                                ))
                            )),
                            if (isTrue(_ctx.isSelf)) {
                                createElementVNode("view", utsMapOf("key" to 0, "class" to "space-actions"), utsArrayOf(
                                    createVNode(_component_main_btn, utsMapOf("onClick" to fun(){
                                        _ctx.openUserEditInfo();
                                    }, "width" to "330rpx", "height" to "65rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            "编辑资料"
                                        );
                                    }), "_" to 1), 8, utsArrayOf(
                                        "onClick"
                                    ))
                                ));
                            } else {
                                createElementVNode("view", utsMapOf("key" to 1, "class" to "space-actions"), utsArrayOf(
                                    if (isTrue(_ctx.isblacked)) {
                                        createVNode(_component_main_btn, utsMapOf("key" to 0, "onClick" to fun(){
                                            _ctx.handleBlack();
                                        }, "width" to "330rpx", "height" to "65rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                "解除拉黑"
                                            );
                                        }), "_" to 1), 8, utsArrayOf(
                                            "onClick"
                                        ));
                                    } else {
                                        createVNode(_component_follow_button, utsMapOf("key" to 1, "type" to "main-btn", "user_id" to _ctx.user.id, "modelValue" to _ctx.isfollow, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            _ctx.isfollow = `$event`;
                                        }
                                        ), null, 8, utsArrayOf(
                                            "user_id",
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ));
                                    }
                                    ,
                                    createElementVNode("view", utsMapOf("class" to "space-action-msg", "onClick" to _ctx.openChat), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "iconfont space-action-msg-icon"), toDisplayString("\ue648"))
                                    ), 8, utsArrayOf(
                                        "onClick"
                                    ))
                                ));
                            }
                        ))
                    )),
                    createElementVNode("text", utsMapOf("class" to "space-info"), toDisplayString(if (_ctx.user.desc == null) {
                        "暂无描述~";
                    } else {
                        _ctx.user.desc;
                    }
                    ), 1),
                    createElementVNode("text", utsMapOf("class" to "space-info"), "地区：" + toDisplayString(if (_ctx.user.path == null) {
                        "未知";
                    } else {
                        _ctx.user.path;
                    }
                    ), 1),
                    createElementVNode("view", utsMapOf("class" to "space-tags"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "space-tag"), toDisplayString(_ctx.sex), 1),
                        createElementVNode("text", utsMapOf("class" to "space-tag"), toDisplayString(_ctx.user.age) + "岁", 1),
                        if (_ctx.user.birthday != null) {
                            createElementVNode("text", utsMapOf("key" to 0, "class" to "space-tag"), toDisplayString(_ctx.user.birthday), 1);
                        } else {
                            createCommentVNode("v-if", true);
                        }
                    ))
                );
            }
            ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.tabs, fun(item, index, _, _): VNode {
                        return createElementVNode("swiper-item", utsMapOf("class" to "flex-1", "key" to index), utsArrayOf(
                            createVNode(_component_long_page, utsMapOf("isAdmin" to _ctx.isSelf, "ref_for" to true, "ref" to "longPage", "page" to "user-space", "id" to ("list_" + item.id), "user_id" to _ctx.user.id, "type" to item.type, "preload" to item.preload, "onOnDeleteSuccess" to _ctx.loadUserDetail), null, 8, utsArrayOf(
                                "isAdmin",
                                "id",
                                "user_id",
                                "type",
                                "preload",
                                "onOnDeleteSuccess"
                            ))
                        ));
                    }
                    ), 128)
                );
            }
            ), "_" to 1), 8, utsArrayOf(
                "tabs",
                "onLoadData",
                "onChange"
            )),
            createVNode(_component_popup, utsMapOf("ref" to "popup"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "more-popup"), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "more-item", "onClick" to _ctx.handleBlack), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "iconfont more-item-icon"), toDisplayString("\ue60a")),
                            createElementVNode("text", null, toDisplayString(if (_ctx.isblacked) {
                                "解除拉黑";
                            } else {
                                "拉黑";
                            }
                            ), 1)
                        ), 8, utsArrayOf(
                            "onClick"
                        )),
                        createElementVNode("view", utsMapOf("class" to "more-item", "onClick" to fun(){
                            _ctx.openReportPopup();
                        }
                        ), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "iconfont more-item-icon"), toDisplayString("\ue6f7")),
                            createElementVNode("text", null, "举报")
                        ), 8, utsArrayOf(
                            "onClick"
                        ))
                    ))
                );
            }
            ), "_" to 1), 512),
            createVNode(_component_popup, utsMapOf("ref" to "reportPopup", "title" to "举报原因", "show-cancel" to false, "onConfirm" to _ctx.confirmReport), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createVNode(_component_radio_group, utsMapOf("name" to "reason", "style" to normalizeStyle(utsMapOf("height" to "940rpx", "width" to "750rpx")), "onChange" to _ctx.handleReportChange), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.reasonOptions, fun(r, ri, _, _): VNode {
                                return createElementVNode("view", utsMapOf("key" to ri), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "reason-title"), toDisplayString(r.title), 1),
                                    createElementVNode("view", utsMapOf("class" to "reason-box"), utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(r.list, fun(s, sI, _, _): VNode {
                                            return createVNode(_component_radio, utsMapOf("color" to "#F06487", "class" to "reason-item", "key" to sI, "value" to s), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "reason-item-text"), toDisplayString(s), 1)
                                                );
                                            }
                                            ), "_" to 2), 1032, utsArrayOf(
                                                "value"
                                            ));
                                        }
                                        ), 128)
                                    ))
                                ));
                            }
                            ), 128)
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "style",
                        "onChange"
                    ))
                );
            }
            ), "_" to 1), 8, utsArrayOf(
                "onConfirm"
            ))
        ), 64);
    }
    open var tabIndex: Number by `$data`;
    open var tabs: UTSArray<TabsSwiperItem> by `$data`;
    open var title: String by `$data`;
    open var isfollow: Boolean by `$data`;
    open var isblacked: Boolean by `$data`;
    open var user: UserDetail2 by `$data`;
    open var popup: ComponentPublicInstance? by `$data`;
    open var reportPopup: ComponentPublicInstance? by `$data`;
    open var reasonContent: String by `$data`;
    open var reasonOptions: UTSArray<ReasonOption> by `$data`;
    open var sex: String by `$data`;
    open var isSelf: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("tabIndex" to 0, "tabs" to utsArrayOf<TabsSwiperItem>(TabsSwiperItem(id = 1, name = "帖子", type = "article", preload = false), TabsSwiperItem(id = 2, name = "评论", type = "comment", preload = false)), "title" to "个人空间", "isfollow" to false, "isblacked" to false, "user" to UserDetail2(name = "", id = 0, avatar = "", status = 1, age = 0, sex = 0, qg = 0, job = null, path = null, birthday = null, desc = null, fans_count = 0, follows_count = 0, articles_count = 0, comments_count = 0, isfollow = false, isblacked = false), "popup" to null as ComponentPublicInstance?, "reportPopup" to null as ComponentPublicInstance?, "reasonContent" to "", "reasonOptions" to utsArrayOf<ReasonOption>(ReasonOption(title = "违规", list = utsArrayOf(
            "低俗色情",
            "侮辱谩骂",
            "违法行为",
            "政治敏感",
            "垃圾广告",
            "未成年人有害行为"
        )), ReasonOption(title = "不友善", list = utsArrayOf(
            "不尊重女性",
            "引战、制造冲突",
            "恶意诋毁",
            "刷水/骗赞",
            "感官不适"
        )), ReasonOption(title = "个人信息问题", list = utsArrayOf(
            "头像/昵称/签名违规",
            "冒充官号/其他用户"
        ))), "sex" to computed<String>(fun(): String {
            return getSexText(this.user.sex);
        }
        ), "isSelf" to computed<Boolean>(fun(): Boolean {
            return this.user.id === userState.id;
        }
        ));
    }
    override fun `$initMethods`() {
        this.openChat = fun() {
            AuthAction(fun(){
                uni_showLoading(ShowLoadingOptions(title = "发起聊天中...", mask = true));
                uni_request<Result<Conversation>>(RequestOptions(url = getURL("/im/create_conversation"), method = "POST", header = object : UTSJSONObject() {
                    var token = getToken()
                }, data = let {
                    object : UTSJSONObject() {
                        var target_id = it.user.id
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
                    var resData = r.data as Conversation;
                    uni__emit("onUpdateConversation", resData);
                    uni_navigateTo(NavigateToOptions(url = "/pages/chat/chat?id=" + resData.id + "&target_id=" + resData.target_id + "&title=" + resData.name));
                }
                , fail = fun(err){
                    uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
                }
                , complete = fun(_){
                    uni_hideLoading();
                }
                ));
            }
            );
        }
        ;
        this.onUpdateInfoSuccess = fun(_: String) {
            this.loadUserDetail();
            this.refreshData(null);
        }
        ;
        this.openUserEditInfo = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/user-editinfo/user-editinfo"));
        }
        ;
        this.handleReportChange = fun(e: UniRadioGroupChangeEvent) {
            this.reasonContent = e.detail.value;
        }
        ;
        this.confirmReport = fun() {
            AuthAction(fun(){
                uni_showLoading(ShowLoadingOptions(title = "提交中...", mask = true));
                uni_request<defaultResult>(RequestOptions(url = getURL("/report/save"), method = "POST", header = object : UTSJSONObject() {
                    var token = getToken()
                }, data = let {
                    object : UTSJSONObject() {
                        var report_uid = it.user.id
                        var content = it.reasonContent
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
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                }
                , fail = fun(err){
                    uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
                }
                , complete = fun(_){
                    uni_hideLoading();
                    setTimeout(fun(){
                        this.reportPopup?.`$callMethod`("close");
                    }
                    , 400);
                }
                ));
            }
            );
        }
        ;
        this.openReportPopup = fun() {
            this.popup?.`$callMethod`("close");
            this.reportPopup?.`$callMethod`("open");
        }
        ;
        this.refreshData = fun(loadComplete: (() -> Unit)?) {
            (this.`$refs`["longPage"] as UTSArray<ComponentPublicInstance>)[this.tabIndex].`$callMethod`("refreshData", loadComplete);
        }
        ;
        this.handleBlack = fun() {
            this.popup?.`$callMethod`("close");
            if (this.isblacked) {
                this.doBlack();
                return;
            }
            uni_showModal(ShowModalOptions(title = "确定拉黑用户？", content = "拉黑后用户不能关注你，给你评论及@你，你也将不会再推荐此用户内容", confirmText = "直接拉黑", success = fun(res){
                if (res.confirm) {
                    this.doBlack();
                }
            }
            ));
        }
        ;
        this.doBlack = fun() {
            AuthAction(fun(){
                uni_showLoading(ShowLoadingOptions(title = "操作中...", mask = true));
                var action = if (!this.isblacked) {
                    "add_blacklist";
                } else {
                    "remove_blacklist";
                }
                ;
                uni_request<defaultResult>(RequestOptions(url = getURL("/" + action + "/" + this.user.id), method = "POST", header = object : UTSJSONObject() {
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
                    this.isblacked = !this.isblacked;
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    this.refreshData(null);
                }
                , fail = fun(err){
                    uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
                }
                , complete = fun(_){
                    uni_hideLoading();
                }
                ));
            }
            );
        }
        ;
        this.openMore = fun() {
            this.popup?.`$callMethod`("open");
        }
        ;
        this.loadUserDetail = fun() {
            uni_showLoading(ShowLoadingOptions(title = "加载中...", mask = false));
            uni_request<Result<UserDetail2>>(RequestOptions(url = getURL("/user_info/" + this.user.id), header = object : UTSJSONObject() {
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
                this.user = r.data as UserDetail2;
                if (this.user.name != null) {
                    this.title = this.user.name as String;
                }
                this.isfollow = this.user.isfollow as Boolean;
                this.isblacked = this.user.isblacked as Boolean;
                this.loadData(this.tabIndex);
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
        this.loadData = fun(index: Number) {
            (this.`$refs`["longPage"] as UTSArray<ComponentPublicInstance>)[index].`$callMethod`("loadData", null);
        }
        ;
        this.onSwiperChange = fun(i: Number) {
            this.tabIndex = i;
        }
        ;
    }
    open lateinit var openChat: () -> Unit;
    open lateinit var onUpdateInfoSuccess: (_: String) -> Unit;
    open lateinit var openUserEditInfo: () -> Unit;
    open lateinit var handleReportChange: (e: UniRadioGroupChangeEvent) -> Unit;
    open lateinit var confirmReport: () -> Unit;
    open lateinit var openReportPopup: () -> Unit;
    open lateinit var refreshData: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var handleBlack: () -> Unit;
    open lateinit var doBlack: () -> Unit;
    open lateinit var openMore: () -> Unit;
    open lateinit var loadUserDetail: () -> Unit;
    open lateinit var loadData: (index: Number) -> Unit;
    open lateinit var onSwiperChange: (i: Number) -> Unit;
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
                return utsMapOf("space-header" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "35rpx", "paddingRight" to "35rpx", "paddingBottom" to "35rpx", "paddingLeft" to "35rpx")), "space-data" to padStyleMapOf(utsMapOf("flexDirection" to "row", "marginBottom" to "25rpx")), "space-data-item" to padStyleMapOf(utsMapOf("flex" to 1, "justifyContent" to "center", "alignItems" to "center")), "space-data-value" to padStyleMapOf(utsMapOf("fontSize" to 22, "color" to "#070707", "fontWeight" to "bold")), "space-data-title" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#101010")), "space-actions" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "center")), "space-action-msg" to padStyleMapOf(utsMapOf("width" to "65rpx", "height" to "65rpx", "borderRadius" to 5, "borderWidth" to "1rpx", "borderStyle" to "solid", "borderColor" to "#dedede", "alignItems" to "center", "justifyContent" to "center", "marginLeft" to "10rpx")), "space-action-msg-icon" to padStyleMapOf(utsMapOf("fontSize" to 20, "color" to "#535353")), "space-info" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to "35rpx", "paddingBottom" to 0, "paddingLeft" to "35rpx", "marginTop" to "15rpx", "lineHeight" to 1.5, "fontSize" to 15, "color" to "#8e8e90")), "space-tags" to padStyleMapOf(utsMapOf("flexDirection" to "row", "paddingTop" to 0, "paddingRight" to "35rpx", "paddingBottom" to 0, "paddingLeft" to "35rpx", "marginTop" to "15rpx", "marginBottom" to "20rpx")), "space-tag" to padStyleMapOf(utsMapOf("fontSize" to 12, "borderWidth" to "1rpx", "borderStyle" to "solid", "borderColor" to "#e0e0e0", "borderRadius" to 50, "paddingTop" to "10rpx", "paddingRight" to "20rpx", "paddingBottom" to "10rpx", "paddingLeft" to "20rpx", "marginRight" to "10rpx")), "more-popup" to padStyleMapOf(utsMapOf("height" to "230rpx", "backgroundColor" to "#f4f4f4", "flexDirection" to "row")), "more-item" to padStyleMapOf(utsMapOf("flex" to 1, "alignItems" to "center", "justifyContent" to "center")), "more-item-icon" to padStyleMapOf(utsMapOf("fontSize" to 25, "marginBottom" to "25rpx", "backgroundColor" to "#ffffff", "width" to "100rpx", "height" to "100rpx", "textAlign" to "center", "lineHeight" to "100rpx", "borderRadius" to 50, "color" to "#5a5a5a")), "reason-title" to padStyleMapOf(utsMapOf("fontSize" to 15, "marginTop" to "35rpx", "marginRight" to "30rpx", "marginBottom" to "35rpx", "marginLeft" to "30rpx", "color" to "#828282")), "reason-box" to padStyleMapOf(utsMapOf("flexDirection" to "row", "flexWrap" to "wrap")), "reason-item" to padStyleMapOf(utsMapOf("width" to "375rpx", "flexDirection" to "row", "paddingLeft" to "30rpx", "paddingBottom" to "35rpx")), "reason-item-text" to padStyleMapOf(utsMapOf("marginLeft" to "10rpx", "width" to "260rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf("headTabsSwiper" to GenComponentsTabsSwiperHeadTabsSwiperClass, "longPage" to GenPagesLongListLongListPageClass);
    }
}
