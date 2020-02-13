import java.util.Date;

public abstract class Recebimento extends Lancamento {

    private Date dataDoPagamento; //dia em que a pessoa vai receber o primeiro ou único recebimento
    private boolean recebido = false;

    //metodos

        //getters

        public Date getDataDoPagamento() {

            return this.dataDoPagamento;

        }

        public boolean isRecebido() {
            return recebido;
        }

    //setters

        public void setDataDoPagamento(Date dataDoPagamento) {

            this.dataDoPagamento = dataDoPagamento;

        }

        public void setRecebido(boolean recebido) {
            this.recebido = recebido;
        }

}
