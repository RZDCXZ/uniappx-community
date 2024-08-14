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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesUserLoginPasswordUserLoginPassword : BasePage {
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
                createElementVNode("text", utsMapOf("class" to "login-title"), "密码登录"),
                createVNode(_component_login_input, utsMapOf("auto-focus" to true, "modelValue" to _ctx.username, "onUpdate:modelValue" to fun(`$event`: String){
                    _ctx.username = `$event`;
                }
                , "placeholder" to "输入手机号/邮箱"), null, 8, utsArrayOf(
                    "modelValue",
                    "onUpdate:modelValue"
                )),
                createVNode(_component_login_input, utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "0")), "modelValue" to _ctx.password, "onUpdate:modelValue" to fun(`$event`: String){
                    _ctx.password = `$event`;
                }
                , "type" to "safe-password", "placeholder" to "输入密码", "confirm-type" to "send", "onConfirm" to _ctx.submit, "btn" to "忘记密码", "onClick" to _ctx.openForgetPassword), null, 8, utsArrayOf(
                    "style",
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
                    createVNode(_component_main_btn, utsMapOf("disabled" to _ctx.disabled, "borderRadius" to "0", "width" to "750rpx", "height" to "98rpx", "fontSize" to "18px", "onClick" to fun(){
                        _ctx.submit();
                    }
                    ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "登录"
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
    open var username: String by `$data`;
    open var password: String by `$data`;
    open var isagree: Boolean by `$data`;
    open var disabled: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("username" to "", "password" to "", "isagree" to false, "disabled" to computed<Boolean>(fun(): Boolean {
            return this.username.trim().length == 0 || this.password.trim().length == 0;
        }
        ));
    }
    override fun `$initMethods`() {
        this.openForgetPassword = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/user-forget-password/user-forget-password"));
        }
        ;
        this.submit = fun() {
            if (this.disabled) {
                return;
            }
            if (!this.isagree) {
                uni_showToast(ShowToastOptions(title = "请先阅读并同意用户协议和隐私政策", icon = "none"));
                return;
            }
            uni_showLoading(ShowLoadingOptions(title = "登录中...", mask = false));
            uni_request<Result<UserDetail>>(RequestOptions(url = getURL("/user/login"), method = "POST", data = let {
                object : UTSJSONObject() {
                    var username = it.username
                    var password = it.password
                }
            }, success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                login(r.data as UserDetail);
                uni_navigateBack(NavigateBackOptions(delta = 2));
                setTimeout(fun() {
                    uni_showToast(ShowToastOptions(title = "登录成功", icon = "none"));
                }
                , 200);
            }
            , fail = fun(err){
                uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
            }
            , complete = fun(_){
                uni_hideLoading();
            }
            ));
        }
        ;
    }
    open lateinit var openForgetPassword: () -> Unit;
    open lateinit var submit: () -> Unit;
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
