package lucasgodoy1.com.github.applistavip.view

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View

import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import lucasgodoy1.com.github.applistavip.R
import lucasgodoy1.com.github.applistavip.controller.PessoaController
import lucasgodoy1.com.github.applistavip.model.Pessoa

class MainActivity : AppCompatActivity() {
    lateinit var idNome: EditText
    lateinit var idSobrenome: EditText
    lateinit var idCursoInt: EditText
    lateinit var idTelefone: EditText

    lateinit var idBtnFinalizar: AppCompatButton
    lateinit var idBtnLimpar: AppCompatButton
    lateinit var idBtnSalvar: AppCompatButton

    lateinit var pessoa: Pessoa

    lateinit var preferences: SharedPreferences

    val NOME_PREFERENCES : String = "pref_listaVip"

    var pessoaController = PessoaController()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        preferences = getSharedPreferences(NOME_PREFERENCES, 0)
        var listaVip = preferences.edit()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        idNome = findViewById(R.id.idAndroidNome)
        idSobrenome = findViewById(R.id.idAndroidSobrenome)
        idCursoInt = findViewById(R.id.idAndroidCursoInt)
        idTelefone = findViewById(R.id.idAndroidTel)

        idBtnSalvar = findViewById(R.id.idAndroidBtnSal)
        idBtnLimpar = findViewById(R.id.idAndroidBtnLimp)
        idBtnFinalizar = findViewById(R.id.idAndroidBtnFinalizar)



        idBtnLimpar.setOnClickListener(View.OnClickListener {
            idNome.setText("")
            idSobrenome.setText("")
            idCursoInt.setText("")
            idTelefone.setText("")
        })

        idBtnSalvar.setOnClickListener(View.OnClickListener {
            pessoa = Pessoa(
                idNome.text.toString(),
                idSobrenome.text.toString(),
                idCursoInt.text.toString(),
                idTelefone.text.toString()
            )
            Toast.makeText(this, "Salvo: $pessoa", Toast.LENGTH_LONG).show()

            pessoaController.salvar(pessoa)

            listaVip.putString("PrimeiroNome", pessoa.primeiroNome)
            listaVip.putString("SegundoNome", pessoa.segundoNome)
            listaVip.putString("Nome do curso", pessoa.cursoDeImteresse)
            listaVip.putString("Telefone de contato", pessoa.telefoneContato)

            listaVip.apply()
        })

        idBtnFinalizar.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Volte Sempre", Toast.LENGTH_LONG).show()
            finish()
        })
    }


}