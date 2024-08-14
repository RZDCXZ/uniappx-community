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
open class GenComponentsAddPostBtnAddPostBtn : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "add-btn", "hover-class" to "add-btn-hover", "onClick" to _ctx.openAddPost), utsArrayOf(
            createElementVNode("text", utsMapOf("class" to "iconfont add-btn-text"), toDisplayString("\ue684"))
        ), 8, utsArrayOf(
            "onClick"
        ));
    }
    open var topic_id: Number by `$props`;
    open var topic_title: String by `$props`;
    override fun `$initMethods`() {
        this.openAddPost = fun() {
            var url = "/pages/add-post/add-post";
            if (this.topic_id != 0 && this.topic_title != "") {
                url += "?topic_id=" + this.topic_id + "&topic_title=" + this.topic_title;
            }
            AuthNavigateTo(url);
        }
        ;
    }
    open lateinit var openAddPost: () -> Unit;
    companion object {
        var name = "add-post-btn";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("add-btn" to padStyleMapOf(utsMapOf("width" to "100rpx", "height" to "100rpx", "alignItems" to "center", "justifyContent" to "center", "position" to "fixed", "bottom" to "34rpx", "right" to "34rpx", "zIndex" to 1000, "borderRadius" to 50, "backgroundImage" to "linear-gradient(to bottom right,#fc6672,#e47989)")), "add-btn-hover" to padStyleMapOf(utsMapOf("backgroundImage" to "linear-gradient(to bottom right,#fd6373,#fd6373)")), "add-btn-text" to padStyleMapOf(utsMapOf("color" to "#ffffff", "fontSize" to 25)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("topic_id" to utsMapOf("type" to "Number", "default" to 0), "topic_title" to utsMapOf("type" to "String", "default" to "")));
        var propsNeedCastKeys = utsArrayOf(
            "topic_id",
            "topic_title"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
