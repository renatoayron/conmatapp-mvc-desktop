# Sistema ConMat

##### Sistema de Gerenciamento de Empréstimos e Reservas de Materiais de Matemática

O Sistema ConMat foi desenvolvido para a disciplina de Engenharia de Software. O sistema é bem simples e trata-se de um controle de materiais de matemática criados e compartilhados pelos alunos e professores de uma escola fictícia.

Antes de executar o projeto, crie o banco de dados no MySQL para que o mesmo crie as tabelas. O arquivo .sql está no seguinte diretório:

	src/main/resources

Para conectar no banco altere os parâmetros user e password, de acordo com suas informações do MySQL, em:

	src/main/java/com/conmat/config/Conexao.java
	
