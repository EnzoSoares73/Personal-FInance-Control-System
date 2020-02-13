public class RecebimentoUnico extends Recebimento {

    //metodos

    public double aplicaLancamento() {

        if (isRecebido() == false && (getTempo().geraDiferencaEntreDuasDatasEmDias(getTempo().geraDataAtual(), getDataDoPagamento())) >= 0 ) { //verifica se ja foi recebido e se a data do pagamento é antes ou depois da data atual

            setRecebido(true); //o recebimento se torna recebido

            return getValor();

        } else {

            return 0;

        } //se o recebimento ainda não foi aplicado, setRecebido recebe true e retorna-se o valor do lançamento para o metodo executaLançamento da classe Tempo. Se não, retorna 0;

    }

    @Override
    public void imprimeLancamento() {

        System.out.println(getNomeLancamento());
        System.out.println(this.getClass().getSimpleName());
        System.out.println("Valor = " + getValor());
        System.out.println("Data de recebimento = " + getTempo().converteDataEmString(getDataDoPagamento()));

        if (isRecebido() == true) {

            System.out.println("Já recebido");

        } else {

            System.out.println("Ainda não recebido");

        }

    }

}
