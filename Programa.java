package br.ucsal;

import java.util.Random;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {// main � o m�todo de execu��o do programa. Tem como par�metro, um array do tipo String chamado de args (padr�o do JVM)
		
		obterPermissao(obterLogin(), obterSenhas());//Chamada do m�todo obterDados, tendo como par�metro o m�todo obterLogin e obterSenha.
	
	}

	
	public static String[] obterLogin() {//M�todo contendo o vetor de logings(Strings) v�lidos.
		String[] logins = { "fabia", "leonardo", "misael", "rubem", "thiago" };
		return logins;// retornando um vetor de Strings.
	}

	public static int[] obterSenhas() {//M�todo contendo o vetor de senhas(valores inteiros) v�lidas.
		int[] senhas = { 123, 456, 789, 321, 654 };
		return senhas;// retornando um vetor de de valores inteiros.
	}
	
	
	public static void obterPermissao(String[] logins, int[] senhas) {//M�todo obterDados tem dois par�metros
		
		Scanner ent = new Scanner(System.in);//Chamando a classe Scanner, nomeando-a de ent para pedir a entrada de dados do usu�rio.
		imprimir("Informe o login: \n");//acessando o m�todo imprimir para imprimir essa frase.
		String login = ent.next();//Pedindo que o usu�rio digite o login -- O uso do next(), � porque se trata de uma String a ser digitada.
		imprimir("Informe a senha: \n");//acessando o m�todo imprimir para imprimir essa frase.
		int senha = ent.nextInt();//Pedindo que o usu�rio digite o login -- O uso do nextInt(), � porque se trata de um dado inteiro a ser digitado.
		
		//Usando o for para percorrer os vetores logins e senhas, e comparando-os com os valores digitados pelo usu�rio.
		for (int i = 0; i < logins.length; i++) {//vai percorrer o vetor desde o �ndice 0 at� o �ltimo �ndice do vetor, atrav�s de um incremento.
			if (login.equals(logins[i]) && senha == senhas[i]) {//Se o login digitado for igual a algum login(elemento) do vetor logins e a senha digitada for igual a algumm senha(elemento) do vetor senhas, executar� o c�digo abaixo.
				imprimir("\nBem vindo usu�rio(a): " + login + "\n\n"); //Imprimindo a frase, bem vindo, usu�rio "fulano" com duas quebras de linha.
				menuJogos();//Chamando o m�todo menuJogos();
				
			}
			
			
		} 

	} 
	

	
	public static void menuJogos() {
		Scanner ent = new Scanner(System.in);
		imprimir("\nQual jogo gostaria de jogar? (valor inteiro de 1 a 4):\n" 
				+ "1 - Jogo da Forca;\n"//Acessando o m�todo imprimir() para imprimir essa frase pedindo para o usu�rio escolher o jogo.		
				+ "2 - Batalha Naval;\n" 
				+ "3 - Campo Minado.\n"
				+ "4 - Sair.\n");
				int escolha = ent.nextInt();
				
				switch (escolha) {//Usando o switch(estrutura de m�ltipla escolha) na vari�vel escolha.
				case 1:
					imprimir("\nBem vindo ao Jogo da Forca\n\n"); //Se o usu�rio, digitar 1, o usu�rio jogar� o Jogo da Forca.
					JogoForca.novoJogo();//O m�todo contido dentro dessa classe � est�tico, por isso, podemos acess�-lo sem ter que intanciar a classe.
					menuJogos();//Acessando o m�todo menuJogos() para depois de jogar o jogos, retornar para o menu.
					break; //Break para parar na escolha do n�mero 1.
				case 2:
					imprimir("\nBem vindo ao Batalha Naval\n"); //Se o usu�rio, digitar 2, o usu�rio jogar� o batalha naval.
					BatalhaNaval.novoJogo();//O m�todo contido dentro dessa classe � est�tico, por isso, podemos acess�-lo sem ter que intanciar a classe.
					menuJogos(); //Acessando o m�todo menuJogos() para depois de jogar o jogos, retornar para o menu.
					break;//Break para parar na escolha do n�mero 2.
				case 3:
					imprimir("\nBem vindo ao Campo Minado\n"); //Se o usu�rio, digitar 3, o usu�rio jogar� o campo minado.
					CampoMinado.novoJogo();//O m�todo contido dentro dessa classe � est�tico, por isso, podemos acess�-lo sem ter que intanciar a classe.
					menuJogos(); //Acessando o m�todo menuJogos() para depois de jogar o jogos, retornar para o menu.
					break;//Break para parar na escolha do n�mero 3.
				case 4:
					imprimir("At� a pr�xima.\n"); //Se o usu�rio, digitar 4, sair� do menu.
					break;//Break para parar na escolha do n�mero 4.
				}

	}
	
	
	public static void imprimir(String txt) {//M�todo para imprimir apenas textos
		System.out.print(txt);
	}


}