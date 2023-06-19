# Criação de uma aplicação
### Criação de uma aplicação para visualizar base de dados
### Autor
* Bruno Santos - 8990
* Daniel Guerra - 9009
* Rodrigo Vieira - 9026
* Gabriel Granja - 9042
* Gonçalo Neiva - 9045

## Resumo
O objetivo deste trabalho é criar uma aplicação para fins educacionais que é uma base de dados que armazena informações sobre uma companhia. Esta aplicação irá mostrar dados da companhia, de todos os trabalhadores e dos relatórios da mesma como id do funcionário, nome, a listagem de todos os funcionários e os seus respetivos contactos, na empresa temos os departamentos onde será listado o id, o nome s localização dos mesmos e uma listagem geral e nos relatórios temos uma listagem dos gerentes e funcioários e os seus respetivos departamentos, o contrato de salários de cada funcionário, os funcinários contratados por ano e os funcionários com os salários máximos e minimos da companhia.
No trabalho houve um total de duas entidades como: departments e employees, cada um destes com os seus respectivos atributos e ligações.

## Introdução
Para ajudar uma companhia com as informoções da mesma , foi dado o objetivo de criar uma aplicação que disponibilizava a vizualização dos dados inseridos e guardados nessa base de dados, em relação a base de dados é importante que a base de dados seja criada de forma eficiente para garantir que a organização, acesso e gerenciamento das informações ocorram de forma rápida e efetiva e que de forma não prejudique o relacionamento com a aplicação criada.
A aplicação foi criada a partir da linguagem java pois seria a mais eficaz para o tipo de problema criado, com a aplicação será mais facil para a companhia vizualizar e monitorar a base de dados e as informações que contém nela, também é util para correções de erros que poderam surgir e monitorar gastos e os próprios funciários

## Extenções
Para o desenvolvimento do projeto, escolhemos utilizar o Visual Studio Code como ambiente integrado de desenvolvimento (IDE). Com a extensão Live Share, conseguimos otimizar a colaboração, permitindo que múltiplos desenvolvedores trabalhassem simultaneamente no mesmo código, o que foi essencial para aumentar a produtividade da nossa equipa.

A extensão Language Support for Java foi instalada para auxiliar na escrita do código em Java, fornecendo recursos de autocomplete, formatação e realce de sintaxe. Além disso, ela nos permitiu executar o código Java de forma eficiente, tornando o processo de desenvolvimento mais fluido.

Para garantir a qualidade do código desenvolvido, utilizamos o Test Runner para Java no Visual Studio Code. Essa ferramenta foi útil para automatizar os testes, permitindo que sejam realizados testes de unidade, testes de integração e testes de aceitação de forma mais eficiente e integrada com o ambiente de desenvolvimento. Com ela, conseguimos identificar e corrigir problemas no código de forma mais rápida e efetiva.

## Participantes e suas funções
Os desenvolvedores contribuíram de forma significativa para o sucesso do projeto, cada um em sua área de atuação. O desenvolvedor  Gonçalo Neiva trabalhou nas tabelas da base de dados e no resumo, melhorando a eficiência do sistema e fornecendo informações úteis. O Rodrigo Vieira implementou a funcionalidade de departamentos e o menu inicial, tornando o sistema mais intuitivo. Daniel Guerra contribuiu para a gestão eficiente de recursos e a estabilidade do sistema. Gabriel Granja implementou funções para a equipa e para mostrar tabelas, ajudando a equipa a trabalhar de forma produtiva. Bruno Santos trabalhou no relatório, fornecendo informações precisas e úteis aos utilizadores. Cada pessoa que participou tanto no código como no relatório tiveram um papel importante para sucesso do projeto.

## Imports
java.sql.Connection - fornece métodos para se conectar a um banco de dados e gerenciar essa conexão

java.sql.Date - representa uma data no formato SQL

java.sql.ResultSet - representa um conjunto de resultados de uma consulta SQL e permite a navegação por esses resultados

java.sql.Statement - permite a execução de instruções SQL em um banco de dados

java.util.Scanner - permite a leitura de entrada do usuário a partir do console

javax.print.event.PrintEvent - fornece informações sobre eventos de impressão

javax.sql.rowset.serial.SerialDatalink - representa uma coluna de dados do tipo DATALINK em um banco de dados

java.sql.SQLException - representa uma exceção lançada quando ocorre um erro ao acessar um banco de dados

java.io.PrintWriter - fornece métodos para escrever dados em um arquivo de texto

java.io.FileNotFoundException: representa uma exceção lançada quando um arquivo não é encontrado.

Basicamente esses imports permitem que o código em questão se comunique com um banco de dados, execute consultas e manipule os resultados, além de permitir a leitura de entrada de utilizadores e a gravação de dados em um documento de texto.

## Anexos

![unnamed](https://github.com/GEscola/Trabalho-Avaliacao-GrupoGranja/assets/134594770/2e356ec1-6799-4c5d-9602-e621db9fbdf2)

-Método para imprimir Menu


![unnamed](https://github.com/GEscola/Trabalho-Avaliacao-GrupoGranja/assets/134594770/72068f88-f805-47d1-81e0-70cc52a7e238)

-Método para imprimir submenu funcionários


![unnamed](https://github.com/GEscola/Trabalho-Avaliacao-GrupoGranja/assets/134594770/dbaa6e72-1f78-4c01-8459-3df0b622fd16)

-Método para imprimir submenu departamentos

