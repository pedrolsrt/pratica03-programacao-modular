public class IngressoEstudante extends Ingresso {

    private String instituicaoEnsino;

    public IngressoEstudante(
            int codigo,
            String nomeEvento,
            String setor,
            double valorBase,
            String instituicaoEnsino) {

        super(codigo, nomeEvento, setor, valorBase);
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(String instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 0.5;
    }

    @Override
    public String obterBeneficios() {
        return "Direito a meia-entrada - Instituicao: " + instituicaoEnsino;
    }
}