package controller;

import entity.Inscrito;

public class InscritoController {
	
	public void cadastro() {
		ListaMetodos lista = new ListaMetodos();
		
		Inscrito novo = new Inscrito();
		novo.setCpf("adicionar cpf");
		novo.setCurriculo("adicionar curriculo");
		novo.setEmail("Adicionar email");
		novo.setNome("Adicionar nome");
		novo.setOpcCurso("Adicionar curso");
		novo.setRg("Adicionar Rg");
		novo.setTelefone("Adicionar telefone");
		
		lista.adicionaFinal(novo);
		lista.percorre();
		
	}

}
