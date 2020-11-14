package controller;

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
import controller.Lista;

public class InscritoController {
	
	public Inscrito cadastro() {
		Inscrito novo = new Inscrito();
		
		String [] opcoes = {"Gest�o de Projetos e Processos Organizacionais", "Enganharia e Neg�cios", "Tecnologia e Inova��o"};

		
		String nome = JOptionPane.showInputDialog("Adicionar Nome: ");
		novo.setNome(nome);
		
		String email = JOptionPane.showInputDialog("Adicionar E-mail: ");
		novo.setEmail(email);
		
		String rg = JOptionPane.showInputDialog("Adicionar RG: ");
		novo.setRg(rg);
		
		String cpf = JOptionPane.showInputDialog("Adicionar CPF: ");
		novo.setCpf(cpf);
		
		String cursoPos = (String) JOptionPane.showInputDialog(null, "Escolha o Curso", "Lista de Cursos", JOptionPane.PLAIN_MESSAGE ,null, opcoes
				,"");
		novo.setOpcCurso(cursoPos);
		
		String telefone = JOptionPane.showInputDialog("Adicionar Telefone: ");
		novo.setTelefone(telefone);
		
		String faculdade = JOptionPane.showInputDialog("Em faculdade (institui��o) voc� estudou: ");
		novo.setNomeFaculdade(faculdade);
		
		String curso = JOptionPane.showInputDialog("Qual � a sua gradua��o: ");
		novo.setNomeCurso(curso);
		
		Double media = Double.parseDouble(JOptionPane.showInputDialog("Qual foi a sua m�dia geral na faculdade: "));
		novo.setMediaFaculdade(media);
		
		String curriculo = JOptionPane.showInputDialog("Digite aqui seu Curr�culo: ");
		novo.setCurriculo(curriculo);
		
		return novo;
	}
	
