# Controle de Brassagem Automatizado

O Controle de Brassagem Automatizado, é um projeto desenvolvido com o objetivo de facilitar o processo de brassagem na produção de cerveja artesanal, deixando o procedimento mais automático e simples para o usuário.

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
- Relé (TY): Necessário para o acionamento da resistência

Com todos os instrumentos escolhidos, podemos criar um diagrama para auxiliar na visualização da lógica de controle de temperatura:

![Diagrama de controle de temperatura](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/Diagramas/DiagramaControleDeTemperatura.png)  

Diferentemente dos processos de brassagem e fervura, a **FILTRAGEM E CLARIFICAÇÃO**, não depende de um controle de temperatura do líquido na panela, mas sim, do seu fluxo na passagem pelo filtro, sendo assim, precisamos criar outra estratégia para que possamos transitar o mosto entre as panelas, e para realizar a passagem do líquido pelo filtro.

### Fluxo do líquido

Para realizarmos o fluxo do líquido entre as panelas, precisamos de mais alguns instrumentos, sendo eles:

- Motor: Auxilia a manter o mosto em movimento dentro da panela
- Bomba: Responsável por realizar o fluxo do líquido entre as panelas e atravéz do filtro
- Visor de vazão (FV): Necessário para analisarmos a coloração do mosto
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

Agora que sabemos todos os componentes que iremos utilizar, precisamos criar uma lógica para controlar todo o projeto. Para esse projeto, separamos a lógica em 3 núcleos:

- Interface: É responsável pela interação com o usuário, será exibida no IHM Nextion
- Scripts: São responsáveis pela lógica de controle de todo o sistema
- Status: Estruturado no formato JSON, é o arquivo que irá conter os estados de todos os componentes do sistema, e as configurações realizadas pelo usuário

### Interface

A Interface do projeto foi criada com a linguagem **JAVA**, juntamente com o pacote **SWING** para a criação dos Layouts. Com esse pacote importado, as classes Java podem ter um layout, dessa forma, podemos mudar o Layout da Interface apenas chamando uma outra classe. Nesse projeto, temos 4 classes Java, sendo elas:

- Interface.java: Tela inicial do sistema
- StatusController.java: Contém métodos para leitura do arquivo Status.json
- TelaBrassagemManual.java: Tela para brassagem de modo manual
- TelaNovaBrassagem.java: Tela de configuração de uma nova brassagem

#### StatusController.java

A classe StatusController é uma classe simples Java sendo a única no projeto que não utiliza o pacote Swing. Ela é responsável por **Ler e Escrever** no arquivo **Status.json**, através dos métodos **readStatus()**, **writeStatus()** e **resetStatus()**, podemos fazer isso a partir do pacote **org.json**, que foi importado para o projeto. A estrutura do arquivo **Status.json** foi criada da seguinte forma:

```
{
    "BrewStatus":"Pausado",
    "Bomb":false,
    "BrewMode":"Automatic",
    "Tank1":{
        "Ramps":[[0,0],[0,0]],
        "MaltAlert":false,
        "Temperature":0,
        "Motor":false,
        "NextProcess":false,
        "SetPoint":0,
        "ActualRamp":0,
        "Resistence":false
        },
    "Tank2":{
        "ClarificationTime":0,
        "Motor":false,
        "NextProcess":false
        },
    "Tank3":{
        "Temperature":0,
        "NextProcess":false,
        "Hops":[0,0,0],
        "BoilTime":0,
        "SetPoint":0,
        "Resistence":false,
        "HopAlert":false
        }
}
```

A implementação do método **readStatus()** é simples, só precisamos ler o arquivo Status.json com a classe **FileReader** do pocote java.io, converter para um tipo JSONObject, armazenar em uma variável e retorná-la. Essa implementação foi feita dentro de um LOOP while, isso nos permite fazer uma verificação de se a variável retornada está vazia, se ela estiver, acontece novamente a leitura. Esse tipo de erro pode ocorrer quando os scripts estiverem manipulando os dados do arquivo, dessa forma, o JSONObject não será retornado vazio, evitando um erro em outra parte do sistema.

```
public static JSONObject readStatus(){
    do{
        try {
            jsonParser = new JSONParser();
            jsonObject = new JSONObject(jsonParser.parse(new FileReader("../status.json")).toString());
        } catch (ParseException | IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }while(jsonObject.isEmpty());
            
    return jsonObject;
    }
```

O método **writeStatus()** foi implementado da seguinte forma, primeiro, utilizamos o método **readStatus()** da própria classe para lermos os estados atuais de Status.json e armazená-los em uma variável do tipo JSONObject, podendo assim manipular o JSON através do método **put()**. Após isso, criamos um objeto da classe **FileWriter**, contida no pacote java.io, e escrevemos o JSONObject no arquivo Status.json, através do método **write()**. É importante ressaltar também que foi utilizado um polimorfismo em **writeStatus()**, para que possamos escrever no JSON um objeto qualquer ou um JSONArray. Além disso, colocamos uma verificação do parâmetro tank em ambos os métodos, isso nos permite mudar as variáveis de um tanque, ou do projeto como um todo.

