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
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync;
import io.dcloud.uniapp.extapi.rpx2px as uni_rpx2px;
open class GenComponentsSkeletonSkeleton : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onMounted(fun() {
            val systemInfo = uni_getSystemInfoSync();
            this.screenWidth = systemInfo.screenWidth;
            var ctx = (this.`$refs`["skeleton"] as UniElement).getDrawableContext();
            if (ctx == null) {
                return;
            }
            ctx.reset();
            this.draw(ctx, 0);
            this.draw(ctx, 495);
            ctx.update();
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("ref" to "skeleton", "style" to normalizeStyle(utsMapOf("width" to "750rpx", "height" to "990px"))), null, 4);
    }
    open var screenWidth: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("screenWidth" to 0);
    }
    override fun `$initMethods`() {
        this.draw = fun(ctx: DrawableContext, start: Number) {
            val screenWidth = this.screenWidth;
            val p = uni_rpx2px(30);
            ctx.fillStyle = "#f0f0f0";
            ctx.beginPath();
            ctx.arc(p + 20, start + 35, 20, 0, 2 * Math.PI, false);
            ctx.fill();
            ctx.lineWidth = 15;
            ctx.lineCap = "round";
            ctx.beginPath();
            ctx.moveTo(p + 60, start + 35);
            ctx.lineTo(p + 110, start + 35);
            ctx.stroke();
            ctx.beginPath();
            ctx.moveTo(p + screenWidth - 16 - 50, start + 35);
            ctx.lineTo(p + screenWidth - 16 - 25, start + 35);
            ctx.stroke();
            ctx.beginPath();
            ctx.moveTo(p + 10, start + 80);
            ctx.lineTo(screenWidth - 2 * p + 10, start + 80);
            ctx.stroke();
            ctx.fillRect(0, start + 100, screenWidth, 290);
            ctx.beginPath();
            ctx.moveTo(p + 10, start + 410);
            ctx.lineTo(screenWidth - 2 * p + 10, start + 410);
            ctx.stroke();
            ctx.beginPath();
            ctx.moveTo(p + 10, start + 435);
            ctx.lineTo(screenWidth - 2 * p + 10, start + 435);
            ctx.stroke();
            ctx.beginPath();
            ctx.moveTo(p + 10, start + 460);
            ctx.lineTo(screenWidth - 100, start + 460);
            ctx.stroke();
            ctx.lineWidth = 10;
            ctx.lineCap = "butt";
            ctx.beginPath();
            ctx.moveTo(0, start + 485);
            ctx.lineTo(screenWidth, start + 485);
            ctx.stroke();
        }
        ;
    }
    open lateinit var draw: (ctx: DrawableContext, start: Number) -> Unit;
    companion object {
        var name = "skeleton";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf());
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
