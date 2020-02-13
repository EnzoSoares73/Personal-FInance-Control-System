import java.util.ArrayList;

public class Controle { //essa classe tem a funcao de controlar o sistema, tendo um arrayList de usuarios nela

    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    //metodos

        //getters e setters

        public ArrayList<Pessoa> getListaPessoas() {
            return listaPessoas;
        }

        public void setListaPessoas(ArrayList<Pessoa> listaPessoas) {
            this.listaPessoas = listaPessoas;
        }

    public void adicionaPessoa(Pessoa pessoa) {

        listaPessoas.add(pessoa);

    }

    public void imprimePessoas() {

        int i = 1;

        if (listaPessoas.isEmpty()) {

            System.out.println("Não há usuários");

        } else {

            for (Pessoa pessoa : listaPessoas) {

                System.out.println("Usuário número " + i + ":" + pessoa.getNome());
                i++;

            }

        }

    }


    public void atualiza() { //atualiza todas as contas de todos os usuarios

        for (Pessoa pessoa : getListaPessoas()) {

            for (Conta conta : pessoa.getArrayContas()) {

                for (Categoria categoria : conta.getlistaCategorias()) {

                    for (Lancamento lancamento : categoria.getArrayLancamento()) {

                        conta.setSaldo(conta.getSaldo() + lancamento.aplicaLancamento());

                    }

                }

            }

        }

        //todo: criar um metodo que vai ler todas as informacoes dos arquivos

    }
}
