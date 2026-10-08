import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bilheteria bilheteria = new Bilheteria();

        int opcao;

        do {

            System.out.println("\n=== BILHETERIA ===");
            System.out.println("1 - Cadastrar ingresso");
            System.out.println("2 - Remover ingresso");
            System.out.println("3 - Buscar ingresso por codigo");
            System.out.println("4 - Listar todos os ingressos");
            System.out.println("5 - Calcular arrecadacao total");
            System.out.println("6 - Listar beneficios dos ingressos");
            System.out.println("7 - Finalizar");
            System.out.print("Escolha uma opcao: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {

                case 1:

                    System.out.println("\n1 - Ingresso comum");
                    System.out.println("2 - Ingresso estudante");
                    System.out.println("3 - Ingresso VIP");
                    System.out.print("Escolha o tipo: ");

                    int tipo = Integer.parseInt(scanner.nextLine());

                    System.out.print("Codigo: ");
                    int codigo = Integer.parseInt(scanner.nextLine());

                    if (bilheteria.buscarIngresso(codigo) != null) {
                        System.out.println("Ja existe um ingresso com esse codigo.");
                        break;
                    }

                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();

                    System.out.print("Setor: ");
                    String setor = scanner.nextLine();

                    System.out.print("Valor base: ");
                    double valorBase = Double.parseDouble(scanner.nextLine());

                    if (tipo == 1) {

                        Ingresso ingresso =
                                new IngressoComum(
                                        codigo,
                                        nomeEvento,
                                        setor,
                                        valorBase
                                );

                        bilheteria.adicionarIngresso(ingresso);

                        System.out.println("Ingresso cadastrado com sucesso.");

                    } else if (tipo == 2) {

                        System.out.print("Instituicao de ensino: ");
                        String instituicao = scanner.nextLine();

                        Ingresso ingresso =
                                new IngressoEstudante(
                                        codigo,
                                        nomeEvento,
                                        setor,
                                        valorBase,
                                        instituicao
                                );

                        bilheteria.adicionarIngresso(ingresso);

                        System.out.println("Ingresso cadastrado com sucesso.");

                    } else if (tipo == 3) {

                        System.out.print("Possui acesso ao backstage? (s/n): ");
                        String resposta = scanner.nextLine();

                        boolean backstage =
                                resposta.equalsIgnoreCase("s");

                        System.out.print("Numero do lounge: ");
                        int lounge = Integer.parseInt(scanner.nextLine());

                        Ingresso ingresso =
                                new IngressoVIP(
                                        codigo,
                                        nomeEvento,
                                        setor,
                                        valorBase,
                                        backstage,
                                        lounge
                                );

                        bilheteria.adicionarIngresso(ingresso);

                        System.out.println("Ingresso cadastrado com sucesso.");

                    } else {

                        System.out.println("Tipo invalido.");
                    }

                    break;

                case 2:

                    System.out.print("Codigo do ingresso: ");
                    int codigoRemover =
                            Integer.parseInt(scanner.nextLine());

                    if (bilheteria.removerIngresso(codigoRemover)) {

                        System.out.println("Ingresso removido com sucesso.");

                    } else {

                        System.out.println("Ingresso nao encontrado.");
                    }

                    break;

                case 3:

                    System.out.print("Codigo do ingresso: ");
                    int codigoBusca =
                            Integer.parseInt(scanner.nextLine());

                    Ingresso ingresso =
                            bilheteria.buscarIngresso(codigoBusca);

                    if (ingresso != null) {

                        System.out.println();
                        ingresso.exibirInformacoes();

                    } else {

                        System.out.println("Ingresso nao encontrado.");
                    }

                    break;

                case 4:

                    bilheteria.listarIngressos();
                    break;

                case 5:

                    System.out.printf(
                            "Arrecadacao total: R$ %.2f%n",
                            bilheteria.calcularArrecadacaoTotal()
                    );

                    break;

                case 6:

                    bilheteria.listarBeneficios();
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