```
public static void writeStatus(String  tank, String target, Object value){
    try {
        if(tank != null){
            originalJson = readStatus();
            jsonObject = readStatus().getJSONObject(tank);
            jsonObject.put(target, value);
            originalJson.put(tank, jsonObject);
            System.out.println(jsonObject);
            writer = new FileWriter("../status.json");
                
            writer.write(originalJson.toString());
        }else{
            jsonObject = readStatus();
            writer = new FileWriter("../status.json");
            System.out.println(jsonObject);
            jsonObject.put(target, value);
            writer.write(jsonObject.toString());
        }
            
        writer.close();
    } catch (IOException ex) {
       ex.printStackTrace();
    }
}

public static void writeStatus(String  tank, String target, JSONArray value){
    try {
        if(tank != null){
            originalJson = readStatus();
            jsonObject = readStatus().getJSONObject(tank);
            jsonObject.put(target, value);
            originalJson.put(tank, jsonObject);
            System.out.println(jsonObject);
            writer = new FileWriter("../status.json");
                
            writer.write(originalJson.toString());
        }else{
            jsonObject = readStatus();
            writer = new FileWriter("../status.json");
            System.out.println(jsonObject);
            jsonObject.put(target, value);
            writer.write(jsonObject.toString());
        }
            
        writer.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
```

O método **resetStatus()** também foi implementado de forma simples, apenas criamos um novo JSONObject a partir de uma String que contém todos os valores do JSON setado em 0 ou false, a partir disso, escrevemos no Arquivo utilizando o **FileWriter** novamente 

```
public static void resetStatus(){
    try { 
        jsonObject = new JSONObject("{\"BrewStatus\":\"Pausado\",\"Tank3\":{\"Temperature\":0,\"NextProcess\":false,\"Hops\":[0,0,0],\"BoilTime\":0,\"SetPoint\":0,\"Resistence\":false,\"HopAlert\":false},\"Tank2\":{\"ClarificationTime\":0,\"Motor\":false,\"NextProcess\":false},\"BrewMode\":\"Automatic\",\"Tank1\":{\"Ramps\":[[0,0],[0,0]],\"MaltAlert\":false,\"Temperature\":0,\"Motor\":false,\"NextProcess\":false,\"SetPoint\":0,\"ActualRamp\":0,\"Resistence\":false},\"Bomb\":false}");

        writer = new FileWriter("../status.json");
        writer.write(jsonObject.toString());
        writer.close();
    } catch (IOException ex) {
        Logger.getLogger(StatusController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
}
```

#### Interface.java

O layout da tela inicial foi criado da seguinte forma:

![TelaInicial](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/ImagensDocumentacao/TelaInicial.png)

Para essa tela temos alguns componentes que são manipulados pela classe, são eles:

- Labels:

   - lblBomb: Mostra o estado da bomba
   - lblBrewStatus: Mostra o estado da brassagem (Pausado ou Em andamento)
   - lblParameter: Mostra a variável do tanque que está sendo exibida
   - lblResult: Mostra o valor da variável do tanque
   - lblStartStop: Muda o nome do botão btnStartBrew para INICIAR BRASSAGEM ou PAUSAR BRASSAGEM
   - lblTankNumber: Mostra qual é o tanque na qual as variáveis estão sendo exibidas

- Botões:

   - btnChangeMode: Chama a classe TelaBrassagemManual
   - btnEmergency: Reseta todas as variáveis do arquivo Status.json.
   - btnNewBrew: Chama a classe TelaNovaBrassagem
   - btnStartBrew: Inicia a lógica do projeto
   - btnTank1: Mostra os valores das váriaveis do tanque 1 nos labels lblResults
   - btnTank2: Mostra os valores das váriaveis do tanque 2 nos labels lblResults 
   - btnTank3: Mostra os valores das váriaveis do tanque 3 nos labels lblResults

Com todos os Botões e Labels já adicionados, precisamos implementar os métodos de cada botão para que as funções possam ser executadas quando pressionados.

Para os botões **btnChangeMode** e **btnNewBrew** foram adicionadas apenas funções que chamam uma outra classe, abaixo temos um exemplo dessa implementação:

```
private void btnNewBrewActionPerformed(java.awt.event.ActionEvent evt){                                           
    new TelaNovaBrassagem().setVisible(true);
    dispose();
    }
```

Nos botões **btnTank1**, **btnTank2**, **btnTank3** apenas mudamos o valor da variável **tankControled**, ela é responsável por armazenar o valor do tanque na qual as variáveis estão sendo exibidas na tela.

```
private void btnTank1ActionPerformed(java.awt.event.ActionEvent evt) {
    tankControled = 1;
}
```

No botão **btnEmergency**, chamamos o método **resetStatus()** da classe StatusController, dessa forma, todos os valores contidos em Status.json são resetados.

```
private void btnEmergencyActionPerformed(java.awt.event.ActionEvent evt){  
    new StatusController().resetStatus();
}
```

No Botão **btnStartBrew** criamos um objeto da classe StatusController e com o método **writeStatus()** mudamos o valor da váriavel **BrewStatus**, contida no em Status.json, para EM ANDAMENTO ou PAUSADO, isso vai depender do valor que estava contido anteriormente.

```
private void btnStartBrewActionPerformed(java.awt.event.ActionEvent evt) {                   
    status = new StatusController();
        
    if(brewStarted){
    status.writeStatus(null, "BrewStatus", "Pausado");
    lblBrewStatus.setText("PAUSADO");
    lblStartStop.setText("<html><center> INICIAR BRASSAGEM <center></html>");
    }else{
    status.writeStatus(null, "BrewStatus", "Em andamento");
    lblBrewStatus.setText("EM ANDAMENTO");
    lblStartStop.setText("<html><center> PAUSAR BRASSAGEM <center></html>");
    }
        
    brewStarted = !brewStarted;
}
```

