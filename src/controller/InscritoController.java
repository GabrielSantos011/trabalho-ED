package controller;

import javax.swing.JOptionPane;

import entity.Inscrito;

public class InscritoController {
	
	public Inscrito cadastro() {
		//Aqui inserir o JOptionPane
		
		Inscrito novo = new Inscrito();
		
		String nome = JOptionPane.showInputDialog("Adicionar Nome: ");
		novo.setNome(nome);
		
		String email = JOptionPane.showInputDialog("Adicionar E-mail: ");
		novo.setEmail(email);
		
		String rg = JOptionPane.showInputDialog("Adicionar RG: ");
		novo.setRg(rg);
		
		String cpf = JOptionPane.showInputDialog("Adicionar CPF: ");
		novo.setCpf(cpf);
		
		String cursoPos = JOptionPane.showInputDialog("Adicionar Curso de Pós graduação desejado: ");
		novo.setOpcCurso(cursoPos);
		
		String telefone = JOptionPane.showInputDialog("Adicionar Telefone: ");
		novo.setTelefone(telefone);
		
		String faculdade = JOptionPane.showInputDialog("Em faculdade (instituição) você estudou: ");
		novo.setNomeFaculdade(faculdade);
		
		String curso = JOptionPane.showInputDialog("Qual é a sua graduação: ");
		novo.setNomeCurso(curso);
		
		Double media = Double.parseDouble(JOptionPane.showInputDialog("Qual foi a sua média geral na faculdade: "));
		novo.setMediaFaculdade(media);
		
		String curriculo = JOptionPane.showInputDialog("Digite aqui seu Currículo: ");
		novo.setCurriculo(curriculo);
		
		return novo;
	}

}
