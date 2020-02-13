import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, UnsupportedEncodingException, NoSuchAlgorithmException {

        Controle controle = new Controle();
        Tempo tempo = new Tempo();
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);

        /*
        Insira aqui todas as leituras de dados dos arquivos na forma de um metodo na classe controle
         */

        int escolha;

        System.out.println("Bem-vindo");

        do {

            controle.atualiza();

            escolha = menu.menuPrincipal();

            if (escolha == 1) { //cria novo usuario

                controle.adicionaPessoa(menu.criaPessoa(controle));

            } else if (escolha == 2) { //tenta logar em um dos usuarios existentes

                if (controle.getListaPessoas().isEmpty() == false) {

                    String nome;
                    controle.imprimePessoas();

                    System.out.println("Insira o nome do usuário");
                    nome = scan.nextLine();

                    for (Pessoa pessoa : controle.getListaPessoas()) {

                        if (pessoa.equals(nome)) {

                            System.out.println("Usuário encontrado! Insira a senha");
                            String senha = scan.next();

                            while (pessoa.valida(senha) == false) {

                                System.out.println("Senha errada. Tente novamente");
                                senha = scan.next();


                            }

                            System.out.println("Senha correta. Logando...");

                            int escolha1 = menu.menuUsuario();

                            switch (escolha1) {

                                case 1:

                                    pessoa.adicionaConta(menu.criaConta(pessoa));

                                    break;

                                case 2:

                                    pessoa.imprimeContas();
                                    System.out.println("Digite o identificador de uma das contas");
                                    int idConta = scan.nextInt();

                                    int escolha2 = menu.menuConta();

                                    while (escolha2 != 0) {

                                        int idCategoria;

                                        switch (escolha2) {

                                            case 1:

                                                pessoa.getArrayContas().get(idConta).imprimeCategorias();
                                                pessoa.getArrayContas().get(idConta).adicionaCategoria(menu.criaCategoria());

                                                break;

                                            case 2:

                                                pessoa.getArrayContas().get(idConta).imprimeCategorias();

                                                if (pessoa.getArrayContas().get(idConta).getlistaCategorias().isEmpty() == false) {

                                                    System.out.println("Digite o identificador da categoria onde você quer criar o lançamento");
                                                    idCategoria = scan.nextInt();

                                                    pessoa.getArrayContas().get(idConta).getlistaCategorias().get(idCategoria).adicionaLancamento(menu.criaLancamento());
                                                }

                                                break;

                                            case 3:

                                                System.out.println(pessoa.getArrayContas().get(idConta).getSaldo());

                                                break;

                                            case 4:

                                                pessoa.getArrayContas().get(idConta).imprimeCategorias();
                                                System.out.println("Digite o identificador da categoria");
                                                idCategoria = scan.nextInt();

                                                pessoa.getArrayContas().get(idConta).getlistaCategorias().get(idCategoria).imprimeLancamentos();

                                            break;

                                        }

                                        escolha2 = menu.menuConta();

                                    }

                                    break;

                            }

                        }
                    }

                } else {

                    System.out.println("Nenhum usuário encontrado\n\n\n\n");

                }


            }

        } while(escolha != 0);

        System.out.println("Programa encerrado");
    }
}
