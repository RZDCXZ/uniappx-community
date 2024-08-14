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
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage;
open class GenComponentsFeedbackItemFeedbackItem : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("text", utsMapOf("class" to "feedback-time"), toDisplayString(_ctx.item.create_time), 1),
            createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                "feedback",
                utsMapOf("feedback-self" to (_ctx.item.type == "user"))
            ))), utsArrayOf(
                createVNode(_component_avatar, utsMapOf("src" to _ctx.item.avatar, "width" to "84rpx", "height" to "84rpx", "style" to normalizeStyle(utsMapOf("margin" to "0 20rpx"))), null, 8, utsArrayOf(
                    "src",
                    "style"
                )),
                createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                    "feedback-body",
                    utsMapOf("feedback-body-self" to (_ctx.item.type == "user"))
                ))), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "feedback-text"), toDisplayString(_ctx.item.content), 1),
                    if (_ctx.item.images.length > 0) {
                        createElementVNode("view", utsMapOf("key" to 0, "class" to "feedback-img"), utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.item.images, fun(img, index, _, _): VNode {
                                return createElementVNode("image", utsMapOf("key" to index, "src" to img, "mode" to "aspectFill", "class" to "feedback-img-item", "onClick" to fun(){
                                    _ctx.previewImage(img);
                                }), null, 8, utsArrayOf(
                                    "src",
                                    "onClick"
                                ));
                            }), 128)
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                ), 2)
            ), 2)
        ), 64);
    }
    open var item: FeedbackItem by `$props`;
    override fun `$initMethods`() {
        this.previewImage = fun(img: String) {
            uni_previewImage(PreviewImageOptions(current = img, urls = this.item.images));
        }
        ;
    }
    open lateinit var previewImage: (img: String) -> Unit;
    companion object {
        var name = "feedback-item";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("feedback-time" to padStyleMapOf(utsMapOf("textAlign" to "center", "color" to "#898989", "fontSize" to 14, "marginTop" to "20rpx")), "feedback" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "flex-start", "paddingTop" to "25rpx", "paddingRight" to "10rpx", "paddingBottom" to "25rpx", "paddingLeft" to "10rpx")), "feedback-self" to padStyleMapOf(utsMapOf("flexDirection" to "row-reverse")), "feedback-body" to padStyleMapOf(utsMapOf("backgroundColor" to "#f4f4f4", "borderRadius" to 8, "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx", "maxWidth" to "475rpx")), "feedback-body-self" to padStyleMapOf(utsMapOf("backgroundColor" to "rgba(240,100,135,0.1)")), "feedback-text" to padStyleMapOf(utsMapOf("lineHeight" to 1.6, "fontSize" to 16)), "feedback-img" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "feedback-img-item" to padStyleMapOf(utsMapOf("width" to "130rpx", "height" to "130rpx", "paddingTop" to "5rpx", "paddingRight" to "5rpx", "paddingBottom" to "5rpx", "paddingLeft" to "5rpx", "borderRadius" to "6rpx", "backgroundColor" to "#f4f4f4")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("item" to utsMapOf("type" to "Object", "required" to true)));
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
