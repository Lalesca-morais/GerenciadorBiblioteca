package service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuService {
    private LivroService livroService;
    private LeitorService leitorService;
    private EmprestimoService emprestimoService;

    public void MenuView() {
        Scanner scanner = new Scanner(System.in);
        livroService = new LivroService();
        leitorService = new LeitorService();
        emprestimoService = new EmprestimoService();
    }
    public int selecionarOpcao() {
        Scanner scanner = null;
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
        }
        return 1;
    }
    public void menuEmprestimo() {
        System.out.println("Digite uma das seguinte opções");
        System.out.println("1 - Fazer um empréstimo");
        System.out.println("2 - Renovar meu empréstimo");
        System.out.println("0 - Sair");
    }

}
