package service.livroService;

import java.sql.*;

import static connection.Conexao.fazerConexao;

public class LivroService {
    private Statement statement;
    public void LivroService(){
        try{
            statement = fazerConexao().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void criarLivro(String titulo,String anopublicacao, String idautor){
        String sql = "INSERT INTO livro (titulo, anopublicacao, idautor) " +
                "VALUES ('" + titulo + "', '" + anopublicacao + "', '" + idautor + "')";
        try{
            statement.executeUpdate(sql);
            System.out.println("\nLivro '" + titulo + "' criado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void mostrarTodosOsLivros(){
        String sql = "SELECT * FROM livro";
        boolean livrosEncontrados = false;
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                livrosEncontrados = true;
                System.out.println("=====LIVROS CADASTRADOS=====");
                System.out.println("ID: " + resultSet.getString("idlivro") +
                        " | Título: " + resultSet.getString("titulo") +
                        " | Autor: " + resultSet.getString("idautor") +
                        " | Ano de publicação: " + resultSet.getString("anopublicacao"));

            }if (!livrosEncontrados){
                System.out.println("Ainda não foi cadastrado nenhum livro.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void consultarLivroPorId(int id){
        String sql = "SELECT * FROM livro WHERE id = " + id;
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                System.out.println("=====LIVRO ENCONTRADO=====");
                System.out.println("ID: " + resultSet.getString("idlivro") +
                        " | Título: " + resultSet.getString("titulo") +
                        " | Autor: " + resultSet.getString("idautor") +
                        " | Ano de publicação: " + resultSet.getString("anopublicacao"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void atualizarLivro(String titulo, String anopublicacao, String idautor) {
        String sql = "UPDATE livro SET titulo = '" + titulo +
                "', anopublicacao = '" + anopublicacao + "', idautor = '" + idautor + "' WHERE id = ";
        try {
            int rowCount = statement.executeUpdate(sql);
            if (rowCount > 0) {
                System.out.println("Livro com nome " + titulo + "foi atualizado com sucesso.");
            } else {
                System.out.println("Livro com nome " + titulo + " não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletarLivro(int id){
        String sql = "DELETE FROM livro WHERE id = " + id;
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
