package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import entity.Inscrito;
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

		} else {

			No aux;
			aux = buscaUltimo(inicio);
			aux.setProx(novo);
			novo.setAnterior(aux);
			novo.setProx(null);
			inscritoController.salvarLista(novo, arquivo);
			JOptionPane.showMessageDialog(null, "Adicionado");

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

	public String removeFinal() throws IOException {
		
		percorreParaRemover(arquivo);
		if (inicio.getProx() == null) {
			return removeInicio();
		} else {
			String inscritoRemovido = "";
			No auxiliar = inicio;
			if (inicio.getProx().getProx() == null) {
				inscritoRemovido = "O seguinte inscrito foi removido:\n" + "Nome: " + auxiliar.getProx().getInscrito().getNome()
						+ "\nCurrículo: " + auxiliar.getProx().getInscrito().getCurriculo() + "\nCPF: " + auxiliar.getProx().getInscrito().getCpf()
						+ "\nCurso Desejado: " + auxiliar.getProx().getInscrito().getOpcCurso() + "\nEmail: "
						+ auxiliar.getProx().getInscrito().getEmail() + "\nRG: " + auxiliar.getProx().getInscrito().getRg() + "\nTelefone: "
						+ auxiliar.getInscrito().getTelefone() + "\nFaculdade: " + auxiliar.getInscrito().getNomeFaculdade()
						+ "\nCurso: " + auxiliar.getProx().getInscrito().getNomeCurso() + "\nMédia Geral: "
						+ auxiliar.getProx().getInscrito().getMediaFaculdade();
			} else {
				auxiliar = inicio;
				while ((auxiliar.getProx()).getProx() != null) {
					auxiliar = auxiliar.getProx();
				}
				inscritoRemovido = "O seguinte inscrito foi removido:\n" + "Nome: " + auxiliar.getProx().getInscrito().getNome()
						+ "\nCurrículo: " + auxiliar.getProx().getInscrito().getCurriculo() + "\nCPF: " + auxiliar.getProx().getInscrito().getCpf()
						+ "\nCurso Desejado: " + auxiliar.getProx().getInscrito().getOpcCurso() + "\nEmail: "
						+ auxiliar.getProx().getInscrito().getEmail() + "\nRG: " + auxiliar.getProx().getInscrito().getRg() + "\nTelefone: "
						+ auxiliar.getInscrito().getTelefone() + "\nFaculdade: " + auxiliar.getInscrito().getNomeFaculdade()
						+ "\nCurso: " + auxiliar.getProx().getInscrito().getNomeCurso() + "\nMédia Geral: "
						+ auxiliar.getProx().getInscrito().getMediaFaculdade();
			}
			auxiliar.setProx(null);
			salvarDepoisDeRemover();
			return inscritoRemovido;
		}
	}

	private String removeInicio() throws IOException {
		String inscritoRemovido = "";
		No auxiliar = inicio;
		inscritoRemovido = "O seguinte inscrito foi removido:\n" + "Nome: " + auxiliar.getInscrito().getNome()
				+ "\nCurrículo: " + auxiliar.getInscrito().getCurriculo() + "\nCPF: " + auxiliar.getInscrito().getCpf()
				+ "\nCurso Desejado: " + auxiliar.getInscrito().getOpcCurso() + "\nEmail: "
				+ auxiliar.getInscrito().getEmail() + "\nRG: " + auxiliar.getInscrito().getRg() + "\nTelefone: "
				+ auxiliar.getInscrito().getTelefone() + "\nFaculdade: " + auxiliar.getInscrito().getNomeFaculdade()
				+ "\nCurso: " + auxiliar.getInscrito().getNomeCurso() + "\nMédia Geral: "
				+ auxiliar.getInscrito().getMediaFaculdade();
		inicio = auxiliar.getProx();
		salvarDepoisDeRemover();
		return inscritoRemovido;
	}

	public String removeCpf(String cpf) throws IOException {
		String inscritoRemovido = "";
		percorreParaRemover(arquivo);
		No auxiliar = inicio;
		if (auxiliar.getInscrito().getCpf().equals(cpf)) {
			return removeInicio();
		}
		auxiliar = inicio.getProx();
		while (auxiliar != null) {
			if ((auxiliar.getInscrito().getCpf()).equals(cpf)) {
				inscritoRemovido = "O seguinte inscrito foi removido:\n" + "Nome: " + auxiliar.getInscrito().getNome()
						+ "\nCurrículo: " + auxiliar.getInscrito().getCurriculo() + "\nCPF: "
						+ auxiliar.getInscrito().getCpf() + "\nCurso Desejado: " + auxiliar.getInscrito().getOpcCurso()
						+ "\nEmail: " + auxiliar.getInscrito().getEmail() + "\nRG: " + auxiliar.getInscrito().getRg()
						+ "\nTelefone: " + auxiliar.getInscrito().getTelefone() + "\nFaculdade: "
						+ auxiliar.getInscrito().getNomeFaculdade() + "\nCurso: "
						+ auxiliar.getInscrito().getNomeCurso() + "\nMédia Geral: "
						+ auxiliar.getInscrito().getMediaFaculdade();
				if (auxiliar.getProx() != null) {
					auxiliar.getAnterior().setProx(auxiliar.getProx());
					auxiliar.getProx().setAnterior(auxiliar.getAnterior());
					auxiliar = null;
				}
				else {
					auxiliar.getAnterior().setProx(null);
					auxiliar = null;
				}

			} else {
				auxiliar = auxiliar.getProx();
			}
		}
		salvarDepoisDeRemover();
		return inscritoRemovido;
	}
	
	public void percorreParaRemover(String nome_arquivo) throws IOException {
		File arq = new File(nome_arquivo);
		String nome = "", curriculo = "", cpf = "", curso = "", email = "", rg = "", telefone = "",
				nomeDaFaculdade = "", nomeDoCurso = "";
		double mediaGeral = 0;
		int tamanho = 0;
		Ordenacao ordenacao = new Ordenacao();
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
				montaNoRemover(nome, curriculo, cpf, curso, email, rg, telefone, nomeDaFaculdade, nomeDoCurso, mediaGeral,
						tamanho);
				linha = buffer.readLine();

				tamanho++;

			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		else {
			JOptionPane.showMessageDialog(null, "Desculpe, o arquivo não existe!");
		}
	}
	
	private void montaNoRemover(String nome, String curriculo, String cpf, String curso, String email, String rg,
			String telefone, String nomeDaFaculdade, String nomeDoCurso, double mediaGeral, int tamanho) {
		Lista lista = new Lista();
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
		
		 if (inicio == null) {

			novo_no.setProx(null);
			novo_no.setAnterior(inicio);
			inicio = novo_no;

		} else {

			No aux;
			aux = lista.buscaUltimo(inicio);
			aux.setProx(novo_no);
			novo_no.setAnterior(aux);
			novo_no.setProx(null);
		}
	}
	
	public void salvarDepoisDeRemover() throws IOException {

		String dadosInscrito = "";
		File arquivo_atualizado = new File(arquivo);

		
		// Configuração de FileWriter para atualização e inserção de dados no arquivo
		FileWriter escreveArquivo = new FileWriter(arquivo_atualizado, false);
		PrintWriter adicionaInscrito = new PrintWriter(escreveArquivo);

		dadosInscrito = "Nome" + ";" + "Curriculo" + ";" + "CPF" + ";" + "Curso desejado" + ";" + "E-mail" + ";" + "RG"
				+ ";" + "Telefone" + ";" + "Nome da Faculdade" + ";" + "Nome do curso" + ";" + "MÃ©dia geral" + "\r\n";

		// Escrevemos o cabeçalho
		adicionaInscrito.write(dadosInscrito);

		// Escrevemos os dados
		No auxiliar = inicio;
		while (auxiliar != null) {
			dadosInscrito = auxiliar.getInscrito().getNome() + ";" + auxiliar.getInscrito().getCurriculo() + ";"
					+ auxiliar.getInscrito().getCpf() + ";" + auxiliar.getInscrito().getOpcCurso() + ";" + auxiliar.getInscrito().getEmail()
					+ ";" + auxiliar.getInscrito().getRg() + ";" + auxiliar.getInscrito().getTelefone() + ";"
					+ auxiliar.getInscrito().getNomeFaculdade() + ";" + auxiliar.getInscrito().getNomeCurso() + ";"
					+ auxiliar.getInscrito().getMediaFaculdade() + ";" + "\r\n";
			adicionaInscrito.write(dadosInscrito);
			adicionaInscrito.flush();
			auxiliar = auxiliar.getProx();
		}
		adicionaInscrito.close();
		escreveArquivo.close();
		inicio = null;

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

	public void ordenaArquivo() {
		
		try {
			inscritoController.percorreCsv(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
