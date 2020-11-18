package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.Lista;

public class Tela {

	public static void main(String[] args) throws IOException {
		int opc = 0;

		Lista lista = new Lista();
		
		while (opc != 9) {

			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite a opção desejada:\n"
					+ "1 - Cadastro de Inscrito\n"
					+ "2 - Mostra\n"
					+ "3 - Remover o último inscrito\n"
					+ "4 - Remover um inscrito baseado no cpf\n"
					+ "5 - Abrir o arquivo .csv\n"
					+ "6 - Fazer ordenação do arquivo csv\n"
					+ "9 - Fim"));

			switch (opc) {
			case 1:
				try {
					lista.adicionaFinal();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Erro! Não foi possível inserir algum dado\n"+e);
				}
				
				break;

			case 2:
				lista.percorre();
				break;
				
			case 3:
				if (lista.vazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia!");
					break;
				}
		
				JOptionPane.showInternalMessageDialog(null, lista.removeFinal());
				break;
				
				
			case 4:
				if (lista.vazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia!");
					break;
				}
				String cpf = JOptionPane.showInputDialog("Insira aqui o cpf do inscrito que deseja remover: ");
				String cpf_removido = lista.removeCpf(cpf);
				if (!cpf_removido.equals("")) {
					JOptionPane.showInternalMessageDialog(null, cpf_removido);
				}
				else {
					JOptionPane.showMessageDialog(null, "O cpf "+cpf+" não consta na lista.");
				}
				break;
			
				
			case 5:
				lista.openFile("ListaAlunos.csv");
				break;
				
			case 6:
				lista.ordenaArquivo();
				break;

				
			case 9:
				JOptionPane.showMessageDialog(null, "Fim");
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Opção inexistente");
			}
			
		}
	}

}
