package com.example.samplehandlerlooper

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
   // val ht = MyWorkerThread()
    //val ht = ExampleWorkerThread()
    val ht = ExampleLooperHandler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val handler = object :Handler(Looper.getMainLooper()) {
           override fun handleMessage(msg: Message) {
               super.handleMessage(msg)
               Toast.makeText(this@MainActivity, msg.obj.toString(),Toast.LENGTH_SHORT).show()
           }
       }
        findViewById<Button>(R.id.btnStartThread).also {
               it.setOnClickListener {
                   ht.start()
                  /* ht.addTask{
                       Thread.sleep(1000)
                       Log.i("sasa",  "${Thread.currentThread()}")
                       val message = Message.obtain()
                       message.obj = "My name is sasa"
                       handler.handleMessage(message)
                   }*/
               }
           }




        findViewById<Button>(R.id.btnStopThread).also {
            it.setOnClickListener {

            }
        }
        findViewById<Button>(R.id.btnAddMessage).also {
            it.setOnClickListener {
             val message = Message.obtain()
                message.what = TASK1
                message.obj = "Hi I am sandeep"
                message.target = ht.handler
                message.sendToTarget()
            }
        }
        findViewById<Button>(R.id.btnAddRunnable).also {
            it.setOnClickListener {
             ht.handler?.post {
                 for (item in 0..5) {
                     SystemClock.sleep(1000)
                     Log.d(TAG, "inside runnable")
                 }
              }
            }
        }
    }





}