import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Pessoa {

    private String nome;
    private int idade;
    private ArrayList<Conta> listaContas = new ArrayList<Conta>();
    private String senha;
    private Tempo tempo = new Tempo();
    private static int numPessoas = 0;

    //construtores

    public Pessoa(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        this.senha = tempo.geraHash(senha);
        this.numPessoas++;

    }

    //metodos

        //setters

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        //getters

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        public ArrayList<Conta> getArrayContas() {
            return this.listaContas;
        }

        public int getNumPessoas() { return numPessoas; }

    public boolean valida(String senhaInserida) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        return tempo.comparaHashes(senha, tempo.geraHash(senhaInserida));

    }

    public void adicionaConta(Conta conta) {

        this.listaContas.add(conta);

    }

    public boolean equals (String nome) {

        if (nome.equals(this.nome)) {

            return true;

        } else {

            return false;

        }

    }

    public void imprimeContas () {

        int i = 0;

        if (listaContas.isEmpty()) {

            System.out.println("Não há contas");

        } else {

            for (Conta conta : listaContas) {

                System.out.println("Conta número " + i + ": saldo = " + conta.getSaldo());

            }

        }

    }
}
