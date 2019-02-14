package br.com.guacom.dicionario.aurelio.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

import br.com.guacom.dicionario.aurelio.dao.DicionarioDAO;
import br.com.guacom.dicionario.aurelio.model.Palavra;
import br.com.guacom.dicionario.aurelio.model.Significado;
import br.com.guacom.dicionario.aurelio.view.DicionarioView;

public class DicionarioController implements ActionListener {
	private DicionarioView dv;
	private DicionarioDAO dDAO;

	public DicionarioController(DicionarioView dv, DicionarioDAO dDAO) {
		if (dv == null || dDAO == null)
			throw new IllegalArgumentException("Erro no programa!");
		this.dv = dv;
		this.dDAO = dDAO;
		dv.btnPesquisar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == dv.btnPesquisar) {
			try {
				Palavra palavra = search();
				dv.lblWord.setText(palavra.getWord());
				dv.lblSignificado.setText(String.format("Significado de %s", palavra.getWord()));
				StringBuilder sb = new StringBuilder();
				for(Significado s : palavra.getSignificados()) {
					sb.append(s.getSigni());
					sb.append(System.lineSeparator());
				}
				dv.lblDefinicao.setText(sb.toString());
				cleanElements();
			} catch (NoSuchElementException e) {
				JOptionPane.showMessageDialog(dv, "Erro: " + e.getMessage());
			}
		}
	}

	public Palavra search() {
		try {
			String name = dv.txtBuscar.getText().trim();
			Palavra p = dDAO.search(name);
			if (p != null)
				return p;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(dv, "Campo vázio!");
		}
		return null;
	}

	public void cleanElements() {
		dv.txtBuscar.setText("");
	}
}
