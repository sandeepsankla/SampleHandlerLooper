package com.example.samplehandlerlooper

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log


const val TASK1 = 1
 const val TASK2 = 2
class ExampleHandler(val myLooper :Looper) : Handler(myLooper) {
     val TAG = "ExampleHandler"
    override fun handleMessage(msg: Message) {
         when(msg.what){
             TASK1->{
              Log.d(TAG, "task 1 running")
             }
             TASK2->{
                 Log.d(TAG, "task 2 running")
             }
             else ->{
                 Log.d(TAG, "task  running")

             }
         }
    }
}