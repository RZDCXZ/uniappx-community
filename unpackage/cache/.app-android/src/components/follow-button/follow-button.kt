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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenComponentsFollowButtonFollowButton : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        return if (_ctx.type == "main-btn") {
            createVNode(_component_main_btn, utsMapOf("key" to 0, "onClick" to withModifiers(_ctx.handleFollow, utsArrayOf(
                "stop"
            )), "width" to "330rpx", "height" to "65rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    toDisplayString(if (_ctx.modelValue) {
                        "已关注";
                    } else {
                        "关注";
                    })
                );
            }), "_" to 1), 8, utsArrayOf(
                "onClick"
            ));
        } else {
            createElementVNode("text", utsMapOf("key" to 1, "class" to normalizeClass(utsArrayOf(
                "follow",
                utsMapOf("follow-" + _ctx.type to true, "follow-active" to _ctx.modelValue)
            )), "onClick" to withModifiers(_ctx.handleFollow, utsArrayOf(
                "stop"
            ))), toDisplayString(if (_ctx.modelValue) {
                "已关注";
            } else {
                "关注";
            }
            ), 11, utsArrayOf(
                "onClick"
            ));
        }
        ;
    }
    open var modelValue: Boolean by `$props`;
    open var user_id: Number by `$props`;
    open var type: String by `$props`;
    open var loading: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("loading" to false);
    }
    override fun `$initMethods`() {
        this.handleFollow = fun() {
            AuthAction(fun(){
                if (this.loading) {
                    return;
                }
                this.loading = true;
                var action = if (this.modelValue) {
                    "remove_follow";
                } else {
                    "add_follow";
                }
                ;
                uni_request<defaultResult>(RequestOptions(url = getURL("/" + action + "/" + this.user_id), method = "POST", header = object : UTSJSONObject() {
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
                    uni__emit("onUpdateArticleChange", updateArticleChangeEvent(id = this.user_id, key = "updateFollow", value = if (this.modelValue) {
                        "false";
                    } else {
                        "true";
                    }
                    ));
                    this.`$emit`("update:modelValue", !this.modelValue);
                }
                , fail = fun(err){
                    uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
                }
                , complete = fun(_){
                    setTimeout(fun(){
                        this.loading = false;
                    }
                    , 300);
                }
                ));
            }
            );
        }
        ;
    }
    open lateinit var handleFollow: () -> Unit;
    companion object {
        var name = "follow-button";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("follow" to padStyleMapOf(utsMapOf("fontSize" to 15, "fontWeight" to "bold", "marginLeft" to "auto")), "follow-text" to padStyleMapOf(utsMapOf("color" to "#de6489", "paddingTop" to "10rpx", "paddingRight" to "10rpx", "paddingBottom" to "10rpx", "paddingLeft" to "10rpx")), "follow-plain" to padStyleMapOf(utsMapOf("color" to "#de6489", "borderWidth" to "1rpx", "borderStyle" to "solid", "borderColor" to "#de6489", "borderRadius" to 6, "paddingTop" to "10rpx", "paddingRight" to "25rpx", "paddingBottom" to "10rpx", "paddingLeft" to "25rpx", "fontSize" to 14)), "follow-button" to padStyleMapOf(utsMapOf("borderRadius" to 6, "backgroundColor" to "#de6489", "color" to "#ffffff", "paddingTop" to "10rpx", "paddingRight" to "25rpx", "paddingBottom" to "10rpx", "paddingLeft" to "25rpx")), "follow-active" to padStyleMapOf(utsMapOf("color" to "#9a9a9a", "backgroundColor" to "#ffffff", "borderColor" to "#ffffff")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("update:modelValue" to null);
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "Boolean", "default" to false), "user_id" to utsMapOf("type" to "Number", "default" to 0), "type" to utsMapOf("type" to "String", "default" to "text")));
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "user_id",
            "type"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
