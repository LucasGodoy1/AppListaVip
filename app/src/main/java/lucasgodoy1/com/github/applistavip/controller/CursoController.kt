package lucasgodoy1.com.github.applistavip.controller

import android.util.Log
import lucasgodoy1.com.github.applistavip.model.Curso

class CursoController() {

    lateinit var cursos: MutableList<Curso>
        private set


    private fun getListaDoCurso(): MutableList<Curso> {
        cursos = mutableListOf()

        cursos.add(Curso("Java"))
        cursos.add(Curso("Kotlin"))
        cursos.add(Curso("Python"))
        cursos.add(Curso("Dart"))
        cursos.add(Curso("Ruby"))

        Log.i("Log_Lista", cursos.toString())

        return cursos
    }

    fun getListaParaSpiner(): MutableList<String> {
        val lista = getListaDoCurso()
        var listaDeObjetos: MutableList<String>
        listaDeObjetos = mutableListOf()

        for (item in lista) {
            listaDeObjetos.add(item.nomeDoCursoDesehado)
        }
        return listaDeObjetos
    }


}