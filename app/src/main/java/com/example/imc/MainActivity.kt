import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.imc.R

class MainActivity : AppCompatActivity() {

    lateinit var peso: EditText
    lateinit var altura: EditText
    lateinit var calcularButton: Button
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        peso = findViewById(R.id.txtPeso)
        altura = findViewById(R.id.txtAltura)
        calcularButton = findViewById(R.id.btnCalcular)
        resultado = findViewById(R.id.txtResultado)

        calcularButton.setOnClickListener {
            calcularIMC()
        }
    }

    private fun calcularIMC() {
        val peso = peso.text.toString().toDoubleOrNull()
        val altura = altura.text.toString().toDoubleOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            val resultadoIMC = String.format("%.2f", imc)
            resultado.text = "Tu IMC es: $resultadoIMC\n"

            val mensaje: String = when {
                imc < 18.5 -> "Usted sufre delgadez, debería comer más."
                imc in 18.5..24.9 -> "Su estado de forma es bueno."
                imc in 25.0..29.9 -> "Usted sufre sobrepeso, debería cuidarse y llamar a un dietista."
                else -> "Usted sufre obesidad, debería llamar a un médico urgentemente."
            }

            resultado.text = "Tu IMC es: $resultadoIMC\n$mensaje"
        } else {
            resultado.text = "Ingresa valores válidos para peso y altura."
        }
    }

}


