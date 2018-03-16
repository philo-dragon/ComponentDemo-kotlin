package com.pfl.common.base

import android.app.Application
import android.content.Context

import com.pfl.common.weidget.InfAutoInflaterConvert
import com.yan.inflaterauto.AutoBaseOn
import com.yan.inflaterauto.InflaterAuto

/**
 * Created by rocky on 2018/3/16.
 */

class BaseApplication : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(InflaterAuto.wrap(base))
    }

    override fun onCreate() {
        super.onCreate()
        initAutoUI()
    }

    /**
     * 以下可以写在任何地方，只要在生成View之前
     */
    protected fun initAutoUI() {
        setAutoUI(720, 1280)
    }

    private fun setAutoUI(w: Int, h: Int) {
        InflaterAuto.init(InflaterAuto.Builder()
                .width(w.toFloat())
                .height(h.toFloat())
                .baseOnDirection(AutoBaseOn.Both)// 宽度根据宽度比例缩放，长度根据长度比例缩放
                // 由 com.yan.inflaterautotest.InflaterConvert 编译生成，自动添加前缀InfAuto
                // 你也可以添加你自己的实现了Convert的类，替换任何一种view成为你想替换的view
                .inflaterConvert(InfAutoInflaterConvert())
                .build()
        )
    }
}
