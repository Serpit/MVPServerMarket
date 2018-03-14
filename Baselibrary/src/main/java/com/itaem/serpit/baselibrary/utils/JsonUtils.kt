package com.itaem.serpit.baselibrary.utils




import com.google.gson.Gson

/**
 * Created by Administrator on 2018/2/9 0009.
 */
class JsonUtils {

    companion object {
        val gson = Gson()
        fun <T> convertToJson(dataClass:T):String {
            return gson.toJson(dataClass)
        }
    }

}