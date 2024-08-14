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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenComponentsCommentComment : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onCreated(fun() {
            this.loadCommentList();
            uni__on("onSendCommentSuccess", this.onSendCommentSuccess);
        }
        , instance);
        onUnmounted(fun() {
            uni__off("onSendCommentSuccess", this.onSendCommentSuccess);
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_tip = resolveEasyComponent("tip", GenComponentsTipTipClass);
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        val _component_loading_more = resolveEasyComponent("loading-more", GenComponentsLoadingMoreLoadingMoreClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "comment-section"), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "comment-title"), toDisplayString(if (_ctx.isreply) {
                    "" + _ctx.support_count + " \u6761\u56DE\u590D";
                } else {
                    "评论";
                }
                ), 1),
                if (isTrue(!_ctx.isreply)) {
                    createElementVNode("text", utsMapOf("key" to 0, "class" to "comment-count"), toDisplayString(_ctx.support_count) + "人表态", 1);
                } else {
                    createCommentVNode("v-if", true);
                }
            )),
            if (isTrue(_ctx.commentList.length == 0 && !_ctx.isFirstLoad)) {
                createVNode(_component_tip, utsMapOf("key" to 0, "title" to "暂无评论~"));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.commentList, fun(ct, ctI, _, _): VNode {
                return createElementVNode("view", utsMapOf("class" to "comment", "key" to ctI), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "flex"), utsArrayOf(
                        createVNode(_component_avatar, utsMapOf("src" to ct.avatar, "style" to normalizeStyle(utsMapOf("margin-right" to "27rpx")), "onClick" to fun(){
                            _ctx.openUserSpace(ct.user_id);
                        }
                        ), null, 8, utsArrayOf(
                            "src",
                            "style",
                            "onClick"
                        )),
                        createElementVNode("text", utsMapOf("class" to "comment-nickname", "onClick" to fun(){
                            _ctx.openUserSpace(ct.user_id);
                        }
                        ), toDisplayString(ct.name), 9, utsArrayOf(
                            "onClick"
                        )),
                        createElementVNode("text", utsMapOf("class" to "comment-time"), toDisplayString(ct.create_time), 1)
                    )),
                    createElementVNode("text", utsMapOf("class" to "comment-content"), toDisplayString(ct.content), 1),
                    if (ct.quote != null) {
                        createElementVNode("rich-text", utsMapOf("key" to 0, "class" to "comment-quote", "nodes" to ("<a href='/pages/user-space/user-space?user_id=" + ct.quote?.user_id + "'>" + ct.quote?.name + "</a>\uFF1A<span>" + ct.quote?.content + "</span>"), "onItemclick" to _ctx.handleRichItemClick), null, 40, utsArrayOf(
                            "nodes",
                            "onItemclick"
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                    ,
                    if (ct.reply_count > 0) {
                        createElementVNode("view", utsMapOf("key" to 1, "class" to "reply", "hover-class" to "reply-hover", "onClick" to fun(){
                            _ctx.openCommentDetail(ct.id);
                        }), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "reply-text"), toDisplayString(ct.reply_count) + "条回复", 1),
                            createElementVNode("text", utsMapOf("class" to "iconfont reply-icon"), toDisplayString("\ue60c"))
                        ), 8, utsArrayOf(
                            "onClick"
                        ));
                    } else {
                        createElementVNode("view", utsMapOf("key" to 2, "class" to "reply", "style" to normalizeStyle(if (_ctx.isreply) {
                            "background:#ffffff;";
                        } else {
                            "";
                        }
                        ), "hover-class" to "reply-hover", "onClick" to fun(){
                            _ctx.handleReply(ct.name, ct.id);
                        }
                        ), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "reply-text"), "回复")
                        ), 12, utsArrayOf(
                            "onClick"
                        ));
                    }
                ));
            }
            ), 128),
            if (isTrue(_ctx.isFirstLoad || _ctx.commentList.length > 0)) {
                createVNode(_component_loading_more, utsMapOf("key" to 1, "loading" to _ctx.loading, "isEnded" to _ctx.isEnded), null, 8, utsArrayOf(
                    "loading",
                    "isEnded"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ), 64);
    }
    open var support_count: Number by `$props`;
    open var article_id: Number by `$props`;
    open var isreply: Boolean by `$props`;
    open var comment_id: Number by `$props`;
    open var commentList: UTSArray<CommentItem> by `$data`;
    open var isEnded: Boolean by `$data`;
    open var currentPage: Number by `$data`;
    open var loading: Boolean by `$data`;
    open var isFirstLoad: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("commentList" to utsArrayOf<CommentItem>(), "isEnded" to false, "currentPage" to 1, "loading" to false, "isFirstLoad" to true);
    }
    override fun `$initMethods`() {
        this.handleRichItemClick = fun(e: UniRichTextItemClickEvent) {
            uni_navigateTo(NavigateToOptions(url = e.detail.href as String));
        }
        ;
        this.handleReply = fun(name: String?, reply_id: Number) {
            val placeholder = "回复@" + name;
            this.`$emit`("reply", ReplyEmit(placeholder = placeholder, reply_id = reply_id));
        }
        ;
        this.onSendCommentSuccess = fun(e: CommentItem) {
            if (!this.isreply && e.comment_id != null) {
                var i = this.commentList.findIndex(fun(o: CommentItem): Boolean {
                    return o.id == e.comment_id;
                });
                if (i == -1) {
                    return;
                }
                this.commentList[i].reply_count = Math.floor(this.commentList[i].reply_count + 1);
            } else {
                this.commentList = utsArrayOf(
                    e
                ).concat(this.commentList);
            }
        }
        ;
        this.openUserSpace = fun(user_id: Number) {
            uni_navigateTo(NavigateToOptions(url = "/pages/user-space/user-space?user_id=" + user_id));
        }
        ;
        this.openCommentDetail = fun(id: Number) {
            uni_navigateTo(NavigateToOptions(url = "/pages/comment-detail/comment-detail?id=" + id));
        }
        ;
        this.loadCommentList = fun() {
            if (this.loading || this.isEnded) {
                return;
            }
            this.loading = true;
            val page = Math.floor(this.currentPage);
            var url = "/article/" + this.article_id + "/comment/" + page;
            if (this.isreply) {
                url = "/comment/" + this.comment_id + "/replies/" + page;
            }
            uni_request<Result<CommentItemResult>>(RequestOptions(url = getURL(url), success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                val resData = r.data as CommentItemResult?;
                if (resData == null) {
                    return;
                }
                this.isEnded = resData.last_page <= resData.current_page;
                if (this.currentPage == 1) {
                    this.commentList = resData.data;
                } else {
                    this.commentList.push(*resData.data.toTypedArray());
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
            }
            ));
        }
        ;
    }
    open lateinit var handleRichItemClick: (e: UniRichTextItemClickEvent) -> Unit;
    open lateinit var handleReply: (name: String?, reply_id: Number) -> Unit;
    open lateinit var onSendCommentSuccess: (e: CommentItem) -> Unit;
    open lateinit var openUserSpace: (user_id: Number) -> Unit;
    open lateinit var openCommentDetail: (id: Number) -> Unit;
    open lateinit var loadCommentList: () -> Unit;
    companion object {
        var name = "comment";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("comment-section" to padStyleMapOf(utsMapOf("flexDirection" to "row", "height" to "80rpx", "width" to "750rpx", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "32rpx", "paddingBottom" to 0, "paddingLeft" to "32rpx", "justifyContent" to "space-between")), "comment-title" to padStyleMapOf(utsMapOf("fontSize" to 16, "fontWeight" to "bold")), "comment-count" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#8b8b8b")), "comment" to padStyleMapOf(utsMapOf("paddingTop" to "20rpx", "paddingRight" to "30rpx", "paddingBottom" to "20rpx", "paddingLeft" to "30rpx")), "comment-nickname" to padStyleMapOf(utsMapOf("maxWidth" to "224rpx", "textOverflow" to "ellipsis", "height" to "30rpx", "fontSize" to 14, "marginTop" to "15rpx", "lineHeight" to 1.2, "marginRight" to "10rpx")), "comment-time" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#a7a7a7", "marginTop" to "15rpx", "marginLeft" to "auto", "lineHeight" to 1.2)), "comment-content" to padStyleMapOf(utsMapOf("fontSize" to 16, "width" to "590rpx", "marginLeft" to "98rpx", "lineHeight" to 1.5, "marginTop" to "10rpx")), "reply" to padStyleMapOf(utsMapOf("backgroundColor" to "#f8f8f8", "borderRadius" to 50, "paddingTop" to "10rpx", "paddingRight" to "18rpx", "paddingBottom" to "10rpx", "paddingLeft" to "18rpx", "alignSelf" to "flex-start", "marginLeft" to "98rpx", "marginTop" to "20rpx", "flexDirection" to "row")), "reply-hover" to padStyleMapOf(utsMapOf("backgroundColor" to "#f2f2f2")), "reply-text" to padStyleMapOf(utsMapOf("color" to "#0a0a0a", "fontSize" to 12)), "reply-icon" to padStyleMapOf(utsMapOf("color" to "#0a0a0a", "fontSize" to 12, "marginLeft" to "5rpx")), "comment-quote" to padStyleMapOf(utsMapOf("width" to "590rpx", "marginLeft" to "98rpx", "marginTop" to "10rpx", "borderLeftWidth" to "2rpx", "borderLeftStyle" to "solid", "borderLeftColor" to "#bbbbbb", "paddingLeft" to "20rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("reply" to null);
        var props = normalizePropsOptions(utsMapOf("support_count" to utsMapOf("type" to "Number", "default" to 0), "article_id" to utsMapOf("type" to "Number", "default" to 0), "isreply" to utsMapOf("type" to "Boolean", "default" to false), "comment_id" to utsMapOf("type" to "Number", "default" to 0)));
        var propsNeedCastKeys = utsArrayOf(
            "support_count",
            "article_id",
            "isreply",
            "comment_id"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
