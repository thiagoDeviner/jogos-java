package br.ucsal;

import java.util.Random;
import java.util.Scanner;

public class CampoMinado {

	//Inicia um novo jogo
	public static void novoJogo() {
		
		char[][] tabuleiro = new char[16][16];//Criando um vetor bidimensional 16 por 16 que será mostrado ao jogador.
		int[][] minas = new int[16][16];//Criando um vetor bidimensional 16 por 16 que será virtual.
		int lin, col, jogada = 0;

		Scanner leitura = new Scanner(System.in);

		boolean encerrar = false;
		boolean vencedor = false;

		//Monta o tabuleiro de jogo
		tabJogo(tabuleiro);
		//distrinue as minas no tabuleiro virtual
		tabMinas(minas);

		
		
		
		
		do {
			jogada++;
			//impressaoTabMinas(minas);
			imprimirTabJogo(tabuleiro);

			do {

				imprimir("\n\nRodada: " + jogada + "\n");
				imprimir("\n");
				imprimir("Info: linha e a coluna vai de '0' a '15'.\n");

				do {
					imprimir("Informe a linha: \n");
                    lin = leitura.nextInt();
                    //tratamento de erro
					if (lin < 0 || lin > 15) {
						imprimir("Escolha números entre 0 e 15.\n");
					}
				} while (lin < 0 || lin > 15);

				do {
					imprimir("Informe a coluna: \n");
					col = leitura.nextInt();
					if (col < 0 || col > 15) {
						imprimir("Escolha números entre 0 e 15.\n");
					}
				} while (col < 0 || col > 15);
				
				if ((tabuleiro[lin][col] != '_') && ((lin >= 0 && lin < 16) && (col >= 0 && col < 16))) { 
					imprimir("Esse campo já foi informado ou automaticamente descartado!\n");
				} //Caso o usuário digite um número fora do intervalo de 0 a 15, aparecerá essa frase. 

            } while (tabuleiro[lin][col] != '_');
            
			if (minas[lin][col] == -1) { //Se pisar numa mina, o jogo encerra.
				encerrar = true;
			} 
			if (encerrar == false){
				mostrarVizinhas(minas, tabuleiro, lin, col);
				vencedor = vencer(tabuleiro, lin, col);
			}

		} while (encerrar == false && vencedor == false); 
		//Essa repetição irá ocorrer até que o jogador pise em uma mina ou termine o jogo sem pisar em nenhuma menia(vencendor).
		
		
		
		
		if(vencedor == false){
			imprimir("BOOOOOOOOOOOOOOOOMMMMMMMMMMMMM!!! Você perdeu!\n");
			imprimirTabJogo(mostrarMinas(minas, tabuleiro));
		} else {
			imprimir("PARABÉNS, você em "+jogada+" jogadas não clicou nos 40 campos de minas.\n");
			imprimirTabJogo(mostrarMinas(minas, tabuleiro));
		}
	}

