package com.xwm.androidcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.xwm.common.arounter.ARouterPath
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener {
            ARouter.getInstance().build(ARouterPath.ACTIVITY_MODULE1).navigation()
        }

        btn2.setOnClickListener {
            ARouter.getInstance().build(ARouterPath.ACTIVITY_MODULE2).navigation()
        }
    }
}
