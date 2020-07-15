package com.appgrouplab.code.kotlin.idlehandler.idlehandler

import android.app.Activity
import android.os.Handler
import android.util.Log
import android.widget.Toast

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class IdleHandlerConfiguration private constructor(
    private var activity: Activity? = null,
    private var stopTime: Long? = null,
    private var timeoutHandler: Handler? = null,
    private var interactionTimeoutRunnable: Runnable? = null
) {

    data class IdleCallbackConfigurationBuilder(
        var activity: Activity? = null,
        var stopTime: Long = 300,
        var timeoutHandler: Handler? = null,
        var interactionTimeoutRunnable: Runnable? = null
    ) {
        fun activity(activity: Activity) = apply { this.activity = activity }
        fun stopTime(stopTime: Long) = apply { this.stopTime = stopTime }
        fun build() = IdleHandlerConfiguration(
            activity,
            stopTime
        )
    }

    fun start() {
        Log.d("timer", "Init action")
        Log.d("timer", stopTime.toString())
        timeoutHandler = Handler()
        interactionTimeoutRunnable = Runnable {
            Log.d("timer", "Finish action")
            Toast.makeText(activity, "Finish action", Toast.LENGTH_SHORT).show()
        }
        timeoutHandler?.postDelayed(interactionTimeoutRunnable, 1000 * stopTime!!)
    }

    fun reset() {
        Log.d("timer", "Reset action")
        timeoutHandler?.removeCallbacks(interactionTimeoutRunnable)
        timeoutHandler?.postDelayed(interactionTimeoutRunnable, 1000 * stopTime!!)
    }

}