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
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesUserForgetPasswordUserForgetPassword : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_navbar = resolveEasyComponent("navbar", GenComponentsNavbarNavbarClass);
        val _component_login_input = resolveEasyComponent("login-input", GenComponentsLoginInputLoginInputClass);
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_navbar),
            createElementVNode("view", utsMapOf("class" to "login-page"), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "login-title"), "忘记密码"),
                createVNode(_component_login_input, utsMapOf("auto-focus" to true, "fontSize" to "24px", "modelValue" to _ctx.phone, "onUpdate:modelValue" to fun(`$event`: String){
                    _ctx.phone = `$event`;
                }
                , "type" to "tel", "placeholder" to "输入手机号", "maxlength" to 11, "confirm-type" to "send", "onConfirm" to _ctx.next), null, 8, utsArrayOf(
                    "modelValue",
                    "onUpdate:modelValue",
                    "onConfirm"
                )),
                createElementVNode("view", utsMapOf("class" to "login-bottom"), utsArrayOf(
                    createVNode(_component_main_btn, utsMapOf("disabled" to _ctx.disabled, "borderRadius" to "0", "width" to "750rpx", "height" to "98rpx", "fontSize" to "18px", "onClick" to _ctx.next), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "下一步"
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "disabled",
                        "onClick"
                    ))
                ))
            ))
        ), 64);
    }
    open var phone: String by `$data`;
    open var disabled: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("phone" to "", "disabled" to computed<Boolean>(fun(): Boolean {
            return this.phone.trim().length != 11;
        }
        ));
    }
    override fun `$initMethods`() {
        this.next = fun() {
            if (this.disabled) {
                return;
            }
            if (!isValidPhoneNumber(this.phone)) {
                uni_showToast(ShowToastOptions(title = "请输入合法手机号", icon = "none"));
                return;
            }
            uni_navigateTo(NavigateToOptions(url = "/pages/user-reset-password/user-reset-password?phone=" + this.phone + "&type=forget"));
        }
        ;
    }
    open lateinit var next: () -> Unit;
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
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
