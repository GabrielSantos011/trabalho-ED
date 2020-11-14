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
			System.out.println(lista);
			return concatena(aux.getProx(), lista);
		}

		return lista;
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
				 + "\nCurrículo: "+auxiliar.getInscrito().getCurriculo()
				 + "\nCPF: "+auxiliar.getInscrito().getCpf()
				 +"\nCurso Desejado: "+auxiliar.getInscrito().getOpcCurso()
				 +"\nEmail: "+auxiliar.getInscrito().getEmail()
				 +"\nRG: "+auxiliar.getInscrito().getRg()
				 + "\nTelefone: "+auxiliar.getInscrito().getTelefone()
				 + "\nFaculdade: "+auxiliar.getInscrito().getNomeFaculdade()
				 + "\nCurso: "+auxiliar.getInscrito().getNomeCurso()
				 + "\nMédia Geral: "+auxiliar.getInscrito().getMediaFaculdade();
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
								 + "\nCurrículo: "+auxiliar.getInscrito().getCurriculo()
								 + "\nCPF: "+auxiliar.getInscrito().getCpf()
								 +"\nCurso Desejado: "+auxiliar.getInscrito().getOpcCurso()
								 +"\nEmail: "+auxiliar.getInscrito().getEmail()
								 +"\nRG: "+auxiliar.getInscrito().getRg()
								 + "\nTelefone: "+auxiliar.getInscrito().getTelefone()
								 + "\nFaculdade: "+auxiliar.getInscrito().getNomeFaculdade()
								 + "\nCurso: "+auxiliar.getInscrito().getNomeCurso()
								 + "\nMédia Geral: "+auxiliar.getInscrito().getMediaFaculdade();
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
			throw new IOException("Arquivo Inválido");
		}
	}
	
	public void percorreCsv(String nome_arquivo) throws IOException{
		inicio = null;
		File arq = new File(nome_arquivo);
		String nome="", curriculo="", cpf="", curso="", email="", rg="", telefone="", nomeDaFaculdade="", nomeDoCurso="";
		double mediaGeral = 0;
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String[] dadosDoCandidato;
			linha = buffer.readLine(); // pulando a primeira linha
			while (linha != null) { // procurando EOF
				dadosDoCandidato = linha.split(";");
				nome = dadosDoCandidato[0];
				curriculo = dadosDoCandidato[1];
				cpf = dadosDoCandidato[2];
				curso = dadosDoCandidato[3];
				email = dadosDoCandidato[4];
				rg = dadosDoCandidato[5];
				telefone = dadosDoCandidato[6];
				nomeDaFaculdade = dadosDoCandidato[7];
				nomeDoCurso = dadosDoCandidato[8];
				mediaGeral = Double.parseDouble(dadosDoCandidato[9]);
				insereNo(nome, curriculo, cpf, curso, email, rg, telefone, nomeDaFaculdade, nomeDoCurso, mediaGeral);
				linha = buffer.readLine();	
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}

	private void insereNo(String nome, String curriculo, String cpf, String curso, String email, String rg,
			String telefone, String nomeDaFaculdade, String nomeDoCurso, double mediaGeral) {
		No novo_no = new No();
		Inscrito novo_inscrito = new Inscrito();
		novo_inscrito.setNome(nome);
		novo_inscrito.setCurriculo(curriculo);
		novo_inscrito.setCpf(cpf);
		novo_inscrito.setOpcCurso(curso);
		novo_inscrito.setEmail(email);
		novo_inscrito.setRg(rg);
		novo_inscrito.setTelefone(telefone);
		novo_inscrito.setNomeFaculdade(nomeDaFaculdade);
		novo_inscrito.setNomeCurso(nomeDoCurso);
		novo_inscrito.setMediaFaculdade(mediaGeral);
		
		novo_no.setInscrito(novo_inscrito);
		
		if (vazia()) {
			
			novo_no.setProx(null);
			novo_no.setAnterior(null);
			inicio = novo_no;

		} else {

			No aux;
			aux = buscaUltimo(inicio);
			aux.setProx(novo_no);
			novo_no.setAnterior(aux);
			novo_no.setProx(null);

		}
		
	}
	
	public void lerArquivo(String nomeArquivo) throws IOException {
		File arq = new File(nomeArquivo);
		String nome="", curriculo="", cpf="", curso="", email="", rg="", telefone="", nomeDaFaculdade="", nomeDoCurso="", mediaGeral = "";
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine(); // pular a primeira linha
			String[] dadosDoCandidato;
			while (linha != null) { // procurando EOF
				dadosDoCandidato = linha.split(";");
				nome = dadosDoCandidato[0];
				curriculo = dadosDoCandidato[1];
				cpf = dadosDoCandidato[2];
				curso = dadosDoCandidato[3];
				email = dadosDoCandidato[4];
				rg = dadosDoCandidato[5];
				telefone = dadosDoCandidato[6];
				nomeDaFaculdade = dadosDoCandidato[7];
				nomeDoCurso = dadosDoCandidato[8];
				mediaGeral = dadosDoCandidato[9];
				String candidato = "Nome: "+nome+"\n"
								+ "Curriculo: "+curriculo+"\n"
								+ "CPF: "+cpf+"\n"
								+ "Curso: "+curso+"\n"
								+ "Email: "+email+"\n"
								+ "RG: "+rg+"\n"
								+ "Telefone: "+telefone+"\n"
								+ "Faculdade: "+nomeDaFaculdade+"\n"
								+ "Curso: "+nomeDoCurso+"\n"
								+ "Média Geral: "+mediaGeral+"\n";
				System.out.println(candidato);
				System.out.println("___________________________________");
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}
	
	public void ordenaArquivo(String nomeArquivo) {
		// Em construção
	}

}
