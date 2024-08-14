@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.UNIC512840;
import android.content.Intent;
import android.net.Uri;
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
import io.dcloud.uniapp.appframe.AppConfig;
import io.dcloud.uniapp.extapi.closeSocket as uni_closeSocket;
import io.dcloud.uniapp.extapi.connectSocket as uni_connectSocket;
import io.dcloud.uniapp.extapi.exit as uni_exit;
import io.dcloud.uniapp.extapi.getStorage as uni_getStorage;
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync;
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.onSocketClose as uni_onSocketClose;
import io.dcloud.uniapp.extapi.onSocketError as uni_onSocketError;
import io.dcloud.uniapp.extapi.onSocketMessage as uni_onSocketMessage;
import io.dcloud.uniapp.extapi.onSocketOpen as uni_onSocketOpen;
import io.dcloud.uniapp.extapi.removeStorageSync as uni_removeStorageSync;
import io.dcloud.uniapp.extapi.removeTabBarBadge as uni_removeTabBarBadge;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync;
import io.dcloud.uniapp.extapi.setTabBarBadge as uni_setTabBarBadge;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
val baseURL = "http://sqapi2.dishawang.com/api/v1";
val websocketURL = "wss://sqapi2.dishawang.com/ws";
val agreementUrl = "http://sqapi2.dishawang.com/agreement";
val privacyUrl = "http://sqapi2.dishawang.com/privacy";
open class TopicNav (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var title: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return TopicNavReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class TopicNavReactiveObject : TopicNav, IUTSReactive<TopicNav> {
    override var __v_raw: TopicNav;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: TopicNav, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, title = __v_raw.title) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): TopicNavReactiveObject {
        return TopicNavReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var title: String
        get() {
            return trackReactiveGet(__v_raw, "title", __v_raw.title, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("title")) {
                return;
            }
            val oldValue = __v_raw.title;
            __v_raw.title = value;
            triggerReactiveSet(__v_raw, "title", oldValue, value);
        }
}
open class Topic (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var cover: String,
    @JsonNotNull
    open var desc: String,
    open var create_time: String? = null,
    open var update_time: String? = null,
    @JsonNotNull
    open var category_id: Number,
    @JsonNotNull
    open var article_count: Number,
    @JsonNotNull
    open var today_article_count: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return TopicReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class TopicReactiveObject : Topic, IUTSReactive<Topic> {
    override var __v_raw: Topic;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: Topic, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, title = __v_raw.title, cover = __v_raw.cover, desc = __v_raw.desc, create_time = __v_raw.create_time, update_time = __v_raw.update_time, category_id = __v_raw.category_id, article_count = __v_raw.article_count, today_article_count = __v_raw.today_article_count) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): TopicReactiveObject {
        return TopicReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var title: String
        get() {
            return trackReactiveGet(__v_raw, "title", __v_raw.title, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("title")) {
                return;
            }
            val oldValue = __v_raw.title;
            __v_raw.title = value;
            triggerReactiveSet(__v_raw, "title", oldValue, value);
        }
    override var cover: String
        get() {
            return trackReactiveGet(__v_raw, "cover", __v_raw.cover, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("cover")) {
                return;
            }
            val oldValue = __v_raw.cover;
            __v_raw.cover = value;
            triggerReactiveSet(__v_raw, "cover", oldValue, value);
        }
    override var desc: String
        get() {
            return trackReactiveGet(__v_raw, "desc", __v_raw.desc, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("desc")) {
                return;
            }
            val oldValue = __v_raw.desc;
            __v_raw.desc = value;
            triggerReactiveSet(__v_raw, "desc", oldValue, value);
        }
    override var create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "create_time", __v_raw.create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("create_time")) {
                return;
            }
            val oldValue = __v_raw.create_time;
            __v_raw.create_time = value;
            triggerReactiveSet(__v_raw, "create_time", oldValue, value);
        }
    override var update_time: String?
        get() {
            return trackReactiveGet(__v_raw, "update_time", __v_raw.update_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("update_time")) {
                return;
            }
            val oldValue = __v_raw.update_time;
            __v_raw.update_time = value;
            triggerReactiveSet(__v_raw, "update_time", oldValue, value);
        }
    override var category_id: Number
        get() {
            return trackReactiveGet(__v_raw, "category_id", __v_raw.category_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("category_id")) {
                return;
            }
            val oldValue = __v_raw.category_id;
            __v_raw.category_id = value;
            triggerReactiveSet(__v_raw, "category_id", oldValue, value);
        }
    override var article_count: Number
        get() {
            return trackReactiveGet(__v_raw, "article_count", __v_raw.article_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("article_count")) {
                return;
            }
            val oldValue = __v_raw.article_count;
            __v_raw.article_count = value;
            triggerReactiveSet(__v_raw, "article_count", oldValue, value);
        }
    override var today_article_count: Number
        get() {
            return trackReactiveGet(__v_raw, "today_article_count", __v_raw.today_article_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("today_article_count")) {
                return;
            }
            val oldValue = __v_raw.today_article_count;
            __v_raw.today_article_count = value;
            triggerReactiveSet(__v_raw, "today_article_count", oldValue, value);
        }
}
open class Result<T> (
    @JsonNotNull
    open var msg: String,
    open var data: T? = null,
    @JsonNotNull
    open var code: Number,
) : UTSObject()
open class TopicResult (
    @JsonNotNull
    open var current_page: Number,
    @JsonNotNull
    open var per_page: Number,
    @JsonNotNull
    open var last_page: Number,
    @JsonNotNull
    open var total: Number,
    @JsonNotNull
    open var data: UTSArray<Topic>,
) : UTSObject()
open class ListItem (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var user_id: Number,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var images: UTSArray<String>,
    @JsonNotNull
    open var url: String,
    @JsonNotNull
    open var category_id: Number,
    @JsonNotNull
    open var topic_id: Number,
    @JsonNotNull
    open var share_count: Number,
    @JsonNotNull
    open var ding_count: Number,
    @JsonNotNull
    open var cai_count: Number,
    @JsonNotNull
    open var comment_count: Number,
    @JsonNotNull
    open var read_count: Number,
    @JsonNotNull
    open var collect_count: Number,
    open var create_time: String? = null,
    open var update_time: String? = null,
    @JsonNotNull
    open var name: String,
    open var avatar: String? = null,
    @JsonNotNull
    open var user_status: Number,
    open var topic_name: String? = null,
    @JsonNotNull
    open var user_support_action: String,
    @JsonNotNull
    open var isfollow: Boolean = false,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ListItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class ListItemReactiveObject : ListItem, IUTSReactive<ListItem> {
    override var __v_raw: ListItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: ListItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, user_id = __v_raw.user_id, title = __v_raw.title, images = __v_raw.images, url = __v_raw.url, category_id = __v_raw.category_id, topic_id = __v_raw.topic_id, share_count = __v_raw.share_count, ding_count = __v_raw.ding_count, cai_count = __v_raw.cai_count, comment_count = __v_raw.comment_count, read_count = __v_raw.read_count, collect_count = __v_raw.collect_count, create_time = __v_raw.create_time, update_time = __v_raw.update_time, name = __v_raw.name, avatar = __v_raw.avatar, user_status = __v_raw.user_status, topic_name = __v_raw.topic_name, user_support_action = __v_raw.user_support_action, isfollow = __v_raw.isfollow) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ListItemReactiveObject {
        return ListItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var user_id: Number
        get() {
            return trackReactiveGet(__v_raw, "user_id", __v_raw.user_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("user_id")) {
                return;
            }
            val oldValue = __v_raw.user_id;
            __v_raw.user_id = value;
            triggerReactiveSet(__v_raw, "user_id", oldValue, value);
        }
    override var title: String
        get() {
            return trackReactiveGet(__v_raw, "title", __v_raw.title, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("title")) {
                return;
            }
            val oldValue = __v_raw.title;
            __v_raw.title = value;
            triggerReactiveSet(__v_raw, "title", oldValue, value);
        }
    override var images: UTSArray<String>
        get() {
            return trackReactiveGet(__v_raw, "images", __v_raw.images, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("images")) {
                return;
            }
            val oldValue = __v_raw.images;
            __v_raw.images = value;
            triggerReactiveSet(__v_raw, "images", oldValue, value);
        }
    override var url: String
        get() {
            return trackReactiveGet(__v_raw, "url", __v_raw.url, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("url")) {
                return;
            }
            val oldValue = __v_raw.url;
            __v_raw.url = value;
            triggerReactiveSet(__v_raw, "url", oldValue, value);
        }
    override var category_id: Number
        get() {
            return trackReactiveGet(__v_raw, "category_id", __v_raw.category_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("category_id")) {
                return;
            }
            val oldValue = __v_raw.category_id;
            __v_raw.category_id = value;
            triggerReactiveSet(__v_raw, "category_id", oldValue, value);
        }
    override var topic_id: Number
        get() {
            return trackReactiveGet(__v_raw, "topic_id", __v_raw.topic_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("topic_id")) {
                return;
            }
            val oldValue = __v_raw.topic_id;
            __v_raw.topic_id = value;
            triggerReactiveSet(__v_raw, "topic_id", oldValue, value);
        }
    override var share_count: Number
        get() {
            return trackReactiveGet(__v_raw, "share_count", __v_raw.share_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("share_count")) {
                return;
            }
            val oldValue = __v_raw.share_count;
            __v_raw.share_count = value;
            triggerReactiveSet(__v_raw, "share_count", oldValue, value);
        }
    override var ding_count: Number
        get() {
            return trackReactiveGet(__v_raw, "ding_count", __v_raw.ding_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("ding_count")) {
                return;
            }
            val oldValue = __v_raw.ding_count;
            __v_raw.ding_count = value;
            triggerReactiveSet(__v_raw, "ding_count", oldValue, value);
        }
    override var cai_count: Number
        get() {
            return trackReactiveGet(__v_raw, "cai_count", __v_raw.cai_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("cai_count")) {
                return;
            }
            val oldValue = __v_raw.cai_count;
            __v_raw.cai_count = value;
            triggerReactiveSet(__v_raw, "cai_count", oldValue, value);
        }
    override var comment_count: Number
        get() {
            return trackReactiveGet(__v_raw, "comment_count", __v_raw.comment_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("comment_count")) {
                return;
            }
            val oldValue = __v_raw.comment_count;
            __v_raw.comment_count = value;
            triggerReactiveSet(__v_raw, "comment_count", oldValue, value);
        }
    override var read_count: Number
        get() {
            return trackReactiveGet(__v_raw, "read_count", __v_raw.read_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("read_count")) {
                return;
            }
            val oldValue = __v_raw.read_count;
            __v_raw.read_count = value;
            triggerReactiveSet(__v_raw, "read_count", oldValue, value);
        }
    override var collect_count: Number
        get() {
            return trackReactiveGet(__v_raw, "collect_count", __v_raw.collect_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("collect_count")) {
                return;
            }
            val oldValue = __v_raw.collect_count;
            __v_raw.collect_count = value;
            triggerReactiveSet(__v_raw, "collect_count", oldValue, value);
        }
    override var create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "create_time", __v_raw.create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("create_time")) {
                return;
            }
            val oldValue = __v_raw.create_time;
            __v_raw.create_time = value;
            triggerReactiveSet(__v_raw, "create_time", oldValue, value);
        }
    override var update_time: String?
        get() {
            return trackReactiveGet(__v_raw, "update_time", __v_raw.update_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("update_time")) {
                return;
            }
            val oldValue = __v_raw.update_time;
            __v_raw.update_time = value;
            triggerReactiveSet(__v_raw, "update_time", oldValue, value);
        }
    override var name: String
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
    override var user_status: Number
        get() {
            return trackReactiveGet(__v_raw, "user_status", __v_raw.user_status, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("user_status")) {
                return;
            }
            val oldValue = __v_raw.user_status;
            __v_raw.user_status = value;
            triggerReactiveSet(__v_raw, "user_status", oldValue, value);
        }
    override var topic_name: String?
        get() {
            return trackReactiveGet(__v_raw, "topic_name", __v_raw.topic_name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("topic_name")) {
                return;
            }
            val oldValue = __v_raw.topic_name;
            __v_raw.topic_name = value;
            triggerReactiveSet(__v_raw, "topic_name", oldValue, value);
        }
    override var user_support_action: String
        get() {
            return trackReactiveGet(__v_raw, "user_support_action", __v_raw.user_support_action, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("user_support_action")) {
                return;
            }
            val oldValue = __v_raw.user_support_action;
            __v_raw.user_support_action = value;
            triggerReactiveSet(__v_raw, "user_support_action", oldValue, value);
        }
    override var isfollow: Boolean
        get() {
            return trackReactiveGet(__v_raw, "isfollow", __v_raw.isfollow, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isfollow")) {
                return;
            }
            val oldValue = __v_raw.isfollow;
            __v_raw.isfollow = value;
            triggerReactiveSet(__v_raw, "isfollow", oldValue, value);
        }
}
open class ListResult (
    @JsonNotNull
    open var current_page: Number,
    @JsonNotNull
    open var per_page: Number,
    @JsonNotNull
    open var last_page: Number,
    @JsonNotNull
    open var total: Number,
    @JsonNotNull
    open var data: UTSArray<ListItem>,
) : UTSObject()
open class UserDetail (
    open var name: String? = null,
    @JsonNotNull
    open var id: Number,
    open var username: String? = null,
    open var avatar: String? = null,
    @JsonNotNull
    open var password: Boolean = false,
    open var phone: String? = null,
    open var email: String? = null,
    @JsonNotNull
    open var status: Number,
    @JsonNotNull
    open var age: Number,
    @JsonNotNull
    open var sex: Number,
    @JsonNotNull
    open var qg: Number,
    open var job: String? = null,
    open var path: String? = null,
    open var birthday: String? = null,
    open var desc: String? = null,
    open var wx_openid: String? = null,
    open var wx_unionid: String? = null,
    open var create_time: String? = null,
    open var update_time: String? = null,
    @JsonNotNull
    open var fans_count: Number,
    @JsonNotNull
    open var follows_count: Number,
    @JsonNotNull
    open var articles_count: Number,
    @JsonNotNull
    open var comments_count: Number,
    open var token: String? = null,
    open var isfollow: Boolean? = null,
    open var isblacked: Boolean? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return UserDetailReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class UserDetailReactiveObject : UserDetail, IUTSReactive<UserDetail> {
    override var __v_raw: UserDetail;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: UserDetail, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(name = __v_raw.name, id = __v_raw.id, username = __v_raw.username, avatar = __v_raw.avatar, password = __v_raw.password, phone = __v_raw.phone, email = __v_raw.email, status = __v_raw.status, age = __v_raw.age, sex = __v_raw.sex, qg = __v_raw.qg, job = __v_raw.job, path = __v_raw.path, birthday = __v_raw.birthday, desc = __v_raw.desc, wx_openid = __v_raw.wx_openid, wx_unionid = __v_raw.wx_unionid, create_time = __v_raw.create_time, update_time = __v_raw.update_time, fans_count = __v_raw.fans_count, follows_count = __v_raw.follows_count, articles_count = __v_raw.articles_count, comments_count = __v_raw.comments_count, token = __v_raw.token, isfollow = __v_raw.isfollow, isblacked = __v_raw.isblacked) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UserDetailReactiveObject {
        return UserDetailReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var name: String?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var username: String?
        get() {
            return trackReactiveGet(__v_raw, "username", __v_raw.username, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("username")) {
                return;
            }
            val oldValue = __v_raw.username;
            __v_raw.username = value;
            triggerReactiveSet(__v_raw, "username", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
    override var password: Boolean
        get() {
            return trackReactiveGet(__v_raw, "password", __v_raw.password, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("password")) {
                return;
            }
            val oldValue = __v_raw.password;
            __v_raw.password = value;
            triggerReactiveSet(__v_raw, "password", oldValue, value);
        }
    override var phone: String?
        get() {
            return trackReactiveGet(__v_raw, "phone", __v_raw.phone, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("phone")) {
                return;
            }
            val oldValue = __v_raw.phone;
            __v_raw.phone = value;
            triggerReactiveSet(__v_raw, "phone", oldValue, value);
        }
    override var email: String?
        get() {
            return trackReactiveGet(__v_raw, "email", __v_raw.email, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("email")) {
                return;
            }
            val oldValue = __v_raw.email;
            __v_raw.email = value;
            triggerReactiveSet(__v_raw, "email", oldValue, value);
        }
    override var status: Number
        get() {
            return trackReactiveGet(__v_raw, "status", __v_raw.status, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("status")) {
                return;
            }
            val oldValue = __v_raw.status;
            __v_raw.status = value;
            triggerReactiveSet(__v_raw, "status", oldValue, value);
        }
    override var age: Number
        get() {
            return trackReactiveGet(__v_raw, "age", __v_raw.age, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("age")) {
                return;
            }
            val oldValue = __v_raw.age;
            __v_raw.age = value;
            triggerReactiveSet(__v_raw, "age", oldValue, value);
        }
    override var sex: Number
        get() {
            return trackReactiveGet(__v_raw, "sex", __v_raw.sex, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("sex")) {
                return;
            }
            val oldValue = __v_raw.sex;
            __v_raw.sex = value;
            triggerReactiveSet(__v_raw, "sex", oldValue, value);
        }
    override var qg: Number
        get() {
            return trackReactiveGet(__v_raw, "qg", __v_raw.qg, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("qg")) {
                return;
            }
            val oldValue = __v_raw.qg;
            __v_raw.qg = value;
            triggerReactiveSet(__v_raw, "qg", oldValue, value);
        }
    override var job: String?
        get() {
            return trackReactiveGet(__v_raw, "job", __v_raw.job, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("job")) {
                return;
            }
            val oldValue = __v_raw.job;
            __v_raw.job = value;
            triggerReactiveSet(__v_raw, "job", oldValue, value);
        }
    override var path: String?
        get() {
            return trackReactiveGet(__v_raw, "path", __v_raw.path, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("path")) {
                return;
            }
            val oldValue = __v_raw.path;
            __v_raw.path = value;
            triggerReactiveSet(__v_raw, "path", oldValue, value);
        }
    override var birthday: String?
        get() {
            return trackReactiveGet(__v_raw, "birthday", __v_raw.birthday, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("birthday")) {
                return;
            }
            val oldValue = __v_raw.birthday;
            __v_raw.birthday = value;
            triggerReactiveSet(__v_raw, "birthday", oldValue, value);
        }
    override var desc: String?
        get() {
            return trackReactiveGet(__v_raw, "desc", __v_raw.desc, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("desc")) {
                return;
            }
            val oldValue = __v_raw.desc;
            __v_raw.desc = value;
            triggerReactiveSet(__v_raw, "desc", oldValue, value);
        }
    override var wx_openid: String?
        get() {
            return trackReactiveGet(__v_raw, "wx_openid", __v_raw.wx_openid, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("wx_openid")) {
                return;
            }
            val oldValue = __v_raw.wx_openid;
            __v_raw.wx_openid = value;
            triggerReactiveSet(__v_raw, "wx_openid", oldValue, value);
        }
    override var wx_unionid: String?
        get() {
            return trackReactiveGet(__v_raw, "wx_unionid", __v_raw.wx_unionid, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("wx_unionid")) {
                return;
            }
            val oldValue = __v_raw.wx_unionid;
            __v_raw.wx_unionid = value;
            triggerReactiveSet(__v_raw, "wx_unionid", oldValue, value);
        }
    override var create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "create_time", __v_raw.create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("create_time")) {
                return;
            }
            val oldValue = __v_raw.create_time;
            __v_raw.create_time = value;
            triggerReactiveSet(__v_raw, "create_time", oldValue, value);
        }
    override var update_time: String?
        get() {
            return trackReactiveGet(__v_raw, "update_time", __v_raw.update_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("update_time")) {
                return;
            }
            val oldValue = __v_raw.update_time;
            __v_raw.update_time = value;
            triggerReactiveSet(__v_raw, "update_time", oldValue, value);
        }
    override var fans_count: Number
        get() {
            return trackReactiveGet(__v_raw, "fans_count", __v_raw.fans_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("fans_count")) {
                return;
            }
            val oldValue = __v_raw.fans_count;
            __v_raw.fans_count = value;
            triggerReactiveSet(__v_raw, "fans_count", oldValue, value);
        }
    override var follows_count: Number
        get() {
            return trackReactiveGet(__v_raw, "follows_count", __v_raw.follows_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("follows_count")) {
                return;
            }
            val oldValue = __v_raw.follows_count;
            __v_raw.follows_count = value;
            triggerReactiveSet(__v_raw, "follows_count", oldValue, value);
        }
    override var articles_count: Number
        get() {
            return trackReactiveGet(__v_raw, "articles_count", __v_raw.articles_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("articles_count")) {
                return;
            }
            val oldValue = __v_raw.articles_count;
            __v_raw.articles_count = value;
            triggerReactiveSet(__v_raw, "articles_count", oldValue, value);
        }
    override var comments_count: Number
        get() {
            return trackReactiveGet(__v_raw, "comments_count", __v_raw.comments_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("comments_count")) {
                return;
            }
            val oldValue = __v_raw.comments_count;
            __v_raw.comments_count = value;
            triggerReactiveSet(__v_raw, "comments_count", oldValue, value);
        }
    override var token: String?
        get() {
            return trackReactiveGet(__v_raw, "token", __v_raw.token, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("token")) {
                return;
            }
            val oldValue = __v_raw.token;
            __v_raw.token = value;
            triggerReactiveSet(__v_raw, "token", oldValue, value);
        }
    override var isfollow: Boolean?
        get() {
            return trackReactiveGet(__v_raw, "isfollow", __v_raw.isfollow, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isfollow")) {
                return;
            }
            val oldValue = __v_raw.isfollow;
            __v_raw.isfollow = value;
            triggerReactiveSet(__v_raw, "isfollow", oldValue, value);
        }
    override var isblacked: Boolean?
        get() {
            return trackReactiveGet(__v_raw, "isblacked", __v_raw.isblacked, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isblacked")) {
                return;
            }
            val oldValue = __v_raw.isblacked;
            __v_raw.isblacked = value;
            triggerReactiveSet(__v_raw, "isblacked", oldValue, value);
        }
}
open class UserDetail2 (
    open var name: String? = null,
    @JsonNotNull
    open var id: Number,
    open var avatar: String? = null,
    @JsonNotNull
    open var status: Number,
    @JsonNotNull
    open var age: Number,
    @JsonNotNull
    open var sex: Number,
    @JsonNotNull
    open var qg: Number,
    open var job: String? = null,
    open var path: String? = null,
    open var birthday: String? = null,
    open var desc: String? = null,
    @JsonNotNull
    open var fans_count: Number,
    @JsonNotNull
    open var follows_count: Number,
    @JsonNotNull
    open var articles_count: Number,
    @JsonNotNull
    open var comments_count: Number,
    @JsonNotNull
    open var isfollow: Boolean = false,
    @JsonNotNull
    open var isblacked: Boolean = false,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return UserDetail2ReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class UserDetail2ReactiveObject : UserDetail2, IUTSReactive<UserDetail2> {
    override var __v_raw: UserDetail2;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: UserDetail2, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(name = __v_raw.name, id = __v_raw.id, avatar = __v_raw.avatar, status = __v_raw.status, age = __v_raw.age, sex = __v_raw.sex, qg = __v_raw.qg, job = __v_raw.job, path = __v_raw.path, birthday = __v_raw.birthday, desc = __v_raw.desc, fans_count = __v_raw.fans_count, follows_count = __v_raw.follows_count, articles_count = __v_raw.articles_count, comments_count = __v_raw.comments_count, isfollow = __v_raw.isfollow, isblacked = __v_raw.isblacked) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UserDetail2ReactiveObject {
        return UserDetail2ReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var name: String?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
    override var status: Number
        get() {
            return trackReactiveGet(__v_raw, "status", __v_raw.status, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("status")) {
                return;
            }
            val oldValue = __v_raw.status;
            __v_raw.status = value;
            triggerReactiveSet(__v_raw, "status", oldValue, value);
        }
    override var age: Number
        get() {
            return trackReactiveGet(__v_raw, "age", __v_raw.age, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("age")) {
                return;
            }
            val oldValue = __v_raw.age;
            __v_raw.age = value;
            triggerReactiveSet(__v_raw, "age", oldValue, value);
        }
    override var sex: Number
        get() {
            return trackReactiveGet(__v_raw, "sex", __v_raw.sex, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("sex")) {
                return;
            }
            val oldValue = __v_raw.sex;
            __v_raw.sex = value;
            triggerReactiveSet(__v_raw, "sex", oldValue, value);
        }
    override var qg: Number
        get() {
            return trackReactiveGet(__v_raw, "qg", __v_raw.qg, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("qg")) {
                return;
            }
            val oldValue = __v_raw.qg;
            __v_raw.qg = value;
            triggerReactiveSet(__v_raw, "qg", oldValue, value);
        }
    override var job: String?
        get() {
            return trackReactiveGet(__v_raw, "job", __v_raw.job, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("job")) {
                return;
            }
            val oldValue = __v_raw.job;
            __v_raw.job = value;
            triggerReactiveSet(__v_raw, "job", oldValue, value);
        }
    override var path: String?
        get() {
            return trackReactiveGet(__v_raw, "path", __v_raw.path, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("path")) {
                return;
            }
            val oldValue = __v_raw.path;
            __v_raw.path = value;
            triggerReactiveSet(__v_raw, "path", oldValue, value);
        }
    override var birthday: String?
        get() {
            return trackReactiveGet(__v_raw, "birthday", __v_raw.birthday, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("birthday")) {
                return;
            }
            val oldValue = __v_raw.birthday;
            __v_raw.birthday = value;
            triggerReactiveSet(__v_raw, "birthday", oldValue, value);
        }
    override var desc: String?
        get() {
            return trackReactiveGet(__v_raw, "desc", __v_raw.desc, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("desc")) {
                return;
            }
            val oldValue = __v_raw.desc;
            __v_raw.desc = value;
            triggerReactiveSet(__v_raw, "desc", oldValue, value);
        }
    override var fans_count: Number
        get() {
            return trackReactiveGet(__v_raw, "fans_count", __v_raw.fans_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("fans_count")) {
                return;
            }
            val oldValue = __v_raw.fans_count;
            __v_raw.fans_count = value;
            triggerReactiveSet(__v_raw, "fans_count", oldValue, value);
        }
    override var follows_count: Number
        get() {
            return trackReactiveGet(__v_raw, "follows_count", __v_raw.follows_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("follows_count")) {
                return;
            }
            val oldValue = __v_raw.follows_count;
            __v_raw.follows_count = value;
            triggerReactiveSet(__v_raw, "follows_count", oldValue, value);
        }
    override var articles_count: Number
        get() {
            return trackReactiveGet(__v_raw, "articles_count", __v_raw.articles_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("articles_count")) {
                return;
            }
            val oldValue = __v_raw.articles_count;
            __v_raw.articles_count = value;
            triggerReactiveSet(__v_raw, "articles_count", oldValue, value);
        }
    override var comments_count: Number
        get() {
            return trackReactiveGet(__v_raw, "comments_count", __v_raw.comments_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("comments_count")) {
                return;
            }
            val oldValue = __v_raw.comments_count;
            __v_raw.comments_count = value;
            triggerReactiveSet(__v_raw, "comments_count", oldValue, value);
        }
    override var isfollow: Boolean
        get() {
            return trackReactiveGet(__v_raw, "isfollow", __v_raw.isfollow, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isfollow")) {
                return;
            }
            val oldValue = __v_raw.isfollow;
            __v_raw.isfollow = value;
            triggerReactiveSet(__v_raw, "isfollow", oldValue, value);
        }
    override var isblacked: Boolean
        get() {
            return trackReactiveGet(__v_raw, "isblacked", __v_raw.isblacked, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isblacked")) {
                return;
            }
            val oldValue = __v_raw.isblacked;
            __v_raw.isblacked = value;
            triggerReactiveSet(__v_raw, "isblacked", oldValue, value);
        }
}
open class defaultResult (
    @JsonNotNull
    open var code: Number,
    @JsonNotNull
    open var msg: String,
    open var data: Any? = null,
) : UTSObject()
open class articleNav (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var title: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return articleNavReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class articleNavReactiveObject : articleNav, IUTSReactive<articleNav> {
    override var __v_raw: articleNav;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: articleNav, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, title = __v_raw.title) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): articleNavReactiveObject {
        return articleNavReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var title: String
        get() {
            return trackReactiveGet(__v_raw, "title", __v_raw.title, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("title")) {
                return;
            }
            val oldValue = __v_raw.title;
            __v_raw.title = value;
            triggerReactiveSet(__v_raw, "title", oldValue, value);
        }
}
open class updateArticleChangeEvent (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var key: String,
    @JsonNotNull
    open var value: String,
) : UTSObject()
open class updateSupportEvent (
    @JsonNotNull
    open var action: String,
    @JsonNotNull
    open var ding_count: Number,
    @JsonNotNull
    open var cai_count: Number,
) : UTSObject()
open class UserItem (
    @JsonNotNull
    open var id: Number,
    open var username: String? = null,
    open var phone: String? = null,
    open var email: String? = null,
    open var avatar: String? = null,
    open var desc: String? = null,
    open var create_time: String? = null,
    @JsonNotNull
    open var fans_count: Number,
    @JsonNotNull
    open var isfollow: Boolean = false,
    open var name: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return UserItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class UserItemReactiveObject : UserItem, IUTSReactive<UserItem> {
    override var __v_raw: UserItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: UserItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, username = __v_raw.username, phone = __v_raw.phone, email = __v_raw.email, avatar = __v_raw.avatar, desc = __v_raw.desc, create_time = __v_raw.create_time, fans_count = __v_raw.fans_count, isfollow = __v_raw.isfollow, name = __v_raw.name) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UserItemReactiveObject {
        return UserItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var username: String?
        get() {
            return trackReactiveGet(__v_raw, "username", __v_raw.username, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("username")) {
                return;
            }
            val oldValue = __v_raw.username;
            __v_raw.username = value;
            triggerReactiveSet(__v_raw, "username", oldValue, value);
        }
    override var phone: String?
        get() {
            return trackReactiveGet(__v_raw, "phone", __v_raw.phone, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("phone")) {
                return;
            }
            val oldValue = __v_raw.phone;
            __v_raw.phone = value;
            triggerReactiveSet(__v_raw, "phone", oldValue, value);
        }
    override var email: String?
        get() {
            return trackReactiveGet(__v_raw, "email", __v_raw.email, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("email")) {
                return;
            }
            val oldValue = __v_raw.email;
            __v_raw.email = value;
            triggerReactiveSet(__v_raw, "email", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
    override var desc: String?
        get() {
            return trackReactiveGet(__v_raw, "desc", __v_raw.desc, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("desc")) {
                return;
            }
            val oldValue = __v_raw.desc;
            __v_raw.desc = value;
            triggerReactiveSet(__v_raw, "desc", oldValue, value);
        }
    override var create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "create_time", __v_raw.create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("create_time")) {
                return;
            }
            val oldValue = __v_raw.create_time;
            __v_raw.create_time = value;
            triggerReactiveSet(__v_raw, "create_time", oldValue, value);
        }
    override var fans_count: Number
        get() {
            return trackReactiveGet(__v_raw, "fans_count", __v_raw.fans_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("fans_count")) {
                return;
            }
            val oldValue = __v_raw.fans_count;
            __v_raw.fans_count = value;
            triggerReactiveSet(__v_raw, "fans_count", oldValue, value);
        }
    override var isfollow: Boolean
        get() {
            return trackReactiveGet(__v_raw, "isfollow", __v_raw.isfollow, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isfollow")) {
                return;
            }
            val oldValue = __v_raw.isfollow;
            __v_raw.isfollow = value;
            triggerReactiveSet(__v_raw, "isfollow", oldValue, value);
        }
    override var name: String?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
}
open class UserItemResult (
    @JsonNotNull
    open var current_page: Number,
    @JsonNotNull
    open var per_page: Number,
    @JsonNotNull
    open var last_page: Number,
    @JsonNotNull
    open var total: Number,
    @JsonNotNull
    open var data: UTSArray<UserItem>,
) : UTSObject()
open class ArticleDetail (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var user_id: Number,
    open var title: String? = null,
    open var content: String? = null,
    @JsonNotNull
    open var images: UTSArray<String>,
    open var url: String? = null,
    @JsonNotNull
    open var category_id: Number,
    @JsonNotNull
    open var topic_id: Number,
    @JsonNotNull
    open var share_count: Number,
    @JsonNotNull
    open var ding_count: Number,
    @JsonNotNull
    open var cai_count: Number,
    @JsonNotNull
    open var comment_count: Number,
    @JsonNotNull
    open var read_count: Number,
    @JsonNotNull
    open var collect_count: Number,
    open var create_time: String? = null,
    open var update_time: String? = null,
    open var name: String? = null,
    open var avatar: String? = null,
    @JsonNotNull
    open var user_status: Number,
    open var topic_name: String? = null,
    @JsonNotNull
    open var user_support_action: String,
    @JsonNotNull
    open var isfollow: Boolean = false,
    @JsonNotNull
    open var isCollect: Boolean = false,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ArticleDetailReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class ArticleDetailReactiveObject : ArticleDetail, IUTSReactive<ArticleDetail> {
    override var __v_raw: ArticleDetail;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: ArticleDetail, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, user_id = __v_raw.user_id, title = __v_raw.title, content = __v_raw.content, images = __v_raw.images, url = __v_raw.url, category_id = __v_raw.category_id, topic_id = __v_raw.topic_id, share_count = __v_raw.share_count, ding_count = __v_raw.ding_count, cai_count = __v_raw.cai_count, comment_count = __v_raw.comment_count, read_count = __v_raw.read_count, collect_count = __v_raw.collect_count, create_time = __v_raw.create_time, update_time = __v_raw.update_time, name = __v_raw.name, avatar = __v_raw.avatar, user_status = __v_raw.user_status, topic_name = __v_raw.topic_name, user_support_action = __v_raw.user_support_action, isfollow = __v_raw.isfollow, isCollect = __v_raw.isCollect) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ArticleDetailReactiveObject {
        return ArticleDetailReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var user_id: Number
        get() {
            return trackReactiveGet(__v_raw, "user_id", __v_raw.user_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("user_id")) {
                return;
            }
            val oldValue = __v_raw.user_id;
            __v_raw.user_id = value;
            triggerReactiveSet(__v_raw, "user_id", oldValue, value);
        }
    override var title: String?
        get() {
            return trackReactiveGet(__v_raw, "title", __v_raw.title, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("title")) {
                return;
            }
            val oldValue = __v_raw.title;
            __v_raw.title = value;
            triggerReactiveSet(__v_raw, "title", oldValue, value);
        }
    override var content: String?
        get() {
            return trackReactiveGet(__v_raw, "content", __v_raw.content, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("content")) {
                return;
            }
            val oldValue = __v_raw.content;
            __v_raw.content = value;
            triggerReactiveSet(__v_raw, "content", oldValue, value);
        }
    override var images: UTSArray<String>
        get() {
            return trackReactiveGet(__v_raw, "images", __v_raw.images, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("images")) {
                return;
            }
            val oldValue = __v_raw.images;
            __v_raw.images = value;
            triggerReactiveSet(__v_raw, "images", oldValue, value);
        }
    override var url: String?
        get() {
            return trackReactiveGet(__v_raw, "url", __v_raw.url, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("url")) {
                return;
            }
            val oldValue = __v_raw.url;
            __v_raw.url = value;
            triggerReactiveSet(__v_raw, "url", oldValue, value);
        }
    override var category_id: Number
        get() {
            return trackReactiveGet(__v_raw, "category_id", __v_raw.category_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("category_id")) {
                return;
            }
            val oldValue = __v_raw.category_id;
            __v_raw.category_id = value;
            triggerReactiveSet(__v_raw, "category_id", oldValue, value);
        }
    override var topic_id: Number
        get() {
            return trackReactiveGet(__v_raw, "topic_id", __v_raw.topic_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("topic_id")) {
                return;
            }
            val oldValue = __v_raw.topic_id;
            __v_raw.topic_id = value;
            triggerReactiveSet(__v_raw, "topic_id", oldValue, value);
        }
    override var share_count: Number
        get() {
            return trackReactiveGet(__v_raw, "share_count", __v_raw.share_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("share_count")) {
                return;
            }
            val oldValue = __v_raw.share_count;
            __v_raw.share_count = value;
            triggerReactiveSet(__v_raw, "share_count", oldValue, value);
        }
    override var ding_count: Number
        get() {
            return trackReactiveGet(__v_raw, "ding_count", __v_raw.ding_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("ding_count")) {
                return;
            }
            val oldValue = __v_raw.ding_count;
            __v_raw.ding_count = value;
            triggerReactiveSet(__v_raw, "ding_count", oldValue, value);
        }
    override var cai_count: Number
        get() {
            return trackReactiveGet(__v_raw, "cai_count", __v_raw.cai_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("cai_count")) {
                return;
            }
            val oldValue = __v_raw.cai_count;
            __v_raw.cai_count = value;
            triggerReactiveSet(__v_raw, "cai_count", oldValue, value);
        }
    override var comment_count: Number
        get() {
            return trackReactiveGet(__v_raw, "comment_count", __v_raw.comment_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("comment_count")) {
                return;
            }
            val oldValue = __v_raw.comment_count;
            __v_raw.comment_count = value;
            triggerReactiveSet(__v_raw, "comment_count", oldValue, value);
        }
    override var read_count: Number
        get() {
            return trackReactiveGet(__v_raw, "read_count", __v_raw.read_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("read_count")) {
                return;
            }
            val oldValue = __v_raw.read_count;
            __v_raw.read_count = value;
            triggerReactiveSet(__v_raw, "read_count", oldValue, value);
        }
    override var collect_count: Number
        get() {
            return trackReactiveGet(__v_raw, "collect_count", __v_raw.collect_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("collect_count")) {
                return;
            }
            val oldValue = __v_raw.collect_count;
            __v_raw.collect_count = value;
            triggerReactiveSet(__v_raw, "collect_count", oldValue, value);
        }
    override var create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "create_time", __v_raw.create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("create_time")) {
                return;
            }
            val oldValue = __v_raw.create_time;
            __v_raw.create_time = value;
            triggerReactiveSet(__v_raw, "create_time", oldValue, value);
        }
    override var update_time: String?
        get() {
            return trackReactiveGet(__v_raw, "update_time", __v_raw.update_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("update_time")) {
                return;
            }
            val oldValue = __v_raw.update_time;
            __v_raw.update_time = value;
            triggerReactiveSet(__v_raw, "update_time", oldValue, value);
        }
    override var name: String?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
    override var user_status: Number
        get() {
            return trackReactiveGet(__v_raw, "user_status", __v_raw.user_status, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("user_status")) {
                return;
            }
            val oldValue = __v_raw.user_status;
            __v_raw.user_status = value;
            triggerReactiveSet(__v_raw, "user_status", oldValue, value);
        }
    override var topic_name: String?
        get() {
            return trackReactiveGet(__v_raw, "topic_name", __v_raw.topic_name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("topic_name")) {
                return;
            }
            val oldValue = __v_raw.topic_name;
            __v_raw.topic_name = value;
            triggerReactiveSet(__v_raw, "topic_name", oldValue, value);
        }
    override var user_support_action: String
        get() {
            return trackReactiveGet(__v_raw, "user_support_action", __v_raw.user_support_action, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("user_support_action")) {
                return;
            }
            val oldValue = __v_raw.user_support_action;
            __v_raw.user_support_action = value;
            triggerReactiveSet(__v_raw, "user_support_action", oldValue, value);
        }
    override var isfollow: Boolean
        get() {
            return trackReactiveGet(__v_raw, "isfollow", __v_raw.isfollow, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isfollow")) {
                return;
            }
            val oldValue = __v_raw.isfollow;
            __v_raw.isfollow = value;
            triggerReactiveSet(__v_raw, "isfollow", oldValue, value);
        }
    override var isCollect: Boolean
        get() {
            return trackReactiveGet(__v_raw, "isCollect", __v_raw.isCollect, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isCollect")) {
                return;
            }
            val oldValue = __v_raw.isCollect;
            __v_raw.isCollect = value;
            triggerReactiveSet(__v_raw, "isCollect", oldValue, value);
        }
}
open class Quote (
    @JsonNotNull
    open var content: String,
    @JsonNotNull
    open var user_id: Number,
    open var name: String? = null,
    open var avatar: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return QuoteReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class QuoteReactiveObject : Quote, IUTSReactive<Quote> {
    override var __v_raw: Quote;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: Quote, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(content = __v_raw.content, user_id = __v_raw.user_id, name = __v_raw.name, avatar = __v_raw.avatar) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): QuoteReactiveObject {
        return QuoteReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var content: String
        get() {
            return trackReactiveGet(__v_raw, "content", __v_raw.content, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("content")) {
                return;
            }
            val oldValue = __v_raw.content;
            __v_raw.content = value;
            triggerReactiveSet(__v_raw, "content", oldValue, value);
        }
    override var user_id: Number
        get() {
            return trackReactiveGet(__v_raw, "user_id", __v_raw.user_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("user_id")) {
                return;
            }
            val oldValue = __v_raw.user_id;
            __v_raw.user_id = value;
            triggerReactiveSet(__v_raw, "user_id", oldValue, value);
        }
    override var name: String?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
}
open class CommentItem (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var article_id: Number,
    @JsonNotNull
    open var user_id: Number,
    @JsonNotNull
    open var reply_count: Number,
    open var content: String? = null,
    open var comment_id: Number? = null,
    open var create_time: String? = null,
    open var avatar: String? = null,
    open var name: String? = null,
    open var quote: Quote? = null,
    open var article_cover: String? = null,
    open var article_title: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return CommentItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class CommentItemReactiveObject : CommentItem, IUTSReactive<CommentItem> {
    override var __v_raw: CommentItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: CommentItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, article_id = __v_raw.article_id, user_id = __v_raw.user_id, reply_count = __v_raw.reply_count, content = __v_raw.content, comment_id = __v_raw.comment_id, create_time = __v_raw.create_time, avatar = __v_raw.avatar, name = __v_raw.name, quote = __v_raw.quote, article_cover = __v_raw.article_cover, article_title = __v_raw.article_title) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): CommentItemReactiveObject {
        return CommentItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var article_id: Number
        get() {
            return trackReactiveGet(__v_raw, "article_id", __v_raw.article_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("article_id")) {
                return;
            }
            val oldValue = __v_raw.article_id;
            __v_raw.article_id = value;
            triggerReactiveSet(__v_raw, "article_id", oldValue, value);
        }
    override var user_id: Number
        get() {
            return trackReactiveGet(__v_raw, "user_id", __v_raw.user_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("user_id")) {
                return;
            }
            val oldValue = __v_raw.user_id;
            __v_raw.user_id = value;
            triggerReactiveSet(__v_raw, "user_id", oldValue, value);
        }
    override var reply_count: Number
        get() {
            return trackReactiveGet(__v_raw, "reply_count", __v_raw.reply_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("reply_count")) {
                return;
            }
            val oldValue = __v_raw.reply_count;
            __v_raw.reply_count = value;
            triggerReactiveSet(__v_raw, "reply_count", oldValue, value);
        }
    override var content: String?
        get() {
            return trackReactiveGet(__v_raw, "content", __v_raw.content, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("content")) {
                return;
            }
            val oldValue = __v_raw.content;
            __v_raw.content = value;
            triggerReactiveSet(__v_raw, "content", oldValue, value);
        }
    override var comment_id: Number?
        get() {
            return trackReactiveGet(__v_raw, "comment_id", __v_raw.comment_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("comment_id")) {
                return;
            }
            val oldValue = __v_raw.comment_id;
            __v_raw.comment_id = value;
            triggerReactiveSet(__v_raw, "comment_id", oldValue, value);
        }
    override var create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "create_time", __v_raw.create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("create_time")) {
                return;
            }
            val oldValue = __v_raw.create_time;
            __v_raw.create_time = value;
            triggerReactiveSet(__v_raw, "create_time", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
    override var name: String?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var quote: Quote?
        get() {
            return trackReactiveGet(__v_raw, "quote", __v_raw.quote, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("quote")) {
                return;
            }
            val oldValue = __v_raw.quote;
            __v_raw.quote = value;
            triggerReactiveSet(__v_raw, "quote", oldValue, value);
        }
    override var article_cover: String?
        get() {
            return trackReactiveGet(__v_raw, "article_cover", __v_raw.article_cover, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("article_cover")) {
                return;
            }
            val oldValue = __v_raw.article_cover;
            __v_raw.article_cover = value;
            triggerReactiveSet(__v_raw, "article_cover", oldValue, value);
        }
    override var article_title: String?
        get() {
            return trackReactiveGet(__v_raw, "article_title", __v_raw.article_title, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("article_title")) {
                return;
            }
            val oldValue = __v_raw.article_title;
            __v_raw.article_title = value;
            triggerReactiveSet(__v_raw, "article_title", oldValue, value);
        }
}
open class CommentItemResult (
    @JsonNotNull
    open var current_page: Number,
    @JsonNotNull
    open var per_page: Number,
    @JsonNotNull
    open var last_page: Number,
    @JsonNotNull
    open var total: Number,
    @JsonNotNull
    open var data: UTSArray<CommentItem>,
) : UTSObject()
open class ReplyEmit (
    open var placeholder: String? = null,
    @JsonNotNull
    open var reply_id: Number,
) : UTSObject()
open class CommentDetail (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var article_id: Number,
    @JsonNotNull
    open var user_id: Number,
    @JsonNotNull
    open var reply_count: Number,
    @JsonNotNull
    open var content: String,
    open var comment_id: Number? = null,
    open var create_time: String? = null,
    open var avatar: String? = null,
    open var name: String? = null,
    @JsonNotNull
    open var isfollow: Boolean = false,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return CommentDetailReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class CommentDetailReactiveObject : CommentDetail, IUTSReactive<CommentDetail> {
    override var __v_raw: CommentDetail;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: CommentDetail, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, article_id = __v_raw.article_id, user_id = __v_raw.user_id, reply_count = __v_raw.reply_count, content = __v_raw.content, comment_id = __v_raw.comment_id, create_time = __v_raw.create_time, avatar = __v_raw.avatar, name = __v_raw.name, isfollow = __v_raw.isfollow) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): CommentDetailReactiveObject {
        return CommentDetailReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var article_id: Number
        get() {
            return trackReactiveGet(__v_raw, "article_id", __v_raw.article_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("article_id")) {
                return;
            }
            val oldValue = __v_raw.article_id;
            __v_raw.article_id = value;
            triggerReactiveSet(__v_raw, "article_id", oldValue, value);
        }
    override var user_id: Number
        get() {
            return trackReactiveGet(__v_raw, "user_id", __v_raw.user_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("user_id")) {
                return;
            }
            val oldValue = __v_raw.user_id;
            __v_raw.user_id = value;
            triggerReactiveSet(__v_raw, "user_id", oldValue, value);
        }
    override var reply_count: Number
        get() {
            return trackReactiveGet(__v_raw, "reply_count", __v_raw.reply_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("reply_count")) {
                return;
            }
            val oldValue = __v_raw.reply_count;
            __v_raw.reply_count = value;
            triggerReactiveSet(__v_raw, "reply_count", oldValue, value);
        }
    override var content: String
        get() {
            return trackReactiveGet(__v_raw, "content", __v_raw.content, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("content")) {
                return;
            }
            val oldValue = __v_raw.content;
            __v_raw.content = value;
            triggerReactiveSet(__v_raw, "content", oldValue, value);
        }
    override var comment_id: Number?
        get() {
            return trackReactiveGet(__v_raw, "comment_id", __v_raw.comment_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("comment_id")) {
                return;
            }
            val oldValue = __v_raw.comment_id;
            __v_raw.comment_id = value;
            triggerReactiveSet(__v_raw, "comment_id", oldValue, value);
        }
    override var create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "create_time", __v_raw.create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("create_time")) {
                return;
            }
            val oldValue = __v_raw.create_time;
            __v_raw.create_time = value;
            triggerReactiveSet(__v_raw, "create_time", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
    override var name: String?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var isfollow: Boolean
        get() {
            return trackReactiveGet(__v_raw, "isfollow", __v_raw.isfollow, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isfollow")) {
                return;
            }
            val oldValue = __v_raw.isfollow;
            __v_raw.isfollow = value;
            triggerReactiveSet(__v_raw, "isfollow", oldValue, value);
        }
}
open class onAddArticleSuccessEvent (
    @JsonNotNull
    open var category_id: Number,
    @JsonNotNull
    open var topic_id: Number,
) : UTSObject()
open class FeedbackItem (
    @JsonNotNull
    open var id: Number,
    open var content: String? = null,
    @JsonNotNull
    open var images: UTSArray<String>,
    @JsonNotNull
    open var type: String,
    open var create_time: String? = null,
    open var name: String? = null,
    open var avatar: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FeedbackItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class FeedbackItemReactiveObject : FeedbackItem, IUTSReactive<FeedbackItem> {
    override var __v_raw: FeedbackItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: FeedbackItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, content = __v_raw.content, images = __v_raw.images, type = __v_raw.type, create_time = __v_raw.create_time, name = __v_raw.name, avatar = __v_raw.avatar) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FeedbackItemReactiveObject {
        return FeedbackItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var content: String?
        get() {
            return trackReactiveGet(__v_raw, "content", __v_raw.content, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("content")) {
                return;
            }
            val oldValue = __v_raw.content;
            __v_raw.content = value;
            triggerReactiveSet(__v_raw, "content", oldValue, value);
        }
    override var images: UTSArray<String>
        get() {
            return trackReactiveGet(__v_raw, "images", __v_raw.images, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("images")) {
                return;
            }
            val oldValue = __v_raw.images;
            __v_raw.images = value;
            triggerReactiveSet(__v_raw, "images", oldValue, value);
        }
    override var type: String
        get() {
            return trackReactiveGet(__v_raw, "type", __v_raw.type, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("type")) {
                return;
            }
            val oldValue = __v_raw.type;
            __v_raw.type = value;
            triggerReactiveSet(__v_raw, "type", oldValue, value);
        }
    override var create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "create_time", __v_raw.create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("create_time")) {
                return;
            }
            val oldValue = __v_raw.create_time;
            __v_raw.create_time = value;
            triggerReactiveSet(__v_raw, "create_time", oldValue, value);
        }
    override var name: String?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
}
open class FeedbackItemResult (
    @JsonNotNull
    open var current_page: Number,
    @JsonNotNull
    open var per_page: Number,
    @JsonNotNull
    open var last_page: Number,
    @JsonNotNull
    open var total: Number,
    @JsonNotNull
    open var data: UTSArray<FeedbackItem>,
) : UTSObject()
open class Conversation (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var target_id: Number,
    @JsonNotNull
    open var unread_count: Number,
    open var last_msg_note: String? = null,
    open var update_time: String? = null,
    open var name: String? = null,
    open var avatar: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ConversationReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class ConversationReactiveObject : Conversation, IUTSReactive<Conversation> {
    override var __v_raw: Conversation;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: Conversation, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, target_id = __v_raw.target_id, unread_count = __v_raw.unread_count, last_msg_note = __v_raw.last_msg_note, update_time = __v_raw.update_time, name = __v_raw.name, avatar = __v_raw.avatar) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ConversationReactiveObject {
        return ConversationReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var target_id: Number
        get() {
            return trackReactiveGet(__v_raw, "target_id", __v_raw.target_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("target_id")) {
                return;
            }
            val oldValue = __v_raw.target_id;
            __v_raw.target_id = value;
            triggerReactiveSet(__v_raw, "target_id", oldValue, value);
        }
    override var unread_count: Number
        get() {
            return trackReactiveGet(__v_raw, "unread_count", __v_raw.unread_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("unread_count")) {
                return;
            }
            val oldValue = __v_raw.unread_count;
            __v_raw.unread_count = value;
            triggerReactiveSet(__v_raw, "unread_count", oldValue, value);
        }
    override var last_msg_note: String?
        get() {
            return trackReactiveGet(__v_raw, "last_msg_note", __v_raw.last_msg_note, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("last_msg_note")) {
                return;
            }
            val oldValue = __v_raw.last_msg_note;
            __v_raw.last_msg_note = value;
            triggerReactiveSet(__v_raw, "last_msg_note", oldValue, value);
        }
    override var update_time: String?
        get() {
            return trackReactiveGet(__v_raw, "update_time", __v_raw.update_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("update_time")) {
                return;
            }
            val oldValue = __v_raw.update_time;
            __v_raw.update_time = value;
            triggerReactiveSet(__v_raw, "update_time", oldValue, value);
        }
    override var name: String?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
}
open class ConversationResult (
    @JsonNotNull
    open var current_page: Number,
    @JsonNotNull
    open var per_page: Number,
    @JsonNotNull
    open var last_page: Number,
    @JsonNotNull
    open var total: Number,
    @JsonNotNull
    open var data: UTSArray<Conversation>,
) : UTSObject()
open class ChatItem (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var user_id: Number,
    @JsonNotNull
    open var target_id: Number,
    @JsonNotNull
    open var is_revoke: Number,
    @JsonNotNull
    open var is_push: Number,
    @JsonNotNull
    open var type: String,
    @JsonNotNull
    open var state: Number,
    @JsonNotNull
    open var body: String,
    open var create_time: String? = null,
    open var update_time: String? = null,
    open var client_create_time: String? = null,
    open var name: String? = null,
    open var avatar: String? = null,
    open var conversation_id: Number? = null,
    open var state_text: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ChatItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class ChatItemReactiveObject : ChatItem, IUTSReactive<ChatItem> {
    override var __v_raw: ChatItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: ChatItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, user_id = __v_raw.user_id, target_id = __v_raw.target_id, is_revoke = __v_raw.is_revoke, is_push = __v_raw.is_push, type = __v_raw.type, state = __v_raw.state, body = __v_raw.body, create_time = __v_raw.create_time, update_time = __v_raw.update_time, client_create_time = __v_raw.client_create_time, name = __v_raw.name, avatar = __v_raw.avatar, conversation_id = __v_raw.conversation_id, state_text = __v_raw.state_text) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ChatItemReactiveObject {
        return ChatItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var user_id: Number
        get() {
            return trackReactiveGet(__v_raw, "user_id", __v_raw.user_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("user_id")) {
                return;
            }
            val oldValue = __v_raw.user_id;
            __v_raw.user_id = value;
            triggerReactiveSet(__v_raw, "user_id", oldValue, value);
        }
    override var target_id: Number
        get() {
            return trackReactiveGet(__v_raw, "target_id", __v_raw.target_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("target_id")) {
                return;
            }
            val oldValue = __v_raw.target_id;
            __v_raw.target_id = value;
            triggerReactiveSet(__v_raw, "target_id", oldValue, value);
        }
    override var is_revoke: Number
        get() {
            return trackReactiveGet(__v_raw, "is_revoke", __v_raw.is_revoke, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("is_revoke")) {
                return;
            }
            val oldValue = __v_raw.is_revoke;
            __v_raw.is_revoke = value;
            triggerReactiveSet(__v_raw, "is_revoke", oldValue, value);
        }
    override var is_push: Number
        get() {
            return trackReactiveGet(__v_raw, "is_push", __v_raw.is_push, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("is_push")) {
                return;
            }
            val oldValue = __v_raw.is_push;
            __v_raw.is_push = value;
            triggerReactiveSet(__v_raw, "is_push", oldValue, value);
        }
    override var type: String
        get() {
            return trackReactiveGet(__v_raw, "type", __v_raw.type, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("type")) {
                return;
            }
            val oldValue = __v_raw.type;
            __v_raw.type = value;
            triggerReactiveSet(__v_raw, "type", oldValue, value);
        }
    override var state: Number
        get() {
            return trackReactiveGet(__v_raw, "state", __v_raw.state, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("state")) {
                return;
            }
            val oldValue = __v_raw.state;
            __v_raw.state = value;
            triggerReactiveSet(__v_raw, "state", oldValue, value);
        }
    override var body: String
        get() {
            return trackReactiveGet(__v_raw, "body", __v_raw.body, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("body")) {
                return;
            }
            val oldValue = __v_raw.body;
            __v_raw.body = value;
            triggerReactiveSet(__v_raw, "body", oldValue, value);
        }
    override var create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "create_time", __v_raw.create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("create_time")) {
                return;
            }
            val oldValue = __v_raw.create_time;
            __v_raw.create_time = value;
            triggerReactiveSet(__v_raw, "create_time", oldValue, value);
        }
    override var update_time: String?
        get() {
            return trackReactiveGet(__v_raw, "update_time", __v_raw.update_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("update_time")) {
                return;
            }
            val oldValue = __v_raw.update_time;
            __v_raw.update_time = value;
            triggerReactiveSet(__v_raw, "update_time", oldValue, value);
        }
    override var client_create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "client_create_time", __v_raw.client_create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("client_create_time")) {
                return;
            }
            val oldValue = __v_raw.client_create_time;
            __v_raw.client_create_time = value;
            triggerReactiveSet(__v_raw, "client_create_time", oldValue, value);
        }
    override var name: String?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var avatar: String?
        get() {
            return trackReactiveGet(__v_raw, "avatar", __v_raw.avatar, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("avatar")) {
                return;
            }
            val oldValue = __v_raw.avatar;
            __v_raw.avatar = value;
            triggerReactiveSet(__v_raw, "avatar", oldValue, value);
        }
    override var conversation_id: Number?
        get() {
            return trackReactiveGet(__v_raw, "conversation_id", __v_raw.conversation_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("conversation_id")) {
                return;
            }
            val oldValue = __v_raw.conversation_id;
            __v_raw.conversation_id = value;
            triggerReactiveSet(__v_raw, "conversation_id", oldValue, value);
        }
    override var state_text: String?
        get() {
            return trackReactiveGet(__v_raw, "state_text", __v_raw.state_text, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("state_text")) {
                return;
            }
            val oldValue = __v_raw.state_text;
            __v_raw.state_text = value;
            triggerReactiveSet(__v_raw, "state_text", oldValue, value);
        }
}
open class ChatItemResult (
    @JsonNotNull
    open var current_page: Number,
    @JsonNotNull
    open var per_page: Number,
    @JsonNotNull
    open var last_page: Number,
    @JsonNotNull
    open var total: Number,
    @JsonNotNull
    open var data: UTSArray<ChatItem>,
) : UTSObject()
fun getURL(url: String): String {
    return baseURL + url;
}
val userState = reactive(UserDetail(name = "", id = 0, username = null, avatar = "", password = false, phone = "", email = null, status = 1, age = 0, sex = 0, qg = 0, job = null, path = null, birthday = null, desc = null, wx_openid = null, wx_unionid = null, create_time = "", update_time = "", fans_count = 0, follows_count = 0, articles_count = 0, comments_count = 0, token = null));
val isConnect = ref<Boolean>(false);
val loginState = ref(false);
val client_id = ref<String>("");
val isOnline = ref<Boolean>(false);
val onlining = ref<Boolean>(false);
val current_conversation_id = ref<Number>(0);
val current_target_id = ref<Number>(0);
val total_unread_count = ref<Number>(0);
fun setCurrentConversation(conversation_id: Number, target_id: Number) {
    current_conversation_id.value = conversation_id;
    current_target_id.value = target_id;
}
fun openSocket() {
    handleBindOnline();
    if (isConnect.value) {
        return;
    }
    uni_connectSocket(ConnectSocketOptions(url = websocketURL));
    uni_onSocketOpen(fun(_){
        console.log("已连接", " at common/socket.uts:38");
        isConnect.value = true;
        resetReconnectAttempts();
    }
    );
    uni_onSocketClose(fun(res: OnSocketCloseCallbackResult){
        isConnect.value = false;
        client_id.value = "";
        isOnline.value = false;
        if (res.code == 1000) {
            console.log("websocket已干净关闭，未尝试重新连接", " at common/socket.uts:50");
        } else {
            console.log("websocket意外断开，正在尝试重新连接", " at common/socket.uts:52");
            reconnect();
        }
    }
    );
    uni_onSocketError(fun(res: OnSocketErrorCallbackResult){
        isConnect.value = false;
        client_id.value = "";
        isOnline.value = false;
        console.log("失败 socket", " at common/socket.uts:62");
        console.log(res, " at common/socket.uts:63");
    }
    );
    uni_onSocketMessage(fun(res: OnSocketMessageCallbackResult){
        console.log("消息 socket", " at common/socket.uts:68");
        var d = JSON.parse(res.data as String) as UTSJSONObject;
        val type = d.get("type") as String;
        when (type) {
            "bind" -> 
                {
                    client_id.value = d.get("data") as String;
                    handleBindOnline();
                }
            "message" -> 
                {
                    var data2 = JSON.parse<ChatItem>(JSON.stringify(d.get("data")));
                    uni__emit("onMessage", data2);
                }
            "conversation" -> 
                {
                    var data1 = JSON.parse<Conversation>(JSON.stringify(d.get("data")));
                    uni__emit("onUpdateConversation", data1);
                }
            "total_unread_count" -> 
                {
                    total_unread_count.value = d.get("data") as Number;
                    var total = total_unread_count.value;
                    if (total > 0) {
                        uni_setTabBarBadge(SetTabBarBadgeOptions(index = 2, text = if (total > 99) {
                            "99+";
                        } else {
                            total.toString();
                        }));
                    } else {
                        uni_removeTabBarBadge(RemoveTabBarBadgeOptions(index = 2));
                    }
                }
        }
    }
    );
}
fun login(data: UserDetail) {
    if (data.token != null) {
        uni_setStorageSync("user_token", data.token as String);
    }
    updateUserState(data);
    uni_setStorageSync("user_info", data);
    loginState.value = true;
    uni__emit("onUpdateConversation", null);
    openSocket();
}
fun updateUserState(data: UserDetail) {
    userState.id = data.id;
    userState.name = data.name;
    userState.username = data.username;
    userState.avatar = data.avatar;
    userState.password = data.password;
    userState.phone = data.phone;
    userState.email = data.email;
    userState.status = data.status;
    userState.age = data.age;
    userState.sex = data.sex;
    userState.qg = data.qg;
    userState.job = data.job;
    userState.path = data.path;
    userState.birthday = data.birthday;
    userState.desc = data.desc;
    userState.wx_openid = data.wx_openid;
    userState.wx_unionid = data.wx_unionid;
    userState.create_time = data.create_time;
    userState.update_time = data.update_time;
    userState.fans_count = data.fans_count;
    userState.follows_count = data.follows_count;
    userState.articles_count = data.articles_count;
    userState.comments_count = data.comments_count;
    userState.token = data.token;
}
fun getToken(): String? {
    return uni_getStorageSync("user_token") as String?;
}
fun closeSocket() {
    uni_closeSocket(CloseSocketOptions(code = 1000));
}
fun handleBindOnline() {
    if (isConnect.value && client_id.value != "" && !isOnline.value && !onlining.value) {
        onlining.value = true;
        val cid = client_id.value as String;
        uni_request<defaultResult>(RequestOptions(url = getURL("/im/bind_online"), method = "POST", header = object : UTSJSONObject() {
            var token = getToken()
        }, data = object : UTSJSONObject() {
            var client_id = cid
        }, success = fun(res){
            var r = res.data;
            if (r == null) {
                return;
            }
            if (res.statusCode != 200) {
                uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                return;
            }
            isOnline.value = true;
            console.log("用户上线", " at common/socket.uts:133");
        }
        , fail = fun(err){
            uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
        }
        , complete = fun(_){
            onlining.value = false;
        }
        ));
    }
}
fun isLogin(): Boolean {
    var token = getToken();
    return if (token == "" || token == null) {
        false;
    } else {
        true;
    }
    ;
}
fun initCurrentUser() {
    getUserInfo(true);
    if (loginState.value) {
        openSocket();
    }
}
fun getUserInfo(cache: Boolean = true) {
    if (cache) {
        uni_getStorage(GetStorageOptions(key = "user_info", success = fun(res){
            if (UTSAndroid.`typeof`( res.data) !== "object") {
                return;
            }
            var d = JSON.parse<UserDetail>(JSON.stringify(res.data));
            if (d == null) {
                return;
            }
            updateUserState(d);
            loginState.value = true;
        }
        ));
        return;
    }
    if (isLogin()) {
        var token = getToken();
        uni_request<Result<UserDetail>>(RequestOptions(url = getURL("/user/info"), header = object : UTSJSONObject() {
            var token = token
        }, success = fun(res){
            var r = res.data;
            if (r == null) {
                return;
            }
            if (res.statusCode != 200) {
                if (r.msg == "登录已失效，请重新登录") {
                    logout();
                    setTimeout(fun() {
                        uni_navigateTo(NavigateToOptions(url = "/pages/user-login/user-login"));
                    }, 300);
                } else {
                    uni_showToast(ShowToastOptions(title = r.msg, icon = "none"));
                }
                return;
            }
            if (r.data == null) {
                return;
            }
            updateUserState(r.data as UserDetail);
            loginState.value = true;
        }
        , fail = fun(err){
            uni_showToast(ShowToastOptions(title = err.errMsg, icon = "none"));
        }
        ));
    }
}
fun logout() {
    uni_removeStorageSync("user_token");
    uni_removeStorageSync("user_info");
    loginState.value = false;
    uni__emit("onUpdateConversation", null);
    closeSocket();
}
fun AuthNavigateTo(u: String) {
    val url = if (loginState.value) {
        u;
    } else {
        "/pages/user-login/user-login";
    }
    ;
    uni_navigateTo(NavigateToOptions(url = url));
}
fun updatePhoneAndName(data: UserDetail) {
    userState.phone = data.phone;
    userState.name = data.name;
    uni_setStorageSync("user_info", userState);
}
fun updatePassword() {
    userState.password = true;
    uni_setStorageSync("user_info", userState);
}
fun AuthAction(callback: () -> Unit) {
    if (loginState.value) {
        callback();
        return;
    }
    uni_navigateTo(NavigateToOptions(url = "/pages/user-login/user-login"));
}
fun updateUserStateAvatar(src: String) {
    userState.avatar = src;
    uni_setStorageSync("user_info", userState);
}
fun updateInfo(data: UserDetail) {
    userState.name = data.name;
    userState.username = data.username;
    userState.age = data.age;
    userState.sex = data.sex;
    userState.qg = data.qg;
    userState.path = data.path;
    userState.birthday = data.birthday;
    userState.desc = data.desc;
    uni_setStorageSync("user_info", userState);
}
var reconnectAttemptCount = ref<Number>(0);
var reconnectAttempts: Number = 5;
var reconnectInterval: Number = 0;
fun reconnect(): Unit {
    console.log("重连中...", " at common/socket.uts:157");
    if (reconnectAttemptCount.value < reconnectAttempts) {
        reconnectAttemptCount.value++;
        reconnectInterval = setTimeout(fun(){
            openSocket();
        }, getReconnectDelay(reconnectAttemptCount.value));
    } else {
        console.log("已经达到最大重连尝试次数", " at common/socket.uts:167");
    }
}
fun getReconnectDelay(attempt: Number): Number {
    val baseDelay: Number = 1000;
    val maxDelay: Number = 10000;
    val delay = baseDelay * (2 * attempt) + Math.random() * 1000;
    return Math.min(delay, maxDelay);
}
fun resetReconnectAttempts(): Unit {
    if (reconnectInterval > 0) {
        clearInterval(reconnectInterval);
        reconnectInterval = 0;
    }
    reconnectAttemptCount.value = 0;
}
var firstBackTime: Number = 0;
open class GenApp : BaseApp {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLaunch(fun(_: OnLaunchOptions) {
            console.log("App Launch", " at App.uvue:6");
        }
        , instance);
        onAppShow(fun(_: OnShowOptions) {
            console.log("App Show", " at App.uvue:9");
            initCurrentUser();
        }
        , instance);
        onHide(fun() {
            console.log("App Hide", " at App.uvue:14");
        }
        , instance);
        onLastPageBackPress(fun() {
            console.log("App LastPageBackPress", " at App.uvue:18");
            if (firstBackTime == 0) {
                uni_showToast(ShowToastOptions(title = "再按一次退出应用", position = "bottom"));
                firstBackTime = Date.now();
                setTimeout(fun(){
                    firstBackTime = 0;
                }, 2000);
            } else if (Date.now() - firstBackTime < 2000) {
                firstBackTime = Date.now();
                uni_exit(null);
            }
        }
        , instance);
        onExit(fun() {
            console.log("App Exit", " at App.uvue:35");
        }
        , instance);
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("iconfont" to padStyleMapOf(utsMapOf("!fontFamily" to "iconfont", "fontSize" to 16, "fontStyle" to "normal")), "flex" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row")), "flex-1" to padStyleMapOf(utsMapOf("flex" to 1)), "flex-center" to padStyleMapOf(utsMapOf("alignItems" to "center", "justifyContent" to "center", "display" to "flex")), "divider" to padStyleMapOf(utsMapOf("backgroundColor" to "#f3f3f3", "width" to "750rpx", "height" to "17rpx")), "login-page" to padStyleMapOf(utsMapOf("flex" to 1, "paddingTop" to 0, "paddingRight" to "48rpx", "paddingBottom" to 0, "paddingLeft" to "48rpx")), "login-title" to padStyleMapOf(utsMapOf("marginTop" to "70rpx", "fontSize" to 30, "fontWeight" to "bold")), "login-bottom" to padStyleMapOf(utsMapOf("position" to "fixed", "left" to 0, "bottom" to 0, "right" to 0)), "input-tip" to padStyleMapOf(utsMapOf("color" to "#8d8d8d", "fontSize" to 12, "marginTop" to "25rpx", "lineHeight" to 1.5)), "@FONT-FACE" to utsMapOf("0" to utsMapOf("fontFamily" to "iconfont", "src" to "url('/static/iconfont.ttf')")));
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "app", name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = utsArrayOf(), emits = Map(), components = Map(), styles = GenApp.styles);
}
, fun(instance): GenApp {
    return GenApp(instance);
}
);
open class StoreListItem (
    @JsonNotNull
    open var enable: Boolean = false,
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var scheme: String,
    @JsonNotNull
    open var priority: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return StoreListItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class StoreListItemReactiveObject : StoreListItem, IUTSReactive<StoreListItem> {
    override var __v_raw: StoreListItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: StoreListItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(enable = __v_raw.enable, id = __v_raw.id, name = __v_raw.name, scheme = __v_raw.scheme, priority = __v_raw.priority) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): StoreListItemReactiveObject {
        return StoreListItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var enable: Boolean
        get() {
            return trackReactiveGet(__v_raw, "enable", __v_raw.enable, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("enable")) {
                return;
            }
            val oldValue = __v_raw.enable;
            __v_raw.enable = value;
            triggerReactiveSet(__v_raw, "enable", oldValue, value);
        }
    override var id: String
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var name: String
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var scheme: String
        get() {
            return trackReactiveGet(__v_raw, "scheme", __v_raw.scheme, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("scheme")) {
                return;
            }
            val oldValue = __v_raw.scheme;
            __v_raw.scheme = value;
            triggerReactiveSet(__v_raw, "scheme", oldValue, value);
        }
    override var priority: Number
        get() {
            return trackReactiveGet(__v_raw, "priority", __v_raw.priority, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("priority")) {
                return;
            }
            val oldValue = __v_raw.priority;
            __v_raw.priority = value;
            triggerReactiveSet(__v_raw, "priority", oldValue, value);
        }
}
open class UniUpgradeCenterResult (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var appid: String,
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var contents: String,
    @JsonNotNull
    open var url: String,
    @JsonNotNull
    open var platform: UTSArray<String>,
    @JsonNotNull
    open var version: String,
    @JsonNotNull
    open var uni_platform: String,
    @JsonNotNull
    open var stable_publish: Boolean = false,
    @JsonNotNull
    open var is_mandatory: Boolean = false,
    @JsonNotNull
    open var is_silently: Boolean = false,
    @JsonNotNull
    open var create_env: String,
    open var create_time: String? = null,
    open var update_time: String? = null,
    @JsonNotNull
    open var message: String,
    @JsonNotNull
    open var code: Number,
    @JsonNotNull
    open var type: String,
    open var store_list: UTSArray<StoreListItem>? = null,
    open var min_uni_version: String? = null,
) : UTSObject()
open class CheckVersionResult (
    @JsonNotNull
    open var code: Number,
    open var data: UniUpgradeCenterResult? = null,
    @JsonNotNull
    open var msg: String,
) : UTSObject()
fun `default`(): UTSPromise<UniUpgradeCenterResult> {
    return UTSPromise<UniUpgradeCenterResult>(fun(resolve, reject){
        val systemInfo = uni_getSystemInfoSync();
        val appId = systemInfo.appId;
        val appVersion = systemInfo.appVersion;
        if (UTSAndroid.`typeof`( appId) === "string" && UTSAndroid.`typeof`( appVersion) === "string" && appId.length > 0 && appVersion.length > 0) {
            try {
                var data = object : UTSJSONObject() {
                    var appid = appId
                    var appVersion = appVersion
                    var wgtVersion = "0.0.0.0.0.1"
                    var platform = systemInfo.platform
                };
                uni_request<CheckVersionResult>(RequestOptions(url = baseURL + "/upgradation", method = "POST", data = data, success = fun(res){
                    var r = res.data;
                    if (r == null) {
                        return reject(object : UTSJSONObject() {
                            var code: Number = 0
                            var message = "未知错误"
                        });
                    }
                    if (r.data != null) {
                        var d = r.data as UniUpgradeCenterResult;
                        if (r.code == 0) {
                            reject(object : UTSJSONObject() {
                                var code = d.code
                                var message = d.message
                            });
                        } else {
                            resolve(d);
                        }
                    } else {
                        reject(object : UTSJSONObject() {
                            var code = r.code
                            var message = r.msg
                        });
                    }
                }, fail = fun(err){
                    console.log(err, " at uni_modules/uni-upgrade-center-app/utils/call-check-version.ts:86");
                    reject(object : UTSJSONObject() {
                        var code: Number = 0
                        var message = err.errMsg
                    });
                }));
            } catch (e: Throwable) {
                reject(e.message);
            }
        } else {
            reject("invalid appid or appVersion");
        }
    }
    );
}
fun openSchema(url: String): UTSPromise<Boolean> {
    return UTSPromise<Boolean>(fun(resolve, reject){
        try {
            val context = UTSAndroid.getUniActivity()!!;
            val uri = Uri.parse(url);
            val intent = Intent(Intent.ACTION_VIEW, uri);
            intent.setData(uri);
            context.startActivity(intent);
            resolve(true);
        }
         catch (e: Throwable) {
            reject(e);
        }
    }
    );
}
fun default1(component: ComponentPublicInstance? = null): UTSPromise<UniUpgradeCenterResult> {
    return UTSPromise<UniUpgradeCenterResult>(fun(resolve, reject){
        `default`().then(fun(uniUpgradeCenterResult): UTSPromise<Unit> {
            suspend fun async(): Unit {
                val code = uniUpgradeCenterResult.code;
                val message = uniUpgradeCenterResult.message;
                if (code > 0) {
                    component?.`$callMethod`("show", true, uniUpgradeCenterResult);
                    return resolve(uniUpgradeCenterResult);
                } else if (code < 0) {
                    console.error(message, " at uni_modules/uni-upgrade-center-app/utils/check-update.ts:25");
                    return reject(uniUpgradeCenterResult);
                }
                return resolve(uniUpgradeCenterResult);
            }
            return UTSPromise(fun(resolve, reject) {
                kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                    try {
                        val result = async();
                        resolve(result);
                    }
                     catch (e: Throwable) {
                        reject(e);
                    }
                }
                ;
            }
            );
        }
        ).`catch`(fun(err){
            reject(err);
        }
        );
    }
    );
}
open class TabsSwiperItem (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var type: String,
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var preload: Boolean = false,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return TabsSwiperItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class TabsSwiperItemReactiveObject : TabsSwiperItem, IUTSReactive<TabsSwiperItem> {
    override var __v_raw: TabsSwiperItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: TabsSwiperItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, type = __v_raw.type, name = __v_raw.name, preload = __v_raw.preload) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): TabsSwiperItemReactiveObject {
        return TabsSwiperItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var type: String
        get() {
            return trackReactiveGet(__v_raw, "type", __v_raw.type, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("type")) {
                return;
            }
            val oldValue = __v_raw.type;
            __v_raw.type = value;
            triggerReactiveSet(__v_raw, "type", oldValue, value);
        }
    override var name: String
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var preload: Boolean
        get() {
            return trackReactiveGet(__v_raw, "preload", __v_raw.preload, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("preload")) {
                return;
            }
            val oldValue = __v_raw.preload;
            __v_raw.preload = value;
            triggerReactiveSet(__v_raw, "preload", oldValue, value);
        }
}
val GenComponentsSkeletonSkeletonClass = CreateVueComponent(GenComponentsSkeletonSkeleton::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsSkeletonSkeleton.name, inheritAttrs = GenComponentsSkeletonSkeleton.inheritAttrs, inject = GenComponentsSkeletonSkeleton.inject, props = GenComponentsSkeletonSkeleton.props, propsNeedCastKeys = GenComponentsSkeletonSkeleton.propsNeedCastKeys, emits = GenComponentsSkeletonSkeleton.emits, components = GenComponentsSkeletonSkeleton.components, styles = GenComponentsSkeletonSkeleton.styles);
}
, fun(instance): GenComponentsSkeletonSkeleton {
    return GenComponentsSkeletonSkeleton(instance);
}
);
val GenComponentsMainBtnMainBtnClass = CreateVueComponent(GenComponentsMainBtnMainBtn::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsMainBtnMainBtn.name, inheritAttrs = GenComponentsMainBtnMainBtn.inheritAttrs, inject = GenComponentsMainBtnMainBtn.inject, props = GenComponentsMainBtnMainBtn.props, propsNeedCastKeys = GenComponentsMainBtnMainBtn.propsNeedCastKeys, emits = GenComponentsMainBtnMainBtn.emits, components = GenComponentsMainBtnMainBtn.components, styles = GenComponentsMainBtnMainBtn.styles);
}
, fun(instance): GenComponentsMainBtnMainBtn {
    return GenComponentsMainBtnMainBtn(instance);
}
);
val default2 = UTSAndroid.getResourcePath("static/empty.png");
val GenComponentsTipTipClass = CreateVueComponent(GenComponentsTipTip::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsTipTip.name, inheritAttrs = GenComponentsTipTip.inheritAttrs, inject = GenComponentsTipTip.inject, props = GenComponentsTipTip.props, propsNeedCastKeys = GenComponentsTipTip.propsNeedCastKeys, emits = GenComponentsTipTip.emits, components = GenComponentsTipTip.components, styles = GenComponentsTipTip.styles);
}
, fun(instance): GenComponentsTipTip {
    return GenComponentsTipTip(instance);
}
);
fun isValidPhoneNumber(phone: String): Boolean {
    val regex = UTSRegExp("^1[34578]\\d{9}\$", "");
    return regex.test(phone);
}
fun stepInt(value: Number, action: String = "+", step: Number = 1): Number {
    var v: Number = 0;
    if (action == "+") {
        v = Math.floor(value + step);
    } else if (action == "-") {
        v = Math.floor(value - step);
        if (v < 0) {
            v = 0;
        }
    }
    return v;
}
fun generateUniqueId(): String {
    var timestamp = Date.now().toString();
    var randomNum = Math.floor(Math.random() * 1000000);
    return timestamp + randomNum.toString();
}
val sexOptions = utsArrayOf<String>("不限", "男", "女");
fun getSexText(sex: Number): String {
    return sexOptions[sex];
}
val emotionOptions = utsArrayOf<String>("不限", "未婚", "已婚");
fun getEmotionText(qg: Number): String {
    return emotionOptions[qg];
}
val GenComponentsAvatarAvatarClass = CreateVueComponent(GenComponentsAvatarAvatar::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsAvatarAvatar.name, inheritAttrs = GenComponentsAvatarAvatar.inheritAttrs, inject = GenComponentsAvatarAvatar.inject, props = GenComponentsAvatarAvatar.props, propsNeedCastKeys = GenComponentsAvatarAvatar.propsNeedCastKeys, emits = GenComponentsAvatarAvatar.emits, components = GenComponentsAvatarAvatar.components, styles = GenComponentsAvatarAvatar.styles);
}
, fun(instance): GenComponentsAvatarAvatar {
    return GenComponentsAvatarAvatar(instance);
}
);
val GenComponentsFollowButtonFollowButtonClass = CreateVueComponent(GenComponentsFollowButtonFollowButton::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsFollowButtonFollowButton.name, inheritAttrs = GenComponentsFollowButtonFollowButton.inheritAttrs, inject = GenComponentsFollowButtonFollowButton.inject, props = GenComponentsFollowButtonFollowButton.props, propsNeedCastKeys = GenComponentsFollowButtonFollowButton.propsNeedCastKeys, emits = GenComponentsFollowButtonFollowButton.emits, components = GenComponentsFollowButtonFollowButton.components, styles = GenComponentsFollowButtonFollowButton.styles);
}
, fun(instance): GenComponentsFollowButtonFollowButton {
    return GenComponentsFollowButtonFollowButton(instance);
}
);
val GenComponentsIconBtnIconBtnClass = CreateVueComponent(GenComponentsIconBtnIconBtn::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsIconBtnIconBtn.name, inheritAttrs = GenComponentsIconBtnIconBtn.inheritAttrs, inject = GenComponentsIconBtnIconBtn.inject, props = GenComponentsIconBtnIconBtn.props, propsNeedCastKeys = GenComponentsIconBtnIconBtn.propsNeedCastKeys, emits = GenComponentsIconBtnIconBtn.emits, components = GenComponentsIconBtnIconBtn.components, styles = GenComponentsIconBtnIconBtn.styles);
}
, fun(instance): GenComponentsIconBtnIconBtn {
    return GenComponentsIconBtnIconBtn(instance);
}
);
val GenComponentsArticleListItemArticleListItemClass = CreateVueComponent(GenComponentsArticleListItemArticleListItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsArticleListItemArticleListItem.name, inheritAttrs = GenComponentsArticleListItemArticleListItem.inheritAttrs, inject = GenComponentsArticleListItemArticleListItem.inject, props = GenComponentsArticleListItemArticleListItem.props, propsNeedCastKeys = GenComponentsArticleListItemArticleListItem.propsNeedCastKeys, emits = GenComponentsArticleListItemArticleListItem.emits, components = GenComponentsArticleListItemArticleListItem.components, styles = GenComponentsArticleListItemArticleListItem.styles);
}
, fun(instance): GenComponentsArticleListItemArticleListItem {
    return GenComponentsArticleListItemArticleListItem(instance);
}
);
val GenComponentsUserListItemUserListItemClass = CreateVueComponent(GenComponentsUserListItemUserListItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsUserListItemUserListItem.name, inheritAttrs = GenComponentsUserListItemUserListItem.inheritAttrs, inject = GenComponentsUserListItemUserListItem.inject, props = GenComponentsUserListItemUserListItem.props, propsNeedCastKeys = GenComponentsUserListItemUserListItem.propsNeedCastKeys, emits = GenComponentsUserListItemUserListItem.emits, components = GenComponentsUserListItemUserListItem.components, styles = GenComponentsUserListItemUserListItem.styles);
}
, fun(instance): GenComponentsUserListItemUserListItem {
    return GenComponentsUserListItemUserListItem(instance);
}
);
val GenComponentsTopicListItemTopicListItemClass = CreateVueComponent(GenComponentsTopicListItemTopicListItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsTopicListItemTopicListItem.name, inheritAttrs = GenComponentsTopicListItemTopicListItem.inheritAttrs, inject = GenComponentsTopicListItemTopicListItem.inject, props = GenComponentsTopicListItemTopicListItem.props, propsNeedCastKeys = GenComponentsTopicListItemTopicListItem.propsNeedCastKeys, emits = GenComponentsTopicListItemTopicListItem.emits, components = GenComponentsTopicListItemTopicListItem.components, styles = GenComponentsTopicListItemTopicListItem.styles);
}
, fun(instance): GenComponentsTopicListItemTopicListItem {
    return GenComponentsTopicListItemTopicListItem(instance);
}
);
val GenComponentsCommentListItemCommentListItemClass = CreateVueComponent(GenComponentsCommentListItemCommentListItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsCommentListItemCommentListItem.name, inheritAttrs = GenComponentsCommentListItemCommentListItem.inheritAttrs, inject = GenComponentsCommentListItemCommentListItem.inject, props = GenComponentsCommentListItemCommentListItem.props, propsNeedCastKeys = GenComponentsCommentListItemCommentListItem.propsNeedCastKeys, emits = GenComponentsCommentListItemCommentListItem.emits, components = GenComponentsCommentListItemCommentListItem.components, styles = GenComponentsCommentListItemCommentListItem.styles);
}
, fun(instance): GenComponentsCommentListItemCommentListItem {
    return GenComponentsCommentListItemCommentListItem(instance);
}
);
val GenComponentsLoadingMoreLoadingMoreClass = CreateVueComponent(GenComponentsLoadingMoreLoadingMore::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsLoadingMoreLoadingMore.name, inheritAttrs = GenComponentsLoadingMoreLoadingMore.inheritAttrs, inject = GenComponentsLoadingMoreLoadingMore.inject, props = GenComponentsLoadingMoreLoadingMore.props, propsNeedCastKeys = GenComponentsLoadingMoreLoadingMore.propsNeedCastKeys, emits = GenComponentsLoadingMoreLoadingMore.emits, components = GenComponentsLoadingMoreLoadingMore.components, styles = GenComponentsLoadingMoreLoadingMore.styles);
}
, fun(instance): GenComponentsLoadingMoreLoadingMore {
    return GenComponentsLoadingMoreLoadingMore(instance);
}
);
val GenPagesLongListLongListPageClass = CreateVueComponent(GenPagesLongListLongListPage::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenPagesLongListLongListPage.inheritAttrs, inject = GenPagesLongListLongListPage.inject, props = GenPagesLongListLongListPage.props, propsNeedCastKeys = GenPagesLongListLongListPage.propsNeedCastKeys, emits = GenPagesLongListLongListPage.emits, components = GenPagesLongListLongListPage.components, styles = GenPagesLongListLongListPage.styles);
}
, fun(instance): GenPagesLongListLongListPage {
    return GenPagesLongListLongListPage(instance);
}
);
val GenComponentsStatusBarStatusBarClass = CreateVueComponent(GenComponentsStatusBarStatusBar::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsStatusBarStatusBar.name, inheritAttrs = GenComponentsStatusBarStatusBar.inheritAttrs, inject = GenComponentsStatusBarStatusBar.inject, props = GenComponentsStatusBarStatusBar.props, propsNeedCastKeys = GenComponentsStatusBarStatusBar.propsNeedCastKeys, emits = GenComponentsStatusBarStatusBar.emits, components = GenComponentsStatusBarStatusBar.components, styles = GenComponentsStatusBarStatusBar.styles);
}
, fun(instance): GenComponentsStatusBarStatusBar {
    return GenComponentsStatusBarStatusBar(instance);
}
);
fun lerpNumber(value1: Number, value2: Number, amount: Number): Number {
    return (value1 + (value2 - value1) * amount);
}
val GenComponentsTabsSwiperTabsSwiperClass = CreateVueComponent(GenComponentsTabsSwiperTabsSwiper::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsTabsSwiperTabsSwiper.inheritAttrs, inject = GenComponentsTabsSwiperTabsSwiper.inject, props = GenComponentsTabsSwiperTabsSwiper.props, propsNeedCastKeys = GenComponentsTabsSwiperTabsSwiper.propsNeedCastKeys, emits = GenComponentsTabsSwiperTabsSwiper.emits, components = GenComponentsTabsSwiperTabsSwiper.components, styles = GenComponentsTabsSwiperTabsSwiper.styles);
}
, fun(instance): GenComponentsTabsSwiperTabsSwiper {
    return GenComponentsTabsSwiperTabsSwiper(instance);
}
);
val GenComponentsAddPostBtnAddPostBtnClass = CreateVueComponent(GenComponentsAddPostBtnAddPostBtn::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsAddPostBtnAddPostBtn.name, inheritAttrs = GenComponentsAddPostBtnAddPostBtn.inheritAttrs, inject = GenComponentsAddPostBtnAddPostBtn.inject, props = GenComponentsAddPostBtnAddPostBtn.props, propsNeedCastKeys = GenComponentsAddPostBtnAddPostBtn.propsNeedCastKeys, emits = GenComponentsAddPostBtnAddPostBtn.emits, components = GenComponentsAddPostBtnAddPostBtn.components, styles = GenComponentsAddPostBtnAddPostBtn.styles);
}
, fun(instance): GenComponentsAddPostBtnAddPostBtn {
    return GenComponentsAddPostBtnAddPostBtn(instance);
}
);
val platform_iOS = "iOS";
val platform_Android = "Android";
val requiredKey = utsArrayOf(
    "version",
    "url",
    "type"
);
var downloadTask: DownloadTask? = null;
var openSchemePromise: UTSPromise<Boolean>? = null;
val GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterAppClass = CreateVueComponent(GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp.inheritAttrs, inject = GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp.inject, props = GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp.props, propsNeedCastKeys = GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp.propsNeedCastKeys, emits = GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp.emits, components = GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp.components, styles = GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp.styles);
}
, fun(instance): GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp {
    return GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterApp(instance);
}
);
val GenPagesIndexIndexClass = CreateVueComponent(GenPagesIndexIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexIndex.inheritAttrs, inject = GenPagesIndexIndex.inject, props = GenPagesIndexIndex.props, propsNeedCastKeys = GenPagesIndexIndex.propsNeedCastKeys, emits = GenPagesIndexIndex.emits, components = GenPagesIndexIndex.components, styles = GenPagesIndexIndex.styles);
}
, fun(instance): GenPagesIndexIndex {
    return GenPagesIndexIndex(instance);
}
);
val default3 = UTSAndroid.getResourcePath("static/loading1.gif");
val default4 = UTSAndroid.getResourcePath("static/loading2.gif");
val GenComponentsLoadingLoadingClass = CreateVueComponent(GenComponentsLoadingLoading::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsLoadingLoading.name, inheritAttrs = GenComponentsLoadingLoading.inheritAttrs, inject = GenComponentsLoadingLoading.inject, props = GenComponentsLoadingLoading.props, propsNeedCastKeys = GenComponentsLoadingLoading.propsNeedCastKeys, emits = GenComponentsLoadingLoading.emits, components = GenComponentsLoadingLoading.components, styles = GenComponentsLoadingLoading.styles);
}
, fun(instance): GenComponentsLoadingLoading {
    return GenComponentsLoadingLoading(instance);
}
);
val GenPagesTopicTopicClass = CreateVueComponent(GenPagesTopicTopic::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesTopicTopic.inheritAttrs, inject = GenPagesTopicTopic.inject, props = GenPagesTopicTopic.props, propsNeedCastKeys = GenPagesTopicTopic.propsNeedCastKeys, emits = GenPagesTopicTopic.emits, components = GenPagesTopicTopic.components, styles = GenPagesTopicTopic.styles);
}
, fun(instance): GenPagesTopicTopic {
    return GenPagesTopicTopic(instance);
}
);
val GenPagesMsgMsgClass = CreateVueComponent(GenPagesMsgMsg::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesMsgMsg.inheritAttrs, inject = GenPagesMsgMsg.inject, props = GenPagesMsgMsg.props, propsNeedCastKeys = GenPagesMsgMsg.propsNeedCastKeys, emits = GenPagesMsgMsg.emits, components = GenPagesMsgMsg.components, styles = GenPagesMsgMsg.styles);
}
, fun(instance): GenPagesMsgMsg {
    return GenPagesMsgMsg(instance);
}
);
val GenComponentsCellCellClass = CreateVueComponent(GenComponentsCellCell::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsCellCell.name, inheritAttrs = GenComponentsCellCell.inheritAttrs, inject = GenComponentsCellCell.inject, props = GenComponentsCellCell.props, propsNeedCastKeys = GenComponentsCellCell.propsNeedCastKeys, emits = GenComponentsCellCell.emits, components = GenComponentsCellCell.components, styles = GenComponentsCellCell.styles);
}
, fun(instance): GenComponentsCellCell {
    return GenComponentsCellCell(instance);
}
);
val default5 = UTSAndroid.getResourcePath("static/nologin-image.png");
val default6 = UTSAndroid.getResourcePath("static/view-list.png");
val default7 = UTSAndroid.getResourcePath("static/message.png");
val default8 = UTSAndroid.getResourcePath("static/star.png");
open class AdsenseItem (
    @JsonNotNull
    open var src: String,
    @JsonNotNull
    open var url: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return AdsenseItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class AdsenseItemReactiveObject : AdsenseItem, IUTSReactive<AdsenseItem> {
    override var __v_raw: AdsenseItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: AdsenseItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(src = __v_raw.src, url = __v_raw.url) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): AdsenseItemReactiveObject {
        return AdsenseItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var src: String
        get() {
            return trackReactiveGet(__v_raw, "src", __v_raw.src, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("src")) {
                return;
            }
            val oldValue = __v_raw.src;
            __v_raw.src = value;
            triggerReactiveSet(__v_raw, "src", oldValue, value);
        }
    override var url: String
        get() {
            return trackReactiveGet(__v_raw, "url", __v_raw.url, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("url")) {
                return;
            }
            val oldValue = __v_raw.url;
            __v_raw.url = value;
            triggerReactiveSet(__v_raw, "url", oldValue, value);
        }
}
val GenPagesMyMyClass = CreateVueComponent(GenPagesMyMy::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesMyMy.inheritAttrs, inject = GenPagesMyMy.inject, props = GenPagesMyMy.props, propsNeedCastKeys = GenPagesMyMy.propsNeedCastKeys, emits = GenPagesMyMy.emits, components = GenPagesMyMy.components, styles = GenPagesMyMy.styles);
}
, fun(instance): GenPagesMyMy {
    return GenPagesMyMy(instance);
}
);
open class tab (
    @JsonNotNull
    open var type: String,
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var id: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return tabReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class tabReactiveObject : tab, IUTSReactive<tab> {
    override var __v_raw: tab;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: tab, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(type = __v_raw.type, name = __v_raw.name, id = __v_raw.id) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): tabReactiveObject {
        return tabReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var type: String
        get() {
            return trackReactiveGet(__v_raw, "type", __v_raw.type, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("type")) {
                return;
            }
            val oldValue = __v_raw.type;
            __v_raw.type = value;
            triggerReactiveSet(__v_raw, "type", oldValue, value);
        }
    override var name: String
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return;
            }
            val oldValue = __v_raw.name;
            __v_raw.name = value;
            triggerReactiveSet(__v_raw, "name", oldValue, value);
        }
    override var id: String
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
}
open class TopicDetail (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var cover: String,
    @JsonNotNull
    open var desc: String,
    open var create_time: String? = null,
    open var update_time: String? = null,
    @JsonNotNull
    open var category_id: Number,
    @JsonNotNull
    open var article_count: Number,
    @JsonNotNull
    open var today_article_count: Number,
    open var category_name: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return TopicDetailReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class TopicDetailReactiveObject : TopicDetail, IUTSReactive<TopicDetail> {
    override var __v_raw: TopicDetail;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: TopicDetail, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, title = __v_raw.title, cover = __v_raw.cover, desc = __v_raw.desc, create_time = __v_raw.create_time, update_time = __v_raw.update_time, category_id = __v_raw.category_id, article_count = __v_raw.article_count, today_article_count = __v_raw.today_article_count, category_name = __v_raw.category_name) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): TopicDetailReactiveObject {
        return TopicDetailReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: Number
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var title: String
        get() {
            return trackReactiveGet(__v_raw, "title", __v_raw.title, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("title")) {
                return;
            }
            val oldValue = __v_raw.title;
            __v_raw.title = value;
            triggerReactiveSet(__v_raw, "title", oldValue, value);
        }
    override var cover: String
        get() {
            return trackReactiveGet(__v_raw, "cover", __v_raw.cover, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("cover")) {
                return;
            }
            val oldValue = __v_raw.cover;
            __v_raw.cover = value;
            triggerReactiveSet(__v_raw, "cover", oldValue, value);
        }
    override var desc: String
        get() {
            return trackReactiveGet(__v_raw, "desc", __v_raw.desc, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("desc")) {
                return;
            }
            val oldValue = __v_raw.desc;
            __v_raw.desc = value;
            triggerReactiveSet(__v_raw, "desc", oldValue, value);
        }
    override var create_time: String?
        get() {
            return trackReactiveGet(__v_raw, "create_time", __v_raw.create_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("create_time")) {
                return;
            }
            val oldValue = __v_raw.create_time;
            __v_raw.create_time = value;
            triggerReactiveSet(__v_raw, "create_time", oldValue, value);
        }
    override var update_time: String?
        get() {
            return trackReactiveGet(__v_raw, "update_time", __v_raw.update_time, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("update_time")) {
                return;
            }
            val oldValue = __v_raw.update_time;
            __v_raw.update_time = value;
            triggerReactiveSet(__v_raw, "update_time", oldValue, value);
        }
    override var category_id: Number
        get() {
            return trackReactiveGet(__v_raw, "category_id", __v_raw.category_id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("category_id")) {
                return;
            }
            val oldValue = __v_raw.category_id;
            __v_raw.category_id = value;
            triggerReactiveSet(__v_raw, "category_id", oldValue, value);
        }
    override var article_count: Number
        get() {
            return trackReactiveGet(__v_raw, "article_count", __v_raw.article_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("article_count")) {
                return;
            }
            val oldValue = __v_raw.article_count;
            __v_raw.article_count = value;
            triggerReactiveSet(__v_raw, "article_count", oldValue, value);
        }
    override var today_article_count: Number
        get() {
            return trackReactiveGet(__v_raw, "today_article_count", __v_raw.today_article_count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("today_article_count")) {
                return;
            }
            val oldValue = __v_raw.today_article_count;
            __v_raw.today_article_count = value;
            triggerReactiveSet(__v_raw, "today_article_count", oldValue, value);
        }
    override var category_name: String?
        get() {
            return trackReactiveGet(__v_raw, "category_name", __v_raw.category_name, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("category_name")) {
                return;
            }
            val oldValue = __v_raw.category_name;
            __v_raw.category_name = value;
            triggerReactiveSet(__v_raw, "category_name", oldValue, value);
        }
}
val GenPagesTopicDetailTopicDetailClass = CreateVueComponent(GenPagesTopicDetailTopicDetail::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesTopicDetailTopicDetail.inheritAttrs, inject = GenPagesTopicDetailTopicDetail.inject, props = GenPagesTopicDetailTopicDetail.props, propsNeedCastKeys = GenPagesTopicDetailTopicDetail.propsNeedCastKeys, emits = GenPagesTopicDetailTopicDetail.emits, components = GenPagesTopicDetailTopicDetail.components, styles = GenPagesTopicDetailTopicDetail.styles);
}
, fun(instance): GenPagesTopicDetailTopicDetail {
    return GenPagesTopicDetailTopicDetail(instance);
}
);
val GenPagesWebviewWebviewClass = CreateVueComponent(GenPagesWebviewWebview::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWebviewWebview.inheritAttrs, inject = GenPagesWebviewWebview.inject, props = GenPagesWebviewWebview.props, propsNeedCastKeys = GenPagesWebviewWebview.propsNeedCastKeys, emits = GenPagesWebviewWebview.emits, components = GenPagesWebviewWebview.components, styles = GenPagesWebviewWebview.styles);
}
, fun(instance): GenPagesWebviewWebview {
    return GenPagesWebviewWebview(instance);
}
);
open class LeftIcons (
    @JsonNotNull
    open var more: String,
    @JsonNotNull
    open var back: String,
    @JsonNotNull
    open var close: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return LeftIconsReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class LeftIconsReactiveObject : LeftIcons, IUTSReactive<LeftIcons> {
    override var __v_raw: LeftIcons;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: LeftIcons, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(more = __v_raw.more, back = __v_raw.back, close = __v_raw.close) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): LeftIconsReactiveObject {
        return LeftIconsReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var more: String
        get() {
            return trackReactiveGet(__v_raw, "more", __v_raw.more, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("more")) {
                return;
            }
            val oldValue = __v_raw.more;
            __v_raw.more = value;
            triggerReactiveSet(__v_raw, "more", oldValue, value);
        }
    override var back: String
        get() {
            return trackReactiveGet(__v_raw, "back", __v_raw.back, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("back")) {
                return;
            }
            val oldValue = __v_raw.back;
            __v_raw.back = value;
            triggerReactiveSet(__v_raw, "back", oldValue, value);
        }
    override var close: String
        get() {
            return trackReactiveGet(__v_raw, "close", __v_raw.close, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("close")) {
                return;
            }
            val oldValue = __v_raw.close;
            __v_raw.close = value;
            triggerReactiveSet(__v_raw, "close", oldValue, value);
        }
}
val GenComponentsNavbarNavbarClass = CreateVueComponent(GenComponentsNavbarNavbar::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsNavbarNavbar.name, inheritAttrs = GenComponentsNavbarNavbar.inheritAttrs, inject = GenComponentsNavbarNavbar.inject, props = GenComponentsNavbarNavbar.props, propsNeedCastKeys = GenComponentsNavbarNavbar.propsNeedCastKeys, emits = GenComponentsNavbarNavbar.emits, components = GenComponentsNavbarNavbar.components, styles = GenComponentsNavbarNavbar.styles);
}
, fun(instance): GenComponentsNavbarNavbar {
    return GenComponentsNavbarNavbar(instance);
}
);
val GenComponentsLoginInputLoginInputClass = CreateVueComponent(GenComponentsLoginInputLoginInput::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsLoginInputLoginInput.name, inheritAttrs = GenComponentsLoginInputLoginInput.inheritAttrs, inject = GenComponentsLoginInputLoginInput.inject, props = GenComponentsLoginInputLoginInput.props, propsNeedCastKeys = GenComponentsLoginInputLoginInput.propsNeedCastKeys, emits = GenComponentsLoginInputLoginInput.emits, components = GenComponentsLoginInputLoginInput.components, styles = GenComponentsLoginInputLoginInput.styles);
}
, fun(instance): GenComponentsLoginInputLoginInput {
    return GenComponentsLoginInputLoginInput(instance);
}
);
val GenComponentsAgreementAgreementClass = CreateVueComponent(GenComponentsAgreementAgreement::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsAgreementAgreement.name, inheritAttrs = GenComponentsAgreementAgreement.inheritAttrs, inject = GenComponentsAgreementAgreement.inject, props = GenComponentsAgreementAgreement.props, propsNeedCastKeys = GenComponentsAgreementAgreement.propsNeedCastKeys, emits = GenComponentsAgreementAgreement.emits, components = GenComponentsAgreementAgreement.components, styles = GenComponentsAgreementAgreement.styles);
}
, fun(instance): GenComponentsAgreementAgreement {
    return GenComponentsAgreementAgreement(instance);
}
);
val GenPagesUserLoginUserLoginClass = CreateVueComponent(GenPagesUserLoginUserLogin::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserLoginUserLogin.inheritAttrs, inject = GenPagesUserLoginUserLogin.inject, props = GenPagesUserLoginUserLogin.props, propsNeedCastKeys = GenPagesUserLoginUserLogin.propsNeedCastKeys, emits = GenPagesUserLoginUserLogin.emits, components = GenPagesUserLoginUserLogin.components, styles = GenPagesUserLoginUserLogin.styles);
}
, fun(instance): GenPagesUserLoginUserLogin {
    return GenPagesUserLoginUserLogin(instance);
}
);
val GenPagesUserLoginPasswordUserLoginPasswordClass = CreateVueComponent(GenPagesUserLoginPasswordUserLoginPassword::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserLoginPasswordUserLoginPassword.inheritAttrs, inject = GenPagesUserLoginPasswordUserLoginPassword.inject, props = GenPagesUserLoginPasswordUserLoginPassword.props, propsNeedCastKeys = GenPagesUserLoginPasswordUserLoginPassword.propsNeedCastKeys, emits = GenPagesUserLoginPasswordUserLoginPassword.emits, components = GenPagesUserLoginPasswordUserLoginPassword.components, styles = GenPagesUserLoginPasswordUserLoginPassword.styles);
}
, fun(instance): GenPagesUserLoginPasswordUserLoginPassword {
    return GenPagesUserLoginPasswordUserLoginPassword(instance);
}
);
val GenPagesUserGetcodeUserGetcodeClass = CreateVueComponent(GenPagesUserGetcodeUserGetcode::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserGetcodeUserGetcode.inheritAttrs, inject = GenPagesUserGetcodeUserGetcode.inject, props = GenPagesUserGetcodeUserGetcode.props, propsNeedCastKeys = GenPagesUserGetcodeUserGetcode.propsNeedCastKeys, emits = GenPagesUserGetcodeUserGetcode.emits, components = GenPagesUserGetcodeUserGetcode.components, styles = GenPagesUserGetcodeUserGetcode.styles);
}
, fun(instance): GenPagesUserGetcodeUserGetcode {
    return GenPagesUserGetcodeUserGetcode(instance);
}
);
val whites = utsArrayOf<String>("user_info", "user_token");
val GenPagesUserSettingUserSettingClass = CreateVueComponent(GenPagesUserSettingUserSetting::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserSettingUserSetting.inheritAttrs, inject = GenPagesUserSettingUserSetting.inject, props = GenPagesUserSettingUserSetting.props, propsNeedCastKeys = GenPagesUserSettingUserSetting.propsNeedCastKeys, emits = GenPagesUserSettingUserSetting.emits, components = GenPagesUserSettingUserSetting.components, styles = GenPagesUserSettingUserSetting.styles);
}
, fun(instance): GenPagesUserSettingUserSetting {
    return GenPagesUserSettingUserSetting(instance);
}
);
val GenPagesUserSafeUserSafeClass = CreateVueComponent(GenPagesUserSafeUserSafe::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserSafeUserSafe.inheritAttrs, inject = GenPagesUserSafeUserSafe.inject, props = GenPagesUserSafeUserSafe.props, propsNeedCastKeys = GenPagesUserSafeUserSafe.propsNeedCastKeys, emits = GenPagesUserSafeUserSafe.emits, components = GenPagesUserSafeUserSafe.components, styles = GenPagesUserSafeUserSafe.styles);
}
, fun(instance): GenPagesUserSafeUserSafe {
    return GenPagesUserSafeUserSafe(instance);
}
);
open class cityItem (
    @JsonNotNull
    open var label: String,
    @JsonNotNull
    open var value: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return cityItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class cityItemReactiveObject : cityItem, IUTSReactive<cityItem> {
    override var __v_raw: cityItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: cityItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(label = __v_raw.label, value = __v_raw.value) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): cityItemReactiveObject {
        return cityItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var label: String
        get() {
            return trackReactiveGet(__v_raw, "label", __v_raw.label, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("label")) {
                return;
            }
            val oldValue = __v_raw.label;
            __v_raw.label = value;
            triggerReactiveSet(__v_raw, "label", oldValue, value);
        }
    override var value: String
        get() {
            return trackReactiveGet(__v_raw, "value", __v_raw.value, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("value")) {
                return;
            }
            val oldValue = __v_raw.value;
            __v_raw.value = value;
            triggerReactiveSet(__v_raw, "value", oldValue, value);
        }
}
open class citypickerChangeEvent (
    @JsonNotNull
    open var label: String,
    @JsonNotNull
    open var value: UTSArray<Number>,
    @JsonNotNull
    open var cityCode: String,
) : UTSObject()
open class datepickerChangeEvent (
    @JsonNotNull
    open var year: Number,
    @JsonNotNull
    open var month: Number,
    @JsonNotNull
    open var day: Number,
    @JsonNotNull
    open var label: String,
) : UTSObject()
val GenComponentsFPickerFPickerClass = CreateVueComponent(GenComponentsFPickerFPicker::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsFPickerFPicker.name, inheritAttrs = GenComponentsFPickerFPicker.inheritAttrs, inject = GenComponentsFPickerFPicker.inject, props = GenComponentsFPickerFPicker.props, propsNeedCastKeys = GenComponentsFPickerFPicker.propsNeedCastKeys, emits = GenComponentsFPickerFPicker.emits, components = GenComponentsFPickerFPicker.components, styles = GenComponentsFPickerFPicker.styles);
}
, fun(instance): GenComponentsFPickerFPicker {
    return GenComponentsFPickerFPicker(instance);
}
);
var provinceData = utsArrayOf<cityItem>(cityItem(label = "北京市", value = "11"), cityItem(label = "天津市", value = "12"), cityItem(label = "河北省", value = "13"), cityItem(label = "山西省", value = "14"), cityItem(label = "内蒙古自治区", value = "15"), cityItem(label = "辽宁省", value = "21"), cityItem(label = "吉林省", value = "22"), cityItem(label = "黑龙江省", value = "23"), cityItem(label = "上海市", value = "31"), cityItem(label = "江苏省", value = "32"), cityItem(label = "浙江省", value = "33"), cityItem(label = "安徽省", value = "34"), cityItem(label = "福建省", value = "35"), cityItem(label = "江西省", value = "36"), cityItem(label = "山东省", value = "37"), cityItem(label = "河南省", value = "41"), cityItem(label = "湖北省", value = "42"), cityItem(label = "湖南省", value = "43"), cityItem(label = "广东省", value = "44"), cityItem(label = "广西壮族自治区", value = "45"), cityItem(label = "海南省", value = "46"), cityItem(label = "重庆市", value = "50"), cityItem(label = "四川省", value = "51"), cityItem(label = "贵州省", value = "52"), cityItem(label = "云南省", value = "53"), cityItem(label = "西藏自治区", value = "54"), cityItem(label = "陕西省", value = "61"), cityItem(label = "甘肃省", value = "62"), cityItem(label = "青海省", value = "63"), cityItem(label = "宁夏回族自治区", value = "64"), cityItem(label = "新疆维吾尔自治区", value = "65"), cityItem(label = "台湾", value = "66"), cityItem(label = "香港", value = "67"), cityItem(label = "澳门", value = "68"));
var cityData = utsArrayOf<UTSArray<cityItem>>(utsArrayOf(
    cityItem(label = "市辖区", value = "1101")
), utsArrayOf(
    cityItem(label = "市辖区", value = "1201")
), utsArrayOf(
    cityItem(label = "石家庄市", value = "1301"),
    cityItem(label = "唐山市", value = "1302"),
    cityItem(label = "秦皇岛市", value = "1303"),
    cityItem(label = "邯郸市", value = "1304"),
    cityItem(label = "邢台市", value = "1305"),
    cityItem(label = "保定市", value = "1306"),
    cityItem(label = "张家口市", value = "1307"),
    cityItem(label = "承德市", value = "1308"),
    cityItem(label = "沧州市", value = "1309"),
    cityItem(label = "廊坊市", value = "1310"),
    cityItem(label = "衡水市", value = "1311")
), utsArrayOf(
    cityItem(label = "太原市", value = "1401"),
    cityItem(label = "大同市", value = "1402"),
    cityItem(label = "阳泉市", value = "1403"),
    cityItem(label = "长治市", value = "1404"),
    cityItem(label = "晋城市", value = "1405"),
    cityItem(label = "朔州市", value = "1406"),
    cityItem(label = "晋中市", value = "1407"),
    cityItem(label = "运城市", value = "1408"),
    cityItem(label = "忻州市", value = "1409"),
    cityItem(label = "临汾市", value = "1410"),
    cityItem(label = "吕梁市", value = "1411")
), utsArrayOf(
    cityItem(label = "呼和浩特市", value = "1501"),
    cityItem(label = "包头市", value = "1502"),
    cityItem(label = "乌海市", value = "1503"),
    cityItem(label = "赤峰市", value = "1504"),
    cityItem(label = "通辽市", value = "1505"),
    cityItem(label = "鄂尔多斯市", value = "1506"),
    cityItem(label = "呼伦贝尔市", value = "1507"),
    cityItem(label = "巴彦淖尔市", value = "1508"),
    cityItem(label = "乌兰察布市", value = "1509"),
    cityItem(label = "兴安盟", value = "1522"),
    cityItem(label = "锡林郭勒盟", value = "1525"),
    cityItem(label = "阿拉善盟", value = "1529")
), utsArrayOf(
    cityItem(label = "沈阳市", value = "2101"),
    cityItem(label = "大连市", value = "2102"),
    cityItem(label = "鞍山市", value = "2103"),
    cityItem(label = "抚顺市", value = "2104"),
    cityItem(label = "本溪市", value = "2105"),
    cityItem(label = "丹东市", value = "2106"),
    cityItem(label = "锦州市", value = "2107"),
    cityItem(label = "营口市", value = "2108"),
    cityItem(label = "阜新市", value = "2109"),
    cityItem(label = "辽阳市", value = "2110"),
    cityItem(label = "盘锦市", value = "2111"),
    cityItem(label = "铁岭市", value = "2112"),
    cityItem(label = "朝阳市", value = "2113"),
    cityItem(label = "葫芦岛市", value = "2114")
), utsArrayOf(
    cityItem(label = "长春市", value = "2201"),
    cityItem(label = "吉林市", value = "2202"),
    cityItem(label = "四平市", value = "2203"),
    cityItem(label = "辽源市", value = "2204"),
    cityItem(label = "通化市", value = "2205"),
    cityItem(label = "白山市", value = "2206"),
    cityItem(label = "松原市", value = "2207"),
    cityItem(label = "白城市", value = "2208"),
    cityItem(label = "延边朝鲜族自治州", value = "2224")
), utsArrayOf(
    cityItem(label = "哈尔滨市", value = "2301"),
    cityItem(label = "齐齐哈尔市", value = "2302"),
    cityItem(label = "鸡西市", value = "2303"),
    cityItem(label = "鹤岗市", value = "2304"),
    cityItem(label = "双鸭山市", value = "2305"),
    cityItem(label = "大庆市", value = "2306"),
    cityItem(label = "伊春市", value = "2307"),
    cityItem(label = "佳木斯市", value = "2308"),
    cityItem(label = "七台河市", value = "2309"),
    cityItem(label = "牡丹江市", value = "2310"),
    cityItem(label = "黑河市", value = "2311"),
    cityItem(label = "绥化市", value = "2312"),
    cityItem(label = "大兴安岭地区", value = "2327")
), utsArrayOf(
    cityItem(label = "市辖区", value = "3101")
), utsArrayOf(
    cityItem(label = "南京市", value = "3201"),
    cityItem(label = "无锡市", value = "3202"),
    cityItem(label = "徐州市", value = "3203"),
    cityItem(label = "常州市", value = "3204"),
    cityItem(label = "苏州市", value = "3205"),
    cityItem(label = "南通市", value = "3206"),
    cityItem(label = "连云港市", value = "3207"),
    cityItem(label = "淮安市", value = "3208"),
    cityItem(label = "盐城市", value = "3209"),
    cityItem(label = "扬州市", value = "3210"),
    cityItem(label = "镇江市", value = "3211"),
    cityItem(label = "泰州市", value = "3212"),
    cityItem(label = "宿迁市", value = "3213")
), utsArrayOf(
    cityItem(label = "杭州市", value = "3301"),
    cityItem(label = "宁波市", value = "3302"),
    cityItem(label = "温州市", value = "3303"),
    cityItem(label = "嘉兴市", value = "3304"),
    cityItem(label = "湖州市", value = "3305"),
    cityItem(label = "绍兴市", value = "3306"),
    cityItem(label = "金华市", value = "3307"),
    cityItem(label = "衢州市", value = "3308"),
    cityItem(label = "舟山市", value = "3309"),
    cityItem(label = "台州市", value = "3310"),
    cityItem(label = "丽水市", value = "3311")
), utsArrayOf(
    cityItem(label = "合肥市", value = "3401"),
    cityItem(label = "芜湖市", value = "3402"),
    cityItem(label = "蚌埠市", value = "3403"),
    cityItem(label = "淮南市", value = "3404"),
    cityItem(label = "马鞍山市", value = "3405"),
    cityItem(label = "淮北市", value = "3406"),
    cityItem(label = "铜陵市", value = "3407"),
    cityItem(label = "安庆市", value = "3408"),
    cityItem(label = "黄山市", value = "3410"),
    cityItem(label = "滁州市", value = "3411"),
    cityItem(label = "阜阳市", value = "3412"),
    cityItem(label = "宿州市", value = "3413"),
    cityItem(label = "六安市", value = "3415"),
    cityItem(label = "亳州市", value = "3416"),
    cityItem(label = "池州市", value = "3417"),
    cityItem(label = "宣城市", value = "3418")
), utsArrayOf(
    cityItem(label = "福州市", value = "3501"),
    cityItem(label = "厦门市", value = "3502"),
    cityItem(label = "莆田市", value = "3503"),
    cityItem(label = "三明市", value = "3504"),
    cityItem(label = "泉州市", value = "3505"),
    cityItem(label = "漳州市", value = "3506"),
    cityItem(label = "南平市", value = "3507"),
    cityItem(label = "龙岩市", value = "3508"),
    cityItem(label = "宁德市", value = "3509")
), utsArrayOf(
    cityItem(label = "南昌市", value = "3601"),
    cityItem(label = "景德镇市", value = "3602"),
    cityItem(label = "萍乡市", value = "3603"),
    cityItem(label = "九江市", value = "3604"),
    cityItem(label = "新余市", value = "3605"),
    cityItem(label = "鹰潭市", value = "3606"),
    cityItem(label = "赣州市", value = "3607"),
    cityItem(label = "吉安市", value = "3608"),
    cityItem(label = "宜春市", value = "3609"),
    cityItem(label = "抚州市", value = "3610"),
    cityItem(label = "上饶市", value = "3611")
), utsArrayOf(
    cityItem(label = "济南市", value = "3701"),
    cityItem(label = "青岛市", value = "3702"),
    cityItem(label = "淄博市", value = "3703"),
    cityItem(label = "枣庄市", value = "3704"),
    cityItem(label = "东营市", value = "3705"),
    cityItem(label = "烟台市", value = "3706"),
    cityItem(label = "潍坊市", value = "3707"),
    cityItem(label = "济宁市", value = "3708"),
    cityItem(label = "泰安市", value = "3709"),
    cityItem(label = "威海市", value = "3710"),
    cityItem(label = "日照市", value = "3711"),
    cityItem(label = "莱芜市", value = "3712"),
    cityItem(label = "临沂市", value = "3713"),
    cityItem(label = "德州市", value = "3714"),
    cityItem(label = "聊城市", value = "3715"),
    cityItem(label = "滨州市", value = "3716"),
    cityItem(label = "菏泽市", value = "3717")
), utsArrayOf(
    cityItem(label = "郑州市", value = "4101"),
    cityItem(label = "开封市", value = "4102"),
    cityItem(label = "洛阳市", value = "4103"),
    cityItem(label = "平顶山市", value = "4104"),
    cityItem(label = "安阳市", value = "4105"),
    cityItem(label = "鹤壁市", value = "4106"),
    cityItem(label = "新乡市", value = "4107"),
    cityItem(label = "焦作市", value = "4108"),
    cityItem(label = "濮阳市", value = "4109"),
    cityItem(label = "许昌市", value = "4110"),
    cityItem(label = "漯河市", value = "4111"),
    cityItem(label = "三门峡市", value = "4112"),
    cityItem(label = "南阳市", value = "4113"),
    cityItem(label = "商丘市", value = "4114"),
    cityItem(label = "信阳市", value = "4115"),
    cityItem(label = "周口市", value = "4116"),
    cityItem(label = "驻马店市", value = "4117"),
    cityItem(label = "省直辖县级行政区划", value = "4190")
), utsArrayOf(
    cityItem(label = "武汉市", value = "4201"),
    cityItem(label = "黄石市", value = "4202"),
    cityItem(label = "十堰市", value = "4203"),
    cityItem(label = "宜昌市", value = "4205"),
    cityItem(label = "襄阳市", value = "4206"),
    cityItem(label = "鄂州市", value = "4207"),
    cityItem(label = "荆门市", value = "4208"),
    cityItem(label = "孝感市", value = "4209"),
    cityItem(label = "荆州市", value = "4210"),
    cityItem(label = "黄冈市", value = "4211"),
    cityItem(label = "咸宁市", value = "4212"),
    cityItem(label = "随州市", value = "4213"),
    cityItem(label = "恩施土家族苗族自治州", value = "4228"),
    cityItem(label = "省直辖县级行政区划", value = "4290")
), utsArrayOf(
    cityItem(label = "长沙市", value = "4301"),
    cityItem(label = "株洲市", value = "4302"),
    cityItem(label = "湘潭市", value = "4303"),
    cityItem(label = "衡阳市", value = "4304"),
    cityItem(label = "邵阳市", value = "4305"),
    cityItem(label = "岳阳市", value = "4306"),
    cityItem(label = "常德市", value = "4307"),
    cityItem(label = "张家界市", value = "4308"),
    cityItem(label = "益阳市", value = "4309"),
    cityItem(label = "郴州市", value = "4310"),
    cityItem(label = "永州市", value = "4311"),
    cityItem(label = "怀化市", value = "4312"),
    cityItem(label = "娄底市", value = "4313"),
    cityItem(label = "湘西土家族苗族自治州", value = "4331")
), utsArrayOf(
    cityItem(label = "广州市", value = "4401"),
    cityItem(label = "韶关市", value = "4402"),
    cityItem(label = "深圳市", value = "4403"),
    cityItem(label = "珠海市", value = "4404"),
    cityItem(label = "汕头市", value = "4405"),
    cityItem(label = "佛山市", value = "4406"),
    cityItem(label = "江门市", value = "4407"),
    cityItem(label = "湛江市", value = "4408"),
    cityItem(label = "茂名市", value = "4409"),
    cityItem(label = "肇庆市", value = "4412"),
    cityItem(label = "惠州市", value = "4413"),
    cityItem(label = "梅州市", value = "4414"),
    cityItem(label = "汕尾市", value = "4415"),
    cityItem(label = "河源市", value = "4416"),
    cityItem(label = "阳江市", value = "4417"),
    cityItem(label = "清远市", value = "4418"),
    cityItem(label = "东莞市", value = "4419"),
    cityItem(label = "中山市", value = "4420"),
    cityItem(label = "潮州市", value = "4451"),
    cityItem(label = "揭阳市", value = "4452"),
    cityItem(label = "云浮市", value = "4453")
), utsArrayOf(
    cityItem(label = "南宁市", value = "4501"),
    cityItem(label = "柳州市", value = "4502"),
    cityItem(label = "桂林市", value = "4503"),
    cityItem(label = "梧州市", value = "4504"),
    cityItem(label = "北海市", value = "4505"),
    cityItem(label = "防城港市", value = "4506"),
    cityItem(label = "钦州市", value = "4507"),
    cityItem(label = "贵港市", value = "4508"),
    cityItem(label = "玉林市", value = "4509"),
    cityItem(label = "百色市", value = "4510"),
    cityItem(label = "贺州市", value = "4511"),
    cityItem(label = "河池市", value = "4512"),
    cityItem(label = "来宾市", value = "4513"),
    cityItem(label = "崇左市", value = "4514")
), utsArrayOf(
    cityItem(label = "海口市", value = "4601"),
    cityItem(label = "三亚市", value = "4602"),
    cityItem(label = "三沙市", value = "4603"),
    cityItem(label = "儋州市", value = "4604"),
    cityItem(label = "省直辖县级行政区划", value = "4690")
), utsArrayOf(
    cityItem(label = "市辖区", value = "5001"),
    cityItem(label = "县", value = "5002")
), utsArrayOf(
    cityItem(label = "成都市", value = "5101"),
    cityItem(label = "自贡市", value = "5103"),
    cityItem(label = "攀枝花市", value = "5104"),
    cityItem(label = "泸州市", value = "5105"),
    cityItem(label = "德阳市", value = "5106"),
    cityItem(label = "绵阳市", value = "5107"),
    cityItem(label = "广元市", value = "5108"),
    cityItem(label = "遂宁市", value = "5109"),
    cityItem(label = "内江市", value = "5110"),
    cityItem(label = "乐山市", value = "5111"),
    cityItem(label = "南充市", value = "5113"),
    cityItem(label = "眉山市", value = "5114"),
    cityItem(label = "宜宾市", value = "5115"),
    cityItem(label = "广安市", value = "5116"),
    cityItem(label = "达州市", value = "5117"),
    cityItem(label = "雅安市", value = "5118"),
    cityItem(label = "巴中市", value = "5119"),
    cityItem(label = "资阳市", value = "5120"),
    cityItem(label = "阿坝藏族羌族自治州", value = "5132"),
    cityItem(label = "甘孜藏族自治州", value = "5133"),
    cityItem(label = "凉山彝族自治州", value = "5134")
), utsArrayOf(
    cityItem(label = "贵阳市", value = "5201"),
    cityItem(label = "六盘水市", value = "5202"),
    cityItem(label = "遵义市", value = "5203"),
    cityItem(label = "安顺市", value = "5204"),
    cityItem(label = "毕节市", value = "5205"),
    cityItem(label = "铜仁市", value = "5206"),
    cityItem(label = "黔西南布依族苗族自治州", value = "5223"),
    cityItem(label = "黔东南苗族侗族自治州", value = "5226"),
    cityItem(label = "黔南布依族苗族自治州", value = "5227")
), utsArrayOf(
    cityItem(label = "昆明市", value = "5301"),
    cityItem(label = "曲靖市", value = "5303"),
    cityItem(label = "玉溪市", value = "5304"),
    cityItem(label = "保山市", value = "5305"),
    cityItem(label = "昭通市", value = "5306"),
    cityItem(label = "丽江市", value = "5307"),
    cityItem(label = "普洱市", value = "5308"),
    cityItem(label = "临沧市", value = "5309"),
    cityItem(label = "楚雄彝族自治州", value = "5323"),
    cityItem(label = "红河哈尼族彝族自治州", value = "5325"),
    cityItem(label = "文山壮族苗族自治州", value = "5326"),
    cityItem(label = "西双版纳傣族自治州", value = "5328"),
    cityItem(label = "大理白族自治州", value = "5329"),
    cityItem(label = "德宏傣族景颇族自治州", value = "5331"),
    cityItem(label = "怒江傈僳族自治州", value = "5333"),
    cityItem(label = "迪庆藏族自治州", value = "5334")
), utsArrayOf(
    cityItem(label = "拉萨市", value = "5401"),
    cityItem(label = "日喀则市", value = "5402"),
    cityItem(label = "昌都市", value = "5403"),
    cityItem(label = "林芝市", value = "5404"),
    cityItem(label = "山南市", value = "5405"),
    cityItem(label = "那曲地区", value = "5424"),
    cityItem(label = "阿里地区", value = "5425")
), utsArrayOf(
    cityItem(label = "西安市", value = "6101"),
    cityItem(label = "铜川市", value = "6102"),
    cityItem(label = "宝鸡市", value = "6103"),
    cityItem(label = "咸阳市", value = "6104"),
    cityItem(label = "渭南市", value = "6105"),
    cityItem(label = "延安市", value = "6106"),
    cityItem(label = "汉中市", value = "6107"),
    cityItem(label = "榆林市", value = "6108"),
    cityItem(label = "安康市", value = "6109"),
    cityItem(label = "商洛市", value = "6110")
), utsArrayOf(
    cityItem(label = "兰州市", value = "6201"),
    cityItem(label = "嘉峪关市", value = "6202"),
    cityItem(label = "金昌市", value = "6203"),
    cityItem(label = "白银市", value = "6204"),
    cityItem(label = "天水市", value = "6205"),
    cityItem(label = "武威市", value = "6206"),
    cityItem(label = "张掖市", value = "6207"),
    cityItem(label = "平凉市", value = "6208"),
    cityItem(label = "酒泉市", value = "6209"),
    cityItem(label = "庆阳市", value = "6210"),
    cityItem(label = "定西市", value = "6211"),
    cityItem(label = "陇南市", value = "6212"),
    cityItem(label = "临夏回族自治州", value = "6229"),
    cityItem(label = "甘南藏族自治州", value = "6230")
), utsArrayOf(
    cityItem(label = "西宁市", value = "6301"),
    cityItem(label = "海东市", value = "6302"),
    cityItem(label = "海北藏族自治州", value = "6322"),
    cityItem(label = "黄南藏族自治州", value = "6323"),
    cityItem(label = "海南藏族自治州", value = "6325"),
    cityItem(label = "果洛藏族自治州", value = "6326"),
    cityItem(label = "玉树藏族自治州", value = "6327"),
    cityItem(label = "海西蒙古族藏族自治州", value = "6328")
), utsArrayOf(
    cityItem(label = "银川市", value = "6401"),
    cityItem(label = "石嘴山市", value = "6402"),
    cityItem(label = "吴忠市", value = "6403"),
    cityItem(label = "固原市", value = "6404"),
    cityItem(label = "中卫市", value = "6405")
), utsArrayOf(
    cityItem(label = "乌鲁木齐市", value = "6501"),
    cityItem(label = "克拉玛依市", value = "6502"),
    cityItem(label = "吐鲁番市", value = "6504"),
    cityItem(label = "哈密市", value = "6505"),
    cityItem(label = "昌吉回族自治州", value = "6523"),
    cityItem(label = "博尔塔拉蒙古自治州", value = "6527"),
    cityItem(label = "巴音郭楞蒙古自治州", value = "6528"),
    cityItem(label = "阿克苏地区", value = "6529"),
    cityItem(label = "克孜勒苏柯尔克孜自治州", value = "6530"),
    cityItem(label = "喀什地区", value = "6531"),
    cityItem(label = "和田地区", value = "6532"),
    cityItem(label = "伊犁哈萨克自治州", value = "6540"),
    cityItem(label = "塔城地区", value = "6542"),
    cityItem(label = "阿勒泰地区", value = "6543"),
    cityItem(label = "自治区直辖县级行政区划", value = "6590")
), utsArrayOf(
    cityItem(label = "台北", value = "6601"),
    cityItem(label = "高雄", value = "6602"),
    cityItem(label = "基隆", value = "6603"),
    cityItem(label = "台中", value = "6604"),
    cityItem(label = "台南", value = "6605"),
    cityItem(label = "新竹", value = "6606"),
    cityItem(label = "嘉义", value = "6607"),
    cityItem(label = "宜兰", value = "6608"),
    cityItem(label = "桃园", value = "6609"),
    cityItem(label = "苗栗", value = "6610"),
    cityItem(label = "彰化", value = "6611"),
    cityItem(label = "南投", value = "6612"),
    cityItem(label = "云林", value = "6613"),
    cityItem(label = "屏东", value = "6614"),
    cityItem(label = "台东", value = "6615"),
    cityItem(label = "花莲", value = "6616"),
    cityItem(label = "澎湖", value = "6617")
), utsArrayOf(
    cityItem(label = "香港岛", value = "6701"),
    cityItem(label = "九龙", value = "6702"),
    cityItem(label = "新界", value = "6703")
), utsArrayOf(
    cityItem(label = "澳门半岛", value = "6801"),
    cityItem(label = "氹仔岛", value = "6802"),
    cityItem(label = "路环岛", value = "6803"),
    cityItem(label = "路氹城", value = "6804")
));
var areaData = utsArrayOf<UTSArray<UTSArray<cityItem>>>(utsArrayOf(
    utsArrayOf(
        cityItem(label = "东城区", value = "110101"),
        cityItem(label = "西城区", value = "110102"),
        cityItem(label = "朝阳区", value = "110105"),
        cityItem(label = "丰台区", value = "110106"),
        cityItem(label = "石景山区", value = "110107"),
        cityItem(label = "海淀区", value = "110108"),
        cityItem(label = "门头沟区", value = "110109"),
        cityItem(label = "房山区", value = "110111"),
        cityItem(label = "通州区", value = "110112"),
        cityItem(label = "顺义区", value = "110113"),
        cityItem(label = "昌平区", value = "110114"),
        cityItem(label = "大兴区", value = "110115"),
        cityItem(label = "怀柔区", value = "110116"),
        cityItem(label = "平谷区", value = "110117"),
        cityItem(label = "密云区", value = "110118"),
        cityItem(label = "延庆区", value = "110119")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "和平区", value = "120101"),
        cityItem(label = "河东区", value = "120102"),
        cityItem(label = "河西区", value = "120103"),
        cityItem(label = "南开区", value = "120104"),
        cityItem(label = "河北区", value = "120105"),
        cityItem(label = "红桥区", value = "120106"),
        cityItem(label = "东丽区", value = "120110"),
        cityItem(label = "西青区", value = "120111"),
        cityItem(label = "津南区", value = "120112"),
        cityItem(label = "北辰区", value = "120113"),
        cityItem(label = "武清区", value = "120114"),
        cityItem(label = "宝坻区", value = "120115"),
        cityItem(label = "滨海新区", value = "120116"),
        cityItem(label = "宁河区", value = "120117"),
        cityItem(label = "静海区", value = "120118"),
        cityItem(label = "蓟州区", value = "120119")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "长安区", value = "130102"),
        cityItem(label = "桥西区", value = "130104"),
        cityItem(label = "新华区", value = "130105"),
        cityItem(label = "井陉矿区", value = "130107"),
        cityItem(label = "裕华区", value = "130108"),
        cityItem(label = "藁城区", value = "130109"),
        cityItem(label = "鹿泉区", value = "130110"),
        cityItem(label = "栾城区", value = "130111"),
        cityItem(label = "井陉县", value = "130121"),
        cityItem(label = "正定县", value = "130123"),
        cityItem(label = "行唐县", value = "130125"),
        cityItem(label = "灵寿县", value = "130126"),
        cityItem(label = "高邑县", value = "130127"),
        cityItem(label = "深泽县", value = "130128"),
        cityItem(label = "赞皇县", value = "130129"),
        cityItem(label = "无极县", value = "130130"),
        cityItem(label = "平山县", value = "130131"),
        cityItem(label = "元氏县", value = "130132"),
        cityItem(label = "赵县", value = "130133"),
        cityItem(label = "石家庄高新技术产业开发区", value = "130171"),
        cityItem(label = "石家庄循环化工园区", value = "130172"),
        cityItem(label = "辛集市", value = "130181"),
        cityItem(label = "晋州市", value = "130183"),
        cityItem(label = "新乐市", value = "130184")
    ),
    utsArrayOf(
        cityItem(label = "路南区", value = "130202"),
        cityItem(label = "路北区", value = "130203"),
        cityItem(label = "古冶区", value = "130204"),
        cityItem(label = "开平区", value = "130205"),
        cityItem(label = "丰南区", value = "130207"),
        cityItem(label = "丰润区", value = "130208"),
        cityItem(label = "曹妃甸区", value = "130209"),
        cityItem(label = "滦县", value = "130223"),
        cityItem(label = "滦南县", value = "130224"),
        cityItem(label = "乐亭县", value = "130225"),
        cityItem(label = "迁西县", value = "130227"),
        cityItem(label = "玉田县", value = "130229"),
        cityItem(label = "唐山市芦台经济技术开发区", value = "130271"),
        cityItem(label = "唐山市汉沽管理区", value = "130272"),
        cityItem(label = "唐山高新技术产业开发区", value = "130273"),
        cityItem(label = "河北唐山海港经济开发区", value = "130274"),
        cityItem(label = "遵化市", value = "130281"),
        cityItem(label = "迁安市", value = "130283")
    ),
    utsArrayOf(
        cityItem(label = "海港区", value = "130302"),
        cityItem(label = "山海关区", value = "130303"),
        cityItem(label = "北戴河区", value = "130304"),
        cityItem(label = "抚宁区", value = "130306"),
        cityItem(label = "青龙满族自治县", value = "130321"),
        cityItem(label = "昌黎县", value = "130322"),
        cityItem(label = "卢龙县", value = "130324"),
        cityItem(label = "秦皇岛市经济技术开发区", value = "130371"),
        cityItem(label = "北戴河新区", value = "130372")
    ),
    utsArrayOf(
        cityItem(label = "邯山区", value = "130402"),
        cityItem(label = "丛台区", value = "130403"),
        cityItem(label = "复兴区", value = "130404"),
        cityItem(label = "峰峰矿区", value = "130406"),
        cityItem(label = "肥乡区", value = "130407"),
        cityItem(label = "永年区", value = "130408"),
        cityItem(label = "临漳县", value = "130423"),
        cityItem(label = "成安县", value = "130424"),
        cityItem(label = "大名县", value = "130425"),
        cityItem(label = "涉县", value = "130426"),
        cityItem(label = "磁县", value = "130427"),
        cityItem(label = "邱县", value = "130430"),
        cityItem(label = "鸡泽县", value = "130431"),
        cityItem(label = "广平县", value = "130432"),
        cityItem(label = "馆陶县", value = "130433"),
        cityItem(label = "魏县", value = "130434"),
        cityItem(label = "曲周县", value = "130435"),
        cityItem(label = "邯郸经济技术开发区", value = "130471"),
        cityItem(label = "邯郸冀南新区", value = "130473"),
        cityItem(label = "武安市", value = "130481")
    ),
    utsArrayOf(
        cityItem(label = "桥东区", value = "130502"),
        cityItem(label = "桥西区", value = "130503"),
        cityItem(label = "邢台县", value = "130521"),
        cityItem(label = "临城县", value = "130522"),
        cityItem(label = "内丘县", value = "130523"),
        cityItem(label = "柏乡县", value = "130524"),
        cityItem(label = "隆尧县", value = "130525"),
        cityItem(label = "任县", value = "130526"),
        cityItem(label = "南和县", value = "130527"),
        cityItem(label = "宁晋县", value = "130528"),
        cityItem(label = "巨鹿县", value = "130529"),
        cityItem(label = "新河县", value = "130530"),
        cityItem(label = "广宗县", value = "130531"),
        cityItem(label = "平乡县", value = "130532"),
        cityItem(label = "威县", value = "130533"),
        cityItem(label = "清河县", value = "130534"),
        cityItem(label = "临西县", value = "130535"),
        cityItem(label = "河北邢台经济开发区", value = "130571"),
        cityItem(label = "南宫市", value = "130581"),
        cityItem(label = "沙河市", value = "130582")
    ),
    utsArrayOf(
        cityItem(label = "竞秀区", value = "130602"),
        cityItem(label = "莲池区", value = "130606"),
        cityItem(label = "满城区", value = "130607"),
        cityItem(label = "清苑区", value = "130608"),
        cityItem(label = "徐水区", value = "130609"),
        cityItem(label = "涞水县", value = "130623"),
        cityItem(label = "阜平县", value = "130624"),
        cityItem(label = "定兴县", value = "130626"),
        cityItem(label = "唐县", value = "130627"),
        cityItem(label = "高阳县", value = "130628"),
        cityItem(label = "容城县", value = "130629"),
        cityItem(label = "涞源县", value = "130630"),
        cityItem(label = "望都县", value = "130631"),
        cityItem(label = "安新县", value = "130632"),
        cityItem(label = "易县", value = "130633"),
        cityItem(label = "曲阳县", value = "130634"),
        cityItem(label = "蠡县", value = "130635"),
        cityItem(label = "顺平县", value = "130636"),
        cityItem(label = "博野县", value = "130637"),
        cityItem(label = "雄县", value = "130638"),
        cityItem(label = "保定高新技术产业开发区", value = "130671"),
        cityItem(label = "保定白沟新城", value = "130672"),
        cityItem(label = "涿州市", value = "130681"),
        cityItem(label = "定州市", value = "130682"),
        cityItem(label = "安国市", value = "130683"),
        cityItem(label = "高碑店市", value = "130684")
    ),
    utsArrayOf(
        cityItem(label = "桥东区", value = "130702"),
        cityItem(label = "桥西区", value = "130703"),
        cityItem(label = "宣化区", value = "130705"),
        cityItem(label = "下花园区", value = "130706"),
        cityItem(label = "万全区", value = "130708"),
        cityItem(label = "崇礼区", value = "130709"),
        cityItem(label = "张北县", value = "130722"),
        cityItem(label = "康保县", value = "130723"),
        cityItem(label = "沽源县", value = "130724"),
        cityItem(label = "尚义县", value = "130725"),
        cityItem(label = "蔚县", value = "130726"),
        cityItem(label = "阳原县", value = "130727"),
        cityItem(label = "怀安县", value = "130728"),
        cityItem(label = "怀来县", value = "130730"),
        cityItem(label = "涿鹿县", value = "130731"),
        cityItem(label = "赤城县", value = "130732"),
        cityItem(label = "张家口市高新技术产业开发区", value = "130771"),
        cityItem(label = "张家口市察北管理区", value = "130772"),
        cityItem(label = "张家口市塞北管理区", value = "130773")
    ),
    utsArrayOf(
        cityItem(label = "双桥区", value = "130802"),
        cityItem(label = "双滦区", value = "130803"),
        cityItem(label = "鹰手营子矿区", value = "130804"),
        cityItem(label = "承德县", value = "130821"),
        cityItem(label = "兴隆县", value = "130822"),
        cityItem(label = "滦平县", value = "130824"),
        cityItem(label = "隆化县", value = "130825"),
        cityItem(label = "丰宁满族自治县", value = "130826"),
        cityItem(label = "宽城满族自治县", value = "130827"),
        cityItem(label = "围场满族蒙古族自治县", value = "130828"),
        cityItem(label = "承德高新技术产业开发区", value = "130871"),
        cityItem(label = "平泉市", value = "130881")
    ),
    utsArrayOf(
        cityItem(label = "新华区", value = "130902"),
        cityItem(label = "运河区", value = "130903"),
        cityItem(label = "沧县", value = "130921"),
        cityItem(label = "青县", value = "130922"),
        cityItem(label = "东光县", value = "130923"),
        cityItem(label = "海兴县", value = "130924"),
        cityItem(label = "盐山县", value = "130925"),
        cityItem(label = "肃宁县", value = "130926"),
        cityItem(label = "南皮县", value = "130927"),
        cityItem(label = "吴桥县", value = "130928"),
        cityItem(label = "献县", value = "130929"),
        cityItem(label = "孟村回族自治县", value = "130930"),
        cityItem(label = "河北沧州经济开发区", value = "130971"),
        cityItem(label = "沧州高新技术产业开发区", value = "130972"),
        cityItem(label = "沧州渤海新区", value = "130973"),
        cityItem(label = "泊头市", value = "130981"),
        cityItem(label = "任丘市", value = "130982"),
        cityItem(label = "黄骅市", value = "130983"),
        cityItem(label = "河间市", value = "130984")
    ),
    utsArrayOf(
        cityItem(label = "安次区", value = "131002"),
        cityItem(label = "广阳区", value = "131003"),
        cityItem(label = "固安县", value = "131022"),
        cityItem(label = "永清县", value = "131023"),
        cityItem(label = "香河县", value = "131024"),
        cityItem(label = "大城县", value = "131025"),
        cityItem(label = "文安县", value = "131026"),
        cityItem(label = "大厂回族自治县", value = "131028"),
        cityItem(label = "廊坊经济技术开发区", value = "131071"),
        cityItem(label = "霸州市", value = "131081"),
        cityItem(label = "三河市", value = "131082")
    ),
    utsArrayOf(
        cityItem(label = "桃城区", value = "131102"),
        cityItem(label = "冀州区", value = "131103"),
        cityItem(label = "枣强县", value = "131121"),
        cityItem(label = "武邑县", value = "131122"),
        cityItem(label = "武强县", value = "131123"),
        cityItem(label = "饶阳县", value = "131124"),
        cityItem(label = "安平县", value = "131125"),
        cityItem(label = "故城县", value = "131126"),
        cityItem(label = "景县", value = "131127"),
        cityItem(label = "阜城县", value = "131128"),
        cityItem(label = "河北衡水经济开发区", value = "131171"),
        cityItem(label = "衡水滨湖新区", value = "131172"),
        cityItem(label = "深州市", value = "131182")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "小店区", value = "140105"),
        cityItem(label = "迎泽区", value = "140106"),
        cityItem(label = "杏花岭区", value = "140107"),
        cityItem(label = "尖草坪区", value = "140108"),
        cityItem(label = "万柏林区", value = "140109"),
        cityItem(label = "晋源区", value = "140110"),
        cityItem(label = "清徐县", value = "140121"),
        cityItem(label = "阳曲县", value = "140122"),
        cityItem(label = "娄烦县", value = "140123"),
        cityItem(label = "山西转型综合改革示范区", value = "140171"),
        cityItem(label = "古交市", value = "140181")
    ),
    utsArrayOf(
        cityItem(label = "城区", value = "140202"),
        cityItem(label = "矿区", value = "140203"),
        cityItem(label = "南郊区", value = "140211"),
        cityItem(label = "新荣区", value = "140212"),
        cityItem(label = "阳高县", value = "140221"),
        cityItem(label = "天镇县", value = "140222"),
        cityItem(label = "广灵县", value = "140223"),
        cityItem(label = "灵丘县", value = "140224"),
        cityItem(label = "浑源县", value = "140225"),
        cityItem(label = "左云县", value = "140226"),
        cityItem(label = "大同县", value = "140227"),
        cityItem(label = "山西大同经济开发区", value = "140271")
    ),
    utsArrayOf(
        cityItem(label = "城区", value = "140302"),
        cityItem(label = "矿区", value = "140303"),
        cityItem(label = "郊区", value = "140311"),
        cityItem(label = "平定县", value = "140321"),
        cityItem(label = "盂县", value = "140322"),
        cityItem(label = "山西阳泉经济开发区", value = "140371")
    ),
    utsArrayOf(
        cityItem(label = "城区", value = "140402"),
        cityItem(label = "郊区", value = "140411"),
        cityItem(label = "长治县", value = "140421"),
        cityItem(label = "襄垣县", value = "140423"),
        cityItem(label = "屯留县", value = "140424"),
        cityItem(label = "平顺县", value = "140425"),
        cityItem(label = "黎城县", value = "140426"),
        cityItem(label = "壶关县", value = "140427"),
        cityItem(label = "长子县", value = "140428"),
        cityItem(label = "武乡县", value = "140429"),
        cityItem(label = "沁县", value = "140430"),
        cityItem(label = "沁源县", value = "140431"),
        cityItem(label = "山西长治高新技术产业园区", value = "140471"),
        cityItem(label = "潞城市", value = "140481")
    ),
    utsArrayOf(
        cityItem(label = "城区", value = "140502"),
        cityItem(label = "沁水县", value = "140521"),
        cityItem(label = "阳城县", value = "140522"),
        cityItem(label = "陵川县", value = "140524"),
        cityItem(label = "泽州县", value = "140525"),
        cityItem(label = "高平市", value = "140581")
    ),
    utsArrayOf(
        cityItem(label = "朔城区", value = "140602"),
        cityItem(label = "平鲁区", value = "140603"),
        cityItem(label = "山阴县", value = "140621"),
        cityItem(label = "应县", value = "140622"),
        cityItem(label = "右玉县", value = "140623"),
        cityItem(label = "怀仁县", value = "140624"),
        cityItem(label = "山西朔州经济开发区", value = "140671")
    ),
    utsArrayOf(
        cityItem(label = "榆次区", value = "140702"),
        cityItem(label = "榆社县", value = "140721"),
        cityItem(label = "左权县", value = "140722"),
        cityItem(label = "和顺县", value = "140723"),
        cityItem(label = "昔阳县", value = "140724"),
        cityItem(label = "寿阳县", value = "140725"),
        cityItem(label = "太谷县", value = "140726"),
        cityItem(label = "祁县", value = "140727"),
        cityItem(label = "平遥县", value = "140728"),
        cityItem(label = "灵石县", value = "140729"),
        cityItem(label = "介休市", value = "140781")
    ),
    utsArrayOf(
        cityItem(label = "盐湖区", value = "140802"),
        cityItem(label = "临猗县", value = "140821"),
        cityItem(label = "万荣县", value = "140822"),
        cityItem(label = "闻喜县", value = "140823"),
        cityItem(label = "稷山县", value = "140824"),
        cityItem(label = "新绛县", value = "140825"),
        cityItem(label = "绛县", value = "140826"),
        cityItem(label = "垣曲县", value = "140827"),
        cityItem(label = "夏县", value = "140828"),
        cityItem(label = "平陆县", value = "140829"),
        cityItem(label = "芮城县", value = "140830"),
        cityItem(label = "永济市", value = "140881"),
        cityItem(label = "河津市", value = "140882")
    ),
    utsArrayOf(
        cityItem(label = "忻府区", value = "140902"),
        cityItem(label = "定襄县", value = "140921"),
        cityItem(label = "五台县", value = "140922"),
        cityItem(label = "代县", value = "140923"),
        cityItem(label = "繁峙县", value = "140924"),
        cityItem(label = "宁武县", value = "140925"),
        cityItem(label = "静乐县", value = "140926"),
        cityItem(label = "神池县", value = "140927"),
        cityItem(label = "五寨县", value = "140928"),
        cityItem(label = "岢岚县", value = "140929"),
        cityItem(label = "河曲县", value = "140930"),
        cityItem(label = "保德县", value = "140931"),
        cityItem(label = "偏关县", value = "140932"),
        cityItem(label = "五台山风景名胜区", value = "140971"),
        cityItem(label = "原平市", value = "140981")
    ),
    utsArrayOf(
        cityItem(label = "尧都区", value = "141002"),
        cityItem(label = "曲沃县", value = "141021"),
        cityItem(label = "翼城县", value = "141022"),
        cityItem(label = "襄汾县", value = "141023"),
        cityItem(label = "洪洞县", value = "141024"),
        cityItem(label = "古县", value = "141025"),
        cityItem(label = "安泽县", value = "141026"),
        cityItem(label = "浮山县", value = "141027"),
        cityItem(label = "吉县", value = "141028"),
        cityItem(label = "乡宁县", value = "141029"),
        cityItem(label = "大宁县", value = "141030"),
        cityItem(label = "隰县", value = "141031"),
        cityItem(label = "永和县", value = "141032"),
        cityItem(label = "蒲县", value = "141033"),
        cityItem(label = "汾西县", value = "141034"),
        cityItem(label = "侯马市", value = "141081"),
        cityItem(label = "霍州市", value = "141082")
    ),
    utsArrayOf(
        cityItem(label = "离石区", value = "141102"),
        cityItem(label = "文水县", value = "141121"),
        cityItem(label = "交城县", value = "141122"),
        cityItem(label = "兴县", value = "141123"),
        cityItem(label = "临县", value = "141124"),
        cityItem(label = "柳林县", value = "141125"),
        cityItem(label = "石楼县", value = "141126"),
        cityItem(label = "岚县", value = "141127"),
        cityItem(label = "方山县", value = "141128"),
        cityItem(label = "中阳县", value = "141129"),
        cityItem(label = "交口县", value = "141130"),
        cityItem(label = "孝义市", value = "141181"),
        cityItem(label = "汾阳市", value = "141182")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "新城区", value = "150102"),
        cityItem(label = "回民区", value = "150103"),
        cityItem(label = "玉泉区", value = "150104"),
        cityItem(label = "赛罕区", value = "150105"),
        cityItem(label = "土默特左旗", value = "150121"),
        cityItem(label = "托克托县", value = "150122"),
        cityItem(label = "和林格尔县", value = "150123"),
        cityItem(label = "清水河县", value = "150124"),
        cityItem(label = "武川县", value = "150125"),
        cityItem(label = "呼和浩特金海工业园区", value = "150171"),
        cityItem(label = "呼和浩特经济技术开发区", value = "150172")
    ),
    utsArrayOf(
        cityItem(label = "东河区", value = "150202"),
        cityItem(label = "昆都仑区", value = "150203"),
        cityItem(label = "青山区", value = "150204"),
        cityItem(label = "石拐区", value = "150205"),
        cityItem(label = "白云鄂博矿区", value = "150206"),
        cityItem(label = "九原区", value = "150207"),
        cityItem(label = "土默特右旗", value = "150221"),
        cityItem(label = "固阳县", value = "150222"),
        cityItem(label = "达尔罕茂明安联合旗", value = "150223"),
        cityItem(label = "包头稀土高新技术产业开发区", value = "150271")
    ),
    utsArrayOf(
        cityItem(label = "海勃湾区", value = "150302"),
        cityItem(label = "海南区", value = "150303"),
        cityItem(label = "乌达区", value = "150304")
    ),
    utsArrayOf(
        cityItem(label = "红山区", value = "150402"),
        cityItem(label = "元宝山区", value = "150403"),
        cityItem(label = "松山区", value = "150404"),
        cityItem(label = "阿鲁科尔沁旗", value = "150421"),
        cityItem(label = "巴林左旗", value = "150422"),
        cityItem(label = "巴林右旗", value = "150423"),
        cityItem(label = "林西县", value = "150424"),
        cityItem(label = "克什克腾旗", value = "150425"),
        cityItem(label = "翁牛特旗", value = "150426"),
        cityItem(label = "喀喇沁旗", value = "150428"),
        cityItem(label = "宁城县", value = "150429"),
        cityItem(label = "敖汉旗", value = "150430")
    ),
    utsArrayOf(
        cityItem(label = "科尔沁区", value = "150502"),
        cityItem(label = "科尔沁左翼中旗", value = "150521"),
        cityItem(label = "科尔沁左翼后旗", value = "150522"),
        cityItem(label = "开鲁县", value = "150523"),
        cityItem(label = "库伦旗", value = "150524"),
        cityItem(label = "奈曼旗", value = "150525"),
        cityItem(label = "扎鲁特旗", value = "150526"),
        cityItem(label = "通辽经济技术开发区", value = "150571"),
        cityItem(label = "霍林郭勒市", value = "150581")
    ),
    utsArrayOf(
        cityItem(label = "东胜区", value = "150602"),
        cityItem(label = "康巴什区", value = "150603"),
        cityItem(label = "达拉特旗", value = "150621"),
        cityItem(label = "准格尔旗", value = "150622"),
        cityItem(label = "鄂托克前旗", value = "150623"),
        cityItem(label = "鄂托克旗", value = "150624"),
        cityItem(label = "杭锦旗", value = "150625"),
        cityItem(label = "乌审旗", value = "150626"),
        cityItem(label = "伊金霍洛旗", value = "150627")
    ),
    utsArrayOf(
        cityItem(label = "海拉尔区", value = "150702"),
        cityItem(label = "扎赉诺尔区", value = "150703"),
        cityItem(label = "阿荣旗", value = "150721"),
        cityItem(label = "莫力达瓦达斡尔族自治旗", value = "150722"),
        cityItem(label = "鄂伦春自治旗", value = "150723"),
        cityItem(label = "鄂温克族自治旗", value = "150724"),
        cityItem(label = "陈巴尔虎旗", value = "150725"),
        cityItem(label = "新巴尔虎左旗", value = "150726"),
        cityItem(label = "新巴尔虎右旗", value = "150727"),
        cityItem(label = "满洲里市", value = "150781"),
        cityItem(label = "牙克石市", value = "150782"),
        cityItem(label = "扎兰屯市", value = "150783"),
        cityItem(label = "额尔古纳市", value = "150784"),
        cityItem(label = "根河市", value = "150785")
    ),
    utsArrayOf(
        cityItem(label = "临河区", value = "150802"),
        cityItem(label = "五原县", value = "150821"),
        cityItem(label = "磴口县", value = "150822"),
        cityItem(label = "乌拉特前旗", value = "150823"),
        cityItem(label = "乌拉特中旗", value = "150824"),
        cityItem(label = "乌拉特后旗", value = "150825"),
        cityItem(label = "杭锦后旗", value = "150826")
    ),
    utsArrayOf(
        cityItem(label = "集宁区", value = "150902"),
        cityItem(label = "卓资县", value = "150921"),
        cityItem(label = "化德县", value = "150922"),
        cityItem(label = "商都县", value = "150923"),
        cityItem(label = "兴和县", value = "150924"),
        cityItem(label = "凉城县", value = "150925"),
        cityItem(label = "察哈尔右翼前旗", value = "150926"),
        cityItem(label = "察哈尔右翼中旗", value = "150927"),
        cityItem(label = "察哈尔右翼后旗", value = "150928"),
        cityItem(label = "四子王旗", value = "150929"),
        cityItem(label = "丰镇市", value = "150981")
    ),
    utsArrayOf(
        cityItem(label = "乌兰浩特市", value = "152201"),
        cityItem(label = "阿尔山市", value = "152202"),
        cityItem(label = "科尔沁右翼前旗", value = "152221"),
        cityItem(label = "科尔沁右翼中旗", value = "152222"),
        cityItem(label = "扎赉特旗", value = "152223"),
        cityItem(label = "突泉县", value = "152224")
    ),
    utsArrayOf(
        cityItem(label = "二连浩特市", value = "152501"),
        cityItem(label = "锡林浩特市", value = "152502"),
        cityItem(label = "阿巴嘎旗", value = "152522"),
        cityItem(label = "苏尼特左旗", value = "152523"),
        cityItem(label = "苏尼特右旗", value = "152524"),
        cityItem(label = "东乌珠穆沁旗", value = "152525"),
        cityItem(label = "西乌珠穆沁旗", value = "152526"),
        cityItem(label = "太仆寺旗", value = "152527"),
        cityItem(label = "镶黄旗", value = "152528"),
        cityItem(label = "正镶白旗", value = "152529"),
        cityItem(label = "正蓝旗", value = "152530"),
        cityItem(label = "多伦县", value = "152531"),
        cityItem(label = "乌拉盖管委会", value = "152571")
    ),
    utsArrayOf(
        cityItem(label = "阿拉善左旗", value = "152921"),
        cityItem(label = "阿拉善右旗", value = "152922"),
        cityItem(label = "额济纳旗", value = "152923"),
        cityItem(label = "内蒙古阿拉善经济开发区", value = "152971")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "和平区", value = "210102"),
        cityItem(label = "沈河区", value = "210103"),
        cityItem(label = "大东区", value = "210104"),
        cityItem(label = "皇姑区", value = "210105"),
        cityItem(label = "铁西区", value = "210106"),
        cityItem(label = "苏家屯区", value = "210111"),
        cityItem(label = "浑南区", value = "210112"),
        cityItem(label = "沈北新区", value = "210113"),
        cityItem(label = "于洪区", value = "210114"),
        cityItem(label = "辽中区", value = "210115"),
        cityItem(label = "康平县", value = "210123"),
        cityItem(label = "法库县", value = "210124"),
        cityItem(label = "新民市", value = "210181")
    ),
    utsArrayOf(
        cityItem(label = "中山区", value = "210202"),
        cityItem(label = "西岗区", value = "210203"),
        cityItem(label = "沙河口区", value = "210204"),
        cityItem(label = "甘井子区", value = "210211"),
        cityItem(label = "旅顺口区", value = "210212"),
        cityItem(label = "金州区", value = "210213"),
        cityItem(label = "普兰店区", value = "210214"),
        cityItem(label = "长海县", value = "210224"),
        cityItem(label = "瓦房店市", value = "210281"),
        cityItem(label = "庄河市", value = "210283")
    ),
    utsArrayOf(
        cityItem(label = "铁东区", value = "210302"),
        cityItem(label = "铁西区", value = "210303"),
        cityItem(label = "立山区", value = "210304"),
        cityItem(label = "千山区", value = "210311"),
        cityItem(label = "台安县", value = "210321"),
        cityItem(label = "岫岩满族自治县", value = "210323"),
        cityItem(label = "海城市", value = "210381")
    ),
    utsArrayOf(
        cityItem(label = "新抚区", value = "210402"),
        cityItem(label = "东洲区", value = "210403"),
        cityItem(label = "望花区", value = "210404"),
        cityItem(label = "顺城区", value = "210411"),
        cityItem(label = "抚顺县", value = "210421"),
        cityItem(label = "新宾满族自治县", value = "210422"),
        cityItem(label = "清原满族自治县", value = "210423")
    ),
    utsArrayOf(
        cityItem(label = "平山区", value = "210502"),
        cityItem(label = "溪湖区", value = "210503"),
        cityItem(label = "明山区", value = "210504"),
        cityItem(label = "南芬区", value = "210505"),
        cityItem(label = "本溪满族自治县", value = "210521"),
        cityItem(label = "桓仁满族自治县", value = "210522")
    ),
    utsArrayOf(
        cityItem(label = "元宝区", value = "210602"),
        cityItem(label = "振兴区", value = "210603"),
        cityItem(label = "振安区", value = "210604"),
        cityItem(label = "宽甸满族自治县", value = "210624"),
        cityItem(label = "东港市", value = "210681"),
        cityItem(label = "凤城市", value = "210682")
    ),
    utsArrayOf(
        cityItem(label = "古塔区", value = "210702"),
        cityItem(label = "凌河区", value = "210703"),
        cityItem(label = "太和区", value = "210711"),
        cityItem(label = "黑山县", value = "210726"),
        cityItem(label = "义县", value = "210727"),
        cityItem(label = "凌海市", value = "210781"),
        cityItem(label = "北镇市", value = "210782")
    ),
    utsArrayOf(
        cityItem(label = "站前区", value = "210802"),
        cityItem(label = "西市区", value = "210803"),
        cityItem(label = "鲅鱼圈区", value = "210804"),
        cityItem(label = "老边区", value = "210811"),
        cityItem(label = "盖州市", value = "210881"),
        cityItem(label = "大石桥市", value = "210882")
    ),
    utsArrayOf(
        cityItem(label = "海州区", value = "210902"),
        cityItem(label = "新邱区", value = "210903"),
        cityItem(label = "太平区", value = "210904"),
        cityItem(label = "清河门区", value = "210905"),
        cityItem(label = "细河区", value = "210911"),
        cityItem(label = "阜新蒙古族自治县", value = "210921"),
        cityItem(label = "彰武县", value = "210922")
    ),
    utsArrayOf(
        cityItem(label = "白塔区", value = "211002"),
        cityItem(label = "文圣区", value = "211003"),
        cityItem(label = "宏伟区", value = "211004"),
        cityItem(label = "弓长岭区", value = "211005"),
        cityItem(label = "太子河区", value = "211011"),
        cityItem(label = "辽阳县", value = "211021"),
        cityItem(label = "灯塔市", value = "211081")
    ),
    utsArrayOf(
        cityItem(label = "双台子区", value = "211102"),
        cityItem(label = "兴隆台区", value = "211103"),
        cityItem(label = "大洼区", value = "211104"),
        cityItem(label = "盘山县", value = "211122")
    ),
    utsArrayOf(
        cityItem(label = "银州区", value = "211202"),
        cityItem(label = "清河区", value = "211204"),
        cityItem(label = "铁岭县", value = "211221"),
        cityItem(label = "西丰县", value = "211223"),
        cityItem(label = "昌图县", value = "211224"),
        cityItem(label = "调兵山市", value = "211281"),
        cityItem(label = "开原市", value = "211282")
    ),
    utsArrayOf(
        cityItem(label = "双塔区", value = "211302"),
        cityItem(label = "龙城区", value = "211303"),
        cityItem(label = "朝阳县", value = "211321"),
        cityItem(label = "建平县", value = "211322"),
        cityItem(label = "喀喇沁左翼蒙古族自治县", value = "211324"),
        cityItem(label = "北票市", value = "211381"),
        cityItem(label = "凌源市", value = "211382")
    ),
    utsArrayOf(
        cityItem(label = "连山区", value = "211402"),
        cityItem(label = "龙港区", value = "211403"),
        cityItem(label = "南票区", value = "211404"),
        cityItem(label = "绥中县", value = "211421"),
        cityItem(label = "建昌县", value = "211422"),
        cityItem(label = "兴城市", value = "211481")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "南关区", value = "220102"),
        cityItem(label = "宽城区", value = "220103"),
        cityItem(label = "朝阳区", value = "220104"),
        cityItem(label = "二道区", value = "220105"),
        cityItem(label = "绿园区", value = "220106"),
        cityItem(label = "双阳区", value = "220112"),
        cityItem(label = "九台区", value = "220113"),
        cityItem(label = "农安县", value = "220122"),
        cityItem(label = "长春经济技术开发区", value = "220171"),
        cityItem(label = "长春净月高新技术产业开发区", value = "220172"),
        cityItem(label = "长春高新技术产业开发区", value = "220173"),
        cityItem(label = "长春汽车经济技术开发区", value = "220174"),
        cityItem(label = "榆树市", value = "220182"),
        cityItem(label = "德惠市", value = "220183")
    ),
    utsArrayOf(
        cityItem(label = "昌邑区", value = "220202"),
        cityItem(label = "龙潭区", value = "220203"),
        cityItem(label = "船营区", value = "220204"),
        cityItem(label = "丰满区", value = "220211"),
        cityItem(label = "永吉县", value = "220221"),
        cityItem(label = "吉林经济开发区", value = "220271"),
        cityItem(label = "吉林高新技术产业开发区", value = "220272"),
        cityItem(label = "吉林中国新加坡食品区", value = "220273"),
        cityItem(label = "蛟河市", value = "220281"),
        cityItem(label = "桦甸市", value = "220282"),
        cityItem(label = "舒兰市", value = "220283"),
        cityItem(label = "磐石市", value = "220284")
    ),
    utsArrayOf(
        cityItem(label = "铁西区", value = "220302"),
        cityItem(label = "铁东区", value = "220303"),
        cityItem(label = "梨树县", value = "220322"),
        cityItem(label = "伊通满族自治县", value = "220323"),
        cityItem(label = "公主岭市", value = "220381"),
        cityItem(label = "双辽市", value = "220382")
    ),
    utsArrayOf(
        cityItem(label = "龙山区", value = "220402"),
        cityItem(label = "西安区", value = "220403"),
        cityItem(label = "东丰县", value = "220421"),
        cityItem(label = "东辽县", value = "220422")
    ),
    utsArrayOf(
        cityItem(label = "东昌区", value = "220502"),
        cityItem(label = "二道江区", value = "220503"),
        cityItem(label = "通化县", value = "220521"),
        cityItem(label = "辉南县", value = "220523"),
        cityItem(label = "柳河县", value = "220524"),
        cityItem(label = "梅河口市", value = "220581"),
        cityItem(label = "集安市", value = "220582")
    ),
    utsArrayOf(
        cityItem(label = "浑江区", value = "220602"),
        cityItem(label = "江源区", value = "220605"),
        cityItem(label = "抚松县", value = "220621"),
        cityItem(label = "靖宇县", value = "220622"),
        cityItem(label = "长白朝鲜族自治县", value = "220623"),
        cityItem(label = "临江市", value = "220681")
    ),
    utsArrayOf(
        cityItem(label = "宁江区", value = "220702"),
        cityItem(label = "前郭尔罗斯蒙古族自治县", value = "220721"),
        cityItem(label = "长岭县", value = "220722"),
        cityItem(label = "乾安县", value = "220723"),
        cityItem(label = "吉林松原经济开发区", value = "220771"),
        cityItem(label = "扶余市", value = "220781")
    ),
    utsArrayOf(
        cityItem(label = "洮北区", value = "220802"),
        cityItem(label = "镇赉县", value = "220821"),
        cityItem(label = "通榆县", value = "220822"),
        cityItem(label = "吉林白城经济开发区", value = "220871"),
        cityItem(label = "洮南市", value = "220881"),
        cityItem(label = "大安市", value = "220882")
    ),
    utsArrayOf(
        cityItem(label = "延吉市", value = "222401"),
        cityItem(label = "图们市", value = "222402"),
        cityItem(label = "敦化市", value = "222403"),
        cityItem(label = "珲春市", value = "222404"),
        cityItem(label = "龙井市", value = "222405"),
        cityItem(label = "和龙市", value = "222406"),
        cityItem(label = "汪清县", value = "222424"),
        cityItem(label = "安图县", value = "222426")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "道里区", value = "230102"),
        cityItem(label = "南岗区", value = "230103"),
        cityItem(label = "道外区", value = "230104"),
        cityItem(label = "平房区", value = "230108"),
        cityItem(label = "松北区", value = "230109"),
        cityItem(label = "香坊区", value = "230110"),
        cityItem(label = "呼兰区", value = "230111"),
        cityItem(label = "阿城区", value = "230112"),
        cityItem(label = "双城区", value = "230113"),
        cityItem(label = "依兰县", value = "230123"),
        cityItem(label = "方正县", value = "230124"),
        cityItem(label = "宾县", value = "230125"),
        cityItem(label = "巴彦县", value = "230126"),
        cityItem(label = "木兰县", value = "230127"),
        cityItem(label = "通河县", value = "230128"),
        cityItem(label = "延寿县", value = "230129"),
        cityItem(label = "尚志市", value = "230183"),
        cityItem(label = "五常市", value = "230184")
    ),
    utsArrayOf(
        cityItem(label = "龙沙区", value = "230202"),
        cityItem(label = "建华区", value = "230203"),
        cityItem(label = "铁锋区", value = "230204"),
        cityItem(label = "昂昂溪区", value = "230205"),
        cityItem(label = "富拉尔基区", value = "230206"),
        cityItem(label = "碾子山区", value = "230207"),
        cityItem(label = "梅里斯达斡尔族区", value = "230208"),
        cityItem(label = "龙江县", value = "230221"),
        cityItem(label = "依安县", value = "230223"),
        cityItem(label = "泰来县", value = "230224"),
        cityItem(label = "甘南县", value = "230225"),
        cityItem(label = "富裕县", value = "230227"),
        cityItem(label = "克山县", value = "230229"),
        cityItem(label = "克东县", value = "230230"),
        cityItem(label = "拜泉县", value = "230231"),
        cityItem(label = "讷河市", value = "230281")
    ),
    utsArrayOf(
        cityItem(label = "鸡冠区", value = "230302"),
        cityItem(label = "恒山区", value = "230303"),
        cityItem(label = "滴道区", value = "230304"),
        cityItem(label = "梨树区", value = "230305"),
        cityItem(label = "城子河区", value = "230306"),
        cityItem(label = "麻山区", value = "230307"),
        cityItem(label = "鸡东县", value = "230321"),
        cityItem(label = "虎林市", value = "230381"),
        cityItem(label = "密山市", value = "230382")
    ),
    utsArrayOf(
        cityItem(label = "向阳区", value = "230402"),
        cityItem(label = "工农区", value = "230403"),
        cityItem(label = "南山区", value = "230404"),
        cityItem(label = "兴安区", value = "230405"),
        cityItem(label = "东山区", value = "230406"),
        cityItem(label = "兴山区", value = "230407"),
        cityItem(label = "萝北县", value = "230421"),
        cityItem(label = "绥滨县", value = "230422")
    ),
    utsArrayOf(
        cityItem(label = "尖山区", value = "230502"),
        cityItem(label = "岭东区", value = "230503"),
        cityItem(label = "四方台区", value = "230505"),
        cityItem(label = "宝山区", value = "230506"),
        cityItem(label = "集贤县", value = "230521"),
        cityItem(label = "友谊县", value = "230522"),
        cityItem(label = "宝清县", value = "230523"),
        cityItem(label = "饶河县", value = "230524")
    ),
    utsArrayOf(
        cityItem(label = "萨尔图区", value = "230602"),
        cityItem(label = "龙凤区", value = "230603"),
        cityItem(label = "让胡路区", value = "230604"),
        cityItem(label = "红岗区", value = "230605"),
        cityItem(label = "大同区", value = "230606"),
        cityItem(label = "肇州县", value = "230621"),
        cityItem(label = "肇源县", value = "230622"),
        cityItem(label = "林甸县", value = "230623"),
        cityItem(label = "杜尔伯特蒙古族自治县", value = "230624"),
        cityItem(label = "大庆高新技术产业开发区", value = "230671")
    ),
    utsArrayOf(
        cityItem(label = "伊春区", value = "230702"),
        cityItem(label = "南岔区", value = "230703"),
        cityItem(label = "友好区", value = "230704"),
        cityItem(label = "西林区", value = "230705"),
        cityItem(label = "翠峦区", value = "230706"),
        cityItem(label = "新青区", value = "230707"),
        cityItem(label = "美溪区", value = "230708"),
        cityItem(label = "金山屯区", value = "230709"),
        cityItem(label = "五营区", value = "230710"),
        cityItem(label = "乌马河区", value = "230711"),
        cityItem(label = "汤旺河区", value = "230712"),
        cityItem(label = "带岭区", value = "230713"),
        cityItem(label = "乌伊岭区", value = "230714"),
        cityItem(label = "红星区", value = "230715"),
        cityItem(label = "上甘岭区", value = "230716"),
        cityItem(label = "嘉荫县", value = "230722"),
        cityItem(label = "铁力市", value = "230781")
    ),
    utsArrayOf(
        cityItem(label = "向阳区", value = "230803"),
        cityItem(label = "前进区", value = "230804"),
        cityItem(label = "东风区", value = "230805"),
        cityItem(label = "郊区", value = "230811"),
        cityItem(label = "桦南县", value = "230822"),
        cityItem(label = "桦川县", value = "230826"),
        cityItem(label = "汤原县", value = "230828"),
        cityItem(label = "同江市", value = "230881"),
        cityItem(label = "富锦市", value = "230882"),
        cityItem(label = "抚远市", value = "230883")
    ),
    utsArrayOf(
        cityItem(label = "新兴区", value = "230902"),
        cityItem(label = "桃山区", value = "230903"),
        cityItem(label = "茄子河区", value = "230904"),
        cityItem(label = "勃利县", value = "230921")
    ),
    utsArrayOf(
        cityItem(label = "东安区", value = "231002"),
        cityItem(label = "阳明区", value = "231003"),
        cityItem(label = "爱民区", value = "231004"),
        cityItem(label = "西安区", value = "231005"),
        cityItem(label = "林口县", value = "231025"),
        cityItem(label = "牡丹江经济技术开发区", value = "231071"),
        cityItem(label = "绥芬河市", value = "231081"),
        cityItem(label = "海林市", value = "231083"),
        cityItem(label = "宁安市", value = "231084"),
        cityItem(label = "穆棱市", value = "231085"),
        cityItem(label = "东宁市", value = "231086")
    ),
    utsArrayOf(
        cityItem(label = "爱辉区", value = "231102"),
        cityItem(label = "嫩江县", value = "231121"),
        cityItem(label = "逊克县", value = "231123"),
        cityItem(label = "孙吴县", value = "231124"),
        cityItem(label = "北安市", value = "231181"),
        cityItem(label = "五大连池市", value = "231182")
    ),
    utsArrayOf(
        cityItem(label = "北林区", value = "231202"),
        cityItem(label = "望奎县", value = "231221"),
        cityItem(label = "兰西县", value = "231222"),
        cityItem(label = "青冈县", value = "231223"),
        cityItem(label = "庆安县", value = "231224"),
        cityItem(label = "明水县", value = "231225"),
        cityItem(label = "绥棱县", value = "231226"),
        cityItem(label = "安达市", value = "231281"),
        cityItem(label = "肇东市", value = "231282"),
        cityItem(label = "海伦市", value = "231283")
    ),
    utsArrayOf(
        cityItem(label = "加格达奇区", value = "232701"),
        cityItem(label = "松岭区", value = "232702"),
        cityItem(label = "新林区", value = "232703"),
        cityItem(label = "呼中区", value = "232704"),
        cityItem(label = "呼玛县", value = "232721"),
        cityItem(label = "塔河县", value = "232722"),
        cityItem(label = "漠河县", value = "232723")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "黄浦区", value = "310101"),
        cityItem(label = "徐汇区", value = "310104"),
        cityItem(label = "长宁区", value = "310105"),
        cityItem(label = "静安区", value = "310106"),
        cityItem(label = "普陀区", value = "310107"),
        cityItem(label = "虹口区", value = "310109"),
        cityItem(label = "杨浦区", value = "310110"),
        cityItem(label = "闵行区", value = "310112"),
        cityItem(label = "宝山区", value = "310113"),
        cityItem(label = "嘉定区", value = "310114"),
        cityItem(label = "浦东新区", value = "310115"),
        cityItem(label = "金山区", value = "310116"),
        cityItem(label = "松江区", value = "310117"),
        cityItem(label = "青浦区", value = "310118"),
        cityItem(label = "奉贤区", value = "310120"),
        cityItem(label = "崇明区", value = "310151")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "玄武区", value = "320102"),
        cityItem(label = "秦淮区", value = "320104"),
        cityItem(label = "建邺区", value = "320105"),
        cityItem(label = "鼓楼区", value = "320106"),
        cityItem(label = "浦口区", value = "320111"),
        cityItem(label = "栖霞区", value = "320113"),
        cityItem(label = "雨花台区", value = "320114"),
        cityItem(label = "江宁区", value = "320115"),
        cityItem(label = "六合区", value = "320116"),
        cityItem(label = "溧水区", value = "320117"),
        cityItem(label = "高淳区", value = "320118")
    ),
    utsArrayOf(
        cityItem(label = "锡山区", value = "320205"),
        cityItem(label = "惠山区", value = "320206"),
        cityItem(label = "滨湖区", value = "320211"),
        cityItem(label = "梁溪区", value = "320213"),
        cityItem(label = "新吴区", value = "320214"),
        cityItem(label = "江阴市", value = "320281"),
        cityItem(label = "宜兴市", value = "320282")
    ),
    utsArrayOf(
        cityItem(label = "鼓楼区", value = "320302"),
        cityItem(label = "云龙区", value = "320303"),
        cityItem(label = "贾汪区", value = "320305"),
        cityItem(label = "泉山区", value = "320311"),
        cityItem(label = "铜山区", value = "320312"),
        cityItem(label = "丰县", value = "320321"),
        cityItem(label = "沛县", value = "320322"),
        cityItem(label = "睢宁县", value = "320324"),
        cityItem(label = "徐州经济技术开发区", value = "320371"),
        cityItem(label = "新沂市", value = "320381"),
        cityItem(label = "邳州市", value = "320382")
    ),
    utsArrayOf(
        cityItem(label = "天宁区", value = "320402"),
        cityItem(label = "钟楼区", value = "320404"),
        cityItem(label = "新北区", value = "320411"),
        cityItem(label = "武进区", value = "320412"),
        cityItem(label = "金坛区", value = "320413"),
        cityItem(label = "溧阳市", value = "320481")
    ),
    utsArrayOf(
        cityItem(label = "虎丘区", value = "320505"),
        cityItem(label = "吴中区", value = "320506"),
        cityItem(label = "相城区", value = "320507"),
        cityItem(label = "姑苏区", value = "320508"),
        cityItem(label = "吴江区", value = "320509"),
        cityItem(label = "苏州工业园区", value = "320571"),
        cityItem(label = "常熟市", value = "320581"),
        cityItem(label = "张家港市", value = "320582"),
        cityItem(label = "昆山市", value = "320583"),
        cityItem(label = "太仓市", value = "320585")
    ),
    utsArrayOf(
        cityItem(label = "崇川区", value = "320602"),
        cityItem(label = "港闸区", value = "320611"),
        cityItem(label = "通州区", value = "320612"),
        cityItem(label = "海安县", value = "320621"),
        cityItem(label = "如东县", value = "320623"),
        cityItem(label = "南通经济技术开发区", value = "320671"),
        cityItem(label = "启东市", value = "320681"),
        cityItem(label = "如皋市", value = "320682"),
        cityItem(label = "海门市", value = "320684")
    ),
    utsArrayOf(
        cityItem(label = "连云区", value = "320703"),
        cityItem(label = "海州区", value = "320706"),
        cityItem(label = "赣榆区", value = "320707"),
        cityItem(label = "东海县", value = "320722"),
        cityItem(label = "灌云县", value = "320723"),
        cityItem(label = "灌南县", value = "320724"),
        cityItem(label = "连云港经济技术开发区", value = "320771"),
        cityItem(label = "连云港高新技术产业开发区", value = "320772")
    ),
    utsArrayOf(
        cityItem(label = "淮安区", value = "320803"),
        cityItem(label = "淮阴区", value = "320804"),
        cityItem(label = "清江浦区", value = "320812"),
        cityItem(label = "洪泽区", value = "320813"),
        cityItem(label = "涟水县", value = "320826"),
        cityItem(label = "盱眙县", value = "320830"),
        cityItem(label = "金湖县", value = "320831"),
        cityItem(label = "淮安经济技术开发区", value = "320871")
    ),
    utsArrayOf(
        cityItem(label = "亭湖区", value = "320902"),
        cityItem(label = "盐都区", value = "320903"),
        cityItem(label = "大丰区", value = "320904"),
        cityItem(label = "响水县", value = "320921"),
        cityItem(label = "滨海县", value = "320922"),
        cityItem(label = "阜宁县", value = "320923"),
        cityItem(label = "射阳县", value = "320924"),
        cityItem(label = "建湖县", value = "320925"),
        cityItem(label = "盐城经济技术开发区", value = "320971"),
        cityItem(label = "东台市", value = "320981")
    ),
    utsArrayOf(
        cityItem(label = "广陵区", value = "321002"),
        cityItem(label = "邗江区", value = "321003"),
        cityItem(label = "江都区", value = "321012"),
        cityItem(label = "宝应县", value = "321023"),
        cityItem(label = "扬州经济技术开发区", value = "321071"),
        cityItem(label = "仪征市", value = "321081"),
        cityItem(label = "高邮市", value = "321084")
    ),
    utsArrayOf(
        cityItem(label = "京口区", value = "321102"),
        cityItem(label = "润州区", value = "321111"),
        cityItem(label = "丹徒区", value = "321112"),
        cityItem(label = "镇江新区", value = "321171"),
        cityItem(label = "丹阳市", value = "321181"),
        cityItem(label = "扬中市", value = "321182"),
        cityItem(label = "句容市", value = "321183")
    ),
    utsArrayOf(
        cityItem(label = "海陵区", value = "321202"),
        cityItem(label = "高港区", value = "321203"),
        cityItem(label = "姜堰区", value = "321204"),
        cityItem(label = "泰州医药高新技术产业开发区", value = "321271"),
        cityItem(label = "兴化市", value = "321281"),
        cityItem(label = "靖江市", value = "321282"),
        cityItem(label = "泰兴市", value = "321283")
    ),
    utsArrayOf(
        cityItem(label = "宿城区", value = "321302"),
        cityItem(label = "宿豫区", value = "321311"),
        cityItem(label = "沭阳县", value = "321322"),
        cityItem(label = "泗阳县", value = "321323"),
        cityItem(label = "泗洪县", value = "321324"),
        cityItem(label = "宿迁经济技术开发区", value = "321371")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "上城区", value = "330102"),
        cityItem(label = "下城区", value = "330103"),
        cityItem(label = "江干区", value = "330104"),
        cityItem(label = "拱墅区", value = "330105"),
        cityItem(label = "西湖区", value = "330106"),
        cityItem(label = "滨江区", value = "330108"),
        cityItem(label = "萧山区", value = "330109"),
        cityItem(label = "余杭区", value = "330110"),
        cityItem(label = "富阳区", value = "330111"),
        cityItem(label = "临安区", value = "330112"),
        cityItem(label = "桐庐县", value = "330122"),
        cityItem(label = "淳安县", value = "330127"),
        cityItem(label = "建德市", value = "330182")
    ),
    utsArrayOf(
        cityItem(label = "海曙区", value = "330203"),
        cityItem(label = "江北区", value = "330205"),
        cityItem(label = "北仑区", value = "330206"),
        cityItem(label = "镇海区", value = "330211"),
        cityItem(label = "鄞州区", value = "330212"),
        cityItem(label = "奉化区", value = "330213"),
        cityItem(label = "象山县", value = "330225"),
        cityItem(label = "宁海县", value = "330226"),
        cityItem(label = "余姚市", value = "330281"),
        cityItem(label = "慈溪市", value = "330282")
    ),
    utsArrayOf(
        cityItem(label = "鹿城区", value = "330302"),
        cityItem(label = "龙湾区", value = "330303"),
        cityItem(label = "瓯海区", value = "330304"),
        cityItem(label = "洞头区", value = "330305"),
        cityItem(label = "永嘉县", value = "330324"),
        cityItem(label = "平阳县", value = "330326"),
        cityItem(label = "苍南县", value = "330327"),
        cityItem(label = "文成县", value = "330328"),
        cityItem(label = "泰顺县", value = "330329"),
        cityItem(label = "温州经济技术开发区", value = "330371"),
        cityItem(label = "瑞安市", value = "330381"),
        cityItem(label = "乐清市", value = "330382")
    ),
    utsArrayOf(
        cityItem(label = "南湖区", value = "330402"),
        cityItem(label = "秀洲区", value = "330411"),
        cityItem(label = "嘉善县", value = "330421"),
        cityItem(label = "海盐县", value = "330424"),
        cityItem(label = "海宁市", value = "330481"),
        cityItem(label = "平湖市", value = "330482"),
        cityItem(label = "桐乡市", value = "330483")
    ),
    utsArrayOf(
        cityItem(label = "吴兴区", value = "330502"),
        cityItem(label = "南浔区", value = "330503"),
        cityItem(label = "德清县", value = "330521"),
        cityItem(label = "长兴县", value = "330522"),
        cityItem(label = "安吉县", value = "330523")
    ),
    utsArrayOf(
        cityItem(label = "越城区", value = "330602"),
        cityItem(label = "柯桥区", value = "330603"),
        cityItem(label = "上虞区", value = "330604"),
        cityItem(label = "新昌县", value = "330624"),
        cityItem(label = "诸暨市", value = "330681"),
        cityItem(label = "嵊州市", value = "330683")
    ),
    utsArrayOf(
        cityItem(label = "婺城区", value = "330702"),
        cityItem(label = "金东区", value = "330703"),
        cityItem(label = "武义县", value = "330723"),
        cityItem(label = "浦江县", value = "330726"),
        cityItem(label = "磐安县", value = "330727"),
        cityItem(label = "兰溪市", value = "330781"),
        cityItem(label = "义乌市", value = "330782"),
        cityItem(label = "东阳市", value = "330783"),
        cityItem(label = "永康市", value = "330784")
    ),
    utsArrayOf(
        cityItem(label = "柯城区", value = "330802"),
        cityItem(label = "衢江区", value = "330803"),
        cityItem(label = "常山县", value = "330822"),
        cityItem(label = "开化县", value = "330824"),
        cityItem(label = "龙游县", value = "330825"),
        cityItem(label = "江山市", value = "330881")
    ),
    utsArrayOf(
        cityItem(label = "定海区", value = "330902"),
        cityItem(label = "普陀区", value = "330903"),
        cityItem(label = "岱山县", value = "330921"),
        cityItem(label = "嵊泗县", value = "330922")
    ),
    utsArrayOf(
        cityItem(label = "椒江区", value = "331002"),
        cityItem(label = "黄岩区", value = "331003"),
        cityItem(label = "路桥区", value = "331004"),
        cityItem(label = "三门县", value = "331022"),
        cityItem(label = "天台县", value = "331023"),
        cityItem(label = "仙居县", value = "331024"),
        cityItem(label = "温岭市", value = "331081"),
        cityItem(label = "临海市", value = "331082"),
        cityItem(label = "玉环市", value = "331083")
    ),
    utsArrayOf(
        cityItem(label = "莲都区", value = "331102"),
        cityItem(label = "青田县", value = "331121"),
        cityItem(label = "缙云县", value = "331122"),
        cityItem(label = "遂昌县", value = "331123"),
        cityItem(label = "松阳县", value = "331124"),
        cityItem(label = "云和县", value = "331125"),
        cityItem(label = "庆元县", value = "331126"),
        cityItem(label = "景宁畲族自治县", value = "331127"),
        cityItem(label = "龙泉市", value = "331181")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "瑶海区", value = "340102"),
        cityItem(label = "庐阳区", value = "340103"),
        cityItem(label = "蜀山区", value = "340104"),
        cityItem(label = "包河区", value = "340111"),
        cityItem(label = "长丰县", value = "340121"),
        cityItem(label = "肥东县", value = "340122"),
        cityItem(label = "肥西县", value = "340123"),
        cityItem(label = "庐江县", value = "340124"),
        cityItem(label = "合肥高新技术产业开发区", value = "340171"),
        cityItem(label = "合肥经济技术开发区", value = "340172"),
        cityItem(label = "合肥新站高新技术产业开发区", value = "340173"),
        cityItem(label = "巢湖市", value = "340181")
    ),
    utsArrayOf(
        cityItem(label = "镜湖区", value = "340202"),
        cityItem(label = "弋江区", value = "340203"),
        cityItem(label = "鸠江区", value = "340207"),
        cityItem(label = "三山区", value = "340208"),
        cityItem(label = "芜湖县", value = "340221"),
        cityItem(label = "繁昌县", value = "340222"),
        cityItem(label = "南陵县", value = "340223"),
        cityItem(label = "无为县", value = "340225"),
        cityItem(label = "芜湖经济技术开发区", value = "340271"),
        cityItem(label = "安徽芜湖长江大桥经济开发区", value = "340272")
    ),
    utsArrayOf(
        cityItem(label = "龙子湖区", value = "340302"),
        cityItem(label = "蚌山区", value = "340303"),
        cityItem(label = "禹会区", value = "340304"),
        cityItem(label = "淮上区", value = "340311"),
        cityItem(label = "怀远县", value = "340321"),
        cityItem(label = "五河县", value = "340322"),
        cityItem(label = "固镇县", value = "340323"),
        cityItem(label = "蚌埠市高新技术开发区", value = "340371"),
        cityItem(label = "蚌埠市经济开发区", value = "340372")
    ),
    utsArrayOf(
        cityItem(label = "大通区", value = "340402"),
        cityItem(label = "田家庵区", value = "340403"),
        cityItem(label = "谢家集区", value = "340404"),
        cityItem(label = "八公山区", value = "340405"),
        cityItem(label = "潘集区", value = "340406"),
        cityItem(label = "凤台县", value = "340421"),
        cityItem(label = "寿县", value = "340422")
    ),
    utsArrayOf(
        cityItem(label = "花山区", value = "340503"),
        cityItem(label = "雨山区", value = "340504"),
        cityItem(label = "博望区", value = "340506"),
        cityItem(label = "当涂县", value = "340521"),
        cityItem(label = "含山县", value = "340522"),
        cityItem(label = "和县", value = "340523")
    ),
    utsArrayOf(
        cityItem(label = "杜集区", value = "340602"),
        cityItem(label = "相山区", value = "340603"),
        cityItem(label = "烈山区", value = "340604"),
        cityItem(label = "濉溪县", value = "340621")
    ),
    utsArrayOf(
        cityItem(label = "铜官区", value = "340705"),
        cityItem(label = "义安区", value = "340706"),
        cityItem(label = "郊区", value = "340711"),
        cityItem(label = "枞阳县", value = "340722")
    ),
    utsArrayOf(
        cityItem(label = "迎江区", value = "340802"),
        cityItem(label = "大观区", value = "340803"),
        cityItem(label = "宜秀区", value = "340811"),
        cityItem(label = "怀宁县", value = "340822"),
        cityItem(label = "潜山县", value = "340824"),
        cityItem(label = "太湖县", value = "340825"),
        cityItem(label = "宿松县", value = "340826"),
        cityItem(label = "望江县", value = "340827"),
        cityItem(label = "岳西县", value = "340828"),
        cityItem(label = "安徽安庆经济开发区", value = "340871"),
        cityItem(label = "桐城市", value = "340881")
    ),
    utsArrayOf(
        cityItem(label = "屯溪区", value = "341002"),
        cityItem(label = "黄山区", value = "341003"),
        cityItem(label = "徽州区", value = "341004"),
        cityItem(label = "歙县", value = "341021"),
        cityItem(label = "休宁县", value = "341022"),
        cityItem(label = "黟县", value = "341023"),
        cityItem(label = "祁门县", value = "341024")
    ),
    utsArrayOf(
        cityItem(label = "琅琊区", value = "341102"),
        cityItem(label = "南谯区", value = "341103"),
        cityItem(label = "来安县", value = "341122"),
        cityItem(label = "全椒县", value = "341124"),
        cityItem(label = "定远县", value = "341125"),
        cityItem(label = "凤阳县", value = "341126"),
        cityItem(label = "苏滁现代产业园", value = "341171"),
        cityItem(label = "滁州经济技术开发区", value = "341172"),
        cityItem(label = "天长市", value = "341181"),
        cityItem(label = "明光市", value = "341182")
    ),
    utsArrayOf(
        cityItem(label = "颍州区", value = "341202"),
        cityItem(label = "颍东区", value = "341203"),
        cityItem(label = "颍泉区", value = "341204"),
        cityItem(label = "临泉县", value = "341221"),
        cityItem(label = "太和县", value = "341222"),
        cityItem(label = "阜南县", value = "341225"),
        cityItem(label = "颍上县", value = "341226"),
        cityItem(label = "阜阳合肥现代产业园区", value = "341271"),
        cityItem(label = "阜阳经济技术开发区", value = "341272"),
        cityItem(label = "界首市", value = "341282")
    ),
    utsArrayOf(
        cityItem(label = "埇桥区", value = "341302"),
        cityItem(label = "砀山县", value = "341321"),
        cityItem(label = "萧县", value = "341322"),
        cityItem(label = "灵璧县", value = "341323"),
        cityItem(label = "泗县", value = "341324"),
        cityItem(label = "宿州马鞍山现代产业园区", value = "341371"),
        cityItem(label = "宿州经济技术开发区", value = "341372")
    ),
    utsArrayOf(
        cityItem(label = "金安区", value = "341502"),
        cityItem(label = "裕安区", value = "341503"),
        cityItem(label = "叶集区", value = "341504"),
        cityItem(label = "霍邱县", value = "341522"),
        cityItem(label = "舒城县", value = "341523"),
        cityItem(label = "金寨县", value = "341524"),
        cityItem(label = "霍山县", value = "341525")
    ),
    utsArrayOf(
        cityItem(label = "谯城区", value = "341602"),
        cityItem(label = "涡阳县", value = "341621"),
        cityItem(label = "蒙城县", value = "341622"),
        cityItem(label = "利辛县", value = "341623")
    ),
    utsArrayOf(
        cityItem(label = "贵池区", value = "341702"),
        cityItem(label = "东至县", value = "341721"),
        cityItem(label = "石台县", value = "341722"),
        cityItem(label = "青阳县", value = "341723")
    ),
    utsArrayOf(
        cityItem(label = "宣州区", value = "341802"),
        cityItem(label = "郎溪县", value = "341821"),
        cityItem(label = "广德县", value = "341822"),
        cityItem(label = "泾县", value = "341823"),
        cityItem(label = "绩溪县", value = "341824"),
        cityItem(label = "旌德县", value = "341825"),
        cityItem(label = "宣城市经济开发区", value = "341871"),
        cityItem(label = "宁国市", value = "341881")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "鼓楼区", value = "350102"),
        cityItem(label = "台江区", value = "350103"),
        cityItem(label = "仓山区", value = "350104"),
        cityItem(label = "马尾区", value = "350105"),
        cityItem(label = "晋安区", value = "350111"),
        cityItem(label = "闽侯县", value = "350121"),
        cityItem(label = "连江县", value = "350122"),
        cityItem(label = "罗源县", value = "350123"),
        cityItem(label = "闽清县", value = "350124"),
        cityItem(label = "永泰县", value = "350125"),
        cityItem(label = "平潭县", value = "350128"),
        cityItem(label = "福清市", value = "350181"),
        cityItem(label = "长乐市", value = "350182")
    ),
    utsArrayOf(
        cityItem(label = "思明区", value = "350203"),
        cityItem(label = "海沧区", value = "350205"),
        cityItem(label = "湖里区", value = "350206"),
        cityItem(label = "集美区", value = "350211"),
        cityItem(label = "同安区", value = "350212"),
        cityItem(label = "翔安区", value = "350213")
    ),
    utsArrayOf(
        cityItem(label = "城厢区", value = "350302"),
        cityItem(label = "涵江区", value = "350303"),
        cityItem(label = "荔城区", value = "350304"),
        cityItem(label = "秀屿区", value = "350305"),
        cityItem(label = "仙游县", value = "350322")
    ),
    utsArrayOf(
        cityItem(label = "梅列区", value = "350402"),
        cityItem(label = "三元区", value = "350403"),
        cityItem(label = "明溪县", value = "350421"),
        cityItem(label = "清流县", value = "350423"),
        cityItem(label = "宁化县", value = "350424"),
        cityItem(label = "大田县", value = "350425"),
        cityItem(label = "尤溪县", value = "350426"),
        cityItem(label = "沙县", value = "350427"),
        cityItem(label = "将乐县", value = "350428"),
        cityItem(label = "泰宁县", value = "350429"),
        cityItem(label = "建宁县", value = "350430"),
        cityItem(label = "永安市", value = "350481")
    ),
    utsArrayOf(
        cityItem(label = "鲤城区", value = "350502"),
        cityItem(label = "丰泽区", value = "350503"),
        cityItem(label = "洛江区", value = "350504"),
        cityItem(label = "泉港区", value = "350505"),
        cityItem(label = "惠安县", value = "350521"),
        cityItem(label = "安溪县", value = "350524"),
        cityItem(label = "永春县", value = "350525"),
        cityItem(label = "德化县", value = "350526"),
        cityItem(label = "金门县", value = "350527"),
        cityItem(label = "石狮市", value = "350581"),
        cityItem(label = "晋江市", value = "350582"),
        cityItem(label = "南安市", value = "350583")
    ),
    utsArrayOf(
        cityItem(label = "芗城区", value = "350602"),
        cityItem(label = "龙文区", value = "350603"),
        cityItem(label = "云霄县", value = "350622"),
        cityItem(label = "漳浦县", value = "350623"),
        cityItem(label = "诏安县", value = "350624"),
        cityItem(label = "长泰县", value = "350625"),
        cityItem(label = "东山县", value = "350626"),
        cityItem(label = "南靖县", value = "350627"),
        cityItem(label = "平和县", value = "350628"),
        cityItem(label = "华安县", value = "350629"),
        cityItem(label = "龙海市", value = "350681")
    ),
    utsArrayOf(
        cityItem(label = "延平区", value = "350702"),
        cityItem(label = "建阳区", value = "350703"),
        cityItem(label = "顺昌县", value = "350721"),
        cityItem(label = "浦城县", value = "350722"),
        cityItem(label = "光泽县", value = "350723"),
        cityItem(label = "松溪县", value = "350724"),
        cityItem(label = "政和县", value = "350725"),
        cityItem(label = "邵武市", value = "350781"),
        cityItem(label = "武夷山市", value = "350782"),
        cityItem(label = "建瓯市", value = "350783")
    ),
    utsArrayOf(
        cityItem(label = "新罗区", value = "350802"),
        cityItem(label = "永定区", value = "350803"),
        cityItem(label = "长汀县", value = "350821"),
        cityItem(label = "上杭县", value = "350823"),
        cityItem(label = "武平县", value = "350824"),
        cityItem(label = "连城县", value = "350825"),
        cityItem(label = "漳平市", value = "350881")
    ),
    utsArrayOf(
        cityItem(label = "蕉城区", value = "350902"),
        cityItem(label = "霞浦县", value = "350921"),
        cityItem(label = "古田县", value = "350922"),
        cityItem(label = "屏南县", value = "350923"),
        cityItem(label = "寿宁县", value = "350924"),
        cityItem(label = "周宁县", value = "350925"),
        cityItem(label = "柘荣县", value = "350926"),
        cityItem(label = "福安市", value = "350981"),
        cityItem(label = "福鼎市", value = "350982")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "东湖区", value = "360102"),
        cityItem(label = "西湖区", value = "360103"),
        cityItem(label = "青云谱区", value = "360104"),
        cityItem(label = "湾里区", value = "360105"),
        cityItem(label = "青山湖区", value = "360111"),
        cityItem(label = "新建区", value = "360112"),
        cityItem(label = "南昌县", value = "360121"),
        cityItem(label = "安义县", value = "360123"),
        cityItem(label = "进贤县", value = "360124")
    ),
    utsArrayOf(
        cityItem(label = "昌江区", value = "360202"),
        cityItem(label = "珠山区", value = "360203"),
        cityItem(label = "浮梁县", value = "360222"),
        cityItem(label = "乐平市", value = "360281")
    ),
    utsArrayOf(
        cityItem(label = "安源区", value = "360302"),
        cityItem(label = "湘东区", value = "360313"),
        cityItem(label = "莲花县", value = "360321"),
        cityItem(label = "上栗县", value = "360322"),
        cityItem(label = "芦溪县", value = "360323")
    ),
    utsArrayOf(
        cityItem(label = "濂溪区", value = "360402"),
        cityItem(label = "浔阳区", value = "360403"),
        cityItem(label = "柴桑区", value = "360404"),
        cityItem(label = "武宁县", value = "360423"),
        cityItem(label = "修水县", value = "360424"),
        cityItem(label = "永修县", value = "360425"),
        cityItem(label = "德安县", value = "360426"),
        cityItem(label = "都昌县", value = "360428"),
        cityItem(label = "湖口县", value = "360429"),
        cityItem(label = "彭泽县", value = "360430"),
        cityItem(label = "瑞昌市", value = "360481"),
        cityItem(label = "共青城市", value = "360482"),
        cityItem(label = "庐山市", value = "360483")
    ),
    utsArrayOf(
        cityItem(label = "渝水区", value = "360502"),
        cityItem(label = "分宜县", value = "360521")
    ),
    utsArrayOf(
        cityItem(label = "月湖区", value = "360602"),
        cityItem(label = "余江县", value = "360622"),
        cityItem(label = "贵溪市", value = "360681")
    ),
    utsArrayOf(
        cityItem(label = "章贡区", value = "360702"),
        cityItem(label = "南康区", value = "360703"),
        cityItem(label = "赣县区", value = "360704"),
        cityItem(label = "信丰县", value = "360722"),
        cityItem(label = "大余县", value = "360723"),
        cityItem(label = "上犹县", value = "360724"),
        cityItem(label = "崇义县", value = "360725"),
        cityItem(label = "安远县", value = "360726"),
        cityItem(label = "龙南县", value = "360727"),
        cityItem(label = "定南县", value = "360728"),
        cityItem(label = "全南县", value = "360729"),
        cityItem(label = "宁都县", value = "360730"),
        cityItem(label = "于都县", value = "360731"),
        cityItem(label = "兴国县", value = "360732"),
        cityItem(label = "会昌县", value = "360733"),
        cityItem(label = "寻乌县", value = "360734"),
        cityItem(label = "石城县", value = "360735"),
        cityItem(label = "瑞金市", value = "360781")
    ),
    utsArrayOf(
        cityItem(label = "吉州区", value = "360802"),
        cityItem(label = "青原区", value = "360803"),
        cityItem(label = "吉安县", value = "360821"),
        cityItem(label = "吉水县", value = "360822"),
        cityItem(label = "峡江县", value = "360823"),
        cityItem(label = "新干县", value = "360824"),
        cityItem(label = "永丰县", value = "360825"),
        cityItem(label = "泰和县", value = "360826"),
        cityItem(label = "遂川县", value = "360827"),
        cityItem(label = "万安县", value = "360828"),
        cityItem(label = "安福县", value = "360829"),
        cityItem(label = "永新县", value = "360830"),
        cityItem(label = "井冈山市", value = "360881")
    ),
    utsArrayOf(
        cityItem(label = "袁州区", value = "360902"),
        cityItem(label = "奉新县", value = "360921"),
        cityItem(label = "万载县", value = "360922"),
        cityItem(label = "上高县", value = "360923"),
        cityItem(label = "宜丰县", value = "360924"),
        cityItem(label = "靖安县", value = "360925"),
        cityItem(label = "铜鼓县", value = "360926"),
        cityItem(label = "丰城市", value = "360981"),
        cityItem(label = "樟树市", value = "360982"),
        cityItem(label = "高安市", value = "360983")
    ),
    utsArrayOf(
        cityItem(label = "临川区", value = "361002"),
        cityItem(label = "东乡区", value = "361003"),
        cityItem(label = "南城县", value = "361021"),
        cityItem(label = "黎川县", value = "361022"),
        cityItem(label = "南丰县", value = "361023"),
        cityItem(label = "崇仁县", value = "361024"),
        cityItem(label = "乐安县", value = "361025"),
        cityItem(label = "宜黄县", value = "361026"),
        cityItem(label = "金溪县", value = "361027"),
        cityItem(label = "资溪县", value = "361028"),
        cityItem(label = "广昌县", value = "361030")
    ),
    utsArrayOf(
        cityItem(label = "信州区", value = "361102"),
        cityItem(label = "广丰区", value = "361103"),
        cityItem(label = "上饶县", value = "361121"),
        cityItem(label = "玉山县", value = "361123"),
        cityItem(label = "铅山县", value = "361124"),
        cityItem(label = "横峰县", value = "361125"),
        cityItem(label = "弋阳县", value = "361126"),
        cityItem(label = "余干县", value = "361127"),
        cityItem(label = "鄱阳县", value = "361128"),
        cityItem(label = "万年县", value = "361129"),
        cityItem(label = "婺源县", value = "361130"),
        cityItem(label = "德兴市", value = "361181")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "历下区", value = "370102"),
        cityItem(label = "市中区", value = "370103"),
        cityItem(label = "槐荫区", value = "370104"),
        cityItem(label = "天桥区", value = "370105"),
        cityItem(label = "历城区", value = "370112"),
        cityItem(label = "长清区", value = "370113"),
        cityItem(label = "章丘区", value = "370114"),
        cityItem(label = "平阴县", value = "370124"),
        cityItem(label = "济阳县", value = "370125"),
        cityItem(label = "商河县", value = "370126"),
        cityItem(label = "济南高新技术产业开发区", value = "370171")
    ),
    utsArrayOf(
        cityItem(label = "市南区", value = "370202"),
        cityItem(label = "市北区", value = "370203"),
        cityItem(label = "黄岛区", value = "370211"),
        cityItem(label = "崂山区", value = "370212"),
        cityItem(label = "李沧区", value = "370213"),
        cityItem(label = "城阳区", value = "370214"),
        cityItem(label = "即墨区", value = "370215"),
        cityItem(label = "青岛高新技术产业开发区", value = "370271"),
        cityItem(label = "胶州市", value = "370281"),
        cityItem(label = "平度市", value = "370283"),
        cityItem(label = "莱西市", value = "370285")
    ),
    utsArrayOf(
        cityItem(label = "淄川区", value = "370302"),
        cityItem(label = "张店区", value = "370303"),
        cityItem(label = "博山区", value = "370304"),
        cityItem(label = "临淄区", value = "370305"),
        cityItem(label = "周村区", value = "370306"),
        cityItem(label = "桓台县", value = "370321"),
        cityItem(label = "高青县", value = "370322"),
        cityItem(label = "沂源县", value = "370323")
    ),
    utsArrayOf(
        cityItem(label = "市中区", value = "370402"),
        cityItem(label = "薛城区", value = "370403"),
        cityItem(label = "峄城区", value = "370404"),
        cityItem(label = "台儿庄区", value = "370405"),
        cityItem(label = "山亭区", value = "370406"),
        cityItem(label = "滕州市", value = "370481")
    ),
    utsArrayOf(
        cityItem(label = "东营区", value = "370502"),
        cityItem(label = "河口区", value = "370503"),
        cityItem(label = "垦利区", value = "370505"),
        cityItem(label = "利津县", value = "370522"),
        cityItem(label = "广饶县", value = "370523"),
        cityItem(label = "东营经济技术开发区", value = "370571"),
        cityItem(label = "东营港经济开发区", value = "370572")
    ),
    utsArrayOf(
        cityItem(label = "芝罘区", value = "370602"),
        cityItem(label = "福山区", value = "370611"),
        cityItem(label = "牟平区", value = "370612"),
        cityItem(label = "莱山区", value = "370613"),
        cityItem(label = "长岛县", value = "370634"),
        cityItem(label = "烟台高新技术产业开发区", value = "370671"),
        cityItem(label = "烟台经济技术开发区", value = "370672"),
        cityItem(label = "龙口市", value = "370681"),
        cityItem(label = "莱阳市", value = "370682"),
        cityItem(label = "莱州市", value = "370683"),
        cityItem(label = "蓬莱市", value = "370684"),
        cityItem(label = "招远市", value = "370685"),
        cityItem(label = "栖霞市", value = "370686"),
        cityItem(label = "海阳市", value = "370687")
    ),
    utsArrayOf(
        cityItem(label = "潍城区", value = "370702"),
        cityItem(label = "寒亭区", value = "370703"),
        cityItem(label = "坊子区", value = "370704"),
        cityItem(label = "奎文区", value = "370705"),
        cityItem(label = "临朐县", value = "370724"),
        cityItem(label = "昌乐县", value = "370725"),
        cityItem(label = "潍坊滨海经济技术开发区", value = "370772"),
        cityItem(label = "青州市", value = "370781"),
        cityItem(label = "诸城市", value = "370782"),
        cityItem(label = "寿光市", value = "370783"),
        cityItem(label = "安丘市", value = "370784"),
        cityItem(label = "高密市", value = "370785"),
        cityItem(label = "昌邑市", value = "370786")
    ),
    utsArrayOf(
        cityItem(label = "任城区", value = "370811"),
        cityItem(label = "兖州区", value = "370812"),
        cityItem(label = "微山县", value = "370826"),
        cityItem(label = "鱼台县", value = "370827"),
        cityItem(label = "金乡县", value = "370828"),
        cityItem(label = "嘉祥县", value = "370829"),
        cityItem(label = "汶上县", value = "370830"),
        cityItem(label = "泗水县", value = "370831"),
        cityItem(label = "梁山县", value = "370832"),
        cityItem(label = "济宁高新技术产业开发区", value = "370871"),
        cityItem(label = "曲阜市", value = "370881"),
        cityItem(label = "邹城市", value = "370883")
    ),
    utsArrayOf(
        cityItem(label = "泰山区", value = "370902"),
        cityItem(label = "岱岳区", value = "370911"),
        cityItem(label = "宁阳县", value = "370921"),
        cityItem(label = "东平县", value = "370923"),
        cityItem(label = "新泰市", value = "370982"),
        cityItem(label = "肥城市", value = "370983")
    ),
    utsArrayOf(
        cityItem(label = "环翠区", value = "371002"),
        cityItem(label = "文登区", value = "371003"),
        cityItem(label = "威海火炬高技术产业开发区", value = "371071"),
        cityItem(label = "威海经济技术开发区", value = "371072"),
        cityItem(label = "威海临港经济技术开发区", value = "371073"),
        cityItem(label = "荣成市", value = "371082"),
        cityItem(label = "乳山市", value = "371083")
    ),
    utsArrayOf(
        cityItem(label = "东港区", value = "371102"),
        cityItem(label = "岚山区", value = "371103"),
        cityItem(label = "五莲县", value = "371121"),
        cityItem(label = "莒县", value = "371122"),
        cityItem(label = "日照经济技术开发区", value = "371171"),
        cityItem(label = "日照国际海洋城", value = "371172")
    ),
    utsArrayOf(
        cityItem(label = "莱城区", value = "371202"),
        cityItem(label = "钢城区", value = "371203")
    ),
    utsArrayOf(
        cityItem(label = "兰山区", value = "371302"),
        cityItem(label = "罗庄区", value = "371311"),
        cityItem(label = "河东区", value = "371312"),
        cityItem(label = "沂南县", value = "371321"),
        cityItem(label = "郯城县", value = "371322"),
        cityItem(label = "沂水县", value = "371323"),
        cityItem(label = "兰陵县", value = "371324"),
        cityItem(label = "费县", value = "371325"),
        cityItem(label = "平邑县", value = "371326"),
        cityItem(label = "莒南县", value = "371327"),
        cityItem(label = "蒙阴县", value = "371328"),
        cityItem(label = "临沭县", value = "371329"),
        cityItem(label = "临沂高新技术产业开发区", value = "371371"),
        cityItem(label = "临沂经济技术开发区", value = "371372"),
        cityItem(label = "临沂临港经济开发区", value = "371373")
    ),
    utsArrayOf(
        cityItem(label = "德城区", value = "371402"),
        cityItem(label = "陵城区", value = "371403"),
        cityItem(label = "宁津县", value = "371422"),
        cityItem(label = "庆云县", value = "371423"),
        cityItem(label = "临邑县", value = "371424"),
        cityItem(label = "齐河县", value = "371425"),
        cityItem(label = "平原县", value = "371426"),
        cityItem(label = "夏津县", value = "371427"),
        cityItem(label = "武城县", value = "371428"),
        cityItem(label = "德州经济技术开发区", value = "371471"),
        cityItem(label = "德州运河经济开发区", value = "371472"),
        cityItem(label = "乐陵市", value = "371481"),
        cityItem(label = "禹城市", value = "371482")
    ),
    utsArrayOf(
        cityItem(label = "东昌府区", value = "371502"),
        cityItem(label = "阳谷县", value = "371521"),
        cityItem(label = "莘县", value = "371522"),
        cityItem(label = "茌平县", value = "371523"),
        cityItem(label = "东阿县", value = "371524"),
        cityItem(label = "冠县", value = "371525"),
        cityItem(label = "高唐县", value = "371526"),
        cityItem(label = "临清市", value = "371581")
    ),
    utsArrayOf(
        cityItem(label = "滨城区", value = "371602"),
        cityItem(label = "沾化区", value = "371603"),
        cityItem(label = "惠民县", value = "371621"),
        cityItem(label = "阳信县", value = "371622"),
        cityItem(label = "无棣县", value = "371623"),
        cityItem(label = "博兴县", value = "371625"),
        cityItem(label = "邹平县", value = "371626")
    ),
    utsArrayOf(
        cityItem(label = "牡丹区", value = "371702"),
        cityItem(label = "定陶区", value = "371703"),
        cityItem(label = "曹县", value = "371721"),
        cityItem(label = "单县", value = "371722"),
        cityItem(label = "成武县", value = "371723"),
        cityItem(label = "巨野县", value = "371724"),
        cityItem(label = "郓城县", value = "371725"),
        cityItem(label = "鄄城县", value = "371726"),
        cityItem(label = "东明县", value = "371728"),
        cityItem(label = "菏泽经济技术开发区", value = "371771"),
        cityItem(label = "菏泽高新技术开发区", value = "371772")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "中原区", value = "410102"),
        cityItem(label = "二七区", value = "410103"),
        cityItem(label = "管城回族区", value = "410104"),
        cityItem(label = "金水区", value = "410105"),
        cityItem(label = "上街区", value = "410106"),
        cityItem(label = "惠济区", value = "410108"),
        cityItem(label = "中牟县", value = "410122"),
        cityItem(label = "郑州经济技术开发区", value = "410171"),
        cityItem(label = "郑州高新技术产业开发区", value = "410172"),
        cityItem(label = "郑州航空港经济综合实验区", value = "410173"),
        cityItem(label = "巩义市", value = "410181"),
        cityItem(label = "荥阳市", value = "410182"),
        cityItem(label = "新密市", value = "410183"),
        cityItem(label = "新郑市", value = "410184"),
        cityItem(label = "登封市", value = "410185")
    ),
    utsArrayOf(
        cityItem(label = "龙亭区", value = "410202"),
        cityItem(label = "顺河回族区", value = "410203"),
        cityItem(label = "鼓楼区", value = "410204"),
        cityItem(label = "禹王台区", value = "410205"),
        cityItem(label = "祥符区", value = "410212"),
        cityItem(label = "杞县", value = "410221"),
        cityItem(label = "通许县", value = "410222"),
        cityItem(label = "尉氏县", value = "410223"),
        cityItem(label = "兰考县", value = "410225")
    ),
    utsArrayOf(
        cityItem(label = "老城区", value = "410302"),
        cityItem(label = "西工区", value = "410303"),
        cityItem(label = "瀍河回族区", value = "410304"),
        cityItem(label = "涧西区", value = "410305"),
        cityItem(label = "吉利区", value = "410306"),
        cityItem(label = "洛龙区", value = "410311"),
        cityItem(label = "孟津县", value = "410322"),
        cityItem(label = "新安县", value = "410323"),
        cityItem(label = "栾川县", value = "410324"),
        cityItem(label = "嵩县", value = "410325"),
        cityItem(label = "汝阳县", value = "410326"),
        cityItem(label = "宜阳县", value = "410327"),
        cityItem(label = "洛宁县", value = "410328"),
        cityItem(label = "伊川县", value = "410329"),
        cityItem(label = "洛阳高新技术产业开发区", value = "410371"),
        cityItem(label = "偃师市", value = "410381")
    ),
    utsArrayOf(
        cityItem(label = "新华区", value = "410402"),
        cityItem(label = "卫东区", value = "410403"),
        cityItem(label = "石龙区", value = "410404"),
        cityItem(label = "湛河区", value = "410411"),
        cityItem(label = "宝丰县", value = "410421"),
        cityItem(label = "叶县", value = "410422"),
        cityItem(label = "鲁山县", value = "410423"),
        cityItem(label = "郏县", value = "410425"),
        cityItem(label = "平顶山高新技术产业开发区", value = "410471"),
        cityItem(label = "平顶山市新城区", value = "410472"),
        cityItem(label = "舞钢市", value = "410481"),
        cityItem(label = "汝州市", value = "410482")
    ),
    utsArrayOf(
        cityItem(label = "文峰区", value = "410502"),
        cityItem(label = "北关区", value = "410503"),
        cityItem(label = "殷都区", value = "410505"),
        cityItem(label = "龙安区", value = "410506"),
        cityItem(label = "安阳县", value = "410522"),
        cityItem(label = "汤阴县", value = "410523"),
        cityItem(label = "滑县", value = "410526"),
        cityItem(label = "内黄县", value = "410527"),
        cityItem(label = "安阳高新技术产业开发区", value = "410571"),
        cityItem(label = "林州市", value = "410581")
    ),
    utsArrayOf(
        cityItem(label = "鹤山区", value = "410602"),
        cityItem(label = "山城区", value = "410603"),
        cityItem(label = "淇滨区", value = "410611"),
        cityItem(label = "浚县", value = "410621"),
        cityItem(label = "淇县", value = "410622"),
        cityItem(label = "鹤壁经济技术开发区", value = "410671")
    ),
    utsArrayOf(
        cityItem(label = "红旗区", value = "410702"),
        cityItem(label = "卫滨区", value = "410703"),
        cityItem(label = "凤泉区", value = "410704"),
        cityItem(label = "牧野区", value = "410711"),
        cityItem(label = "新乡县", value = "410721"),
        cityItem(label = "获嘉县", value = "410724"),
        cityItem(label = "原阳县", value = "410725"),
        cityItem(label = "延津县", value = "410726"),
        cityItem(label = "封丘县", value = "410727"),
        cityItem(label = "长垣县", value = "410728"),
        cityItem(label = "新乡高新技术产业开发区", value = "410771"),
        cityItem(label = "新乡经济技术开发区", value = "410772"),
        cityItem(label = "新乡市平原城乡一体化示范区", value = "410773"),
        cityItem(label = "卫辉市", value = "410781"),
        cityItem(label = "辉县市", value = "410782")
    ),
    utsArrayOf(
        cityItem(label = "解放区", value = "410802"),
        cityItem(label = "中站区", value = "410803"),
        cityItem(label = "马村区", value = "410804"),
        cityItem(label = "山阳区", value = "410811"),
        cityItem(label = "修武县", value = "410821"),
        cityItem(label = "博爱县", value = "410822"),
        cityItem(label = "武陟县", value = "410823"),
        cityItem(label = "温县", value = "410825"),
        cityItem(label = "焦作城乡一体化示范区", value = "410871"),
        cityItem(label = "沁阳市", value = "410882"),
        cityItem(label = "孟州市", value = "410883")
    ),
    utsArrayOf(
        cityItem(label = "华龙区", value = "410902"),
        cityItem(label = "清丰县", value = "410922"),
        cityItem(label = "南乐县", value = "410923"),
        cityItem(label = "范县", value = "410926"),
        cityItem(label = "台前县", value = "410927"),
        cityItem(label = "濮阳县", value = "410928"),
        cityItem(label = "河南濮阳工业园区", value = "410971"),
        cityItem(label = "濮阳经济技术开发区", value = "410972")
    ),
    utsArrayOf(
        cityItem(label = "魏都区", value = "411002"),
        cityItem(label = "建安区", value = "411003"),
        cityItem(label = "鄢陵县", value = "411024"),
        cityItem(label = "襄城县", value = "411025"),
        cityItem(label = "许昌经济技术开发区", value = "411071"),
        cityItem(label = "禹州市", value = "411081"),
        cityItem(label = "长葛市", value = "411082")
    ),
    utsArrayOf(
        cityItem(label = "源汇区", value = "411102"),
        cityItem(label = "郾城区", value = "411103"),
        cityItem(label = "召陵区", value = "411104"),
        cityItem(label = "舞阳县", value = "411121"),
        cityItem(label = "临颍县", value = "411122"),
        cityItem(label = "漯河经济技术开发区", value = "411171")
    ),
    utsArrayOf(
        cityItem(label = "湖滨区", value = "411202"),
        cityItem(label = "陕州区", value = "411203"),
        cityItem(label = "渑池县", value = "411221"),
        cityItem(label = "卢氏县", value = "411224"),
        cityItem(label = "河南三门峡经济开发区", value = "411271"),
        cityItem(label = "义马市", value = "411281"),
        cityItem(label = "灵宝市", value = "411282")
    ),
    utsArrayOf(
        cityItem(label = "宛城区", value = "411302"),
        cityItem(label = "卧龙区", value = "411303"),
        cityItem(label = "南召县", value = "411321"),
        cityItem(label = "方城县", value = "411322"),
        cityItem(label = "西峡县", value = "411323"),
        cityItem(label = "镇平县", value = "411324"),
        cityItem(label = "内乡县", value = "411325"),
        cityItem(label = "淅川县", value = "411326"),
        cityItem(label = "社旗县", value = "411327"),
        cityItem(label = "唐河县", value = "411328"),
        cityItem(label = "新野县", value = "411329"),
        cityItem(label = "桐柏县", value = "411330"),
        cityItem(label = "南阳高新技术产业开发区", value = "411371"),
        cityItem(label = "南阳市城乡一体化示范区", value = "411372"),
        cityItem(label = "邓州市", value = "411381")
    ),
    utsArrayOf(
        cityItem(label = "梁园区", value = "411402"),
        cityItem(label = "睢阳区", value = "411403"),
        cityItem(label = "民权县", value = "411421"),
        cityItem(label = "睢县", value = "411422"),
        cityItem(label = "宁陵县", value = "411423"),
        cityItem(label = "柘城县", value = "411424"),
        cityItem(label = "虞城县", value = "411425"),
        cityItem(label = "夏邑县", value = "411426"),
        cityItem(label = "豫东综合物流产业聚集区", value = "411471"),
        cityItem(label = "河南商丘经济开发区", value = "411472"),
        cityItem(label = "永城市", value = "411481")
    ),
    utsArrayOf(
        cityItem(label = "浉河区", value = "411502"),
        cityItem(label = "平桥区", value = "411503"),
        cityItem(label = "罗山县", value = "411521"),
        cityItem(label = "光山县", value = "411522"),
        cityItem(label = "新县", value = "411523"),
        cityItem(label = "商城县", value = "411524"),
        cityItem(label = "固始县", value = "411525"),
        cityItem(label = "潢川县", value = "411526"),
        cityItem(label = "淮滨县", value = "411527"),
        cityItem(label = "息县", value = "411528"),
        cityItem(label = "信阳高新技术产业开发区", value = "411571")
    ),
    utsArrayOf(
        cityItem(label = "川汇区", value = "411602"),
        cityItem(label = "扶沟县", value = "411621"),
        cityItem(label = "西华县", value = "411622"),
        cityItem(label = "商水县", value = "411623"),
        cityItem(label = "沈丘县", value = "411624"),
        cityItem(label = "郸城县", value = "411625"),
        cityItem(label = "淮阳县", value = "411626"),
        cityItem(label = "太康县", value = "411627"),
        cityItem(label = "鹿邑县", value = "411628"),
        cityItem(label = "河南周口经济开发区", value = "411671"),
        cityItem(label = "项城市", value = "411681")
    ),
    utsArrayOf(
        cityItem(label = "驿城区", value = "411702"),
        cityItem(label = "西平县", value = "411721"),
        cityItem(label = "上蔡县", value = "411722"),
        cityItem(label = "平舆县", value = "411723"),
        cityItem(label = "正阳县", value = "411724"),
        cityItem(label = "确山县", value = "411725"),
        cityItem(label = "泌阳县", value = "411726"),
        cityItem(label = "汝南县", value = "411727"),
        cityItem(label = "遂平县", value = "411728"),
        cityItem(label = "新蔡县", value = "411729"),
        cityItem(label = "河南驻马店经济开发区", value = "411771")
    ),
    utsArrayOf(
        cityItem(label = "济源市", value = "419001")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "江岸区", value = "420102"),
        cityItem(label = "江汉区", value = "420103"),
        cityItem(label = "硚口区", value = "420104"),
        cityItem(label = "汉阳区", value = "420105"),
        cityItem(label = "武昌区", value = "420106"),
        cityItem(label = "青山区", value = "420107"),
        cityItem(label = "洪山区", value = "420111"),
        cityItem(label = "东西湖区", value = "420112"),
        cityItem(label = "汉南区", value = "420113"),
        cityItem(label = "蔡甸区", value = "420114"),
        cityItem(label = "江夏区", value = "420115"),
        cityItem(label = "黄陂区", value = "420116"),
        cityItem(label = "新洲区", value = "420117")
    ),
    utsArrayOf(
        cityItem(label = "黄石港区", value = "420202"),
        cityItem(label = "西塞山区", value = "420203"),
        cityItem(label = "下陆区", value = "420204"),
        cityItem(label = "铁山区", value = "420205"),
        cityItem(label = "阳新县", value = "420222"),
        cityItem(label = "大冶市", value = "420281")
    ),
    utsArrayOf(
        cityItem(label = "茅箭区", value = "420302"),
        cityItem(label = "张湾区", value = "420303"),
        cityItem(label = "郧阳区", value = "420304"),
        cityItem(label = "郧西县", value = "420322"),
        cityItem(label = "竹山县", value = "420323"),
        cityItem(label = "竹溪县", value = "420324"),
        cityItem(label = "房县", value = "420325"),
        cityItem(label = "丹江口市", value = "420381")
    ),
    utsArrayOf(
        cityItem(label = "西陵区", value = "420502"),
        cityItem(label = "伍家岗区", value = "420503"),
        cityItem(label = "点军区", value = "420504"),
        cityItem(label = "猇亭区", value = "420505"),
        cityItem(label = "夷陵区", value = "420506"),
        cityItem(label = "远安县", value = "420525"),
        cityItem(label = "兴山县", value = "420526"),
        cityItem(label = "秭归县", value = "420527"),
        cityItem(label = "长阳土家族自治县", value = "420528"),
        cityItem(label = "五峰土家族自治县", value = "420529"),
        cityItem(label = "宜都市", value = "420581"),
        cityItem(label = "当阳市", value = "420582"),
        cityItem(label = "枝江市", value = "420583")
    ),
    utsArrayOf(
        cityItem(label = "襄城区", value = "420602"),
        cityItem(label = "樊城区", value = "420606"),
        cityItem(label = "襄州区", value = "420607"),
        cityItem(label = "南漳县", value = "420624"),
        cityItem(label = "谷城县", value = "420625"),
        cityItem(label = "保康县", value = "420626"),
        cityItem(label = "老河口市", value = "420682"),
        cityItem(label = "枣阳市", value = "420683"),
        cityItem(label = "宜城市", value = "420684")
    ),
    utsArrayOf(
        cityItem(label = "梁子湖区", value = "420702"),
        cityItem(label = "华容区", value = "420703"),
        cityItem(label = "鄂城区", value = "420704")
    ),
    utsArrayOf(
        cityItem(label = "东宝区", value = "420802"),
        cityItem(label = "掇刀区", value = "420804"),
        cityItem(label = "京山县", value = "420821"),
        cityItem(label = "沙洋县", value = "420822"),
        cityItem(label = "钟祥市", value = "420881")
    ),
    utsArrayOf(
        cityItem(label = "孝南区", value = "420902"),
        cityItem(label = "孝昌县", value = "420921"),
        cityItem(label = "大悟县", value = "420922"),
        cityItem(label = "云梦县", value = "420923"),
        cityItem(label = "应城市", value = "420981"),
        cityItem(label = "安陆市", value = "420982"),
        cityItem(label = "汉川市", value = "420984")
    ),
    utsArrayOf(
        cityItem(label = "沙市区", value = "421002"),
        cityItem(label = "荆州区", value = "421003"),
        cityItem(label = "公安县", value = "421022"),
        cityItem(label = "监利县", value = "421023"),
        cityItem(label = "江陵县", value = "421024"),
        cityItem(label = "荆州经济技术开发区", value = "421071"),
        cityItem(label = "石首市", value = "421081"),
        cityItem(label = "洪湖市", value = "421083"),
        cityItem(label = "松滋市", value = "421087")
    ),
    utsArrayOf(
        cityItem(label = "黄州区", value = "421102"),
        cityItem(label = "团风县", value = "421121"),
        cityItem(label = "红安县", value = "421122"),
        cityItem(label = "罗田县", value = "421123"),
        cityItem(label = "英山县", value = "421124"),
        cityItem(label = "浠水县", value = "421125"),
        cityItem(label = "蕲春县", value = "421126"),
        cityItem(label = "黄梅县", value = "421127"),
        cityItem(label = "龙感湖管理区", value = "421171"),
        cityItem(label = "麻城市", value = "421181"),
        cityItem(label = "武穴市", value = "421182")
    ),
    utsArrayOf(
        cityItem(label = "咸安区", value = "421202"),
        cityItem(label = "嘉鱼县", value = "421221"),
        cityItem(label = "通城县", value = "421222"),
        cityItem(label = "崇阳县", value = "421223"),
        cityItem(label = "通山县", value = "421224"),
        cityItem(label = "赤壁市", value = "421281")
    ),
    utsArrayOf(
        cityItem(label = "曾都区", value = "421303"),
        cityItem(label = "随县", value = "421321"),
        cityItem(label = "广水市", value = "421381")
    ),
    utsArrayOf(
        cityItem(label = "恩施市", value = "422801"),
        cityItem(label = "利川市", value = "422802"),
        cityItem(label = "建始县", value = "422822"),
        cityItem(label = "巴东县", value = "422823"),
        cityItem(label = "宣恩县", value = "422825"),
        cityItem(label = "咸丰县", value = "422826"),
        cityItem(label = "来凤县", value = "422827"),
        cityItem(label = "鹤峰县", value = "422828")
    ),
    utsArrayOf(
        cityItem(label = "仙桃市", value = "429004"),
        cityItem(label = "潜江市", value = "429005"),
        cityItem(label = "天门市", value = "429006"),
        cityItem(label = "神农架林区", value = "429021")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "芙蓉区", value = "430102"),
        cityItem(label = "天心区", value = "430103"),
        cityItem(label = "岳麓区", value = "430104"),
        cityItem(label = "开福区", value = "430105"),
        cityItem(label = "雨花区", value = "430111"),
        cityItem(label = "望城区", value = "430112"),
        cityItem(label = "长沙县", value = "430121"),
        cityItem(label = "浏阳市", value = "430181"),
        cityItem(label = "宁乡市", value = "430182")
    ),
    utsArrayOf(
        cityItem(label = "荷塘区", value = "430202"),
        cityItem(label = "芦淞区", value = "430203"),
        cityItem(label = "石峰区", value = "430204"),
        cityItem(label = "天元区", value = "430211"),
        cityItem(label = "株洲县", value = "430221"),
        cityItem(label = "攸县", value = "430223"),
        cityItem(label = "茶陵县", value = "430224"),
        cityItem(label = "炎陵县", value = "430225"),
        cityItem(label = "云龙示范区", value = "430271"),
        cityItem(label = "醴陵市", value = "430281")
    ),
    utsArrayOf(
        cityItem(label = "雨湖区", value = "430302"),
        cityItem(label = "岳塘区", value = "430304"),
        cityItem(label = "湘潭县", value = "430321"),
        cityItem(label = "湖南湘潭高新技术产业园区", value = "430371"),
        cityItem(label = "湘潭昭山示范区", value = "430372"),
        cityItem(label = "湘潭九华示范区", value = "430373"),
        cityItem(label = "湘乡市", value = "430381"),
        cityItem(label = "韶山市", value = "430382")
    ),
    utsArrayOf(
        cityItem(label = "珠晖区", value = "430405"),
        cityItem(label = "雁峰区", value = "430406"),
        cityItem(label = "石鼓区", value = "430407"),
        cityItem(label = "蒸湘区", value = "430408"),
        cityItem(label = "南岳区", value = "430412"),
        cityItem(label = "衡阳县", value = "430421"),
        cityItem(label = "衡南县", value = "430422"),
        cityItem(label = "衡山县", value = "430423"),
        cityItem(label = "衡东县", value = "430424"),
        cityItem(label = "祁东县", value = "430426"),
        cityItem(label = "衡阳综合保税区", value = "430471"),
        cityItem(label = "湖南衡阳高新技术产业园区", value = "430472"),
        cityItem(label = "湖南衡阳松木经济开发区", value = "430473"),
        cityItem(label = "耒阳市", value = "430481"),
        cityItem(label = "常宁市", value = "430482")
    ),
    utsArrayOf(
        cityItem(label = "双清区", value = "430502"),
        cityItem(label = "大祥区", value = "430503"),
        cityItem(label = "北塔区", value = "430511"),
        cityItem(label = "邵东县", value = "430521"),
        cityItem(label = "新邵县", value = "430522"),
        cityItem(label = "邵阳县", value = "430523"),
        cityItem(label = "隆回县", value = "430524"),
        cityItem(label = "洞口县", value = "430525"),
        cityItem(label = "绥宁县", value = "430527"),
        cityItem(label = "新宁县", value = "430528"),
        cityItem(label = "城步苗族自治县", value = "430529"),
        cityItem(label = "武冈市", value = "430581")
    ),
    utsArrayOf(
        cityItem(label = "岳阳楼区", value = "430602"),
        cityItem(label = "云溪区", value = "430603"),
        cityItem(label = "君山区", value = "430611"),
        cityItem(label = "岳阳县", value = "430621"),
        cityItem(label = "华容县", value = "430623"),
        cityItem(label = "湘阴县", value = "430624"),
        cityItem(label = "平江县", value = "430626"),
        cityItem(label = "岳阳市屈原管理区", value = "430671"),
        cityItem(label = "汨罗市", value = "430681"),
        cityItem(label = "临湘市", value = "430682")
    ),
    utsArrayOf(
        cityItem(label = "武陵区", value = "430702"),
        cityItem(label = "鼎城区", value = "430703"),
        cityItem(label = "安乡县", value = "430721"),
        cityItem(label = "汉寿县", value = "430722"),
        cityItem(label = "澧县", value = "430723"),
        cityItem(label = "临澧县", value = "430724"),
        cityItem(label = "桃源县", value = "430725"),
        cityItem(label = "石门县", value = "430726"),
        cityItem(label = "常德市西洞庭管理区", value = "430771"),
        cityItem(label = "津市市", value = "430781")
    ),
    utsArrayOf(
        cityItem(label = "永定区", value = "430802"),
        cityItem(label = "武陵源区", value = "430811"),
        cityItem(label = "慈利县", value = "430821"),
        cityItem(label = "桑植县", value = "430822")
    ),
    utsArrayOf(
        cityItem(label = "资阳区", value = "430902"),
        cityItem(label = "赫山区", value = "430903"),
        cityItem(label = "南县", value = "430921"),
        cityItem(label = "桃江县", value = "430922"),
        cityItem(label = "安化县", value = "430923"),
        cityItem(label = "益阳市大通湖管理区", value = "430971"),
        cityItem(label = "湖南益阳高新技术产业园区", value = "430972"),
        cityItem(label = "沅江市", value = "430981")
    ),
    utsArrayOf(
        cityItem(label = "北湖区", value = "431002"),
        cityItem(label = "苏仙区", value = "431003"),
        cityItem(label = "桂阳县", value = "431021"),
        cityItem(label = "宜章县", value = "431022"),
        cityItem(label = "永兴县", value = "431023"),
        cityItem(label = "嘉禾县", value = "431024"),
        cityItem(label = "临武县", value = "431025"),
        cityItem(label = "汝城县", value = "431026"),
        cityItem(label = "桂东县", value = "431027"),
        cityItem(label = "安仁县", value = "431028"),
        cityItem(label = "资兴市", value = "431081")
    ),
    utsArrayOf(
        cityItem(label = "零陵区", value = "431102"),
        cityItem(label = "冷水滩区", value = "431103"),
        cityItem(label = "祁阳县", value = "431121"),
        cityItem(label = "东安县", value = "431122"),
        cityItem(label = "双牌县", value = "431123"),
        cityItem(label = "道县", value = "431124"),
        cityItem(label = "江永县", value = "431125"),
        cityItem(label = "宁远县", value = "431126"),
        cityItem(label = "蓝山县", value = "431127"),
        cityItem(label = "新田县", value = "431128"),
        cityItem(label = "江华瑶族自治县", value = "431129"),
        cityItem(label = "永州经济技术开发区", value = "431171"),
        cityItem(label = "永州市金洞管理区", value = "431172"),
        cityItem(label = "永州市回龙圩管理区", value = "431173")
    ),
    utsArrayOf(
        cityItem(label = "鹤城区", value = "431202"),
        cityItem(label = "中方县", value = "431221"),
        cityItem(label = "沅陵县", value = "431222"),
        cityItem(label = "辰溪县", value = "431223"),
        cityItem(label = "溆浦县", value = "431224"),
        cityItem(label = "会同县", value = "431225"),
        cityItem(label = "麻阳苗族自治县", value = "431226"),
        cityItem(label = "新晃侗族自治县", value = "431227"),
        cityItem(label = "芷江侗族自治县", value = "431228"),
        cityItem(label = "靖州苗族侗族自治县", value = "431229"),
        cityItem(label = "通道侗族自治县", value = "431230"),
        cityItem(label = "怀化市洪江管理区", value = "431271"),
        cityItem(label = "洪江市", value = "431281")
    ),
    utsArrayOf(
        cityItem(label = "娄星区", value = "431302"),
        cityItem(label = "双峰县", value = "431321"),
        cityItem(label = "新化县", value = "431322"),
        cityItem(label = "冷水江市", value = "431381"),
        cityItem(label = "涟源市", value = "431382")
    ),
    utsArrayOf(
        cityItem(label = "吉首市", value = "433101"),
        cityItem(label = "泸溪县", value = "433122"),
        cityItem(label = "凤凰县", value = "433123"),
        cityItem(label = "花垣县", value = "433124"),
        cityItem(label = "保靖县", value = "433125"),
        cityItem(label = "古丈县", value = "433126"),
        cityItem(label = "永顺县", value = "433127"),
        cityItem(label = "龙山县", value = "433130"),
        cityItem(label = "湖南吉首经济开发区", value = "433172"),
        cityItem(label = "湖南永顺经济开发区", value = "433173")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "荔湾区", value = "440103"),
        cityItem(label = "越秀区", value = "440104"),
        cityItem(label = "海珠区", value = "440105"),
        cityItem(label = "天河区", value = "440106"),
        cityItem(label = "白云区", value = "440111"),
        cityItem(label = "黄埔区", value = "440112"),
        cityItem(label = "番禺区", value = "440113"),
        cityItem(label = "花都区", value = "440114"),
        cityItem(label = "南沙区", value = "440115"),
        cityItem(label = "从化区", value = "440117"),
        cityItem(label = "增城区", value = "440118")
    ),
    utsArrayOf(
        cityItem(label = "武江区", value = "440203"),
        cityItem(label = "浈江区", value = "440204"),
        cityItem(label = "曲江区", value = "440205"),
        cityItem(label = "始兴县", value = "440222"),
        cityItem(label = "仁化县", value = "440224"),
        cityItem(label = "翁源县", value = "440229"),
        cityItem(label = "乳源瑶族自治县", value = "440232"),
        cityItem(label = "新丰县", value = "440233"),
        cityItem(label = "乐昌市", value = "440281"),
        cityItem(label = "南雄市", value = "440282")
    ),
    utsArrayOf(
        cityItem(label = "罗湖区", value = "440303"),
        cityItem(label = "福田区", value = "440304"),
        cityItem(label = "南山区", value = "440305"),
        cityItem(label = "宝安区", value = "440306"),
        cityItem(label = "龙岗区", value = "440307"),
        cityItem(label = "盐田区", value = "440308"),
        cityItem(label = "龙华区", value = "440309"),
        cityItem(label = "坪山区", value = "440310")
    ),
    utsArrayOf(
        cityItem(label = "香洲区", value = "440402"),
        cityItem(label = "斗门区", value = "440403"),
        cityItem(label = "金湾区", value = "440404")
    ),
    utsArrayOf(
        cityItem(label = "龙湖区", value = "440507"),
        cityItem(label = "金平区", value = "440511"),
        cityItem(label = "濠江区", value = "440512"),
        cityItem(label = "潮阳区", value = "440513"),
        cityItem(label = "潮南区", value = "440514"),
        cityItem(label = "澄海区", value = "440515"),
        cityItem(label = "南澳县", value = "440523")
    ),
    utsArrayOf(
        cityItem(label = "禅城区", value = "440604"),
        cityItem(label = "南海区", value = "440605"),
        cityItem(label = "顺德区", value = "440606"),
        cityItem(label = "三水区", value = "440607"),
        cityItem(label = "高明区", value = "440608")
    ),
    utsArrayOf(
        cityItem(label = "蓬江区", value = "440703"),
        cityItem(label = "江海区", value = "440704"),
        cityItem(label = "新会区", value = "440705"),
        cityItem(label = "台山市", value = "440781"),
        cityItem(label = "开平市", value = "440783"),
        cityItem(label = "鹤山市", value = "440784"),
        cityItem(label = "恩平市", value = "440785")
    ),
    utsArrayOf(
        cityItem(label = "赤坎区", value = "440802"),
        cityItem(label = "霞山区", value = "440803"),
        cityItem(label = "坡头区", value = "440804"),
        cityItem(label = "麻章区", value = "440811"),
        cityItem(label = "遂溪县", value = "440823"),
        cityItem(label = "徐闻县", value = "440825"),
        cityItem(label = "廉江市", value = "440881"),
        cityItem(label = "雷州市", value = "440882"),
        cityItem(label = "吴川市", value = "440883")
    ),
    utsArrayOf(
        cityItem(label = "茂南区", value = "440902"),
        cityItem(label = "电白区", value = "440904"),
        cityItem(label = "高州市", value = "440981"),
        cityItem(label = "化州市", value = "440982"),
        cityItem(label = "信宜市", value = "440983")
    ),
    utsArrayOf(
        cityItem(label = "端州区", value = "441202"),
        cityItem(label = "鼎湖区", value = "441203"),
        cityItem(label = "高要区", value = "441204"),
        cityItem(label = "广宁县", value = "441223"),
        cityItem(label = "怀集县", value = "441224"),
        cityItem(label = "封开县", value = "441225"),
        cityItem(label = "德庆县", value = "441226"),
        cityItem(label = "四会市", value = "441284")
    ),
    utsArrayOf(
        cityItem(label = "惠城区", value = "441302"),
        cityItem(label = "惠阳区", value = "441303"),
        cityItem(label = "博罗县", value = "441322"),
        cityItem(label = "惠东县", value = "441323"),
        cityItem(label = "龙门县", value = "441324")
    ),
    utsArrayOf(
        cityItem(label = "梅江区", value = "441402"),
        cityItem(label = "梅县区", value = "441403"),
        cityItem(label = "大埔县", value = "441422"),
        cityItem(label = "丰顺县", value = "441423"),
        cityItem(label = "五华县", value = "441424"),
        cityItem(label = "平远县", value = "441426"),
        cityItem(label = "蕉岭县", value = "441427"),
        cityItem(label = "兴宁市", value = "441481")
    ),
    utsArrayOf(
        cityItem(label = "城区", value = "441502"),
        cityItem(label = "海丰县", value = "441521"),
        cityItem(label = "陆河县", value = "441523"),
        cityItem(label = "陆丰市", value = "441581")
    ),
    utsArrayOf(
        cityItem(label = "源城区", value = "441602"),
        cityItem(label = "紫金县", value = "441621"),
        cityItem(label = "龙川县", value = "441622"),
        cityItem(label = "连平县", value = "441623"),
        cityItem(label = "和平县", value = "441624"),
        cityItem(label = "东源县", value = "441625")
    ),
    utsArrayOf(
        cityItem(label = "江城区", value = "441702"),
        cityItem(label = "阳东区", value = "441704"),
        cityItem(label = "阳西县", value = "441721"),
        cityItem(label = "阳春市", value = "441781")
    ),
    utsArrayOf(
        cityItem(label = "清城区", value = "441802"),
        cityItem(label = "清新区", value = "441803"),
        cityItem(label = "佛冈县", value = "441821"),
        cityItem(label = "阳山县", value = "441823"),
        cityItem(label = "连山壮族瑶族自治县", value = "441825"),
        cityItem(label = "连南瑶族自治县", value = "441826"),
        cityItem(label = "英德市", value = "441881"),
        cityItem(label = "连州市", value = "441882")
    ),
    utsArrayOf(
        cityItem(label = "东莞市", value = "441900")
    ),
    utsArrayOf(
        cityItem(label = "中山市", value = "442000")
    ),
    utsArrayOf(
        cityItem(label = "湘桥区", value = "445102"),
        cityItem(label = "潮安区", value = "445103"),
        cityItem(label = "饶平县", value = "445122")
    ),
    utsArrayOf(
        cityItem(label = "榕城区", value = "445202"),
        cityItem(label = "揭东区", value = "445203"),
        cityItem(label = "揭西县", value = "445222"),
        cityItem(label = "惠来县", value = "445224"),
        cityItem(label = "普宁市", value = "445281")
    ),
    utsArrayOf(
        cityItem(label = "云城区", value = "445302"),
        cityItem(label = "云安区", value = "445303"),
        cityItem(label = "新兴县", value = "445321"),
        cityItem(label = "郁南县", value = "445322"),
        cityItem(label = "罗定市", value = "445381")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "兴宁区", value = "450102"),
        cityItem(label = "青秀区", value = "450103"),
        cityItem(label = "江南区", value = "450105"),
        cityItem(label = "西乡塘区", value = "450107"),
        cityItem(label = "良庆区", value = "450108"),
        cityItem(label = "邕宁区", value = "450109"),
        cityItem(label = "武鸣区", value = "450110"),
        cityItem(label = "隆安县", value = "450123"),
        cityItem(label = "马山县", value = "450124"),
        cityItem(label = "上林县", value = "450125"),
        cityItem(label = "宾阳县", value = "450126"),
        cityItem(label = "横县", value = "450127")
    ),
    utsArrayOf(
        cityItem(label = "城中区", value = "450202"),
        cityItem(label = "鱼峰区", value = "450203"),
        cityItem(label = "柳南区", value = "450204"),
        cityItem(label = "柳北区", value = "450205"),
        cityItem(label = "柳江区", value = "450206"),
        cityItem(label = "柳城县", value = "450222"),
        cityItem(label = "鹿寨县", value = "450223"),
        cityItem(label = "融安县", value = "450224"),
        cityItem(label = "融水苗族自治县", value = "450225"),
        cityItem(label = "三江侗族自治县", value = "450226")
    ),
    utsArrayOf(
        cityItem(label = "秀峰区", value = "450302"),
        cityItem(label = "叠彩区", value = "450303"),
        cityItem(label = "象山区", value = "450304"),
        cityItem(label = "七星区", value = "450305"),
        cityItem(label = "雁山区", value = "450311"),
        cityItem(label = "临桂区", value = "450312"),
        cityItem(label = "阳朔县", value = "450321"),
        cityItem(label = "灵川县", value = "450323"),
        cityItem(label = "全州县", value = "450324"),
        cityItem(label = "兴安县", value = "450325"),
        cityItem(label = "永福县", value = "450326"),
        cityItem(label = "灌阳县", value = "450327"),
        cityItem(label = "龙胜各族自治县", value = "450328"),
        cityItem(label = "资源县", value = "450329"),
        cityItem(label = "平乐县", value = "450330"),
        cityItem(label = "荔浦县", value = "450331"),
        cityItem(label = "恭城瑶族自治县", value = "450332")
    ),
    utsArrayOf(
        cityItem(label = "万秀区", value = "450403"),
        cityItem(label = "长洲区", value = "450405"),
        cityItem(label = "龙圩区", value = "450406"),
        cityItem(label = "苍梧县", value = "450421"),
        cityItem(label = "藤县", value = "450422"),
        cityItem(label = "蒙山县", value = "450423"),
        cityItem(label = "岑溪市", value = "450481")
    ),
    utsArrayOf(
        cityItem(label = "海城区", value = "450502"),
        cityItem(label = "银海区", value = "450503"),
        cityItem(label = "铁山港区", value = "450512"),
        cityItem(label = "合浦县", value = "450521")
    ),
    utsArrayOf(
        cityItem(label = "港口区", value = "450602"),
        cityItem(label = "防城区", value = "450603"),
        cityItem(label = "上思县", value = "450621"),
        cityItem(label = "东兴市", value = "450681")
    ),
    utsArrayOf(
        cityItem(label = "钦南区", value = "450702"),
        cityItem(label = "钦北区", value = "450703"),
        cityItem(label = "灵山县", value = "450721"),
        cityItem(label = "浦北县", value = "450722")
    ),
    utsArrayOf(
        cityItem(label = "港北区", value = "450802"),
        cityItem(label = "港南区", value = "450803"),
        cityItem(label = "覃塘区", value = "450804"),
        cityItem(label = "平南县", value = "450821"),
        cityItem(label = "桂平市", value = "450881")
    ),
    utsArrayOf(
        cityItem(label = "玉州区", value = "450902"),
        cityItem(label = "福绵区", value = "450903"),
        cityItem(label = "容县", value = "450921"),
        cityItem(label = "陆川县", value = "450922"),
        cityItem(label = "博白县", value = "450923"),
        cityItem(label = "兴业县", value = "450924"),
        cityItem(label = "北流市", value = "450981")
    ),
    utsArrayOf(
        cityItem(label = "右江区", value = "451002"),
        cityItem(label = "田阳县", value = "451021"),
        cityItem(label = "田东县", value = "451022"),
        cityItem(label = "平果县", value = "451023"),
        cityItem(label = "德保县", value = "451024"),
        cityItem(label = "那坡县", value = "451026"),
        cityItem(label = "凌云县", value = "451027"),
        cityItem(label = "乐业县", value = "451028"),
        cityItem(label = "田林县", value = "451029"),
        cityItem(label = "西林县", value = "451030"),
        cityItem(label = "隆林各族自治县", value = "451031"),
        cityItem(label = "靖西市", value = "451081")
    ),
    utsArrayOf(
        cityItem(label = "八步区", value = "451102"),
        cityItem(label = "平桂区", value = "451103"),
        cityItem(label = "昭平县", value = "451121"),
        cityItem(label = "钟山县", value = "451122"),
        cityItem(label = "富川瑶族自治县", value = "451123")
    ),
    utsArrayOf(
        cityItem(label = "金城江区", value = "451202"),
        cityItem(label = "宜州区", value = "451203"),
        cityItem(label = "南丹县", value = "451221"),
        cityItem(label = "天峨县", value = "451222"),
        cityItem(label = "凤山县", value = "451223"),
        cityItem(label = "东兰县", value = "451224"),
        cityItem(label = "罗城仫佬族自治县", value = "451225"),
        cityItem(label = "环江毛南族自治县", value = "451226"),
        cityItem(label = "巴马瑶族自治县", value = "451227"),
        cityItem(label = "都安瑶族自治县", value = "451228"),
        cityItem(label = "大化瑶族自治县", value = "451229")
    ),
    utsArrayOf(
        cityItem(label = "兴宾区", value = "451302"),
        cityItem(label = "忻城县", value = "451321"),
        cityItem(label = "象州县", value = "451322"),
        cityItem(label = "武宣县", value = "451323"),
        cityItem(label = "金秀瑶族自治县", value = "451324"),
        cityItem(label = "合山市", value = "451381")
    ),
    utsArrayOf(
        cityItem(label = "江州区", value = "451402"),
        cityItem(label = "扶绥县", value = "451421"),
        cityItem(label = "宁明县", value = "451422"),
        cityItem(label = "龙州县", value = "451423"),
        cityItem(label = "大新县", value = "451424"),
        cityItem(label = "天等县", value = "451425"),
        cityItem(label = "凭祥市", value = "451481")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "秀英区", value = "460105"),
        cityItem(label = "龙华区", value = "460106"),
        cityItem(label = "琼山区", value = "460107"),
        cityItem(label = "美兰区", value = "460108")
    ),
    utsArrayOf(
        cityItem(label = "海棠区", value = "460202"),
        cityItem(label = "吉阳区", value = "460203"),
        cityItem(label = "天涯区", value = "460204"),
        cityItem(label = "崖州区", value = "460205")
    ),
    utsArrayOf(
        cityItem(label = "西沙群岛", value = "460321"),
        cityItem(label = "南沙群岛", value = "460322"),
        cityItem(label = "中沙群岛的岛礁及其海域", value = "460323")
    ),
    utsArrayOf(
        cityItem(label = "儋州市", value = "460400")
    ),
    utsArrayOf(
        cityItem(label = "五指山市", value = "469001"),
        cityItem(label = "琼海市", value = "469002"),
        cityItem(label = "文昌市", value = "469005"),
        cityItem(label = "万宁市", value = "469006"),
        cityItem(label = "东方市", value = "469007"),
        cityItem(label = "定安县", value = "469021"),
        cityItem(label = "屯昌县", value = "469022"),
        cityItem(label = "澄迈县", value = "469023"),
        cityItem(label = "临高县", value = "469024"),
        cityItem(label = "白沙黎族自治县", value = "469025"),
        cityItem(label = "昌江黎族自治县", value = "469026"),
        cityItem(label = "乐东黎族自治县", value = "469027"),
        cityItem(label = "陵水黎族自治县", value = "469028"),
        cityItem(label = "保亭黎族苗族自治县", value = "469029"),
        cityItem(label = "琼中黎族苗族自治县", value = "469030")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "万州区", value = "500101"),
        cityItem(label = "涪陵区", value = "500102"),
        cityItem(label = "渝中区", value = "500103"),
        cityItem(label = "大渡口区", value = "500104"),
        cityItem(label = "江北区", value = "500105"),
        cityItem(label = "沙坪坝区", value = "500106"),
        cityItem(label = "九龙坡区", value = "500107"),
        cityItem(label = "南岸区", value = "500108"),
        cityItem(label = "北碚区", value = "500109"),
        cityItem(label = "綦江区", value = "500110"),
        cityItem(label = "大足区", value = "500111"),
        cityItem(label = "渝北区", value = "500112"),
        cityItem(label = "巴南区", value = "500113"),
        cityItem(label = "黔江区", value = "500114"),
        cityItem(label = "长寿区", value = "500115"),
        cityItem(label = "江津区", value = "500116"),
        cityItem(label = "合川区", value = "500117"),
        cityItem(label = "永川区", value = "500118"),
        cityItem(label = "南川区", value = "500119"),
        cityItem(label = "璧山区", value = "500120"),
        cityItem(label = "铜梁区", value = "500151"),
        cityItem(label = "潼南区", value = "500152"),
        cityItem(label = "荣昌区", value = "500153"),
        cityItem(label = "开州区", value = "500154"),
        cityItem(label = "梁平区", value = "500155"),
        cityItem(label = "武隆区", value = "500156")
    ),
    utsArrayOf(
        cityItem(label = "城口县", value = "500229"),
        cityItem(label = "丰都县", value = "500230"),
        cityItem(label = "垫江县", value = "500231"),
        cityItem(label = "忠县", value = "500233"),
        cityItem(label = "云阳县", value = "500235"),
        cityItem(label = "奉节县", value = "500236"),
        cityItem(label = "巫山县", value = "500237"),
        cityItem(label = "巫溪县", value = "500238"),
        cityItem(label = "石柱土家族自治县", value = "500240"),
        cityItem(label = "秀山土家族苗族自治县", value = "500241"),
        cityItem(label = "酉阳土家族苗族自治县", value = "500242"),
        cityItem(label = "彭水苗族土家族自治县", value = "500243")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "锦江区", value = "510104"),
        cityItem(label = "青羊区", value = "510105"),
        cityItem(label = "金牛区", value = "510106"),
        cityItem(label = "武侯区", value = "510107"),
        cityItem(label = "成华区", value = "510108"),
        cityItem(label = "龙泉驿区", value = "510112"),
        cityItem(label = "青白江区", value = "510113"),
        cityItem(label = "新都区", value = "510114"),
        cityItem(label = "温江区", value = "510115"),
        cityItem(label = "双流区", value = "510116"),
        cityItem(label = "郫都区", value = "510117"),
        cityItem(label = "金堂县", value = "510121"),
        cityItem(label = "大邑县", value = "510129"),
        cityItem(label = "蒲江县", value = "510131"),
        cityItem(label = "新津县", value = "510132"),
        cityItem(label = "都江堰市", value = "510181"),
        cityItem(label = "彭州市", value = "510182"),
        cityItem(label = "邛崃市", value = "510183"),
        cityItem(label = "崇州市", value = "510184"),
        cityItem(label = "简阳市", value = "510185")
    ),
    utsArrayOf(
        cityItem(label = "自流井区", value = "510302"),
        cityItem(label = "贡井区", value = "510303"),
        cityItem(label = "大安区", value = "510304"),
        cityItem(label = "沿滩区", value = "510311"),
        cityItem(label = "荣县", value = "510321"),
        cityItem(label = "富顺县", value = "510322")
    ),
    utsArrayOf(
        cityItem(label = "东区", value = "510402"),
        cityItem(label = "西区", value = "510403"),
        cityItem(label = "仁和区", value = "510411"),
        cityItem(label = "米易县", value = "510421"),
        cityItem(label = "盐边县", value = "510422")
    ),
    utsArrayOf(
        cityItem(label = "江阳区", value = "510502"),
        cityItem(label = "纳溪区", value = "510503"),
        cityItem(label = "龙马潭区", value = "510504"),
        cityItem(label = "泸县", value = "510521"),
        cityItem(label = "合江县", value = "510522"),
        cityItem(label = "叙永县", value = "510524"),
        cityItem(label = "古蔺县", value = "510525")
    ),
    utsArrayOf(
        cityItem(label = "旌阳区", value = "510603"),
        cityItem(label = "罗江区", value = "510604"),
        cityItem(label = "中江县", value = "510623"),
        cityItem(label = "广汉市", value = "510681"),
        cityItem(label = "什邡市", value = "510682"),
        cityItem(label = "绵竹市", value = "510683")
    ),
    utsArrayOf(
        cityItem(label = "涪城区", value = "510703"),
        cityItem(label = "游仙区", value = "510704"),
        cityItem(label = "安州区", value = "510705"),
        cityItem(label = "三台县", value = "510722"),
        cityItem(label = "盐亭县", value = "510723"),
        cityItem(label = "梓潼县", value = "510725"),
        cityItem(label = "北川羌族自治县", value = "510726"),
        cityItem(label = "平武县", value = "510727"),
        cityItem(label = "江油市", value = "510781")
    ),
    utsArrayOf(
        cityItem(label = "利州区", value = "510802"),
        cityItem(label = "昭化区", value = "510811"),
        cityItem(label = "朝天区", value = "510812"),
        cityItem(label = "旺苍县", value = "510821"),
        cityItem(label = "青川县", value = "510822"),
        cityItem(label = "剑阁县", value = "510823"),
        cityItem(label = "苍溪县", value = "510824")
    ),
    utsArrayOf(
        cityItem(label = "船山区", value = "510903"),
        cityItem(label = "安居区", value = "510904"),
        cityItem(label = "蓬溪县", value = "510921"),
        cityItem(label = "射洪县", value = "510922"),
        cityItem(label = "大英县", value = "510923")
    ),
    utsArrayOf(
        cityItem(label = "市中区", value = "511002"),
        cityItem(label = "东兴区", value = "511011"),
        cityItem(label = "威远县", value = "511024"),
        cityItem(label = "资中县", value = "511025"),
        cityItem(label = "内江经济开发区", value = "511071"),
        cityItem(label = "隆昌市", value = "511083")
    ),
    utsArrayOf(
        cityItem(label = "市中区", value = "511102"),
        cityItem(label = "沙湾区", value = "511111"),
        cityItem(label = "五通桥区", value = "511112"),
        cityItem(label = "金口河区", value = "511113"),
        cityItem(label = "犍为县", value = "511123"),
        cityItem(label = "井研县", value = "511124"),
        cityItem(label = "夹江县", value = "511126"),
        cityItem(label = "沐川县", value = "511129"),
        cityItem(label = "峨边彝族自治县", value = "511132"),
        cityItem(label = "马边彝族自治县", value = "511133"),
        cityItem(label = "峨眉山市", value = "511181")
    ),
    utsArrayOf(
        cityItem(label = "顺庆区", value = "511302"),
        cityItem(label = "高坪区", value = "511303"),
        cityItem(label = "嘉陵区", value = "511304"),
        cityItem(label = "南部县", value = "511321"),
        cityItem(label = "营山县", value = "511322"),
        cityItem(label = "蓬安县", value = "511323"),
        cityItem(label = "仪陇县", value = "511324"),
        cityItem(label = "西充县", value = "511325"),
        cityItem(label = "阆中市", value = "511381")
    ),
    utsArrayOf(
        cityItem(label = "东坡区", value = "511402"),
        cityItem(label = "彭山区", value = "511403"),
        cityItem(label = "仁寿县", value = "511421"),
        cityItem(label = "洪雅县", value = "511423"),
        cityItem(label = "丹棱县", value = "511424"),
        cityItem(label = "青神县", value = "511425")
    ),
    utsArrayOf(
        cityItem(label = "翠屏区", value = "511502"),
        cityItem(label = "南溪区", value = "511503"),
        cityItem(label = "宜宾县", value = "511521"),
        cityItem(label = "江安县", value = "511523"),
        cityItem(label = "长宁县", value = "511524"),
        cityItem(label = "高县", value = "511525"),
        cityItem(label = "珙县", value = "511526"),
        cityItem(label = "筠连县", value = "511527"),
        cityItem(label = "兴文县", value = "511528"),
        cityItem(label = "屏山县", value = "511529")
    ),
    utsArrayOf(
        cityItem(label = "广安区", value = "511602"),
        cityItem(label = "前锋区", value = "511603"),
        cityItem(label = "岳池县", value = "511621"),
        cityItem(label = "武胜县", value = "511622"),
        cityItem(label = "邻水县", value = "511623"),
        cityItem(label = "华蓥市", value = "511681")
    ),
    utsArrayOf(
        cityItem(label = "通川区", value = "511702"),
        cityItem(label = "达川区", value = "511703"),
        cityItem(label = "宣汉县", value = "511722"),
        cityItem(label = "开江县", value = "511723"),
        cityItem(label = "大竹县", value = "511724"),
        cityItem(label = "渠县", value = "511725"),
        cityItem(label = "达州经济开发区", value = "511771"),
        cityItem(label = "万源市", value = "511781")
    ),
    utsArrayOf(
        cityItem(label = "雨城区", value = "511802"),
        cityItem(label = "名山区", value = "511803"),
        cityItem(label = "荥经县", value = "511822"),
        cityItem(label = "汉源县", value = "511823"),
        cityItem(label = "石棉县", value = "511824"),
        cityItem(label = "天全县", value = "511825"),
        cityItem(label = "芦山县", value = "511826"),
        cityItem(label = "宝兴县", value = "511827")
    ),
    utsArrayOf(
        cityItem(label = "巴州区", value = "511902"),
        cityItem(label = "恩阳区", value = "511903"),
        cityItem(label = "通江县", value = "511921"),
        cityItem(label = "南江县", value = "511922"),
        cityItem(label = "平昌县", value = "511923"),
        cityItem(label = "巴中经济开发区", value = "511971")
    ),
    utsArrayOf(
        cityItem(label = "雁江区", value = "512002"),
        cityItem(label = "安岳县", value = "512021"),
        cityItem(label = "乐至县", value = "512022")
    ),
    utsArrayOf(
        cityItem(label = "马尔康市", value = "513201"),
        cityItem(label = "汶川县", value = "513221"),
        cityItem(label = "理县", value = "513222"),
        cityItem(label = "茂县", value = "513223"),
        cityItem(label = "松潘县", value = "513224"),
        cityItem(label = "九寨沟县", value = "513225"),
        cityItem(label = "金川县", value = "513226"),
        cityItem(label = "小金县", value = "513227"),
        cityItem(label = "黑水县", value = "513228"),
        cityItem(label = "壤塘县", value = "513230"),
        cityItem(label = "阿坝县", value = "513231"),
        cityItem(label = "若尔盖县", value = "513232"),
        cityItem(label = "红原县", value = "513233")
    ),
    utsArrayOf(
        cityItem(label = "康定市", value = "513301"),
        cityItem(label = "泸定县", value = "513322"),
        cityItem(label = "丹巴县", value = "513323"),
        cityItem(label = "九龙县", value = "513324"),
        cityItem(label = "雅江县", value = "513325"),
        cityItem(label = "道孚县", value = "513326"),
        cityItem(label = "炉霍县", value = "513327"),
        cityItem(label = "甘孜县", value = "513328"),
        cityItem(label = "新龙县", value = "513329"),
        cityItem(label = "德格县", value = "513330"),
        cityItem(label = "白玉县", value = "513331"),
        cityItem(label = "石渠县", value = "513332"),
        cityItem(label = "色达县", value = "513333"),
        cityItem(label = "理塘县", value = "513334"),
        cityItem(label = "巴塘县", value = "513335"),
        cityItem(label = "乡城县", value = "513336"),
        cityItem(label = "稻城县", value = "513337"),
        cityItem(label = "得荣县", value = "513338")
    ),
    utsArrayOf(
        cityItem(label = "西昌市", value = "513401"),
        cityItem(label = "木里藏族自治县", value = "513422"),
        cityItem(label = "盐源县", value = "513423"),
        cityItem(label = "德昌县", value = "513424"),
        cityItem(label = "会理县", value = "513425"),
        cityItem(label = "会东县", value = "513426"),
        cityItem(label = "宁南县", value = "513427"),
        cityItem(label = "普格县", value = "513428"),
        cityItem(label = "布拖县", value = "513429"),
        cityItem(label = "金阳县", value = "513430"),
        cityItem(label = "昭觉县", value = "513431"),
        cityItem(label = "喜德县", value = "513432"),
        cityItem(label = "冕宁县", value = "513433"),
        cityItem(label = "越西县", value = "513434"),
        cityItem(label = "甘洛县", value = "513435"),
        cityItem(label = "美姑县", value = "513436"),
        cityItem(label = "雷波县", value = "513437")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "南明区", value = "520102"),
        cityItem(label = "云岩区", value = "520103"),
        cityItem(label = "花溪区", value = "520111"),
        cityItem(label = "乌当区", value = "520112"),
        cityItem(label = "白云区", value = "520113"),
        cityItem(label = "观山湖区", value = "520115"),
        cityItem(label = "开阳县", value = "520121"),
        cityItem(label = "息烽县", value = "520122"),
        cityItem(label = "修文县", value = "520123"),
        cityItem(label = "清镇市", value = "520181")
    ),
    utsArrayOf(
        cityItem(label = "钟山区", value = "520201"),
        cityItem(label = "六枝特区", value = "520203"),
        cityItem(label = "水城县", value = "520221"),
        cityItem(label = "盘州市", value = "520281")
    ),
    utsArrayOf(
        cityItem(label = "红花岗区", value = "520302"),
        cityItem(label = "汇川区", value = "520303"),
        cityItem(label = "播州区", value = "520304"),
        cityItem(label = "桐梓县", value = "520322"),
        cityItem(label = "绥阳县", value = "520323"),
        cityItem(label = "正安县", value = "520324"),
        cityItem(label = "道真仡佬族苗族自治县", value = "520325"),
        cityItem(label = "务川仡佬族苗族自治县", value = "520326"),
        cityItem(label = "凤冈县", value = "520327"),
        cityItem(label = "湄潭县", value = "520328"),
        cityItem(label = "余庆县", value = "520329"),
        cityItem(label = "习水县", value = "520330"),
        cityItem(label = "赤水市", value = "520381"),
        cityItem(label = "仁怀市", value = "520382")
    ),
    utsArrayOf(
        cityItem(label = "西秀区", value = "520402"),
        cityItem(label = "平坝区", value = "520403"),
        cityItem(label = "普定县", value = "520422"),
        cityItem(label = "镇宁布依族苗族自治县", value = "520423"),
        cityItem(label = "关岭布依族苗族自治县", value = "520424"),
        cityItem(label = "紫云苗族布依族自治县", value = "520425")
    ),
    utsArrayOf(
        cityItem(label = "七星关区", value = "520502"),
        cityItem(label = "大方县", value = "520521"),
        cityItem(label = "黔西县", value = "520522"),
        cityItem(label = "金沙县", value = "520523"),
        cityItem(label = "织金县", value = "520524"),
        cityItem(label = "纳雍县", value = "520525"),
        cityItem(label = "威宁彝族回族苗族自治县", value = "520526"),
        cityItem(label = "赫章县", value = "520527")
    ),
    utsArrayOf(
        cityItem(label = "碧江区", value = "520602"),
        cityItem(label = "万山区", value = "520603"),
        cityItem(label = "江口县", value = "520621"),
        cityItem(label = "玉屏侗族自治县", value = "520622"),
        cityItem(label = "石阡县", value = "520623"),
        cityItem(label = "思南县", value = "520624"),
        cityItem(label = "印江土家族苗族自治县", value = "520625"),
        cityItem(label = "德江县", value = "520626"),
        cityItem(label = "沿河土家族自治县", value = "520627"),
        cityItem(label = "松桃苗族自治县", value = "520628")
    ),
    utsArrayOf(
        cityItem(label = "兴义市", value = "522301"),
        cityItem(label = "兴仁县", value = "522322"),
        cityItem(label = "普安县", value = "522323"),
        cityItem(label = "晴隆县", value = "522324"),
        cityItem(label = "贞丰县", value = "522325"),
        cityItem(label = "望谟县", value = "522326"),
        cityItem(label = "册亨县", value = "522327"),
        cityItem(label = "安龙县", value = "522328")
    ),
    utsArrayOf(
        cityItem(label = "凯里市", value = "522601"),
        cityItem(label = "黄平县", value = "522622"),
        cityItem(label = "施秉县", value = "522623"),
        cityItem(label = "三穗县", value = "522624"),
        cityItem(label = "镇远县", value = "522625"),
        cityItem(label = "岑巩县", value = "522626"),
        cityItem(label = "天柱县", value = "522627"),
        cityItem(label = "锦屏县", value = "522628"),
        cityItem(label = "剑河县", value = "522629"),
        cityItem(label = "台江县", value = "522630"),
        cityItem(label = "黎平县", value = "522631"),
        cityItem(label = "榕江县", value = "522632"),
        cityItem(label = "从江县", value = "522633"),
        cityItem(label = "雷山县", value = "522634"),
        cityItem(label = "麻江县", value = "522635"),
        cityItem(label = "丹寨县", value = "522636")
    ),
    utsArrayOf(
        cityItem(label = "都匀市", value = "522701"),
        cityItem(label = "福泉市", value = "522702"),
        cityItem(label = "荔波县", value = "522722"),
        cityItem(label = "贵定县", value = "522723"),
        cityItem(label = "瓮安县", value = "522725"),
        cityItem(label = "独山县", value = "522726"),
        cityItem(label = "平塘县", value = "522727"),
        cityItem(label = "罗甸县", value = "522728"),
        cityItem(label = "长顺县", value = "522729"),
        cityItem(label = "龙里县", value = "522730"),
        cityItem(label = "惠水县", value = "522731"),
        cityItem(label = "三都水族自治县", value = "522732")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "五华区", value = "530102"),
        cityItem(label = "盘龙区", value = "530103"),
        cityItem(label = "官渡区", value = "530111"),
        cityItem(label = "西山区", value = "530112"),
        cityItem(label = "东川区", value = "530113"),
        cityItem(label = "呈贡区", value = "530114"),
        cityItem(label = "晋宁区", value = "530115"),
        cityItem(label = "富民县", value = "530124"),
        cityItem(label = "宜良县", value = "530125"),
        cityItem(label = "石林彝族自治县", value = "530126"),
        cityItem(label = "嵩明县", value = "530127"),
        cityItem(label = "禄劝彝族苗族自治县", value = "530128"),
        cityItem(label = "寻甸回族彝族自治县", value = "530129"),
        cityItem(label = "安宁市", value = "530181")
    ),
    utsArrayOf(
        cityItem(label = "麒麟区", value = "530302"),
        cityItem(label = "沾益区", value = "530303"),
        cityItem(label = "马龙县", value = "530321"),
        cityItem(label = "陆良县", value = "530322"),
        cityItem(label = "师宗县", value = "530323"),
        cityItem(label = "罗平县", value = "530324"),
        cityItem(label = "富源县", value = "530325"),
        cityItem(label = "会泽县", value = "530326"),
        cityItem(label = "宣威市", value = "530381")
    ),
    utsArrayOf(
        cityItem(label = "红塔区", value = "530402"),
        cityItem(label = "江川区", value = "530403"),
        cityItem(label = "澄江县", value = "530422"),
        cityItem(label = "通海县", value = "530423"),
        cityItem(label = "华宁县", value = "530424"),
        cityItem(label = "易门县", value = "530425"),
        cityItem(label = "峨山彝族自治县", value = "530426"),
        cityItem(label = "新平彝族傣族自治县", value = "530427"),
        cityItem(label = "元江哈尼族彝族傣族自治县", value = "530428")
    ),
    utsArrayOf(
        cityItem(label = "隆阳区", value = "530502"),
        cityItem(label = "施甸县", value = "530521"),
        cityItem(label = "龙陵县", value = "530523"),
        cityItem(label = "昌宁县", value = "530524"),
        cityItem(label = "腾冲市", value = "530581")
    ),
    utsArrayOf(
        cityItem(label = "昭阳区", value = "530602"),
        cityItem(label = "鲁甸县", value = "530621"),
        cityItem(label = "巧家县", value = "530622"),
        cityItem(label = "盐津县", value = "530623"),
        cityItem(label = "大关县", value = "530624"),
        cityItem(label = "永善县", value = "530625"),
        cityItem(label = "绥江县", value = "530626"),
        cityItem(label = "镇雄县", value = "530627"),
        cityItem(label = "彝良县", value = "530628"),
        cityItem(label = "威信县", value = "530629"),
        cityItem(label = "水富县", value = "530630")
    ),
    utsArrayOf(
        cityItem(label = "古城区", value = "530702"),
        cityItem(label = "玉龙纳西族自治县", value = "530721"),
        cityItem(label = "永胜县", value = "530722"),
        cityItem(label = "华坪县", value = "530723"),
        cityItem(label = "宁蒗彝族自治县", value = "530724")
    ),
    utsArrayOf(
        cityItem(label = "思茅区", value = "530802"),
        cityItem(label = "宁洱哈尼族彝族自治县", value = "530821"),
        cityItem(label = "墨江哈尼族自治县", value = "530822"),
        cityItem(label = "景东彝族自治县", value = "530823"),
        cityItem(label = "景谷傣族彝族自治县", value = "530824"),
        cityItem(label = "镇沅彝族哈尼族拉祜族自治县", value = "530825"),
        cityItem(label = "江城哈尼族彝族自治县", value = "530826"),
        cityItem(label = "孟连傣族拉祜族佤族自治县", value = "530827"),
        cityItem(label = "澜沧拉祜族自治县", value = "530828"),
        cityItem(label = "西盟佤族自治县", value = "530829")
    ),
    utsArrayOf(
        cityItem(label = "临翔区", value = "530902"),
        cityItem(label = "凤庆县", value = "530921"),
        cityItem(label = "云县", value = "530922"),
        cityItem(label = "永德县", value = "530923"),
        cityItem(label = "镇康县", value = "530924"),
        cityItem(label = "双江拉祜族佤族布朗族傣族自治县", value = "530925"),
        cityItem(label = "耿马傣族佤族自治县", value = "530926"),
        cityItem(label = "沧源佤族自治县", value = "530927")
    ),
    utsArrayOf(
        cityItem(label = "楚雄市", value = "532301"),
        cityItem(label = "双柏县", value = "532322"),
        cityItem(label = "牟定县", value = "532323"),
        cityItem(label = "南华县", value = "532324"),
        cityItem(label = "姚安县", value = "532325"),
        cityItem(label = "大姚县", value = "532326"),
        cityItem(label = "永仁县", value = "532327"),
        cityItem(label = "元谋县", value = "532328"),
        cityItem(label = "武定县", value = "532329"),
        cityItem(label = "禄丰县", value = "532331")
    ),
    utsArrayOf(
        cityItem(label = "个旧市", value = "532501"),
        cityItem(label = "开远市", value = "532502"),
        cityItem(label = "蒙自市", value = "532503"),
        cityItem(label = "弥勒市", value = "532504"),
        cityItem(label = "屏边苗族自治县", value = "532523"),
        cityItem(label = "建水县", value = "532524"),
        cityItem(label = "石屏县", value = "532525"),
        cityItem(label = "泸西县", value = "532527"),
        cityItem(label = "元阳县", value = "532528"),
        cityItem(label = "红河县", value = "532529"),
        cityItem(label = "金平苗族瑶族傣族自治县", value = "532530"),
        cityItem(label = "绿春县", value = "532531"),
        cityItem(label = "河口瑶族自治县", value = "532532")
    ),
    utsArrayOf(
        cityItem(label = "文山市", value = "532601"),
        cityItem(label = "砚山县", value = "532622"),
        cityItem(label = "西畴县", value = "532623"),
        cityItem(label = "麻栗坡县", value = "532624"),
        cityItem(label = "马关县", value = "532625"),
        cityItem(label = "丘北县", value = "532626"),
        cityItem(label = "广南县", value = "532627"),
        cityItem(label = "富宁县", value = "532628")
    ),
    utsArrayOf(
        cityItem(label = "景洪市", value = "532801"),
        cityItem(label = "勐海县", value = "532822"),
        cityItem(label = "勐腊县", value = "532823")
    ),
    utsArrayOf(
        cityItem(label = "大理市", value = "532901"),
        cityItem(label = "漾濞彝族自治县", value = "532922"),
        cityItem(label = "祥云县", value = "532923"),
        cityItem(label = "宾川县", value = "532924"),
        cityItem(label = "弥渡县", value = "532925"),
        cityItem(label = "南涧彝族自治县", value = "532926"),
        cityItem(label = "巍山彝族回族自治县", value = "532927"),
        cityItem(label = "永平县", value = "532928"),
        cityItem(label = "云龙县", value = "532929"),
        cityItem(label = "洱源县", value = "532930"),
        cityItem(label = "剑川县", value = "532931"),
        cityItem(label = "鹤庆县", value = "532932")
    ),
    utsArrayOf(
        cityItem(label = "瑞丽市", value = "533102"),
        cityItem(label = "芒市", value = "533103"),
        cityItem(label = "梁河县", value = "533122"),
        cityItem(label = "盈江县", value = "533123"),
        cityItem(label = "陇川县", value = "533124")
    ),
    utsArrayOf(
        cityItem(label = "泸水市", value = "533301"),
        cityItem(label = "福贡县", value = "533323"),
        cityItem(label = "贡山独龙族怒族自治县", value = "533324"),
        cityItem(label = "兰坪白族普米族自治县", value = "533325")
    ),
    utsArrayOf(
        cityItem(label = "香格里拉市", value = "533401"),
        cityItem(label = "德钦县", value = "533422"),
        cityItem(label = "维西傈僳族自治县", value = "533423")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "城关区", value = "540102"),
        cityItem(label = "堆龙德庆区", value = "540103"),
        cityItem(label = "林周县", value = "540121"),
        cityItem(label = "当雄县", value = "540122"),
        cityItem(label = "尼木县", value = "540123"),
        cityItem(label = "曲水县", value = "540124"),
        cityItem(label = "达孜县", value = "540126"),
        cityItem(label = "墨竹工卡县", value = "540127"),
        cityItem(label = "格尔木藏青工业园区", value = "540171"),
        cityItem(label = "拉萨经济技术开发区", value = "540172"),
        cityItem(label = "西藏文化旅游创意园区", value = "540173"),
        cityItem(label = "达孜工业园区", value = "540174")
    ),
    utsArrayOf(
        cityItem(label = "桑珠孜区", value = "540202"),
        cityItem(label = "南木林县", value = "540221"),
        cityItem(label = "江孜县", value = "540222"),
        cityItem(label = "定日县", value = "540223"),
        cityItem(label = "萨迦县", value = "540224"),
        cityItem(label = "拉孜县", value = "540225"),
        cityItem(label = "昂仁县", value = "540226"),
        cityItem(label = "谢通门县", value = "540227"),
        cityItem(label = "白朗县", value = "540228"),
        cityItem(label = "仁布县", value = "540229"),
        cityItem(label = "康马县", value = "540230"),
        cityItem(label = "定结县", value = "540231"),
        cityItem(label = "仲巴县", value = "540232"),
        cityItem(label = "亚东县", value = "540233"),
        cityItem(label = "吉隆县", value = "540234"),
        cityItem(label = "聂拉木县", value = "540235"),
        cityItem(label = "萨嘎县", value = "540236"),
        cityItem(label = "岗巴县", value = "540237")
    ),
    utsArrayOf(
        cityItem(label = "卡若区", value = "540302"),
        cityItem(label = "江达县", value = "540321"),
        cityItem(label = "贡觉县", value = "540322"),
        cityItem(label = "类乌齐县", value = "540323"),
        cityItem(label = "丁青县", value = "540324"),
        cityItem(label = "察雅县", value = "540325"),
        cityItem(label = "八宿县", value = "540326"),
        cityItem(label = "左贡县", value = "540327"),
        cityItem(label = "芒康县", value = "540328"),
        cityItem(label = "洛隆县", value = "540329"),
        cityItem(label = "边坝县", value = "540330")
    ),
    utsArrayOf(
        cityItem(label = "巴宜区", value = "540402"),
        cityItem(label = "工布江达县", value = "540421"),
        cityItem(label = "米林县", value = "540422"),
        cityItem(label = "墨脱县", value = "540423"),
        cityItem(label = "波密县", value = "540424"),
        cityItem(label = "察隅县", value = "540425"),
        cityItem(label = "朗县", value = "540426")
    ),
    utsArrayOf(
        cityItem(label = "乃东区", value = "540502"),
        cityItem(label = "扎囊县", value = "540521"),
        cityItem(label = "贡嘎县", value = "540522"),
        cityItem(label = "桑日县", value = "540523"),
        cityItem(label = "琼结县", value = "540524"),
        cityItem(label = "曲松县", value = "540525"),
        cityItem(label = "措美县", value = "540526"),
        cityItem(label = "洛扎县", value = "540527"),
        cityItem(label = "加查县", value = "540528"),
        cityItem(label = "隆子县", value = "540529"),
        cityItem(label = "错那县", value = "540530"),
        cityItem(label = "浪卡子县", value = "540531")
    ),
    utsArrayOf(
        cityItem(label = "那曲县", value = "542421"),
        cityItem(label = "嘉黎县", value = "542422"),
        cityItem(label = "比如县", value = "542423"),
        cityItem(label = "聂荣县", value = "542424"),
        cityItem(label = "安多县", value = "542425"),
        cityItem(label = "申扎县", value = "542426"),
        cityItem(label = "索县", value = "542427"),
        cityItem(label = "班戈县", value = "542428"),
        cityItem(label = "巴青县", value = "542429"),
        cityItem(label = "尼玛县", value = "542430"),
        cityItem(label = "双湖县", value = "542431")
    ),
    utsArrayOf(
        cityItem(label = "普兰县", value = "542521"),
        cityItem(label = "札达县", value = "542522"),
        cityItem(label = "噶尔县", value = "542523"),
        cityItem(label = "日土县", value = "542524"),
        cityItem(label = "革吉县", value = "542525"),
        cityItem(label = "改则县", value = "542526"),
        cityItem(label = "措勤县", value = "542527")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "新城区", value = "610102"),
        cityItem(label = "碑林区", value = "610103"),
        cityItem(label = "莲湖区", value = "610104"),
        cityItem(label = "灞桥区", value = "610111"),
        cityItem(label = "未央区", value = "610112"),
        cityItem(label = "雁塔区", value = "610113"),
        cityItem(label = "阎良区", value = "610114"),
        cityItem(label = "临潼区", value = "610115"),
        cityItem(label = "长安区", value = "610116"),
        cityItem(label = "高陵区", value = "610117"),
        cityItem(label = "鄠邑区", value = "610118"),
        cityItem(label = "蓝田县", value = "610122"),
        cityItem(label = "周至县", value = "610124")
    ),
    utsArrayOf(
        cityItem(label = "王益区", value = "610202"),
        cityItem(label = "印台区", value = "610203"),
        cityItem(label = "耀州区", value = "610204"),
        cityItem(label = "宜君县", value = "610222")
    ),
    utsArrayOf(
        cityItem(label = "渭滨区", value = "610302"),
        cityItem(label = "金台区", value = "610303"),
        cityItem(label = "陈仓区", value = "610304"),
        cityItem(label = "凤翔县", value = "610322"),
        cityItem(label = "岐山县", value = "610323"),
        cityItem(label = "扶风县", value = "610324"),
        cityItem(label = "眉县", value = "610326"),
        cityItem(label = "陇县", value = "610327"),
        cityItem(label = "千阳县", value = "610328"),
        cityItem(label = "麟游县", value = "610329"),
        cityItem(label = "凤县", value = "610330"),
        cityItem(label = "太白县", value = "610331")
    ),
    utsArrayOf(
        cityItem(label = "秦都区", value = "610402"),
        cityItem(label = "杨陵区", value = "610403"),
        cityItem(label = "渭城区", value = "610404"),
        cityItem(label = "三原县", value = "610422"),
        cityItem(label = "泾阳县", value = "610423"),
        cityItem(label = "乾县", value = "610424"),
        cityItem(label = "礼泉县", value = "610425"),
        cityItem(label = "永寿县", value = "610426"),
        cityItem(label = "彬县", value = "610427"),
        cityItem(label = "长武县", value = "610428"),
        cityItem(label = "旬邑县", value = "610429"),
        cityItem(label = "淳化县", value = "610430"),
        cityItem(label = "武功县", value = "610431"),
        cityItem(label = "兴平市", value = "610481")
    ),
    utsArrayOf(
        cityItem(label = "临渭区", value = "610502"),
        cityItem(label = "华州区", value = "610503"),
        cityItem(label = "潼关县", value = "610522"),
        cityItem(label = "大荔县", value = "610523"),
        cityItem(label = "合阳县", value = "610524"),
        cityItem(label = "澄城县", value = "610525"),
        cityItem(label = "蒲城县", value = "610526"),
        cityItem(label = "白水县", value = "610527"),
        cityItem(label = "富平县", value = "610528"),
        cityItem(label = "韩城市", value = "610581"),
        cityItem(label = "华阴市", value = "610582")
    ),
    utsArrayOf(
        cityItem(label = "宝塔区", value = "610602"),
        cityItem(label = "安塞区", value = "610603"),
        cityItem(label = "延长县", value = "610621"),
        cityItem(label = "延川县", value = "610622"),
        cityItem(label = "子长县", value = "610623"),
        cityItem(label = "志丹县", value = "610625"),
        cityItem(label = "吴起县", value = "610626"),
        cityItem(label = "甘泉县", value = "610627"),
        cityItem(label = "富县", value = "610628"),
        cityItem(label = "洛川县", value = "610629"),
        cityItem(label = "宜川县", value = "610630"),
        cityItem(label = "黄龙县", value = "610631"),
        cityItem(label = "黄陵县", value = "610632")
    ),
    utsArrayOf(
        cityItem(label = "汉台区", value = "610702"),
        cityItem(label = "南郑区", value = "610703"),
        cityItem(label = "城固县", value = "610722"),
        cityItem(label = "洋县", value = "610723"),
        cityItem(label = "西乡县", value = "610724"),
        cityItem(label = "勉县", value = "610725"),
        cityItem(label = "宁强县", value = "610726"),
        cityItem(label = "略阳县", value = "610727"),
        cityItem(label = "镇巴县", value = "610728"),
        cityItem(label = "留坝县", value = "610729"),
        cityItem(label = "佛坪县", value = "610730")
    ),
    utsArrayOf(
        cityItem(label = "榆阳区", value = "610802"),
        cityItem(label = "横山区", value = "610803"),
        cityItem(label = "府谷县", value = "610822"),
        cityItem(label = "靖边县", value = "610824"),
        cityItem(label = "定边县", value = "610825"),
        cityItem(label = "绥德县", value = "610826"),
        cityItem(label = "米脂县", value = "610827"),
        cityItem(label = "佳县", value = "610828"),
        cityItem(label = "吴堡县", value = "610829"),
        cityItem(label = "清涧县", value = "610830"),
        cityItem(label = "子洲县", value = "610831"),
        cityItem(label = "神木市", value = "610881")
    ),
    utsArrayOf(
        cityItem(label = "汉滨区", value = "610902"),
        cityItem(label = "汉阴县", value = "610921"),
        cityItem(label = "石泉县", value = "610922"),
        cityItem(label = "宁陕县", value = "610923"),
        cityItem(label = "紫阳县", value = "610924"),
        cityItem(label = "岚皋县", value = "610925"),
        cityItem(label = "平利县", value = "610926"),
        cityItem(label = "镇坪县", value = "610927"),
        cityItem(label = "旬阳县", value = "610928"),
        cityItem(label = "白河县", value = "610929")
    ),
    utsArrayOf(
        cityItem(label = "商州区", value = "611002"),
        cityItem(label = "洛南县", value = "611021"),
        cityItem(label = "丹凤县", value = "611022"),
        cityItem(label = "商南县", value = "611023"),
        cityItem(label = "山阳县", value = "611024"),
        cityItem(label = "镇安县", value = "611025"),
        cityItem(label = "柞水县", value = "611026")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "城关区", value = "620102"),
        cityItem(label = "七里河区", value = "620103"),
        cityItem(label = "西固区", value = "620104"),
        cityItem(label = "安宁区", value = "620105"),
        cityItem(label = "红古区", value = "620111"),
        cityItem(label = "永登县", value = "620121"),
        cityItem(label = "皋兰县", value = "620122"),
        cityItem(label = "榆中县", value = "620123"),
        cityItem(label = "兰州新区", value = "620171")
    ),
    utsArrayOf(
        cityItem(label = "嘉峪关市", value = "620201")
    ),
    utsArrayOf(
        cityItem(label = "金川区", value = "620302"),
        cityItem(label = "永昌县", value = "620321")
    ),
    utsArrayOf(
        cityItem(label = "白银区", value = "620402"),
        cityItem(label = "平川区", value = "620403"),
        cityItem(label = "靖远县", value = "620421"),
        cityItem(label = "会宁县", value = "620422"),
        cityItem(label = "景泰县", value = "620423")
    ),
    utsArrayOf(
        cityItem(label = "秦州区", value = "620502"),
        cityItem(label = "麦积区", value = "620503"),
        cityItem(label = "清水县", value = "620521"),
        cityItem(label = "秦安县", value = "620522"),
        cityItem(label = "甘谷县", value = "620523"),
        cityItem(label = "武山县", value = "620524"),
        cityItem(label = "张家川回族自治县", value = "620525")
    ),
    utsArrayOf(
        cityItem(label = "凉州区", value = "620602"),
        cityItem(label = "民勤县", value = "620621"),
        cityItem(label = "古浪县", value = "620622"),
        cityItem(label = "天祝藏族自治县", value = "620623")
    ),
    utsArrayOf(
        cityItem(label = "甘州区", value = "620702"),
        cityItem(label = "肃南裕固族自治县", value = "620721"),
        cityItem(label = "民乐县", value = "620722"),
        cityItem(label = "临泽县", value = "620723"),
        cityItem(label = "高台县", value = "620724"),
        cityItem(label = "山丹县", value = "620725")
    ),
    utsArrayOf(
        cityItem(label = "崆峒区", value = "620802"),
        cityItem(label = "泾川县", value = "620821"),
        cityItem(label = "灵台县", value = "620822"),
        cityItem(label = "崇信县", value = "620823"),
        cityItem(label = "华亭县", value = "620824"),
        cityItem(label = "庄浪县", value = "620825"),
        cityItem(label = "静宁县", value = "620826"),
        cityItem(label = "平凉工业园区", value = "620871")
    ),
    utsArrayOf(
        cityItem(label = "肃州区", value = "620902"),
        cityItem(label = "金塔县", value = "620921"),
        cityItem(label = "瓜州县", value = "620922"),
        cityItem(label = "肃北蒙古族自治县", value = "620923"),
        cityItem(label = "阿克塞哈萨克族自治县", value = "620924"),
        cityItem(label = "玉门市", value = "620981"),
        cityItem(label = "敦煌市", value = "620982")
    ),
    utsArrayOf(
        cityItem(label = "西峰区", value = "621002"),
        cityItem(label = "庆城县", value = "621021"),
        cityItem(label = "环县", value = "621022"),
        cityItem(label = "华池县", value = "621023"),
        cityItem(label = "合水县", value = "621024"),
        cityItem(label = "正宁县", value = "621025"),
        cityItem(label = "宁县", value = "621026"),
        cityItem(label = "镇原县", value = "621027")
    ),
    utsArrayOf(
        cityItem(label = "安定区", value = "621102"),
        cityItem(label = "通渭县", value = "621121"),
        cityItem(label = "陇西县", value = "621122"),
        cityItem(label = "渭源县", value = "621123"),
        cityItem(label = "临洮县", value = "621124"),
        cityItem(label = "漳县", value = "621125"),
        cityItem(label = "岷县", value = "621126")
    ),
    utsArrayOf(
        cityItem(label = "武都区", value = "621202"),
        cityItem(label = "成县", value = "621221"),
        cityItem(label = "文县", value = "621222"),
        cityItem(label = "宕昌县", value = "621223"),
        cityItem(label = "康县", value = "621224"),
        cityItem(label = "西和县", value = "621225"),
        cityItem(label = "礼县", value = "621226"),
        cityItem(label = "徽县", value = "621227"),
        cityItem(label = "两当县", value = "621228")
    ),
    utsArrayOf(
        cityItem(label = "临夏市", value = "622901"),
        cityItem(label = "临夏县", value = "622921"),
        cityItem(label = "康乐县", value = "622922"),
        cityItem(label = "永靖县", value = "622923"),
        cityItem(label = "广河县", value = "622924"),
        cityItem(label = "和政县", value = "622925"),
        cityItem(label = "东乡族自治县", value = "622926"),
        cityItem(label = "积石山保安族东乡族撒拉族自治县", value = "622927")
    ),
    utsArrayOf(
        cityItem(label = "合作市", value = "623001"),
        cityItem(label = "临潭县", value = "623021"),
        cityItem(label = "卓尼县", value = "623022"),
        cityItem(label = "舟曲县", value = "623023"),
        cityItem(label = "迭部县", value = "623024"),
        cityItem(label = "玛曲县", value = "623025"),
        cityItem(label = "碌曲县", value = "623026"),
        cityItem(label = "夏河县", value = "623027")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "城东区", value = "630102"),
        cityItem(label = "城中区", value = "630103"),
        cityItem(label = "城西区", value = "630104"),
        cityItem(label = "城北区", value = "630105"),
        cityItem(label = "大通回族土族自治县", value = "630121"),
        cityItem(label = "湟中县", value = "630122"),
        cityItem(label = "湟源县", value = "630123")
    ),
    utsArrayOf(
        cityItem(label = "乐都区", value = "630202"),
        cityItem(label = "平安区", value = "630203"),
        cityItem(label = "民和回族土族自治县", value = "630222"),
        cityItem(label = "互助土族自治县", value = "630223"),
        cityItem(label = "化隆回族自治县", value = "630224"),
        cityItem(label = "循化撒拉族自治县", value = "630225")
    ),
    utsArrayOf(
        cityItem(label = "门源回族自治县", value = "632221"),
        cityItem(label = "祁连县", value = "632222"),
        cityItem(label = "海晏县", value = "632223"),
        cityItem(label = "刚察县", value = "632224")
    ),
    utsArrayOf(
        cityItem(label = "同仁县", value = "632321"),
        cityItem(label = "尖扎县", value = "632322"),
        cityItem(label = "泽库县", value = "632323"),
        cityItem(label = "河南蒙古族自治县", value = "632324")
    ),
    utsArrayOf(
        cityItem(label = "共和县", value = "632521"),
        cityItem(label = "同德县", value = "632522"),
        cityItem(label = "贵德县", value = "632523"),
        cityItem(label = "兴海县", value = "632524"),
        cityItem(label = "贵南县", value = "632525")
    ),
    utsArrayOf(
        cityItem(label = "玛沁县", value = "632621"),
        cityItem(label = "班玛县", value = "632622"),
        cityItem(label = "甘德县", value = "632623"),
        cityItem(label = "达日县", value = "632624"),
        cityItem(label = "久治县", value = "632625"),
        cityItem(label = "玛多县", value = "632626")
    ),
    utsArrayOf(
        cityItem(label = "玉树市", value = "632701"),
        cityItem(label = "杂多县", value = "632722"),
        cityItem(label = "称多县", value = "632723"),
        cityItem(label = "治多县", value = "632724"),
        cityItem(label = "囊谦县", value = "632725"),
        cityItem(label = "曲麻莱县", value = "632726")
    ),
    utsArrayOf(
        cityItem(label = "格尔木市", value = "632801"),
        cityItem(label = "德令哈市", value = "632802"),
        cityItem(label = "乌兰县", value = "632821"),
        cityItem(label = "都兰县", value = "632822"),
        cityItem(label = "天峻县", value = "632823"),
        cityItem(label = "大柴旦行政委员会", value = "632857"),
        cityItem(label = "冷湖行政委员会", value = "632858"),
        cityItem(label = "茫崖行政委员会", value = "632859")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "兴庆区", value = "640104"),
        cityItem(label = "西夏区", value = "640105"),
        cityItem(label = "金凤区", value = "640106"),
        cityItem(label = "永宁县", value = "640121"),
        cityItem(label = "贺兰县", value = "640122"),
        cityItem(label = "灵武市", value = "640181")
    ),
    utsArrayOf(
        cityItem(label = "大武口区", value = "640202"),
        cityItem(label = "惠农区", value = "640205"),
        cityItem(label = "平罗县", value = "640221")
    ),
    utsArrayOf(
        cityItem(label = "利通区", value = "640302"),
        cityItem(label = "红寺堡区", value = "640303"),
        cityItem(label = "盐池县", value = "640323"),
        cityItem(label = "同心县", value = "640324"),
        cityItem(label = "青铜峡市", value = "640381")
    ),
    utsArrayOf(
        cityItem(label = "原州区", value = "640402"),
        cityItem(label = "西吉县", value = "640422"),
        cityItem(label = "隆德县", value = "640423"),
        cityItem(label = "泾源县", value = "640424"),
        cityItem(label = "彭阳县", value = "640425")
    ),
    utsArrayOf(
        cityItem(label = "沙坡头区", value = "640502"),
        cityItem(label = "中宁县", value = "640521"),
        cityItem(label = "海原县", value = "640522")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "天山区", value = "650102"),
        cityItem(label = "沙依巴克区", value = "650103"),
        cityItem(label = "新市区", value = "650104"),
        cityItem(label = "水磨沟区", value = "650105"),
        cityItem(label = "头屯河区", value = "650106"),
        cityItem(label = "达坂城区", value = "650107"),
        cityItem(label = "米东区", value = "650109"),
        cityItem(label = "乌鲁木齐县", value = "650121"),
        cityItem(label = "乌鲁木齐经济技术开发区", value = "650171"),
        cityItem(label = "乌鲁木齐高新技术产业开发区", value = "650172")
    ),
    utsArrayOf(
        cityItem(label = "独山子区", value = "650202"),
        cityItem(label = "克拉玛依区", value = "650203"),
        cityItem(label = "白碱滩区", value = "650204"),
        cityItem(label = "乌尔禾区", value = "650205")
    ),
    utsArrayOf(
        cityItem(label = "高昌区", value = "650402"),
        cityItem(label = "鄯善县", value = "650421"),
        cityItem(label = "托克逊县", value = "650422")
    ),
    utsArrayOf(
        cityItem(label = "伊州区", value = "650502"),
        cityItem(label = "巴里坤哈萨克自治县", value = "650521"),
        cityItem(label = "伊吾县", value = "650522")
    ),
    utsArrayOf(
        cityItem(label = "昌吉市", value = "652301"),
        cityItem(label = "阜康市", value = "652302"),
        cityItem(label = "呼图壁县", value = "652323"),
        cityItem(label = "玛纳斯县", value = "652324"),
        cityItem(label = "奇台县", value = "652325"),
        cityItem(label = "吉木萨尔县", value = "652327"),
        cityItem(label = "木垒哈萨克自治县", value = "652328")
    ),
    utsArrayOf(
        cityItem(label = "博乐市", value = "652701"),
        cityItem(label = "阿拉山口市", value = "652702"),
        cityItem(label = "精河县", value = "652722"),
        cityItem(label = "温泉县", value = "652723")
    ),
    utsArrayOf(
        cityItem(label = "库尔勒市", value = "652801"),
        cityItem(label = "轮台县", value = "652822"),
        cityItem(label = "尉犁县", value = "652823"),
        cityItem(label = "若羌县", value = "652824"),
        cityItem(label = "且末县", value = "652825"),
        cityItem(label = "焉耆回族自治县", value = "652826"),
        cityItem(label = "和静县", value = "652827"),
        cityItem(label = "和硕县", value = "652828"),
        cityItem(label = "博湖县", value = "652829"),
        cityItem(label = "库尔勒经济技术开发区", value = "652871")
    ),
    utsArrayOf(
        cityItem(label = "阿克苏市", value = "652901"),
        cityItem(label = "温宿县", value = "652922"),
        cityItem(label = "库车县", value = "652923"),
        cityItem(label = "沙雅县", value = "652924"),
        cityItem(label = "新和县", value = "652925"),
        cityItem(label = "拜城县", value = "652926"),
        cityItem(label = "乌什县", value = "652927"),
        cityItem(label = "阿瓦提县", value = "652928"),
        cityItem(label = "柯坪县", value = "652929")
    ),
    utsArrayOf(
        cityItem(label = "阿图什市", value = "653001"),
        cityItem(label = "阿克陶县", value = "653022"),
        cityItem(label = "阿合奇县", value = "653023"),
        cityItem(label = "乌恰县", value = "653024")
    ),
    utsArrayOf(
        cityItem(label = "喀什市", value = "653101"),
        cityItem(label = "疏附县", value = "653121"),
        cityItem(label = "疏勒县", value = "653122"),
        cityItem(label = "英吉沙县", value = "653123"),
        cityItem(label = "泽普县", value = "653124"),
        cityItem(label = "莎车县", value = "653125"),
        cityItem(label = "叶城县", value = "653126"),
        cityItem(label = "麦盖提县", value = "653127"),
        cityItem(label = "岳普湖县", value = "653128"),
        cityItem(label = "伽师县", value = "653129"),
        cityItem(label = "巴楚县", value = "653130"),
        cityItem(label = "塔什库尔干塔吉克自治县", value = "653131")
    ),
    utsArrayOf(
        cityItem(label = "和田市", value = "653201"),
        cityItem(label = "和田县", value = "653221"),
        cityItem(label = "墨玉县", value = "653222"),
        cityItem(label = "皮山县", value = "653223"),
        cityItem(label = "洛浦县", value = "653224"),
        cityItem(label = "策勒县", value = "653225"),
        cityItem(label = "于田县", value = "653226"),
        cityItem(label = "民丰县", value = "653227")
    ),
    utsArrayOf(
        cityItem(label = "伊宁市", value = "654002"),
        cityItem(label = "奎屯市", value = "654003"),
        cityItem(label = "霍尔果斯市", value = "654004"),
        cityItem(label = "伊宁县", value = "654021"),
        cityItem(label = "察布查尔锡伯自治县", value = "654022"),
        cityItem(label = "霍城县", value = "654023"),
        cityItem(label = "巩留县", value = "654024"),
        cityItem(label = "新源县", value = "654025"),
        cityItem(label = "昭苏县", value = "654026"),
        cityItem(label = "特克斯县", value = "654027"),
        cityItem(label = "尼勒克县", value = "654028")
    ),
    utsArrayOf(
        cityItem(label = "塔城市", value = "654201"),
        cityItem(label = "乌苏市", value = "654202"),
        cityItem(label = "额敏县", value = "654221"),
        cityItem(label = "沙湾县", value = "654223"),
        cityItem(label = "托里县", value = "654224"),
        cityItem(label = "裕民县", value = "654225"),
        cityItem(label = "和布克赛尔蒙古自治县", value = "654226")
    ),
    utsArrayOf(
        cityItem(label = "阿勒泰市", value = "654301"),
        cityItem(label = "布尔津县", value = "654321"),
        cityItem(label = "富蕴县", value = "654322"),
        cityItem(label = "福海县", value = "654323"),
        cityItem(label = "哈巴河县", value = "654324"),
        cityItem(label = "青河县", value = "654325"),
        cityItem(label = "吉木乃县", value = "654326")
    ),
    utsArrayOf(
        cityItem(label = "石河子市", value = "659001"),
        cityItem(label = "阿拉尔市", value = "659002"),
        cityItem(label = "图木舒克市", value = "659003"),
        cityItem(label = "五家渠市", value = "659004"),
        cityItem(label = "铁门关市", value = "659006")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "台北", value = "660101")
    ),
    utsArrayOf(
        cityItem(label = "高雄", value = "660201")
    ),
    utsArrayOf(
        cityItem(label = "基隆", value = "660301")
    ),
    utsArrayOf(
        cityItem(label = "台中", value = "660401")
    ),
    utsArrayOf(
        cityItem(label = "台南", value = "660501")
    ),
    utsArrayOf(
        cityItem(label = "新竹", value = "660601")
    ),
    utsArrayOf(
        cityItem(label = "嘉义", value = "660701")
    ),
    utsArrayOf(
        cityItem(label = "宜兰", value = "660801")
    ),
    utsArrayOf(
        cityItem(label = "桃园", value = "660901")
    ),
    utsArrayOf(
        cityItem(label = "苗栗", value = "661001")
    ),
    utsArrayOf(
        cityItem(label = "彰化", value = "661101")
    ),
    utsArrayOf(
        cityItem(label = "南投", value = "661201")
    ),
    utsArrayOf(
        cityItem(label = "云林", value = "661301")
    ),
    utsArrayOf(
        cityItem(label = "屏东", value = "661401")
    ),
    utsArrayOf(
        cityItem(label = "台东", value = "661501")
    ),
    utsArrayOf(
        cityItem(label = "花莲", value = "661601")
    ),
    utsArrayOf(
        cityItem(label = "澎湖", value = "661701")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "香港岛", value = "670101")
    ),
    utsArrayOf(
        cityItem(label = "九龙", value = "670201")
    ),
    utsArrayOf(
        cityItem(label = "新界", value = "670301")
    )
), utsArrayOf(
    utsArrayOf(
        cityItem(label = "澳门半岛", value = "680101")
    ),
    utsArrayOf(
        cityItem(label = "氹仔岛", value = "680201")
    ),
    utsArrayOf(
        cityItem(label = "路环岛", value = "680301")
    ),
    utsArrayOf(
        cityItem(label = "路氹城", value = "680401")
    )
));
val GenComponentsFCityPickerFCityPickerClass = CreateVueComponent(GenComponentsFCityPickerFCityPicker::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsFCityPickerFCityPicker.inheritAttrs, inject = GenComponentsFCityPickerFCityPicker.inject, props = GenComponentsFCityPickerFCityPicker.props, propsNeedCastKeys = GenComponentsFCityPickerFCityPicker.propsNeedCastKeys, emits = GenComponentsFCityPickerFCityPicker.emits, components = GenComponentsFCityPickerFCityPicker.components, styles = GenComponentsFCityPickerFCityPicker.styles);
}
, fun(instance): GenComponentsFCityPickerFCityPicker {
    return GenComponentsFCityPickerFCityPicker(instance);
}
);
val GenPagesUserEditinfoUserEditinfoClass = CreateVueComponent(GenPagesUserEditinfoUserEditinfo::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserEditinfoUserEditinfo.inheritAttrs, inject = GenPagesUserEditinfoUserEditinfo.inject, props = GenPagesUserEditinfoUserEditinfo.props, propsNeedCastKeys = GenPagesUserEditinfoUserEditinfo.propsNeedCastKeys, emits = GenPagesUserEditinfoUserEditinfo.emits, components = GenPagesUserEditinfoUserEditinfo.components, styles = GenPagesUserEditinfoUserEditinfo.styles);
}
, fun(instance): GenPagesUserEditinfoUserEditinfo {
    return GenPagesUserEditinfoUserEditinfo(instance);
}
);
val GenComponentsFeedbackItemFeedbackItemClass = CreateVueComponent(GenComponentsFeedbackItemFeedbackItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsFeedbackItemFeedbackItem.name, inheritAttrs = GenComponentsFeedbackItemFeedbackItem.inheritAttrs, inject = GenComponentsFeedbackItemFeedbackItem.inject, props = GenComponentsFeedbackItemFeedbackItem.props, propsNeedCastKeys = GenComponentsFeedbackItemFeedbackItem.propsNeedCastKeys, emits = GenComponentsFeedbackItemFeedbackItem.emits, components = GenComponentsFeedbackItemFeedbackItem.components, styles = GenComponentsFeedbackItemFeedbackItem.styles);
}
, fun(instance): GenComponentsFeedbackItemFeedbackItem {
    return GenComponentsFeedbackItemFeedbackItem(instance);
}
);
val GenPagesUserFeedbackUserFeedbackClass = CreateVueComponent(GenPagesUserFeedbackUserFeedback::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserFeedbackUserFeedback.inheritAttrs, inject = GenPagesUserFeedbackUserFeedback.inject, props = GenPagesUserFeedbackUserFeedback.props, propsNeedCastKeys = GenPagesUserFeedbackUserFeedback.propsNeedCastKeys, emits = GenPagesUserFeedbackUserFeedback.emits, components = GenPagesUserFeedbackUserFeedback.components, styles = GenPagesUserFeedbackUserFeedback.styles);
}
, fun(instance): GenPagesUserFeedbackUserFeedback {
    return GenPagesUserFeedbackUserFeedback(instance);
}
);
val GenPagesAboutAboutClass = CreateVueComponent(GenPagesAboutAbout::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesAboutAbout.inheritAttrs, inject = GenPagesAboutAbout.inject, props = GenPagesAboutAbout.props, propsNeedCastKeys = GenPagesAboutAbout.propsNeedCastKeys, emits = GenPagesAboutAbout.emits, components = GenPagesAboutAbout.components, styles = GenPagesAboutAbout.styles);
}
, fun(instance): GenPagesAboutAbout {
    return GenPagesAboutAbout(instance);
}
);
open class SwiperTabsItem (
    @JsonNotNull
    open var x: Number,
    @JsonNotNull
    open var w: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return SwiperTabsItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class SwiperTabsItemReactiveObject : SwiperTabsItem, IUTSReactive<SwiperTabsItem> {
    override var __v_raw: SwiperTabsItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: SwiperTabsItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(x = __v_raw.x, w = __v_raw.w) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): SwiperTabsItemReactiveObject {
        return SwiperTabsItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var x: Number
        get() {
            return trackReactiveGet(__v_raw, "x", __v_raw.x, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("x")) {
                return;
            }
            val oldValue = __v_raw.x;
            __v_raw.x = value;
            triggerReactiveSet(__v_raw, "x", oldValue, value);
        }
    override var w: Number
        get() {
            return trackReactiveGet(__v_raw, "w", __v_raw.w, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("w")) {
                return;
            }
            val oldValue = __v_raw.w;
            __v_raw.w = value;
            triggerReactiveSet(__v_raw, "w", oldValue, value);
        }
}
fun lerpNumber1(value1: Number, value2: Number, amount: Number): Number {
    return (value1 + (value2 - value1) * amount);
}
val GenComponentsTabsSwiperHeadTabsSwiperClass = CreateVueComponent(GenComponentsTabsSwiperHeadTabsSwiper::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsTabsSwiperHeadTabsSwiper.inheritAttrs, inject = GenComponentsTabsSwiperHeadTabsSwiper.inject, props = GenComponentsTabsSwiperHeadTabsSwiper.props, propsNeedCastKeys = GenComponentsTabsSwiperHeadTabsSwiper.propsNeedCastKeys, emits = GenComponentsTabsSwiperHeadTabsSwiper.emits, components = GenComponentsTabsSwiperHeadTabsSwiper.components, styles = GenComponentsTabsSwiperHeadTabsSwiper.styles);
}
, fun(instance): GenComponentsTabsSwiperHeadTabsSwiper {
    return GenComponentsTabsSwiperHeadTabsSwiper(instance);
}
);
val GenComponentsPopupPopupClass = CreateVueComponent(GenComponentsPopupPopup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsPopupPopup.name, inheritAttrs = GenComponentsPopupPopup.inheritAttrs, inject = GenComponentsPopupPopup.inject, props = GenComponentsPopupPopup.props, propsNeedCastKeys = GenComponentsPopupPopup.propsNeedCastKeys, emits = GenComponentsPopupPopup.emits, components = GenComponentsPopupPopup.components, styles = GenComponentsPopupPopup.styles);
}
, fun(instance): GenComponentsPopupPopup {
    return GenComponentsPopupPopup(instance);
}
);
open class ReasonOption (
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var list: UTSArray<String>,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ReasonOptionReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class ReasonOptionReactiveObject : ReasonOption, IUTSReactive<ReasonOption> {
    override var __v_raw: ReasonOption;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: ReasonOption, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(title = __v_raw.title, list = __v_raw.list) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ReasonOptionReactiveObject {
        return ReasonOptionReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var title: String
        get() {
            return trackReactiveGet(__v_raw, "title", __v_raw.title, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("title")) {
                return;
            }
            val oldValue = __v_raw.title;
            __v_raw.title = value;
            triggerReactiveSet(__v_raw, "title", oldValue, value);
        }
    override var list: UTSArray<String>
        get() {
            return trackReactiveGet(__v_raw, "list", __v_raw.list, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("list")) {
                return;
            }
            val oldValue = __v_raw.list;
            __v_raw.list = value;
            triggerReactiveSet(__v_raw, "list", oldValue, value);
        }
}
val GenPagesUserSpaceUserSpaceClass = CreateVueComponent(GenPagesUserSpaceUserSpace::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserSpaceUserSpace.inheritAttrs, inject = GenPagesUserSpaceUserSpace.inject, props = GenPagesUserSpaceUserSpace.props, propsNeedCastKeys = GenPagesUserSpaceUserSpace.propsNeedCastKeys, emits = GenPagesUserSpaceUserSpace.emits, components = GenPagesUserSpaceUserSpace.components, styles = GenPagesUserSpaceUserSpace.styles);
}
, fun(instance): GenPagesUserSpaceUserSpace {
    return GenPagesUserSpaceUserSpace(instance);
}
);
val GenPagesUserFollowListUserFollowListClass = CreateVueComponent(GenPagesUserFollowListUserFollowList::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserFollowListUserFollowList.inheritAttrs, inject = GenPagesUserFollowListUserFollowList.inject, props = GenPagesUserFollowListUserFollowList.props, propsNeedCastKeys = GenPagesUserFollowListUserFollowList.propsNeedCastKeys, emits = GenPagesUserFollowListUserFollowList.emits, components = GenPagesUserFollowListUserFollowList.components, styles = GenPagesUserFollowListUserFollowList.styles);
}
, fun(instance): GenPagesUserFollowListUserFollowList {
    return GenPagesUserFollowListUserFollowList(instance);
}
);
val GenPagesUserFansListUserFansListClass = CreateVueComponent(GenPagesUserFansListUserFansList::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserFansListUserFansList.inheritAttrs, inject = GenPagesUserFansListUserFansList.inject, props = GenPagesUserFansListUserFansList.props, propsNeedCastKeys = GenPagesUserFansListUserFansList.propsNeedCastKeys, emits = GenPagesUserFansListUserFansList.emits, components = GenPagesUserFansListUserFansList.components, styles = GenPagesUserFansListUserFansList.styles);
}
, fun(instance): GenPagesUserFansListUserFansList {
    return GenPagesUserFansListUserFansList(instance);
}
);
val GenPagesMyCollectionMyCollectionClass = CreateVueComponent(GenPagesMyCollectionMyCollection::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesMyCollectionMyCollection.inheritAttrs, inject = GenPagesMyCollectionMyCollection.inject, props = GenPagesMyCollectionMyCollection.props, propsNeedCastKeys = GenPagesMyCollectionMyCollection.propsNeedCastKeys, emits = GenPagesMyCollectionMyCollection.emits, components = GenPagesMyCollectionMyCollection.components, styles = GenPagesMyCollectionMyCollection.styles);
}
, fun(instance): GenPagesMyCollectionMyCollection {
    return GenPagesMyCollectionMyCollection(instance);
}
);
val GenPagesUserHistoryUserHistoryClass = CreateVueComponent(GenPagesUserHistoryUserHistory::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserHistoryUserHistory.inheritAttrs, inject = GenPagesUserHistoryUserHistory.inject, props = GenPagesUserHistoryUserHistory.props, propsNeedCastKeys = GenPagesUserHistoryUserHistory.propsNeedCastKeys, emits = GenPagesUserHistoryUserHistory.emits, components = GenPagesUserHistoryUserHistory.components, styles = GenPagesUserHistoryUserHistory.styles);
}
, fun(instance): GenPagesUserHistoryUserHistory {
    return GenPagesUserHistoryUserHistory(instance);
}
);
val GenPagesUserBlacklistUserBlacklistClass = CreateVueComponent(GenPagesUserBlacklistUserBlacklist::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserBlacklistUserBlacklist.inheritAttrs, inject = GenPagesUserBlacklistUserBlacklist.inject, props = GenPagesUserBlacklistUserBlacklist.props, propsNeedCastKeys = GenPagesUserBlacklistUserBlacklist.propsNeedCastKeys, emits = GenPagesUserBlacklistUserBlacklist.emits, components = GenPagesUserBlacklistUserBlacklist.components, styles = GenPagesUserBlacklistUserBlacklist.styles);
}
, fun(instance): GenPagesUserBlacklistUserBlacklist {
    return GenPagesUserBlacklistUserBlacklist(instance);
}
);
val GenPagesUserResetPasswordUserResetPasswordClass = CreateVueComponent(GenPagesUserResetPasswordUserResetPassword::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserResetPasswordUserResetPassword.inheritAttrs, inject = GenPagesUserResetPasswordUserResetPassword.inject, props = GenPagesUserResetPasswordUserResetPassword.props, propsNeedCastKeys = GenPagesUserResetPasswordUserResetPassword.propsNeedCastKeys, emits = GenPagesUserResetPasswordUserResetPassword.emits, components = GenPagesUserResetPasswordUserResetPassword.components, styles = GenPagesUserResetPasswordUserResetPassword.styles);
}
, fun(instance): GenPagesUserResetPasswordUserResetPassword {
    return GenPagesUserResetPasswordUserResetPassword(instance);
}
);
val GenPagesUserBindphoneUserBindphoneClass = CreateVueComponent(GenPagesUserBindphoneUserBindphone::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserBindphoneUserBindphone.inheritAttrs, inject = GenPagesUserBindphoneUserBindphone.inject, props = GenPagesUserBindphoneUserBindphone.props, propsNeedCastKeys = GenPagesUserBindphoneUserBindphone.propsNeedCastKeys, emits = GenPagesUserBindphoneUserBindphone.emits, components = GenPagesUserBindphoneUserBindphone.components, styles = GenPagesUserBindphoneUserBindphone.styles);
}
, fun(instance): GenPagesUserBindphoneUserBindphone {
    return GenPagesUserBindphoneUserBindphone(instance);
}
);
val GenPagesUserForgetPasswordUserForgetPasswordClass = CreateVueComponent(GenPagesUserForgetPasswordUserForgetPassword::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserForgetPasswordUserForgetPassword.inheritAttrs, inject = GenPagesUserForgetPasswordUserForgetPassword.inject, props = GenPagesUserForgetPasswordUserForgetPassword.props, propsNeedCastKeys = GenPagesUserForgetPasswordUserForgetPassword.propsNeedCastKeys, emits = GenPagesUserForgetPasswordUserForgetPassword.emits, components = GenPagesUserForgetPasswordUserForgetPassword.components, styles = GenPagesUserForgetPasswordUserForgetPassword.styles);
}
, fun(instance): GenPagesUserForgetPasswordUserForgetPassword {
    return GenPagesUserForgetPasswordUserForgetPassword(instance);
}
);
val GenPagesSearchSearchClass = CreateVueComponent(GenPagesSearchSearch::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesSearchSearch.inheritAttrs, inject = GenPagesSearchSearch.inject, props = GenPagesSearchSearch.props, propsNeedCastKeys = GenPagesSearchSearch.propsNeedCastKeys, emits = GenPagesSearchSearch.emits, components = GenPagesSearchSearch.components, styles = GenPagesSearchSearch.styles);
}
, fun(instance): GenPagesSearchSearch {
    return GenPagesSearchSearch(instance);
}
);
val GenPagesSearchResultSearchResultClass = CreateVueComponent(GenPagesSearchResultSearchResult::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesSearchResultSearchResult.inheritAttrs, inject = GenPagesSearchResultSearchResult.inject, props = GenPagesSearchResultSearchResult.props, propsNeedCastKeys = GenPagesSearchResultSearchResult.propsNeedCastKeys, emits = GenPagesSearchResultSearchResult.emits, components = GenPagesSearchResultSearchResult.components, styles = GenPagesSearchResultSearchResult.styles);
}
, fun(instance): GenPagesSearchResultSearchResult {
    return GenPagesSearchResultSearchResult(instance);
}
);
fun share(text: String, title: String = "分享到") {
    val context = UTSAndroid.getUniActivity()!!;
    val intent = Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
    intent.putExtra(Intent.EXTRA_TEXT, text);
    context.startActivity(Intent.createChooser(intent, title));
}
val GenComponentsCommentCommentClass = CreateVueComponent(GenComponentsCommentComment::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsCommentComment.name, inheritAttrs = GenComponentsCommentComment.inheritAttrs, inject = GenComponentsCommentComment.inject, props = GenComponentsCommentComment.props, propsNeedCastKeys = GenComponentsCommentComment.propsNeedCastKeys, emits = GenComponentsCommentComment.emits, components = GenComponentsCommentComment.components, styles = GenComponentsCommentComment.styles);
}
, fun(instance): GenComponentsCommentComment {
    return GenComponentsCommentComment(instance);
}
);
val GenComponentsCommentPopupCommentPopupClass = CreateVueComponent(GenComponentsCommentPopupCommentPopup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsCommentPopupCommentPopup.name, inheritAttrs = GenComponentsCommentPopupCommentPopup.inheritAttrs, inject = GenComponentsCommentPopupCommentPopup.inject, props = GenComponentsCommentPopupCommentPopup.props, propsNeedCastKeys = GenComponentsCommentPopupCommentPopup.propsNeedCastKeys, emits = GenComponentsCommentPopupCommentPopup.emits, components = GenComponentsCommentPopupCommentPopup.components, styles = GenComponentsCommentPopupCommentPopup.styles);
}
, fun(instance): GenComponentsCommentPopupCommentPopup {
    return GenComponentsCommentPopupCommentPopup(instance);
}
);
val GenPagesDetailDetailClass = CreateVueComponent(GenPagesDetailDetail::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesDetailDetail.inheritAttrs, inject = GenPagesDetailDetail.inject, props = GenPagesDetailDetail.props, propsNeedCastKeys = GenPagesDetailDetail.propsNeedCastKeys, emits = GenPagesDetailDetail.emits, components = GenPagesDetailDetail.components, styles = GenPagesDetailDetail.styles);
}
, fun(instance): GenPagesDetailDetail {
    return GenPagesDetailDetail(instance);
}
);
val GenPagesCommentDetailCommentDetailClass = CreateVueComponent(GenPagesCommentDetailCommentDetail::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommentDetailCommentDetail.inheritAttrs, inject = GenPagesCommentDetailCommentDetail.inject, props = GenPagesCommentDetailCommentDetail.props, propsNeedCastKeys = GenPagesCommentDetailCommentDetail.propsNeedCastKeys, emits = GenPagesCommentDetailCommentDetail.emits, components = GenPagesCommentDetailCommentDetail.components, styles = GenPagesCommentDetailCommentDetail.styles);
}
, fun(instance): GenPagesCommentDetailCommentDetail {
    return GenPagesCommentDetailCommentDetail(instance);
}
);
open class ImageItem (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var src: String,
    @JsonNotNull
    open var progress: Number,
    @JsonNotNull
    open var err: String,
    open var task: UploadTask? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ImageItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class ImageItemReactiveObject : ImageItem, IUTSReactive<ImageItem> {
    override var __v_raw: ImageItem;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: ImageItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, src = __v_raw.src, progress = __v_raw.progress, err = __v_raw.err, task = __v_raw.task) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ImageItemReactiveObject {
        return ImageItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var id: String
        get() {
            return trackReactiveGet(__v_raw, "id", __v_raw.id, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("id")) {
                return;
            }
            val oldValue = __v_raw.id;
            __v_raw.id = value;
            triggerReactiveSet(__v_raw, "id", oldValue, value);
        }
    override var src: String
        get() {
            return trackReactiveGet(__v_raw, "src", __v_raw.src, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("src")) {
                return;
            }
            val oldValue = __v_raw.src;
            __v_raw.src = value;
            triggerReactiveSet(__v_raw, "src", oldValue, value);
        }
    override var progress: Number
        get() {
            return trackReactiveGet(__v_raw, "progress", __v_raw.progress, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("progress")) {
                return;
            }
            val oldValue = __v_raw.progress;
            __v_raw.progress = value;
            triggerReactiveSet(__v_raw, "progress", oldValue, value);
        }
    override var err: String
        get() {
            return trackReactiveGet(__v_raw, "err", __v_raw.err, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("err")) {
                return;
            }
            val oldValue = __v_raw.err;
            __v_raw.err = value;
            triggerReactiveSet(__v_raw, "err", oldValue, value);
        }
    override var task: UploadTask?
        get() {
            return trackReactiveGet(__v_raw, "task", __v_raw.task, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("task")) {
                return;
            }
            val oldValue = __v_raw.task;
            __v_raw.task = value;
            triggerReactiveSet(__v_raw, "task", oldValue, value);
        }
}
val GenComponentsUploadImagesUploadImagesClass = CreateVueComponent(GenComponentsUploadImagesUploadImages::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsUploadImagesUploadImages.name, inheritAttrs = GenComponentsUploadImagesUploadImages.inheritAttrs, inject = GenComponentsUploadImagesUploadImages.inject, props = GenComponentsUploadImagesUploadImages.props, propsNeedCastKeys = GenComponentsUploadImagesUploadImages.propsNeedCastKeys, emits = GenComponentsUploadImagesUploadImages.emits, components = GenComponentsUploadImagesUploadImages.components, styles = GenComponentsUploadImagesUploadImages.styles);
}
, fun(instance): GenComponentsUploadImagesUploadImages {
    return GenComponentsUploadImagesUploadImages(instance);
}
);
val GenPagesAddPostAddPostClass = CreateVueComponent(GenPagesAddPostAddPost::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesAddPostAddPost.inheritAttrs, inject = GenPagesAddPostAddPost.inject, props = GenPagesAddPostAddPost.props, propsNeedCastKeys = GenPagesAddPostAddPost.propsNeedCastKeys, emits = GenPagesAddPostAddPost.emits, components = GenPagesAddPostAddPost.components, styles = GenPagesAddPostAddPost.styles);
}
, fun(instance): GenPagesAddPostAddPost {
    return GenPagesAddPostAddPost(instance);
}
);
val GenPagesChooseTopicChooseTopicClass = CreateVueComponent(GenPagesChooseTopicChooseTopic::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesChooseTopicChooseTopic.inheritAttrs, inject = GenPagesChooseTopicChooseTopic.inject, props = GenPagesChooseTopicChooseTopic.props, propsNeedCastKeys = GenPagesChooseTopicChooseTopic.propsNeedCastKeys, emits = GenPagesChooseTopicChooseTopic.emits, components = GenPagesChooseTopicChooseTopic.components, styles = GenPagesChooseTopicChooseTopic.styles);
}
, fun(instance): GenPagesChooseTopicChooseTopic {
    return GenPagesChooseTopicChooseTopic(instance);
}
);
val GenPagesUserFeedbackFormUserFeedbackFormClass = CreateVueComponent(GenPagesUserFeedbackFormUserFeedbackForm::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserFeedbackFormUserFeedbackForm.inheritAttrs, inject = GenPagesUserFeedbackFormUserFeedbackForm.inject, props = GenPagesUserFeedbackFormUserFeedbackForm.props, propsNeedCastKeys = GenPagesUserFeedbackFormUserFeedbackForm.propsNeedCastKeys, emits = GenPagesUserFeedbackFormUserFeedbackForm.emits, components = GenPagesUserFeedbackFormUserFeedbackForm.components, styles = GenPagesUserFeedbackFormUserFeedbackForm.styles);
}
, fun(instance): GenPagesUserFeedbackFormUserFeedbackForm {
    return GenPagesUserFeedbackFormUserFeedbackForm(instance);
}
);
val GenComponentsChatItemChatItemClass = CreateVueComponent(GenComponentsChatItemChatItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsChatItemChatItem.name, inheritAttrs = GenComponentsChatItemChatItem.inheritAttrs, inject = GenComponentsChatItemChatItem.inject, props = GenComponentsChatItemChatItem.props, propsNeedCastKeys = GenComponentsChatItemChatItem.propsNeedCastKeys, emits = GenComponentsChatItemChatItem.emits, components = GenComponentsChatItemChatItem.components, styles = GenComponentsChatItemChatItem.styles);
}
, fun(instance): GenComponentsChatItemChatItem {
    return GenComponentsChatItemChatItem(instance);
}
);
val GenPagesChatChatClass = CreateVueComponent(GenPagesChatChat::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesChatChat.inheritAttrs, inject = GenPagesChatChat.inject, props = GenPagesChatChat.props, propsNeedCastKeys = GenPagesChatChat.propsNeedCastKeys, emits = GenPagesChatChat.emits, components = GenPagesChatChat.components, styles = GenPagesChatChat.styles);
}
, fun(instance): GenPagesChatChat {
    return GenPagesChatChat(instance);
}
);
fun createApp(): UTSJSONObject {
    val app = createSSRApp(GenAppClass);
    return object : UTSJSONObject() {
        var app = app
    };
}
fun main(app: IApp) {
    definePageRoutes();
    defineAppConfig();
    (createApp()["app"] as VueApp).mount(app);
}
open class UniAppConfig : AppConfig {
    override var name: String = "uniappx社区交友";
    override var appid: String = "__UNI__C512840";
    override var versionName: String = "1.0.0";
    override var versionCode: String = "1";
    override var uniCompilerVersion: String = "4.24";
    constructor(){}
}
fun definePageRoutes() {
    __uniRoutes.push(PageRoute(path = "pages/index/index", component = GenPagesIndexIndexClass, meta = PageMeta(isQuit = true), style = utsMapOf("navigationBarTitleText" to "首页", "navigationStyle" to "custom", "enablePullDownRefresh" to true)));
    __uniRoutes.push(PageRoute(path = "pages/topic/topic", component = GenPagesTopicTopicClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "话题分类页", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/msg/msg", component = GenPagesMsgMsgClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "消息列表", "enablePullDownRefresh" to true)));
    __uniRoutes.push(PageRoute(path = "pages/my/my", component = GenPagesMyMyClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "个人中心", "enablePullDownRefresh" to false, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/topic-detail/topic-detail", component = GenPagesTopicDetailTopicDetailClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to true, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/webview/webview", component = GenPagesWebviewWebviewClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/user-login/user-login", component = GenPagesUserLoginUserLoginClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/user-login-password/user-login-password", component = GenPagesUserLoginPasswordUserLoginPasswordClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/user-getcode/user-getcode", component = GenPagesUserGetcodeUserGetcodeClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/user-setting/user-setting", component = GenPagesUserSettingUserSettingClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "设置", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/user-safe/user-safe", component = GenPagesUserSafeUserSafeClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "账号与安全", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/user-editinfo/user-editinfo", component = GenPagesUserEditinfoUserEditinfoClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/user-feedback/user-feedback", component = GenPagesUserFeedbackUserFeedbackClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "我的反馈", "enablePullDownRefresh" to true)));
    __uniRoutes.push(PageRoute(path = "pages/about/about", component = GenPagesAboutAboutClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "关于社区", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/user-space/user-space", component = GenPagesUserSpaceUserSpaceClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to true, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/user-follow-list/user-follow-list", component = GenPagesUserFollowListUserFollowListClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "关注列表", "enablePullDownRefresh" to true)));
    __uniRoutes.push(PageRoute(path = "pages/user-fans-list/user-fans-list", component = GenPagesUserFansListUserFansListClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "粉丝列表", "enablePullDownRefresh" to true)));
    __uniRoutes.push(PageRoute(path = "pages/my-collection/my-collection", component = GenPagesMyCollectionMyCollectionClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "我的收藏", "enablePullDownRefresh" to true)));
    __uniRoutes.push(PageRoute(path = "pages/user-history/user-history", component = GenPagesUserHistoryUserHistoryClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "历史记录", "enablePullDownRefresh" to true)));
    __uniRoutes.push(PageRoute(path = "pages/user-blacklist/user-blacklist", component = GenPagesUserBlacklistUserBlacklistClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "黑名单", "enablePullDownRefresh" to true)));
    __uniRoutes.push(PageRoute(path = "pages/user-reset-password/user-reset-password", component = GenPagesUserResetPasswordUserResetPasswordClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/user-bindphone/user-bindphone", component = GenPagesUserBindphoneUserBindphoneClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/user-forget-password/user-forget-password", component = GenPagesUserForgetPasswordUserForgetPasswordClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/search/search", component = GenPagesSearchSearchClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/search-result/search-result", component = GenPagesSearchResultSearchResultClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false, "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/detail/detail", component = GenPagesDetailDetailClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/comment-detail/comment-detail", component = GenPagesCommentDetailCommentDetailClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "评论详情页")));
    __uniRoutes.push(PageRoute(path = "pages/add-post/add-post", component = GenPagesAddPostAddPostClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/choose-topic/choose-topic", component = GenPagesChooseTopicChooseTopicClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "选择话题")));
    __uniRoutes.push(PageRoute(path = "pages/user-feedback-form/user-feedback-form", component = GenPagesUserFeedbackFormUserFeedbackFormClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/chat/chat", component = GenPagesChatChatClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "")));
}
val __uniTabBar: Map<String, Any?>? = utsMapOf("color" to "#323232", "selectedColor" to "#f85c81", "borderStyle" to "black", "backgroundColor" to "#FFFFFF", "list" to utsArrayOf(
    utsMapOf("iconPath" to "static/tabbar/index.png", "selectedIconPath" to "static/tabbar/indexed.png", "pagePath" to "pages/index/index", "text" to "首页"),
    utsMapOf("iconPath" to "static/tabbar/news.png", "selectedIconPath" to "static/tabbar/newsed.png", "pagePath" to "pages/topic/topic", "text" to "话题"),
    utsMapOf("iconPath" to "static/tabbar/paper.png", "selectedIconPath" to "static/tabbar/papered.png", "pagePath" to "pages/msg/msg", "text" to "消息"),
    utsMapOf("iconPath" to "static/tabbar/home.png", "selectedIconPath" to "static/tabbar/homeed.png", "pagePath" to "pages/my/my", "text" to "我的")
));
val __uniLaunchPage: Map<String, Any?> = utsMapOf("url" to "pages/index/index", "style" to utsMapOf("navigationBarTitleText" to "首页", "navigationStyle" to "custom", "enablePullDownRefresh" to true));
fun defineAppConfig() {
    __uniConfig.entryPagePath = "/pages/index/index";
    __uniConfig.globalStyle = utsMapOf("navigationBarTextStyle" to "black", "navigationBarTitleText" to "社区交友", "navigationBarBackgroundColor" to "#FFFFFF", "backgroundColor" to "#FFFFFF");
    __uniConfig.tabBar = __uniTabBar as Map<String, Any>?;
    __uniConfig.conditionUrl = "";
    __uniConfig.uniIdRouter = utsMapOf();
    __uniConfig.ready = true;
}
fun getApp(): GenApp {
    return getBaseApp() as GenApp;
}
