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

public class InscritoController {
	
	public Inscrito cadastro() {
		Inscrito novo = new Inscrito();
		
		String nome = JOptionPane.showInputDialog("Adicionar Nome: ");
		novo.setNome(nome);
		
		String email = JOptionPane.showInputDialog("Adicionar E-mail: ");
		novo.setEmail(email);
		
		String rg = JOptionPane.showInputDialog("Adicionar RG: ");
		novo.setRg(rg);
		
		String cpf = JOptionPane.showInputDialog("Adicionar CPF: ");
		novo.setCpf(cpf);
		
		String cursoPos = JOptionPane.showInputDialog("Adicionar Curso de P�s gradua��o desejado: ");
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

}
