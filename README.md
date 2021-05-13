# Controle De Brassagem Automatizado

O Controle De Brassagem Automatizado, é um projeto desenvolvido com o objetivo de facilitar o processo de brassagem na produção de cerveja artesanal, deixando o procedimento mais automático e simples para o usuário.

## Processo de fabricação da cerveja artesanal

Antes de entendermos o funcionamento do projeto, precisamos estudar um pouco sobre as etapas do processo de fabricação de uma cerveja artesanal, e entender como cada um deles funciona.

Existem várias formas de se fazer cerveja artesanal, mas como todo alimento ou bebida, para sua produção são necessários alguns ingredientes principais:

 - Malte
- Água
- Lúpulo
- Levedura

Eles são misturados de acordo com algumas etapas que podem ser entendidas pelo fluxograma abaixo:

![Fluxograma Fabricação de cerveja](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/Fluxogramas/FluxogramasBrassagem.png)    
    
Pelo fato da fabricação da cerveja ter vários processos, nesse projeto vamos automatizar apenas 3 deles, sendo:

- Brassagem
- Filtragem e clarificação
- Fervura

Tendo isso em mente, podemos estudar um pouco mais afundo, e ver como funciona esses 3 processos de uma forma um pouco mais detalhada.

### Brassagem 

O processo de brassagem, ocorre logo após a moagem do malte, e consiste em adicionar o malte moído em uma panela de água com temperatura regulada, esse processo pode levar de 60 a 90 minutos para ser concluído, e pode ocorrer com rampas de temperatura (processo na qual o tanque mantém a temperatura em um valor determinado pelo usuário) em alguns intervalos de tempo. O fluxograma abaixo nos ajuda a compreender melhor o funcionamento desse processo:

![Fluxograma brassagem](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/Fluxogramas/FuncionamentoProcessoBrassagem.png)

### Filtragem e Clarificação

Nesse processo, o mosto (Resultado da mistura entre água e malte) é passado para uma outra panela, e começa a circular por um filtro, que será responsável por retirar as cascas dos grãos que ficaram no mosto, isso deixará a cerveja com uma coloração mais agradável e sem partículas grandes que não foram dissolvidas.

### Fervura

Após a filtragem e clarificação, entramos na etapa de fervura, essa etapa se baseia em elevar a temperatura do mosto e adicionar os Lúpulos em  alguns intervalos de tempo. Finalizada essa etapa, o mosto é levado para o processo de fermentação, o fluxograma a seguir mostra essa etapa de forma detalhada:

![Fluxograma fervura](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/Fluxogramas/FuncionamentoProcessoFervura.png)

Com todos as etapas já compreendidas, podemos fazer um fluxograma completo, com todos os processos envolvidos.

![Fluxograma completo](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/Fluxogramas/FluxogramaFuncionamentoBrassagem.png)

Agora que conhecemos os 3 processos que serão automatizados, podemos criar uma lógica para o controle dos mesmos. Analisando as 3 etapas, podemos concluir que a principal variável existente nesses processos é a **TEMPERATURA**, que deve ser controlada na **BRASSAGEM** e **FERVURA**. Sendo assim, precisamos criar alguma estratégia para que possamos manter a **TEMPERATURA** sempre no valor que desejarmos.

## Variáveis de processo

### Controle de temperatura

A lógica de controle de temperatura consiste básicamente em 3 elementos:

- Sensor: Responsável por ler a temperatura atual do tanque
- Controlador: Responsável por receber o valor da temperatura do sensor, compará-la com o valor desejado e enviar um comando para o atuador
- Atuador: Recebe o comando do controlador, e age físicamente no processo, modificando sua temperatura

Tendo isso em mente, os dispositivos escolhidos para realizar essas funções foram:

- Sensor (TT): Sensor de temperatura DS18B20
- Controlador (TIC): Raspberry Pi com módulo ControlBeer
- Atuador (Resistência): Resistência elétrica para panela

Além desses componentes principais, vamos precisar também de alguns outros auxiliares, sendo eles:

- Motor: Responsável por misturar os ingredientes (Apenas para o processo de BRASSAGEM)
- Relé (TY): Necessário para o acionamento da resistência

Com todos os instrumentos escolhidos, podemos criar um diagrama para auxiliar na visualização da lógica de controle de temperatura:

![Diagrama de controle de temperatura](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/Diagramas/DiagramaControleDeTemperatura.png)  

Diferentemente dos processos de brassagem e fervura, a **FILTRAGEM E CLARIFICAÇÃO**, não depende de um controle de temperatura do líquido na panela, mas sim, do seu fluxo na passagem pelo filtro, sendo assim, precisamos criar outra estratégia para que possamos transitar o mosto entre as panelas, e para realizar a passagem do líquido pelo filtro.

### Fluxo do líquido

Para realizarmos o fluxo do líquido entre as panelas, precisamos de mais alguns instrumentos, sendo eles:

- Motor: Auxilia a manter o mosto em movimento dentro da panela de filtragem e clarificação
- Bomba: Responsável por realizar o fluxo do líquido entre as panelas e atravéz do filtro
- Visor de vazão (FV): Necessário para analizarmos a coloração do mosto
- Válvulas de acionamento manual: Necessária para controlar o fluxo do mosto entre as panelas 

Dessa forma, o controle de fluxo do projeto será feito de acordo com o diagrama:

![Diagrama de controle de fluxo](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/Diagramas/DiagramaControleDeFluxo.png)


É importante ressaltar que, devido a grande quantidade de válvulas, não é possível controla-lás eletricamente por meio de um solenoide, pois não teriamos um controlador com a quantidade de saídas necessárias, por conta disso, o usuário terá de fazer esse controle manualmente.

Agora que sabemos como será o controle das váriaveis e todos os instrumentos que iremos utilizar, podemos juntar os dois diagramas criados anteriormente e criar um diagrama final do projeto.

![Diagrama final](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/Diagramas/DiagramasControleDeBrassagemAutomatizado.png)

## Componentes e ligações eletrônicas

Após identificarmos todos os instrumentos que iremos utilizar, precisamos de alguns componentes eletrônicos para que possamos acioná-los e controlá-los, sendo eles:

- Fonte 12V
- Módulo regulador de tensão 12V-5V LM2596
- Raspberry Pi 3 Model B
- 2x Sensores de temperatura DS18B20 
- 2x Resistores 4.7K Ohms
- 5x Módulos Relés
- Display Touch Nextion HDMI 1024x600

Tendo todos os componentes em mãos, podemos fazer as seguintes ligações:

![Esquema de ligações](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/Ligações%20eletrônicas/LigaçõesControleDeBrassagemAutomatizado.png)

Apesar do esquema acima ser bem simples, ele não foi utilizado no projeto, em seu lugar, foi utilizado um módulo Raspberry Pi chamado de Control Beer Pi.

![Control Beer Pi](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/Ligações%20eletrônicas/ControlBeerPi.jpg)

Esse módulo já é bem conhecido pelos cervejeiros, e nos auxilia muito por já conter um regulador de tensão 12V-5V, os resistores de 4.7k Ohms e borns para conexão, dessa forma, não precisamos de uma protoboard para fazermos a conexão.

O display nextion será a IHM do projeto, e será conectado diretamente ao Raspberry Pi por um cabo HDMI, e alimentado por um cabo USB, conectado também ao Raspberry.

## Lógica do projeto

Agora que sabemos todos os componentes que iremos utilizar, precisamos criar uma lógica para controlar todo o projeto, 












