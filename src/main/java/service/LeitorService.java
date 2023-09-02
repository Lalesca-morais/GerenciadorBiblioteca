package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static connection.Conexao.fazerConexao;

public class LeitorService {
    private Statement statement;
    public LeitorService(){
        try{
            statement = fazerConexao().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void criarLeitor(String email, String cpf, String nome) {
        String sql = "INSERT INTO leitores (email, cpf, nome) VALUES ('" +
                email + "', '" + cpf + "', '" + nome + "')";
        try {
            statement.executeUpdate(sql);
            System.out.println("Leitor '" + nome + "' foi adicionado com sucesso no banco!");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void consultaTodosLeitores(){
        String sql = "SELECT * FROM leitores";
        boolean leitoresEncontrados = false;
        try {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                leitoresEncontrados = true;
                System.out.println("ID: " + resultSet.getInt("id") +
                        " | NOME: " + resultSet.getString("nome"));
            }
            if (!leitoresEncontrados) {
                System.out.println("Ainda não foi cadastrado nenhum leitor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void alterarLeitor(String nome) {
        String sql = "UPDATE leitores SET nome = '" + nome + "' WHERE id = ";
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
    public void deletarLeitores(int id){
        String sql = "DELETE FROM leitores WHERE id = " + id;
        try{
            int rowCount = statement.executeUpdate(sql);
            if (rowCount > 0){
                System.out.println("Leitor " + id + " foi deletado com sucesso!");

            }else{
                System.out.println("Leitor " + id + " não encontrado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void consultarLeitorPorId(int id){
        String sql = "SELECT * FROM leitores WHERE id = " + id;
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                System.out.println("=====LEITOR ENCONTRADO=====");
                System.out.println("ID: " + resultSet.getString("id_leitor") +
                        " | E-mail: " + resultSet.getString("email") +
                        " | CPF: " + resultSet.getString("cpf") +
                        " | Nome: " + resultSet.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
