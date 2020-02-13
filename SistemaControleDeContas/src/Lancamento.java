import java.util.Date;

public abstract class Lancamento {

    private String nomeLancamento;
    private double valor; //valor a ser pago unicamente ou valor a ser pago to_do mes.
    private Date dataEntradaDoLancamento; //dia em que o sistema recebeu o lancamento
    private String recebedor;
    private String devedor;

    private Tempo tempo = new Tempo();

    //metodos

        //setters

        public void setNomeLancamento(String nomeLancamento) {

            this.nomeLancamento = nomeLancamento;

        }

        public void setRecebedor(String recebedor) {

            this.recebedor = recebedor;

        }

        public void setDevedor(String devedor) {

            this.devedor = devedor;

        }

        public void setValor(double valor) {

            this.valor = valor;

            if (this instanceof RecebimentoRecorrente) {

                ((RecebimentoRecorrente) this).setValorInicial(valor);

            }

        }

        public void setDataEntradaDoLancamento(Date dataEntradaDoLancamento) {

            this.dataEntradaDoLancamento = dataEntradaDoLancamento;

        }

        //getters

        public String getNomeLancamento() {

            return this.nomeLancamento;

        }

        public double getValor() {

            return this.valor;

        }

        public Date getDataEntradaDoLancamento() {

            return this.dataEntradaDoLancamento;

        }

        public String getRecebedor() {

            return this.recebedor;

        }

        public String getDevedor() {

            return this.devedor;

        }

        public Tempo getTempo() {
            return tempo;
        }

        public abstract double aplicaLancamento();

        public abstract void imprimeLancamento();

        //todo: criar um metodo abstrato de escrever as informacoes de cada lancamento em um arquivo e implementa-lo em cada subclasse. Um metodo similar deve ser implemetado em Pessoa e Categoria
}
