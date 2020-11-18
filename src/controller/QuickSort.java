package controller;

import entity.Inscrito;

public class QuickSort {
	
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
		String pivo = lista[inicio].getNome();
		Inscrito auxiliar;

		while (indiceInicio < indiceFim) {
			while (indiceInicio < indiceFim && lista[indiceInicio].getNome().compareTo(pivo) < 0){
				indiceInicio++;
			}

			while (indiceInicio < indiceFim && lista[indiceFim].getNome().compareTo(pivo) >= 0) {
				--indiceFim;
			}

			if (indiceInicio < indiceFim) {
				auxiliar = lista[indiceInicio];
				lista[indiceInicio] = lista[indiceFim];
				lista[indiceFim] = auxiliar;

			}
		}

		return indiceFim;
	}

}
