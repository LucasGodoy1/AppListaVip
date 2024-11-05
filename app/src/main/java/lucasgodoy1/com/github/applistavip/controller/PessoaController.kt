package lucasgodoy1.com.github.applistavip.controller

import android.content.SharedPreferences
import android.util.Log
import lucasgodoy1.com.github.applistavip.model.Pessoa
import lucasgodoy1.com.github.applistavip.view.MainActivity

class PessoaController ( mainActivity: MainActivity){

    val NOME_PREFERENCES : String = "pref_listaVip"
    val preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0)
    var listaVip = preferences.edit()


    fun criarSharedPreferences(){
    }

    fun buscar( ){
        val primeiroNome = preferences.getString("PrimeiroNome", "N/A")
        val segundoNome = preferences.getString("SegundoNome", "N/A")
        val nomeDoCurso = preferences.getString("NomeDocurso", "N/A")
        val telefoneContato = preferences.getString("TelefoneDeContato", "N/A")

        Log.i("MVC_Controller_Arquivo", "Buscar PrimeiroNome: $primeiroNome")
        Log.i("MVC_Controller_Arquivo", "Buscar SegundoNome: $segundoNome")
        Log.i("MVC_Controller_Arquivo", "Buscar NomeDocurso: $nomeDoCurso")
        Log.i("MVC_Controller_Arquivo", "Buscar TelefoneDeContato: $telefoneContato")

    }

    fun limpar(){
        listaVip.clear()
        listaVip.apply()
    }



    fun salvar(pessoa: Pessoa) {
        Log.i("MVC_Controller","salvo ${pessoa.toString()}")

        listaVip.putString("PrimeiroNome", pessoa.primeiroNome)
        listaVip.putString("SegundoNome", pessoa.segundoNome)
        listaVip.putString("NomeDocurso", pessoa.cursoDeImteresse)
        listaVip.putString("TelefoneDeContato", pessoa.telefoneContato)

        listaVip.apply()
        buscar()
    }


}