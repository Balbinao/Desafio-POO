import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Imovel> imoveis = new ArrayList<>();
        Scanner usuario = new Scanner(System.in);

        Proprietario chumbado = new Proprietario("Pedro Augusto", "4002-8922", "111.111.111-11");
        imoveis.add(new Casa("Rua da Tereza", 100, chumbado, 1500));


        while (true) {
            System.out.println("\n--- MENU---");
            System.out.println("1 - Cadastrar Casa");
            System.out.println("2 - Cadastrar Apartamento");
            System.out.println("3 - Listar Imóveis");
            System.out.println("4 - Alugar Imóvel");
            System.out.println("5 - Disponibilizar Imóvel");
            System.out.println("6 - Calcular Aluguel");
            System.out.println("7 - Deletar Imóvel");
            System.out.println("8 - Listar imóveis alugados");
            System.out.println("0. Sair");
            System.out.print("Escolha um número: ");
            int opcao = usuario.nextInt();
            usuario.nextLine();

            if (opcao == 0)
                break;

            switch (opcao) {
                case 1 -> {
                    System.out.print("Endereço: ");
                    String end = usuario.nextLine();
                    System.out.print("Número: ");
                    int num = usuario.nextInt();
                    usuario.nextLine();
                    System.out.print("Nome do proprietário: ");
                    String nome = usuario.nextLine();
                    System.out.print("Telefone: ");
                    String tel = usuario.nextLine();
                    System.out.print("CPF: ");
                    String cpf = usuario.nextLine();
                    System.out.print("Valor do aluguel: ");
                    int valor = usuario.nextInt();

                    Proprietario p = new Proprietario(nome, tel, cpf);
                    imoveis.add(new Casa(end, num, p, valor));
                    System.out.println("Casa cadastrada em nosso sistema!");
                }

                case 2 -> {
                    System.out.print("Endereço: ");
                    String end = usuario.nextLine();
                    System.out.print("Número do apartamento: ");
                    int num = usuario.nextInt();
                    usuario.nextLine();
                    System.out.print("Nome do proprietário: ");
                    String nome = usuario.nextLine();
                    System.out.print("Telefone: ");
                    String tel = usuario.nextLine();
                    System.out.print("CPF: ");
                    String cpf = usuario.nextLine();
                    System.out.print("Valor do aluguel: ");
                    int valor = usuario.nextInt();

                    Proprietario p = new Proprietario(nome, tel, cpf);
                    imoveis.add(new Apartamento(end, num, p, valor));
                    System.out.println("Apartamento cadastrada em nosso sistema!");
                }

                case 3 -> {
                    if (imoveis.isEmpty()) System.out.println("Nenhum imóvel cadastrado.");
                    else {
                        int i = 0;
                        for (Imovel imo : imoveis) {
                            System.out.println(i + " - " + imo);
                            imo.estaAlugado();
                            System.out.println("Contato do proprietário: " + imo.contatoProprietario() + "\n");
                            if (imo.alugado) {
                                System.out.println("Inquilino: " + imo.getInquilino() +"\n"); // mostra somente se alugado
                            }
                            i++;
                        }
                    }
                }

                case 4 -> {
                    System.out.print("Informe o numero do imóvel: ");
                    int numImovel = usuario.nextInt();
                    usuario.nextLine();

                    if (numImovel >= 0 && numImovel < imoveis.size() && !imoveis.get(numImovel).alugado) {
                        System.out.print("Nome do inquilino: ");
                        String nomeInq = usuario.nextLine();
                        System.out.print("Telefone do inquilino: ");
                        String telInq = usuario.nextLine();
                        System.out.print("CPF do inquilino: ");
                        String cpfInq = usuario.nextLine();
                        System.out.print("Meses de contrato: ");
                        int meses = usuario.nextInt();

                        imoveis.get(numImovel).alugado = true;
                        imoveis.get(numImovel).setInquilino(new Inquilino(nomeInq, telInq, cpfInq));

                        int valorTotal = imoveis.get(numImovel).calcularAluguel(meses);
                        System.out.println("Imóvel alugado com sucesso!");
                        System.out.println("Valor total: R$" + valorTotal);

                    } else {
                        System.out.println("Índice inválido ou imóvel já alugado.");
                    }
                }

                case 5 -> {
                    System.out.print("Informe o numero do imóvel: ");
                    int numImovel = usuario.nextInt();

                    if (numImovel >= 0 && numImovel < imoveis.size()) {
                        imoveis.get(numImovel).alugado = false;
                        imoveis.get(numImovel).estaAlugado();
                    } else System.out.println("Número inválido!");
                }

                case 6 -> {
                    System.out.print("Informe o numero do imóvel: ");
                    int numImovel = usuario.nextInt();
                    System.out.print("Informe a quantidade de meses para o aluguel: ");
                    int meses = usuario.nextInt();

                    if (numImovel >= 0 && numImovel < imoveis.size()) {
                        int valorTotal = imoveis.get(numImovel).calcularAluguel(meses);
                        System.out.println("Valor total: R$" + valorTotal);

                    } else System.out.println("Número inválido!");
                }

                case 7 -> {
                    System.out.print("Informe o numero do imóvel para deletar: ");
                    int numImovel = usuario.nextInt();

                    if (numImovel >= 0 && numImovel < imoveis.size()) {
                        imoveis.remove(numImovel);
                        System.out.println("Imóvel removido com sucesso.");
                    } else System.out.println("Número inválido!");
                }

                case 8 -> {
                    System.out.println("Imóveis alugados:");
                    for (Imovel imo : imoveis) {
                        if (imo.alugado && imo.getInquilino() != null)

                            System.out.println("Inquilino: " + imo.getInquilino() + "\n");
                    }
                }

                default -> System.out.println("Opção inválida!");
            }
        }
    }
}