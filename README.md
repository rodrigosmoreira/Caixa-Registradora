# Caixa-Registradora

---

<h1 align="center">
    <img src="https://i.imgur.com/yE4G9XQ.png">
</h1>
<p align="center">
<b>Caixa registradora para ajudar a vendinha do Manoel</b>
</p>

## Tabela de Conteúdos

- [Sobre](#sobre)
- [Requisitos](#requisitos)
- [Build](#build)
- [Funcionalidades](#funcionalidades)

## Sobre
Projeto da materia de Programção Orientada a Objetos 2 no qual deve ser criado uma caixa registradora usando interface gráfica para ajudar Manoel.

Manoel é português no qual tem uma vendinha e vende tudo por peso, ele é um senhor já de 70 anos, e está acostumado com uma caixa registradora antiga, aquelas ainda a manivela que gera uma papeleta com tudo registrado, e quando tecla o = escreve na papeleta o total da venda.

## Requisitos
Necessario Java 8 ou superior e JavaFX 11 ou superior.

## Build
No Eclipse
* Botão direito no projeto -> Run As -> Run Configurations -> Arguments -> VM Arguments
* Copiar o conteúdo abaixo, adaptando para sua pasta onde esta a lib do JavaFX 11:
<pre>
 --module-path C:\java-libs\javafx-sdk\lib --add-modules=javafx.fxml,javafx.controls
</pre>

## Funcionalidades
- [Calcular Venda](#calcular-venda)
- [Cancelar Venda](#cancelar-venda)
- [Limpar Visor](#limpar-visor)
- [Gerar Registro de Vendas](#gerar-registro-de-vendas)

### Calcular Venda
Primeiro informe o peso do produto atravês do teclado ou dos botões e clique no botão Registrar ou a tecla Enter e depois repita o passo para o valor unitário do produto depois disso ira aparecer na tela o valor a ser pago.
* Observação: O programa aceita somente numeros com precisão de duas casas decimais
<h1 align="center">
    <img src="https://i.imgur.com/yLCSKoV.png">
</h1>

### Cancelar Venda
Durante o registro de venda e possivel cancelar a venda apertando o botão Cancelar ou a tecla Delete depois isso ira aparecer a confirmação na tela.
<h1 align="center">
    <img src="https://i.imgur.com/HvYX5t3.png">
</h1>

### Limpar Visor
Para limpar a tela aperte o botão Limpar ou a tecla BackSpace.

### Gerar Registro de Vendas
Para gerar o registro com todas as vendas e o total delas aperte o botão = ou a tecla = e depois disso será exibido na tela o registro e tambêm será salvo no arquivo "registros.txt" no projeto.

<h1 align="center">
    <img src="https://i.imgur.com/ZussUgl.png">
</h1>
<p align="center">
<b>Registro de vendas na tela</b>
</p>

<h1 align="center">
    <img src="https://i.imgur.com/CzvfKVs.png">
</h1>
<p align="center">
<b>Registro de vendas no arquivo .txt</b>
</p>
