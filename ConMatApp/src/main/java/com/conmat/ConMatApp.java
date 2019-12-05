package com.conmat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.conmat.controller.AlunoController;
import com.conmat.controller.MaterialController;
import com.conmat.controller.ProfessorController;
import com.conmat.controller.UsuarioController;
import com.conmat.model.Aluno;
import com.conmat.model.Material;
import com.conmat.model.Professor;
import com.conmat.model.Usuario;

/**
 * Main da aplicação
 * 
 * @author Renato Ayron
 *
 */
public class ConMatApp {

	public static Scanner scan = new Scanner(System.in);
	public static SimpleDateFormat formatter;

	public static void main(String[] args) throws ParseException {

		scan.useLocale(Locale.US);
		System.out.println("Olá! Bem-Vindo ao Sistema ConMat!");
		System.out.println("Um Sistema para Controle de Materiais de Matemática!");

		System.out.println("---------------------------------------------------------------");

//		Usuario usuario = new Usuario("fulano@gmail.com", "fulanoo", "fulano123");

		System.out.println("Informe se deseja cadastrar um:");
		System.out.println("1 - Aluno");
		System.out.println("2 - Professor");
		System.out.println("3 - Material");

		UsuarioController uc = new UsuarioController();
		AlunoController ac = new AlunoController();
		ProfessorController pc = new ProfessorController();
		MaterialController mc = new MaterialController();

		int op = scan.nextInt();

		if (op == 1) {
			System.out.println("Novo Usuário\nPreencha os campos abaixo:\n");
			System.out.println("E-mail: ");
			String email = scan.next();
			System.out.println("Nome de Usuário: ");
			String user = scan.next();
			System.out.println("Senha: ");
			String password = scan.next();

			Usuario u1 = new Usuario(email, user, password);

			System.out.println("---------------------------------------------------------------");

			uc.insert(u1);

			System.out.println("Usuários cadastrados:");

			uc.list();

			System.out.println("---------------------------------------------------------------");

			uc.delete(9);

			uc.list();

//			uc.edit(u1);

//			uc.list();

			System.out.println("---------------------------------------------------------------");

			System.out.println("Novo Aluno\nPreencha os campos abaixo:\n");
			System.out.println("Nome: ");
			String nomeAluno = scan.next();
			System.out.println("Turma: ");
			String turma = scan.next();
			System.out.println("Data de Nascimento: (dd-MM-yyyy)");
			String nascAlunoS = scan.next();

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			Date nascAluno = formatter.parse(nascAlunoS);

			Aluno a1 = new Aluno(nomeAluno, turma, nascAluno);
			a1.setId(u1.getId());

			System.out.println("---------------------------------------------------------------");

			ac.insert(a1);

			System.out.println("Alunos cadastrados:");

			ac.list();

			System.out.println("---------------------------------------------------------------");

			ac.delete(8);

			ac.list();

			System.out.println("---------------------------------------------------------------");

		} else if (op == 2) {
			System.out.println("Novo Usuário\nPreencha os dados de Aluno abaixo:\n");
			System.out.println("E-mail: ");
			String email2 = scan.next();
			System.out.println("Nome de Usuário: ");
			String user2 = scan.next();
			System.out.println("Senha: ");
			String password2 = scan.next();

			Usuario u2 = new Usuario(email2, user2, password2);

			System.out.println("---------------------------------------------------------------");

			uc.insert(u2);

			System.out.println("Usuários cadastrados:");

			uc.list();

			System.out.println("---------------------------------------------------------------");

			uc.delete(9);

			uc.list();

//			uc.edit(u1);

//			uc.list();

			System.out.println("---------------------------------------------------------------");

			System.out.println("Novo Professor\nPreencha os dados do Professor abaixo:\n");
			System.out.println("Nome: ");
			String nomeProf = scan.next();
			System.out.println("Salário: ");
			float salario = scan.nextFloat();
			System.out.println("Data de Nascimento: (dd-MM-yyyy)");
			String nascProfS = scan.next("dd-MM-yyyy");

			formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			Date nascProf = formatter.parse(nascProfS);

			Professor p1 = new Professor(nomeProf, salario, nascProf);
			p1.setId(u2.getId());

			System.out.println("---------------------------------------------------------------");

			pc.insert(p1);

			System.out.println("Alunos cadastrados:");

			pc.list();

			System.out.println("---------------------------------------------------------------");

			pc.delete(7);

			pc.list();

			System.out.println("---------------------------------------------------------------");
		} else if (op == 3) {
			System.out.println("Novo Material\nPreencha os campos abaixo:\n");
			System.out.println("Nome: ");
			String nome = scan.next();
			System.out.println("Autor: ");
			String autor = scan.nextLine();
			System.out.println("Data de Criação: (dd-MM-yyyy)");
			String criacaoS = scan.next("dd-MM-yyyy");
			System.out.println("Descrição: ");
			String descricao = scan.nextLine();
			System.out.println("Status: ");
			String status = scan.nextLine();

			formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			Date criacao = formatter.parse(criacaoS);

			Material m1 = new Material(nome, autor, criacao, descricao, status);

			System.out.println("---------------------------------------------------------------");

			mc.insert(m1);

			System.out.println("Alunos cadastrados:");

			mc.list();

			System.out.println("---------------------------------------------------------------");

			mc.delete(7);

			mc.list();

			System.out.println("---------------------------------------------------------------");
		} else {
			System.out.println("Opção Inválida!\n");
			System.out.println("Informe se deseja cadastrar um:");
			System.out.println("1 - Aluno");
			System.out.println("2 - Professor");
			System.out.println("3 - Material");
			op = scan.nextInt();
		}

	}

}