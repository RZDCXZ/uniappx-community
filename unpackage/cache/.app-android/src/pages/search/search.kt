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
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.removeStorageSync as uni_removeStorageSync;
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
open class GenPagesSearchSearch : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(_: OnLoadOptions) {
            this.getSearchList();
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_navbar = resolveEasyComponent("navbar", GenComponentsNavbarNavbarClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createVNode(_component_navbar, utsMapOf("type" to "search", "onSearch" to _ctx.handleSearch), null, 8, utsArrayOf(
                "onSearch"
            )),
            if (_ctx.searchList.length > 0) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "cell"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "cell-title"), "历史记录"),
                    createElementVNode("text", utsMapOf("class" to "cell-tip", "onClick" to _ctx.clearSearchList), "清除记录", 8, utsArrayOf(
                        "onClick"
                    ))
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode("view", utsMapOf("class" to "keyword-list"), utsArrayOf(
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.searchList, fun(item, index, _, _): VNode {
                    return createElementVNode("text", utsMapOf("class" to "keyword", "key" to index, "onClick" to fun(){
                        _ctx.handleSearch(item);
                    }
                    ), toDisplayString(item), 9, utsArrayOf(
                        "onClick"
                    ));
                }
                ), 128)
            ))
        ), 4);
    }
    open var searchList: UTSArray<String> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("searchList" to utsArrayOf<String>());
    }
    override fun `$initMethods`() {
        this.handleSearch = fun(keyword: String) {
            uni_navigateTo(NavigateToOptions(url = "/pages/search-result/search-result?keyword=" + keyword, success = fun(_){
                this.addSearchList(keyword);
            }
            ));
        }
        ;
        this.getSearchList = fun() {
            var list = uni_getStorageSync("historySearchList")!!;
            if (UTSArray.isArray(list)) {
                this.searchList = list as UTSArray<String>;
            }
        }
        ;
        this.addSearchList = fun(keyword: String) {
            var index = (this.searchList.findIndex(fun(v: String): Boolean {
                return v == keyword;
            }
            ) as Number);
            if (index != -1) {
                this.toFirst(this.searchList, index);
            } else {
                this.searchList = utsArrayOf(
                    keyword
                ).concat(this.searchList);
            }
            uni_setStorageSync("historySearchList", this.searchList);
        }
        ;
        this.toFirst = fun(arr: UTSArray<String>, index: Number): UTSArray<String> {
            if (index != 0) {
                arr.unshift(arr.splice(index, 1)[0]);
            }
            return arr;
        }
        ;
        this.clearSearchList = fun() {
            uni_showModal(ShowModalOptions(title = "提示", content = "是否要清除搜索记录？", confirmText = "清除", success = fun(res){
                if (res.confirm) {
                    uni_removeStorageSync("historySearchList");
                    this.searchList.length = 0;
                }
            }
            ));
        }
        ;
    }
    open lateinit var handleSearch: (keyword: String) -> Unit;
    open lateinit var getSearchList: () -> Unit;
    open lateinit var addSearchList: (keyword: String) -> Unit;
    open lateinit var toFirst: (arr: UTSArray<String>, index: Number) -> UTSArray<String>;
    open lateinit var clearSearchList: () -> Unit;
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
                return utsMapOf("cell" to padStyleMapOf(utsMapOf("height" to "100rpx", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "backgroundColor" to "#ffffff")), "cell-title" to padStyleMapOf(utsMapOf("color" to "#090909")), "cell-tip" to padStyleMapOf(utsMapOf("color" to "#858585")), "keyword-list" to padStyleMapOf(utsMapOf("flexDirection" to "row", "paddingTop" to 0, "paddingRight" to "20rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx", "flexWrap" to "wrap")), "keyword" to padStyleMapOf(utsMapOf("borderWidth" to "1rpx", "borderStyle" to "solid", "borderColor" to "#dddddd", "borderRadius" to 4, "paddingTop" to "8rpx", "paddingRight" to "15rpx", "paddingBottom" to "8rpx", "paddingLeft" to "15rpx", "marginTop" to "10rpx", "marginRight" to "10rpx", "marginBottom" to "10rpx", "marginLeft" to "10rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
