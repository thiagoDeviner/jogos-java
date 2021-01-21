package br.ucsal;

import java.util.Random;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {// main é o método de execução do programa. Tem como parâmetro, um array do tipo String chamado de args (padrão do JVM)
		
		obterPermissao(obterLogin(), obterSenhas());//Chamada do método obterDados, tendo como parâmetro o método obterLogin e obterSenha.
	
	}

	
	public static String[] obterLogin() {//Método contendo o vetor de logings(Strings) válidos.
		String[] logins = { "fabia", "leonardo", "misael", "rubem", "thiago" };
		return logins;// retornando um vetor de Strings.
	}

	public static int[] obterSenhas() {//Método contendo o vetor de senhas(valores inteiros) válidas.
		int[] senhas = { 123, 456, 789, 321, 654 };
		return senhas;// retornando um vetor de de valores inteiros.
	}
	
	
	public static void obterPermissao(String[] logins, int[] senhas) {//Método obterDados tem dois parâmetros
		
		Scanner ent = new Scanner(System.in);//Chamando a classe Scanner, nomeando-a de ent para pedir a entrada de dados do usuário.
		imprimir("Informe o login: \n");//acessando o método imprimir para imprimir essa frase.
		String login = ent.next();//Pedindo que o usuário digite o login -- O uso do next(), é porque se trata de uma String a ser digitada.
		imprimir("Informe a senha: \n");//acessando o método imprimir para imprimir essa frase.
		int senha = ent.nextInt();//Pedindo que o usuário digite o login -- O uso do nextInt(), é porque se trata de um dado inteiro a ser digitado.
		
		//Usando o for para percorrer os vetores logins e senhas, e comparando-os com os valores digitados pelo usuário.
		for (int i = 0; i < logins.length; i++) {//vai percorrer o vetor desde o índice 0 até o último índice do vetor, através de um incremento.
			if (login.equals(logins[i]) && senha == senhas[i]) {//Se o login digitado for igual a algum login(elemento) do vetor logins e a senha digitada for igual a algumm senha(elemento) do vetor senhas, executará o código abaixo.
				imprimir("\nBem vindo usuário(a): " + login + "\n\n"); //Imprimindo a frase, bem vindo, usuário "fulano" com duas quebras de linha.
				menuJogos();//Chamando o método menuJogos();
				
			}
			
			
		} 

	} 
	

	
	public static void menuJogos() {
		Scanner ent = new Scanner(System.in);
		imprimir("\nQual jogo gostaria de jogar? (valor inteiro de 1 a 4):\n" 
				+ "1 - Jogo da Forca;\n"//Acessando o método imprimir() para imprimir essa frase pedindo para o usuário escolher o jogo.		
				+ "2 - Batalha Naval;\n" 
				+ "3 - Campo Minado.\n"
				+ "4 - Sair.\n");
				int escolha = ent.nextInt();
				
				switch (escolha) {//Usando o switch(estrutura de múltipla escolha) na variável escolha.
				case 1:
					imprimir("\nBem vindo ao Jogo da Forca\n\n"); //Se o usuário, digitar 1, o usuário jogará o Jogo da Forca.
					JogoForca.novoJogo();//O método contido dentro dessa classe é estático, por isso, podemos acessá-lo sem ter que intanciar a classe.
					menuJogos();//Acessando o método menuJogos() para depois de jogar o jogos, retornar para o menu.
					break; //Break para parar na escolha do número 1.
				case 2:
					imprimir("\nBem vindo ao Batalha Naval\n"); //Se o usuário, digitar 2, o usuário jogará o batalha naval.
					BatalhaNaval.novoJogo();//O método contido dentro dessa classe é estático, por isso, podemos acessá-lo sem ter que intanciar a classe.
					menuJogos(); //Acessando o método menuJogos() para depois de jogar o jogos, retornar para o menu.
					break;//Break para parar na escolha do número 2.
				case 3:
					imprimir("\nBem vindo ao Campo Minado\n"); //Se o usuário, digitar 3, o usuário jogará o campo minado.
					CampoMinado.novoJogo();//O método contido dentro dessa classe é estático, por isso, podemos acessá-lo sem ter que intanciar a classe.
					menuJogos(); //Acessando o método menuJogos() para depois de jogar o jogos, retornar para o menu.
					break;//Break para parar na escolha do número 3.
				case 4:
					imprimir("Até a próxima.\n"); //Se o usuário, digitar 4, sairá do menu.
					break;//Break para parar na escolha do número 4.
				}

	}
	
	
	public static void imprimir(String txt) {//Método para imprimir apenas textos
		System.out.print(txt);
	}


}