package com.example.samplehandlerlooper

import android.os.Message
import android.util.Log
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.atomic.AtomicBoolean

/**
* Conversion of thread to handler thread, manually adding queue & run the task
* */

class MyWorkerThread : Thread() {
     val TAG = "sasa"
     val isAlive = AtomicBoolean(true)
     val queue = ConcurrentLinkedDeque<Runnable>()

     init {
         start()
     }

     override fun run() {
       while (isAlive.get()) {
           Log.i(TAG, "${this.name} is running")
           queue.poll()?.run()
       }

        Log.i(TAG, "Thread is terminated")
     }

      fun addTask(r :Runnable) :MyWorkerThread{
          queue.add(r)
          return this
      }




      fun quit(){
          isAlive.set(false)
      }

}