## Qeep Moving Desafio Java CLI

Desenvolver um sistema em console para a gestão de disciplinas. 

O sistema deve ter:

- Cadastro de Aluno (Inserção, Alteração, Consulta e Exclusão)
- Cadastro de Professor (Inserção, Alteração, Consulta e Exclusão)
- Cadastro de Disciplina (Inserção, Alteração, Consulta e Exclusão)
- Gerencia de Matricula (Criação, Exclusão)

Os seguintes campos devem existir para: 

- Aluno: Codigo do Aluno, Nome, CPF
- Professor: Codigo do Professor, Nome, CPF
- Disciplina: Codigo da Disciplina, Nome da Disciplina, Carga Horaria, Codigo do Professor
- Matricula: Codigo da Matricula, Codigo da Disciplina, Codigo do Aluno

Regras Gerais: 

1. Cada disciplina só pode ter um único professor.
2. A disciplina só pode existir se tiver um professor definido.
3. Um professor pode ministrar mais de uma disciplina.
4. O aluno pode existir no sistema sem nenhuma disciplina.
5. O aluno pode cursar mais de uma disciplina.
6. O sistema não deve permitir a exclusão de nenhuma entidade que tiver relacionamentos criados ou seja: 
    - Não pode excluir um aluno, se ele já estiver associado a uma disciplina
    - Não pode excluir uma disciplina que tiver alunos matriculados
    - Não pode excluir um professor que estiver associado a uma disciplina
7. Os codigos utilizados para os cadastros deverao ser sequenciais
8. Não pode existir mais de um aluno ou professor com o mesmo CPF
9. Não pode existir mais de uma disciplina com o mesmo nome

---

  Telas do sistema:

    Menu Principal

    1 - Cadastros
    2 - Matricula
    3 - Relatorios
    4 - Sair

    Digite a opção desejada: 

---

    Menu Cadastros

    1 - Alunos
    2 - Professores
    3 - Disciplinas
    4 - Menu Principal

    Digite a opção desejada:

---

    Menu Cadastro de Alunos

    1 - Cadastrar
    2 - Alterar
    3 - Excluir
    4 - Consultar 
    5 - Listar Todos
    6 - Menu Anterior

    Digite a opção desejada: 

---

Regras:

- [x] Ao selecionar cadastrar, o sistema pedira para digitar os valores dos campos Nome e CPF e após a digitação do último campo deverá inserir no banco de dados e voltar para a lista de opções.  Caso já exista um aluno com o mesmo CPF, apresentar uma mensagem informando o fato.
- [x] Ao selecionar alterar, o sistema pedira o codigo do aluno, o novo nome do aluno e após a digitação procerá com a alteração dos dados no banco de dados. Caso, não exista um aluno com este código será apresentado uma mensagem informando o fato e o usuário deverá digitar um enter para voltar para a lista de opções. Não será permitido a alteração do CPF.
- [x] Ao selecionar excluir, o sistema pedira o codigo do aluno, e procederá com a exclusão do aluno no banco de dados. Caso, não exista um aluno com este código será apresentado uma mensagem informando o fato e o usuário deverá digitar um enter para voltar para a lista de opções.
- [x] Ao selecionar consultar, o sistema pedira para digitar o nome do aluno e procederá com a consulta no banco de dados pelo nome utilizando LIKE. Após a consulta o sistema exibirá os dados do aluno e aguardará o usuário digitar um enter para voltar para a lista de opções. Caso não exista nenhum aluno com o nome informado, exibir uma mensagem informando o fato.
- [x] Ao selecionar Listar Todos, o sistema exibira os dados de todos os alunos e aguardará o usuário digitar um enter para voltar para a lista de opções
- [x] Ao selecionar Menu Anterior o sistema volta para o menu anterior

O cadastro de professores segue a mesma tela e regras.

Exemplos da exibição do conteudo (opções de listar):

    CODIGO: 234 | ALUNO: Fulado de Tal | CPF: 342.234.234-23
    CODIGO: 235 | ALUNO: Cicrano de Tal | CPF: 234.231.123-33 
    CODIGO: 236 | ALUNO: Outro fulano de Tal | CPF: 321.221.231-45

-------------------------------------------------

    Menu Cadastro de Disciplinas 

    1 - Cadastrar
    2 - Alterar
    3 - Excluir
    4 - Consultar 
    5 - Listar Todos
    6 - Menu Anterior

    Digite a opção desejada: 

Regras:

- [x] Ao selecionar cadastrar, o sistema pedira para digitar os valores dos campos Codigo da Disciplina, Nome da Disciplina, Carga Horaria, Codigo do Professor e após a digitação do último campo deverá inserir no banco de dados e voltar para a lista de opções. Caso o código do professor não existir, ou já existir uma disciplina com o mesmo nome, apresentar uma mensagem informando o fato.	
- [x] Ao selecionar alterar, o sistema pedira o codigo da disciplina, o novo nome da disciplina, a nova carga horária, o novo código do professor e após a digitação procerá com a alteração dos dados no banco de dados. Caso, não exista uma disciplina com este código será apresentado uma mensagem informando o fato e o usuário deverá digitar um enter para voltar para a lista de opções. 
- [x] Ao selecionar excluir, o sistema pedira o codigo da disciplina, e procederá com a exclusão da disciplina. Caso, não exista uma disciplina com este código será apresentado uma mensagem informando o fato e o usuário deverá digitar um enter para voltar para a lista de opções.
- [x] Ao selecionar consultar, o sistema pedira para digitar o nome da disciplina e procederá com a consulta no banco de dados pelo nome utilizando LIKE. Após a consulta o sistema exibirá os dados da disciplina e aguardará o usuário digitar um enter para voltar para a lista de opções. Caso não exista nenhuma disciplina com o nome informado, exibir uma mensagem informando o fato.
- [x] Ao selecionar Listar Todos, o sistema exibira os dados de todas as disciplinas e aguardará o usuário digitar um enter para voltar para a lista de opções
- [x] Ao selecionar Menu Anterior o sistema volta para o menu anterior

Exemplos da exibição do conteudo (opções de listar):

    CODIGO: 2 | DISCIPLINA: Algoritmos | CARGA HORARIA: 34 horas | PROFESSOR: Fulano de Tal

-------------------------------------------------

    Menu Matricula 

    1 - Cadastrar
    2 - Remover
    3 - Alunos de uma Disciplina  
    4 - Disciplinas de um Aluno
    5 - Menu Anterior

    Regras:

- [x] Ao selecionar cadastrar, o sistema pedira para digitar o código da disciplina e o código do aluno. Após a digitação efetuar a inserão dos dados no banco de dados. Caso o codigo da matricula ou código do aluno não existir apresentar mensagem informando o fato  e o usuário deverá digitar um enter para voltar para a lista de opções. 
- [x] Ao selecionar remover, o sistema pedira para digitar o código da disciplina e o código do aluno. Após a digitação efetar a exclusão da matrícula no banco de dados. O usuário deverá digitar um enter para voltar para a lista de opções. 
- [x] Ao selecionar Disciplinas de um aluno, o sistema perguntara o código do aluno e exibira todas as disciplinas do aluno. Caso o código do aluno não exista, exibir mensagem informando o fato. O usuário deverá digitar um enter para voltar para a lista de opções. 
- [x] Ao selecionar Alunos de uma disciplina, o sistema perguntara o código da disciplina e exibira o codigo e nome de todos os alunos matriculados na disciplina. Caso o código da disciplina não exista, exibir mensagem informando o fato. O usuário deverá digitar um enter para voltar para a lista de opções. 
- [x] Ao selecionar Menu Anterior o sistema volta para o menu anterior

Exemplos da exibição do conteudo (opções de listar):

    CODIGO: 6 | DISCIPLINA: Algoritmos
    ALUNOS: 
    - Outro Fulano de Tal
    - Fulano de Tal
    - Cicrano de Tal

    CODIGO: 7 | ALUNO: Cicrano de TAL
    DISCIPLINAS: 
    - Algoritmos
    - Banco de dados
    - POO 

-------------------------------------------------

    Menu Relatorios

    1 - Listar disciplinas sem alunos
    2 - Listar alunos sem matriculas
    3 - Listar professores sem disciplinas
    4 - Listar total de carga horário do aluno 
      Obs: (Soma das cargas horárias de todas as disciplinas que o aluno esteja matriculado)


    DISCIPLINAS SEM ALUNO
    CODIGO: 4 | DISCIPLINA: Algoritmos
    CODIGO: 7 | DISCIPLINA: POO

    ALUNOS SEM MATRICULA
    CODIGO: 2 | ALUNO: Fulano de Tal
    CODIGO: 3 | ALUNO: Cicrano de Tal

    PROFESSORES SEM DISCIPLINAS
    CODIGO:6 | PROFESSOR: Fulano de TAL

    TOTAL DE CARGA HORARIA DOS ALUNOS
    CODIGO: 5 | ALUNO: Fulano de Tal | TOTAL DISCIPLINAS: 4 | TOTAL CARGA HORARIA: 56 horas
    CODIGO: 6 | ALUNO: Cicrano de Tal | TOTAL DISCIPLINAS: 1 | TOTAL CARGA HORARIA: 12 horas
