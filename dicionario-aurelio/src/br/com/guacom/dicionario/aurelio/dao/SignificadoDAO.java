package br.com.guacom.dicionario.aurelio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.guacom.dicionario.aurelio.model.ConnectionFactory;
import br.com.guacom.dicionario.aurelio.model.Palavra;
import br.com.guacom.dicionario.aurelio.model.Significado;

public class SignificadoDAO {

	public List<Significado> listar() {
		String sql = "select s.*, p.* from significado s inner join palavra p on p.id = s.cod_palavra";
		List<Significado> significados = new LinkedList<>();
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Significado s = new Significado(rs.getString("s.significado"));
				s.setId(rs.getInt("s.id"));
				significados.add(s);
				Palavra p = new Palavra(rs.getInt("p.id"), rs.getString("p.palavra"), significados);
				s.setWord(p);
			}
			return significados;
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		throw new NoSuchElementException("Nenhum significado foi cadastrado");
	}

	public List<Significado> buscar(Palavra p) {
		String sql = "select * from significado s where cod_palavra = ?";
		List<Significado> significados = new LinkedList<>();
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
			stmt.setInt(1, p.getId());
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Significado s = new Significado(rs.getString("s.significado"));
					s.setId(rs.getInt("s.id"));
					significados.add(s);
					s.setWord(p);
				}
				p.setSignificados(significados);
				return significados;
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		throw new NoSuchElementException();
	}
}