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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
open class GenComponentsTabsSwiperTabsSwiper : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onCreated(fun() {
            this.swiperIndex = this.defaultTabIndex;
        }
        , instance);
        onMounted(fun() {
            this.`$nextTick`(fun(){
                this.tabScrollView = this.`$refs`["tabScroll"] as UniElement;
                this.swiperWidth = (this.`$refs`["swiper"] as UniElement).getBoundingClientRect().width;
            }
            );
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_status_bar = resolveEasyComponent("status-bar", GenComponentsStatusBarStatusBarClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            renderSlot(_ctx.`$slots`, "navbar", UTSJSONObject(), fun(): UTSArray<Any> {
                return utsArrayOf(
                    createVNode(_component_status_bar)
                );
            }
            ),
            createElementVNode("view", utsMapOf("class" to "flex-1"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "flex"), utsArrayOf(
                    createElementVNode("scroll-view", utsMapOf("ref" to "tabScroll", "class" to "swiper-tabs", "direction" to "horizontal", "show-scrollbar" to false, "style" to normalizeStyle(if (_ctx.showSearchIcon) {
                        "width: 646rpx;";
                    } else {
                        "width: 750rpx;";
                    }
                    )), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "swiper-tabs-item"), utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.tabs, fun(item, index, _, _): VNode {
                                return createElementVNode("text", utsMapOf("ref_for" to true, "ref" to "swipertab", "class" to normalizeClass(utsArrayOf(
                                    "swiper-tabs-item-text",
                                    if (_ctx.swiperIndex == index) {
                                        "swiper-tabs-item-active";
                                    } else {
                                        "";
                                    }
                                )), "key" to index, "onClick" to fun(){
                                    _ctx.onTabClick(index);
                                }
                                ), toDisplayString(item.name), 11, utsArrayOf(
                                    "onClick"
                                ));
                            }
                            ), 128)
                        ))
                    ), 4),
                    if (isTrue(_ctx.showSearchIcon)) {
                        createElementVNode("view", utsMapOf("key" to 0, "class" to "search", "onClick" to _ctx.openSearch), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "iconfont"), toDisplayString("\ue606"))
                        ), 8, utsArrayOf(
                            "onClick"
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                )),
                createElementVNode("swiper", utsMapOf("ref" to "swiper", "class" to "flex-1", "current" to _ctx.swiperIndex, "onTransition" to _ctx.onSwiperTransition, "onAnimationfinish" to _ctx.onSwiperAnimationfinish), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "default")
                ), 40, utsArrayOf(
                    "current",
                    "onTransition",
                    "onAnimationfinish"
                ))
            ))
        ), 64);
    }
    open var tabs: UTSArray<TabsSwiperItem> by `$props`;
    open var showSearchIcon: Boolean by `$props`;
    open var defaultTabIndex: Number by `$props`;
    open var swiperIndex: Number by `$data`;
    open var tabScrollView: UniElement? by `$data`;
    open var animationFinishIndex: Number by `$data`;
    open var swiperWidth: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("swiperIndex" to 0, "tabScrollView" to null as UniElement?, "animationFinishIndex" to 0, "swiperWidth" to 0);
    }
    override fun `$initMethods`() {
        this.openSearch = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/search/search"));
        }
        ;
        this.onTabClick = fun(index: Number) {
            this.setSwiperIndex(index, false);
        }
        ;
        this.onSwiperTransition = fun(e: SwiperTransitionEvent) {
            val offset_x = e.detail.dx;
            val current_offset_x = offset_x % this.swiperWidth;
            val current_offset_i = offset_x / this.swiperWidth;
            val current_index = this.animationFinishIndex + parseInt(current_offset_i + "");
            var move_to_index = current_index;
            if (current_offset_x > 0 && move_to_index < this.tabs.length - 1) {
                move_to_index += 1;
            } else if (current_offset_x < 0 && move_to_index > 0) {
                move_to_index -= 1;
            }
            val percentage = Math.abs(current_offset_x) / this.swiperWidth;
            if (current_index != move_to_index) {
                this.updateTabIndicator(current_index, move_to_index, percentage);
            }
            this.initSwiperItemData(move_to_index);
        }
        ;
        this.onSwiperAnimationfinish = fun(e: SwiperAnimationFinishEvent) {
            this.setSwiperIndex(e.detail.current, true);
            this.animationFinishIndex = e.detail.current;
        }
        ;
        this.setSwiperIndex = fun(index: Number, updateIndicator: Boolean) {
            if (this.swiperIndex == index) {
                return;
            }
            this.swiperIndex = index;
            this.`$emit`("change", this.swiperIndex);
            this.initSwiperItemData(index);
            if (updateIndicator) {
                this.updateTabIndicator(index, index, 1);
            }
        }
        ;
        this.updateTabIndicator = fun(current_index: Number, move_to_index: Number, percentage: Number) {
            if (percentage == 0) {
                return;
            }
            val min_ratio: Number = 1;
            val max_ratio: Number = 1.3;
            val tabs = this.`$refs`["swipertab"] as UTSArray<UniElement>;
            val current_node = tabs[current_index];
            val move_to_node = tabs[move_to_index];
            val current_scale = lerpNumber(min_ratio, max_ratio, 1 - percentage);
            current_node.style.setProperty("transform", "scale(" + current_scale + ")");
            val move_to_scale = lerpNumber(min_ratio, max_ratio, percentage);
            move_to_node.style.setProperty("transform", "scale(" + move_to_scale + ")");
            val target_x = lerpNumber(current_node.offsetLeft, move_to_node.offsetLeft, percentage);
            val center_x = target_x + move_to_node.offsetWidth / 2 - this.swiperWidth / 2;
            this.tabScrollView!!.scrollLeft = center_x;
        }
        ;
        this.initSwiperItemData = fun(index: Number) {
            if (!this.tabs[index].preload) {
                this.tabs[index].preload = true;
                this.`$emit`("loadData", index as Number);
            }
        }
        ;
    }
    open lateinit var openSearch: () -> Unit;
    open lateinit var onTabClick: (index: Number) -> Unit;
    open lateinit var onSwiperTransition: (e: SwiperTransitionEvent) -> Unit;
    open lateinit var onSwiperAnimationfinish: (e: SwiperAnimationFinishEvent) -> Unit;
    open lateinit var setSwiperIndex: (index: Number, updateIndicator: Boolean) -> Unit;
    open lateinit var updateTabIndicator: (current_index: Number, move_to_index: Number, percentage: Number) -> Unit;
    open lateinit var initSwiperItemData: (index: Number) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("flex" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "flex-1" to padStyleMapOf(utsMapOf("flex" to 1)), "search" to padStyleMapOf(utsMapOf("height" to "103rpx", "width" to "103rpx", "alignItems" to "center", "justifyContent" to "center")), "swiper-tabs" to padStyleMapOf(utsMapOf("height" to "103rpx")), "swiper-tabs-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignSelf" to "flex-start", "height" to "103rpx", "alignItems" to "center")), "swiper-tabs-item-text" to padStyleMapOf(utsMapOf("color" to "#555555", "fontSize" to 16, "fontWeight" to "bold", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to 0, "marginLeft" to "20rpx", "whiteSpace" to "nowrap")), "swiper-tabs-item-active" to padStyleMapOf(utsMapOf("color" to "#F06487")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("loadData" to null, "change" to null);
        var props = normalizePropsOptions(utsMapOf("tabs" to utsMapOf("type" to "Array", "required" to true), "showSearchIcon" to utsMapOf("type" to "Boolean", "default" to false), "defaultTabIndex" to utsMapOf("type" to "Number", "default" to 0)));
        var propsNeedCastKeys = utsArrayOf(
            "showSearchIcon",
            "defaultTabIndex"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
