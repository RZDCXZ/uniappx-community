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
open class GenComponentsFCityPickerFCityPicker : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onCreated(fun() {
            this.init();
        }
        , instance);
        onMounted(fun() {}, instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_picker_view_column = resolveComponent("picker-view-column");
        val _component_picker_view = resolveComponent("picker-view");
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
                createElementVNode("view", utsMapOf("class" to "popup-header"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "iconfont popup-action", "style" to normalizeStyle(utsMapOf("font-size" to "22px")), "onClick" to _ctx.close), "×", 12, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("text", utsMapOf("class" to "popup-title"), "选择地址"),
                    createElementVNode("text", utsMapOf("class" to "popup-action", "style" to normalizeStyle(utsMapOf("color" to "#949494")), "onClick" to _ctx.confirm), "完成", 12, utsArrayOf(
                        "onClick"
                    ))
                )),
                createVNode(_component_picker_view, utsMapOf("indicator-style" to "height: 40px;", "class" to "picker-view", "value" to _ctx.pickerValue, "onChange" to _ctx.pickerChange), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_picker_view_column, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.provinceDataList, fun(item, index, _, _): VNode {
                                    return createElementVNode("view", utsMapOf("key" to index), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "picker-item"), toDisplayString(item.label), 1)
                                    ));
                                }
                                ), 128)
                            );
                        }
                        ), "_" to 1)),
                        createVNode(_component_picker_view_column, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.cityDataList, fun(item, index, _, _): VNode {
                                    return createElementVNode("view", utsMapOf("key" to index), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "picker-item"), toDisplayString(item.label), 1)
                                    ));
                                }
                                ), 128)
                            );
                        }
                        ), "_" to 1)),
                        createVNode(_component_picker_view_column, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.areaDataList, fun(item, index, _, _): VNode {
                                    return createElementVNode("view", utsMapOf("key" to index), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "picker-item"), toDisplayString(item.label), 1)
                                    ));
                                }
                                ), 128)
                            );
                        }
                        ), "_" to 1))
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "value",
                    "onChange"
                ))
            ), 2),
            createElementVNode("view", utsMapOf("onClick" to withModifiers(_ctx.open, utsArrayOf(
                "stop"
            ))), utsArrayOf(
                renderSlot(_ctx.`$slots`, "default")
            ), 8, utsArrayOf(
                "onClick"
            ))
        ), 64);
    }
    open var pickerValue: UTSArray<Number> by `$data`;
    open var provinceDataList: UTSArray<cityItem> by `$data`;
    open var cityDataList: UTSArray<cityItem> by `$data`;
    open var areaDataList: UTSArray<cityItem> by `$data`;
    open var citypickerRef: ComponentPublicInstance? by `$data`;
    open var show: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("pickerValue" to utsArrayOf<Number>(0, 0, 0), "provinceDataList" to provinceData as UTSArray<cityItem>, "cityDataList" to cityData[0] as UTSArray<cityItem>, "areaDataList" to areaData[0][0] as UTSArray<cityItem>, "citypickerRef" to null as ComponentPublicInstance?, "show" to false);
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
        this.init = fun() {
            var pickerValueDefault = utsArrayOf<Number>(0, 0, 0);
            this.cityDataList = cityData[pickerValueDefault[0]];
            this.areaDataList = areaData[pickerValueDefault[0]][pickerValueDefault[1]];
            this.pickerValue = pickerValueDefault;
        }
        ;
        this.pickerChange = fun(e: PickerViewChangeEvent) {
            var changePickerValue = e.detail.value;
            if (this.pickerValue[0] !== changePickerValue[0]) {
                this.cityDataList = cityData[changePickerValue[0]];
                this.areaDataList = areaData[changePickerValue[0]][0];
                changePickerValue[1] = 0;
                changePickerValue[2] = 0;
            } else if (this.pickerValue[1] !== changePickerValue[1]) {
                this.areaDataList = areaData[changePickerValue[0]][changePickerValue[1]];
                changePickerValue[2] = 0;
            }
            this.pickerValue = changePickerValue;
        }
        ;
        this.confirm = fun() {
            var pickObj = citypickerChangeEvent(label = this._getLabel(), value = this.pickerValue, cityCode = this._getCityCode());
            this.`$emit`("confirm", pickObj);
            this.close();
        }
        ;
        this._getLabel = fun(): String {
            var pcikerLabel = this.provinceDataList[this.pickerValue[0]].label + "-" + this.cityDataList[this.pickerValue[1]].label + "-" + this.areaDataList[this.pickerValue[2]].label;
            return pcikerLabel;
        }
        ;
        this._getCityCode = fun(): String {
            return this.areaDataList[this.pickerValue[2]].value;
        }
        ;
    }
    open lateinit var open: () -> Unit;
    open lateinit var close: () -> Unit;
    open lateinit var init: () -> Unit;
    open lateinit var pickerChange: (e: PickerViewChangeEvent) -> Unit;
    open lateinit var confirm: () -> Unit;
    open lateinit var _getLabel: () -> String;
    open lateinit var _getCityCode: () -> String;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("popup-mask" to padStyleMapOf(utsMapOf("position" to "fixed", "left" to 0, "top" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "rgba(0,0,0,0.3)", "zIndex" to 99)), "popup" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "right" to 0, "left" to 0, "backgroundColor" to "#ffffff", "zIndex" to 100, "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "transform" to "translateY(1000px)", "opacity" to 0, "transitionProperty" to "transform,opacity", "transitionDuration" to "400ms")), "popup-show" to padStyleMapOf(utsMapOf("opacity" to 1, "transform" to "translateY(0)")), "popup-header" to padStyleMapOf(utsMapOf("height" to "112rpx", "flexDirection" to "row", "alignItems" to "center", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#ececec")), "popup-action" to padStyleMapOf(utsMapOf("fontSize" to 16, "width" to "100rpx", "height" to "112rpx", "textAlign" to "center", "lineHeight" to "112rpx")), "popup-title" to padStyleMapOf(utsMapOf("flex" to 1, "textAlign" to "center", "fontWeight" to "bold", "fontSize" to 16)), "picker-view" to padStyleMapOf(utsMapOf("width" to "750rpx", "height" to "500rpx")), "picker-item" to padStyleMapOf(utsMapOf("textAlign" to "center", "lineHeight" to "40px", "textOverflow" to "ellipsis", "fontSize" to 16)), "@TRANSITION" to utsMapOf("popup" to utsMapOf("property" to "transform,opacity", "duration" to "400ms")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("confirm" to null);
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
