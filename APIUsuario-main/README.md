<center><h1>API WEB USER - CADASTRO DE USUARIO</h1></center>

<h2>API em Java para Cadastrar, Selecionar, Editar e Deletar usúario (CRUD)</h2>
  
 Essa API foi desenvolvida com a linguagem Java com Spring.
  
 Para renderizer o HTML foi usado o Thymeleaf, e no HTML com Bootstrap para um formulário responsivo. 
  
  <h2>EXECUÇÃO DO PROJETO</h2>
  
  Para executar deve ter o PGAdmin instalado na maquina, o banco de dados utilizado foi o PostgresSQL.
  Criar um banco de dados com o nome de preferência. No modelo foi usado api_web_user.
  
  Deve-se clonar o projeto em sua maquina, abrir em uma IDE de preferência (foi desenvolvido no IntelliJ)
  ir em Properties (Arquivo de propriedades do spring) e inserir o login e senha do PGAdmin e o nome do banco criado.
  Ao execultar o projeto a tabela user será criada com todos os atributos necessários.
  
  Abrir em seu navegador a URL = http://localhost:8080/ que já será carregado a pagina inicial com a lista de usuarios cadastrados no Banco.
  Ao clicar em Register User será redirecionado para uma pagina de cadastro, onde deve ser por os dados e um Email no formato válido.
  Salvo será exibido seus dados e poderá voltar a pagina inicial. 
  Ao clicar em editar seus dados já será carregado ( e seu email não pode ser alterado por segurança) somente pode-se editar nome e idade.
  Ao deletar usuario após carregado podera voltar a pagina inicial.
