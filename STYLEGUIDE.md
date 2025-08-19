<h1>

[STYLE](/build/classes)
[GUIDE](/build/classes)

</h1>

Este guia de estilo, é um documento que estabelece diretrizes e padrões de codificação do projeto de automação dos testes do Núcleo de Teste. Ele serve como uma referência centralizada que ajuda a manter o padrão e boas práticas do código, garantindo uma melhor qualidade no desenvolvimento de todos os códigos.
O intuito é passar uma orientação básica e necessária ao desenvolvimento dos projetos para que todos os times possam padronizar seus códigos melhorando a legibilidade, facilitando os processos de desenvolvimento, retirada de bugs, atividades de validação e manutenção. O uso de um padrão de codificação busca aumenta a produtividade num projeto, uma vez que a comunicação dentro da equipe de desenvolvimento fica mais fácil, mas vale ressaltar que partes desses padrões propostos são sugestões que podem ser agregadas aos núcleos de desenvolvimento e seus próprios padrões.


## ⚙ 1. Princípios de Desenvolvimento de Código
Princípios de desenvolvimento de código são diretrizes que orientam os programadores na criação de software de alta qualidade, legível, escalável e de fácil manutenção. Esses princípios estabelecem um conjunto de boas práticas e padrões que visam melhorar a eficiência, a robustez e a qualidade do código produzido. Eles abrangem desde aspectos de estruturação e organização do código até a utilização de técnicas de programação que promovem a reutilização, a modularidade e a clareza. Ao seguir os princípios de desenvolvimento de código, os desenvolvedores podem produzir software mais confiável, fácil de entender e de dar manutenção, resultando em um processo de desenvolvimento mais eficiente e em produtos de melhor qualidade.

Dentre as diversas práticas e princípios que podem ser aplicadas durante a codificação, foi escolhido o modelo SOLID para ser aplicado no Núcleo de Teste.

Princípios SOLID para ser seguidos:

- Princípio da Responsabilidade Única (Single Responsibility Principle)
- Princípio Aberto Fechado (Open-Closed Principle)
- Princípio da Substituição de Liskov (Liskov Substitution Principle)
- Princípio da Segregação de Interfaces (Interface Segregation Principle)
- Princípio da Inversão de Dependência (Dependency Inversion Principle)

Esses cinco princípios de desenvolvimento de software são diretrizes a serem seguidas ao criar qualquer código de automação.

### <b>1.1. Modelo SOLID</b>

### <b>1.1.1 S — Single Responsibility</b>
Uma classe componente ou função deve ter uma única responsabilidade.

Se uma classe tiver muitas responsabilidades, aumenta a possibilidade de bugs, pois alterar uma de suas responsabilidades pode afetar as outras sem que você saiba.

Este princípio visa separar comportamentos para que, se surgirem bugs como resultado de sua alteração, isso não afete outros comportamentos não relacionados.

### <b>1.1.2. O — Open-Closed</b>
Classes, entidades ou funções devem estar abertas para extensões e fechadas para modificações.

Alterar o comportamento atual de uma classe afetará todos os sistemas que usam essa classe.
Se você deseja que a classe execute mais funções, a abordagem ideal é adicionar às funções que já existem, NÃO alterá-las.

Este princípio visa estender o comportamento de uma classe sem alterar o comportamento existente dessa classe. Isso evita causar bugs onde quer que a classe esteja sendo usada.

### <b>1.1.3. L — Liskov Substitution</b>
Se temos uma classe e dela utilizamos uma subclasse usando herança o objeto resultante dessa subclasse tem que substituir o objeto da classe principal sem quebrar o software.

Este princípio visa reforçar a consistência para que a classe pai ou sua classe filha possam ser usadas da mesma maneira sem erros.

### <b>1.1.4. I — Interface Segregation</b>
Os clientes (Classes) não devem ser forçados a depender de métodos que não usam.

Este princípio visa dividir um conjunto de ações em conjuntos menores para que uma Classe execute APENAS o conjunto de ações de que necessita.

