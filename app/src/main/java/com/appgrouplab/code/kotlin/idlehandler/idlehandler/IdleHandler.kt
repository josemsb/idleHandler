package com.appgrouplab.code.kotlin.idlehandler.idlehandler

object IdleHandler {

    private var idleHandlerConfiguration: IdleHandlerConfiguration? = null

    fun init(idleHandlerConfiguration: IdleHandlerConfiguration) {
        this.idleHandlerConfiguration = idleHandlerConfiguration
        this.idleHandlerConfiguration!!.start()
    }

    fun reset() {
        this.idleHandlerConfiguration!!.reset()
    }

}