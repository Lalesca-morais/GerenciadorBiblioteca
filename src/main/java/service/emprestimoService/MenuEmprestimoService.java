package service.emprestimoService;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MenuEmprestimoService {
        private Scanner scanner;
        private EmprestimoService emprestimoService;
        public MenuEmprestimoService(EmprestimoService emprestimoService) {
            scanner = new Scanner(System.in);
            this.emprestimoService = new EmprestimoService();
        }
        public void escolhaEmprestimo() {
            int opcao;
            do {
                menuEmprestimo();
                opcao = selecionarOpcao();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();

                    System.out.println("Digite o ID do livro: ");
                    int idLivro = Integer.parseInt(scanner.nextLine());

                    System.out.println("Digite a data de devolução (no formato dd/mm/yyyy): ");
                    String dataDevolucao = scanner.nextLine();

                    boolean emprestimoEfetuado = emprestimoService.fazerEmprestimo
                            (nomeUsuario, idLivro, dataDevolucao);
                    if (emprestimoEfetuado) {
                        System.out.println("Empréstimo realizado com sucesso!");
                    } else {
                        System.out.println("O empréstimo não pôde ser efetuado." +
                                " Verifique as informações do livro ou do usuário.");
                    }
                    break;
                    case 2:
                        System.out.println("Digite a data de devolução do livro ");
                        Date data_devolucao = Date.valueOf(scanner.nextLine());
                         emprestimoService.renovar(data_devolucao);
                        break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente!");
                        break;
                }
            } while (opcao != 0);
        }
        private void menuEmprestimo() {
            System.out.println("Digite uma das seguintes opções:");
            System.out.println("1 - Fazer um empréstimo");
            System.out.println("2 - Renovar meu empréstimo");
            System.out.println("0 - Sair");
        }
        private int selecionarOpcao() {
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
}


