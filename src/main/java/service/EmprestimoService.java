package service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import static connection.Conexao.fazerConexao;

public class EmprestimoService {
    Date hoje = new Date();
    Calendar calendar = Calendar.getInstance();
    private int renovacoes = 0;
    private Statement statement;
    private Date dataDevolucao;
    public EmprestimoService(){
        try{
            statement = fazerConexao().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void renovar(String data_devolucao) {
        if (dataDevolucao == null) {
            if (!jaRenovado()) {
                calendar.setTime(hoje);
                calendar.add(Calendar.DAY_OF_MONTH, 15);
                dataDevolucao = calendar.getTime();
                renovacoes++;
            } else {
                throw new RuntimeException("Este empréstimo já foi renovado o número máximo de vezes.");
            }
        } else {
            throw new RuntimeException("Não é possível renovar um empréstimo já devolvido.");
        }
    }
    public boolean jaRenovado() {
        return renovacoes > 0;
    }
    public boolean fazerEmprestimo(String id_usuario, int id_livro, String dataDevolucao) {
        String sql = "INSERT INTO emprestimo (id_usuario, id_livro, dataDevolucao) " +
                "VALUES ('" + id_usuario + "', " + id_livro + ", '" + dataDevolucao + "')";
        try {
            statement.executeUpdate(sql);
            System.out.println("O empréstimo foi realizado com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
