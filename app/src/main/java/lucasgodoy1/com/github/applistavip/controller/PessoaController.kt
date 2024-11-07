package lucasgodoy1.com.github.applistavip.controller

import android.content.SharedPreferences
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import lucasgodoy1.com.github.applistavip.model.ComponenteDeTela
import lucasgodoy1.com.github.applistavip.model.Pessoa
import lucasgodoy1.com.github.applistavip.view.MainActivity

class PessoaController(private val mainActivity: MainActivity) {

    var NOME_PREFERENCES: String = "pref_Arquivo_listaVip"
    var preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0)
    var listaVip: SharedPreferences.Editor = preferences.edit()

    val componenteDeTela = ComponenteDeTela(mainActivity)
    lateinit var pessoa: Pessoa
    var cursoController = CursoController()


    fun iniciarComponentes() {
        buscar()
        salvar()
        finalizar()
        limpar()
        spinner()
    }


    fun buscar() {
        val primeiroNome = preferences.getString("PrimeiroNome", "N/A")
        val segundoNome = preferences.getString("SegundoNome", "N/A")
        val nomeDoCurso = preferences.getString("NomeDocurso", "N/A")
        val telefoneContato = preferences.getString("TelefoneDeContato", "N/A")

        Log.i("MVC_Controller_Arquivo", "Buscar PrimeiroNome: $primeiroNome")
        Log.i("MVC_Controller_Arquivo", "Buscar SegundoNome: $segundoNome")
        Log.i("MVC_Controller_Arquivo", "Buscar NomeDocurso: $nomeDoCurso")
        Log.i("MVC_Controller_Arquivo", "Buscar TelefoneDeContato: $telefoneContato")

    }

    fun limpar() {
        componenteDeTela.idBtnLimpar.setOnClickListener(View.OnClickListener {
            componenteDeTela.idNome.setText("")
            componenteDeTela.idSobrenome.setText("")
            componenteDeTela.idCursoInt.setText("")
            componenteDeTela.idTelefone.setText("")
        })


        listaVip.clear()
        listaVip.apply()
    }


    fun salvar() {
        componenteDeTela.idBtnColetarInfo.setOnClickListener(View.OnClickListener {
            pessoa = Pessoa(
                componenteDeTela.idNome.text.toString(),
                componenteDeTela.idSobrenome.text.toString(),
                componenteDeTela.idCursoInt.text.toString(),
                componenteDeTela.idTelefone.text.toString()
            )
            Log.i("MVC_Controller", "metodo_salvar ${pessoa.toString()}")
            Toast.makeText(mainActivity, "Salvo: $pessoa", Toast.LENGTH_LONG).show()
            listaVip.putString("PrimeiroNome", pessoa.primeiroNome)
            listaVip.putString("SegundoNome", pessoa.segundoNome)
            listaVip.putString("NomeDocurso", pessoa.cursoDeImteresse)
            listaVip.putString("TelefoneDeContato", pessoa.telefoneContato)
            listaVip.apply()
        })


    }

    fun finalizar() {
        componenteDeTela.idBtnFinalizar.setOnClickListener(View.OnClickListener {
            Toast.makeText(mainActivity, "Volte Sempre", Toast.LENGTH_LONG).show()
            mainActivity.finish()
        })
    }

    fun spinner() {
        var adapter = ArrayAdapter<String>(
            mainActivity,
            android.R.layout.simple_list_item_1,
            cursoController.getListaParaSpiner()
        )
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        componenteDeTela.idSpiner.adapter = adapter
    }

}