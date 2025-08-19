
<h1 align="center">Test Automation</h1>

## 📋 Descrição do Projeto
<p>O projeto Test Automation surgiu da necessidade de automação dos testes de frontend dos projetos do CEPEDI para verificação de bugs e falhas de forma automatizada.</p>

## ⚙️ Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- IntelliJ
- Maven
- JDK 21
- Git
  <br/>

## 🔧 Instalação

### Instalação IntelliJ IDEA

_Windows - ( 32x/x64 )_

**PASSO 1:**  Baixar o Instalador
1. Acesse o site da [JetBrains](https://www.jetbrains.com/idea/download/?section=windows)
2. Na página, você verá a versão Community Edition. Certifique-se de que a aba
   Windows está selecionada e clique em Download.

**PASSO 2:** Executar a Instalação
1. Depois que o download terminar, abra o arquivo .exe que você baixou. O
   Windows pode pedir permissão de administrador para continuar; pode permitir.
2. Tela de Boas-Vindas: Apenas clique em "Next" (Avançar).
3. Local da Instalação: O instalador vai sugerir uma pasta. Não precisa mudar,
   apenas clique em "Next".
4. Caso queira, marque as opções sujeridas e depois clique em “Next”.
5. Menu Iniciar: Não precisa mudar nada aqui. Apenas clique em "Install"
   (Instalar).
6. Aguarde a instalação terminar. Quando acabar, pode marcar a caixa "Run IntelliJ
   IDEA Community Edition" e clicar em "Finish" (Concluir) para abrir o programa.

<br>

### Instalação Git

**PASSO 1:**  Baixar o Instalador
1. Acesse o site do [Git](https://git-scm.com/downloads)
2. Faça o download clicando em "Download for Windows" e depois em "Git for Windows/x64 Setup"


**PASSO 2:** Executar a Instalação
1. Depois que o download terminar, abra o arquivo ````.exe```` que você baixou.
2. Siga as instruções do próprio instalador e depois é só finalizar.

<br>

### Instalação Apache Maven
**PASSO 1:**  Baixar o Maven
1. Acesse o site do [Maven](https://maven.apache.org/download.cgi)
2. Procure pela seção "Files". Você verá uma lista de arquivos.
3. Clique no link que termina com ````-bin.zip````. Este é o arquivo que contém os binários
   (o programa pronto para usar). Por exemplo: ````apache-maven-3.9.8-bin.zip````.

**PASSO 2:**   Descompactar os Arquivos
1. O Maven não tem um instalador ````.exe````. Você simplesmente descompacta os arquivos em um local fixo no seu computador.
2. Recomendo criar uma pasta na raiz do seu disco ````C:\````, para guardar esse tipo de programa.
3. Abra o arquivo ````.zip```` que você baixou e extraia a pasta de dentro dele (ex: ````apachemaven-3.9.8````) para dentro de ````C:\````
4. . Ao final, você terá um caminho parecido com este: ````C:\apachemaven-3.9.8````

**PASSO 3:** Configurar as Variáveis de Ambiente do Maven
1. Na barra de pesquisa do Windows, digite "Variáveis de ambiente" e clique na opção "Editar as variáveis de ambiente do sistema".
2. Na seção "Variáveis do sistema", clique em "Novo..." para criar outra variável.
3. Coloque o nome da variável: ````M2_HOME````
4. No valor da variável: ````C:\apache-maven-3.9.8```` (use o caminho exato da pasta que você acabou de extrair).
5. Clique em “OK”
6. Agora, ainda na seção "Variáveis do sistema", procure pela variável Path, selecione-a e clique em "Editar..."
7. Na nova janela, clique em "Novo" e adicione a seguinte linha: ````%M2_HOME%\bin````
8. Essa linha usa a variável que você acabou de criar ````%M2_HOME%```` para
   encontrar a pasta bin dentro do Maven. É nessa pasta que está o comando mvn
   que usaremos.
9. Clique em "OK" em todas as janelas para fechar e salvar as configurações.

**PASSO 4:** Verificar a Instalação
1. Pesquise por cmd no menu Iniciar para abrir um Prompt de Comando.
2. Digite o comando ````mvn –version```` e pressione Enter
3. Se a instalação foi bem-sucedida, você verá uma mensagem mostrando a
   versão do Apache Maven, o caminho da instalação (Maven home) e a versão do
   Java que ele está usando

<br>

### Instalação JAVA JDK 21

**PASSO 1:**  Baixar a JDK
1. Faça o download da JDK conforme o seu Sistema, procure por Java SE
   development Kit no [Site da Oracle](https://www.oracle.com/br/java/technologies/downloads/)

**Passo 2:** Instalar a JDK
1. Após o download, abra o arquivo ````.exe```` que você baixou.
2. O instalador é bem simples. Na maoiria das vezes, você só precisa clicar em
   “Next” até o final, mantendo as opções padrão.
3. O instalador pode perguntar sobre a instalação do JRE (Java Runtime
   Environment) também. Pode confirmar e instalar.

**Passo 3:** Configurar as Variáveis de Ambiente
1. Na barra de pesquisa do Windows, digite "Variáveis de ambiente" e clique na
   opção "Editar as variáveis de ambiente do sistema".
2. Na janela que abrir, clique no botão "Variáveis de Ambiente...".
3. Na seção "Variáveis do sistema" (a de baixo), procure pela variável chamada
   "Path". Selecione-a e clique em "Editar..."
4. Clique em "Novo" e adicione o caminho para a pasta bin do JDK que você
   acabou de instalar. Geralmente, o caminho é: ````C:\ProgramFiles\Java\jdk-21\bin````.
5. Clique em "OK" em todas as janelas para salvar.

**Passo 4:** Verificar a instalação
1. Abra o "Prompt de Comando" (pesquise por cmd no menu Iniciar)
2. Digite o comando ````java -version```` e aperte Enter.
3. . Se a instalação deu certo, você verá uma mensagem mostrando a versão do
   Java que você instalou.

JDK Instruções:
Após o download é necessário configurar as variáveis de ambiente do seu sistema operacional incluído as devidas configurações. Consulte [aqui](https://www.devmedia.com.br/instalacao-e-configuracao-do-pacote-java-jdk/23749) a versão do seu SO e a mudanças que serão necessárias.


## ⚙ Padronização
Para uma melhor adequação do código e padronização, o time de Teste do CEPEDI deve seguir os padrões contidos no [Style Guide](STYLEGUIDE.md).


## 🛠 Tecnologias
As seguintes ferramentas foram usadas na construção do projeto:

- [Selenium](https://www.selenium.dev/)
- [Rest Assured](https://rest-assured.io/)
- [Java](https://www.java.com/pt-BR/)
- [Git](https://git-scm.com/)

<br/>

## 👨‍💻 Contribuição

Um super parabéns 👏 para esse time que faz a diferença e esse projeto acontecer.

<table>
  <tr>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/5-avatar.png" width="100px;" alt=""/><br /><sub><b>Josiane Novais</b></sub><br /><a href="http://gitlab.cepedi/josiane.novais" title="Perfil de Líder">👨‍🚀</a></td>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/1-avatar.png" width="100px;" alt=""/><br /><sub><b>Adriely Novais</b></sub><br /><a href="http://gitlab.cepedi/adriely.novais" title="Perfil de Tester">🚀</a></td>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/2-avatar.png" width="100px;" alt=""/><br /><sub><b>Evaniela Braga</b></sub><br /><a href="http://gitlab.cepedi/evaniele.braga" title="Perfil de Tester">🚀</a></td>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/3-avatar.png" width="100px;" alt=""/><br /><sub><b>Fabilone Santos</b></sub><br /><a href="http://gitlab.cepedi/fabilone.santos" title="Perfil de Tester">🚀</a></td>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/4-avatar.png" width="100px;" alt=""/><br /><sub><b>Jessica Amaral</b></sub><br /><a href="http://gitlab.cepedi/jessica.amaral" title="Perfil de Tester">🚀</a></td>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/9-avatar.png" width="100px;" alt=""/><br /><sub><b>Kayque Moreira</b></sub><br /><a href="http://gitlab.cepedi/kayque.moreira" title="Perfil de Tester">🚀</a></td>
  </tr>
  <tr>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/6-avatar.png" width="100px;" alt=""/><br /><sub><b>Marcus Bitencourt</b></sub><br /><a href="http://gitlab.cepedi/marcus.bitencourt" title="Perfil de Tester">🚀</a></td>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/7-avatar.png" width="100px;" alt=""/><br /><sub><b>Saadila Braga</b></sub><br /><a href="http://gitlab.cepedi/saadila.braga" title="Perfil de Tester">🚀</a></td>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/10-avatar.png" width="100px;" alt=""/><br /><sub><b>Thalles Cerqueira</b></sub><br /><a href="http://gitlab.cepedi/thalles.cerqueira" title="Perfil de Tester">🚀</a></td>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/11-avatar.png" width="100px;" alt=""/><br /><sub><b>Thiago Goncalves</b></sub><br /><a href="http://gitlab.cepedi/thiago.goncalves" title="Perfil de Tester">🚀</a></td>
    <td align="center"><img style="border-radius: 50%;" src="./files_public/8-avatar.png" width="100px;" alt=""/><br /><sub><b>Victor Goncalves</b></sub><br /><a href="http://gitlab.cepedi/victor.goncalves" title="Perfil de Tester">🚀</a></td>
  </tr>
</table>
<br/>

###  Visualização do README

```No VS Cod```

Para uma melhor visualização do README use a extensão [docs-markdown](https://marketplace.visualstudio.com/items?itemName=docsmsft.docs-markdown).

```No IntelliJ```

Por padrão a visualização é nativa da IDE.
###  Versões do README

[Português 🇧🇷](./README.md)

<p align="left"><img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/></p>
