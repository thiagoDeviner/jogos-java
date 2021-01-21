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

		char letra;//Essa vari�vel vai receber a letra que o usu�rio digitar.
		boolean ganhou = false; //Essa vari�vel come�a sendo falsa, pois o jogador s� ganhar� ao fim do jogo acertando todas as letras.
		int vidas = 6; //Quantidade de vidas igual ao n�mero membros que o boneco da forca vai ganhando.

		
		int palavraSorteada = rd.nextInt(palavras.length);// Sorteando uma palavra dentre todo o array palavras.
		String sorteada = palavras[palavraSorteada];// A vari�vel sorteada recebe a palavra sorteada dentre todas do array.

		// Controla os acertos do usu�rio... a ideia � que cada letra seja um acerto.
		char[] acertos = new char[sorteada.length()];//Criando um array char do tamanho da palavra sorteada.
		for (int i = 0; i < acertos.length; i++) {//Percorrendo todo o array de acertos.
			acertos[i] = 0;//Atribuindo 0 para cada elemento do array acertos, que significa que ele n�o acertou ainda.
		} //Olhar a linha 61.
		
		
		
		do {
			imprimir("\n\nQual letra voc� deseja tentar? \n");//Pedindo que o usu�rio informe uma letra.
			letra = ent.next().charAt(0);//charAt(), pois se trata de um caracter.
				
			//Dicas
			if(sorteada.equals("engenheiro")) {//Se a palavra sorteada for igual a engenheiro,
				imprimir("\n Dica: � um profissional.\n");//imprimir� essa dica.
			}
			else if(sorteada.equals("programa")) {//Se a palavra sorteada for igual a programa,
				imprimir("\n Dica: � parte intang�vel do computador.\n");//imprimir� essa dica.
			}
			else if(sorteada.equals("processador")) {//Se a palavra sorteada for igual a processador,
				imprimir("\n Dica: � um hardware.\n");//imprimir� essa dica.
			}
			else if(sorteada.equals("camisa")) {//Se a palavra sorteada for igual a camisa,
				imprimir("\n Dica: � uma roupa.\n");//imprimir� essa dica.
			}
			else if(sorteada.equals("cachorro")) {//Se a palavra sorteada for igual a cachorro,
				imprimir("\n Dica: � um animal.\n");//imprimir� essa dica.
			}
			else {//Por exce��o, se a palavra sorteada for igual a java,
				imprimir("\n Dica: � uma linguagem de programa��o.\n");//imprimir� essa dica.
			}
			
			
			boolean perdeVida = true; //PerdeVida come�a sendo true.
			
			for (int i = 0; i < sorteada.length(); i++) {//verifica se a letra digitada pelo usu�rio � igual a pelo menos uma letra da palavra sorteada.
				if (letra == sorteada.charAt(i)) {
					
					acertos[i] = 1;//acertos[i] passa a valer 1, deixando de ser 0. Isso para imprimir a letra digitada pelo usu�rio. Olhar o bloco da linha 76.
					perdeVida = false;
				}
			}

			if (perdeVida) {//Se perdeVida permanecer true, 
				vidas--;// as vidas ir�o diminuir.
			}

			imprimir("\n");
			
			ganhou = true;
			for (int i = 0; i < sorteada.length(); i++) {
				if (acertos[i] == 0) {//se existir algum acerto[i] for igual a 0(existe pelo menos alguma letra que ele n�o acertou)
					imprimir(" _ "); //imprime o underline.
					ganhou = false; //ent�o ele ainda n�o ganhou o jogo.
				} else {
					imprimir(" " + sorteada.charAt(i) + " ");// sen�o ele ir� acertar, e cosequentemente , ir� imprimir a letra que o usu�rio digitou no lugar do underline.
				}
			}

			if (vidas == 6) {//Se vidas == 6, ele ainda n�o perdeu vida, ent�o s� imprime a forca.
				imprimir("\n\n---\n" 
							+ "  |\n");
			}
			if (vidas == 5) {//Se vidas == 5, imprime a forca e a cabe�a.
				imprimir("\n\n---\n" 
							+ "  |\n" 
							+ "  O\n");
			}
			if (vidas == 4) {//Se vidas == 4, imprime a forca e a cabe�a e o tronco.
				imprimir("\n\n---\n" 
							+ "  |\n" 
							+ "  O\n" 
							+ "  |\n");
			}
			if (vidas == 3) {//Se vidas == 3, imprime a forca, a cabe�a, o tronco e o bra�o esquerdo.
				imprimir("\n\n---\n" 
							+ "  |\n" 
							+ "  O\n" 
							+ "  |\\\n");
			}
			if (vidas == 2) {//Se vidas == 2, imprime a forca, a cabe�a, o tronco e o bra�o esquerdo e direito.
				imprimir("\n\n---\n" 
							+ "  |\n" 
							+ "  O\n" 
							+ " /|\\\n");
			}
			if (vidas == 1) {//Se vidas == 1, imprime a forca, a cabe�a, o tronco e o bra�o esquerdo e direito e a perna esquerda.
				imprimir("\n\n---\n" 
							+ "  |\n" 
							+ "  O\n" 
							+ " /|\\\n" 
							+ "   \\\n");
			}
		} while (!ganhou && vidas > 0); //Se ele ainda n�o ganhou e tamb�m ainda n�o perdeu, vai repetir isso tudo.

		
		//Saindo do la�o de repeti��o, ao final.
		if (vidas != 0) {//Se vidas != 0, o usu�rio vence.
			imprimir("\n\n****Parab�ns!!! Voc� ganhou!!!****\n\n");

		} else {//caso contr�rio, o usu�rio perde e imprime o boneco inteiro na forca.
			imprimir("\n\n Voc� Perdeu!!! =(\n\n");
			imprimir("\n\n---\n" 
						+ "  |\n" 
						+ "  O\n" 
						+ " /|\\\n" 
						+ " / \\\n");
			
			imprimir("\nA palavra sorteada era: " + palavras[palavraSorteada] + "\n\n"); //Imprime tamb�m qual era a palavra sorteada.
		}
	}
	
	public static void imprimir(String txt) {//M�todo de impress�o.
		System.out.print(txt);
	}
	
}
