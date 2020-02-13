import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu { //armazena os metodos relativos ao menu principal

    private Scanner scan = new Scanner(System.in);
    private Tempo tempo = new Tempo();

    //metodos

    public int menuPrincipal() throws UnsupportedEncodingException, NoSuchAlgorithmException {

        int escolha;

        System.out.println("O que você deseja fazer?\n" +
                            "0. Sair\n" +
                            "1. Criar novo usuário\n" +
                            "2. Entrar com um existente\n");

        escolha = scan.nextInt();

        return escolha;

    }

    public int menuConta() {

        int escolha;

        System.out.println("O que você deseja fazer?\n" +
                "0. Sair\n" +
                "1. Criar categoria\n" +
                "2. Criar lançamento\n" +
                "3. Ver saldo\n" +
                "4. Ver lançamentos\n");
        escolha = scan.nextInt();

        return escolha;

    }

    public int menuUsuario() {

        int escolha;

            System.out.println("O que você deseja fazer?\n" +
                                "0. Sair\n" +
                                "1. Criar nova conta\n" +
                                "2. Usar um existente\n");

            escolha = scan.nextInt();

        return escolha;

    }

    public Pessoa criaPessoa(Controle controle) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        String nome;
        String senha;

        boolean permissao = true;

        do {

            System.out.println("Você está criando um novo usuário. Insira seu nome");
            nome = scan.next();
            permissao = true;

            for (Pessoa pessoa : controle.getListaPessoas()) {

                if (pessoa.getNome().equals(nome)) {

                    System.out.println("Esse usuário já existe");
                    permissao = false;

                }

            }

        } while (permissao == false);

        System.out.println("Insira sua senha");
        senha = scan.next();
        Pessoa pessoa = new Pessoa(senha);
        pessoa.setNome(nome);

        System.out.println("Insira sua idade");
        pessoa.setIdade(scan.nextInt());

        System.out.println("Uma nova conta será criada com o usuário");

        pessoa.adicionaConta(criaConta(pessoa));

        return pessoa;

    }

    public Conta criaConta(Pessoa pessoa) {

        System.out.println("Você está criando uma nova conta: o identificador da conta é " + pessoa.getArrayContas().size() + "\n\n\n");
        Conta conta = new Conta();

        return conta;

    }

    public Categoria criaCategoria() {

        Categoria categoria = new Categoria();

        System.out.println("Você está criando uma nova categoria: insira o o nome dela");
        categoria.setNomeCategoria(scan.next());

        return categoria;

    }

    public Lancamento criaLancamento() throws ParseException {

        int escolha;
        Lancamento lancamento = null;

        System.out.println("Você está criando um novo lançamento. Escolha uma das 4 alternativas:\n" +
                            "1. Recebimento único\n" +
                            "2. Recebimento recorrente\n" +
                            "3. Despesa única\n" +
                            "4. Despesa recorrente");

        escolha = scan.nextInt();

        if (escolha == 1) {

            lancamento = new RecebimentoUnico();

        } else if (escolha == 2) {

            lancamento = new RecebimentoRecorrente();

        } else if (escolha == 3) {

            lancamento = new DespesaUnica();

        } else if (escolha == 4) {

            lancamento = new DespesaRecorrente();

        }

        System.out.println("Nome do lançamento?");
        lancamento.setNomeLancamento(scan.next());
        
        System.out.println("Valor?");
        lancamento.setValor(scan.nextInt());
        
        lancamento.setDataEntradaDoLancamento(tempo.geraDataAtual());
        
        if (lancamento instanceof Recebimento) {
            
            lancamento.setRecebedor("Usuário");
            
            System.out.println("Nome do devedor?");
            lancamento.setDevedor(scan.next());

            System.out.println("Dia em que receberá o primeiro ou único pagamento?");
            ((Recebimento) lancamento).setDataDoPagamento(tempo.converteStringEmData(scan.next()));

            if (lancamento instanceof RecebimentoRecorrente) {

                System.out.println("Taxa de recorrência em dias?");
                ((RecebimentoRecorrente) lancamento).setRecorrencia(scan.nextInt());

                System.out.println("Data do último pagamento?");
                ((RecebimentoRecorrente) lancamento).setdataUltimoPagamento(tempo.converteStringEmData(scan.next()));

                System.out.println("Escolha o tipo dos juros:\n" +
                                    "1. Simples\n" +
                                    "2. Compostos\n" +
                                    "3. Nenhum");

                int escolhaJuros = scan.nextInt();

                if (escolhaJuros != 3) {

                    System.out.println("Insira o valor dos juros");
                    
                    if (escolhaJuros == 1) { //simples
                        
                        ((RecebimentoRecorrente) lancamento).setJurosSimples(scan.nextDouble());
                        
                    } else if (escolhaJuros == 2) { //compostos

                        ((RecebimentoRecorrente) lancamento).setJurosCompostos(scan.nextDouble());
                        
                    }

                }

            }

        } else if (lancamento instanceof Despesa) {

            lancamento.setDevedor("Usuário");

            System.out.println("Nome do recebedor?");
            lancamento.setRecebedor(scan.next());

            System.out.println("Dia em que pagará o primeiro ou único pagamento?");
            ((Despesa) lancamento).setDataVencimento(tempo.converteStringEmData(scan.next()));

            if (lancamento instanceof DespesaRecorrente) {

                System.out.println("Taxa de recorrência em dias?");
                ((DespesaRecorrente) lancamento).setRecorrencia(scan.nextInt());

                System.out.println("Data do último pagamento?");
                ((DespesaRecorrente) lancamento).setdataUltimoPagamento(tempo.converteStringEmData(scan.next()));

                System.out.println("Escolha o tipo dos juros:\n" +
                        "1. Simples\n" +
                        "2. Compostos\n" +
                        "3. Nenhum");

                int escolhaJuros = scan.nextInt();

                if (escolhaJuros != 3) {

                    System.out.println("Insira o valor dos juros");

                    if (escolhaJuros == 1) { //simples

                        ((DespesaRecorrente) lancamento).setJurosSimples(scan.nextDouble());

                    } else if (escolhaJuros == 2) { //compostos

                        ((DespesaRecorrente) lancamento).setJurosCompostos(scan.nextDouble());

                    }

                }

            }

        }

        System.out.println("Lancamento criado com sucesso!");

        return lancamento;

    }

}
