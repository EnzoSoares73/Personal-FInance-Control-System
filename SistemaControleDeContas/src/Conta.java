import java.util.ArrayList;

public class Conta {

    private int numCategorias = 0;
    private ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
    private double saldo = 0;

    //metodos

        //getters

        public ArrayList<Categoria> getlistaCategorias() {

            return this.listaCategorias;

        }

        public int getNumCategorias() {
            return numCategorias;
        }

        public double getSaldo() {

            return saldo;

        }

        //setters

        public void setSaldo(double saldo) {

            this.saldo = saldo;

        }

    public void adicionaCategoria(Categoria categoria) {

            listaCategorias.add(categoria);
            this.numCategorias++;

    }

    public void listCategorias() {

        for (Categoria categoria : listaCategorias) {

            System.out.println(categoria.getNomeCategoria());

        }

    }


    public void imprimeCategorias() {

            int i = 0;

            if (listaCategorias.isEmpty()) {

                System.out.println("Não há categorias");

            } else {

                for (Categoria categoria : listaCategorias) {

                    System.out.println(i + ": " + categoria.getNomeCategoria() + "\n");

                }

                System.out.println("\n");

            }

    }
}
