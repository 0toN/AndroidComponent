package com.xwm.module1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.xwm.common.arounter.ARouterPath

@Route(path = ARouterPath.ACTIVITY_MODULE1)
class Module1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module1_activity_main)
    }
}
