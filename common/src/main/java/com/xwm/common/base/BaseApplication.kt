package com.xwm.common.base

import android.app.Application
import android.content.ComponentCallbacks2
import android.content.Context
import android.util.Log
import android.view.textclassifier.TextClassifier
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.xwm.common.BuildConfig

/**
 * 初始化公共逻辑
 * Created by xwm on 2019-06-06
 */
open class BaseApplication : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        initARouter()
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            //打印日志
            ARouter.openLog()
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    /**
     * 程序终止的时候执行
     */
    override fun onTerminate() {
        Log.d("Application", "onTerminate")
        super.onTerminate()
        //清理ARouter注册表
        ARouter.getInstance().destroy()
    }


    /**
     * 低内存的时候执行
     */
    override fun onLowMemory() {
        Log.d("Application", "onLowMemory")
        super.onLowMemory()
        Glide.get(this).clearMemory()
    }


    /**
     * HOME键退出应用程序
     * 程序在内存清理的时候执行
     */
    override fun onTrimMemory(level: Int) {
        Log.d("Application", "onTrimMemory")
        super.onTrimMemory(level)
        if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory()
        }
        Glide.get(this).trimMemory(level)
    }

}