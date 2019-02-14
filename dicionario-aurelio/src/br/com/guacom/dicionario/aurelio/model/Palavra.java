package br.com.guacom.dicionario.aurelio.model;

import java.util.Collections;
import java.util.List;

public class Palavra {
	private Integer id;
	private String word;
	private List<Significado> significados;

	public Palavra(Integer id, String word, List<Significado> significados) {
		if (id == null || word == null || significados == null)
			throw new IllegalArgumentException("Dados não foram cadastrados!");
		this.id = id;
		this.word = word;
		this.significados = significados;
	}

	public Palavra(String word, List<Significado> significados) {
		if (word == null || significados == null)
			throw new IllegalArgumentException("Dados não foram cadastrados!");
		this.word = word;
		this.significados = significados;
	}

	public Palavra(Integer id, String word) {
		if (word == null || id == null)
			throw new IllegalArgumentException("Dados não foram cadastrados!");
		this.word = word;
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public String getWord() {
		return word;
	}

	public List<Significado> getSignificados() {
		return Collections.unmodifiableList(significados);
	}

	public void setSignificados(List<Significado> significados) {
		if(significados == null)
			throw new IllegalArgumentException();
		this.significados = significados;
	}
}
