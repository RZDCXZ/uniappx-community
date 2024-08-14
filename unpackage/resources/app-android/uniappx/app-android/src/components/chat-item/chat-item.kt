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
open class GenComponentsChatItemChatItem : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        return createElementVNode("view", utsMapOf("class" to "chatlist"), utsArrayOf(
            createElementVNode("text", utsMapOf("class" to "chat-time"), toDisplayString(_ctx.item.client_create_time), 1),
            createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                "chat",
                utsMapOf("chat-self" to _ctx.isself)
            ))), utsArrayOf(
                createVNode(_component_avatar, utsMapOf("src" to _ctx.item.avatar, "width" to "84rpx", "height" to "84rpx", "style" to normalizeStyle(utsMapOf("margin" to "0 20rpx"))), null, 8, utsArrayOf(
                    "src",
                    "style"
                )),
                createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                    "chat-body",
                    utsMapOf("chat-body-self" to _ctx.isself)
                ))), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "chat-text"), toDisplayString(_ctx.item.body), 1)
                ), 2)
            ), 2)
        ));
    }
    open var item: ChatItem by `$props`;
    open var isself: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("isself" to computed<Boolean>(fun(): Boolean {
            return userState.id == this.item.user_id;
        }
        ));
    }
    companion object {
        var name = "chat-item";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("chatlist" to padStyleMapOf(utsMapOf("transform" to "rotate(180deg)")), "chat-time" to padStyleMapOf(utsMapOf("textAlign" to "center", "color" to "#898989", "fontSize" to 14, "marginTop" to "20rpx")), "chat" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "flex-start", "paddingTop" to "25rpx", "paddingRight" to "10rpx", "paddingBottom" to "25rpx", "paddingLeft" to "10rpx")), "chat-self" to padStyleMapOf(utsMapOf("flexDirection" to "row-reverse")), "chat-body" to padStyleMapOf(utsMapOf("backgroundColor" to "#f4f4f4", "borderRadius" to 8, "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx", "maxWidth" to "475rpx")), "chat-body-self" to padStyleMapOf(utsMapOf("backgroundColor" to "rgba(240,100,135,0.1)")), "chat-text" to padStyleMapOf(utsMapOf("lineHeight" to 1.6, "fontSize" to 16)), "chat-img" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "chat-img-item" to padStyleMapOf(utsMapOf("width" to "130rpx", "height" to "130rpx", "paddingTop" to "5rpx", "paddingRight" to "5rpx", "paddingBottom" to "5rpx", "paddingLeft" to "5rpx", "borderRadius" to "6rpx", "backgroundColor" to "#f4f4f4")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("item" to utsMapOf("type" to "Object", "required" to true)));
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
