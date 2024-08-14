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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit;
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showActionSheet as uni_showActionSheet;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
import io.dcloud.uniapp.extapi.uploadFile as uni_uploadFile;
open class GenPagesUserEditinfoUserEditinfo : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(_: OnLoadOptions) {
            if (userState.avatar != null) {
                this.avatar = userState.avatar as String;
            }
            if (userState.birthday != null) {
                this.birthday = userState.birthday as String;
            }
            if (userState.path != null) {
                this.path = userState.path as String;
            }
            if (userState.username != null) {
                this.name = userState.username as String;
            }
            if (userState.desc != null) {
                this.desc = userState.desc as String;
            }
            this.sex = userState.sex as Number;
            this.qg = userState.qg as Number;
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_navbar = resolveEasyComponent("navbar", GenComponentsNavbarNavbarClass);
        val _component_avatar = resolveEasyComponent("avatar", GenComponentsAvatarAvatarClass);
        val _component_cell = resolveEasyComponent("cell", GenComponentsCellCellClass);
        val _component_f_picker = resolveEasyComponent("f-picker", GenComponentsFPickerFPickerClass);
        val _component_f_city_picker = resolveEasyComponent("f-city-picker", GenComponentsFCityPickerFCityPickerClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createVNode(_component_navbar, utsMapOf("title" to "编辑资料", "type" to "text", "right-text" to "完成", "onClickRight" to _ctx.sumbit), null, 8, utsArrayOf(
                "onClickRight"
            )),
            createElementVNode("view", utsMapOf("class" to "avatar-input"), utsArrayOf(
                createVNode(_component_avatar, utsMapOf("src" to _ctx.avatar, "width" to "175rpx", "height" to "175rpx", "onClick" to _ctx.updateAvatar), null, 8, utsArrayOf(
                    "src",
                    "onClick"
                )),
                createElementVNode("text", utsMapOf("class" to "avatar-input-tip"), "点击更换头像")
            )),
            createVNode(_component_cell, utsMapOf("title" to "昵称", "border" to true, "is-column" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("input", utsMapOf("modelValue" to _ctx.name, "onInput" to fun(`$event`: InputEvent){
                        _ctx.name = `$event`.detail.value;
                    }
                    , "class" to "nickname-input", "type" to "text", "placeholder" to "请输入你的昵称"), null, 40, utsArrayOf(
                        "modelValue",
                        "onInput"
                    ))
                );
            }
            ), "_" to 1)),
            createVNode(_component_cell, utsMapOf("title" to "性别", "border" to true, "right-text" to _ctx.sexText, "onClick" to _ctx.openSexPicker), null, 8, utsArrayOf(
                "right-text",
                "onClick"
            )),
            createVNode(_component_f_picker, utsMapOf("mode" to "date", "onConfirm" to _ctx.confirmBirthdayPicker), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createVNode(_component_cell, utsMapOf("title" to "生日", "border" to true, "right-text" to if (_ctx.birthday == "") {
                        "未填写";
                    } else {
                        _ctx.birthday;
                    }
                    ), null, 8, utsArrayOf(
                        "right-text"
                    ))
                );
            }
            ), "_" to 1), 8, utsArrayOf(
                "onConfirm"
            )),
            createVNode(_component_cell, utsMapOf("title" to "情感", "border" to true, "right-text" to _ctx.qgText, "onClick" to fun(){
                _ctx.openEmotionPicker();
            }
            ), null, 8, utsArrayOf(
                "right-text",
                "onClick"
            )),
            createVNode(_component_f_city_picker, utsMapOf("onConfirm" to _ctx.confirmPathPicker), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createVNode(_component_cell, utsMapOf("title" to "所在地", "border" to true, "right-text" to if (_ctx.path == "") {
                        "未填写";
                    } else {
                        _ctx.path;
                    }
                    ), null, 8, utsArrayOf(
                        "right-text"
                    ))
                );
            }
            ), "_" to 1), 8, utsArrayOf(
                "onConfirm"
            )),
            createElementVNode("view", utsMapOf("class" to "divider")),
            createVNode(_component_cell, utsMapOf("title" to "个性签名", "show-arrow" to false)),
            createElementVNode("textarea", utsMapOf("value" to _ctx.desc, "placeholder" to "请输入你的个性签名", "class" to "desc-input", "onInput" to _ctx.handleDescInput), null, 40, utsArrayOf(
                "value",
                "onInput"
            )),
            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "300rpx"))), null, 4)
        ), 4);
    }
    open var avatar: String by `$data`;
    open var birthday: String by `$data`;
    open var path: String by `$data`;
    open var name: String by `$data`;
    open var sex: Number by `$data`;
    open var qg: Number by `$data`;
    open var desc: String by `$data`;
    open var sexText: String by `$data`;
    open var qgText: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("avatar" to "/static/default-avatar.png", "birthday" to "", "path" to "", "name" to "", "sex" to 0, "qg" to 0, "desc" to "", "sexText" to computed<String>(fun(): String {
            return getSexText(this.sex);
        }
        ), "qgText" to computed<String>(fun(): String {
            return getEmotionText(this.qg);
        }
        ));
    }
    override fun `$initMethods`() {
        this.sumbit = fun() {
            uni_showLoading(ShowLoadingOptions(title = "修改中...", mask = true));
            val data: UTSJSONObject = let {
                object : UTSJSONObject(UTSSourceMapPosition("data", "pages/user-editinfo/user-editinfo.uvue", 89, 11)) {
                    var name = it.name
                    var sex = it.sex
                    var qg = it.qg
                    var birthday = it.birthday
                    var path = it.path
                    var desc = it.desc
                }
            };
            uni_request<Result<UserDetail>>(RequestOptions(url = getURL("/user/changeinfo"), data = data, method = "POST", header = object : UTSJSONObject() {
                var token = getToken()
            }, success = fun(res){
                var r = res.data;
                if (r === null) {
                    return;
                }
                if (res.statusCode != 200) {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                    return;
                }
                uni__emit("onUpdateInfoSuccess", "info");
                updateInfo(r.data as UserDetail);
                uni_showToast(ShowToastOptions(title = "修改成功", icon = "none"));
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
        this.handleDescInput = fun(e: UniInputEvent) {
            this.desc = e.detail.value;
        }
        ;
        this.openSexPicker = fun() {
            uni_showActionSheet(ShowActionSheetOptions(title = "请选择性别", itemList = sexOptions, success = fun(res: ShowActionSheetSuccess){
                this.sex = res.tapIndex ?: 0;
                console.log(this.sex, " at pages/user-editinfo/user-editinfo.uvue:151");
            }
            ));
        }
        ;
        this.openEmotionPicker = fun() {
            uni_showActionSheet(ShowActionSheetOptions(title = "请选择情感情况", itemList = emotionOptions, success = fun(res: ShowActionSheetSuccess){
                this.qg = res.tapIndex ?: 0;
                console.log(this.qg, " at pages/user-editinfo/user-editinfo.uvue:161");
            }
            ));
        }
        ;
        this.confirmPathPicker = fun(e: citypickerChangeEvent) {
            this.path = e.label;
        }
        ;
        this.confirmBirthdayPicker = fun(e: String) {
            this.birthday = e;
        }
        ;
        this.updateAvatar = fun() {
            uni_chooseImage(ChooseImageOptions(count = 1, sizeType = utsArrayOf(
                "compressed"
            ), sourceType = utsArrayOf(
                "album",
                "camera"
            ), success = fun(res){
                uni_showLoading(ShowLoadingOptions(title = "上传头像中...", mask = true));
                uni_uploadFile(UploadFileOptions(url = getURL("/user/changeavatar"), filePath = res.tempFilePaths[0], name = "avatar", header = object : UTSJSONObject() {
                    var token = getToken()
                }, success = fun(res){
                    var d = UTSAndroid.consoleDebugError(JSON.parse<defaultResult>(res.data), " at pages/user-editinfo/user-editinfo.uvue:189");
                    if (d == null) {
                        return;
                    }
                    if (d.code == 0) {
                        uni_showToast(ShowToastOptions(title = d.msg, icon = "none"));
                        return;
                    }
                    val src = d.data as String;
                    uni_showToast(ShowToastOptions(title = "修改头像成功", icon = "none"));
                    updateUserStateAvatar(src);
                    this.avatar = src;
                    uni__emit("onUpdateInfoSuccess", "avatar");
                }
                , complete = fun(_){
                    uni_hideLoading();
                }
                ));
            }
            ));
        }
        ;
    }
    open lateinit var sumbit: () -> Unit;
    open lateinit var handleDescInput: (e: UniInputEvent) -> Unit;
    open lateinit var openSexPicker: () -> Unit;
    open lateinit var openEmotionPicker: () -> Unit;
    open lateinit var confirmPathPicker: (e: citypickerChangeEvent) -> Unit;
    open lateinit var confirmBirthdayPicker: (e: String) -> Unit;
    open lateinit var updateAvatar: () -> Unit;
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
                return utsMapOf("avatar-input" to padStyleMapOf(utsMapOf("alignItems" to "center", "justifyContent" to "center", "paddingTop" to "60rpx", "paddingBottom" to "50rpx")), "avatar-input-tip" to padStyleMapOf(utsMapOf("fontSize" to 14, "marginTop" to "25rpx", "color" to "#0d0d0d")), "desc-input" to padStyleMapOf(utsMapOf("backgroundColor" to "#f9f9f9", "marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "height" to "225rpx", "paddingTop" to "25rpx", "paddingRight" to "25rpx", "paddingBottom" to "25rpx", "paddingLeft" to "25rpx", "width" to "690rpx")), "nickname-input" to padStyleMapOf(utsMapOf("height" to "90rpx", "fontSize" to 15, "color" to "#424242")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
