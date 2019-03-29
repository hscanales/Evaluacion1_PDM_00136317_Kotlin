package tech.visuallatam.fakejava2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import tech.visuallatam.fakejava2.Model.Factura


class MainActivity : AppCompatActivity() {
        var lista : ArrayList<LinearLayout>? = null
        var lista2: ArrayList<TextView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loader()




    }

    private fun loader() {
        lista =  ArrayList<LinearLayout>().apply {
            add(p1)
            add(p2)
            add(p3)
            add(p4)
            add(p5)
            add(p6)
            add(p7)
            add(p8)
            add(p9)
        }

        lista2 = ArrayList<TextView>().apply{
            add(cp1)
            add(cp2)
            add(cp3)
            add(cp4)
            add(cp5)
            add(cp6)
            add(cp7)
            add(cp8)
            add(cp9)
        }
        for (i in lista!!.indices){
            lel(lista!![i],lista2!![i])
        }


        sndnds.setOnClickListener { v->
                var total = cp1.text.toString().toInt() + cp2.text.toString().toInt()+cp3.text.toString().toInt()+cp4.text.toString().toInt()+cp5.text.toString().toInt()+cp6.text.toString().toInt()+cp7.text.toString().toInt()+cp8.text.toString().toInt()+cp9.text.toString().toInt()
                var factura = Factura(cp1.text.toString(),cp2.text.toString(),cp3.text.toString(),cp4.text.toString(),cp5.text.toString(),cp6.text.toString(),cp7.text.toString(),cp8.text.toString(),cp9.text.toString(),user.text.toString(),correo.text.toString(),total)
                val intent : Intent= Intent(this@MainActivity,second::class.java)
                intent.putExtra("factura", Gson().toJson(factura))
                startActivity(intent)

        }
    }

    fun lel( captura : LinearLayout, contador : TextView){
        captura.setOnClickListener{ v->
            var value = contador.text.toString().toInt()
            value++
            contador.setText(value.toString())
        }
    }
}
