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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesUserFeedbackFormUserFeedbackForm : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        val _component_navbar = resolveEasyComponent("navbar", GenComponentsNavbarNavbarClass);
        val _component_upload_images = resolveEasyComponent("upload-images", GenComponentsUploadImagesUploadImagesClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_navbar, utsMapOf("type" to "text", "title" to "意见反馈"), utsMapOf("right" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "navbar-right"), utsArrayOf(
                        createVNode(_component_main_btn, utsMapOf("disabled" to _ctx.disabled, "width" to "138rpx", "height" to "60rpx", "font-size" to "14px", "onClick" to _ctx.submit), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                "提交反馈"
                            );
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "disabled",
                            "onClick"
                        ))
                    ))
                );
            }
            ), "_" to 1)),
            createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1", "background-color" to "#f4f4f4"))), utsArrayOf(
                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("background-color" to "#ffffff"))), utsArrayOf(
                    createElementVNode("textarea", utsMapOf("auto-focus" to true, "auto-height" to true, "modelValue" to _ctx.content, "onInput" to fun(`$event`: InputEvent){
                        _ctx.content = `$event`.detail.value;
                    }
                    , "placeholder" to "请说明具体问题(300字以内)~", "class" to "add-textarea"), null, 40, utsArrayOf(
                        "modelValue",
                        "onInput"
                    )),
                    createVNode(_component_upload_images, utsMapOf("ref" to "upload", "style" to normalizeStyle(utsMapOf("margin-bottom" to "60rpx"))), null, 8, utsArrayOf(
                        "style"
                    ))
                ), 4)
            ), 4)
        ), 64);
    }
    open var content: String by `$data`;
    open var disabled: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("content" to "", "disabled" to computed<Boolean>(fun(): Boolean {
            return this.content.length == 0;
        }
        ));
    }
    override fun `$initMethods`() {
        this.submit = fun() {
            val uploadRef = this.`$refs`["upload"] as ComponentPublicInstance;
            if (uploadRef.`$callMethod`("isUploading") as Boolean) {
                uni_showToast(ShowToastOptions(title = "还有图片正在上传中...", icon = "none"));
                return;
            }
            var images = uploadRef.`$callMethod`("getValue") as UTSArray<String>;
            var data: UTSJSONObject = let {
                object : UTSJSONObject() {
                    var images = images
                    var content = it.content
                }
            };
            uni_showLoading(ShowLoadingOptions(title = "提交中...", mask = false));
            uni_request<defaultResult>(RequestOptions(url = getURL("/feedback/save"), method = "POST", data = data, header = object : UTSJSONObject() {
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
                uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                setTimeout(fun() {
                    uni_navigateBack(NavigateBackOptions(delta = 1));
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
    open lateinit var submit: () -> Unit;
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
                return utsMapOf("navbar-right" to padStyleMapOf(utsMapOf("height" to 45, "alignItems" to "center", "justifyContent" to "center", "marginRight" to "34rpx")), "cell-tip" to padStyleMapOf(utsMapOf("color" to "#f0748a", "backgroundColor" to "#fff1f6", "borderRadius" to 4, "marginLeft" to "18rpx", "fontSize" to 13, "paddingTop" to "5rpx", "paddingRight" to "10rpx", "paddingBottom" to "5rpx", "paddingLeft" to "10rpx")), "add-textarea" to padStyleMapOf(utsMapOf("width" to "750rpx", "maxHeight" to "500rpx", "paddingTop" to "60rpx", "paddingRight" to "30rpx", "paddingBottom" to "60rpx", "paddingLeft" to "30rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
