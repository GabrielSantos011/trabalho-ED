package controller;

import entity.Inscrito;
import entity.No;

public class ListaMetodos {
	
	private No inicio;
	private No ultimo;
	private int tamanho=0;
	
	public ListaMetodos() {
		inicio = null;
	}
	
	public boolean vazia() {
		if(inicio==null)
			return true;
		else
			return false;
	}
	
	public void adicionaFinal(Inscrito inscrito) {
		No novo = new No(inscrito);
		
		if(vazia()) {
			No aux= inicio;
			aux.setInscrito(novo.getInscrito());
			aux.setAnterior(null);
			aux.setProx(null);
			inicio = aux;
			ultimo = inicio;
			ultimo.setAnterior(null);
			ultimo.setProx(null);
		} else {
			No aux = ultimo;
			aux.setProx(novo);
			novo.setAnterior(aux);
			novo.setProx(null);
			ultimo.setInscrito(novo.getInscrito());
			ultimo.setAnterior(novo.getAnterior());
			ultimo.setProx(novo.getProx());
		}// end if
		tamanho++;
	}//end adiciona Final
	
	public String percorre() {
		String lista="";
		lista = concatena(inicio,lista);
		return lista;
	}
	
	public String concatena(No aux, String lista) {
		if(aux!=null) {
			lista = lista + "\n"+aux.inscrito;
			concatena(aux.prox,lista);
		}
		
		return lista;
	}

}
