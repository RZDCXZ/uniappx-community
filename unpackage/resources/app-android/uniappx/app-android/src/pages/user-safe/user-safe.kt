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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
open class GenPagesUserSafeUserSafe : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onPageShow(fun() {
            this.phone = if (userState.phone == null) {
                "";
            } else {
                userState.phone as String;
            }
            ;
            this.password = userState.password;
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_cell = resolveEasyComponent("cell", GenComponentsCellCellClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createVNode(_component_cell, utsMapOf("title" to "手机号", "right-text" to _ctx.phone, "show-arrow" to false, "onClick" to fun(){
                _ctx.bindPhone();
            }
            ), null, 8, utsArrayOf(
                "right-text",
                "onClick"
            )),
            createVNode(_component_cell, utsMapOf("title" to "登陆密码", "right-text" to if (_ctx.password) {
                "修改密码";
            } else {
                "设置密码";
            }
            , "onClick" to fun(){
                _ctx.resetPassword();
            }
            ), null, 8, utsArrayOf(
                "right-text",
                "onClick"
            ))
        ), 4);
    }
    open var phone: String by `$data`;
    open var password: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("phone" to "", "password" to false);
    }
    override fun `$initMethods`() {
        this.bindPhone = fun() {
            var url = "/pages/user-bindphone/user-bindphone";
            if (this.phone != "") {
                uni_showModal(ShowModalOptions(content = "是否要修改绑定手机号？", confirmText = "修改", success = fun(res){
                    if (res.confirm) {
                        uni_navigateTo(NavigateToOptions(url = url));
                    }
                }
                ));
                return;
            }
            uni_navigateTo(NavigateToOptions(url = url));
        }
        ;
        this.resetPassword = fun() {
            if (this.phone == "") {
                uni_showModal(ShowModalOptions(content = "请先绑定手机号？", confirmText = "修改", success = fun(res){
                    if (res.confirm) {
                        uni_navigateTo(NavigateToOptions(url = "/pages/user-bindphone/user-bindphone"));
                    }
                }
                ));
                return;
            }
            uni_navigateTo(NavigateToOptions(url = "/pages/user-reset-password/user-reset-password"));
        }
        ;
    }
    open lateinit var bindPhone: () -> Unit;
    open lateinit var resetPassword: () -> Unit;
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
