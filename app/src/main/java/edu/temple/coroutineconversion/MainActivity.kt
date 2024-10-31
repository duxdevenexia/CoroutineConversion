package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : AppCompatActivity() {

    //TODO (Refactor to replace Thread code with coroutines)

    private val cakeImageView: ImageView by lazy {
        findViewById(R.id.imageView)
    }

    private val currentTextView: TextView by lazy {
        findViewById(R.id.currentTextView)
    }

    // Use a coroutine scope
    private val coroutineScope = MainScope() // This will handle lifecycle


    /*
    val handler = Handler(Looper.getMainLooper(), Handler.Callback {

        currentTextView.text = String.format(Locale.getDefault(), "Current opacity: %d", it.what)
        cakeImageView.alpha = it.what / 100f
        true
    })



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.revealButton).setOnClickListener{
            Thread{
                repeat(100) {
                    handler.sendEmptyMessage(it)
                    Thread.sleep(40)
                }
            }.start()
        }
    }

    */


   // /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // after click teh button
        findViewById<Button>(R.id.revealButton).setOnClickListener {
            launchOpacityAnimation()    // call launchOpacityAnimation()
        }
    }


    private fun launchOpacityAnimation() {
        // create a new coroutine
        coroutineScope.launch {
            // by repeat
            repeat(100) { i ->
                // changing of the textView and ImageView
                currentTextView.text = String.format(Locale.getDefault(), "Current opacity: %d", i)
                cakeImageView.alpha = i / 100f
                delay(40) // Coroutine delay instead of Thread.sleep
            }
        }
    }

    // fun for canceling the coroutineScope
    override fun onDestroy() {
        super.onDestroy()
        // Cancel the coroutine scope to prevent memory leaks
        coroutineScope.cancel()
    }

    // */
}