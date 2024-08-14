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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
open class GenComponentsTopicListItemTopicListItem : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        return createElementVNode("list-item", utsMapOf("class" to "topic-item", "onClick" to _ctx.open), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "topic-item-image-box"), utsArrayOf(
                createElementVNode("image", utsMapOf("src" to _ctx.item.cover, "fade-show" to true, "mode" to "aspectFill", "class" to "topic-item-image"), null, 8, utsArrayOf(
                    "src"
                ))
            )),
            createElementVNode("view", utsMapOf("class" to "info"), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "nickname"), toDisplayString(_ctx.item.title), 1),
                createElementVNode("text", utsMapOf("class" to "time"), toDisplayString(_ctx.item.desc), 1),
                createElementVNode("text", utsMapOf("class" to "time"), "动态：" + toDisplayString(_ctx.item.article_count) + "条 · 今日" + toDisplayString(_ctx.item.today_article_count) + "条", 1)
            )),
            if (isTrue(_ctx.ischoose)) {
                createVNode(_component_main_btn, utsMapOf("key" to 0, "width" to "100rpx", "height" to "55rpx", "fontSize" to "14px", "style" to normalizeStyle(utsMapOf("margin-left" to "auto")), "onClick" to withModifiers(_ctx.open, utsArrayOf(
                    "stop"
                ))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        "选择"
                    );
                }), "_" to 1), 8, utsArrayOf(
                    "style",
                    "onClick"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ), 8, utsArrayOf(
            "onClick"
        ));
    }
    open var item: Topic by `$props`;
    open var ischoose: Boolean by `$props`;
    override fun `$initMethods`() {
        this.open = fun() {
            if (this.ischoose) {
                val d = TopicNav(id = this.item.id, title = this.item.title);
                uni__emit("onTopicPickerSuccess", d);
                uni_navigateBack(NavigateBackOptions(delta = 1));
                return;
            }
            uni_navigateTo(NavigateToOptions(url = "/pages/topic-detail/topic-detail?id=" + this.item.id));
        }
        ;
    }
    open lateinit var open: () -> Unit;
    companion object {
        var name = "topic-list-item";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("topic-item" to padStyleMapOf(utsMapOf("height" to "170rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#f2f2f2", "flexDirection" to "row", "alignItems" to "center", "paddingRight" to "34rpx")), "topic-item-image-box" to padStyleMapOf(utsMapOf("width" to "102rpx", "height" to "102rpx", "borderRadius" to 5, "overflow" to "hidden", "marginRight" to "25rpx")), "topic-item-image" to padStyleMapOf(utsMapOf("width" to "102rpx", "height" to "102rpx")), "info" to padStyleMapOf(utsMapOf("flex" to 1)), "nickname" to padStyleMapOf(utsMapOf("color" to "#272727", "maxWidth" to "390rpx", "textOverflow" to "ellipsis", "height" to "34rpx", "fontSize" to 15)), "time" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#9a9a9a", "marginTop" to "10rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("item" to utsMapOf("type" to "Object", "required" to true), "ischoose" to utsMapOf("type" to "Boolean", "default" to false)));
        var propsNeedCastKeys = utsArrayOf(
            "ischoose"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
