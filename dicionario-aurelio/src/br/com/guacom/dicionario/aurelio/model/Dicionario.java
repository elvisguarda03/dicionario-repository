package br.com.guacom.dicionario.aurelio.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Dicionario {
	private List<Palavra> palavras;
	private List<Significado> significados;

	public Dicionario() {
		this.palavras = new ArrayList<>();
		this.significados = new ArrayList<>();
	}

	public void add(Palavra word) {
		if (word == null)
			throw new IllegalArgumentException();
		palavras.add(word);
		add(word.getSignificados());
	}
	
	private void add(List<Significado> significados) {
		for (Significado s : significados)
			this.significados.add(s);
	}
	
	public List<Palavra> getPalavras() {
		return (List<Palavra>) Collections.unmodifiableList(palavras);
	}
	
	public List<Significado> getSignificados() {
		return Collections.unmodifiableList(significados);
	}
	
	public List<Significado> pesquisar() {
		return palavras.get(0).getSignificados();
	}
	
	public List<Significado> pesquisar(String palavra) {
		int index = -1;
		if((index = search(palavra)) >= 0)
			return palavras.get(index).getSignificados();
		throw new NoSuchElementException("Palavra não está cadastrada!");
	}

	private int search(String palavra) {
		for(Palavra p : palavras) {
			if(p.getWord().compareToIgnoreCase(palavra) == 0)
				return palavras.indexOf(p);
		}
		return -1;
	}
	
	public List<Significado> pesquisar(int index) {
		return palavras.get(index).getSignificados();
	}
	
	public boolean validarPalavra(String palavra) {
		return search(palavra) >= 0;
	}
}