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
open class GenPagesSearchResultSearchResult : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(options: OnLoadOptions) {
            if (options.has("keyword")) {
                this.keyword = options.get("keyword") as String;
            }
        }
        , instance);
        onReady(fun() {
            if (this.keyword != "") {
                (this.`$refs`["navbar"] as ComponentPublicInstance).`$callMethod`("setKeyword", this.keyword);
            }
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_navbar = resolveEasyComponent("navbar", GenComponentsNavbarNavbarClass);
        val _component_long_page = resolveComponent("long-page");
        val _component_tabs_swiper = resolveEasyComponent("tabs-swiper", GenComponentsTabsSwiperTabsSwiperClass);
        return createVNode(_component_tabs_swiper, utsMapOf("default-tab-index" to _ctx.tabIndex, "show-search-icon" to true, "tabs" to _ctx.tabs, "onLoadData" to _ctx.loadData, "onChange" to _ctx.onSwiperChange), utsMapOf("navbar" to withSlotCtx(fun(): UTSArray<Any> {
            return utsArrayOf(
                createVNode(_component_navbar, utsMapOf("ref" to "navbar", "type" to "search", "disabled" to true), null, 512)
            );
        }
        ), "default" to withSlotCtx(fun(): UTSArray<Any> {
            return utsArrayOf(
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.tabs, fun(item, index, _, _): VNode {
                    return createElementVNode("swiper-item", utsMapOf("class" to "flex-1", "key" to index), utsArrayOf(
                        createVNode(_component_long_page, utsMapOf("ref_for" to true, "ref" to "longPage", "page" to "search", "keyword" to _ctx.keyword, "type" to item.type, "preload" to item.preload), null, 8, utsArrayOf(
                            "keyword",
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
        ));
    }
    open var keyword: String by `$data`;
    open var tabIndex: Number by `$data`;
    open var tabs: UTSArray<TabsSwiperItem> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("keyword" to "", "tabIndex" to 0, "tabs" to utsArrayOf<TabsSwiperItem>(TabsSwiperItem(id = 0, name = "帖子", type = "article", preload = true), TabsSwiperItem(id = 2, name = "用户", type = "user", preload = false), TabsSwiperItem(id = 3, name = "话题", type = "topic", preload = false)));
    }
    override fun `$initMethods`() {
        this.loadData = fun(index: Number) {
            (this.`$refs`["longPage"] as UTSArray<ComponentPublicInstance>)[index].`$callMethod`("loadData", null);
        }
        ;
        this.onSwiperChange = fun(index: Number) {
            this.tabIndex = index;
        }
        ;
    }
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
