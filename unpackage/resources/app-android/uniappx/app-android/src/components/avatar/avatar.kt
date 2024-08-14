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
open class GenComponentsAvatarAvatar : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "avatar-box"), utsArrayOf(
            if (_ctx.tip != "") {
                createElementVNode("text", utsMapOf("key" to 0, "class" to "avatar-tip"), toDisplayString(_ctx.tip), 1);
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode("image", utsMapOf("src" to _ctx.url, "mode" to "aspectFill", "fade-show" to true, "style" to normalizeStyle(utsMapOf("width" to _ctx.width, "height" to _ctx.height)), "onLoad" to _ctx.load, "onError" to _ctx.error), null, 44, utsArrayOf(
                "src",
                "onLoad",
                "onError"
            ))
        ));
    }
    open var src: String by `$props`;
    open var width: String by `$props`;
    open var height: String by `$props`;
    open var tip: String by `$data`;
    open var url: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("tip" to "加载中...", "url" to computed<String>(fun(): String {
            return if (this.src == "") {
                "/static/default-avatar.png";
            } else {
                this.src;
            }
            ;
        }
        ));
    }
    override fun `$initMethods`() {
        this.load = fun() {
            this.tip = "";
        }
        ;
        this.error = fun(e: UniImageErrorEvent) {
            e.target?.setAttribute("src", "/static/default-avatar.png");
        }
        ;
    }
    open lateinit var load: () -> Unit;
    open lateinit var error: (e: UniImageErrorEvent) -> Unit;
    companion object {
        var name = "avatar";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("avatar-box" to padStyleMapOf(utsMapOf("borderRadius" to 50, "backgroundColor" to "#f2f2f2", "position" to "relative", "alignItems" to "center", "justifyContent" to "center")), "avatar-tip" to padStyleMapOf(utsMapOf("fontSize" to 7, "position" to "absolute", "color" to "#a6a6a6")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("src" to utsMapOf("type" to "String", "default" to ""), "width" to utsMapOf("type" to "String", "default" to "75rpx"), "height" to utsMapOf("type" to "String", "default" to "75rpx")));
        var propsNeedCastKeys = utsArrayOf(
            "src",
            "width",
            "height"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
