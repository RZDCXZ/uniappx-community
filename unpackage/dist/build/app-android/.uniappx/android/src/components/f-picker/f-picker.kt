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
open class GenComponentsFPickerFPicker : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onCreated(fun() {
            if (this.title != "") {
                this.t = this.title;
            } else {
                when (this.mode) {
                    "selector" -> 
                        this.t = "";
                    "date" -> 
                        this.t = "选择日期";
                }
            }
            this.init();
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_picker_view_column = resolveComponent("picker-view-column");
        val _component_picker_view = resolveComponent("picker-view");
        return createElementVNode(Fragment, null, utsArrayOf(
            if (isTrue(_ctx.show)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "popup-mask", "onClick" to withModifiers(_ctx.close, utsArrayOf(
                    "stop"
                ))), null, 8, utsArrayOf(
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
                    createElementVNode("text", utsMapOf("class" to "popup-title"), toDisplayString(_ctx.t), 1),
                    createElementVNode("text", utsMapOf("class" to "popup-action", "style" to normalizeStyle(utsMapOf("color" to "#949494")), "onClick" to _ctx.confirm), "完成", 12, utsArrayOf(
                        "onClick"
                    ))
                )),
                if (_ctx.mode == "selector") {
                    createVNode(_component_picker_view, utsMapOf("key" to 0, "class" to "popup-picker", "indicator-style" to "height: 50px;background-color:rgba(0,0,0,0.05);", "onChange" to _ctx.change), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_picker_view_column, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.range, fun(item, index, _, _): VNode {
                                        return createElementVNode("view", utsMapOf("class" to "popup-picker-item", "key" to index), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "popup-picker-text"), toDisplayString(item), 1)
                                        ));
                                    }), 128)
                                );
                            }), "_" to 1))
                        );
                    }), "_" to 1), 8, utsArrayOf(
                        "onChange"
                    ));
                } else {
                    if (_ctx.mode == "date") {
                        createVNode(_component_picker_view, utsMapOf("key" to 1, "class" to "popup-picker", "indicator-style" to "height: 50px;background-color:rgba(0,0,0,0.05);", "value" to _ctx.value, "onChange" to _ctx.change), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_picker_view_column, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.years, fun(item, index, _, _): VNode {
                                            return createElementVNode("view", utsMapOf("class" to "popup-picker-item", "key" to index), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "popup-picker-text"), toDisplayString(item) + "年", 1)
                                            ));
                                        }), 128)
                                    );
                                }), "_" to 1)),
                                createVNode(_component_picker_view_column, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.months, fun(item, index, _, _): VNode {
                                            return createElementVNode("view", utsMapOf("class" to "popup-picker-item", "key" to index), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "popup-picker-text"), toDisplayString(item) + "月", 1)
                                            ));
                                        }), 128)
                                    );
                                }), "_" to 1)),
                                createVNode(_component_picker_view_column, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.days, fun(item, index, _, _): VNode {
                                            return createElementVNode("view", utsMapOf("class" to "popup-picker-item", "key" to index), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "popup-picker-text"), toDisplayString(item) + "日", 1)
                                            ));
                                        }), 128)
                                    );
                                }), "_" to 1))
                            );
                        }), "_" to 1), 8, utsArrayOf(
                            "value",
                            "onChange"
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                    ;
                }
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
    open var title: String by `$props`;
    open var mode: String by `$props`;
    open var range: UTSArray<String>? by `$props`;
    open var t: String by `$data`;
    open var value: UTSArray<Number> by `$data`;
    open var show: Boolean by `$data`;
    open var years: UTSArray<Number> by `$data`;
    open var year: Number by `$data`;
    open var months: UTSArray<Number> by `$data`;
    open var month: Number by `$data`;
    open var days: UTSArray<Number> by `$data`;
    open var day: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("t" to "选择", "value" to utsArrayOf<Number>(0), "show" to false, "years" to utsArrayOf<Number>(), "year" to 0 as Number, "months" to utsArrayOf<Number>(), "month" to 0 as Number, "days" to utsArrayOf<Number>(), "day" to 0 as Number);
    }
    override fun `$initMethods`() {
        this.init = fun() {
            if (this.mode == "date") {
                val date = Date();
                val _years: UTSArray<Number> = utsArrayOf();
                val _year = date.getFullYear();
                val _months: UTSArray<Number> = utsArrayOf();
                val _month: Number = date.getMonth() + 1;
                val _days: UTSArray<Number> = utsArrayOf();
                val _day = date.getDate();
                run {
                    var i: Number = 1949;
                    while(i <= _year){
                        _years.push(i);
                        i++;
                    }
                }
                run {
                    var i: Number = 1;
                    while(i <= 12){
                        _months.push(i);
                        i++;
                    }
                }
                run {
                    var i: Number = 1;
                    while(i <= 31){
                        _days.push(i);
                        i++;
                    }
                }
                this.years = _years;
                this.year = _year;
                this.months = _months;
                this.month = _month;
                this.days = _days;
                this.day = _day;
                this.value = utsArrayOf<Number>(_year - 2000, _month - 1, _day - 1);
            }
        }
        ;
        this.open = fun() {
            this.show = true;
        }
        ;
        this.close = fun() {
            this.show = false;
        }
        ;
        this.change = fun(e: UniPickerViewChangeEvent) {
            val kVal = e.detail.value;
            this.value = kVal;
            if (this.mode == "date") {
                this.year = this.years[kVal[0]];
                this.month = this.months[kVal[1]];
                this.day = this.days[kVal[2]];
            }
        }
        ;
        this.confirm = fun() {
            when (this.mode) {
                "selector" -> 
                    this.`$emit`("confirm", this.value[0] as Number);
                "date" -> 
                    {
                        var pickObj = datepickerChangeEvent(year = this.year, month = this.month, day = this.day, label = "" + this.year + "-" + this._getValue(this.month) + "-" + this._getValue(this.day));
                        this.`$emit`("confirm", pickObj.label);
                    }
            }
            this.close();
        }
        ;
        this._getValue = fun(v: Number): String {
            if (v >= 10) {
                return v.toString();
            }
            return "0" + v;
        }
        ;
    }
    open lateinit var init: () -> Unit;
    open lateinit var open: () -> Unit;
    open lateinit var close: () -> Unit;
    open lateinit var change: (e: UniPickerViewChangeEvent) -> Unit;
    open lateinit var confirm: () -> Unit;
    open lateinit var _getValue: (v: Number) -> String;
    companion object {
        var name = "f-picker";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("popup-mask" to padStyleMapOf(utsMapOf("position" to "fixed", "left" to 0, "top" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "rgba(0,0,0,0.3)", "zIndex" to 99)), "popup" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "right" to 0, "left" to 0, "backgroundColor" to "#ffffff", "zIndex" to 100, "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "transform" to "translateY(1000px)", "opacity" to 0, "transitionProperty" to "transform,opacity", "transitionDuration" to "400ms")), "popup-show" to padStyleMapOf(utsMapOf("opacity" to 1, "transform" to "translateY(0)")), "popup-header" to padStyleMapOf(utsMapOf("height" to "112rpx", "flexDirection" to "row", "alignItems" to "center", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#ececec")), "popup-action" to padStyleMapOf(utsMapOf("fontSize" to 16, "width" to "100rpx", "height" to "112rpx", "textAlign" to "center", "lineHeight" to "112rpx")), "popup-title" to padStyleMapOf(utsMapOf("flex" to 1, "textAlign" to "center", "fontWeight" to "bold", "fontSize" to 16)), "popup-picker" to padStyleMapOf(utsMapOf("height" to "400rpx")), "popup-picker-item" to padStyleMapOf(utsMapOf("height" to 50)), "popup-picker-text" to padStyleMapOf(utsMapOf("textAlign" to "center", "lineHeight" to "50px")), "@TRANSITION" to utsMapOf("popup" to utsMapOf("property" to "transform,opacity", "duration" to "400ms")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("confirm" to null);
        var props = normalizePropsOptions(utsMapOf("title" to utsMapOf("type" to "String", "default" to ""), "mode" to utsMapOf("type" to "String", "default" to "selector"), "range" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>();
        }
        )));
        var propsNeedCastKeys = utsArrayOf(
            "title",
            "mode"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
