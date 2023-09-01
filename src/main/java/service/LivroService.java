package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static connection.Conexao.fazerConexao;

public class LivroService {
    private Statement statement;
    public LivroService(){
        try{
            statement = fazerConexao().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void criarLivro(String titulo, String id_autor, String ano_publicacao){
        String sql = "INSERT INTO livros (titulo, id_autor, ano_publicacao) " +
                "VALUES ('" + titulo + "', '" + id_autor + "', '" + ano_publicacao + "')";

        try{
            statement.executeUpdate(sql);
            System.out.println("\nLivro '" + titulo + "' criado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void mostrarTodosOsLivros(){
        String sql = "SELECT * FROM livros";
        boolean livrosEncontrados = false;

        try{
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                livrosEncontrados = true;
                System.out.println("=====LIVROS CADASTRADOS=====");
                System.out.println("ID: " + resultSet.getString("id_livro") +
                        " | Título: " + resultSet.getString("titulo") +
                        " | Autor: " + resultSet.getString("id_autor") +
                        " | Ano de publicação: " + resultSet.getString("ano_publicacao"));

            }if (!livrosEncontrados){
                System.out.println("Ainda não foi cadastrado nenhum livro.");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void consultarLivroPorId(int id){
        String sql = "SELECT * FROM livros WHERE id = " + id;

        try{
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                System.out.println("=====LIVRO ENCONTRADO=====");
                System.out.println("ID: " + resultSet.getString("id_livro") +
                        " | Título: " + resultSet.getString("titulo") +
                        " | Autor: " + resultSet.getString("id_autor") +
                        " | Ano de publicação: " + resultSet.getString("ano_publicacao"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void alterarLivro(String titulo, String id_autor, String ano_publicacao) {
        String sql = "UPDATE livros SET titulo = '" + titulo +
                "', id_autor = '" + id_autor + "', ano_publicacao = '" + ano_publicacao + "' WHERE id = ";
        try {
            int rowCount = statement.executeUpdate(sql);
            if (rowCount > 0) {
                System.out.println("Livro com nome " + titulo + "foi alterado com sucesso.");
            } else {
                System.out.println("Livro com nome " + titulo + " não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarLivro(int id){
        String sql = "DELETE FROM livros WHERE id = " + id;

        try{
            int rowCount = statement.executeUpdate(sql);
            if (rowCount > 0){
                System.out.println("Livro " + id + " foi deletado com sucesso!");

            }else{
                System.out.println("Livro " + id + " não encontrado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
