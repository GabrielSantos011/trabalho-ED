package controller;

import javax.swing.JOptionPane;

import entity.Inscrito;

public class InscritoController {
	
	public Inscrito cadastro() {
		ListaMetodos lista = new ListaMetodos();
		
		//Aqui inserir o JOptionPane
		Inscrito novo = new Inscrito();
		String cpf = JOptionPane.showInputDialog("Adicionar CPF: ");
		novo.setCpf("Adicionar CPF: ");
		String curriculo = JOptionPane.showInputDialog("Adicionar Currículo: ");
		novo.setCurriculo(curriculo);
		String email = JOptionPane.showInputDialog("Adicionar E-mail: ");
		novo.setEmail(email);
		String nome = JOptionPane.showInputDialog("Adicionar Nome: ");
		novo.setNome(nome);
		String curso = JOptionPane.showInputDialog("Adicionar Curso: ");
		novo.setOpcCurso(curso);
		String rg = JOptionPane.showInputDialog("Adicionar RG: ");
		novo.setRg(rg);
		String telefone = JOptionPane.showInputDialog("Adicionar Telefone: ");
		novo.setTelefone(telefone);
		
		return novo;
	
		
		
	}

}