Agora que nós ja temos todos os componentes e implementamos os métodos de todos os botões, precisamos fazer com que eles sejam atualizados constantemente, para sabermos os valores atuais das variáveis. Para isso, foi adicionada uma nova classe dentro da classe Interface.java, sendo ela a **TankController**, essa classe implementa as funções de uma interface java, chamada **ActionListener**, que foi importada para o projeto e contém o método abstrato **actionPerformed()**, esse método permite que todas as instruções contidas nele sejam executadas em LOOP, nos permitindo atualizar as variáveis em tempo real, abaixo podemos ver um exemplo para implementação da interface java **ActionListener**.

```
class TankController implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            //Instruções a serem executadas em LOOP

        } catch (InterruptedException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
```

Podemos agora implementar a função actionPerformed() com tudo que queremos executar em loop no nosso sistema. No nosso caso, vamos fazer a verificação da variável **tankControled**, e mostrar os valores das variáveis do tanque correspondente, além de verificar as variáveis **Alert** em Status.json, para que possamos mostrar um alerta na tela, avisando ao usuário que uma etapa da produção foi finalizada.

```
class TankController implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Thread.currentThread().sleep(1000);
            status = new StatusController();
            lblBomb.setText(booleanStatus(status.readStatus().getBoolean("Bomb")));

            if(status.readStatus().getJSONObject("Tank1").getBoolean("MaltAlert")){   //Verificação dos alertas
                JOptionPane.showMessageDialog(null, "ADICIONE O MALTE NA PANELA DE MOSTURAÇÃO!!!", "ATENÇÃO!!!", JOptionPane.WARNING_MESSAGE);
            }
            if(status.readStatus().getJSONObject("Tank3").getBoolean("HopAlert")){
                JOptionPane.showMessageDialog(null, "ADICIONE O LÚPULO NA PANELA DE FERVURA!!!", "ATENÇÃO!!!", JOptionPane.WARNING_MESSAGE);
            }
            if(status.readStatus().getJSONObject("Tank1").getBoolean("NextProcess")){
                JOptionPane.showMessageDialog(null, "ACIONE AS VÁVULAS PARA O PROCESSO DE CLARIFICAÇÃO!!!", "ATENÇÃO!!!", JOptionPane.WARNING_MESSAGE);
            }
            if(status.readStatus().getJSONObject("Tank2").getBoolean("NextProcess")){
                JOptionPane.showMessageDialog(null, "ACIONE AS VÁVULAS PARA O PROCESSO DE FERVURA!!!", "ATENÇÃO!!!", JOptionPane.WARNING_MESSAGE);
            }
            if(status.readStatus().getJSONObject("Tank3").getBoolean("NextProcess")){
                JOptionPane.showMessageDialog(null, "ACIONE AS VÁVULAS PARA O PROCESSO DE FERMENTAÇÃO!!!", "ATENÇÃO!!!", JOptionPane.WARNING_MESSAGE);
            }

            switch(tankControled){  //Verificação do tanque na qual deve exibir as variáveis 
                case 1:
                    lblTankNumber.setText("Tanque 1");

                    lblParameter1.setText("Temperatura:");
                    lblParameter2.setText("SetPoint:");
                    lblParameter3.setText("Resistência:");
                    lblParameter4.setText("Motor:");
                    lblParameter5.setText("Rampa atual:");

                    lblResult1.setText(Integer.toString(status.readStatus().getJSONObject("Tank1").getInt("Temperature")) + "ºC");
                    lblResult2.setText(Integer.toString(status.readStatus().getJSONObject("Tank1").getInt("SetPoint")) + "ºC");
                    lblResult3.setText(booleanStatus(status.readStatus().getJSONObject("Tank1").getBoolean("Resistence")));
                    lblResult4.setText(booleanStatus(status.readStatus().getJSONObject("Tank1").getBoolean("Motor")));
                     lblResult5.setText(Integer.toString(status.readStatus().getJSONObject("Tank1").getInt("ActualRamp")));
                     break;
                case 2:
                    lblTankNumber.setText("Tanque 2");

                    lblParameter1.setText("Motor:");
                    lblParameter2.setText("");
                    lblParameter3.setText("");
                    lblParameter4.setText("");
                    lblParameter5.setText("");

                    lblResult1.setText(booleanStatus(status.readStatus().getJSONObject("Tank2").getBoolean("Motor"));
                    lblResult2.setText("");
                    lblResult3.setText("");
                    lblResult4.setText("");
                    lblResult5.setText("");
                    break;
                case 3:
                    lblTankNumber.setText("Tanque 3");

                    lblParameter1.setText("Temperatura:");
                    lblParameter2.setText("SetPoint");
                    lblParameter3.setText("Resistência:");
                    lblParameter4.setText("");
                    lblParameter5.setText("");
                    lblResult1.setText(Integer.toString(status.readStatus().getJSONObject("Tank3").getInt("Temperature")) + "ºC");
                    lblResult2.setText(Integer.toString(status.readStatus().getJSONObject("Tank3").getInt("SetPoint")) + "ºC");
                    lblResult3.setText(booleanStatus(status.readStatus().getJSONObject("Tank3").getBoolean("Resistence")));
                    lblResult4.setText("");
                    lblResult5.setText("");
                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    private String booleanStatus(boolean status){
        if(status) return "LIGADO";
        else return "DESLIGADO";
    }
}
```

Depois de implementarmos o método, precisamos executá-lo, para isso precisamos importar a classe **Timer** do pacote Swing, e criarmos um objeto passando como parâmetro um objeto da classe **TankController**, após isso, chamamos o método **start()**.

