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
open class GenComponentsLoginInputLoginInput : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "login-box"), utsArrayOf(
            createElementVNode("input", utsMapOf("password" to _ctx.password, "auto-focus" to _ctx.autoFocus, "style" to normalizeStyle(utsMapOf("font-size" to _ctx.fontSize)), "value" to _ctx.modelValue, "type" to _ctx.type, "placeholder" to _ctx.placeholder, "placeholder-style" to "font-weight:bold;color:#cbcbcb;", "class" to normalizeClass(utsArrayOf(
                "login-input",
                utsMapOf("login-input-full" to (_ctx.btn == ""))
            )), "maxlength" to _ctx.maxlength, "confirm-type" to _ctx.confirmType, "onInput" to _ctx.handleInput, "onConfirm" to _ctx.handleConfirm), null, 46, utsArrayOf(
                "password",
                "auto-focus",
                "value",
                "type",
                "placeholder",
                "maxlength",
                "confirm-type",
                "onInput",
                "onConfirm"
            )),
            if (_ctx.btn != "") {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "login-box-btn", "onClick" to fun(){
                    _ctx.`$emit`("click");
                }), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "login-box-btn-text"), toDisplayString(_ctx.btn), 1)
                ), 8, utsArrayOf(
                    "onClick"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ));
    }
    open var autoFocus: Boolean by `$props`;
    open var fontSize: String by `$props`;
    open var type: String by `$props`;
    open var placeholder: String by `$props`;
    open var maxlength: Number by `$props`;
    open var confirmType: String by `$props`;
    open var modelValue: String by `$props`;
    open var btn: String by `$props`;
    open var password: Boolean by `$props`;
    override fun `$initMethods`() {
        this.handleInput = fun(event: UniInputEvent) {
            this.`$emit`("update:modelValue", event.detail.value);
        }
        ;
        this.handleConfirm = fun(event: UniInputConfirmEvent) {
            this.`$emit`("confirm", event);
        }
        ;
    }
    open lateinit var handleInput: (event: UniInputEvent) -> Unit;
    open lateinit var handleConfirm: (event: UniInputConfirmEvent) -> Unit;
    companion object {
        var name = "login-input";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("login-box" to padStyleMapOf(utsMapOf("borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#e7e7e7", "flexDirection" to "row", "alignItems" to "center", "marginTop" to "120rpx", "height" to "112rpx")), "login-input" to padStyleMapOf(utsMapOf("height" to "70rpx", "width" to "508rpx", "borderRightWidth" to "1rpx", "borderRightStyle" to "solid", "borderRightColor" to "#e7e7e7")), "login-box-btn" to padStyleMapOf(utsMapOf("flex" to 1, "height" to "70rpx", "alignItems" to "center", "justifyContent" to "center")), "login-box-btn-text" to padStyleMapOf(utsMapOf("fontSize" to 14, "color" to "#262626")), "login-input-full" to padStyleMapOf(utsMapOf("width" to "655rpx", "borderRightWidth" to 0, "borderRightStyle" to "none", "borderRightColor" to "#000000")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("update:modelValue" to null, "confirm" to null, "click" to null);
        var props = normalizePropsOptions(utsMapOf("autoFocus" to utsMapOf("type" to "Boolean", "default" to false), "fontSize" to utsMapOf("type" to "String", "default" to "18px"), "type" to utsMapOf("type" to "String", "default" to "text"), "placeholder" to utsMapOf("type" to "String", "default" to ""), "maxlength" to utsMapOf("type" to "Number", "default" to 140), "confirmType" to utsMapOf("type" to "String", "default" to "done"), "modelValue" to utsMapOf("type" to "String", "default" to ""), "btn" to utsMapOf("type" to "String", "default" to ""), "password" to utsMapOf("type" to "Boolean", "default" to false)));
        var propsNeedCastKeys = utsArrayOf(
            "autoFocus",
            "fontSize",
            "type",
            "placeholder",
            "maxlength",
            "confirmType",
            "modelValue",
            "btn",
            "password"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
