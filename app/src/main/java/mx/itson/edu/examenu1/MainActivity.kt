package mx.itson.edu.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var gradosC: EditText
    lateinit var gradosF: EditText
    lateinit var gradosK: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gradosC = findViewById(R.id.etC)
        gradosF = findViewById(R.id.etF)
        gradosK = findViewById(R.id.etK)

        val btnConvertirG: Button = findViewById(R.id.btnGC)
        val btnConvertirF: Button = findViewById(R.id.btnGF)
        val btnConvertirK: Button = findViewById(R.id.btnGK)


        btnConvertirF.setOnClickListener {
            try {
                if (gradosC.text.toString().trim().equals("")){
                    val formattedNumber="%.2f".format(convertirKelvinFa(gradosK.text.toString().toDouble()))
                    gradosF.setText(formattedNumber)
                } else if (gradosK.text.toString().trim().equals("")){
                    val formattedNumber="%.2f".format(convertirCelsiusFa(gradosC.text.toString().toDouble()))
                    gradosF.setText(formattedNumber)
                }
            } catch (e: java.lang.Exception){
                println(e)
            }
        }

        btnConvertirG.setOnClickListener {
            try {
                if(gradosF.text.toString().trim().equals("")){
                    val formattedNumber="%.2f".format(convertirKelvinC(gradosK.text.toString().toDouble()))
                    //gradosC.setText(convertirKelvinC(gradosK.text.toString().toDouble()).toString())
                    gradosC.setText(formattedNumber)
                } else if(gradosK.text.toString().trim().equals("")){
                    val formattedNumber ="%.2f".format(convertirFarenC(gradosF.text.toString().toDouble()))
                   //gradosC.setText(convertirFarenC(gradosF.text.toString().toDouble()).toString())
                    gradosC.setText(formattedNumber)
                }
            }catch (e: java.lang.Exception){
                println(e)
            }
        }

        btnConvertirK.setOnClickListener {
            try{
                if(gradosF.text.toString().trim().equals("")){
                    val formattedNumber ="%.2f".format(convertirCelsiusKel(gradosC.text.toString().toDouble()))
                    //gradosK.setText(convertirCelsiusKel(gradosC.text.toString().toDouble()).toString())
                    gradosK.setText(formattedNumber)
                } else if (gradosC.text.toString().trim().equals("")){
                    val formattedNumber ="%.2f".format(convertirFarenKel(gradosF.text.toString().toDouble()))
                    //gradosK.setText(convertirFarenKel(gradosF.text.toString().toDouble()).toString())
                    gradosK.setText(formattedNumber)
                }
            } catch (e: java.lang.Exception){
                println(e)
            }
        }
    }

    fun convertirKelvinFa(grados: Double): Double{
        var kel:Double
        kel = ((9*(grados-273.15))/5)+32
        return kel

    }

    fun convertirCelsiusFa(grados: Double):Double{
        var faren:Double
        faren = (grados*9/5)+32
        return faren

    }

    fun convertirFarenC (grados:Double):Double{
        var cel: Double
        cel = (grados-32)*5/9
        return cel

    }

    fun convertirKelvinC(grados:Double):Double{
        var kel: Double
        kel = grados - 273.15
        return kel
    }

    fun convertirCelsiusKel(grados: Double):Double{
        var cel : Double
        cel = grados + 273.15
        return cel
    }

    fun convertirFarenKel (grados:Double):Double{
        var faren: Double
        faren = ((5*(grados-32))/9) + 273.15
        return  faren
    }
}