```
Timer timer = new Timer(1000, new TankController());
timer.start();
```

#### TelaBrassagemManual.java

A TelaBrassagemManual fornece ao usuário a opção de controlar todo o sistema manualmente, seu layout foi criado da seguinte forma:

![TelaBrassagemManual](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/ImagensDocumentacao/TelaBrassagemManual.png)

Para esse layout, temos os seguintes componentes

- Labels

    - lblSetpointTank1: Mostra o SetPoint de temperatura do tanque 1
    - lblSetPointTank3: Mostra o SetPoint de temperatura do tanque 3
    - lblTempTank1: Mostra o valor atual da temperatura do tanque 1
    - lblTempTank3: Mostra o valor atual da temperatura do tanque 3
    - ledBomb: Mostra o estado da bomba
    - ledMotorTank1: Mostra o estado do motor do tanque 1
    - ledMotorTank2: Mostra o estado do motor do tanque 2

- Botões

    - btnAdSetpointTank1: Adiciona +1 ao Setpoint de temperatura do tanque 1
    - btnAdSetpointTank3: Adiciona +1 ao Setpoint de temperatura do tanque 3
    - btnSubSetpointTank1: Subtrai -1 ao Setpoint de temperatura do tanque 1
    - btnSubSetpointTank3: Subtrai -1 ao Setpoint de temperatura do tanque 3
    - btnBomb: Muda o estado da bomba
    - btnChangeMode: Chama a classe TelaInicial
    - btnEmergency: Reseta todas as variáveis do arquivo Status.json 
    - btnMotorTank1: Muda o estado do motor do tanque 1
    - btnMotorTank2: Muda o estado do motor do tanque 2

Para a brassagem manual, os botões **btnMotorTank1**, **btnMotorTank2** e **btnBomb** tem a função de mudar as variáveis contidas em Status.json de forma direta, então criamos uma variável para armazenar o estado de cada elemento a ser controlado, pegamos esse valor e o invertemos, depois passamos como parâmetro através do método **writeStatus()**. Para o usuário ter a informação do valor da variável, foi adicionado um ícone de ON/OFF em um label vazio, a imagem a ser exibida, depende do valor da variável.

```
private void btnBombActionPerformed(java.awt.event.ActionEvent evt) {                                        
        status = new StatusController();
        bombStatus =  !bombStatus;
        status.writeStatus(null, "Bomb", bombStatus);
        if(bombStatus){
            ledBomb.setIcon(ledON);
        }else{
            ledBomb.setIcon(ledOFF);
        }
```

Os botões **btnSubSetPointTank1**, **btnSubSetPointTank3**, **btnAdSetPointTank1** e **btnAdSetPointTank3**, foram implementados com uma lógica semelhante a dos botões citados anteriormente, sua única diferença é a de adicionar +1 ou subtrair -1 ao valor lido, e mostrá-lo no label correspondente.

```
private void btnAdSetpointTank1ActionPerformed(java.awt.event.ActionEvent evt) {     
        status = new StatusController();
        Tank1SetPointValue =  Tank1SetPointValue + 1;
        status.writeStatus("Tank1", "SetPoint", Tank1SetPointValue);
        lblSetpointTank1.setText(Integer.toString(Tank1SetPointValue)+"ºC");
}
```

Para podermos atualizar constantemente o valor de temperatura dos tanques, foi utilizada a mesma lógica de Interface.java, utilizando uma classe, dessa vez a TempControl,  que implementa a interface java ActionListener.

```
class TempControl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            status = new StatusController();
            lblTempTank1.setText(Integer.toString(status.readStatus().getJSONObject("Tank1").getInt("Temperature"))+ "ºC");
            lblTempTank3.setText(Integer.toString(status.readStatus().getJSONObject("Tank3").getInt("Temperature"))+ "ºC");
        }
       
    }
```

Para os botões **btnEmergency** e **btnChangeMode** foi utilizado as mesmas funções descritas em TelaInicial.

#### TelaNovaBrassagem.java

A classe TelaNovaBrassagem é responsável por adicionar as configurações feitas pelo usuário em Status.json, contém o seguinte layout:

![TelaNovaBrassagem](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/ImagensDocumentacao/TelaNovaBrassagem1.png)

E os seguintes componentes:

- Labels 
    
    - lblConfig: Mostra ao usuário qual parâmetro deve ser configurado
    - lblTarget: É o valor que o usuário deseja para o parâmetro que está configurando

- Botões

    - btnBottomArrow: Subtrai -1 ao valor que o usuário está configurando
    - btnTopArrow: Adiciona +1 ao valor que o usuário está configurando
    - btnNext: Adiciona o valor configurado ao Status.json, e muda o parâmetro a ser configurado
    - btnCancel: Chama a classe TelaInicial

Nos botões **btnBottomArrow** e **btnTopArrow** foi adicionada uma lógica para o controle da variável **targetValue**, ela é responsável por armazenar o valor que está sendo exibido em lblTarget, e o usuário a manipula através dos botões, adicionando-a ou subtraindo-a o valor 1.

```
private void btnBottomArrowActionPerformed(java.awt.event.ActionEvent evt) {   
    targetValue--;
    lblTarget.setText(Integer.toString(targetValue));
}                                              

private void btnTopArrowActionPerformed(java.awt.event.ActionEvent evt) {    
    targetValue++;
    lblTarget.setText(Integer.toString(targetValue));
}
```

