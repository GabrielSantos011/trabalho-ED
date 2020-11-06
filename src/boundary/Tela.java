package boundary;

import javax.swing.JOptionPane;

import controller.InscritoController;
import controller.ListaMetodos;

public class Tela {

	public static void main(String[] args) {
		int opc = 0;

		InscritoController metodo = new InscritoController();
		ListaMetodos lista = new ListaMetodos();

		while (opc != 9) {

			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite a opção desejada:\n" + "1 - Cadastro de Inscrito\n2 - Mostra\n" + "9 - Fim"));

			switch (opc) {
			case 1:
				//Coloquei o adiciona final aqui, porque o inicio na classe "ListaMetodos" estava perdendo os dados do "novo" quando saia do método
				lista.adicionaFinal(metodo.cadastro());
				break;

			case 2:
				//Aqui deixei uma opção de mostra lista apenas para ir testando se funciona
				String mostra = lista.percorre();
				JOptionPane.showMessageDialog(null, mostra);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Fim");
				break;
			}
		}
	}

}
