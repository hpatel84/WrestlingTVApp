package com.example.myapplication

import android.R.attr
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import org.jsoup.Jsoup
import android.graphics.BitmapFactory

import android.R.attr.bitmap
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.InputStream
import java.net.URL
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


/**
 * Loads [MainFragment].
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }

        CoroutineScope(IO).launch {
            getWebsite()
        }
    }
}

 fun getWebsite(): String {

    val url = "http://www.allwrestling.live/"
//Connect to website
//Connect to website
    val document: Document = Jsoup.connect(url).get()

//Get the logo source of the website

//Get the logo source of the website
    val img: Element? = document.select("img").first()
// Locate the src attribute
// Locate the src attribute
    val imgSrc: String? = img?.absUrl("src")
// Download image from URL
// Download image from URL
    val input: InputStream = URL(imgSrc).openStream()
// Decode Bitmap
// Decode Bitmap
    //  bitmap = BitmapFactory.decodeStream(input)

//Get the title of the website

//Get the title of the website
    val title = document.title()
    print(title)
     return title

}