É no botão **btnNext** que toda a lógica para adicionarmos os dados em Status.json está contida, para fazermos isso, utilizamos novamente os métodos **readStatus()** e **writeStatus()** contidos em StatusController. Para controlarmos qual parâmetro deve ser configurado, foi criada a variável **config**, ela armazena um valor inteiro, e através de um switch, adicionamos o valor no Status.json e mudamos os valores de lblConfig para o próximo parâmetro a ser configurado.

```
private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {
    config = 0;                         //No código original, os atributos foram declarados no início
    actualRamp = 1;
    actualHop = 1;
    targetValue = 0;
    target1Value = 0;
    allRampsArray  = new JSONArray();
    allHopsArray  = new JSONArray();
    actualRampArray = new JSONArray();

    status = new StatusController();
        
    switch(config){
        case 0:
            status.writeStatus("Tank1", "SetPoint", targetValue);
            lblConfig.setText("Quantidade de rampas: ");
            lblUnidTarget.setVisible(false);
            setTargetsValues(0,0);
            config++;
            break;
        case 1:
            rampsNumber =  targetValue;
            lblConfig.setText("Temperatura rampa 1:");
            lblUnidTarget.setVisible(true);
            lblConfig1.setText("tempo rampa 1:");
            setSecondConfigVisible(true);
            setTargetsValues(0,0);
            config++;
            break;
        case 2:
            actualRampArray.add(Integer.parseInt(lblTarget.getText()));
            actualRampArray.add(Integer.parseInt(lblTarget1.getText()));
            allRampsArray.add(actualRampArray);
            rampsNumber--;
            actualRamp++;
            lblConfig.setText("Temperatura rampa " + Integer.toString(actualRamp) + ":");
            lblConfig1.setText("tempo rampa "+ Integer.toString(actualRamp) + ":");
            setTargetsValues(0,0);
            if(rampsNumber ==  0){
                status.writeStatus("Tank1", "Ramps", allRampsArray);
                setSecondConfigVisible(false);
                lblConfig.setText("Tempo de clarificação:");
                lblUnidTarget.setText("min");
                config++;
            }
            break;
        case 3:
            status.writeStatus("Tank2", "ClarificationTime", Integer.parseInt(lblTarget.getText()));
            setTargetsValues(0,0);
            lblConfig.setText("Temperatura de fervura:");
            lblUnidTarget.setText("ºC");
            config++;
            break;
        case 4:
            status.writeStatus("Tank3", "SetPoint", Integer.parseInt(lblTarget.getText()));
            setTargetsValues(0,0);
            lblConfig.setText("Tempo de fervura:");
            lblUnidTarget.setText("min");
            config++;
            break;
        case 5:
            status.writeStatus("Tank3", "BoilTime", Integer.parseInt(lblTarget.getText()));
            setTargetsValues(0,0);
            lblConfig.setText("Quantidade de Lúpulos: ");
            lblUnidTarget.setVisible(false);
            config++;
            break;
        case 6:
            hopsNumber = targetValue;
            lblConfig.setText("Tempo do 1º Lúpulo:");
            lblUnidTarget.setVisible(true);
            setTargetsValues(0,0);
            config++;
            break;
        case 7:
            allHopsArray.add(Integer.parseInt(lblTarget.getText()));
            hopsNumber--;
            actualHop++;
            lblConfig.setText("Tempo do " + Integer.toString(actualHop) + "º  Lúpulo:");
            setTargetsValues(0,0);
            if(hopsNumber == 1){
                lblNext.setText("FINALIZAR");
            }
            if(hopsNumber == 0){
                status.writeStatus("Tank3", "Hops", allHopsArray);
                new Interface().setVisible(true);
                dispose();
            }
            break;
        case 8:
            break;
    }   
}
```

No botão **btnCancel**, apenas chamamos a classe Interface.java, como ja foi feito anteriormente em outros métodos.


### Scripts

Os Scripts são responsáveis por controlar a GPIO do Raspberry Pi, através da linguagem python, no total, existem 4 Scripts.

- BrewControler: Script principal, contém toda a lógica de funcionamento da brassagem
- GPIOController: Contém uma classe para controle da GPIO
- TemperatureSensorsController: Contém uma classe para controle dos sensores de temperatura DS18B20
- StatusController: Contém métodos para leitura do arquivo Status.json

#### StatusController.py

Nesse arquivo, temos alguns métodos para a leitura do arquivo Status.json, já explicado anteriormente, esses métodos são novamente **readStatus()**, **writeStatus()** e **resetStatus()**, eles contém a mesma lógica dos métodos contidos na classe StatusController.java da interface.

```
path = '../status.json'

def readStatus():                
    file = open(path, 'r')
    sleep(0.25)
    return json.load(file)

def writeStatus(tank, target, value):
    status = readStatus()
    sleep(0.25)
    if tank == None:
        status[target] = value
    else:
        status[tank][target] = value
    file = open(path, 'w')
    json.dump(status, file)

def resetStatus():
    defaultStatus = {'BrewStatus':'Pausado','Tank3':{'Temperature':0,'NextProcess':False,'Hops':[0,0,0],'BoilTime':0,'SetPoint':0,'Resistence':False,'HopAlert':False},'Tank2':{'ClarificationTime':0,'Motor':False,'NextProcess':False},'BrewMode':'Automatic','Tank1':{'Ramps':[[0,0],[0,0]],'MaltAlert':False,'Temperature':0,'Motor':False,'NextProcess':False,'SetPoint':0,'ActualRamp':0,'Resistence':False},'Bomb':False}
    file = open(path, 'w')
    json.dump(defaultStatus, file)
    sleep(0.25)
```

#### GPIOController.py