	public void salvarLista(No inicio, String nomeArquivo) throws IOException {

		No inscrito = inicio;
		String dadosInscrito = "";
		File arquivo = new File(nomeArquivo);
		boolean existe = false;

		// Veriricar se o arquivo j� existe no diret�rio
		if (arquivo.exists() && arquivo.isFile()) {
			existe = true;

			// Configura��o de buffer para escrita de linha de arquivo
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader bufferEscrita = new BufferedReader(leitor);

			String linhaArquivo = bufferEscrita.readLine();

			// Configura��o de FileWriter para atualiza��o e inser��o de dados no arquivo
			FileWriter escreveArquivo = new FileWriter(arquivo, existe);
			PrintWriter adicionaInscrito = new PrintWriter(escreveArquivo);

			// caso a preira linha esteja vazia, o arquivo ainda n�o possui nenhum dados,
			// ent�o inserimos o cabe�alho
			if (linhaArquivo == null) {

				// Caso o arquivo tenha sido criado, mas nenhum dados foi inserido, criamos um
				// cabe�alho para ele
				dadosInscrito = "Nome" + ";" + "Curriculo" + ";" + "CPF" + ";" + "Curso desejado" + ";" + "E-mail" + ";" + "RG"
						+ ";" + "Telefone" + ";" + "Nome da Faculdade" + ";" + "Nome do curso" + ";" + "M�dia geral" + "\r\n";

				// Escrevemos o cabe�alho
				adicionaInscrito.write(dadosInscrito);

				// Escrevemos os dados
				dadosInscrito = inscrito.getInscrito().getNome() + ";" + inscrito.getInscrito().getCurriculo() + ";"
						+ inscrito.getInscrito().getCpf() + ";" + inscrito.getInscrito().getOpcCurso() + ";"
						+ inscrito.getInscrito().getEmail() + ";" + inscrito.getInscrito().getRg() + ";"
						+ inscrito.getInscrito().getTelefone() + ";" + inscrito.getInscrito().getNomeFaculdade() + ";"
						+ inscrito.getInscrito().getNomeCurso() + ";" + inscrito.getInscrito().getMediaFaculdade() + ";" + "\r\n";

				adicionaInscrito.write(dadosInscrito);
				adicionaInscrito.flush();
				adicionaInscrito.close();
				escreveArquivo.close();
				bufferEscrita.close();

			} else {

				// Caso contr�rio, se o arquivo j� existe, inserimos os nosvos dados no arquivo
				dadosInscrito = inscrito.getInscrito().getNome() + ";" + inscrito.getInscrito().getCurriculo() + ";"
						+ inscrito.getInscrito().getCpf() + ";" + inscrito.getInscrito().getOpcCurso() + ";"
						+ inscrito.getInscrito().getEmail() + ";" + inscrito.getInscrito().getRg() + ";"
						+ inscrito.getInscrito().getTelefone() + ";" + inscrito.getInscrito().getNomeFaculdade() + ";"
						+ inscrito.getInscrito().getNomeCurso() + ";" + inscrito.getInscrito().getMediaFaculdade() + ";" + "\r\n";

				adicionaInscrito.write(dadosInscrito);
				adicionaInscrito.flush();
				adicionaInscrito.close();
				escreveArquivo.close();

			}

			// Caso o arquivo n�o exista no diret�rio
		} else {

			// Criamos o arquivos
			arquivo.createTempFile("ListaAlunosd", ".csv");
			existe = true;

			// Configura��o de FileWriter para atualiza��o e inser��o de dados no arquivo
			FileWriter escreveArquivo = new FileWriter(arquivo, existe);
			PrintWriter adicionaInscrito = new PrintWriter(escreveArquivo);

			// Cabe�alho da planilha
			dadosInscrito = "Nome" + ";" + "Curriculo" + ";" + "CPF" + ";" + "Curso desejado" + ";" + "E-mail" + ";" + "RG"
					+ ";" + "Telefone" + ";" + "Nome da Faculdade" + ";" + "Nome do curso" + ";" + "M�dia geral" + "\r\n";

			// Escrevemos o cabe�alho
			adicionaInscrito.write(dadosInscrito);

			// Dados que o usu�rio inseriu
			dadosInscrito = inscrito.getInscrito().getNome() + ";" + inscrito.getInscrito().getCurriculo() + ";"
					+ inscrito.getInscrito().getCpf() + ";" + inscrito.getInscrito().getOpcCurso() + ";"
					+ inscrito.getInscrito().getEmail() + ";" + inscrito.getInscrito().getRg() + ";"
					+ inscrito.getInscrito().getTelefone() + ";" + inscrito.getInscrito().getNomeFaculdade() + ";"
					+ inscrito.getInscrito().getNomeCurso() + ";" + inscrito.getInscrito().getMediaFaculdade() + ";" + "\r\n";
			// Escrevemos os dados no arquivo
			adicionaInscrito.write(dadosInscrito);
			adicionaInscrito.flush();
			adicionaInscrito.close();
			escreveArquivo.close();
		}
	}
	
	public void percorreCsv(String nome_arquivo, No inicio) throws IOException{
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
				insereNo(nome, curriculo, cpf, curso, email, rg, telefone, nomeDaFaculdade, nomeDoCurso, mediaGeral, inicio);
				linha = buffer.readLine();	
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inv�lido");
		}
	}

	private void insereNo(String nome, String curriculo, String cpf, String curso, String email, String rg,
			String telefone, String nomeDaFaculdade, String nomeDoCurso, double mediaGeral, No inicio) {
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
		
		if (lista.vazia()) {
			
			novo_no.setProx(null);
			novo_no.setAnterior(null);
			inicio = novo_no;

		} else {

			No aux;
			aux = lista.buscaUltimo(inicio);
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
								+ "M�dia Geral: "+mediaGeral+"\n";
				System.out.println(candidato);
				System.out.println("___________________________________");
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inv�lido");
		}
	}

}
