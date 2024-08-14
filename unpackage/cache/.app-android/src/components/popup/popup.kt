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
open class GenComponentsPopupPopup : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode(Fragment, null, utsArrayOf(
            if (isTrue(_ctx.show)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "popup-mask", "onClick" to _ctx.close), null, 8, utsArrayOf(
                    "onClick"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                "popup",
                if (_ctx.show) {
                    "popup-show";
                } else {
                    "";
                }
            ))), utsArrayOf(
                if (_ctx.title != "") {
                    createElementVNode("view", utsMapOf("key" to 0, "class" to "popup-header"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "iconfont popup-action", "style" to normalizeStyle(utsMapOf("font-size" to "22px")), "onClick" to _ctx.close), "×", 12, utsArrayOf(
                            "onClick"
                        )),
                        createElementVNode("text", utsMapOf("class" to "popup-title"), toDisplayString(_ctx.title), 1),
                        createElementVNode("text", utsMapOf("class" to "popup-action", "style" to normalizeStyle(utsMapOf("color" to "#949494")), "onClick" to fun(){
                            _ctx.`$emit`("confirm");
                        }), "完成", 12, utsArrayOf(
                            "onClick"
                        ))
                    ));
                } else {
                    createCommentVNode("v-if", true);
                }
                ,
                renderSlot(_ctx.`$slots`, "default"),
                if (isTrue(_ctx.showCancel)) {
                    createElementVNode("view", utsMapOf("key" to 1, "class" to "popup-cancel", "onClick" to _ctx.close), utsArrayOf(
                        createElementVNode("text", null, "取消")
                    ), 8, utsArrayOf(
                        "onClick"
                    ));
                } else {
                    createCommentVNode("v-if", true);
                }
            ), 2)
        ), 64);
    }
    open var title: String by `$props`;
    open var showCancel: Boolean by `$props`;
    open var show: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("show" to false);
    }
    override fun `$initMethods`() {
        this.open = fun() {
            this.show = true;
        }
        ;
        this.close = fun() {
            this.show = false;
        }
        ;
    }
    open lateinit var open: () -> Unit;
    open lateinit var close: () -> Unit;
    companion object {
        var name = "popup";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("popup-mask" to padStyleMapOf(utsMapOf("position" to "fixed", "left" to 0, "top" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "rgba(0,0,0,0.3)", "zIndex" to 99)), "popup" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "right" to 0, "left" to 0, "backgroundColor" to "#ffffff", "zIndex" to 100, "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "transform" to "translateY(1000px)", "opacity" to 0, "transitionProperty" to "transform,opacity", "transitionDuration" to "400ms")), "popup-show" to padStyleMapOf(utsMapOf("opacity" to 1, "transform" to "translateY(0)")), "popup-header" to padStyleMapOf(utsMapOf("height" to "112rpx", "flexDirection" to "row", "alignItems" to "center", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#ececec")), "popup-action" to padStyleMapOf(utsMapOf("fontSize" to 16, "width" to "100rpx", "height" to "112rpx", "textAlign" to "center", "lineHeight" to "112rpx")), "popup-title" to padStyleMapOf(utsMapOf("flex" to 1, "textAlign" to "center", "fontWeight" to "bold", "fontSize" to 16)), "popup-cancel" to padStyleMapOf(utsMapOf("height" to "100rpx", "width" to "750rpx", "alignItems" to "center", "justifyContent" to "center")), "@TRANSITION" to utsMapOf("popup" to utsMapOf("property" to "transform,opacity", "duration" to "400ms")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("confirm" to null);
        var props = normalizePropsOptions(utsMapOf("title" to utsMapOf("type" to "String", "default" to ""), "showCancel" to utsMapOf("type" to "Boolean", "default" to true)));
        var propsNeedCastKeys = utsArrayOf(
            "title",
            "showCancel"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
