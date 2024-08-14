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
open class GenComponentsIconBtnIconBtn : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
            "action-box",
            utsMapOf("action-box-column" to _ctx.column)
        )), "hover-class" to "action-box-hover", "style" to normalizeStyle(_ctx.style), "onClick" to withModifiers(_ctx.handleClick, utsArrayOf(
            "stop"
        ))), utsArrayOf(
            createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                "iconfont action-icon",
                if (_ctx.active) {
                    "action-active";
                } else {
                    "";
                }
            )), "style" to normalizeStyle("font-size:" + _ctx.iconSize)), toDisplayString(_ctx.icon), 7),
            createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                "action-data",
                if (_ctx.active) {
                    "action-active";
                } else {
                    "";
                }
            ))), toDisplayString(if (_ctx.count > 0) {
                _ctx.count;
            } else {
                _ctx.label;
            }
            ), 3)
        ), 14, utsArrayOf(
            "onClick"
        ));
    }
    open var icon: String by `$props`;
    open var iconSize: String by `$props`;
    open var count: Number by `$props`;
    open var label: String by `$props`;
    open var column: Boolean by `$props`;
    open var width: String by `$props`;
    open var active: Boolean by `$props`;
    open var style: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("style" to computed<String>(fun(): String {
            if (this.width != "") {
                return "width:" + this.width + ";";
            }
            return "flex: 1;";
        }
        ));
    }
    override fun `$initMethods`() {
        this.handleClick = fun() {
            this.`$emit`("click");
        }
        ;
    }
    open lateinit var handleClick: () -> Unit;
    companion object {
        var name = "icon-btn";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("action-box" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "action-icon" to utsMapOf("" to utsMapOf("marginRight" to "12rpx", "marginBottom" to 0), ".action-box-column " to utsMapOf("marginRight" to 0, "marginBottom" to "5rpx")), "action-data" to utsMapOf("" to utsMapOf("color" to "#000000", "fontSize" to 15), ".action-box-column " to utsMapOf("fontSize" to 12)), "action-box-column" to padStyleMapOf(utsMapOf("flexDirection" to "column")), "action-active" to padStyleMapOf(utsMapOf("color" to "#de6489")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("click" to null);
        var props = normalizePropsOptions(utsMapOf("icon" to utsMapOf("type" to "String", "default" to ""), "iconSize" to utsMapOf("type" to "String", "default" to "22px"), "count" to utsMapOf("type" to "Number", "default" to 0), "label" to utsMapOf("type" to "String", "default" to ""), "column" to utsMapOf("type" to "Boolean", "default" to false), "width" to utsMapOf("type" to "String", "default" to ""), "active" to utsMapOf("type" to "Boolean", "default" to false)));
        var propsNeedCastKeys = utsArrayOf(
            "icon",
            "iconSize",
            "count",
            "label",
            "column",
            "width",
            "active"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
