package com.example.samplehandlerlooper

import android.os.Handler
import android.os.Looper
import android.util.Log


class ExampleLooperHandler() :Thread() {

    /**
    * Normal Thread will become Handler thread after attaching handler & looper looper.loop
     * will loop the queue in infinite time, coz of that line 22 will not be executed.
    * */
    val TAG = "ExampleLooperHandler"
    var handler : ExampleHandler? = null
    override fun run() {
        Looper.prepare()
        Log.d(TAG, "run start")
        //handler = android.os.Handler(Looper.myLooper()!!)
        handler = ExampleHandler(Looper.myLooper()!!)
        Looper.loop()
        Log.d(TAG, "End of run()")

    }
}