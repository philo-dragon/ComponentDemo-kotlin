package com.pfl.common.base

import android.content.Context
import android.support.v7.app.AppCompatActivity

import com.yan.inflaterauto.InflaterAuto

/**
 * Created by rocky on 2018/3/16.
 */

class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(InflaterAuto.wrap(newBase))
    }
}
