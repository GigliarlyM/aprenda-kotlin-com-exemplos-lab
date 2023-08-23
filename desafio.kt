// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario (var nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    infix fun matricularInfix(usuario: Usuario) { inscritos.add(usuario) }
    
    fun matricular(usuario: Usuario) {
        // ("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }
    
    fun mostrarConteudos(): List<ConteudoEducacional> {
        return conteudos
    }
    
    fun mostrarInscritos(): MutableList<Usuario> {
        return inscritos
    }
    
    fun removerInscrito(posicao: Int) {
        println("O inscrito ${inscritos[posicao].nome} será removido")
        inscritos.removeAt(posicao)
    }
}

fun main() {
    // ("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    // ("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    val conteudos = mutableListOf("Fundamentos", "Conhecendo o ambiente", "Algoritmo", "Sistema Operacional")
    val conteudoEducacionais = mutableListOf<ConteudoEducacional>()
    conteudos.forEach {
        i-> conteudoEducacionais.add(ConteudoEducacional(i))
    }
    
    val formacao = Formacao("TI", Nivel.BASICO, conteudoEducacionais)
    
    val nomes = listOf("Nicolas", "Matias", "Maria", "Ester", "Rodolfo", "Mariana")
    nomes.forEach { i -> 
        formacao matricularInfix Usuario(i)
    }
    
    formacao.run {
        println("Os alunos cadastrados na formacao de $nome:")
        mostrarInscritos().forEach { inscrito->
            println("${inscrito.nome}")
        }
        
        // println(mostrarInscritos()[1].nome) // pesquisa unica
    	
        removerInscrito(0)
    }
    
}