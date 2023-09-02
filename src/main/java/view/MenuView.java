package view;

import service.LeitorService;
import service.LivroService;
import service.emprestimo.MenuEmprestimoService;

public class MenuView {
    private LivroService livroService;
    private LeitorService leitorService;
    private MenuEmprestimoService menuEmprestimoService;
    public MenuView() {
        livroService = new LivroService();
        leitorService = new LeitorService();
    }
    public void iniciar() {

        livroService.criarLivro("Dom Quixote", "1", "1605");
        livroService.criarLivro("Harry Potter e a Pedra Filosofal", "2", "1997");
        livroService.criarLivro("Cem Anos de Solidão", "3", "1967");
        livroService.mostrarTodosOsLivros();
        livroService.consultarLivroPorId(1);
        livroService.deletarLivro(2);
        livroService.mostrarTodosOsLivros();

        leitorService.criarLeitor("lucas_silva@gmail.com", "8332571093", "Lucas");
        leitorService.criarLeitor("ana.morais@gmail.com", "98537253718", "Ana");
        leitorService.criarLeitor("marina_oliveira@gmail.com", "642849275284", "Marina");
        leitorService.alterarLeitor("Lucas");
        leitorService.consultaTodosLeitores();
        leitorService.consultarLeitorPorId(3);
        leitorService.deletarLeitores(2);
        leitorService.consultaTodosLeitores();

        menuEmprestimoService.escolhaEmprestimo();
    }
}
