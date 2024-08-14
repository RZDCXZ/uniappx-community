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
open class GenPagesUserLoginUserLogin : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_navbar = resolveEasyComponent("navbar", GenComponentsNavbarNavbarClass);
        val _component_login_input = resolveEasyComponent("login-input", GenComponentsLoginInputLoginInputClass);
        val _component_agreement = resolveEasyComponent("agreement", GenComponentsAgreementAgreementClass);
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_navbar),
            createElementVNode("view", utsMapOf("class" to "login-page"), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "login-title"), "登录"),
                createVNode(_component_login_input, utsMapOf("auto-focus" to true, "fontSize" to "24px", "modelValue" to _ctx.phone, "onUpdate:modelValue" to fun(`$event`: String){
                    _ctx.phone = `$event`;
                }
                , "type" to "tel", "placeholder" to "输入手机号", "maxlength" to 11, "confirm-type" to "send", "onConfirm" to _ctx.openGetCode, "btn" to "密码登录", "onClick" to _ctx.openLoginByPassword), null, 8, utsArrayOf(
                    "modelValue",
                    "onUpdate:modelValue",
                    "onConfirm",
                    "onClick"
                )),
                createElementVNode("view", utsMapOf("class" to "login-bottom"), utsArrayOf(
                    createVNode(_component_agreement, utsMapOf("modelValue" to _ctx.isagree, "onUpdate:modelValue" to fun(`$event`: Boolean){
                        _ctx.isagree = `$event`;
                    }
                    ), null, 8, utsArrayOf(
                        "modelValue",
                        "onUpdate:modelValue"
                    )),
                    createVNode(_component_main_btn, utsMapOf("disabled" to _ctx.disabled, "borderRadius" to "0", "width" to "750rpx", "height" to "98rpx", "fontSize" to "18px", "onClick" to _ctx.openGetCode), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "获取验证码"
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
    open var isagree: Boolean by `$data`;
    open var disabled: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("phone" to "", "isagree" to false, "disabled" to computed<Boolean>(fun(): Boolean {
            return this.phone.trim().length != 11;
        }
        ));
    }
    override fun `$initMethods`() {
        this.openLoginByPassword = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/user-login-password/user-login-password"));
        }
        ;
        this.openGetCode = fun() {
            if (!isValidPhoneNumber(this.phone)) {
                uni_showToast(ShowToastOptions(title = "请输入合法手机号", icon = "none"));
                return;
            }
            if (!this.isagree) {
                uni_showToast(ShowToastOptions(title = "请先阅读并同意用户协议和隐私政策", icon = "none"));
                return;
            }
            uni_navigateTo(NavigateToOptions(url = "/pages/user-getcode/user-getcode?phone=" + this.phone));
        }
        ;
    }
    open lateinit var openLoginByPassword: () -> Unit;
    open lateinit var openGetCode: () -> Unit;
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
