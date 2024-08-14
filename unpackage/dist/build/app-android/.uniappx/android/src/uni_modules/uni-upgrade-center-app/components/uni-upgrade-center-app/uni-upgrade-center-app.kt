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
import uts.sdk.modules.utsProgressNotification.CreateNotificationProgressOptions;
import uts.sdk.modules.utsProgressNotification.FinishNotificationProgressOptions;
import uts.sdk.modules.utsProgressNotification.createNotificationProgress;
import uts.sdk.modules.utsProgressNotification.cancelNotificationProgress;
import uts.sdk.modules.utsProgressNotification.finishNotificationProgress;
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile;
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onBeforeUnmount(fun() {
            if (this.needNotificationProgress) {
                cancelNotificationProgress();
            }
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_progress = resolveComponent("progress");
        return if (isTrue(_ctx.shown)) {
            createElementVNode("view", utsMapOf("key" to 0, "class" to "mask flex-center"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "content"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "content-top"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "content-top-text"), toDisplayString(_ctx.title), 1),
                        createElementVNode("image", utsMapOf("class" to "content-top-image", "mode" to "widthFix", "src" to "/uni_modules/uni-upgrade-center-app/static/bg_top.png"))
                    )),
                    createElementVNode("view", utsMapOf("class" to "content-body"), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "content-body-title"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "text title"), toDisplayString(_ctx.subTitle), 1),
                            createElementVNode("text", utsMapOf("class" to "text version"), "v" + toDisplayString(_ctx.version), 1)
                        )),
                        createElementVNode("view", utsMapOf("class" to "body"), utsArrayOf(
                            createElementVNode("scroll-view", utsMapOf("class" to "box-des-scroll", "scroll-y" to "true"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "text box-des"), toDisplayString(_ctx.contents), 1)
                            ))
                        )),
                        createElementVNode("view", utsMapOf("class" to "footer flex-center"), utsArrayOf(
                            if (isTrue(_ctx.isiOS)) {
                                createElementVNode(Fragment, utsMapOf("key" to 0), utsArrayOf(
                                    " uni-app x 暂不支持 iOS "
                                ), 64);
                            } else {
                                createElementVNode(Fragment, utsMapOf("key" to 1), utsArrayOf(
                                    if (isTrue(!_ctx.downloadSuccess)) {
                                        createElementVNode(Fragment, utsMapOf("key" to 0), utsArrayOf(
                                            if (isTrue(_ctx.downloading)) {
                                                createElementVNode("view", utsMapOf("key" to 0, "class" to "progress-box flex-column"), utsArrayOf(
                                                    createVNode(_component_progress, utsMapOf("class" to "progress", "percent" to _ctx.downLoadPercent, "activeColor" to "#3DA7FF", "show-info" to true, "stroke-width" to 10), null, 8, utsArrayOf(
                                                        "percent"
                                                    )),
                                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "100%", "justify-content" to "space-around", "flex-direction" to "row"))), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to "text", "style" to normalizeStyle(utsMapOf("font-size" to "14px"))), toDisplayString(_ctx.downLoadingText), 5),
                                                        createElementVNode("text", utsMapOf("class" to "text", "style" to normalizeStyle(utsMapOf("font-size" to "14px"))), "(" + toDisplayString(_ctx.downloadedSize) + "/" + toDisplayString(_ctx.packageFileSize) + "M)", 5)
                                                    ), 4)
                                                ));
                                            } else {
                                                createElementVNode("button", utsMapOf("key" to 1, "class" to "content-button", "onClick" to _ctx.updateApp), toDisplayString(_ctx.downLoadBtnText), 9, utsArrayOf(
                                                    "onClick"
                                                ));
                                            }
                                        ), 64);
                                    } else {
                                        if (isTrue(_ctx.downloadSuccess && !_ctx.installed)) {
                                            createElementVNode("button", utsMapOf("key" to 1, "class" to "content-button", "loading" to _ctx.installing, "disabled" to _ctx.installing, "onClick" to _ctx.installPackage), toDisplayString(if (_ctx.installing) {
                                                "正在安装……";
                                            } else {
                                                "下载完成，立即安装";
                                            }), 9, utsArrayOf(
                                                "loading",
                                                "disabled",
                                                "onClick"
                                            ));
                                        } else {
                                            if (isTrue(_ctx.installed)) {
                                                createElementVNode("button", utsMapOf("key" to 2, "class" to "content-button", "onClick" to _ctx.installPackage), " 安装未完成，点击安装 ", 8, utsArrayOf(
                                                    "onClick"
                                                ));
                                            } else {
                                                createCommentVNode("v-if", true);
                                            };
                                        };
                                    }
                                ), 64);
                            }
                        ))
                    )),
                    createElementVNode("view", utsMapOf("class" to "content-bottom"), utsArrayOf(
                        if (isTrue(!_ctx.is_mandatory)) {
                            createElementVNode("image", utsMapOf("key" to 0, "class" to "close-img", "mode" to "widthFix", "src" to "/uni_modules/uni-upgrade-center-app/static/app_update_close.png", "onClick" to _ctx.closeUpdate), null, 8, utsArrayOf(
                                "onClick"
                            ));
                        } else {
                            createCommentVNode("v-if", true);
                        }
                    ))
                ))
            ));
        } else {
            createCommentVNode("v-if", true);
        }
        ;
    }
    open var shown: Boolean by `$data`;
    open var installForBeforeFilePath: String by `$data`;
    open var installed: Boolean by `$data`;
    open var installing: Boolean by `$data`;
    open var downloadSuccess: Boolean by `$data`;
    open var downloading: Boolean by `$data`;
    open var downLoadPercent: Number by `$data`;
    open var downloadedSize: Number by `$data`;
    open var packageFileSize: Number by `$data`;
    open var tempFilePath: String by `$data`;
    open var title: String by `$data`;
    open var contents: String by `$data`;
    open var version: String by `$data`;
    open var is_mandatory: Boolean by `$data`;
    open var url: String by `$data`;
    open var platform: UTSArray<String> by `$data`;
    open var store_list: UTSArray<StoreListItem>? by `$data`;
    open var subTitle: String by `$data`;
    open var downLoadBtnTextiOS: String by `$data`;
    open var downLoadBtnText: String by `$data`;
    open var downLoadingText: String by `$data`;
    open var isiOS: Boolean by `$data`;
    open var isAndroid: Boolean by `$data`;
    open var needNotificationProgress: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("shown" to false, "installForBeforeFilePath" to "", "installed" to false, "installing" to false, "downloadSuccess" to false, "downloading" to false, "downLoadPercent" to 0, "downloadedSize" to 0, "packageFileSize" to 0, "tempFilePath" to "", "title" to "更新日志", "contents" to "", "version" to "", "is_mandatory" to false, "url" to "", "platform" to utsArrayOf<String>(), "store_list" to null as UTSArray<StoreListItem>?, "subTitle" to "发现新版本", "downLoadBtnTextiOS" to "立即跳转更新", "downLoadBtnText" to "立即下载更新", "downLoadingText" to "安装包下载中，请稍后", "isiOS" to computed<Boolean>(fun(): Boolean {
            return this.platform.includes(platform_iOS);
        }
        ), "isAndroid" to computed<Boolean>(fun(): Boolean {
            return this.platform.includes(platform_Android);
        }
        ), "needNotificationProgress" to computed<Boolean>(fun(): Boolean {
            return this.isAndroid && !this.is_mandatory;
        }
        ));
    }
    override fun `$initMethods`() {
        this.show = fun(shown: Boolean, localPackageInfo: UniUpgradeCenterResult?) {
            if (localPackageInfo === null) {
                return;
            }
            for(key in localPackageInfo){
                if (requiredKey.indexOf(key) != -1 && localPackageInfo[key] === null) {
                    console.error("\u53C2\u6570 " + key + " \u5FC5\u586B\uFF0C\u8BF7\u68C0\u67E5\u540E\u91CD\u8BD5", " at uni_modules/uni-upgrade-center-app/components/uni-upgrade-center-app/uni-upgrade-center-app.uvue:73");
                    uni_navigateBack(null);
                    return;
                }
            }
            this.title = localPackageInfo.title;
            this.url = localPackageInfo.url;
            this.contents = localPackageInfo.contents;
            this.is_mandatory = localPackageInfo.is_mandatory;
            this.platform = localPackageInfo.platform;
            this.version = localPackageInfo.version;
            this.store_list = localPackageInfo.store_list;
            this.shown = shown;
            this.`$emit`("show");
        }
        ;
        this.askAbortDownload = fun() {
            uni_showModal(ShowModalOptions(title = "是否取消下载？", cancelText = "否", confirmText = "是", success = fun(res){
                if (res.confirm) {
                    if (downloadTask !== null) {
                        downloadTask!!.abort();
                    }
                    this.closePopup();
                }
            }
            ));
        }
        ;
        this.closeUpdate = fun() {
            if (this.downloading) {
                if (this.is_mandatory) {
                    return uni_showToast(ShowToastOptions(title = "下载中，请稍后……", icon = "none", duration = 500));
                }
                if (!this.needNotificationProgress) {
                    this.askAbortDownload();
                    return;
                }
            }
            this.closePopup();
        }
        ;
        this.closePopup = fun() {
            this.shown = false;
            this.downloadSuccess = false;
            this.downloading = false;
            this.downLoadPercent = 0;
            this.downloadedSize = 0;
            this.packageFileSize = 0;
            this.tempFilePath = "";
            this.installing = false;
            this.installed = false;
            if (this.needNotificationProgress) {
                cancelNotificationProgress();
            }
            this.`$emit`("close");
        }
        ;
        this.updateApp = fun() {
            val checkStoreScheme = this.checkStoreScheme();
            if (checkStoreScheme !== null) {
                checkStoreScheme.then(fun(_){}).`catch`(fun(){
                    this.downloadPackage();
                }).`finally`(fun(){
                    openSchemePromise = null;
                });
            } else {
                this.downloadPackage();
            }
        }
        ;
        this.checkStoreScheme = fun(): UTSPromise<Boolean>? {
            if (this.store_list !== null) {
                val storeList: UTSArray<StoreListItem> = this.store_list!!.filter(fun(item: StoreListItem): Boolean {
                    return item.enable;
                }
                );
                if (storeList.length > 0) {
                    if (openSchemePromise === null) {
                        openSchemePromise = UTSPromise.reject() as UTSPromise<Boolean>;
                    }
                    storeList.sort(fun(cur: StoreListItem, next: StoreListItem): Number {
                        return next.priority - cur.priority;
                    }
                    ).map(fun(item: StoreListItem): String {
                        return item.scheme;
                    }
                    ).reduce(fun(promise: UTSPromise<Boolean>, cur: String): UTSPromise<Boolean> {
                        openSchemePromise = promise.`catch`(fun(): UTSPromise<Boolean> {
                            return openSchema(cur);
                        }
                        );
                        return openSchemePromise!!;
                    }
                    , openSchemePromise!!);
                    return openSchemePromise!!;
                }
            }
            return null;
        }
        ;
        this.downloadPackage = fun() {
            downloadTask = uni_downloadFile(DownloadFileOptions(url = this.url, success = fun(res){
                if (res.statusCode == 200) {
                    this.tempFilePath = res.tempFilePath;
                    this.downLoadComplete();
                }
            }
            , fail = fun(err){
                console.log("downloadFile err: ", err, " at uni_modules/uni-upgrade-center-app/components/uni-upgrade-center-app/uni-upgrade-center-app.uvue:177");
            }
            ));
            if (downloadTask !== null) {
                this.downloading = true;
                if (this.needNotificationProgress) {
                    this.closePopup();
                }
                downloadTask!!.onProgressUpdate(fun(res){
                    this.downLoadPercent = parseFloat(res.progress.toFixed(0));
                    this.downloadedSize = parseFloat((res.totalBytesWritten / Math.pow(1024, 2)).toFixed(2));
                    this.packageFileSize = parseFloat((res.totalBytesExpectedToWrite / Math.pow(1024, 2)).toFixed(2));
                    if (this.needNotificationProgress) {
                        createNotificationProgress(CreateNotificationProgressOptions(title = "升级中心正在下载安装包……", content = "" + this.downLoadPercent + "%", progress = this.downLoadPercent, onClick = fun(){
                            if (!this.downloadSuccess) {
                                this.askAbortDownload();
                            }
                        }
                        ));
                    }
                }
                );
            }
        }
        ;
        this.downLoadComplete = fun() {
            this.downloadSuccess = true;
            this.downloading = false;
            this.downLoadPercent = 0;
            this.downloadedSize = 0;
            this.packageFileSize = 0;
            downloadTask = null;
            if (this.needNotificationProgress) {
                finishNotificationProgress(FinishNotificationProgressOptions(title = "安装升级包", content = "下载完成", onClick = fun() {}));
                this.installPackage();
                return;
            }
            if (this.is_mandatory) {
                this.installPackage();
            }
        }
        ;
        this.installPackage = fun() {
            this.installing = true;
        }
        ;
    }
    open lateinit var show: (shown: Boolean, localPackageInfo: UniUpgradeCenterResult?) -> Unit;
    open lateinit var askAbortDownload: () -> Unit;
    open lateinit var closeUpdate: () -> Unit;
    open lateinit var closePopup: () -> Unit;
    open lateinit var updateApp: () -> Unit;
    open lateinit var checkStoreScheme: () -> UTSPromise<Boolean>?;
    open lateinit var downloadPackage: () -> Unit;
    open lateinit var downLoadComplete: () -> Unit;
    open lateinit var installPackage: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("flex-center" to padStyleMapOf(utsMapOf("justifyContent" to "center", "alignItems" to "center")), "mask" to padStyleMapOf(utsMapOf("position" to "fixed", "left" to 0, "top" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "rgba(0,0,0,0.65)")), "content" to padStyleMapOf(utsMapOf("position" to "relative", "top" to 0, "width" to "600rpx", "backgroundColor" to "rgba(0,0,0,0)")), "text" to padStyleMapOf(utsMapOf("fontFamily" to "Source Han Sans CN")), "content-top" to padStyleMapOf(utsMapOf("width" to "100%", "borderBottomColor" to "#ffffff", "borderBottomWidth" to 15, "borderBottomStyle" to "solid")), "content-top-image" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "bottom" to -18)), "content-top-text" to padStyleMapOf(utsMapOf("fontSize" to 22, "fontWeight" to "bold", "color" to "#F8F8FA", "position" to "absolute", "width" to "65%", "top" to 77.5, "left" to 25, "zIndex" to 1)), "content-body" to padStyleMapOf(utsMapOf("boxSizing" to "border-box", "paddingTop" to 0, "paddingRight" to 25, "paddingBottom" to 0, "paddingLeft" to 25, "width" to "100%", "backgroundColor" to "#ffffff", "borderBottomLeftRadius" to 15, "borderBottomRightRadius" to 15)), "content-body-title" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center")), "version" to utsMapOf(".content-body-title " to utsMapOf("paddingLeft" to 4, "color" to "#ffffff", "fontSize" to 10, "marginLeft" to 5, "paddingTop" to 2, "paddingRight" to 4, "paddingBottom" to 2, "borderRadius" to 10, "backgroundColor" to "#50aefd")), "title" to padStyleMapOf(utsMapOf("fontSize" to 16, "fontWeight" to "bold", "color" to "#3DA7FF", "lineHeight" to "38px")), "footer" to padStyleMapOf(utsMapOf("height" to 75, "alignItems" to "center", "justifyContent" to "space-around")), "box-des-scroll" to padStyleMapOf(utsMapOf("boxSizing" to "border-box", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "height" to 100)), "box-des" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#000000", "lineHeight" to "25px")), "progress-box" to padStyleMapOf(utsMapOf("width" to "100%")), "progress" to padStyleMapOf(utsMapOf("width" to "90%", "height" to 20)), "content-bottom" to padStyleMapOf(utsMapOf("height" to 75)), "close-img" to padStyleMapOf(utsMapOf("width" to 35, "height" to 35, "zIndex" to 1000, "position" to "relative", "bottom" to -25, "left" to 132)), "content-button" to padStyleMapOf(utsMapOf("width" to "100%", "height" to 40, "lineHeight" to "40px", "fontSize" to 15, "fontWeight" to "400", "borderRadius" to 20, "borderWidth" to "medium", "borderStyle" to "none", "borderColor" to "#000000", "color" to "#ffffff", "textAlign" to "center", "backgroundColor" to "#1785ff")), "flex-column" to padStyleMapOf(utsMapOf("flexDirection" to "column", "alignItems" to "center")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("close" to null, "show" to null);
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
