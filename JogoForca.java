package br.ucsal;

import java.util.Random;
import java.util.Scanner;

public class JogoForca {

	public static void novoJogo() {
		
		Scanner ent = new Scanner(System.in);

		// ARRAY DE PALAVRAS
		String[] palavras = {"engenheiro", "programa", "processador", "camisa", "cachorro", "java" };

		// SORTEADOR
		Random rd = new Random();

		char letra;//Essa variável vai receber a letra que o usuário digitar.
		boolean ganhou = false; //Essa variável começa sendo falsa, pois o jogador só ganhará ao fim do jogo acertando todas as letras.
		int vidas = 6; //Quantidade de vidas igual ao número membros que o boneco da forca vai ganhando.

		
		int palavraSorteada = rd.nextInt(palavras.length);// Sorteando uma palavra dentre todo o array palavras.
		String sorteada = palavras[palavraSorteada];// A variável sorteada recebe a palavra sorteada dentre todas do array.

		// Controla os acertos do usuário... a ideia é que cada letra seja um acerto.
		char[] acertos = new char[sorteada.length()];//Criando um array char do tamanho da palavra sorteada.
		for (int i = 0; i < acertos.length; i++) {//Percorrendo todo o array de acertos.
			acertos[i] = 0;//Atribuindo 0 para cada elemento do array acertos, que significa que ele não acertou ainda.
		} //Olhar a linha 61.
		
		
		
		do {
			imprimir("\n\nQual letra você deseja tentar? \n");//Pedindo que o usuário informe uma letra.
			letra = ent.next().charAt(0);//charAt(), pois se trata de um caracter.
				
			//Dicas
			if(sorteada.equals("engenheiro")) {//Se a palavra sorteada for igual a engenheiro,
				imprimir("\n Dica: É um profissional.\n");//imprimirá essa dica.
			}
			else if(sorteada.equals("programa")) {//Se a palavra sorteada for igual a programa,
				imprimir("\n Dica: É parte intangível do computador.\n");//imprimirá essa dica.
			}
			else if(sorteada.equals("processador")) {//Se a palavra sorteada for igual a processador,
				imprimir("\n Dica: É um hardware.\n");//imprimirá essa dica.
			}
			else if(sorteada.equals("camisa")) {//Se a palavra sorteada for igual a camisa,
				imprimir("\n Dica: É uma roupa.\n");//imprimirá essa dica.
			}
			else if(sorteada.equals("cachorro")) {//Se a palavra sorteada for igual a cachorro,
				imprimir("\n Dica: É um animal.\n");//imprimirá essa dica.
			}
			else {//Por exceção, se a palavra sorteada for igual a java,
				imprimir("\n Dica: É uma linguagem de programação.\n");//imprimirá essa dica.
			}
			
			
			boolean perdeVida = true; //PerdeVida começa sendo true.
			
			for (int i = 0; i < sorteada.length(); i++) {//verifica se a letra digitada pelo usuário é igual a pelo menos uma letra da palavra sorteada.
				if (letra == sorteada.charAt(i)) {
					
					acertos[i] = 1;//acertos[i] passa a valer 1, deixando de ser 0. Isso para imprimir a letra digitada pelo usuário. Olhar o bloco da linha 76.
					perdeVida = false;
				}
			}

			if (perdeVida) {//Se perdeVida permanecer true, 
				vidas--;// as vidas irão diminuir.
			}

			imprimir("\n");
			
			ganhou = true;
			for (int i = 0; i < sorteada.length(); i++) {
				if (acertos[i] == 0) {//se existir algum acerto[i] for igual a 0(existe pelo menos alguma letra que ele não acertou)
					imprimir(" _ "); //imprime o underline.
					ganhou = false; //então ele ainda não ganhou o jogo.
				} else {
					imprimir(" " + sorteada.charAt(i) + " ");// senão ele irá acertar, e cosequentemente , irá imprimir a letra que o usuário digitou no lugar do underline.
				}
			}

			if (vidas == 6) {//Se vidas == 6, ele ainda não perdeu vida, então só imprime a forca.
				imprimir("\n\n---\n" 
							+ "  |\n");
			}
			if (vidas == 5) {//Se vidas == 5, imprime a forca e a cabeça.
				imprimir("\n\n---\n" 
							+ "  |\n" 
							+ "  O\n");
			}
			if (vidas == 4) {//Se vidas == 4, imprime a forca e a cabeça e o tronco.
				imprimir("\n\n---\n" 
							+ "  |\n" 
							+ "  O\n" 
							+ "  |\n");
			}
			if (vidas == 3) {//Se vidas == 3, imprime a forca, a cabeça, o tronco e o braço esquerdo.
				imprimir("\n\n---\n" 
							+ "  |\n" 
							+ "  O\n" 
							+ "  |\\\n");
			}
			if (vidas == 2) {//Se vidas == 2, imprime a forca, a cabeça, o tronco e o braço esquerdo e direito.
				imprimir("\n\n---\n" 
							+ "  |\n" 
							+ "  O\n" 
							+ " /|\\\n");
			}
			if (vidas == 1) {//Se vidas == 1, imprime a forca, a cabeça, o tronco e o braço esquerdo e direito e a perna esquerda.
				imprimir("\n\n---\n" 
							+ "  |\n" 
							+ "  O\n" 
							+ " /|\\\n" 
							+ "   \\\n");
			}
		} while (!ganhou && vidas > 0); //Se ele ainda não ganhou e também ainda não perdeu, vai repetir isso tudo.

		
		//Saindo do laço de repetição, ao final.
		if (vidas != 0) {//Se vidas != 0, o usuário vence.
			imprimir("\n\n****Parabéns!!! Você ganhou!!!****\n\n");

		} else {//caso contrário, o usuário perde e imprime o boneco inteiro na forca.
			imprimir("\n\n Você Perdeu!!! =(\n\n");
			imprimir("\n\n---\n" 
						+ "  |\n" 
						+ "  O\n" 
						+ " /|\\\n" 
						+ " / \\\n");
			
			imprimir("\nA palavra sorteada era: " + palavras[palavraSorteada] + "\n\n"); //Imprime também qual era a palavra sorteada.
		}
	}
	
	public static void imprimir(String txt) {//Método de impressão.
		System.out.print(txt);
	}
	
}
