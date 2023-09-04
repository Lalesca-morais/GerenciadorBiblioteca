package view;

import service.leitorService.LeitorService;
import service.livroService.LivroService;
import service.emprestimoService.MenuEmprestimoService;

public class MenuView {
     LivroService livroService = new LivroService();
     LeitorService leitorService = new LeitorService();
     MenuEmprestimoService menuEmprestimoService;
    public void iniciar() {

        livroService.criarLivro("Dom Quixote", "1", "1605");
        livroService.criarLivro("Harry Potter e a Pedra Filosofal", "2", "1997");
        livroService.criarLivro("Cem Anos de Solidão", "3", "1967");
        livroService.mostrarTodosOsLivros();
        livroService.consultarLivroPorId(1);
        livroService.deletarLivro(2);
        livroService.mostrarTodosOsLivros();

        leitorService.criarLeitor("Lucas","lucas_silva@gmail.com");
        leitorService.criarLeitor("Ana","ana.morais@gmail.com");
        leitorService.criarLeitor("Marina","marina_oliveira@gmail.com");
        leitorService.alterarLeitor("Lucas");
        leitorService.consultaTodosLeitores();
        leitorService.consultarLeitorPorId(3);
        leitorService.deletarLeitores(2);
        leitorService.consultaTodosLeitores();

        menuEmprestimoService.escolhaEmprestimo();
    }
}
