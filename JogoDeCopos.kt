/* Exercicio URI 3053

Uma brincadeira muito comum e divertida entre dois jogadores usa uma moeda e três copos opacos (ou seja,
não é possível ver o que está dentro do copo olhando pela lateral do copo). Os três copos são
colocados com a boca para baixo, em uma linha, um ao lado do outro, em posições que vamos chamar
de A, B e C. Uma moeda é colocada embaixo de um dos copos.
Na brincadeira, um jogador chamado banca realiza um movimento para trocar a posição de dois copos,
arrastando os copos de tal modo que se a moeda está em baixo de um dos copos envolvidos no movimento,
ela continua embaixo do mesmo copo após a troca de posição. O jogador banca pode realizar três tipos
de movimento, ilustrados na figura abaixo:

1. Trocar o copo na posição A com o copo na posição B.

2. Trocar o copo na posição B com o copo na posição C.

3. Trocar o copo na posição A com o copo na posição C.

O jogador banca realiza vários movimentos de troca tentando confundir o outro jogador,
chamado espectador. Ao final o jogador espectador deve dizer em qual posição está a moeda.
Por exemplo, considere que inicialmente a moeda está embaixo do copo na posição A e que o
jogador banca realiza uma sequência de apenas três trocas, executando um movimento do tipo 1,
após o qual moeda termina embaixo do copo na posição B, seguido de um movimento do tipo 2,
após o qual a moeda termina embaixo do copo na posição C, seguido de um movimento do tipo 3,
após o qual a moeda termina embaixo do copo na posição A.

Nesta tarefa, dadas a descrição da sequência de movimentos e a posição inicial da moeda,
você deve escrever um programa que determine a posição final da moeda após todos os movimentos.

Entrada

A primeira linha contém um inteiro N, o número de movimentos que o jogador banca realiza.
A segunda linha contém um caractere, entre A, B e C, indicando a posição inicial da moeda.
Cada uma das N linhas seguintes contém um inteiro, indicando o tipo de movimento efetuado pelo
jogador banca na sequência.

Saída

Seu programa deve produzir uma única linha, com um único caractere entre A, B e C,
a posição em que a moeda se encontra ao final da sequência de movimentos.

Restrições • 1 ≤ N ≤ 1000

 */


const val POSITION_A = "A"
const val POSITION_B = "B"
const val POSITION_C = "C"

fun main() {

    println("Digite o número de movimentos que o jogador banca realiza:")
    val rRounds = readLine().toString().toInt()

    if (rRounds <= 0 || rRounds > 1000){
        println("Numero invalido! (Valido de 1 a 1000)")
        return
    }

    println("Digite a posição inicial da moeda:")
    var rCoin = readLine().toString().uppercase()

    if (!(rCoin == "A" || rCoin == "B" || rCoin == "C")){
        println("Posição invalida! (Valido A, B ou C)")
        return
    }

    var i = 0
    while (i < rRounds) {
        println("Digite o numero de movimento:")
        val rMove = readLine().toString().toInt()

        when (rMove) {
            1 -> {
                when (rCoin) {
                    POSITION_A -> rCoin = POSITION_B
                    POSITION_B -> rCoin = POSITION_A
                }
            }
            2 -> {
                when (rCoin) {
                    POSITION_B -> rCoin = POSITION_C
                    POSITION_C -> rCoin = POSITION_B
                }
            }
            3 -> {
                when (rCoin) {
                    POSITION_A -> rCoin = POSITION_C
                    POSITION_C -> rCoin = POSITION_A
                }
            }
            else -> println("Numero de movimento invalido.")
        }
        i++
    }

    println(rCoin)
}