### <b>1.1.5. D — Dependency Inversion</b>
Um módulo não deve depender de detalhes de implementação de um outro módulo diretamente. Deve existir uma abstração entre eles.

Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender da abstração.
As abstrações não devem depender de detalhes. Detalhes devem depender de abstrações.

Este princípio visa reduzir a dependência de uma classe de alto nível na classe de baixo nível, introduzindo uma interface.

## ⚙ 2. Boas Práticas
Utilizar o Selenium WebDriver de forma eficaz requer a adoção de várias boas práticas para garantir que seus testes sejam confiáveis, fáceis de manter e
escaláveis. Aqui estão algumas boas práticas ao trabalhar com o Selenium WebDriver:

### Escolha um Framework de Testes Adequado:
Utilize um framework de testes, como o TestNG ou JUnit.
Isso ajuda na execução, relatórios e gerenciamento dos testes.

### Organize seu Código:
Mantenha seu código de automação limpo e bem organizado. Use um padrão de design, como o Page Object Model (POM), para separar as ações do navegador da lógica dos testes.

### Centralizar Toda a Implementação na Page:
Toda a lógica de interação com a interface, que antes era implementada nos métodos de teste, agora devem ser centralizadas nas classes de Page Object, promovendo a reutilização de código e facilitando a manutenção.

Exemplo de um método da Page Objects:
<center>
    <img src="./files_public/1.Método Page.jpg" width="auto;" alt=""/>
</center>

Exemplo de um método teste:
<center>
    <img src="./files_public/1.Método Test.jpg" width="auto;" alt=""/>
</center>

### Utilização de métodos @before e @after:
Os métodos @Before e @After são utilizados para preparar e restaurar o ambiente de teste antes e depois da execução de cada teste, respectivamente. Isso garante que cada teste comece com um estado consistente e que quaisquer alterações feitas durante o teste sejam limpas, mantendo a independência dos testes.

Implementação:
- @Before: Utilizado para configurar o ambiente de teste, como inicializar variáveis, configurar URIs base, autenticação, etc.
- @After: Utilizado para limpar o ambiente de teste, como deletar dados criados durante o teste, fechar conexões, etc.

<center>
    <img src="./files_public/3.@before e @after.jpg" width="auto;" alt=""/>
</center>

### Declaração de Variáveis Apenas Fora dos Métodos:
Todas as variáveis utilizadas nos testes devem ser declaradas fora dos métodos, no escopo da classe. Isso promove uma melhor organização e reutilização de variáveis, além de facilitar a manutenção do código.

Método de teste

<center>
    <img src="./files_public/6.test.jpg" width="auto;" alt=""/>
</center>

Método Page Objects

<center>
    <img src="./files_public/6.page.jpg" width="auto;" alt=""/>
</center>

### Uso Correto do Encapsulamento:
Atentar-se às boas práticas e uso correto do encapsulamento. O encapsulamento é uma prática fundamental na programação orientada a objetos que visa proteger os dados e garantir a integridade dos objetos.

- Public: Permite o acesso a classes, métodos e variáveis de qualquer outro código. Deve ser usado para as CLASSES e MÉTODOS DA CLASSE;
- Private: Restringe o acesso a variáveis apenas na própria classe. Usar apenas em variáveis. Deve ser usado para as variáveis;
- Final: Define constantes. O valor de uma variável final não pode ser alterado após a inicialização. Deve ser utilizado apenas em variáveis que não são entradas para os testes. Exemplo: url de API, url de sistema, caminho de repositórios, time de delays, dentre outros.

### Use Esperas Explícitas:
Evite usar Thread.sleep() sempre que possível. Em vez disso, utilize esperas explícitas para aguardar que elementos apareçam, sejam clicáveis ou tenham determinados estados.

### Manipule Janelas e Frames Adequadamente:
o lidar com janelas pop-up, abas do navegador e frames, certifique-se de usar métodos apropriados para alternar entre eles, como switchTo(), para garantir que o WebDriver esteja interagindo com o contexto correto.

### Gerencie os Drivers e Configurações:
Mantenha as configurações do WebDriver e a inicialização do driver em um local centralizado. Isso facilita a manutenção e a reutilização do código de configuração.

