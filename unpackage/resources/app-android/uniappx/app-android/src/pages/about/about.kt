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
import io.dcloud.uniapp.extapi.getAppBaseInfo as uni_getAppBaseInfo;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesAboutAbout : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(_: OnLoadOptions) {
            val res = uni_getAppBaseInfo(null);
            this.appVersion = res.appVersion as String;
            this.agreementUrl = uni.UNIC512840.agreementUrl;
            this.privacyUrl = uni.UNIC512840.privacyUrl;
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        val _component_cell = resolveEasyComponent("cell", GenComponentsCellCellClass);
        val _component_uni_upgrade_center_app = resolveEasyComponent("uni-upgrade-center-app", GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterAppClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "app-logo"), utsArrayOf(
                createVNode(_component_avatar, utsMapOf("src" to "/static/default-avatar.png", "width" to "175rpx", "height" to "175rpx")),
                createElementVNode("text", utsMapOf("class" to "app-version"), "version " + toDisplayString(_ctx.appVersion), 1)
            )),
            createVNode(_component_cell, utsMapOf("title" to "新版本检测", "onClick" to _ctx.checkUpdate), null, 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_cell, utsMapOf("title" to "用户协议", "onClick" to fun(){
                _ctx.openWebview(_ctx.agreementUrl);
            }
            ), null, 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_cell, utsMapOf("title" to "隐私政策", "onClick" to fun(){
                _ctx.openWebview(_ctx.privacyUrl);
            }
            ), null, 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_uni_upgrade_center_app, utsMapOf("ref" to "upgradePopup"), null, 512)
        ), 4);
    }
    open var appVersion: String by `$data`;
    open var agreementUrl: String by `$data`;
    open var privacyUrl: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("appVersion" to "", "agreementUrl" to "", "privacyUrl" to "");
    }
    override fun `$initMethods`() {
        this.checkUpdate = fun() {
            uni_showLoading(ShowLoadingOptions(title = "请求中...", mask = true));
            default1(this.`$refs`["upgradePopup"] as ComponentPublicInstance).`catch`(fun(err){
                var e = JSON.parse<UTSJSONObject>(JSON.stringify(err));
                if (e != null) {
                    var title = e.get("message") as String;
                    uni_showToast(ShowToastOptions(title = title, icon = "none"));
                }
            }
            ).`finally`(fun(){
                uni_hideLoading();
            }
            );
        }
        ;
        this.openWebview = fun(url: String) {
            uni_navigateTo(NavigateToOptions(url = "/pages/webview/webview?url=" + url));
        }
        ;
    }
    open lateinit var checkUpdate: () -> Unit;
    open lateinit var openWebview: (url: String) -> Unit;
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
                return utsMapOf("app-logo" to padStyleMapOf(utsMapOf("alignItems" to "center", "justifyContent" to "center", "paddingTop" to "60rpx", "paddingBottom" to "50rpx")), "app-version" to padStyleMapOf(utsMapOf("marginTop" to "25rpx", "fontSize" to 14, "color" to "#0d0d0d")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
