package controller;

import entity.Inscrito;
import entity.No;

public class ListaMetodos {

	private No inicio;
	private No ultimo;
	private int tamanho = 0;

	public ListaMetodos() {
		inicio = null;
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

		//Consegui apenas inserir os valores com a lista vazia
		if (vazia()) {
			// No aux = inicio;
			// aux.setInscrito(novo.getInscrito());
			// aux.setAnterior(null);
			// aux.setProx(null);
			// inicio = aux;
			novo.setProx(null);
			novo.setAnterior(null);
			// inicio.setInscrito(novo.getInscrito());
			inicio = novo;
			// ultimo.setAnterior(null);
			// ultimo.setProx(null);
		} else {
			
			//Aqui ainda não foi alterado
			No aux = ultimo;
			aux.setProx(novo);
			novo.setAnterior(aux);
			novo.setProx(null);
			ultimo.setInscrito(novo.getInscrito());
			ultimo.setAnterior(novo);
			ultimo.setProx(novo);
		} // end if
		tamanho++;
	}// end adiciona Final

	public String percorre() {
		String lista = "";
		No aux = inicio;
		lista = concatena(aux, lista);
		return lista;
	}

	public String concatena(No aux, String lista) {
		
		//Aqui temos que chamar o getInscrito (referencia de memoria) e depois o dados dentro da classe (getNome, etc...)
		if (aux != null) {
			lista += "Nome: " + aux.getInscrito().getNome() + "\n Curriculo: "
					+ aux.getInscrito().getCurriculo() + "\nCPF: " + aux.getInscrito().getCpf() + "\nCurso: "
					+ aux.getInscrito().getOpcCurso() + "\nE-mail: " + aux.getInscrito().getEmail() + "\nRG: "
					+ aux.getInscrito().getRg() + "\nTelefone: " + aux.getInscrito().getTelefone();
			
			return concatena(aux.getProx(), lista); //Aqui inseri o "return"
		}
		

		return lista;
	}

}
