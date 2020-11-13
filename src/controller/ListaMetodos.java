package controller;

import javax.swing.JOptionPane;

import entity.Inscrito;
import entity.No;

public class ListaMetodos {

	private No inicio;

	public ListaMetodos() {
		this.inicio = null;
	}

	public boolean vazia() {
		if (inicio == null)
			return true;
		else
			return false;
	}

	public void adicionaFinal(Inscrito inscrito) {
		No novo = new No();
		novo.setInscrito(inscrito);

		// Consegui apenas inserir os valores com a lista vazia
		if (vazia()) {
			novo.setProx(null);
			novo.setAnterior(null);
			inicio = novo;
		} else {

			// Inserção no final da lista atualizado
			No aux;
			aux = buscaUltimo(inicio);
			aux.setProx(novo);
			novo.setAnterior(aux);
			novo.setProx(null);
			String inscrito_adicionado = "O seguinte inscrito foi adicionado com sucesso:\n"+"Nome: "+novo.getInscrito().getNome()+"\nEmail: "+novo.getInscrito().getEmail()+"\nRG: "+novo.getInscrito().getRg()+"\nCPF: "+novo.getInscrito().getCpf()+"\nCurso: "+novo.getInscrito().getOpcCurso();
			JOptionPane.showMessageDialog(null, inscrito_adicionado);
		
		} // end if
	}// end adiciona Final
	
	
	// Método para remover do final da lista
	public String remove_final() {
		if (inicio.getProx() == null) {
			return remove_inicio();
		}
		else {
			String inscrito_removido = "";
			No auxiliar;
			auxiliar = inicio;
			while ((auxiliar.getProx()).getProx() != null) {
				auxiliar = auxiliar.getProx();
			}
			inscrito_removido = "O seguinte inscrito foi removido:\n"+"Nome: "+auxiliar.getProx().getInscrito().getNome()+"\nEmail: "+auxiliar.getProx().getInscrito().getEmail()+"\nRG: "+auxiliar.getProx().getInscrito().getRg()+"\nCPF: "+auxiliar.getProx().getInscrito().getCpf()+"\nCurso: "+auxiliar.getProx().getInscrito().getOpcCurso();
			auxiliar.getProx().getProx().setAnterior(auxiliar);
			auxiliar.setProx(null);
			
			return inscrito_removido;
		}
	}
	
	private String remove_inicio() {
		String inscrito_removido = "";
		No auxiliar = inicio;
		inscrito_removido = "O seguinte inscrito foi removido:\n"+"Nome: "+auxiliar.getInscrito().getNome()+"\nEmail: "+auxiliar.getInscrito().getEmail()+"\nRG: "+auxiliar.getInscrito().getRg()+"\nCPF: "+auxiliar.getInscrito().getCpf()+"\nCurso: "+auxiliar.getInscrito().getOpcCurso();
		inicio = auxiliar.getProx();
		return inscrito_removido;
	}
	
	
	// Método para remover um aluno com base no CPF dele
	public String remove_cpf(String cpf) {
		String inscrito_removido = "";
		No auxiliar = inicio;
		if (auxiliar.getInscrito().getCpf() .equals(cpf)) {
			return remove_inicio();
		}
		auxiliar = inicio.getProx();
		while (auxiliar != null){
			if ((auxiliar.getInscrito().getCpf()) .equals(cpf)) {
				inscrito_removido = "O seguinte inscrito foi removido:\n"+"Nome: "+auxiliar.getInscrito().getNome()+"\nEmail: "+auxiliar.getInscrito().getEmail()+"\nRG: "+auxiliar.getInscrito().getRg()+"\nCPF: "+auxiliar.getInscrito().getCpf()+"\nCurso: "+auxiliar.getInscrito().getOpcCurso();
				if (auxiliar.getProx() != null) {
					auxiliar.getAnterior().setProx(auxiliar.getProx());
					auxiliar.getProx().setAnterior(auxiliar.getAnterior());
				}
				auxiliar.getAnterior().setProx(null);
				auxiliar = null;
			
			}
			else {
				auxiliar = auxiliar.getProx();
			}
		}
		return inscrito_removido;
	}
	

	// Método para buscar o ultimo elemento da lista de maneira recursiva.
	public No buscaUltimo(No aux) {

		if (aux.getProx() == null) {
			return aux;
		}

		return buscaUltimo(aux.getProx());
	}

	public String percorre() {
		String lista = "Cadastrados\n\n";
		No aux = inicio;
		lista = concatena(aux, lista);
		return lista;
	}

	public String concatena(No aux, String lista) {

		// Aqui temos que chamar o getInscrito (referencia de memoria) e depois o dados
		// dentro da classe (getNome, etc)
		if (aux != null) {
			lista += "Nome: " + aux.getInscrito().getNome() + "\nCurriculo: " + aux.getInscrito().getCurriculo()
					+ "\nCPF: " + aux.getInscrito().getCpf() + "\nOpcCurso: " + aux.getInscrito().getOpcCurso()
					+ "\nE-mail: " + aux.getInscrito().getEmail() + "\nRG: " + aux.getInscrito().getRg()
					+ "\nTelefone: " + aux.getInscrito().getTelefone() +"\nFaculdade: " + aux.getInscrito().getNomeFaculdade() +
					"\nCurso :" + aux.getInscrito().getNomeCurso() + "\nMédia geral: " + aux.getInscrito().getMediaFaculdade() 
					+ "\n\n";

			return concatena(aux.getProx(), lista); // Aqui inseri o "return"
		}

		return lista;
	}

}
