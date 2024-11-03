package lucasgodoy1.com.github.applistavip.controller

import android.util.Log
import lucasgodoy1.com.github.applistavip.model.Pessoa

class PessoaController {


    fun salvar(pessoa: Pessoa) {
        Log.i("MVC_Controller","salvo ${pessoa.toString()}")
    }


}