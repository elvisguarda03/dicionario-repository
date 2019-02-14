package br.com.guacom.dicionario.aurelio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.NoSuchElementException;

import br.com.guacom.dicionario.aurelio.model.ConnectionFactory;
import br.com.guacom.dicionario.aurelio.model.Dicionario;
import br.com.guacom.dicionario.aurelio.model.Palavra;

public class DicionarioDAO {
	private SignificadoDAO sDAO;

	public DicionarioDAO(SignificadoDAO sDAO) {
		if (sDAO == null)
			throw new IllegalArgumentException();
		this.sDAO = sDAO;
	}

	public Dicionario listar() {
		String sql = "select p.id, p.palavra from palavra p inner join significado s on s.cod_palavra = p.id;";
		Dicionario dicionario = new Dicionario();
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("p.id");
				Palavra p = new Palavra(id, rs.getString("p.palavra"));
				sDAO.buscar(p);
				dicionario.add(p);
			}
			return dicionario;
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		throw new NoSuchElementException("Nenhuma palavra foi cadastrada!");
	}

	public Palavra search(String name) {
		String sql = "select p.* from palavra p where p.palavra like ?";
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
			stmt.setString(1, "%" + name + "%");
			try (ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					Palavra p = new Palavra(rs.getInt("p.id"), rs.getString("p.palavra"));
					sDAO.buscar(p);
					return p;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new NoSuchElementException(String.format(new Locale("pt", "BR"), "Palavra %s não foi cadastrada.", name));
	}
}