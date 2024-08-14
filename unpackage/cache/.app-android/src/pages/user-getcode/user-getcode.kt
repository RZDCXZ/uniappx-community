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
open class GenPagesUserGetcodeUserGetcode : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(options: OnLoadOptions) {
            if (options.has("phone")) {
                this.phone = options.get("phone") as String;
            }
            if (options.has("type")) {
                this.type = options.get("type") as String;
            }
        }
        , instance);
        onReady(fun() {
            if (this.phone.length == 11) {
                this.sendSmsCode();
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
                createElementVNode("view", utsMapOf("class" to "login-info"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "login-info-phone"), toDisplayString(_ctx.phone), 1),
                    createElementVNode("text", utsMapOf("class" to "iconfont", "style" to normalizeStyle(utsMapOf("color" to "#8f8f8f"))), toDisplayString("\ue668"), 4)
                )),
                createVNode(_component_login_input, utsMapOf("auto-focus" to true, "modelValue" to _ctx.code, "onUpdate:modelValue" to utsArrayOf(
                    fun(`$event`){
                        _ctx.code = `$event`;
                    }
                    ,
                    _ctx.submit
                ), "placeholder" to "请输入验证码", "maxlength" to 6), null, 8, utsArrayOf(
                    "modelValue",
                    "onUpdate:modelValue"
                )),
                createElementVNode("view", utsMapOf("class" to "login-bottom"), utsArrayOf(
                    createVNode(_component_main_btn, utsMapOf("disabled" to _ctx.disabled, "borderRadius" to "0", "width" to "750rpx", "height" to "98rpx", "fontSize" to "18px", "onClick" to _ctx.sendSmsCode), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "重新发送" + toDisplayString(if (_ctx.time > 0) {
                                "" + _ctx.time + "s";
                            } else {
                                "";
                            }
                            )
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
    open var code: String by `$data`;
    open var time: Number by `$data`;
    open var type: String by `$data`;
    open var disabled: Boolean by `$data`;
    open var title: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("phone" to "", "code" to "", "time" to 0, "type" to "login", "disabled" to computed<Boolean>(fun(): Boolean {
            return this.time > 0;
        }
        ), "title" to computed<String>(fun(): String {
            if (this.type == "login") {
                return "登录";
            } else if (this.type == "bindphone") {
                return "绑定";
            }
            return "";
        }
        ));
    }
    override fun `$initMethods`() {
        this.submit = fun(code: String) {
            if (code.length < 6) {
                return;
            }
            uni_showLoading(ShowLoadingOptions(title = this.title + "中...", mask = true));
            var t = if (this.type == "login") {
                "phonelogin";
            } else {
                "bindphone";
            }
            ;
            uni_request<Result<UserDetail>>(RequestOptions(url = getURL("/user/" + t), method = "POST", data = let {
                object : UTSJSONObject() {
                    var phone = it.phone
                    var code = code
                }
            }, header = object : UTSJSONObject() {
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
                if (this.type == "login") {
                    login(r.data as UserDetail);
                } else {
                    updatePhoneAndName(r.data as UserDetail);
                }
                uni_navigateBack(NavigateBackOptions(delta = 2));
                setTimeout(fun() {
                    uni_showToast(ShowToastOptions(title = this.title + "成功", icon = "none"));
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
        this.sendSmsCode = fun() {
            uni_showLoading(ShowLoadingOptions(title = "发送中...", mask = true));
            uni_request<defaultResult>(RequestOptions(url = getURL("/user/sendcode"), method = "POST", data = let {
                object : UTSJSONObject() {
                    var phone = it.phone
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
    }
    open lateinit var submit: (code: String) -> Unit;
    open lateinit var sendSmsCode: () -> Unit;
    open lateinit var handleSendSmsCode: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("login-info" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "marginTop" to "40rpx")), "login-info-phone" to padStyleMapOf(utsMapOf("color" to "#8f8f8f", "fontWeight" to "bold", "marginRight" to "20rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
