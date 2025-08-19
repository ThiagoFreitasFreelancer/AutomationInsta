<h1>

[Padrão Formatação de Código](/build/classes)

</h1>

<h3>Instrução de formatação de código backend e frontend</h3>

O IntelliJ IDEA é uma poderosa e popular ferramenta de desenvolvimento que facilita a formação de código de alta qualidade. Portanto, existem recursos da própria ferramenta que facilitam a automatiza a formatação do código com base nos padrões escolhidos pelo usuário.
O objetivo desse documento é orientar o usuário sobre as configurações necessárias para realizar a formatação do seu código de forma automática usando o IntelliJ IDEA.

## 1.	Como configurar o IntelliJ IDEA

Para preparar o seu ambiente de desenvolvimento de forma que a formatação do seu código possa ser de maneira automática, deve-se seguir os passos abaixo.

1.1. Importando as configurações para o IntelliJ IDEA

Acesse o menu File em sua IDEA -> Settings.

<center>
    <img src="./files_public/Format-1.PNG" width="auto;" alt=""/>
</center>


Na nova janela procure pela opção Editor -> Code Style.
<center>
    <img src="./files_public/Format-2.PNG" width="auto;" alt=""/>
</center>

No campo Scheme estará setado as configurações padrões do sistema, será necessário importar o padrão de formatação do núcleo de teste.

<center>
    <img src="./files_public/Format-3.PNG" width="auto;" alt=""/>
</center>

Clique na engrenagem ao lado do campo Scheme -> Import Scheme.

<center>
    <img src="./files_public/Format-4.PNG" width="auto;" alt=""/>
</center>

Escolha a opção IntelliJ IDEA Code Style XML.

<center>
    <img src="./files_public/Format-5.PNG" width="auto;" alt=""/>
</center>

Navegue em seu computador até o local onde estar o modelo de formatação do Núcleo de Teste, selecione o arquivo [Code-Format-NTCEPEDI.xml](./files_public/Code-Format-NTCEPEDI.xml) e clique em OK.

<center>
    <img src="./files_public/Format-6.PNG" width="auto;" alt=""/>
</center>

Na próxima tela, confirme novamente em OK, depois clique em Apply e OK na tela de Settings.

## 2.	Como utilizar a formatação automática no IntelliJ IDEA

Após importar o arquivo [Code-Format-NTCEPEDI.xml](./files_public/Code-Format-NTCEPEDI.xml) para o seu IntelliJ, basta seguir os passos abaixo para que seu código seja formatado. Vale lembrar que a ferramenta não irá fazer toda a formatação de forma automática, apenas algumas indentações serão feitas de forma automatizada.

### 2.1. Formatando todo o seu código usando o IntelliJ IDEA

Para formatar todo o seu código, basta selecionar todo o código e aplicar os comandos Alt Cmd + L no Mac ou Ctrl Alt L no Windows ou Linux.

<center>
    <img src="./files_public/Format-7.PNG" width="auto;" alt=""/>
</center>

<center>
    <img src="./files_public/Format-8.PNG" width="auto;" alt=""/>
</center>

### 2.2. Formatando parte do seu código usando o IntelliJ IDEA

Para formatar parte do seu código, basta selecionar o trecho de código desejado e aplicar os comandos Alt Cmd + L no Mac ou Ctrl Alt L no Windows ou Linux.



