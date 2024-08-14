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
open class GenComponentsMainBtnMainBtn : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
            "main-btn",
            utsMapOf("main-btn-disabled" to _ctx.disabled)
        )), "style" to normalizeStyle(utsMapOf("width" to _ctx.width, "height" to _ctx.height, "borderRadius" to _ctx.borderRadius)), "hover-class" to if (_ctx.disabled) {
            "";
        } else {
            "main-btn-hover";
        }
        , "onClick" to _ctx.handleClick), utsArrayOf(
            createElementVNode("text", utsMapOf("class" to "main-btn-text", "style" to normalizeStyle(utsMapOf("fontSize" to _ctx.fontSize))), utsArrayOf(
                renderSlot(_ctx.`$slots`, "default")
            ), 4)
        ), 14, utsArrayOf(
            "hover-class",
            "onClick"
        ));
    }
    open var disabled: Boolean by `$props`;
    open var width: String by `$props`;
    open var height: String by `$props`;
    open var fontSize: String by `$props`;
    open var borderRadius: String by `$props`;
    override fun `$initMethods`() {
        this.handleClick = fun() {
            if (this.disabled) {
                return;
            }
            this.`$emit`("click");
        }
        ;
    }
    open lateinit var handleClick: () -> Unit;
    companion object {
        var name = "main-btn";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("main-btn" to padStyleMapOf(utsMapOf("alignItems" to "center", "justifyContent" to "center", "backgroundImage" to "linear-gradient(to bottom right,#fc6672,#e47989)")), "main-btn-text" to padStyleMapOf(utsMapOf("color" to "#ffffff", "fontWeight" to "bold")), "main-btn-hover" to padStyleMapOf(utsMapOf("backgroundImage" to "linear-gradient(to bottom right,#fd6373,#fd6373)")), "main-btn-disabled" to padStyleMapOf(utsMapOf("backgroundColor" to "#d9d9d9", "backgroundImage" to "linear-gradient(to bottom right,#d9d9d9,#d9d9d9)")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("click" to null);
        var props = normalizePropsOptions(utsMapOf("disabled" to utsMapOf("type" to "Boolean", "default" to false), "width" to utsMapOf("type" to "String", "default" to "280rpx"), "height" to utsMapOf("type" to "String", "default" to "80rpx"), "fontSize" to utsMapOf("type" to "String", "default" to "15px"), "borderRadius" to utsMapOf("type" to "String", "default" to "5px")));
        var propsNeedCastKeys = utsArrayOf(
            "disabled",
            "width",
            "height",
            "fontSize",
            "borderRadius"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
