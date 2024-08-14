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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack;
open class GenComponentsNavbarNavbar : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_status_bar = resolveEasyComponent("status-bar", GenComponentsStatusBarStatusBarClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_status_bar),
            createElementVNode("view", utsMapOf("class" to "navbar"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "navbar-icon", "onClick" to _ctx.back), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "iconfont"), toDisplayString(_ctx.leftIcon), 1)
                ), 8, utsArrayOf(
                    "onClick"
                )),
                if (_ctx.type == "search") {
                    createElementVNode(Fragment, utsMapOf("key" to 0), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "flex-1"), utsArrayOf(
                            if (isTrue(!_ctx.disabled)) {
                                createElementVNode("input", utsMapOf("key" to 0, "class" to "search-input", "type" to "text", "placeholder" to "请输入搜索词", "modelValue" to _ctx.keyword, "onInput" to fun(`$event`: InputEvent){
                                    _ctx.keyword = `$event`.detail.value;
                                }, "confirm-type" to "search", "onConfirm" to _ctx.handleSearch), null, 40, utsArrayOf(
                                    "modelValue",
                                    "onInput",
                                    "onConfirm"
                                ));
                            } else {
                                createElementVNode("input", utsMapOf("key" to 1, "disabled" to true, "class" to "search-input", "type" to "text", "placeholder" to "请输入搜索词", "modelValue" to _ctx.keyword, "onInput" to fun(`$event`: InputEvent){
                                    _ctx.keyword = `$event`.detail.value;
                                }, "onClick" to _ctx.back), null, 40, utsArrayOf(
                                    "modelValue",
                                    "onInput",
                                    "onClick"
                                ));
                            }
                        )),
                        createElementVNode("view", utsMapOf("class" to "navbar-icon", "onClick" to _ctx.handleSearch), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "search-btn"), "搜索")
                        ), 8, utsArrayOf(
                            "onClick"
                        ))
                    ), 64);
                } else {
                    if (_ctx.type == "text") {
                        createElementVNode(Fragment, utsMapOf("key" to 1), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "flex-1 flex-center"), utsArrayOf(
                                createElementVNode("text", null, toDisplayString(_ctx.title), 1)
                            )),
                            renderSlot(_ctx.`$slots`, "right", UTSJSONObject(), fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    if (isTrue(_ctx.showRightIcon)) {
                                        createElementVNode("view", utsMapOf("key" to 0, "class" to "navbar-icon", "onClick" to fun(){
                                            _ctx.`$emit`("clickRight");
                                        }), utsArrayOf(
                                            if (_ctx.rightIcon != "") {
                                                createElementVNode("text", utsMapOf("key" to 0, "class" to "iconfont"), toDisplayString(_ctx.icons[_ctx.rightIcon]), 1);
                                            } else {
                                                createCommentVNode("v-if", true);
                                            },
                                            if (_ctx.rightText != "") {
                                                createElementVNode("text", utsMapOf("key" to 1, "class" to "search-btn"), toDisplayString(_ctx.rightText), 1);
                                            } else {
                                                createCommentVNode("v-if", true);
                                            }
                                        ), 8, utsArrayOf(
                                            "onClick"
                                        ));
                                    } else {
                                        createCommentVNode("v-if", true);
                                    }
                                );
                            })
                        ), 64);
                    } else {
                        createCommentVNode("v-if", true);
                    }
                    ;
                }
            ))
        ), 64);
    }
    open var type: String by `$props`;
    open var disabled: Boolean by `$props`;
    open var title: String by `$props`;
    open var rightIcon: String by `$props`;
    open var showRightIcon: Boolean by `$props`;
    open var rightText: String by `$props`;
    open var keyword: String by `$data`;
    open var icons: LeftIcons by `$data`;
    open var leftIcon: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("keyword" to "", "icons" to LeftIcons(more = "\ue6fd", back = "\ue60d", close = "\ue6aa"), "leftIcon" to computed<String>(fun(): String {
            if (this.type == "search" || this.type == "text") {
                return this.icons.back;
            }
            return this.icons.close;
        }
        ));
    }
    override fun `$initMethods`() {
        this.setKeyword = fun(keyword: String) {
            this.keyword = keyword;
        }
        ;
        this.back = fun() {
            uni_navigateBack(NavigateBackOptions(delta = 1));
        }
        ;
        this.handleSearch = fun() {
            if (this.disabled) {
                this.back();
                return;
            }
            if (this.keyword.trim() == "") {
                return;
            }
            this.`$emit`("search", this.keyword);
        }
        ;
    }
    open lateinit var setKeyword: (keyword: String) -> Unit;
    open lateinit var back: () -> Unit;
    open lateinit var handleSearch: () -> Unit;
    companion object {
        var name = "navbar";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("navbar" to padStyleMapOf(utsMapOf("height" to 45, "flexDirection" to "row")), "navbar-icon" to padStyleMapOf(utsMapOf("width" to 45, "height" to 45, "justifyContent" to "center", "alignItems" to "center")), "search-input" to padStyleMapOf(utsMapOf("height" to "80rpx", "backgroundColor" to "#f4f4f4", "borderRadius" to "6rpx", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx")), "search-btn" to padStyleMapOf(utsMapOf("fontSize" to 14)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("search" to null, "clickRight" to null);
        var props = normalizePropsOptions(utsMapOf("type" to utsMapOf("type" to "String", "default" to ""), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "title" to utsMapOf("type" to "String", "default" to ""), "rightIcon" to utsMapOf("type" to "String", "default" to ""), "showRightIcon" to utsMapOf("type" to "Boolean", "default" to true), "rightText" to utsMapOf("type" to "String", "default" to "")));
        var propsNeedCastKeys = utsArrayOf(
            "type",
            "disabled",
            "title",
            "rightIcon",
            "showRightIcon",
            "rightText"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
