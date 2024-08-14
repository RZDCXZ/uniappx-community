@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uts.sdk.modules.uniInstallApk;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
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
import java.io.File;
import java.io.FileOutputStream;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
open class InstallApkSuccess (
    @JsonNotNull
    open var errMsg: String,
) : UTSObject()
typealias InstallApkComplete = Any;
typealias InstallApkSuccessCallback = (res: InstallApkSuccess) -> Unit;
typealias InstallApkErrorCode = Number;
interface InstallApkFail : IUniError {
    override var errCode: InstallApkErrorCode
}
typealias InstallApkFailCallback = (err: InstallApkFail) -> Unit;
typealias InstallApkCompleteCallback = (res: InstallApkComplete) -> Unit;
open class InstallApkOptions (
    @JsonNotNull
    open var filePath: String,
    open var success: InstallApkSuccessCallback? = null,
    open var fail: InstallApkFailCallback? = null,
    open var complete: InstallApkCompleteCallback? = null,
) : UTSObject()
val UniErrorSubject = "uni-installApk";
val UniErrors: Map<InstallApkErrorCode, String> = Map(utsArrayOf(
    utsArrayOf(
        1300002,
        "No such file"
    )
));
open class InstallApkFailImpl : UniError, InstallApkFail {
    constructor(errCode: InstallApkErrorCode) : super() {
        this.errSubject = UniErrorSubject;
        this.errCode = errCode;
        this.errMsg = UniErrors[errCode] ?: "";
    }
}
fun installApk(options: InstallApkOptions): Unit {
    val context = UTSAndroid.getAppContext() as Context;
    var filePath = UTSAndroid.convert2AbsFullPath(options.filePath);
    var apkFile: File?;
    if (filePath.startsWith("/android_asset/")) {
        filePath = filePath.replace("/android_asset/", "");
        apkFile = copyAssetFileToPrivateDir(context, filePath);
    } else {
        apkFile = File(filePath);
    }
    if (apkFile != null && !apkFile.exists() && !apkFile.isFile()) {
        var error = InstallApkFailImpl(1300002);
        options.fail?.invoke(error);
        options.complete?.invoke(error);
        return;
    }
    val intent = Intent();
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.setAction(Intent.ACTION_VIEW);
    if (Build.VERSION.SDK_INT >= 24) {
        val authority = context.getPackageName() + ".dc.fileprovider";
        val apkUri = FileProvider.getUriForFile(context, authority, apkFile as File);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
    } else {
        intent.setDataAndType(Uri.fromFile(apkFile as File), "application/vnd.android.package-archive");
    }
    context.startActivity(intent);
    val success = InstallApkSuccess(errMsg = "success");
    options.success?.invoke(success);
    options.complete?.invoke(success);
}
fun copyAssetFileToPrivateDir(context: Context, fileName: String): File? {
    try {
        val destPath = context.getCacheDir().getPath() + "/apks/" + fileName;
        val outFile = File(destPath);
        val parentFile = outFile.getParentFile();
        if (parentFile != null) {
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
        if (!outFile.exists()) {
            outFile.createNewFile();
        }
        val inputStream = context.getAssets().open(fileName);
        val outputStream = FileOutputStream(outFile);
        var buffer = ByteArray(1024);
        do {
            var len = inputStream.read(buffer);
            if (len == -1) {
                break;
            }
            outputStream.write(buffer, 0, len);
        }
        while (true)
        inputStream.close();
        outputStream.close();
        return outFile;
    }
     catch (e: Exception) {
        e.printStackTrace();
    }
    return null;
}
