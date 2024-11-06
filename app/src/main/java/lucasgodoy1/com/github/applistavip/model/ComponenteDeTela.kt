package lucasgodoy1.com.github.applistavip.model

import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatButton
import lucasgodoy1.com.github.applistavip.R
import lucasgodoy1.com.github.applistavip.controller.CursoController
import lucasgodoy1.com.github.applistavip.view.MainActivity

class ComponenteDeTela ( private val mainActivity : MainActivity){

     var idNome: EditText = mainActivity.findViewById(R.id.idAndroidNome)
     var idSobrenome: EditText = mainActivity.findViewById(R.id.idAndroidSobrenome)
     var idCursoInt: EditText = mainActivity.findViewById(R.id.idAndroidCursoInt)
     var idTelefone: EditText = mainActivity.findViewById(R.id.idAndroidTel)

     val idBtnFinalizar: AppCompatButton =  mainActivity.findViewById(R.id.idAndroidBtnFinalizar)
     val idBtnLimpar: AppCompatButton = mainActivity.findViewById(R.id.idAndroidBtnLimp)
     val idBtnColetarInfo: AppCompatButton  = mainActivity.findViewById(R.id.idAndroidBtnSal)

     var idSpiner : Spinner = mainActivity.findViewById(R.id.idSpinerCurso)



}