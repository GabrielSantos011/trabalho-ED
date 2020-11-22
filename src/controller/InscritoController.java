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

	private No inicio;
	private Inscrito[] dados;
	private int contador;
	

	public Inscrito cadastro() {
		Inscrito novo = new Inscrito();

		String[] opcoes = { "Gest�o de Projetos e Processos Organizacionais", "Enganharia e Neg�cios",
				"Tecnologia e Iniva��o" };

		String nome = JOptionPane.showInputDialog("Adicionar Nome: ");
		novo.setNome(nome);

		String email = JOptionPane.showInputDialog("Adicionar E-mail: ");
		novo.setEmail(email);

		String rg = JOptionPane.showInputDialog("Adicionar RG: ");
		novo.setRg(rg);

		String cpf = JOptionPane.showInputDialog("Adicionar CPF: ");
		novo.setCpf(cpf);

		String cursoPos = (String) JOptionPane.showInputDialog(null, "Escolha o Curso", "Lista de Cursos",
				JOptionPane.PLAIN_MESSAGE, null, opcoes, "");
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

		// Veriricar se o arquivo já existe no diretório
		if (arquivo.exists() && arquivo.isFile()) {
			existe = true;

			// Configuração de buffer para escrita de linha de arquivo
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader bufferEscrita = new BufferedReader(leitor);

			String linhaArquivo = bufferEscrita.readLine();

			// Configuração de FileWriter para atualização e inserção de dados no
			// arquivo
			FileWriter escreveArquivo = new FileWriter(arquivo, existe);
			PrintWriter adicionaInscrito = new PrintWriter(escreveArquivo);

			// caso a preira linha esteja vazia, o arquivo ainda não possui nenhum dados,
			// então inserimos o cabeçalho
			if (linhaArquivo == null) {

				// Caso o arquivo tenha sido criado, mas nenhum dados foi inserido, criamos um
				// cabeçalho para ele
				dadosInscrito = "Nome" + ";" + "Curriculo" + ";" + "CPF" + ";" + "Curso desejado" + ";" + "E-mail" + ";"
						+ "RG" + ";" + "Telefone" + ";" + "Nome da Faculdade" + ";" + "Nome do curso" + ";"
						+ "M�dia geral" + "\r\n";

				// Escrevemos o cabeçalho
				adicionaInscrito.write(dadosInscrito);

				// Escrevemos os dados
				dadosInscrito = inscrito.getInscrito().getNome() + ";" + inscrito.getInscrito().getCurriculo() + ";"
						+ inscrito.getInscrito().getCpf() + ";" + inscrito.getInscrito().getOpcCurso() + ";"
						+ inscrito.getInscrito().getEmail() + ";" + inscrito.getInscrito().getRg() + ";"
						+ inscrito.getInscrito().getTelefone() + ";" + inscrito.getInscrito().getNomeFaculdade() + ";"
						+ inscrito.getInscrito().getNomeCurso() + ";" + inscrito.getInscrito().getMediaFaculdade() + ";"
						+ "\r\n";

				adicionaInscrito.write(dadosInscrito);
				adicionaInscrito.flush();
				adicionaInscrito.close();
				escreveArquivo.close();
				bufferEscrita.close();

			} else {

				// Caso contrário, se o arquivo já existe, inserimos os novos dados no arquivo
				dadosInscrito = inscrito.getInscrito().getNome() + ";" + inscrito.getInscrito().getCurriculo() + ";"
						+ inscrito.getInscrito().getCpf() + ";" + inscrito.getInscrito().getOpcCurso() + ";"
						+ inscrito.getInscrito().getEmail() + ";" + inscrito.getInscrito().getRg() + ";"
						+ inscrito.getInscrito().getTelefone() + ";" + inscrito.getInscrito().getNomeFaculdade() + ";"
						+ inscrito.getInscrito().getNomeCurso() + ";" + inscrito.getInscrito().getMediaFaculdade() + ";"
						+ "\r\n";

				adicionaInscrito.write(dadosInscrito);
				adicionaInscrito.flush();
				adicionaInscrito.close();
				escreveArquivo.close();

			}

			// Caso o arquivo não exista no diretório
		} else {

			// Criamos o arquivos
			arquivo.createTempFile("ListaAlunosd", ".csv");
			existe = true;

			// Configuração de FileWriter para atualização e inserção de dados no
			// arquivo
			FileWriter escreveArquivo = new FileWriter(arquivo, existe);
			PrintWriter adicionaInscrito = new PrintWriter(escreveArquivo);

			// Cabeçalho da planilha
			dadosInscrito = "Nome" + ";" + "Curriculo" + ";" + "CPF" + ";" + "Curso desejado" + ";" + "E-mail" + ";"
					+ "RG" + ";" + "Telefone" + ";" + "Nome da Faculdade" + ";" + "Nome do curso" + ";" + "Mdia geral"
					+ "\r\n";

			// Escrevemos o cabeçalho
			adicionaInscrito.write(dadosInscrito);

			// Dados que o usuário inseriu
			dadosInscrito = inscrito.getInscrito().getNome() + ";" + inscrito.getInscrito().getCurriculo() + ";"
					+ inscrito.getInscrito().getCpf() + ";" + inscrito.getInscrito().getOpcCurso() + ";"
					+ inscrito.getInscrito().getEmail() + ";" + inscrito.getInscrito().getRg() + ";"
					+ inscrito.getInscrito().getTelefone() + ";" + inscrito.getInscrito().getNomeFaculdade() + ";"
					+ inscrito.getInscrito().getNomeCurso() + ";" + inscrito.getInscrito().getMediaFaculdade() + ";"
					+ "\r\n";
			// Escrevemos os dados no arquivo
			adicionaInscrito.write(dadosInscrito);
			adicionaInscrito.flush();
			adicionaInscrito.close();
			escreveArquivo.close();
		}
	}

	public void percorreCsv(String nome_arquivo) throws IOException {
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
			
			//Cason�o seja mais a primeira itera��o, verificamos esta condi��o para n�o ter duplicidade na vari�vel inicio
			if(contador > 0) {
				inicio = null;
			}

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
				insereNo(nome, curriculo, cpf, curso, email, rg, telefone, nomeDaFaculdade, nomeDoCurso, mediaGeral,
						tamanho);
				linha = buffer.readLine();

				tamanho++;

			}
			buffer.close();
			leitor.close();
			fluxo.close();
			converteEmVetor(inicio, tamanho);

			ordenacao.quickSort(dados, 0, tamanho - 1);

			for (int i = 0; i < dados.length; i++) {
				System.out.println(dados[i].getNome() + "\n");
			}

			salvarOrdenado(dados, tamanho);

		} else {
			throw new IOException("Arquivo Inv�lido");
		}
	}

	public void salvarOrdenado(Inscrito[] dados2, int tamanho) throws IOException {

		String dadosInscrito = "";
		File arquivo = new File("ordenado.csv");
		boolean existe = false;

		// Veriricar se o arquivo já existe no diretório
		if (!arquivo.exists() && arquivo.isFile()) {
			arquivo.createTempFile("ordenado", ".csv");
		}

		// Configuração de FileWriter para atualização e inserção de dados no
		// arquivo
		FileWriter escreveArquivo = new FileWriter(arquivo);
		PrintWriter adicionaInscrito = new PrintWriter(escreveArquivo);

		// caso a primeira linha esteja vazia, o arquivo ainda não possui nenhum dados,
		// então inserimos o cabeçalho

		dadosInscrito = "Nome" + ";" + "Curriculo" + ";" + "CPF" + ";" + "Curso desejado" + ";" + "E-mail" + ";" + "RG"
				+ ";" + "Telefone" + ";" + "Nome da Faculdade" + ";" + "Nome do curso" + ";" + "Média geral" + "\r\n";

		// Escrevemos o cabeçalho
		adicionaInscrito.write(dadosInscrito);

		// Escrevemos os dados
		int contador = 0;
		while (contador < tamanho) {
			dadosInscrito = dados[contador].getNome() + ";" + dados[contador].getCurriculo() + ";"
					+ dados[contador].getCpf() + ";" + dados[contador].getOpcCurso() + ";" + dados[contador].getEmail()
					+ ";" + dados[contador].getRg() + ";" + dados[contador].getTelefone() + ";"
					+ dados[contador].getNomeFaculdade() + ";" + dados[contador].getNomeCurso() + ";"
					+ dados[contador].getMediaFaculdade() + ";" + "\r\n";
			adicionaInscrito.write(dadosInscrito);
			adicionaInscrito.flush();
			contador += 1;
		}
		adicionaInscrito.close();
		escreveArquivo.close();
	}

	private void insereNo(String nome, String curriculo, String cpf, String curso, String email, String rg,
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

	private void converteEmVetor(No inicio, int tamanho) {
		No auxiliar = inicio;
		dados = new Inscrito[tamanho];
		
		//Caso n�o seja a primeira itera��o, zeramos o contador para que ele possa iniciar do indice 0
		if (contador > 0) {
			contador = 0;
		}
		while (auxiliar != null) {
			dados[contador] = auxiliar.getInscrito();
			auxiliar = auxiliar.getProx();
			contador++;
		}

	}

	public void lerArquivo(String nomeArquivo) throws IOException {
		File arq = new File(nomeArquivo);
		Ordenacao ordenacao = new Ordenacao();

		String nome = "", curriculo = "", cpf = "", curso = "", email = "", rg = "", telefone = "",
				nomeDaFaculdade = "", nomeDoCurso = "", mediaGeral = "";
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
				String candidato = "Nome: " + nome + "\n" + "Curriculo: " + curriculo + "\n" + "CPF: " + cpf + "\n"
						+ "Curso: " + curso + "\n" + "Email: " + email + "\n" + "RG: " + rg + "\n" + "Telefone: "
						+ telefone + "\n" + "Faculdade: " + nomeDaFaculdade + "\n" + "Curso: " + nomeDoCurso + "\n"
						+ "M�dia Geral: " + mediaGeral + "\n";
				System.out.println(candidato);
				System.out.println("___________________________________");
				linha = buffer.readLine();

			}

			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo In�lido");
		}
	}

}
