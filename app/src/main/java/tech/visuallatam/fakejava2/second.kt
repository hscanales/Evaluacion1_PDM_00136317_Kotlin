package tech.visuallatam.fakejava2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_second.*
import tech.visuallatam.fakejava2.Model.Factura




class second : AppCompatActivity() {
    var json : String = ""
    lateinit var factura: Factura


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var extras : Bundle  = intent.extras
        if(extras != null){
            json = extras.getString("factura")
        }
        factura = Gson().fromJson(json,Factura::class.java)

        loader()
    }

    private fun loader() {
        userf.text=factura.username
        emailf.text=factura.email
        p1f.text=factura.c1
        p2f.text=factura.c2
        p3f.text=factura.c3
        p4f.text=factura.c4
        p5f.text=factura.c5
        p6f.text=factura.c6
        p7f.text=factura.c7
        p8f.text=factura.c8
        p9f.text=factura.c9
        total.text = factura.total.toString()

        share.setOnClickListener { v->
            val snd = Intent()
            snd.action = Intent.ACTION_SEND
            snd.putExtra(Intent.EXTRA_TEXT, Gson().toJson(factura))
            snd.type = "text/plain"
            startActivity(Intent.createChooser(snd, "appname"))
        }
    }


}
