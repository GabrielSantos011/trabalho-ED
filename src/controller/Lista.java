package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import entity.No;
import entity.Inscrito;


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
			inscritoController.salvarLista(novo, arquivo);
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
	
	public void percorre() {
		try {
			inscritoController.lerArquivo(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
	public String removeFinal() {
		if (inicio.getProx() == null) {
			return removeInicio();
		}
		else {
			String inscritoRemovido = "";
			No auxiliar = inicio;
			if (inicio.getProx().getProx() == null) {
				inscritoRemovido = "O seguinte inscrito foi removido:\n"+"Nome: "+auxiliar.getProx().getInscrito().getNome()+"\nEmail: "+auxiliar.getProx().getInscrito().getEmail()+"\nRG: "+auxiliar.getProx().getInscrito().getRg()+"\nCPF: "+auxiliar.getProx().getInscrito().getCpf()+"\nCurso: "+auxiliar.getProx().getInscrito().getOpcCurso();
			}
			else {
				auxiliar = inicio;
				while ((auxiliar.getProx()).getProx() != null) {
					auxiliar = auxiliar.getProx();
				}
				inscritoRemovido = "O seguinte inscrito foi removido:\n"+"Nome: "+auxiliar.getProx().getInscrito().getNome()+"\nEmail: "+auxiliar.getProx().getInscrito().getEmail()+"\nRG: "+auxiliar.getProx().getInscrito().getRg()+"\nCPF: "+auxiliar.getProx().getInscrito().getCpf()+"\nCurso: "+auxiliar.getProx().getInscrito().getOpcCurso();
				auxiliar.getProx().getProx().setAnterior(auxiliar);
			}
			auxiliar.setProx(null);
			return inscritoRemovido;
		}
	}
	
	private String removeInicio() {
		String inscritoRemovido = "";
		No auxiliar = inicio;
		inscritoRemovido =  "O seguinte inscrito foi removido:\n"
				 + "Nome: "+auxiliar.getInscrito().getNome()
				 + "\nCurr�culo: "+auxiliar.getInscrito().getCurriculo()
				 + "\nCPF: "+auxiliar.getInscrito().getCpf()
				 +"\nCurso Desejado: "+auxiliar.getInscrito().getOpcCurso()
				 +"\nEmail: "+auxiliar.getInscrito().getEmail()
				 +"\nRG: "+auxiliar.getInscrito().getRg()
				 + "\nTelefone: "+auxiliar.getInscrito().getTelefone()
				 + "\nFaculdade: "+auxiliar.getInscrito().getNomeFaculdade()
				 + "\nCurso: "+auxiliar.getInscrito().getNomeCurso()
				 + "\nM�dia Geral: "+auxiliar.getInscrito().getMediaFaculdade();
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
				inscritoRemovido = "O seguinte inscrito foi removido:\n"
								 + "Nome: "+auxiliar.getInscrito().getNome()
								 + "\nCurr�culo: "+auxiliar.getInscrito().getCurriculo()
								 + "\nCPF: "+auxiliar.getInscrito().getCpf()
								 +"\nCurso Desejado: "+auxiliar.getInscrito().getOpcCurso()
								 +"\nEmail: "+auxiliar.getInscrito().getEmail()
								 +"\nRG: "+auxiliar.getInscrito().getRg()
								 + "\nTelefone: "+auxiliar.getInscrito().getTelefone()
								 + "\nFaculdade: "+auxiliar.getInscrito().getNomeFaculdade()
								 + "\nCurso: "+auxiliar.getInscrito().getNomeCurso()
								 + "\nM�dia Geral: "+auxiliar.getInscrito().getMediaFaculdade();
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
	
	
	public void openFile(String nome_arquivo) throws IOException {
		File arq = new File(nome_arquivo);
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo Inv�lido");
		}
	}
	

	
	public void ordenaArquivo(String nomeArquivo) {
		// Em constru��o
	}

}
