package com.xwm.module2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.xwm.common.arounter.ARouterPath

@Route(path = ARouterPath.ACTIVITY_MODULE2)
class Module2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module2_activity_main)
    }
}
