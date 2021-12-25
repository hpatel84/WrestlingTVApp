package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import org.jsoup.Jsoup

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.InputStream
import java.net.URL
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.jsoup.select.Elements


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

//        CoroutineScope(IO).launch {
//            val document = getWebsite()
//            updateUI(document)
//        }
    }
}

fun getWebsite(): Document {

    val url = "http://www.allwrestling.live/"
//Connect to website
//Connect to website
    val document: Document = Jsoup.connect(url).get()

//    val sections: Elements = document.select(".section-box")
//
//    for (section in sections) {
//        val name: Element? = section.select("span.name").first()
//        val images: Elements? = section.select("span.clip > img")
//        if (images != null) {
//            for (image in images) {
//                println("image: " + image.attr("abs:src"))
//            }
//
//        }
//        if (name != null) {
//            println("Section: " + name.text())
//        }
//    }

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
    // print(title)
    return document
}

fun updateUI(document:Document){
    //println("TEST: $title")

    // Get sections
    val sections: Elements = document.select(".section-box")

    for (section in sections) {
        // Get names of each section
        val name: Element? = section.select("span.name").first()
        if (name != null) {
            println("Section: " + name.text())
        }

        // Get images of each section
        val images: Elements? = section.select("span.clip > img")
        if (images != null) {
            for (image in images) {
                println("image: " + image.attr("abs:src"))
            }
        }

    }
}