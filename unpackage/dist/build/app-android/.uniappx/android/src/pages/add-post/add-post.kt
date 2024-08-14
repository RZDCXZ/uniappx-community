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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit;
import io.dcloud.uniapp.extapi.`$off` as uni__off;
import io.dcloud.uniapp.extapi.`$on` as uni__on;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesAddPostAddPost : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(options: OnLoadOptions) {
            if (options.has("topic_id")) {
                this.chooseTopicId = parseInt(options.get("topic_id") as String);
            }
            if (options.has("topic_title")) {
                this.chooseTopicTitle = options.get("topic_title") as String;
            }
            this.loadCategories();
            uni__on("onTopicPickerSuccess", this.onTopicPickerSuccess);
        }
        , instance);
        onUnload(fun() {
            uni__off("onTopicPickerSuccess", this.onTopicPickerSuccess);
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_main_btn = resolveEasyComponent("main-btn", GenComponentsMainBtnMainBtnClass);
        val _component_navbar = resolveEasyComponent("navbar", GenComponentsNavbarNavbarClass);
        val _component_upload_images = resolveEasyComponent("upload-images", GenComponentsUploadImagesUploadImagesClass);
        val _component_cell = resolveEasyComponent("cell", GenComponentsCellCellClass);
        val _component_f_picker = resolveEasyComponent("f-picker", GenComponentsFPickerFPickerClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_navbar, utsMapOf("type" to "text"), utsMapOf("right" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "navbar-right"), utsArrayOf(
                        createVNode(_component_main_btn, utsMapOf("disabled" to _ctx.disabled, "width" to "118rpx", "height" to "60rpx", "font-size" to "14px", "onClick" to _ctx.submit), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                "发送"
                            );
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "disabled",
                            "onClick"
                        ))
                    ))
                );
            }
            ), "_" to 1)),
            createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1", "background-color" to "#f4f4f4"))), utsArrayOf(
                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("background-color" to "#ffffff"))), utsArrayOf(
                    createElementVNode("textarea", utsMapOf("auto-focus" to true, "auto-height" to true, "modelValue" to _ctx.content, "onInput" to fun(`$event`: InputEvent){
                        _ctx.content = `$event`.detail.value;
                    }
                    , "placeholder" to "有标题和画面清晰无水印的作品曝光更多哦~", "class" to "add-textarea"), null, 40, utsArrayOf(
                        "modelValue",
                        "onInput"
                    )),
                    createVNode(_component_upload_images, utsMapOf("ref" to "upload", "style" to normalizeStyle(utsMapOf("margin-bottom" to "60rpx"))), null, 8, utsArrayOf(
                        "style"
                    ))
                ), 4),
                createVNode(_component_f_picker, utsMapOf("range" to _ctx.range, "onConfirm" to _ctx.handleChooseCategory), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_cell, utsMapOf("title" to ("# " + _ctx.chooseCategoryTitle), "rightText" to if (_ctx.chooseCategoryId == 0) {
                            "点击选择";
                        } else {
                            "";
                        }
                        ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                if (_ctx.chooseCategoryId == 0) {
                                    createElementVNode("text", utsMapOf("key" to 0, "class" to "cell-tip"), "必填");
                                } else {
                                    createCommentVNode("v-if", true);
                                }
                            );
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "title",
                            "rightText"
                        ))
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "range",
                    "onConfirm"
                )),
                createVNode(_component_cell, utsMapOf("title" to ("# " + _ctx.chooseTopicTitle), "rightText" to if (_ctx.chooseTopicId == 0) {
                    "点击选择";
                } else {
                    "";
                }
                , "onClick" to _ctx.openTopicPicker), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        if (_ctx.chooseTopicId == 0) {
                            createElementVNode("text", utsMapOf("key" to 0, "class" to "cell-tip"), "让更多人看见");
                        } else {
                            createCommentVNode("v-if", true);
                        }
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "title",
                    "rightText",
                    "onClick"
                ))
            ), 4)
        ), 64);
    }
    open var content: String by `$data`;
    open var chooseCategoryTitle: String by `$data`;
    open var chooseCategoryId: Number by `$data`;
    open var categoryList: UTSArray<articleNav> by `$data`;
    open var range: UTSArray<String> by `$data`;
    open var chooseTopicTitle: String by `$data`;
    open var chooseTopicId: Number by `$data`;
    open var disabled: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("content" to "", "chooseCategoryTitle" to "选择分类", "chooseCategoryId" to 0, "categoryList" to utsArrayOf<articleNav>(articleNav(id = 0, title = "请选择")), "range" to utsArrayOf<String>(), "chooseTopicTitle" to "选择话题", "chooseTopicId" to 0, "disabled" to computed<Boolean>(fun(): Boolean {
            return this.content.length == 0 || this.chooseCategoryId == 0;
        }
        ));
    }
    override fun `$initMethods`() {
        this.onTopicPickerSuccess = fun(e: TopicNav) {
            this.chooseTopicId = e.id;
            this.chooseTopicTitle = e.title;
        }
        ;
        this.openTopicPicker = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/choose-topic/choose-topic"));
        }
        ;
        this.loadCategories = fun() {
            uni_request<Result<UTSArray<articleNav>>>(RequestOptions(url = getURL("/category/article"), success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                var d = r.data as UTSArray<articleNav>;
                this.categoryList.push(*d.toTypedArray());
                this.range = this.categoryList.map(fun(o: articleNav): String {
                    return o.title;
                }
                );
            }
            , fail = fun(err){
                uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
            }
            ));
        }
        ;
        this.submit = fun() {
            val uploadRef = this.`$refs`["upload"] as ComponentPublicInstance;
            if (uploadRef.`$callMethod`("isUploading") as Boolean) {
                uni_showToast(ShowToastOptions(title = "还有图片正在上传中...", icon = "none"));
                return;
            }
            var images = uploadRef.`$callMethod`("getValue") as UTSArray<String>;
            var data: UTSJSONObject = let {
                object : UTSJSONObject() {
                    var images = images
                    var content = it.content
                    var category_id = it.chooseCategoryId
                    var topic_id = it.chooseTopicId
                }
            };
            uni_showLoading(ShowLoadingOptions(title = "发布中...", mask = false));
            uni_request<defaultResult>(RequestOptions(url = getURL("/article/save"), method = "POST", data = data, header = object : UTSJSONObject() {
                var token = getToken()
            }, success = fun(res){
                var r = res.data;
                if (r == null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                uni__emit("onAddArticleSuccess", onAddArticleSuccessEvent(category_id = this.chooseCategoryId, topic_id = this.chooseTopicId));
                uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                setTimeout(fun() {
                    uni_navigateBack(NavigateBackOptions(delta = 1));
                }
                , 300);
            }
            , fail = fun(err){
                uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
            }
            , complete = fun(_){
                uni_hideLoading();
            }
            ));
        }
        ;
        this.handleChooseCategory = fun(i: Number) {
            var item = this.categoryList[i] as articleNav;
            this.chooseCategoryId = item.id;
            this.chooseCategoryTitle = item.title;
        }
        ;
    }
    open lateinit var onTopicPickerSuccess: (e: TopicNav) -> Unit;
    open lateinit var openTopicPicker: () -> Unit;
    open lateinit var loadCategories: () -> Unit;
    open lateinit var submit: () -> Unit;
    open lateinit var handleChooseCategory: (i: Number) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("navbar-right" to padStyleMapOf(utsMapOf("height" to 45, "alignItems" to "center", "justifyContent" to "center", "marginRight" to "34rpx")), "cell-tip" to padStyleMapOf(utsMapOf("color" to "#f0748a", "backgroundColor" to "#fff1f6", "borderRadius" to 4, "marginLeft" to "18rpx", "fontSize" to 13, "paddingTop" to "5rpx", "paddingRight" to "10rpx", "paddingBottom" to "5rpx", "paddingLeft" to "10rpx")), "add-textarea" to padStyleMapOf(utsMapOf("width" to "750rpx", "maxHeight" to "500rpx", "paddingTop" to "60rpx", "paddingRight" to "30rpx", "paddingBottom" to "60rpx", "paddingLeft" to "30rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
