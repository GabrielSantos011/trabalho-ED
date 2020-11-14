package controller;

import java.io.IOException;
import javax.swing.JOptionPane;
import entity.No;

public class Lista {
	
	String arquivo = "ListaAlunos.csv";
	private No inicio;
	InscritoController inscritoController = new InscritoController();

	public Lista() {
		this.inicio = null;
	}

	public boolean vazia() {
		if (inicio == null)
			return true;
		else
			return false;
	}

	public void adicionaFinal() throws IOException {
		No novo = new No();
		novo.setInscrito(inscritoController.cadastro());

		if (vazia()) {
			
			novo.setProx(null);
			novo.setAnterior(null);
			inicio = novo;
			inscritoController.salvarLista(inicio, arquivo);
			JOptionPane.showMessageDialog(null, "Adicionado");
			percorre();

		} else {

			No aux;
			aux = buscaUltimo(inicio);
			aux.setProx(novo);
			novo.setAnterior(aux);
			novo.setProx(null);
			inscritoController.salvarLista(inicio, arquivo);
			JOptionPane.showMessageDialog(null, "Adicionado");
			percorre();

		}	
	}
	
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
		if (aux != null) {
			lista += "Nome: " + aux.getInscrito().getNome() + "\nCurriculo: " + aux.getInscrito().getCurriculo()
					+ "\nCPF: " + aux.getInscrito().getCpf() + "\nOpcCurso: " + aux.getInscrito().getOpcCurso()
					+ "\nE-mail: " + aux.getInscrito().getEmail() + "\nRG: " + aux.getInscrito().getRg()
					+ "\nTelefone: " + aux.getInscrito().getTelefone() +"\nFaculdade: " + aux.getInscrito().getNomeFaculdade() +
					"\nCurso :" + aux.getInscrito().getNomeCurso() + "\nMédia geral: " + aux.getInscrito().getMediaFaculdade() 
					+ "\n\n";

			return concatena(aux.getProx(), lista);
		}

		return lista;
	}

	
	public String removeFinal() {
		if (inicio.getProx() == null) {
			return removeInicio();
		}
		else 
		{
			String inscritoRemovido = "";
			No auxiliar;
			auxiliar = inicio;
			while ((auxiliar.getProx()).getProx() != null) {
				auxiliar = auxiliar.getProx();
			}
			inscritoRemovido = "O seguinte inscrito foi removido:\n"+"Nome: "+auxiliar.getProx().getInscrito().getNome()+"\nEmail: "+auxiliar.getProx().getInscrito().getEmail()+"\nRG: "+auxiliar.getProx().getInscrito().getRg()+"\nCPF: "+auxiliar.getProx().getInscrito().getCpf()+"\nCurso: "+auxiliar.getProx().getInscrito().getOpcCurso();
			auxiliar.getProx().getProx().setAnterior(auxiliar);
			auxiliar.setProx(null);
			
			return inscritoRemovido;
		}
	}
	
	private String removeInicio() {
		String inscritoRemovido = "";
		No auxiliar = inicio;
		inscritoRemovido = "O seguinte inscrito foi removido:\n"+"Nome: "+auxiliar.getInscrito().getNome()+"\nEmail: "+auxiliar.getInscrito().getEmail()+"\nRG: "+auxiliar.getInscrito().getRg()+"\nCPF: "+auxiliar.getInscrito().getCpf()+"\nCurso: "+auxiliar.getInscrito().getOpcCurso();
		inicio = auxiliar.getProx();
		return inscritoRemovido;
	}
	
	
	public String removeCpf(String cpf) {
		String inscritoRemovido = "";
		No auxiliar = inicio;
		if (auxiliar.getInscrito().getCpf() .equals(cpf)) {
			return removeInicio();
		}
		auxiliar = inicio.getProx();
		while (auxiliar != null){
			if ((auxiliar.getInscrito().getCpf()) .equals(cpf)) {
				inscritoRemovido = "O seguinte inscrito foi removido:\n"+"Nome: "+auxiliar.getInscrito().getNome()+"\nEmail: "+auxiliar.getInscrito().getEmail()+"\nRG: "+auxiliar.getInscrito().getRg()+"\nCPF: "+auxiliar.getInscrito().getCpf()+"\nCurso: "+auxiliar.getInscrito().getOpcCurso();
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
		return inscritoRemovido;
	}

}
