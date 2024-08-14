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
open class GenComponentsCellCell : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
            "cell",
            utsMapOf("cell-column" to _ctx.isColumn)
        )), "hover-class" to if (_ctx.hover) {
            "cell-hover";
        } else {
            "";
        }
        ), utsArrayOf(
            createElementVNode("text", utsMapOf("class" to "cell-title"), toDisplayString(_ctx.title), 1),
            renderSlot(_ctx.`$slots`, "default"),
            if (isTrue(!_ctx.isColumn)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "cell-right"), utsArrayOf(
                    if (_ctx.rightText != "") {
                        createElementVNode("text", utsMapOf("key" to 0, "class" to "cell-right-text"), toDisplayString(_ctx.rightText), 1);
                    } else {
                        createCommentVNode("v-if", true);
                    },
                    if (isTrue(_ctx.showArrow)) {
                        createElementVNode("text", utsMapOf("key" to 1, "class" to "iconfont cell-icon"), toDisplayString("\ue60c"));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ), 10, utsArrayOf(
            "hover-class"
        ));
    }
    open var title: String by `$props`;
    open var rightText: String by `$props`;
    open var showArrow: Boolean by `$props`;
    open var hover: Boolean by `$props`;
    open var isColumn: Boolean by `$props`;
    companion object {
        var name = "cell";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("cell" to padStyleMapOf(utsMapOf("flexDirection" to "row", "minHeight" to "100rpx", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "backgroundColor" to "#ffffff")), "cell-column" to padStyleMapOf(utsMapOf("flexDirection" to "column", "alignItems" to "flex-start")), "cell-hover" to padStyleMapOf(utsMapOf("backgroundColor" to "#f4f4f4")), "cell-title" to padStyleMapOf(utsMapOf("color" to "#000000")), "cell-right" to padStyleMapOf(utsMapOf("marginLeft" to "auto", "flexDirection" to "row", "alignItems" to "center")), "cell-icon" to padStyleMapOf(utsMapOf("color" to "#808080")), "cell-right-text" to padStyleMapOf(utsMapOf("color" to "#828282")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("title" to utsMapOf("type" to "String", "default" to ""), "rightText" to utsMapOf("type" to "String", "default" to ""), "showArrow" to utsMapOf("type" to "Boolean", "default" to true), "hover" to utsMapOf("type" to "Boolean", "default" to true), "isColumn" to utsMapOf("type" to "Boolean", "default" to false)));
        var propsNeedCastKeys = utsArrayOf(
            "title",
            "rightText",
            "showArrow",
            "hover",
            "isColumn"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
