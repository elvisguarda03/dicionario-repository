package br.com.guacom.dicionario.aurelio.main;

import br.com.guacom.dicionario.aurelio.controller.DicionarioController;
import br.com.guacom.dicionario.aurelio.dao.DicionarioDAO;
import br.com.guacom.dicionario.aurelio.dao.SignificadoDAO;
import br.com.guacom.dicionario.aurelio.view.DicionarioView;

public class DicionarioDemo {

	public static void main(String[] args) {
		DicionarioView dv = new DicionarioView();
		dv.setVisible(true);
		DicionarioDAO dicionarioDAO = new DicionarioDAO(new SignificadoDAO());
		DicionarioController dc = new DicionarioController(dv, dicionarioDAO);
	}
}