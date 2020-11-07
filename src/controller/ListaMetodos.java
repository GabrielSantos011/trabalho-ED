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
		} // end if
		tamanho++;
	}// end adiciona Final

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
			lista += "Nome: " + aux.getInscrito().getNome() + "\n Curriculo: " + aux.getInscrito().getCurriculo()
					+ "\nCPF: " + aux.getInscrito().getCpf() + "\nCurso: " + aux.getInscrito().getOpcCurso()
					+ "\nE-mail: " + aux.getInscrito().getEmail() + "\nRG: " + aux.getInscrito().getRg()
					+ "\nTelefone: " + aux.getInscrito().getTelefone() + "\n\n";

			return concatena(aux.getProx(), lista); // Aqui inseri o "return"
		}

		return lista;
	}

}
