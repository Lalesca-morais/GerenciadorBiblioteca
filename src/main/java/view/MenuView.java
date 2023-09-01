package view;

import service.EmprestimoService;
import service.MenuService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    private MenuService menuService;
    private EmprestimoService emprestimoService;
    public int selecionarOpcao(){
        try{
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
            scanner.nextLine();
        }
        return 1;
    }

    public void opcoesEmprestimo(){
        int opcao;
        do {
            menuService.menuEmprestimo();
            opcao = selecionarOpcao();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();

                    System.out.println("Digite o ID do livro: ");
                    int idLivro = Integer.parseInt(scanner.nextLine());

                    System.out.println("Digite a data de devolução (no formato dd/mm/yyyy): ");
                    String dataDevolucao = scanner.nextLine();

                    boolean emprestimoEfetuado = emprestimoService.fazerEmprestimo(nomeUsuario,
                            idLivro, dataDevolucao);
                    if (emprestimoEfetuado) {
                        System.out.println("Empréstimo realizado com sucesso!");
                    } else {
                        System.out.println("O empréstimo não pôde ser efetuado." +
                                " Verifique as informações do livro ou do usuário.");
                    }
                    break;
                case 2:
                    System.out.println("Digite a data de devolução do livro ");
                    String data_devolucao = scanner.nextLine();
                    emprestimoService.renovar(data_devolucao);
                    break;
            }
        } while (opcao != 0);
    }
}