	//Gera o tabuleiro do jogo que será visualizado pelo jogador
	public static void tabJogo(char[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				tab[i][j] = '_'; 
			}
		}
	}

	//Gera o tabuleiro virtual onde será alocado as minas
	public static void tabMinas(int[][]tabMinas) {
		for (int i = 0; i < tabMinas.length; i++) {
			for (int j = 0; j < tabMinas.length; j++) {
				
			}
		}
			
		distribuirMinas(tabMinas);
		atribuirDicas(tabMinas);
	}
	


	//Distribui as minas sobre o tabuleiro 'tabMinas'
	public static void distribuirMinas(int[][]tabMinas) {
		int lin, col, minas=0, qtdMinasEmCampo = 40;
        Random rd = new Random();
        
        //Essa variável é o controlador do laço de repetição
        boolean minaPos = false;
        
		while (minas < qtdMinasEmCampo) {	
			
			do {
                //Essas duas linhas fazem o sorteio da linha e coluna
				lin = rd.nextInt(16); 
                col = rd.nextInt(16);
                
                //Checa que se na posição sorteada já tem uma mina
				if (tabMinas[lin][col] == -1) {
					minaPos = false;
				} else {
					minaPos = true;
                }
                //se minaPos for igual a -1, significa que naquela posição já tem uma mina
			} while (minaPos == false);
			
			tabMinas[lin][col] = -1;
			minas++;
			
		}
	}

	//Atribui as dicas das minas sobre o tabuleiro 'tabMinas'
	public static void atribuirDicas(int[][]tabMinas){
		for (int lin = 0; lin < 16; lin++) {
			for (int col = 0; col < 16; col++) {

                //Com base na posição de uma mina eu parto para atribuir as dicas
				if (tabMinas[lin][col] == -1) {
                    //Eu sempre verifico com base nas extremidades do tabuleiro
					if (lin == 0 && col == 0) {
						tabMinas[lin][col+1] += 1;
						tabMinas[lin+1][col] += 1;
						tabMinas[lin+1][col+1] += 1;
					} else if (lin == 15 && col == 0) {
						tabMinas[lin][col+1] += 1;
						tabMinas[lin-1][col] += 1;
						tabMinas[lin-1][col+1] += 1;
					} else if (lin == 0 && col == 15) {
						tabMinas[lin+1][col] += 1;
						tabMinas[lin][col-1] += 1;
						tabMinas[lin+1][col-1] += 1;
					} else if (lin == 15 && col == 15) {
						tabMinas[lin-1][col] += 1;
						tabMinas[lin][col-1] += 1;
                        tabMinas[lin-1][col-1] += 1;
                    //com base na linha eu utilizo a primeira linha e a ultima como delimitador    
					} else if (lin == 0) {
                        //se a posição já tiver uma dica ela a incrementa
						tabMinas[lin][col-1] += 1;
						tabMinas[lin][col+1] += 1;
						tabMinas[lin+1][col] += 1;
						tabMinas[lin+1][col-1] += 1;
						tabMinas[lin+1][col+1] += 1;
					} else if ( lin == 15) {
						tabMinas[lin][col-1] += 1;
						tabMinas[lin][col+1] += 1;
						tabMinas[lin-1][col] += 1;
						tabMinas[lin-1][col-1] += 1;
						tabMinas[lin-1][col+1] += 1;
					} else if (col == 0) {
						tabMinas[lin-1][col] += 1;
						tabMinas[lin+1][col] += 1;
						tabMinas[lin][col+1] += 1;
						tabMinas[lin+1][col+1] += 1;
						tabMinas[lin-1][col+1] += 1;
					} else if (col == 15) {
						tabMinas[lin-1][col] += 1;
						tabMinas[lin+1][col] += 1;
						tabMinas[lin][col-1] += 1;
						tabMinas[lin+1][col-1] += 1;
						tabMinas[lin-1][col-1] += 1;
					} else {
                        //Percorrendo o centro
						tabMinas[lin][col-1] += 1;
						tabMinas[lin][col+1] += 1;

						tabMinas[lin-1][col] += 1;
						tabMinas[lin+1][col] += 1;

						tabMinas[lin-1][col-1] += 1;
						tabMinas[lin-1][col+1] += 1;

						tabMinas[lin+1][col-1] += 1;
						tabMinas[lin+1][col+1] += 1;
					}
				}
			}
		}
	}

	//Mostra as minas ao final do jogo
	public static char[][] mostrarMinas(int[][]tabMinas, char[][]tab){
		for (int i = 0; i < 16; i++)
			for (int j = 0; j < 16; j++)
				if (tabMinas[i][j] == -1)
					tab[i][j] = '*';
		return tab;
	}
	

	

	//Ao selecionar um campo abre os campos aos lados mostrando as dicas atribuidas
	public static void mostrarVizinhas(int[][]tabMinas, char[][]tab, int linInf, int colInf) {
		int nivelAjuda = 2;
		for (int lin = 0; lin < nivelAjuda; lin++) {
            for (int col = 0; col < nivelAjuda; col++) {
                //checa se estoura a matriz ou se na posição não é um mina
                //Se passar de boa é feita a exibição dos espaços e dicas com limitador de 2 casas que é
                //o nível de ajuda pre definido
            	 if ((linInf != 15 && colInf != 15) && (tabMinas[linInf + lin][colInf + col] != -1)) {
	                    tab[linInf + lin][colInf + col] = Character.forDigit(tabMinas[linInf + lin][colInf + col], 16);
	                } else if ((linInf == 15 && colInf == 15) && (tabMinas[linInf - lin][colInf - col] != -1)) {
	                	tab[linInf - lin][colInf - col] = Character.forDigit(tabMinas[linInf - lin][colInf - col], 16);
	                } else if ((linInf < 15 && colInf == 15) && (tabMinas[linInf + lin][colInf - col] != -1)) {
	                	tab[linInf + lin][colInf - col] = Character.forDigit(tabMinas[linInf + lin][colInf - col], 16);
	                } else if ((linInf == 15 && colInf < 15) && (tabMinas[linInf - lin][colInf + col] != -1)) {
	                	tab[linInf - lin][colInf + col] = Character.forDigit(tabMinas[linInf - lin][colInf + col], 16);
	                }
				//Uso o forDigit para formatar um caracter para ser exibido.
			}
		}
	}
	
	

	//Retorna 'true' quando o jogador abre todas os campos sem acionar alguma bomba
	public static boolean vencer(char[][]tab, int lin, int col) {
		int cont = 0;
		for (lin = 0; lin < 16; lin++) {
			for (col = 0; col < 16; col++) {
				if(tab[lin][col] == '_') {
					cont++;
				}
			}
        }
        
        //Se todas as minas estão intáctas e o jogador conseguiu clickar em todos os espaços ele retorna
        //true e o cabra ganha o jogo.
		if(cont == 40) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void imprimir(String txt) {//Método de impressão simples.
		System.out.print(txt);
	}

	//Imprime a tabela do jogo
	public static void imprimirTabJogo (char[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.println();
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print(" " + tab[i][j] + " "); 
			}
		}
	}

	
	//Método de impressão da tabela do jogo virtual - contem as minas
	public static void imprimirTabMinas (int[][] tabMinas) {
		for (int i = 0; i < tabMinas.length; i++) {
			System.out.println();
			for (int j = 0; j < tabMinas[i].length; j++) {
				System.out.print(" " + tabMinas[i][j] + " "); 
			}
		}
	}

		
}
