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
open class GenComponentsLoadingMoreLoadingMore : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return if (_ctx.loadingText != "") {
            createElementVNode("view", utsMapOf("key" to 0, "class" to "loading"), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "loading-text"), toDisplayString(_ctx.loadingText), 1)
            ));
        } else {
            createCommentVNode("v-if", true);
        }
        ;
    }
    open var loading: Boolean by `$props`;
    open var isEnded: Boolean by `$props`;
    open var loadingText: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("loadingText" to computed<String>(fun(): String {
            if (this.loading) {
                return "加载中...";
            } else if (this.isEnded) {
                return "已经到底了";
            } else {
                return "上拉加载更多";
            }
        }
        ));
    }
    companion object {
        var name = "loading-more";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("loading" to padStyleMapOf(utsMapOf("paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "justifyContent" to "center", "alignItems" to "center", "flexDirection" to "row")), "loading-text" to padStyleMapOf(utsMapOf("textAlign" to "center", "color" to "#333333")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("loading" to utsMapOf("type" to "Boolean", "default" to false), "isEnded" to utsMapOf("type" to "Boolean", "default" to false)));
        var propsNeedCastKeys = utsArrayOf(
            "loading",
            "isEnded"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
