package com.stx.xhb.dmgameapp.utils;

import android.support.annotation.Nullable;
import android.util.Log;

import com.stx.core.utils.GsonUtil;
import com.stx.xhb.dmgameapp.data.body.NewsAboutContent;

import okhttp3.RequestBody;

/**
 * Author: Mr.xiao on 2018/9/6
 *
 * @mail:xhb_199409@163.com
 * @github:https://github.com/xiaohaibin
 * @describe: RequestBody 工具类
 */
public class RequestBodyHelper {

    public static RequestBody creatRequestBody(@Nullable Object src) {
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GsonUtil.newGson().toJson(src));
    }

}
