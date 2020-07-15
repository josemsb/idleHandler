package com.appgrouplab.code.kotlin.idlehandler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appgrouplab.code.kotlin.idlehandler.idlehandler.IdleHandler
import com.appgrouplab.code.kotlin.idlehandler.idlehandler.IdleHandlerConfiguration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val idleCallbackConfigurationBuilder =
            IdleHandlerConfiguration.IdleCallbackConfigurationBuilder()
                .activity(this@MainActivity)
                .stopTime(10)
                .build()

        IdleHandler.init(idleCallbackConfigurationBuilder)

    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        IdleHandler.reset()
    }

}