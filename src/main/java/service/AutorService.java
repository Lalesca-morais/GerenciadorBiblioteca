package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static connection.Conexao.fazerConexao;

public class AutorService {
    private Statement statement;
    public AutorService(){
        try{
            statement = fazerConexao().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void criarAutor(String nome){
        String sql = "INSERT INTO autor (nome) VALUES ('" +
                nome + "')";

        try{
            statement.executeUpdate(sql);
            System.out.println("Autor : " + nome + "foi adicionado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void consultaTodosAutores(){
        String sql = "SELECT * FROM autor";
        boolean livrosEncontrados = false;
        try {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                livrosEncontrados = true;
                System.out.println("ID: " + resultSet.getInt("id") +
                        " | NOME: " + resultSet.getString("nome"));
            }
            if (!livrosEncontrados) {
                System.out.println("Ainda não foi cadastrado nenhum autor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarAutor(String nome) {
        String sql = "UPDATE livros SET nome = '" + nome + "' WHERE id = ";
        try {
            int rowCount = statement.executeUpdate(sql);
            if (rowCount > 0) {
                System.out.println("Autor com nome " + nome + "foi alterado com sucesso.");
            } else {
                System.out.println("Autor com nome " + nome + " não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarAutor(int id){
        String sql = "DELETE FROM autor WHERE id = " + id;

        try{
            int rowCount = statement.executeUpdate(sql);
            if (rowCount > 0){
                System.out.println("Autor " + id + " foi deletado com sucesso!");

            }else{
                System.out.println("Autor " + id + " não encontrado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
