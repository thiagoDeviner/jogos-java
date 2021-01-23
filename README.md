# Atividade Avaliativa - LPA – Jogos em Java

A atividade avaliativa corresponde ao desenvolvimento de jogos, com as regras definidas a seguir: 

1. Os jogos deverão ser desenvolvidos em equipe e o número de alunos por equipe será definido pelo professor em conformidade com os alunos. 
2. Os jogos devem ser construídos exclusivamente na linguagem Java para ser executado rio console da IDE do eclipse. Não será aceito qualquer tipo gráfico na construção dos jogos, apenas os resultados apresentados no console. Os jogos devem ser desenvolvidos de forma que qualquer pessoa possa executá-lo. 
3. Os jogos devem ser apresentados pelos alunos que fazem parte da equipe e os jogos devem estar funcionando corretamente (sem erro), de acordo com o que está definido na regra do jogo. 
4. Todos os alunos devem estar preparados para apresentar e responder aos questionamentos relacionados à lógica empregada, ao código desenvolvido e todas as estruturas utilizadas. 
5. O professor deverá indicar os alunos da equipe que irão apresentar os jogos, responder aos questiona mentos e demais retornos necessários.

## O que fazer: 
1) Inicialmente o usuário que irá executar o jogo deve se identificar, informando seu nome e um código de acesso. (uso do Scanner e Array). 

2) Em seguida será apresentado ao usuário um menu, com seu nome identificado no texto inicial, as opções dos jogos que poderá executar. São eles: (1) Jogo da Forca, (2) Batalha Naval, (3) Campo Minado e (4) Sair. 

3) O usuário deverá escolher um jogo de cada vez e ao finalizar o jogo, retornará ao menu e poderá optar por executar outro jogo ou finalizar a execução dos jogos. 

## 1. O Jogo da Forca 
O jogo da forca é um jogo em que o jogador tem que acertar qual é a palavra oculta, tendo como dica o número de letras definidas através de um traçado. A cada letra errada é desenhado uma parte do corpo do "enforcado" e a cada letra certa a posição do traço é substituída pela letra. Se o jogador conseguir adivinhar todas as letras da palavra antes de finalizar o desenho do "enforcado" ele ganha o jogo. O trabalho aqui é elaborar um jogo da forca em Java considerando passagem de parâmetro por valor, delegação de responsabilidade para os métodos e implementação correta da estratégia do jogo. Nesse caso utilize métodos para: 

a. Construir a forca e do enforcado 

b. Definir a palavra oculta 

c. Efetuar a jogada d. Validar a jogada

e. Efetuar a estratégia 

f. Identificar o vencedor / perdedor 


Na figura abaixo, pode-se observar a tela inicial do jogo quando executado.

<img src="/img/jogo-da-forca.PNG">
 

## 2. O Jogo Batalha Naval 
Batalha naval é um jogo de tabuleiro 10 x 10 onde dois jogadores têm que adivinhar os quadrados onde os navios estão escondidos. Ganha o jogo quem identificar todos os "barcos" do adversário primeiro. Nesse jogo cada jogador tem um tabuleiro (mínimo 02) pelo qual irão dispor todos os seus "barcos" em posições que dificulte o palpite do adversário. Os barcos não podem se sobrepor, o número de barcos é o mesmo para todos os jogadores. Após os barcos serem posicionados o jogo é iniciado e cada jogador propõe uma posição do tabuleiro do adversário alternadamente. Os tipos de barcos são: (1) porta-aviões (cinco quadrados), (2) navios-tanque (quatro quadrados), (3) contratorpedeiros (três quadrados) e (4) submarinos (dois quadrados). Os quadrados que compõem os barcos devem estar conectados e em fila reta. O trabalho aqui é elaborar um jogo batalha naval em _lava considerando passagem de parâmetro por valor, delegação de responsabilidade para os métodos e implementação correta da estratégia do jogo. Nesse caso utilize métodos para (https://rachacuca.com.br/jogos/batalha-naval/): 

a. Construir os tabuleiros 
b. Definir a posição de cada barco nos tabuleiros 
c. Efetuar a jogada 
d. Validara jogada 
e. Efetuar a estratégia 
f. Identificar o vencedor / perdedor

<img src="/img/tela-batalha-naval.PNG">
 

## 3. O Jogo Campo Minado 
Esse jogo foi inventado por Robert Donner em 1989, para ser jogado por um único jogador, e tem como objetivo revelar as minas distribuídas pelo tabuleiro, evitando que qualquer uma delas seja detonada. Cada quadrado do tabuleiro irá revelar se há uma mina ou não após receber um clique. Se o quadrado selecionado contiver uma mina, então o jogo acaba. Se, por outro lado, o quadrado não contiver uma mina poderá aparecer um valor indicando a quantidade de quadrados adjacentes que contêm minas ou nenhum número aparece. Neste caso, o jogo revela automaticamente os quadrados que se encontram adjacentes ao quadrado vazio, já que não podem conter minas. O jogador vence o jogo quando todos os quadrados que não tem minas forem revelados. (Fonte: httos://pt.wikipedia.org/wiki/Campo minado). 
Para essa atividade, considere um tabuleiro de tamanho 16 x 16 para ser distribuído as "minas'.

<img src="/img/campo-minado.PNG">
 

## Item e - Jogo da forca 
Nesse caso é como será apresentada a palavra oculta (pode a partir de um array de palavras que será escolhida aleatoriamente no início do jogo, uma palavra atribuída a uma variável manualmente fixada para o jogo, a palavra pode ser construída dinamicamente a partir de algum elemento como nome de países, estados, nomes próprios, etc...) e a quantidade de erros possíveis do usuário, pois um erro pode corresponder aos dois braços, os dois braços e as duas pernas, um único braço, etc.... (por exemplo, os dois braços serão apresentados de uma única vez quando ocorrer o erro ou será apresentado um braço do "boneco" de cada vez para cada erro?)

