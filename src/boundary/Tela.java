package boundary;

import javax.swing.JOptionPane;

import controller.InscritoController;
import controller.ListaMetodos;

public class Tela {

	public static void main(String[] args) {
		int opc = 0;
		String inscrito_removido;

		InscritoController metodo = new InscritoController();
		ListaMetodos lista = new ListaMetodos();

		while (opc != 9) {

			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite a opção desejada:\n"
					+ "1 - Cadastro de Inscrito\n"
					+ "2 - Mostra\n"
					+ "3 - Remover o último inscrito\n"
					+ "4 - Remover um inscrito baseado no cpf\n"
					+ "9 - Fim"));

			switch (opc) {
			case 1:
				//Coloquei o adiciona final aqui, porque o inicio na classe "ListaMetodos" estava perdendo os dados do "novo" quando saia do método
				try {
					lista.adicionaFinal(metodo.cadastro());
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Erro! Não foi possível inserir algum dado\n"+e);
				}
				
				break;

			case 2:
				//Aqui deixei uma opção de mostra lista apenas para ir testando se funciona
				if (lista.vazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia!");
				}
				else {
					String mostra = lista.percorre();
					JOptionPane.showMessageDialog(null, mostra);
				}
				break;
				
			case 3:
				if (lista.vazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia!");
					break;
				}
				inscrito_removido = lista.remove_final();
				JOptionPane.showInternalMessageDialog(null, inscrito_removido);
				break;
				
				
			case 4:
				if (lista.vazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia!");
					break;
				}
				String cpf = JOptionPane.showInputDialog("Insira aqui o cpf do inscrito que deseja remover: ");
				inscrito_removido = lista.remove_cpf(cpf);
				if (!inscrito_removido .equals("")) {
					JOptionPane.showInternalMessageDialog(null, inscrito_removido);
				}
				else {
					JOptionPane.showMessageDialog(null, "O cpf "+cpf+" não consta na lista.");
				}
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
