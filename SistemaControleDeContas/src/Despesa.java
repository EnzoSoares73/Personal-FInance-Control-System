import java.util.Date;

public abstract class Despesa extends Lancamento {

    private Date dataVencimento; //data máxima em que a despesa deve ser paga ou deve começar a ser paga
    private Date dataDoPagamento; //data em que a despesa efetivamente foi paga
    private boolean paga = false;

    //metodos

        //getters

        public Date getDataDoPagamento() {

            return this.dataDoPagamento;

        }

        public Date getDataVencimento() {

            return this.dataVencimento;

        }

        public boolean getPaga() {
            return paga;
        }

    //setters

        public void setDataDoPagamento(Date dataDoPagamento) {

            this.dataDoPagamento = dataDoPagamento;

        }

        public void setDataVencimento(Date dataVencimento) {

            this.dataVencimento = dataVencimento;

        }

        public void setPaga(boolean paga) {
            this.paga = paga;
        }

}
