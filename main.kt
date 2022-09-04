import java.time.LocalDate
import java.util.Scanner

class Viagem(pais: String, cidade: String, dia: String, mes: String, ano: String, hospedagem: String) {
    val date: LocalDate = LocalDate.of(ano.toInt(), mes.toInt(), dia.toInt())
    val destino: String = "$cidade, $pais"
    val hospedagem: String = hospedagem

    init {
        println("Viagem para $destino, no dia $date, hospedagem em $hospedagem")
    }
}
class Itinerario {
    val viagens = mutableListOf<Viagem>()
}

fun criarViagem(scanner: Scanner): Viagem {
    println("Qual o país da viagem?")
    val pais = scanner.nextLine()
    println("Qual a cidade da viagem?")
    val cidade = scanner.nextLine()
    println("Qual o dia da viagem?")
    val dia = scanner.nextLine()
    println("Qual o mês da viagem?")
    val mes = scanner.nextLine()
    println("Qual o ano da viagem?")
    val ano = scanner.nextLine()
    println("Qual o local de hospedagem?")
    val hospedagem = scanner.nextLine()
    return Viagem(pais, cidade, dia, mes, ano, hospedagem)
}

fun organizarItinerario(viagens: List<Viagem>): Itinerario {
    val itinerario = Itinerario()
    val viagensOrdenadas = viagens.sortedBy { it.date }
    itinerario.viagens.addAll(viagensOrdenadas)
    return itinerario
}

fun main() {
    val scanner = Scanner(System.`in`)
    val viagens = mutableListOf<Viagem>()
    var continuar = true
    while (continuar) {
        val viagem = criarViagem(scanner)
        viagens.add(viagem)
        println("Deseja adicionar outra viagem? (s/n)")
        val resposta = scanner.nextLine()
        if (resposta == "n") {
            continuar = false
        }
    }
    val itinerario = organizarItinerario(viagens)
    for (viagem in itinerario.viagens) {
        println("Viagem para ${viagem.destino}, no dia ${viagem.date}, hospedagem em ${viagem.hospedagem}")
    }
}