package model;

import java.time.LocalDate;

public class EmprestimoModel {
    private LocalDate data_emprestimo;
    private String id;
    private String nome;
    private String leitor;
    private String id_emprestimo;
    private LocalDate data_devolucao;
    public EmprestimoModel(LocalDate data_emprestimo, String id, String nome, String leitor, String id_emprestimo,
                           LocalDate data_devolucao) {
        this.data_emprestimo = data_emprestimo;
        this.id = id;
        this.nome = nome;
        this.leitor = leitor;
        this.id_emprestimo = id_emprestimo;
        this.data_devolucao = data_devolucao;
    }
    public LocalDate getData_devolucao() {
        return data_devolucao;
    }
    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLeitor() {
        return leitor;
    }

    public void setLeitor(String leitor) {
        this.leitor = leitor;
    }

    public String getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(String id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }
}
