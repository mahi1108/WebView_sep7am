package cubex.mahesh.webview_sep7am

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                    when(p0!!.id){
                        R.id.srch-> wview.loadUrl(et1.text.toString())
                        R.id.fb->wview.loadUrl("http://www.facebook.com")
                        R.id.google->wview.loadUrl("http://www.google.com")
                        R.id.you->wview.loadUrl("http://www.youtube.com")
                        R.id.html->    wview.loadUrl("")
                    }
            }
        }
        srch.setOnClickListener(listener)
        fb.setOnClickListener(listener)
        google.setOnClickListener(listener)
        you.setOnClickListener(listener)
        html.setOnClickListener(listener)
        var pDialog = ProgressDialog(this@MainActivity)
        pDialog.setMessage("Please wait page is loading....")
        wview.webViewClient = object:WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                pDialog.show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                pDialog.dismiss()
            }
        }
        wview.settings.javaScriptEnabled = true
        wview.settings.builtInZoomControls = true

    } //onCreate
}
