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
open class GenComponentsTipTip : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        return createElementVNode("view", utsMapOf("class" to "tip"), utsArrayOf(
            createElementVNode("image", utsMapOf("src" to default2, "mode" to "widthFix", "fade-show" to true, "class" to "tip-img")),
            createElementVNode("text", utsMapOf("class" to "tip-title"), toDisplayString(_ctx.title), 1),
            if (_ctx.button != "") {
                createVNode(_component_main_btn, utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("margin-top" to "20rpx")), "onClick" to fun(){
                    _ctx.`$emit`("click-button");
                }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        toDisplayString(_ctx.button)
                    );
                }), "_" to 1), 8, utsArrayOf(
                    "style",
                    "onClick"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ));
    }
    open var title: String by `$props`;
    open var button: String by `$props`;
    companion object {
        var name = "tip";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("tip" to padStyleMapOf(utsMapOf("flex" to 1, "alignItems" to "center", "justifyContent" to "center", "minHeight" to "600rpx")), "tip-img" to padStyleMapOf(utsMapOf("width" to "350rpx", "height" to "350rpx")), "tip-title" to padStyleMapOf(utsMapOf("color" to "#5d5d5d", "marginTop" to "45rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("click-button" to null);
        var props = normalizePropsOptions(utsMapOf("title" to utsMapOf("type" to "String", "default" to "暂无数据"), "button" to utsMapOf("type" to "String", "default" to "")));
        var propsNeedCastKeys = utsArrayOf(
            "title",
            "button"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
