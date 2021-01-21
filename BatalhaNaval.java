package br.ucsal;

import java.util.Scanner;

public class BatalhaNaval {

	public static void novoJogo () {


		Scanner entCol = new Scanner(System.in);
		Scanner entLinha = new Scanner(System.in);

		int[] vetorColunas = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// Tabuleiro: Utilizado somente para o formato a ser exibido do
		// tabuleiro
		String tabela[][] = new String[10][10];

		// Área do tabuleiro (para ser utilizado valores númericos)
		int area[][] = new int[10][10];

		// Array de navios, totalizando 20. Cada um com seu valor (ponto)
		int navios[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4 };

		int tiroCol = 0; // Tiro em colunas
		int tiroLin = 0; // Tiro em linhas
		int pontos = 0, acertos = 0, erros = 0;
		int linhas = 0; // Linhas com random
		int cols = 0; // Colunas com random
		int qtdTentativas = 6; // Quantidade de tentativas

		// Abaixo estão sendo inseridos os navios na área do tabuleiro.
		// O if(area[linhas][cols] == 0) compara se o valor atual não foi
		// preenchido por algum navio anterior.
		// Como as váriaveis "linhas" e "colunas" estão com um valor randômico,
		// o valor da área
		// que vier aleatoriamente, será preenchido pelo navio.
		// A varivável contNavios é o contador de navios.
		
		int contNavios = 0;
		do {
			linhas = (int) (Math.random() * 10); // Linhas
			cols = (int) (Math.random() * 10); // Colunas
			if (area[linhas][cols] == 0) {
				if (contNavios == 0) {
					area[linhas][cols] = navios[0];
				} else if (contNavios == 1) {
					area[linhas][cols] = navios[1];
				} else if (contNavios == 2) {
					area[linhas][cols] = navios[2];
				} else if (contNavios == 3) {
					area[linhas][cols] = navios[3];
				} else if (contNavios == 4) {
					area[linhas][cols] = navios[4];
				} else if (contNavios == 5) {
					area[linhas][cols] = navios[5];
				} else if (contNavios == 6) {
					area[linhas][cols] = navios[6];
				} else if (contNavios == 7) {
					area[linhas][cols] = navios[7];
				} else if (contNavios == 8) {
					area[linhas][cols] = navios[8];
				} else if (contNavios == 9) {
					area[linhas][cols] = navios[9];
				} else if (contNavios == 10) {
					area[linhas][cols] = navios[10];
				} else if (contNavios == 11) {
					area[linhas][cols] = navios[11];
				} else if (contNavios == 12) {
					area[linhas][cols] = navios[12];
				} else if (contNavios == 13) {
					area[linhas][cols] = navios[13];
				} else if (contNavios == 14) {
					area[linhas][cols] = navios[14];
				} else if (contNavios == 15) {
					area[linhas][cols] = navios[15];
				} else if (contNavios == 16) {
					area[linhas][cols] = navios[16];
				} else if (contNavios == 17) {
					area[linhas][cols] = navios[17];
				} else if (contNavios == 18) {
					area[linhas][cols] = navios[18];
				} else if (contNavios == 19) {
					area[linhas][cols] = navios[19];
				} else if (contNavios == 20) {
					area[linhas][cols] = navios[20];
				}  
				
				contNavios++;
			}

		} while (contNavios < 20);

		imprimir("\nRegras do jogo: O jogo contém um tabuleiro 10x10 com 20 navios nele.\n");
		imprimir("Há 8 submarinos de 1 ponto, 6 contratorpedeiros de 2 pontos, 4 navios-tanque de 3 pontos e 1 porta-aviões de 4 pontos.\n");
		imprimir("Caso acerte um navio será marcado X no tabuleiro, caso acerte a água será marcado O.\n");
		imprimir("Você tem " + qtdTentativas + " tiros disponíveis.\n");
		imprimir("Informe um número de 1 a 10 para representar a coluna, \n");
		imprimir("Informe um número de 1 a 10 para representar a linha. \n");
		imprimir("No final do jogo será exibido o local dos navios com seus respectivos pontos.\n");

		// No while abaixo, será a quantidade de tentativas de tiros que poderão
		// ser realizados.
		
		while (qtdTentativas > 0) {
			imprimir("Tentativas restantes: " + qtdTentativas + "\n");
			int coluna;
			imprimir("Escolha a coluna: ");
			coluna = entCol.nextInt();

			// For utilizado para comparar o número da coluna digitado acima com o array de
			// colunas.
			
			for (int i = 0; i < 10; i++) {
				if (coluna == vetorColunas[i]) {
					tiroCol = i;
				}

			}

			// Valor adquirido pelo Scanner -1, ou seja, se for digitado 1,
			// irá pegar a primeira linha que a primeira posição do array (0)
			imprimir("Escolha a linha: ");
			tiroLin = entLinha.nextInt() - 1;
			imprimir("\n");

			// Ifs utilizados para atribuição de pontos, acertos e erros
			// Caso ocorra algum acerto, será inserido X no tabuleiro, caso
			// contrário insere O
			
			
			if (area[tiroLin][tiroCol] == navios[0] || area[tiroLin][tiroCol] == navios[1] || area[tiroLin][tiroCol] == navios[2] || area[tiroLin][tiroCol] == navios[3] || area[tiroLin][tiroCol] == navios[4] || area[tiroLin][tiroCol] == navios[5] || area[tiroLin][tiroCol] == navios[6] || area[tiroLin][tiroCol] == navios[7]) {
				pontos += 1;
				acertos++;
				imprimir("Acertou um submarino de 1 ponto!\n");
				tabela[tiroLin][tiroCol] = "X";
			} else if (area[tiroLin][tiroCol] == navios[8] || area[tiroLin][tiroCol] == navios[9] || area[tiroLin][tiroCol] == navios[10] || area[tiroLin][tiroCol] == navios[11] || area[tiroLin][tiroCol] == navios[12] || area[tiroLin][tiroCol] == navios[13]) {
				pontos += 2;
				acertos++;
				imprimir("Acertou um navio-tanue de 2 pontos!\n");
				tabela[tiroLin][tiroCol] = "X";
			} else if (area[tiroLin][tiroCol] == navios[14] || area[tiroLin][tiroCol] == navios[15] || area[tiroLin][tiroCol] == navios[16] || area[tiroLin][tiroCol] == navios[17]) {
				pontos += 3;
				acertos++;
				imprimir("Acertou um contratorpedeiro de 3 pontos!!\n");
				tabela[tiroLin][tiroCol] = "X";
			} else if (area[tiroLin][tiroCol] == navios[18] || area[tiroLin][tiroCol] == navios[19]) {
				pontos += 4;
				acertos++;
				imprimir("Acertou um porta-aviões de 4 pontos!!!\n");
				tabela[tiroLin][tiroCol] = "X";
			}

			else {
				erros++;
				imprimir("Acertou a água... =/\n");
				tabela[tiroLin][tiroCol] = "O";
			}

			// Exibir as letras das colunas antes de exibir o tabuleiro
			imprimir("----------------------\n");
			imprimir("|1|2|3|4|5|6|7|8|9|10|\n");
			imprimir("----------------------");

			// for utilizado somente para formatar e exibir o tabuleiro
			for (int i = 0; i < 10; i++) {
				imprimir("\n");
				imprimir(i + 1);

				for (int j = 0; j < 10; j++) {

					if (tabela[i][j] != "X" && tabela[i][j] != "O") {
						tabela[i][j] = " ";
					}
					imprimir("|" + tabela[i][j]);

				}
				imprimir("|\n----------------------");
			}

			// Exibir os pontos, acertos e erros
			imprimir("\nPontos: " + pontos + "\n");
			imprimir("Acertos no navio: " + acertos + "\n");
			imprimir("Acertos na água: " + erros + "\n");
			imprimir("\n");

			// Contador de tentativas
			qtdTentativas--;

		} // Fim while contTentativas
		

		// Campo para exibir a resposta do jogo
		imprimir("**** RESPOSTA ****\n");
		imprimir("----------------------\n");
		imprimir("|1|2|3|4|5|6|7|8|9|10|\n");
		imprimir("----------------------");

		for (int i = 0; i < 10; i++) {
			imprimir("\n");
			imprimir(i + 1);

			for (int j = 0; j < 10; j++) {

				imprimir("|" + area[i][j]);

			}
			imprimir("|\n------------------");
		}
		
	
	}
	
	public static void imprimir(String txt) {
		System.out.print(txt);
	}
	
	public static void imprimir(int valor) {
		System.out.println(valor);
	}
	
}