### Use Dados de Teste Dinâmicos:
Evite usar dados de teste rígidos e estáticos sempre que possível. Utilize dados dinâmicos e parametrização de testes para verificar diferentes cenários com os mesmos testes.

### Gere Relatórios Detalhados:
Utilize ferramentas de relatórios, como o ExtentReports ou Allure, para criar relatórios detalhados que mostram o progresso e os resultados dos testes de forma clara e compreensível.

### Trate Exceções Adequadamente:
Implemente tratamento de exceções para lidar com erros durante a execução dos testes. Isso ajudará a identificar e solucionar
problemas de forma mais eficaz.

### Utilize Boas Práticas de Testes:
Siga as boas práticas de escrita de testes, como testes independentes, testes isolados e testes que podem ser executados em paralelo.

### Teste em Múltiplos Navegadores:
Se sua aplicação precisa suportar vários navegadores, certifique-se de testá-la em todos eles usando o Selenium WebDriver. Isso ajudará a garantir a compatibilidade cruzada.

### Automatize Testes de Regressão:
Priorize a automação de testes de regressão, ou seja, testes que verificam se funcionalidades existentes ainda estão funcionando após alterações no código.

### Mantenha-se Atualizado:
O Selenium é uma ferramenta em constante evolução. Certifique-se de acompanhar as atualizações e novas versões para aproveitar as melhorias e correções de bugs.

Adotar essas boas práticas ao trabalhar com o Selenium WebDriver contribuirá significativamente para o sucesso e eficácia de seus testes de automação de software.

## ⚙ 3. Sobre estrutura de diretórios/pastas

Na organização de pastas existem três principais ramos, pageobjects, tests e utils. O diretório pageobjects será utilizado para arquivos com mapeamento (declaração de variáveis com endereços xpath, id, class, tagname etc.) e métodos de ações (clique, escreva, mova, apague etc.). O diretório tests será utilizado para chamadas dos métodos de ações, planejamento e execução dos testes. O diretório utils contém todo o que é necessário para auxiliar nos testes. Veremos o exemplo a seguir:

<center>
    <img src="./files_public/report-1.png" width="auto;" alt=""/>
</center>

Dentro da estrutura de configuração do projeto, encontram-se três classes fundamentais que desempenham papéis cruciais:

#### Classe Browser:
A classe Browser encapsula métodos essenciais destinados a configurações e preparativos antes da execução do navegador. Ela fornece funcionalidades de inicialização e encerramento do navegador, bem como configurações iniciais necessárias para a automação de testes.

#### Classe BaseTeste:
A classe BaseTeste abriga métodos auxiliares que desempenham um papel crucial na execução dos testes. Esses métodos podem incluir configurações de ambiente, inicialização e finalização do teste, ou outras funcionalidades que são comuns a vários casos de teste.

#### Classe BaseActionElement:
A classe BaseActionElement contém métodos auxiliares projetados para simplificar a criação e modelagem de métodos de ação em elementos da interface do usuário.
Isso inclui operações como clicar, preencher campos de formulários, verificar estados e interações com elementos em uma página web.

Aprimorar as descrições das classes dessa forma torna mais claro o propósito de cada uma delas e facilita a compreensão de como elas se encaixam no contexto de automação de testes de software.

## ⚙ 4. Padronização do Código

### 4.1 Sobre a Formatação
Quanto à formatação, adotaremos a organização padrão recomendada pelas IDEs, como é o caso do Intellij, que pode ser facilmente aplicada com o atalho 'Ctrl + Alt + L', podendo utilizar a configuração base da IDE ou o modelo [Padrão de Formatação de Código](FORMATTING_PATTERN.md) no personalizando a indentação.

Essa abordagem nos permitirá eliminar a tarefa de procurar por pequenos erros, como espaços, linhas em branco e problemas de estrutura, uma vez que a formatação consistente e automática proporcionada pela IDE contribuirá para a coesão do código. Com essa abordagem, aprimoramos eficazmente nosso fluxo de trabalho, resultando em uma maior precisão durante a elaboração de códigos.

### 4.2 Sobre comentários:

Os comentários são feitos em português para melhor entendimento e leitura. Utilizar comentário quando necessário.

Exemplo: ``` /*Comentário em português para melhor leitura e entendimento*/ ```

Exemplo: ``` //Comentário em português para melhor leitura e entendimento ```


### 4.3 Sobre linguagem:

As nomenclaturas, declarações de classes, métodos, variáveis, documentos etc.. São todas em inglês (exceto comentários).

### 4.4 Nomenclatura de métodos e variáveis:

Quanto aos critérios para nomear elementos, seguiremos as seguintes diretrizes:

Para a criação de 'map objects' no arquivo de página (page):
Utilizaremos a convenção de nomenclatura "EstruturaHtml" seguida pelo nome do sugestivo correspondente, no mapeamento dos WebElements.
Exemplo: private WebElement btnSignIn; private WebElement inputName;
Utilizaremos a convenção de nomenclatura “VerboDeAção”+"EstruturaHtml" seguida pelo nome do sugestivo correspondente do mapeamento.

Exemplo:
```
private WebElement pressBtnSignIn(){};
private WebElement fillInputName(){};
```

Para outros métodos auxiliares na page, seguir o seguinte padrão:
```
Ação que será feita (create, update, delete, search, etc) + 
Nome do que será manipulado (user, item, profile, etc)
```
- Exemplos:
```
createUser
updateUserProfile
deleteUserAccount
searchItem
createNewItem
updateItemDetails
deleteItem
createUserWithInvalidEmail
verifyUserLogin
logoutUser
```

#### 4.4.1 Para a elaboração de testes no arquivo de teste (test):
Adotaremos a seguinte convenção:
```
Ação que será feita (create, update, delete, search, etc) + 
Nome do que será manipulado (user, item, profile, etc) + Test.
```
- Exemplos:
```
createUserTest
updateUserProfileTest
deleteUserAccountTest
searchItemTest
createNewItemTest
updateItemDetailsTest
deleteItemTest
createUserWithInvalidEmailTest
verifyUserLoginTest
logoutUserTest
```

Ao seguir essas diretrizes, estaremos estabelecendo um padrão uniforme para a nomenclatura, o que facilitará a identificação e compreensão dos elementos em nosso código. Isso, por sua vez, contribuirá para um desenvolvimento mais organizado e eficiente.

#### 4.4.2 Para a elaboração de validações nos asserts:
Adotaremos a convenção de nomear o método com o "NomeDaValidação" seguido pelo nome sugestivo correspondente e acrescido de "Validation".

### 4.4.3 Sobre classe MenuPage:

A classe MenuPage será utilizada para mapeamento do ```‘Menu’``` e criação de métodos de ação para navegar entre as páginas. (Obrigatório).

<center>
    <img src="./files_public/report-2.png" width="auto;" alt=""/>
</center>

<br/>


### 4.5 Geração de nomes aleatórios (ações na automações /tests)

Na codificação da automação, por muitas vezes, nos deparamos com situações
onde devemos preencher o(s) campo(s) ‘’input com informações válidas.
Obviamente, não é um problema passar a ‘string’ preenchendo o campo ‘input’,
entretanto, na maioria dos casos, precisamos a cada execução alimentar o banco
de dados com informações diferentes. Dessa maneira, surge a necessidade de
adaptar o projeto test automation com uma poderosa biblioteca que utiliza ‘maven’,
vamos dá bem-vindo ao ‘java faker’.

O objetivo da utilização do ‘java faker’ é facilitar o preenchimento dos campos,
gerando dados válidos e aleatórios.
Para utilizar o java faker, é necessário instanciar do objeto:

```
private final Faker faker = new Faker();
```

Para fazer as chamadas utilizaremos o prefixo fake com a notação ponto.
```
private final Faker faker = new Faker();

@Test
public void registerTest() {

        String pass = faker.internet().password();
        register.fillInputFirstName( faker.name().firstName() );
        register.fillInputLastName( faker.name().lastName() );

    }
```
Podem ser gerados dados como:

