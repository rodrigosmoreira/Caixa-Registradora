# Caixa-Registradora

---

<h1 align="center">
    <img src="https://i.imgur.com/pweqmwH.png">
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
- [Gerar Registro de Vendas](#gerar-registro-de-vendas)
- [Manual](#manual)

### Calcular Venda
O valor a ser pago é calculado atravês da multiplicação do peso e do valor unitario informado pelo usuario.
* Observação: O programa aceita somente numeros com precisão de duas casas decimais
<h1 align="center">
    <img src="https://i.imgur.com/GzXa4Iq.png">
</h1>

### Gerar Registro de Vendas
Exibe todas as vendas realizadas no programa desde seu uso inicial na tela e em um arquivo.

<h1 align="center">
    <img src="https://i.imgur.com/gViiEpq.png">
</h1>
<p align="center">
<b>Registro de vendas na tela</b>
</p>

<h1 align="center">
    <img src="https://i.imgur.com/tFuwkPF.png">
</h1>
<p align="center">
<b>Registro de vendas no arquivo .txt</b>
</p>

### Manual
Descreve a utilização do programa para o usuario.

<h1 align="center">
    <img src="https://i.imgur.com/SEYZVmM.png">
</h1>
<p align="center">
<b>Caminho do manual</b>
</p>

<h1 align="center">
    <img src="https://i.imgur.com/lFNINQm.png">
</h1>
<p align="center">
<b>Manual</b>
</p>
