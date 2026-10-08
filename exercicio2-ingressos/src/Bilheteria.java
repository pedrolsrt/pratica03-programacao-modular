import java.util.ArrayList;

public class Bilheteria {

    private ArrayList<Ingresso> ingressos;

    public Bilheteria() {
        ingressos = new ArrayList<>();
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(ArrayList<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public boolean removerIngresso(int codigo) {

        Ingresso ingresso = buscarIngresso(codigo);

        if (ingresso != null) {
            ingressos.remove(ingresso);
            return true;
        }

        return false;
    }

    public Ingresso buscarIngresso(int codigo) {

        for (Ingresso ingresso : ingressos) {

            if (ingresso.getCodigo() == codigo) {
                return ingresso;
            }
        }

        return null;
    }

    public void listarIngressos() {

        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }

        for (Ingresso ingresso : ingressos) {

            System.out.println("\n--------------------");
            ingresso.exibirInformacoes();
        }
    }

    public double calcularArrecadacaoTotal() {

        double total = 0;

        for (Ingresso ingresso : ingressos) {
            total += ingresso.calcularValorFinal();
        }

        return total;
    }

    public void listarBeneficios() {

        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }

        for (Ingresso ingresso : ingressos) {

            System.out.println(
                    ingresso.getNomeEvento()
                            + " - "
                            + ingresso.obterBeneficios()
            );
        }
    }
}