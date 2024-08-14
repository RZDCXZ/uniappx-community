import { baseURL } from '@/common/config'

export type StoreListItem = {
	enable : boolean
	id : string
	name : string
	scheme : string
	priority : number // 优先级
}

// 请求响应数据
export type UniUpgradeCenterResult = {
	id : number
	appid : string
	name : string
	title : string
	contents : string
	url : string // 安装包下载地址
	platform : Array<string> // Array<'Android' | 'iOS'>
	version : string // 版本号 1.0.0
	uni_platform : string // "android" | "ios" // 版本号 1.0.0
	stable_publish : boolean // 是否是稳定版
	is_mandatory : boolean // 是否强制更新
	is_silently : boolean	// 是否静默更新
	create_env : string // "upgrade-center"
	create_time : string | null
	update_time:  string | null
	message : string
	code : number

	type : string // "native_app" | "wgt"
	store_list : StoreListItem[] | null
	min_uni_version : string | null  // 升级 wgt 的最低 uni-app 版本
}

type CheckVersionResult = {
	code : number
	data : UniUpgradeCenterResult | null
	msg : string
}

export default function () : Promise<UniUpgradeCenterResult> {

	return new Promise<UniUpgradeCenterResult>((resolve, reject) => {
		const systemInfo = uni.getSystemInfoSync()
		const appId = systemInfo.appId
		const appVersion = systemInfo.appVersion //systemInfo.appVersion

		if (typeof appId === 'string' && typeof appVersion === 'string' && appId.length > 0 && appVersion.length > 0) {
			try {
				let data = {
					appid: appId,
					appVersion: appVersion,
					wgtVersion: '0.0.0.0.0.1',
					platform:systemInfo.platform
				}
				uni.request<CheckVersionResult>({
					// 请求url
					url: baseURL + '/upgradation',
					method: 'POST',
					data,
					success: res => {
						let r = res.data
						if (r == null) return reject({
							code: 0,
							message: "未知错误"
						})
						if(r.data != null){
							let d = r.data as UniUpgradeCenterResult
							if (r.code == 0) {
								reject({
									code: d.code,
									message: d.message
								})
							} else {
								resolve(d)
							}
						} else {
							reject({
								code: r.code,
								message: r.msg,
							})
						}
					},
					fail: (err) => {
						console.log(err)
						reject({
							code:0,
							message:err.errMsg
						})
					},
				});
				
			} catch (e) {
				reject(e.message)
			}
		} else {
			reject('invalid appid or appVersion')
		}

	})

}