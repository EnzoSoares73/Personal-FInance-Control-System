import java.util.ArrayList;

public class Categoria {

    private String nomeCategoria;
    private int numLancamentos = 0;
    private ArrayList<Lancamento> listaLancamentos= new ArrayList<Lancamento>();

    //metodos

        //getters

        public String getNomeCategoria() {

            return this.nomeCategoria;

        }

        public ArrayList<Lancamento> getArrayLancamento() {

            return this.listaLancamentos;

        }

        //setters

        public void setNomeCategoria(String nomeCategoria) {

            this.nomeCategoria = nomeCategoria;

        }

    public void adicionaLancamento(Lancamento lancamento) {

            listaLancamentos.add(lancamento);

    }

    public void imprimeLancamentos() {

            int i = 0;

            if (listaLancamentos.isEmpty()) {

                System.out.println("Não há lançamentos");

            } else {

                for (Lancamento lancamento : listaLancamentos) {

                    lancamento.imprimeLancamento();
                    System.out.println("\n\n\n");

                }

            }

    }

}
