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
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage;
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
import io.dcloud.uniapp.extapi.uploadFile as uni_uploadFile;
open class GenComponentsUploadImagesUploadImages : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "upload-images"), utsArrayOf(
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.imageList, fun(img, index, _, _): VNode {
                return createElementVNode("view", utsMapOf("class" to "upload-item", "key" to img.id), utsArrayOf(
                    createElementVNode("image", utsMapOf("src" to img.src, "mode" to "aspectFill", "class" to "upload-img", "onClick" to fun(){
                        _ctx.previewImage(img.src);
                    }
                    ), null, 8, utsArrayOf(
                        "src",
                        "onClick"
                    )),
                    createElementVNode("text", utsMapOf("class" to "iconfont upload-close", "onClick" to fun(){
                        _ctx.remove(index);
                    }
                    ), "x", 8, utsArrayOf(
                        "onClick"
                    )),
                    if (isTrue(img.err != "" || img.progress < 100)) {
                        createElementVNode("view", utsMapOf("key" to 0, "class" to "upload-progress"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "upload-progress-data"), toDisplayString(if (img.err != "") {
                                img.err;
                            } else {
                                (img.progress + "%");
                            }), 1)
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                ));
            }
            ), 128),
            if (_ctx.count > 0) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "upload-btn upload-item", "onClick" to _ctx.chooseImageUpload), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "iconfont upload-btn-icon"), "+")
                ), 8, utsArrayOf(
                    "onClick"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ));
    }
    open var imageList: UTSArray<ImageItem> by `$data`;
    open var count: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("imageList" to utsArrayOf<ImageItem>(), "count" to computed<Number>(fun(): Number {
            return 9 - this.imageList.length;
        }
        ));
    }
    override fun `$initMethods`() {
        this.isUploading = fun(): Boolean {
            var result = false;
            this.imageList.forEach(fun(o: ImageItem){
                if (o.progress < 100 && o.err == "") {
                    result = true;
                }
            }
            );
            return result;
        }
        ;
        this.getValue = fun(): UTSArray<String> {
            var arr = utsArrayOf<String>();
            this.imageList.forEach(fun(o: ImageItem){
                if (o.progress == 100) {
                    arr.push(o.src);
                }
            }
            );
            return arr;
        }
        ;
        this.remove = fun(index: Number) {
            uni_showModal(ShowModalOptions(title = "提示", content = "是否要删除该图片？", confirmText = "删除", success = fun(res){
                if (!res.confirm) {
                    return;
                }
                var item = this.imageList[index];
                if (item.progress < 100 && item.task != null && item.err == "") {
                    item.task?.abort();
                }
                this.imageList.splice(index, 1);
            }
            ));
        }
        ;
        this.previewImage = fun(current: String) {
            uni_previewImage(PreviewImageOptions(current = current, urls = this.imageList.map(fun(o: ImageItem): String {
                return o.src;
            }
            )));
        }
        ;
        this.chooseImageUpload = fun() {
            uni_chooseImage(ChooseImageOptions(count = this.count, sizeType = utsArrayOf(
                "compressed"
            ), sourceType = utsArrayOf(
                "album"
            ), success = fun(res: ChooseImageSuccess){
                var length = res.tempFilePaths.length;
                run {
                    var i: Number = 0;
                    while(i < length){
                        var src = res.tempFilePaths[i];
                        this.upload(src);
                        i++;
                    }
                }
            }
            ));
        }
        ;
        this.upload = fun(src: String) {
            var item = ImageItem(id = generateUniqueId(), src = src, progress = 0, err = "", task = null);
            var i = this.imageList.length;
            this.imageList.push(item);
            item.task = uni_uploadFile(UploadFileOptions(url = getURL("/upload"), filePath = src, name = "image", header = object : UTSJSONObject() {
                var token = getToken()
            }, success = fun(res){
                var d = JSON.parse<defaultResult>(res.data);
                if (d == null) {
                    return;
                }
                if (d.code == 0) {
                    this.imageList[i].err = "上传失败";
                    uni_showToast(ShowToastOptions(title = d.msg, icon = "none"));
                    return;
                }
                this.imageList[i].src = d.data as String;
            }
            , fail = fun(_){
                this.imageList[i].err = "上传失败";
            }
            ));
            item.task?.onProgressUpdate(fun(res: OnProgressUpdateResult){
                this.imageList[i].progress = res.progress;
            }
            );
        }
        ;
    }
    open lateinit var isUploading: () -> Boolean;
    open lateinit var getValue: () -> UTSArray<String>;
    open lateinit var remove: (index: Number) -> Unit;
    open lateinit var previewImage: (current: String) -> Unit;
    open lateinit var chooseImageUpload: () -> Unit;
    open lateinit var upload: (src: String) -> Unit;
    companion object {
        var name = "upload-images";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("upload-images" to padStyleMapOf(utsMapOf("flexDirection" to "row", "flexWrap" to "wrap", "paddingTop" to 0, "paddingRight" to "14rpx", "paddingBottom" to 0, "paddingLeft" to "14rpx")), "upload-item" to padStyleMapOf(utsMapOf("width" to "220rpx", "height" to "220rpx", "borderRadius" to 5, "marginTop" to "10rpx", "marginRight" to "10rpx", "marginBottom" to "10rpx", "marginLeft" to "10rpx", "overflow" to "hidden", "position" to "relative")), "upload-img" to padStyleMapOf(utsMapOf("width" to "220rpx", "height" to "220rpx")), "upload-close" to padStyleMapOf(utsMapOf("position" to "absolute", "right" to 0, "top" to 0, "zIndex" to 100, "width" to "50rpx", "height" to "50rpx", "textAlign" to "center", "lineHeight" to "50rpx", "color" to "#ffffff", "backgroundColor" to "rgba(0,0,0,0.1)", "borderRadius" to 5)), "upload-btn" to padStyleMapOf(utsMapOf("borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "#e2e2e2", "alignItems" to "center", "justifyContent" to "center")), "upload-btn-icon" to padStyleMapOf(utsMapOf("fontSize" to 60, "color" to "#e2e2e2")), "upload-progress" to padStyleMapOf(utsMapOf("width" to "220rpx", "height" to "220rpx", "position" to "absolute", "top" to 0, "right" to 0, "backgroundColor" to "rgba(0,0,0,0.3)", "zIndex" to 99, "alignItems" to "center", "justifyContent" to "center", "flexDirection" to "row")), "upload-progress-data" to padStyleMapOf(utsMapOf("fontSize" to 14, "color" to "#ffffff")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
