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
import io.dcloud.uniapp.extapi.getStorageInfo as uni_getStorageInfo;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.removeStorageSync as uni_removeStorageSync;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesUserSettingUserSetting : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(_: OnLoadOptions) {
            this.getStorageInfo();
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_cell = resolveEasyComponent("cell", GenComponentsCellCellClass);
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createVNode(_component_cell, utsMapOf("title" to "账号与安全", "onClick" to fun(){
                _ctx.open("user-safe");
            }
            ), null, 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_cell, utsMapOf("title" to "资料编辑", "onClick" to fun(){
                _ctx.open("user-editinfo");
            }
            ), null, 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_cell, utsMapOf("title" to "清除缓存", "right-text" to _ctx.currentSize, "show-arrow" to false, "onClick" to _ctx.clearStorage), null, 8, utsArrayOf(
                "right-text",
                "onClick"
            )),
            createVNode(_component_cell, utsMapOf("title" to "意见反馈", "onClick" to fun(){
                _ctx.open("user-feedback");
            }
            ), null, 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_cell, utsMapOf("title" to "关于社区", "onClick" to fun(){
                _ctx.open("about");
            }
            ), null, 8, utsArrayOf(
                "onClick"
            )),
            if (isTrue(_ctx.loginState)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "flex-center", "style" to normalizeStyle(utsMapOf("padding" to "20rpx 0"))), utsArrayOf(
                    createVNode(_component_main_btn, utsMapOf("width" to "600rpx", "onClick" to _ctx.logout), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "退出登录"
                        );
                    }), "_" to 1), 8, utsArrayOf(
                        "onClick"
                    ))
                ), 4);
            } else {
                createCommentVNode("v-if", true);
            }
        ), 4);
    }
    open var currentSize: String by `$data`;
    open var keys: UTSArray<String> by `$data`;
    open var loginState: Boolean by `$data`;
    open var id: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("currentSize" to "", "keys" to utsArrayOf<String>(), "loginState" to computed<Boolean>(fun(): Boolean {
            return uni.UNIC512840.loginState.value;
        }
        ), "id" to computed<Number>(fun(): Number {
            return userState.id;
        }
        ));
    }
    override fun `$initMethods`() {
        this.logout = fun() {
            uni_showModal(ShowModalOptions(content = "是否要退出登录？", confirmText = "立即退出", success = fun(res){
                if (!res.confirm) {
                    return;
                }
                uni_showLoading(ShowLoadingOptions(title = "退出登录中...", mask = false));
                uni_request<defaultResult>(RequestOptions(url = getURL("/user/logout"), method = "POST", header = object : UTSJSONObject() {
                    var token = getToken()
                }, complete = fun(_){
                    uni_hideLoading();
                    uni.UNIC512840.logout();
                    uni_showToast(ShowToastOptions(title = "退出成功", icon = "none"));
                    setTimeout(fun() {
                        uni_navigateBack(NavigateBackOptions(delta = 1));
                    }
                    , 300);
                }
                ));
            }
            ));
        }
        ;
        this.getStorageInfo = fun() {
            uni_getStorageInfo(GetStorageInfoOptions(success = fun(res){
                this.currentSize = if (res.currentSize > 1024) {
                    (res.currentSize / 1024).toFixed(2) + "MB";
                } else {
                    res.currentSize.toFixed(2) + "KB";
                }
                ;
                this.keys = res.keys.filter(fun(k: String): Boolean {
                    return !whites.includes(k);
                }
                );
            }
            ));
        }
        ;
        this.clearStorage = fun() {
            uni_showModal(ShowModalOptions(title = "提示", content = "是否要清除缓存？", confirmText = "立即清除", success = fun(res){
                if (res.confirm) {
                    run {
                        var i: Number = 0;
                        while(i < this.keys.length){
                            uni_removeStorageSync(this.keys[i]);
                            i++;
                        }
                    }
                    this.getStorageInfo();
                    uni_showToast(ShowToastOptions(title = "清除缓存成功", icon = "none"));
                }
            }
            ));
        }
        ;
        this.open = fun(p: String) {
            var url = "/pages/" + p + "/" + p;
            if (p == "user-safe" || p == "user-feedback" || p == "user-editinfo") {
                AuthNavigateTo("" + url + "?user_id=" + this.id);
                return;
            }
            uni_navigateTo(NavigateToOptions(url = url));
        }
        ;
    }
    open lateinit var logout: () -> Unit;
    open lateinit var getStorageInfo: () -> Unit;
    open lateinit var clearStorage: () -> Unit;
    open lateinit var open: (p: String) -> Unit;
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