Para controlarmos a GPIO do Raspberry Pi, precisamos importar para esse arquivo, a classe GPIO, contida na biblioteca Rpi, e a classe Buzzer da biblioteca gpiozero, para controlarmos o buzzer de maneira mais simples. Após isso criamos a classe **GPIOController**, no método construtor declaramos atributos para cada saída da GPIO que queremos controlar, e setamos cada uma delas como OUTPUT.

```
class GPIOController:
    def __init__(self):
        self.BOMB = 19
        self.MOTOR_1 = 13
        self.MOTOR_2 = 6
        self.RESISTENCE_1 = 5
        self.RESISTENCE_2 = 11
        self.BUZZER = 22

        GPIO.cleanup()
        os.system('modprobe w1-gpio')
        os.system('modprobe w1-therm')
        GPIO.setmode(GPIO.BCM)

        GPIO.setup(self.BOMB, GPIO.OUT)
        GPIO.setup(self.MOTOR_1, GPIO.OUT)
        GPIO.setup(self.MOTOR_2, GPIO.OUT)
        GPIO.setup(self.RESISTENCE_1, GPIO.OUT)
        GPIO.setup(self.RESISTENCE_2, GPIO.OUT)
        self.buzzer = Buzzer(self.BUZZER)
```

Após isso, implementamos os métodos Getters e Setters para cada saída, e pedimos como parâmetro um valor booleano e setamos a saída com True como HIGH e False como LOW, abaixo temos um exemplo dessa implementação

```
def setBomb(self, value):
        if value == True:
            GPIO.output(self.BOMB, GPIO.HIGH)
        else:
            GPIO.output(self.BOMB, GPIO.LOW)
```

O método para controle do Buzzer é um pouco diferente, pois temos a biblioteca, que nos permite apenas ligá-lo ou desligado, dessa forma, pedimos como parâmetro apenas o tempo em que o buzzer deve permanecer ligado

```
def buzzerBeep(self, secs):
        self.buzzer.on()
        sleep(secs)
        self.buzzer.off()
```

#### TemperatureSensorsController.py

