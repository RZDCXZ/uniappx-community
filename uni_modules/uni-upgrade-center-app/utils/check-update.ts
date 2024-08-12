import callCheckVersion, { UniUpgradeCenterResult } from "./call-check-version"
import { openSchema } from './utils'

// 推荐再App.vue中使用
const PACKAGE_INFO_KEY = '__package_info__'

// uni-app 项目无法从 vue 中导出 ComponentPublicInstance 类型，故使用条件编译
export default function (component : ComponentPublicInstance | null = null) : Promise<UniUpgradeCenterResult> {
	return new Promise<UniUpgradeCenterResult>((resolve, reject) => {
		callCheckVersion().then(async (uniUpgradeCenterResult) => {

			// NOTE uni-app x 3.96 解构有问题
			const code = uniUpgradeCenterResult.code
			const message = uniUpgradeCenterResult.message

			// 此处逻辑仅为示例，可自行编写
			if (code > 0) {
				/**
				 * 官方适配的升级弹窗，可自行替换资源适配UI风格
				 */
				component?.$callMethod('show', true, uniUpgradeCenterResult)

				return resolve(uniUpgradeCenterResult)
			} else if (code < 0) {
				console.error(message)
				return reject(uniUpgradeCenterResult)
			}
			return resolve(uniUpgradeCenterResult)
		}).catch((err) => {
			reject(err)
		})
	});
}

/**
 * 使用 uni.showModal 升级
 */
function updateUseModal(packageInfo : UniUpgradeCenterResult) : void {
	// #ifdef APP
	const {
		title, // 标题
		contents, // 升级内容
		is_mandatory, // 是否强制更新
		url, // 安装包下载地址
		type,
		platform
	} = packageInfo;

	let isWGT = type === 'wgt'
	let isiOS = !isWGT ? platform.includes('iOS') : false;

	let confirmText = '立即下载更新'

	return uni.showModal({
		title,
		content: contents,
		showCancel: !is_mandatory,
		confirmText,
		success: res => {
			if (res.cancel) return;

			if (isiOS) {
				// iOS 平台跳转 AppStore
				openSchema(url)
				return;
			}

			uni.showToast({
				title: '后台下载中……',
				duration: 1000
			});

			// wgt 和 安卓下载更新
			uni.downloadFile({
				url,
				success: res => {
					if (res.statusCode !== 200) {
						console.error('下载安装包失败');
						return;
					}
					// 下载好直接安装，下次启动生效
					uni.installApk({
						filePath: res.tempFilePath,
						success: () => {
							uni.showModal({
								title: '安装成功请手动重启'
							});
						},
						fail: err => {
							uni.showModal({
								title: '更新失败',
								content: err.message,
								showCancel: false
							});
						}
					});
				}
			});
		}
	});
	// #endif
}