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
open class GenComponentsAgreementAgreement : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onCreated(fun() {
            this.agreementUrl = uni.UNIE905653.agreementUrl;
            this.privacyUrl = uni.UNIE905653.privacyUrl;
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_radio = resolveComponent("radio");
        return createElementVNode("view", utsMapOf("class" to "agreement"), utsArrayOf(
            createVNode(_component_radio, utsMapOf("checked" to _ctx.modelValue, "onClick" to _ctx.handleIsAgree, "value" to "1", "color" to "#fd6373"), null, 8, utsArrayOf(
                "checked",
                "onClick"
            )),
            createElementVNode("text", utsMapOf("class" to "agreement-text"), "已阅读并同意"),
            createElementVNode("text", utsMapOf("class" to "agreement-text link", "onClick" to fun(){
                _ctx.openWebview(_ctx.agreementUrl);
            }
            ), "用户协议", 8, utsArrayOf(
                "onClick"
            )),
            createElementVNode("text", utsMapOf("class" to "agreement-text"), "和"),
            createElementVNode("text", utsMapOf("class" to "agreement-text link", "onClick" to fun(){
                _ctx.openWebview(_ctx.privacyUrl);
            }
            ), "隐私政策", 8, utsArrayOf(
                "onClick"
            ))
        ));
    }
    open var modelValue: Boolean by `$props`;
    open var agreementUrl: String by `$data`;
    open var privacyUrl: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("agreementUrl" to "", "privacyUrl" to "");
    }
    override fun `$initMethods`() {
        this.openWebview = fun(url: String) {
            uni_navigateTo(NavigateToOptions(url = "/pages/webview/webview?url=" + url));
        }
        ;
        this.handleIsAgree = fun() {
            this.`$emit`("update:modelValue", !this.modelValue);
        }
        ;
    }
    open lateinit var openWebview: (url: String) -> Unit;
    open lateinit var handleIsAgree: () -> Unit;
    companion object {
        var name = "agreement";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("agreement" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "center", "marginBottom" to "40rpx", "alignItems" to "center")), "agreement-text" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#6e6e6e")), "link" to padStyleMapOf(utsMapOf("color" to "#264060", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("update:modelValue" to null);
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "Boolean", "default" to false)));
        var propsNeedCastKeys = utsArrayOf(
            "modelValue"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
