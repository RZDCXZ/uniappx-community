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
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesUserResetPasswordUserResetPassword : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(options: OnLoadOptions) {
            if (options.has("phone")) {
                this.phone = options.get("phone") as String;
            } else {
                this.phone = userState.phone as String;
            }
            if (options.has("type")) {
                this.type = options.get("type") as String;
            }
        }
        , instance);
    }
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
                createElementVNode("text", utsMapOf("class" to "login-title"), toDisplayString(_ctx.title), 1),
                if (_ctx.phone != "") {
                    createElementVNode("text", utsMapOf("key" to 0, "class" to "input-tip"), "通过手机号 " + toDisplayString(_ctx.phone) + " 进行验证", 1);
                } else {
                    createCommentVNode("v-if", true);
                }
                ,
                createVNode(_component_login_input, utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "10rpx")), "modelValue" to _ctx.code, "onUpdate:modelValue" to fun(`$event`: String){
                    _ctx.code = `$event`;
                }
                , "placeholder" to "请输入验证码", "maxlength" to 6, "btn" to if (_ctx.time > 0) {
                    "" + _ctx.time + "s";
                } else {
                    "发送验证码";
                }
                , "onClick" to _ctx.sendSmsCode), null, 8, utsArrayOf(
                    "style",
                    "modelValue",
                    "onUpdate:modelValue",
                    "btn",
                    "onClick"
                )),
                createVNode(_component_login_input, utsMapOf("password" to true, "type" to "safe-password", "style" to normalizeStyle(utsMapOf("margin-top" to "0")), "modelValue" to _ctx.password, "onUpdate:modelValue" to fun(`$event`: String){
                    _ctx.password = `$event`;
                }
                , "placeholder" to "请输入密码", "confirm-type" to "send", "onConfirm" to _ctx.submit), null, 8, utsArrayOf(
                    "style",
                    "modelValue",
                    "onUpdate:modelValue",
                    "onConfirm"
                )),
                createElementVNode("text", utsMapOf("class" to "input-tip"), "温馨提示：密码为6-20位，至少包含大写/小写字母/数字符号2中组合"),
                createElementVNode("view", utsMapOf("class" to "login-bottom"), utsArrayOf(
                    createVNode(_component_main_btn, utsMapOf("disabled" to _ctx.disabled, "borderRadius" to "0", "width" to "750rpx", "height" to "98rpx", "fontSize" to "18px", "onClick" to fun(){
                        _ctx.submit();
                    }
                    ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "完成"
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
    open var code: String by `$data`;
    open var password: String by `$data`;
    open var time: Number by `$data`;
    open var type: String by `$data`;
    open var phone: String by `$data`;
    open var title: String by `$data`;
    open var disabled: Boolean by `$data`;
    open var sendSmsDisabled: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("code" to "", "password" to "", "time" to 0, "type" to "changepwd", "phone" to "", "title" to computed<String>(fun(): String {
            if (this.type == "forget") {
                return "重置密码";
            }
            return "修改密码";
        }
        ), "disabled" to computed<Boolean>(fun(): Boolean {
            return this.password.trim().length < 5;
        }
        ), "sendSmsDisabled" to computed<Boolean>(fun(): Boolean {
            return this.time > 0;
        }
        ));
    }
    override fun `$initMethods`() {
        this.sendSmsCode = fun() {
            if (this.sendSmsDisabled) {
                return;
            }
            uni_showLoading(ShowLoadingOptions(title = "发送中...", mask = true));
            var data: UTSJSONObject = object : UTSJSONObject(UTSSourceMapPosition("data", "pages/user-reset-password/user-reset-password.uvue", 63, 9)) {
            };
            var url = "sendcode2";
            if (this.type == "forget") {
                data.set("phone", this.phone);
                url = "sendcode";
            }
            uni_request<defaultResult>(RequestOptions(url = getURL("/user/" + url), method = "POST", data = data, header = object : UTSJSONObject() {
                var token = getToken()
            }, success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                if (r.msg == "发送成功") {
                    uni_showToast(ShowToastOptions(title = "发送成功"));
                } else {
                    uni_showModal(ShowModalOptions(content = r.msg, showCancel = false));
                }
                this.handleSendSmsCode();
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
        this.handleSendSmsCode = fun() {
            this.time = 60;
            var interval: Number = 0;
            interval = setInterval(fun(){
                this.time--;
                if (this.time <= 0) {
                    clearInterval(interval);
                }
            }
            , 1000);
        }
        ;
        this.submit = fun() {
            if (this.disabled) {
                return;
            }
            uni_showLoading(ShowLoadingOptions(title = "修改中...", mask = true));
            var data: UTSJSONObject = let {
                object : UTSJSONObject(UTSSourceMapPosition("data", "pages/user-reset-password/user-reset-password.uvue", 131, 9)) {
                    var code = it.code
                    var password = it.password
                }
            };
            if (this.type == "forget") {
                data.set("phone", this.phone);
            }
            uni_request<defaultResult>(RequestOptions(url = getURL("/user/" + this.type), method = "POST", header = object : UTSJSONObject() {
                var token = getToken()
            }, data = data, success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                var delta: Number = 1;
                if (this.type == "changepwd") {
                    updatePassword();
                } else {
                    delta = 2;
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                }
                setTimeout(fun(){
                    uni_navigateBack(NavigateBackOptions(delta = delta));
                }
                , 300);
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
    open lateinit var sendSmsCode: () -> Unit;
    open lateinit var handleSendSmsCode: () -> Unit;
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
