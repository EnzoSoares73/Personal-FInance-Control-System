import java.util.Date;

public class DespesaRecorrente extends Despesa {

    private int recorrencia; //periodo até o recebimento ser aplicado novamente em dias
    private double jurosSimples;
    private double jurosCompostos;
    private double valorInicial = getValor();
    private Date dataUltimoPagamento; //data em que o recebimento parará de ser recebido
    private Date dataDoUltimoPagamentoAplicado = getDataVencimento();
    private double valorASerPago = 0;

    private Tempo tempo = new Tempo();

    //metodos

    //setters

    public void setRecorrencia(int recorrencia) {
        this.recorrencia = recorrencia;
    }

    public void setValorInicial(double valorInicial) { this.valorInicial = valorInicial; }

    public void setJurosSimples(double jurosSimples) {
        this.jurosSimples = jurosSimples;
        jurosCompostos = 0 ;
    }

    public void setJurosCompostos(double jurosCompostos) {
        this.jurosCompostos = jurosCompostos;
        jurosSimples = 0;
    }

    public void setdataUltimoPagamento(Date dataUltimoPagamento) {
        this.dataUltimoPagamento = dataUltimoPagamento;
    }

    public void setDataDoUltimoPagamentoAplicado (Date dataDoUltimoPagamentoAplicado) { this.dataDoUltimoPagamentoAplicado = dataDoUltimoPagamentoAplicado; }

    //getters

    public int getRecorrencia() {
        return this.recorrencia;
    }

    public double getJurosSimples() {
        return this.jurosSimples;
    }

    public double getJurosCompostos() {
        return this.jurosCompostos;
    }

    public Date getdataUltimoPagamento() {
        return this.dataUltimoPagamento;
    }

    public double getValorInicial() {return this.valorInicial; }

    public Date getDataDoUltimoPagamentoAplicado() { return dataDoUltimoPagamentoAplicado; }

    public double aplicaLancamento()  {

        Date data = new Date(); //essa variavel vai servir para comparar qual data está mais para frente:DataAtual ou DataDoUltimoPagamento; esta data escolhida vai ser usada para saber até quando lançamento vai ser aplicado.

        if (tempo.geraDiferencaEntreDuasDatasEmDias(tempo.geraDataAtual(), dataUltimoPagamento) >= 0) {

            data = getTempo().geraDataAtual();

        } else {

            data = dataUltimoPagamento;

        }

        if (dataDoUltimoPagamentoAplicado == null) {

            dataDoUltimoPagamentoAplicado = getDataVencimento();
        }

        while ((getTempo().geraDiferencaEntreDuasDatasEmDias(data, getDataDoUltimoPagamentoAplicado())) < recorrencia ) { //verifca se a data do pagamento é antes ou depois da data atual

            setDataDoUltimoPagamentoAplicado(tempo.adicionaDiasAUmaData(recorrencia, getDataDoUltimoPagamentoAplicado()));

            if (jurosCompostos > 0) {

                valorInicial += ((valorInicial*jurosCompostos)/100);
                valorASerPago += valorInicial;

            } else if (jurosSimples > 0) {

                valorASerPago+=valorInicial*jurosSimples;

            } else {

                valorASerPago = valorInicial;

            }

        }

        return valorASerPago*-1;
    }

    @Override
    public void imprimeLancamento() {

        System.out.println(getNomeLancamento());
        System.out.println(this.getClass().getSimpleName());
        System.out.println("Valor = " + getValor());
        System.out.println("Juros simples = " + jurosSimples);
        System.out.println("Juros compostos = " + jurosCompostos);
        System.out.println("Recorrência = " + recorrencia);
        System.out.println("Data do último pagamento = " + dataUltimoPagamento);
        System.out.println("Recebedor = " + getRecebedor());
        System.out.println("Devedor = " + getDevedor());

        if (tempo.geraDiferencaEntreDuasDatasEmDias(tempo.geraDataAtual(), dataUltimoPagamento) > 0) {

            System.out.println("Despesa ainda pendente");

        } else {

            System.out.println("Despesa paga");

        }
    }

}
