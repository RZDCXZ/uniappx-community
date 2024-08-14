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
import io.dcloud.uniapp.extapi.`$on` as uni__on;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesLongListLongListPage : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onCreated(fun() {
            if (this.preload) {
                this.loadData(null);
            }
            uni__on("onUpdateArticleChange", this.onUpdateArticleChange);
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_skeleton = resolveEasyComponent("skeleton", GenComponentsSkeletonSkeletonClass);
        val _component_tip = resolveEasyComponent("tip", GenComponentsTipTipClass);
        val _component_article_list_item = resolveEasyComponent("article-list-item", GenComponentsArticleListItemArticleListItemClass);
        val _component_user_list_item = resolveEasyComponent("user-list-item", GenComponentsUserListItemUserListItemClass);
        val _component_topic_list_item = resolveEasyComponent("topic-list-item", GenComponentsTopicListItemTopicListItemClass);
        val _component_comment_list_item = resolveEasyComponent("comment-list-item", GenComponentsCommentListItemCommentListItemClass);
        val _component_loading_more = resolveEasyComponent("loading-more", GenComponentsLoadingMoreLoadingMoreClass);
        return createElementVNode("list-view", utsMapOf("ref" to "listView", "id" to _ctx.id, "class" to "list", "rebound" to false, "scroll-y" to true, "custom-nested-scroll" to true, "onScrolltolower" to fun(){
            _ctx.loadData(null);
        }
        ), utsArrayOf(
            if (isTrue(_ctx.isFirstLoad)) {
                createElementVNode("list-item", utsMapOf("key" to 0, "type" to 1), utsArrayOf(
                    createVNode(_component_skeleton)
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            if (isTrue(!_ctx.isFirstLoad && _ctx.count == 0)) {
                createElementVNode("list-item", utsMapOf("key" to 1, "type" to 2, "class" to "flex-1"), utsArrayOf(
                    if (isTrue(_ctx.page == "user-space" && _ctx.isAdmin && _ctx.type == "article")) {
                        createVNode(_component_tip, utsMapOf("key" to 0, "title" to "现在不发帖,光看别人火", "button" to "去发帖", "onClickButton" to _ctx.openAddPost), null, 8, utsArrayOf(
                            "onClickButton"
                        ));
                    } else {
                        createVNode(_component_tip, utsMapOf("key" to 1));
                    }
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            if (isTrue(_ctx.type == "article" || _ctx.page == "index")) {
                createElementVNode(Fragment, utsMapOf("key" to 2), RenderHelpers.renderList(_ctx.dataList, fun(item, index, _, _): VNode {
                    return createElementVNode("list-item", utsMapOf("key" to index, "type" to 0), utsArrayOf(
                        createVNode(_component_article_list_item, utsMapOf("isAdmin" to _ctx.isAdmin, "inUserSpace" to (_ctx.page == "user-space"), "ref_for" to true, "ref" to "articleListItem", "item" to item, "onOnDeleteSuccess" to _ctx.onDeleteSuccess), null, 8, utsArrayOf(
                            "isAdmin",
                            "inUserSpace",
                            "item",
                            "onOnDeleteSuccess"
                        ))
                    ));
                }), 128);
            } else {
                if (_ctx.type == "user") {
                    createElementVNode(Fragment, utsMapOf("key" to 3), RenderHelpers.renderList(_ctx.userList, fun(item, index, _, _): VNode {
                        return createElementVNode("list-item", utsMapOf("key" to index, "type" to 5), utsArrayOf(
                            createVNode(_component_user_list_item, utsMapOf("item" to item), null, 8, utsArrayOf(
                                "item"
                            ))
                        ));
                    }), 128);
                } else {
                    if (_ctx.type == "topic") {
                        createElementVNode(Fragment, utsMapOf("key" to 4), RenderHelpers.renderList(_ctx.topicList, fun(item, index, _, _): VNode {
                            return createElementVNode("list-item", utsMapOf("style" to normalizeStyle(utsMapOf("padding-left" to "34rpx")), "key" to index, "type" to 6), utsArrayOf(
                                createVNode(_component_topic_list_item, utsMapOf("item" to item), null, 8, utsArrayOf(
                                    "item"
                                ))
                            ), 4);
                        }), 128);
                    } else {
                        if (_ctx.type == "comment") {
                            createElementVNode(Fragment, utsMapOf("key" to 5), RenderHelpers.renderList(_ctx.commentList, fun(item, index, _, _): VNode {
                                return createElementVNode("list-item", utsMapOf("key" to index, "type" to 7), utsArrayOf(
                                    createVNode(_component_comment_list_item, utsMapOf("isAdmin" to _ctx.isAdmin, "item" to item, "onOnDeleteSuccess" to fun(){
                                        _ctx.refreshData(null);
                                    }), null, 8, utsArrayOf(
                                        "isAdmin",
                                        "item",
                                        "onOnDeleteSuccess"
                                    ))
                                ));
                            }), 128);
                        } else {
                            createCommentVNode("v-if", true);
                        }
                        ;
                    }
                    ;
                }
                ;
            }
            ,
            if (isTrue(!_ctx.isFirstLoad && _ctx.count > 0)) {
                createElementVNode("list-item", utsMapOf("key" to 6, "type" to 4), utsArrayOf(
                    createVNode(_component_loading_more, utsMapOf("loading" to _ctx.loading, "isEnded" to _ctx.isEnded), null, 8, utsArrayOf(
                        "loading",
                        "isEnded"
                    ))
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ), 40, utsArrayOf(
            "id",
            "onScrolltolower"
        ));
    }
    open var type: String by `$props`;
    open var preload: Boolean by `$props`;
    open var id: String by `$props`;
    open var category_id: Number by `$props`;
    open var page: String by `$props`;
    open var keyword: String by `$props`;
    open var user_id: Number by `$props`;
    open var isAdmin: Boolean by `$props`;
    open var loading: Boolean by `$data`;
    open var dataList: UTSArray<ListItem> by `$data`;
    open var topicList: UTSArray<Topic> by `$data`;
    open var userList: UTSArray<UserItem> by `$data`;
    open var commentList: UTSArray<CommentItem> by `$data`;
    open var isEnded: Boolean by `$data`;
    open var loadingError: String by `$data`;
    open var currentPage: Number by `$data`;
    open var isFirstLoad: Boolean by `$data`;
    open var count: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("loading" to false, "dataList" to utsArrayOf<ListItem>(), "topicList" to utsArrayOf<Topic>(), "userList" to utsArrayOf<UserItem>(), "commentList" to utsArrayOf<CommentItem>(), "isEnded" to false, "loadingError" to "", "currentPage" to 1, "isFirstLoad" to true, "count" to computed<Number>(fun(): Number {
            var count = this.dataList.length;
            when (this.type) {
                "topic" -> 
                    count = this.topicList.length;
                "user" -> 
                    count = this.userList.length;
                "comment" -> 
                    count = this.commentList.length;
            }
            return count;
        }
        ));
    }
    override fun `$initMethods`() {
        this.onDeleteSuccess = fun() {
            this.refreshData(null);
            this.`$emit`("onDeleteSuccess");
        }
        ;
        this.openAddPost = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/add-post/add-post"));
        }
        ;
        this.onUpdateArticleChange = fun(e: updateArticleChangeEvent) {
            val aRefs = this.`$refs`["articleListItem"] as UTSArray<ComponentPublicInstance>;
            if (e.key == "updateFollow") {
                this.dataList.forEach(fun(o: ListItem, i: Number){
                    if (o.user_id == e.id) {
                        aRefs[i].`$callMethod`("updateFollow", if (e.value == "true") {
                            true;
                        } else {
                            false;
                        }
                        );
                    }
                }
                );
                return;
            }
            var index = this.dataList.findIndex(fun(o: ListItem, _: Number): Boolean {
                return o.id == e.id;
            }
            );
            if (index == -1) {
                return;
            }
            var ItemRef = aRefs[index];
            when (e.key) {
                "updateSupport" -> 
                    ItemRef.`$callMethod`("updateSupport", UTSAndroid.consoleDebugError(JSON.parse<updateSupportEvent>(e.value), " at pages/long-list/long-list-page.uvue:158"));
                "updateReadCount" -> 
                    ItemRef.`$callMethod`("updateReadCount", parseInt(e.value));
                "updateCommentCount" -> 
                    ItemRef.`$callMethod`("updateCommentCount", parseInt(e.value));
            }
        }
        ;
        this.refreshData = fun(loadComplete: (() -> Unit)?) {
            this.dataList.length = 0;
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
            when (this.page) {
                "index" -> 
                    this.loadArticleList(loadComplete);
                "search" -> 
                    if (this.type == "article") {
                        this.loadArticleList(loadComplete);
                    } else if (this.type == "topic") {
                        this.loadSearchTopicList(loadComplete);
                    } else if (this.type == "user") {
                        this.loadSearchUserList(loadComplete);
                    }
                "user-space" -> 
                    if (this.type == "article") {
                        this.loadArticleList(loadComplete);
                    } else if (this.type == "comment") {
                        this.loadCommentListByUserId(loadComplete);
                    }
            }
        }
        ;
        this.loadCommentListByUserId = fun(loadComplete: (() -> Unit)?) {
            uni_request<Result<CommentItemResult>>(RequestOptions(url = getURL("/user/" + this.user_id + "/comment/" + Math.floor(this.currentPage)), header = object : UTSJSONObject() {
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
                if (loadComplete != null) {
                    loadComplete();
                }
            }
            ));
        }
        ;
        this.loadSearchTopicList = fun(loadComplete: (() -> Unit)?) {
            uni_request<Result<TopicResult>>(RequestOptions(url = getURL("/search/topic/" + Math.floor(this.currentPage) + "?keyword=" + this.keyword), success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                val resData = r.data as TopicResult?;
                if (resData == null) {
                    return;
                }
                this.isEnded = resData.last_page <= resData.current_page;
                if (this.currentPage == 1) {
                    this.topicList = resData.data;
                } else {
                    this.topicList.push(*resData.data.toTypedArray());
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
        this.loadSearchUserList = fun(loadComplete: (() -> Unit)?) {
            uni_request<Result<UserItemResult>>(RequestOptions(url = getURL("/search/user/" + Math.floor(this.currentPage) + "?keyword=" + this.keyword), header = object : UTSJSONObject() {
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
                val resData = r.data as UserItemResult?;
                if (resData == null) {
                    return;
                }
                this.isEnded = resData.last_page <= resData.current_page;
                if (this.currentPage == 1) {
                    this.userList = resData.data;
                } else {
                    this.userList.push(*resData.data.toTypedArray());
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
        this.loadArticleList = fun(loadComplete: (() -> Unit)?) {
            val p = Math.floor(this.currentPage);
            var url = "/category/" + this.category_id + "/article/" + p;
            if (this.page == "search") {
                url = "/search/article/" + p + "?keyword=" + this.keyword;
            } else if (this.page == "user-space") {
                url = "/user/" + this.user_id + "/article/" + p;
            }
            uni_request<Result<ListResult>>(RequestOptions(url = getURL(url), header = object : UTSJSONObject() {
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
                val resData = r.data as ListResult?;
                if (resData == null) {
                    return;
                }
                this.isEnded = resData.last_page <= resData.current_page;
                if (this.currentPage == 1) {
                    this.dataList = resData.data;
                } else {
                    this.dataList.push(*resData.data.toTypedArray());
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
    open lateinit var onDeleteSuccess: () -> Unit;
    open lateinit var openAddPost: () -> Unit;
    open lateinit var onUpdateArticleChange: (e: updateArticleChangeEvent) -> Unit;
    open lateinit var refreshData: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadData: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadCommentListByUserId: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadSearchTopicList: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadSearchUserList: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadArticleList: (loadComplete: (() -> Unit)?) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("list" to padStyleMapOf(utsMapOf("flex" to 1, "backgroundColor" to "#ffffff")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("onDeleteSuccess" to null);
        var props = normalizePropsOptions(utsMapOf("type" to utsMapOf("type" to "String", "default" to ""), "preload" to utsMapOf("type" to "Boolean", "default" to false), "id" to utsMapOf("type" to "String", "default" to ""), "category_id" to utsMapOf("type" to "Number", "default" to 0), "page" to utsMapOf("type" to "String", "default" to "index"), "keyword" to utsMapOf("type" to "String", "default" to ""), "user_id" to utsMapOf("type" to "Number", "default" to 0), "isAdmin" to utsMapOf("type" to "Boolean", "default" to false)));
        var propsNeedCastKeys = utsArrayOf(
            "type",
            "preload",
            "id",
            "category_id",
            "page",
            "keyword",
            "user_id",
            "isAdmin"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
