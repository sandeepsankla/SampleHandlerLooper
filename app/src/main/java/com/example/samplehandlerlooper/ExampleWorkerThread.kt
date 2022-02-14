package com.example.samplehandlerlooper

import android.os.SystemClock
import android.util.Log

class ExampleWorkerThread : Thread() {
    val TAG = "ExampleWorkerThread"

    override fun run() {
       for (i in 0..5){
           Log.i(TAG, "task $i running, thread name - ${currentThread().name}" )
           SystemClock.sleep(1000)
       }

       Log.d(TAG, "task ended")
    }


    /**
    * After task ended, thread will die. we can't assign more task to this thread. In order to reuse the same
    * thread will have to convert this thread to handler thread.
    **/
}