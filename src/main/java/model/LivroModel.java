package model;

public class LivroModel {
    private String id_livro;
    private String titulo;
    private String id_autor;
    private String ano_publicacao;

    public String getId_livro() {
        return id_livro;
    }

    public void setId_livro(String id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getId_autor() {
        return id_autor;
    }

    public void setId_autor(String id_autor) {
        this.id_autor = id_autor;
    }

    public String getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(String ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }
}
