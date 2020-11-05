package boundary;

import javax.swing.JOptionPane;

import controller.InscritoController;

public class Tela {

	public static void main(String[] args) {
		int opc = 0;
		
		InscritoController metodo = new InscritoController();
		
		while(opc!=9) {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada:\n"
					+ "1 - Cadastro de Inscrito\n"
					+ "9 - Fim"));
			
			switch(opc) {
			case 1:
				metodo.cadastro();
			case 9:
				JOptionPane.showMessageDialog(null, "Fim");
			}
		}
	}

}
