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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
open class GenComponentsUserListItemUserListItem : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onCreated(fun() {
            this.isfollow = this.item.isfollow;
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        val _component_follow_button = resolveEasyComponent("follow-button", GenComponentsFollowButtonFollowButtonClass);
        return createElementVNode("view", utsMapOf("class" to "list-item-header"), utsArrayOf(
            createVNode(_component_avatar, utsMapOf("src" to _ctx.item.avatar, "width" to "120rpx", "height" to "120rpx", "style" to normalizeStyle(utsMapOf("margin-right" to "27rpx")), "onClick" to _ctx.openUserSpace), null, 8, utsArrayOf(
                "src",
                "style",
                "onClick"
            )),
            createElementVNode("view", utsMapOf("onClick" to _ctx.openUserSpace), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "nickname"), toDisplayString(_ctx.item.name), 1),
                createElementVNode("text", utsMapOf("class" to "desc"), toDisplayString(_ctx.item.desc), 1),
                createElementVNode("text", utsMapOf("class" to "time"), toDisplayString(_ctx.item.create_time), 1)
            ), 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_follow_button, utsMapOf("type" to "plain", "modelValue" to _ctx.isfollow, "onUpdate:modelValue" to fun(`$event`: Boolean){
                _ctx.isfollow = `$event`;
            }
            , "user_id" to _ctx.item.id), null, 8, utsArrayOf(
                "modelValue",
                "onUpdate:modelValue",
                "user_id"
            ))
        ));
    }
    open var item: UserItem by `$props`;
    open var isfollow: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("isfollow" to false);
    }
    override fun `$initMethods`() {
        this.openUserSpace = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/user-space/user-space?user_id=" + this.item.id));
        }
        ;
    }
    open lateinit var openUserSpace: () -> Unit;
    companion object {
        var name = "user-list-item";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("list-item-header" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "26rpx", "paddingLeft" to "33rpx", "paddingRight" to "33rpx")), "time" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#a7a7a7", "marginTop" to "10rpx")), "nickname" to padStyleMapOf(utsMapOf("color" to "#050505", "textOverflow" to "ellipsis", "maxWidth" to "240rpx", "height" to "34rpx", "fontSize" to 15, "fontWeight" to "bold")), "desc" to padStyleMapOf(utsMapOf("fontSize" to 14, "color" to "#202020", "marginTop" to "10rpx", "lines" to 1, "maxWidth" to "410rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("item" to utsMapOf("type" to "Object", "required" to true)));
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