Para fazermos o controle de temperatura do nosso sistema, precisamos ler o sensor DS18B20 através da comunicação OneWire, o sensor cria no Raspberry Pi, um arquivo no diretório **/sys/bus/w1/devices/**, precisamos então ler esse arquivo, apesar de parecer simples, é necessário fazer algumas configurações no Raspberry Pi, você pode aprender a fazer essas configurações no tutorial do link abaixo:

https://labprototipando.com.br/2020/06/22/como-utilizar-o-sensor-de-temperatura-ds18b20-no-raspberry-pi/

Com o Raspberry Pi configurado, podemos criar uma classe para a leitura do arquivo criado, e colocamos em seu construtor o diretório do arquivo, no nosso caso temos dois sensores, sendo assim 2 arquivos são criado em pastas diferentes. Utilizamos as bibliotecas **glob** e **os** para nos ajudar a encontrar os diretórios dos arquivos.

```
class TemperatureSensors:
    def __init__(self):
        os.system('modprobe w1-gpio')
        os.system('modprobe w1-therm')

        self.SENSORS_BASE_DIR = '/sys/bus/w1/devices/'

        self.DEVICE_1_FOLDER = glob.glob(self.SENSORS_BASE_DIR + '28*')[0]
        self.DEVICE_1_FILE = self.DEVICE_1_FOLDER + '/w1_slave'

        self.DEVICE_2_FOLDER = glob.glob(self.SENSORS_BASE_DIR + '28*')[1]
        self.DEVICE_2_FILE = self.DEVICE_2_FOLDER + '/w1_slave'
```

Tendo os diretórios dos arquivos, podemos ler, filtrar as informações irrelevantes, e retornar a temperatura lida como um número inteiro.

```
def getTank1Sensor(self):
        try:
            f = open(self.DEVICE_1_FILE, 'r')
            lines = f.readlines()
            f.close()
            address, temp = lines[1].split('t=')
        except:
            pass

        return round(int(temp)/1000,1)
```


#### BrewController.py

O Arquivo BrewController.py é o principal do sistema, é nele que está contida toda a lógica de funcionamento do projeto, e é o arquivo que deve ser executado pelo usuário. Esse arquivo executa 2 Threads de processamento, através da classe **Thread** da biblioteca **Threading**, sendo elas:

- startInterface: Inicia a interface do projeto
- statusSync: Coloca os estados da saída da GPIO de acordo com os estados contidos em Status.json
- brew: Contem a lógica de funcionamento do projeto

Cada thread corresponde a um método do arquivo, e conseguimos executá-las da seguinte forma:

```
Thread(target=statusSync).start()
Thread(target=brew).start()
```

Com isso, os 2 métodos serão executados em paralelo, melhorando o desempenho do projeto.

Na thread **statusSync**, nós setamos todas as saídas da GPIO, através da classe GPIOController, de acordo com os valores contidos em Status.json, além de adicionar ao JSON a temperatura atual de cada tanque. Também foi implementado nessa Thread, a lógica para o **controle de temperatura** no **modo manual**. 

```
def statusSync():
    tempTank1, tempTank3, lastTempTank1, lastTempTank3 = (0,0,0,0)
    while True:
        try:
            tempTank1 = int(temperatureSensors.getTank1Sensor())
            tempTank3 = int(temperatureSensors.getTank3Sensor())
            if tempTank1 != lastTempTank1:
                StatusController.writeStatus('Tank1', 'Temperature', temperatureSensors.getTank1Sensor())
            
            if tempTank3 != lastTempTank3:
                StatusController.writeStatus('Tank3', 'Temperature', temperatureSensors.getTank3Sensor())

            lastTempTank1 = tempTank1
            lastTempTank3 = tempTank3

            gpioController.setBomb(StatusController.readStatus()['Bomb'])
            gpioController.setMotor1(StatusController.readStatus()['Tank1']['Motor'])
            gpioController.setMotor2(StatusController.readStatus()['Tank2']['Motor'])
            gpioController.setResistence1(StatusController.readStatus()['Tank1']['Resistence'])
            gpioController.setResistence2(StatusController.readStatus()['Tank3']['Resistence'])

            status = StatusController.readStatus()  

            if status['BrewMode'] == 'Manual': 
                if status['Tank1']['Temperature'] < status['Tank1']['SetPoint']:
                    StatusController.writeStatus('Tank1', 'Resistence', True)
                else:
                    StatusController.writeStatus('Tank1', 'Resistence', False)

            if status['BrewMode'] == 'Manual':
                if status['Tank3']['Temperature'] < status['Tank3']['SetPoint']:
                    StatusController.writeStatus('Tank3', 'Resistence', True)
                else:
                    StatusController.writeStatus('Tank3', 'Resistence', False)
            
            print(tempTank1)
            print(tempTank3)
        except:
            pass
```

Como já mencionado anteriormente, a thread **brew()** contém a lógica de todo o sistema, e ela é baseada no fluxograma que explica o funcionamento dos 3 processos que serão automatizados, já vistos anteriormente, e vamos analisá-la por partes. Primeiramente, ela inicia um LOOP, na qual faz a verificação de BrewStatus em Status.json, se o valor retornado for igual a EM ANDAMENTO, inicia-se toda a lógica dos processos, **ligando o motor 1** e **regulando a temperatura do tanque 1** para a **adição do malte**.

```
def brew():
    gpioController.buzzerBeep(0.5)
    while True:
        try:
            sleep(1)
            print('Lendo Status')
            status =  StatusController.readStatus()
            if status['BrewStatus'] ==  'Em andamento' and status['BrewMode'] == 'Automatic':
                gpioController.buzzerBeep(0.5)
                StatusController.writeStatus('Tank1', 'Motor', True)
                print('Motor 1 ligado')
                temperature  =  status['Tank1']['Temperature']
                setPoint = status['Tank1']['SetPoint']

                while temperature < setPoint:
                    print('Setpoint')
                    StatusController.writeStatus('Tank1', 'Resistence', True)
                    temperature  =  StatusController.readStatus()['Tank1']['Temperature']
```

Com a temperatura regulada, a resistência do tanque 1 é desligada, e é setado o valor **MaltAlert** do JSON como **True**, para que a **Inteface** possa **mostrar um alerta** na tela do IHM e o usuário adicionar o malte na panela. Depois, entramos na etapa das rampas de temperatura, para isso, temos o array **Ramps** do JSON, dentro dele vamos armazenar outros arrays, que contém 2 posições, sendo a **primeira** o **SetPoint de temperatura**, e a **segunda** o **tempo da rampa** em minutos. Desse modo, podemos ler o array e armazenar em uma variável o SetPoint de temperatura, podendo assim regula-lá. Para conseguirmos executar a rampa no tempo desejado, utilizamos a função **time()** da biblioteca **time**, ela nos permite pegar o valor do tempo atual, dessa forma, podemos somá-lo com o tempo da rampa, contido na segunda posição dos arrays, e armazená-lo na variável **endTime**, assim temos o tempo em que a rampa irá finalizar, podemos então executar a rampa enquanto o valor do tempo atual **time()** for menor que o tempo de finalização da rampa **endTime**, quando o valor de **time()** for igual ou maior que **endTime**, a rampa é finalizada. 

```
                StatusController.writeStatus('Tank1', 'Resistence', False)
                gpioController.buzzerBeep(0.5)
                StatusController.writeStatus('Tank1', 'MaltAlert', True)
                print('Adicionar malte')
                sleep(0.5)
                StatusController.writeStatus('Tank1', 'MaltAlert', False)
                sleep(0.5)

                actualRamp = 1
                for malt in status['Tank1']['Ramps']:
                    gpioController.buzzerBeep(0.5)
                    print('Rampa ', actualRamp)
                    StatusController.writeStatus('Tank1', 'ActualRamp', actualRamp)
                    StatusController.writeStatus('Tank1', 'SetPoint', malt[0])
                    temperature  =  StatusController.readStatus()['Tank1']['Temperature']
                    setPoint = malt[0]
                    endTime = time() + malt[1]*60

                    while time() < endTime:
                        if temperature < setPoint:
                            StatusController.writeStatus('Tank1', 'Resistence', True)
                        else:
                            StatusController.writeStatus('Tank1', 'Resistence', False)

                        temperature = StatusController.readStatus()['Tank1']['Temperature']

                    actualRamp+=1
```

Com todas as rampas realizadas, podemos desligar a resistência e o motor 1, além de setar o valor **NextProcess** como **True**, para fazer com que a Interface mostre um alerta na tela do IHM, avisando o usuário para fazer a transição do mosto para outra panela, abrindo as válvulas necessárias. Após isso a bomba e o motor 2 são ligados e o sistema entra em um **sleep()** para a **clarificação**, o tempo de sleep será dado pelo valor contido em **ClarificationTime** no JSON, dado também em minutos e configurado pelo usuário anteriormente.

```
                StatusController.writeStatus('Tank1', 'Motor', False)
                StatusController.writeStatus('Tank1', 'Resistence', False)
                gpioController.buzzerBeep(0.5)
                StatusController.writeStatus('Tank1', 'NextProcess', True)
                StatusController.writeStatus(None, 'Bomb', True)
                print('Bomba Ligada')
                print('Proximo processo')
                sleep(0.35)
                StatusController.writeStatus('Tank1', 'NextProcess', False)

                StatusController.writeStatus('Tank2', 'Motor', True)
                print('Motor 2 ligado, Clarificação')
                sleep(StatusController.readStatus()['Tank2']['ClarificationTime']*60)
```

Finalizada a etapa de clarificação, setamos o **NextProcess** como True, avisando o usuário para fazer a transição do mosto para o tanque 3, entramos então na etapa de **fervura**. Para fazermos a fervura, precisamos ler dois tipos de dados em Status.json, o **BoilTime**, que contém o tempo de fervura, e o Array **Hops**, que contém o tempo de adição de cada lúpulo. Para controlarmos o tempo de fervura, foi utilizada a mesma lógica das rampas de temperatura no tanque 1, comparando o retorno de **time()** e comparando-o com a variável **boilTime**, resultado da soma do valor contido em **BoilTime** e **time()**. Para o tempo de cada lúpulo, lêmos um valor contido no array **hops** e somamos com o valor de **clock**, essa variável contém o tempo de início da fervura dada por **time()** no ínicio do código, após isso, comparamos esse valor, com o tempo atual, dado também por **time()**.


```
                gpioController.buzzerBeep(0.5)
                StatusController.writeStatus('Tank2', 'NextProcess', True)
                print('Proximo processo')
                sleep(0.5)
                StatusController.writeStatus('Tank2', 'NextProcess', False)
                StatusController.writeStatus('Tank2', 'Motor', False)

                status = StatusController.readStatus()
                print('status atual: ', status)
                temperature  =  status['Tank3']['Temperature']
                setPoint = status['Tank3']['SetPoint']
                boilTime = time() + (status['Tank3']['BoilTime']*60)
                clock = time()
                hops = status['Tank3']['Hops']

                while time() < boilTime:
                    print(hops)
                    if temperature < setPoint:
                        StatusController.writeStatus('Tank3', 'Resistence', True)
                    else:
                        StatusController.writeStatus('Tank3', 'Resistence', False)

                    if len(hops) != 0 and time() >= clock + (hops[0]*60):
                        hops.pop(0)
                        print('Adicionar Lupulo')
                        gpioController.buzzerBeep(0.5)
                        StatusController.writeStatus('Tank3', 'HopAlert', True)
                        sleep(0.4)
                        StatusController.writeStatus('Tank3', 'HopAlert', False)
                
                    temperature = StatusController.readStatus()['Tank3']['Temperature']
```

Com o término da fervura, avisamos o usuário novamente através de **NextProccess**, setamos **BrewStatus** como **Pausado**, **bomba** como **False** e finalizamos a brassagem.

```
                gpioController.buzzerBeep(0.5)
                StatusController.writeStatus('Tank3', 'NextProcess', True)
                print('Proximo processo')
                StatusController.writeStatus(None, 'BrewStatus', 'Pausado')
                StatusController.writeStatus(None, 'Bomb', False)
                sleep(0.5)
                StatusController.writeStatus('Tank3', 'NextProcess', False)
                sleep(15)
```

## Execução

Para podemos rodar o projeto ao dar boot no Raspberry Pi, devemos fazer algumas configurações. Precisamos primeiro, criar uma pasta **autostart** no diretório **.config**, e criarmos um arquivo **.desktop** dentro dessa pasta.

```
mkdir /home/pi/.config/autostart
nano /home/pi/.config/autostart/BrewController.desktop
```

Ao executarmos o comando **nano**, o Raspberry Pi irá abrir um editor de texto, e nele deve ser escrito o seguinte comando:

```
[Desktop Entry]
Type=Application
Name=Clock
Exec=sudo python3 /home/pi/BrewController.py
```

Note que em Exec, devemos utilizar o comando **sudo python3** juntamente com o diretório do arquivo **BrewController.py**.

Além de configurarmos o BrewController, precisamos também, iniciar a **Interface.java**, que deve ser executada junto com BrewController.py, e podemos configurá-la da mesma forma:

```
nano /home/pi/.config/autostart/BrewController.desktop
```

Dentro do arquivo:

```
[Desktop Entry]
Type=Application
Name=Clock
Exec=sudo java -jar /home/pi/Interface.jar
```

## Considerações finais

Trabalhei nesse projeto por 5 meses, não diretos, e sua realização foi muito divertida, e pude adquirir muitos conhecimetos com a realização dele, que ainda apesar de rodar, apresenta logs de erros da Interface, eles não interferem no processo, mas podem causar algum bug. Por ser um projeto um pouco complexo, podem ter havido implementações que simplesmente não foram feitas, peço pra que se encontrar alguma delas, crie uma issue nesse repositório, ou até mesmo fazer a implementação e criar um pull request.

## Me faça uma doação!

Gostou do projeto? Me faça uma doação! Assim você me incentiva a aprender mais e criar novos projetos :smiley:

Você pode utilizar o App do seu banco para ler o QR Code abaixo, ou se preferir, utilizar minha chave pix:

:point_down::point_down:

0caf9f55-45dd-43a3-865c-70d005770ef7

![Donate](https://github.com/GabrielSirtoriCorrea/ControleDeBrassagemAutomatizado/blob/main/Planejamento/ImagensDocumentacao/donate.jpeg)