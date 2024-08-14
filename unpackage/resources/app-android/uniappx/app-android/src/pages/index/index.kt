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
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh;
open class GenPagesIndexIndex : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(_: OnLoadOptions) {
            this.loadTabs(null);
            uni__on("onAddArticleSuccess", this.onAddArticleSuccess);
        }
        , instance);
        onReady(fun() {
            default1(this.`$refs`["upgradePopup"] as ComponentPublicInstance);
        }
        , instance);
        onUnload(fun() {
            uni__off("onAddArticleSuccess", this.onAddArticleSuccess);
        }
        , instance);
        onPullDownRefresh(fun() {
            if (!this.isTabsLoaded) {
                this.loadTabs(fun(){
                    uni_stopPullDownRefresh();
                }
                );
                return;
            }
            (this.`$refs`["longPage"] as UTSArray<ComponentPublicInstance>)[this.tabIndex].`$callMethod`("refreshData", fun(){
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
        val _component_long_page = resolveComponent("long-page");
        val _component_tabs_swiper = resolveEasyComponent("tabs-swiper", GenComponentsTabsSwiperTabsSwiperClass);
        val _component_add_post_btn = resolveEasyComponent("add-post-btn", GenComponentsAddPostBtnAddPostBtnClass);
        val _component_uni_upgrade_center_app = resolveEasyComponent("uni-upgrade-center-app", GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterAppClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_tabs_swiper, utsMapOf("default-tab-index" to _ctx.tabIndex, "show-search-icon" to true, "tabs" to _ctx.tabs, "onLoadData" to _ctx.loadData, "onChange" to _ctx.onSwiperChange), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.tabs, fun(item, index, _, _): VNode {
                        return createElementVNode("swiper-item", utsMapOf("class" to "flex-1", "key" to index), utsArrayOf(
                            createVNode(_component_long_page, utsMapOf("ref_for" to true, "ref" to "longPage", "category_id" to item.id, "type" to item.type, "preload" to item.preload), null, 8, utsArrayOf(
                                "category_id",
                                "type",
                                "preload"
                            ))
                        ));
                    }
                    ), 128)
                );
            }
            ), "_" to 1), 8, utsArrayOf(
                "default-tab-index",
                "tabs",
                "onLoadData",
                "onChange"
            )),
            createVNode(_component_add_post_btn),
            createVNode(_component_uni_upgrade_center_app, utsMapOf("ref" to "upgradePopup"), null, 512)
        ), 64);
    }
    open var tabIndex: Number by `$data`;
    open var tabs: UTSArray<TabsSwiperItem> by `$data`;
    open var isTabsLoaded: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("tabIndex" to 1, "tabs" to utsArrayOf<TabsSwiperItem>(TabsSwiperItem(id = 0, name = "关注", type = "follow", preload = false), TabsSwiperItem(id = 2, name = "图文", type = "default", preload = false), TabsSwiperItem(id = 3, name = "体育", type = "default", preload = false), TabsSwiperItem(id = 4, name = "热点", type = "default", preload = false)), "isTabsLoaded" to false);
    }
    override fun `$initMethods`() {
        this.onAddArticleSuccess = fun(e: onAddArticleSuccessEvent) {
            var i = this.tabs.findIndex(fun(o: TabsSwiperItem): Boolean {
                return o.id == e.category_id;
            }
            );
            if (i == -1) {
                return;
            }
            (this.`$refs`["longPage"] as UTSArray<ComponentPublicInstance>)[i].`$callMethod`("refreshData", null);
        }
        ;
        this.loadTabs = fun(loadComplete: (() -> Unit)?) {
            uni_request<Result<UTSArray<articleNav>>>(RequestOptions(url = getURL("/category/article"), success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                var tabs = utsArrayOf<TabsSwiperItem>(TabsSwiperItem(id = 0, name = "关注", type = "follow", preload = false));
                var d = r.data as UTSArray<articleNav>;
                d.forEach(fun(o: articleNav, _: Number){
                    tabs.push(TabsSwiperItem(id = o.id, name = o.title, type = "default", preload = false));
                }
                );
                this.tabs = tabs;
                this.isTabsLoaded = true;
                this.loadData(this.tabIndex);
            }
            , fail = fun(err){
                uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
            }
            , complete = fun(_){
                if (loadComplete != null) {
                    loadComplete();
                }
            }
            ));
        }
        ;
        this.loadData = fun(index: Number) {
            (this.`$refs`["longPage"] as UTSArray<ComponentPublicInstance>)[index].`$callMethod`("loadData", null);
        }
        ;
        this.onSwiperChange = fun(index: Number) {
            this.tabIndex = index;
        }
        ;
    }
    open lateinit var onAddArticleSuccess: (e: onAddArticleSuccessEvent) -> Unit;
    open lateinit var loadTabs: (loadComplete: (() -> Unit)?) -> Unit;
    open lateinit var loadData: (index: Number) -> Unit;
    open lateinit var onSwiperChange: (index: Number) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(), utsArrayOf(
                    GenApp.styles
                ));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf("longPage" to GenPagesLongListLongListPageClass);
    }
}
