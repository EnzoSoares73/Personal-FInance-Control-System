public class DespesaUnica extends Despesa {

    public double aplicaLancamento() {

        if (getPaga() == false && (getTempo().geraDiferencaEntreDuasDatasEmDias(getTempo().geraDataAtual(), getDataDoPagamento())) >= 0 ) { //verifica se ja foi Paga e se a data do pagamento é antes ou depois da data atual

            setPaga(true); //o despesa se torna Paga

            return getValor()*-1;

        } else {

            return 0;

        } //se o despesa ainda não foi aplicado, setPaga recebe true e retorna-se o valor do lançamento para o metodo executaLançamento da classe Tempo. Se não, retorna 0;

    }

    @Override
    public void imprimeLancamento() {

            System.out.println(getNomeLancamento());
            System.out.println(this.getClass().getSimpleName());
            System.out.println("Valor = " + getValor());
            System.out.println("Data de vencimento = " + getTempo().converteDataEmString(getDataVencimento()));

        if (getPaga() == true) {

            System.out.println("Já recebido");

        } else {

            System.out.println("Ainda não recebido");

        }

    }

}