- Address
- Ancient
- Animal
- App
- Aqua Teen Hunger Force
- Artist
- Avatar
- Back To The Future
- Aviation
- Basketball
- Beer
- Bojack Horseman
- Book
- Bool
- Business
- ChuckNorris
- Cat
- Code
- Coin
- Color
- Commerce
- Company
- Crypto
- DateAndTime
- Demographic
- Disease
- Dog
- DragonBall
- Dune
- Educator
- Esports
- EnglandFootBall
- File
- Finance
- Food
- Friends
- FunnyName
- GameOfThrones
- Gender
- Hacker
- HarryPotter
- Hipster
- HitchhikersGuideToTheGalaxy
- Hobbit
- HowIMetYourMother
- IdNumber
- Internet
- Job
- Kaamelott
- LeagueOfLegends
- Lebowski
- LordOfTheRings
- Lorem
- Matz
- Music
- Name
- Nation
- Number
- Options
- Overwatch
- PhoneNumber
- Photography
- Pokemon
- Princess Bride
- Relationship Terms
- RickAndMorty
- Robin
- RockBand
- Shakespeare
- Sip
- SlackEmoji
- Space
- StarCraft
- StarTrek
- Stock
- Superhero
- Team
- TwinPeaks
- University
- Weather
- Witcher
- Yoda
- Zelda

Além disso o ‘java faker’ dá suporte a idiomas/localidades como:

- bg
- ca
- ca-CAT
- da-DK
- de
- de-AT
- de-CH
- en
- en-AU
- en-au-ocker
- en-BORK
- en-CA
- en-GB
- en-IND
- en-MS
- en-NEP
- en-NG
- en-NZ
- en-PAK
- en-SG
- en-UG
- en-US
- en-ZA
- es
- es-MX
- fa
- fi-FI
- fr
- he
- hu
- in-ID
- it
- ja
- ko
- nb-NO
- nl
- pl
- pt
- pt-BR
- ru
- sk
- sv
- sv-SE
- tr
- uk
- vi
- zh-CN
- zh-TW

Para utilizar uma localidade instancie um objeto java faker indicando a localidade:

```
private static final Faker faker = new Faker( new Locale( language: "pt-Br" ) );
```

### 4.6 Variáveis de Ambiente
As variáveis de ambiente ou 'environment', é fator de segurança indispensável em projetos que contém informações confidenciais, entretanto, de certa forma, na maioria das vezes essas informações não podem ficar visíveis, comprometendo
assim, a segurança do projeto.

### 4.6.1 Criação arquivo .env
Para utilizar as variáveis de ambiente é necessário criar o arquivo ‘.env’ na raiz do projeto contendo as informações
no modelo chave e valor.

Exemplo:
```html
user = amee.legros
pass = pass137@
pass_incorrect = pass123@
```


### 4.6.2 Como realizar a chamada do dotenv no LoginPage
Primeiramente, nas importações, é necessário importar.
```html
import io.github.cdimascio.dotenv.Dotenv;
```
É necessário instanciar o objeto e fazer as devidas chamadas no arquivo de
Login.(LoginPage).

```bash
private final Dotenv dotenv = Dotenv.load();

public void fillInputCredentials( String email, String pass ) {
  
    inputEmail.sendKeys( dotenv.get( email ) );
    inputPassword.sendKeys( dotenv.get( pass ) );
    btnLogin.click();
    
}
```
### 4.6.3 Passagem de argumento nos arquivos de Test
Na passagem do argumento do método de Login, lembre-se que devemos passar
‘chave’ inserida no arquivo .env, nesse caso é ‘user’ e ‘pass’. Através das ‘chaves’ a
chamada dotenv.get() terá acesso ao ‘value’.

```bash
@Test
public void loginWithTheCorrectCredentialsTest() {
  
  login.fillInputCredentials( "user", "pass" );
  assertTrue( driver.getPageSource().contains( "Jasmin Volkman" ) );

}
```

> [!IMPORTANT]
> Para finalizar, devemos nos atentar e adicionar o arquivo .env no .gitignore, pois,
não podem subir essas informações ao repositório.

```html
|## Auth ##
*.env
env
```
