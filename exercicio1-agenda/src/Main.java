import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcao;

        do {

            System.out.println("\n=== AGENDA TELEFONICA ===");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato por nome");
            System.out.println("4 - Buscar contato por email");
            System.out.println("5 - Buscar contato por telefone");
            System.out.println("6 - Consultar tamanho da agenda");
            System.out.println("7 - Finalizar");
            System.out.print("Escolha uma opcao: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {

                case 1:

                    System.out.println("\n1 - Contato pessoal");
                    System.out.println("2 - Contato profissional");
                    System.out.println("3 - Contato de emergencia");
                    System.out.print("Escolha o tipo: ");

                    int tipo = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    if (tipo == 1) {

                        System.out.print("Data de aniversario: ");
                        String dataAniversario = scanner.nextLine();

                        System.out.print("Parentesco: ");
                        String parentesco = scanner.nextLine();

                        ContatoPessoal contato =
                                new ContatoPessoal(nome, email, telefone,
                                        dataAniversario, parentesco);

                        agenda.adicionarContato(contato);

                        System.out.println("Contato adicionado com sucesso.");

                    } else if (tipo == 2) {

                        System.out.print("Empresa: ");
                        String empresa = scanner.nextLine();

                        System.out.print("Cargo: ");
                        String cargo = scanner.nextLine();

                        ContatoProfissional contato =
                                new ContatoProfissional(nome, email, telefone,
                                        empresa, cargo);

                        agenda.adicionarContato(contato);

                        System.out.println("Contato adicionado com sucesso.");

                    } else if (tipo == 3) {

                        System.out.print("Grau de prioridade (1 a 5): ");
                        int prioridade = Integer.parseInt(scanner.nextLine());

                        System.out.print("Observacao: ");
                        String observacao = scanner.nextLine();

                        ContatoEmergencia contato =
                                new ContatoEmergencia(nome, email, telefone,
                                        prioridade, observacao);

                        agenda.adicionarContato(contato);

                        System.out.println("Contato adicionado com sucesso.");

                    } else {
                        System.out.println("Tipo invalido.");
                    }

                    break;

                case 2:

                    System.out.print("Nome do contato que deseja remover: ");
                    String nomeRemover = scanner.nextLine();

                    if (agenda.removerContato(nomeRemover)) {
                        System.out.println("Contato removido com sucesso.");
                    } else {
                        System.out.println("Contato nao encontrado.");
                    }

                    break;

                case 3:

                    System.out.print("Nome: ");
                    String nomeBusca = scanner.nextLine();

                    Contato contatoNome = agenda.buscarPorNome(nomeBusca);

                    if (contatoNome != null) {
                        contatoNome.exibirDados();
                    } else {
                        System.out.println("Contato nao encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("Email: ");
                    String emailBusca = scanner.nextLine();

                    Contato contatoEmail = agenda.buscarPorEmail(emailBusca);

                    if (contatoEmail != null) {
                        contatoEmail.exibirDados();
                    } else {
                        System.out.println("Contato nao encontrado.");
                    }

                    break;

                case 5:

                    System.out.print("Telefone: ");
                    String telefoneBusca = scanner.nextLine();

                    Contato contatoTelefone =
                            agenda.buscarPorTelefone(telefoneBusca);

                    if (contatoTelefone != null) {
                        contatoTelefone.exibirDados();
                    } else {
                        System.out.println("Contato nao encontrado.");
                    }

                    break;

                case 6:

                    System.out.println(
                            "Quantidade de contatos: "
                                    + agenda.getQuantidadeContatos()
                    );

                    break;

                case 7:

                    System.out.println("Programa finalizado.");
                    break;

                default:

                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 7);

        scanner.close();
    }
}