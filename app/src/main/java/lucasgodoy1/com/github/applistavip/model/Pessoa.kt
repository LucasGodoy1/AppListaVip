package lucasgodoy1.com.github.applistavip.model


class Pessoa (nome : String, segundoNome: String, cursoDeImteresse: String, telefoneContato : String){
     val primeiroNome: String = nome
     val segundoNome: String = segundoNome
     var cursoDeImteresse: String = cursoDeImteresse
     var telefoneContato: String = telefoneContato



    override fun toString(): String {
        return "Pessoa(primeiroNome='$primeiroNome', segundoNome='$segundoNome', cursoDeImteresse='$cursoDeImteresse', telefoneContato='$telefoneContato')"
    }


}