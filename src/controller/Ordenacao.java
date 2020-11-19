package controller;

import entity.Inscrito;

public class Ordenacao {
	
	public void quickSort(Inscrito lista[], int inicio, int fim) {
		int divisao;

		if (inicio < fim) {
			divisao = particao(lista, inicio, fim);
			quickSort(lista, inicio, divisao - 1);
			quickSort(lista, divisao + 1, fim);

		}

	}

	public int particao(Inscrito lista[], int inicio, int fim) {

		int indiceInicio = inicio;
		int indiceFim = fim;
		Inscrito pivo = lista[inicio];
		Inscrito auxiliar;

		
		while (indiceInicio < indiceFim) {
			
			// encontrando um nome "maior" que o pivo
			while (indiceInicio < indiceFim && lista[indiceInicio].getNome().compareTo(pivo.getNome()) <= 0){
				indiceInicio++;
			}

			// encontrar a partir do fim um valor "menor" que o meu pivo
			while (lista[indiceFim].getNome().compareTo(pivo.getNome()) > 0) {
				--indiceFim;
			}

			// Se eles não se cruzaram nos indices, realizamos a troca
			if (indiceInicio < indiceFim) {
				auxiliar = lista[indiceInicio];
				lista[indiceInicio] = lista[indiceFim];
				lista[indiceFim] = auxiliar;

			}
		}
		
		//Trocamos o indice do incio com o do final, assim poderemos atualizar o pivo, retornar o valor e fazer o particionamento novamente
		lista[inicio] = lista[indiceFim];
		lista[indiceFim] = pivo;

		return indiceFim;
	}

}
