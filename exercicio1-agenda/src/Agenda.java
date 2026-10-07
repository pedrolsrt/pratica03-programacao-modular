import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contato> contatos;
    private int quantidadeContatos;

    public Agenda() {
        contatos = new ArrayList<>();
        quantidadeContatos = 0;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
        this.quantidadeContatos = contatos.size();
    }

    public int getQuantidadeContatos() {
        return quantidadeContatos;
    }

    public void setQuantidadeContatos(int quantidadeContatos) {
        this.quantidadeContatos = quantidadeContatos;
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        quantidadeContatos = contatos.size();
    }

    public boolean removerContato(String nome) {

        Contato contato = buscarPorNome(nome);

        if (contato != null) {
            contatos.remove(contato);
            quantidadeContatos = contatos.size();
            return true;
        }

        return false;
    }

    public Contato buscarPorNome(String nome) {

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }

        return null;
    }

    public Contato buscarPorEmail(String email) {

        for (Contato contato : contatos) {
            if (contato.getEmail().equalsIgnoreCase(email)) {
                return contato;
            }
        }

        return null;
    }

    public Contato buscarPorTelefone(String telefone) {

        for (Contato contato : contatos) {
            if (contato.getTelefone().equalsIgnoreCase(telefone)) {
                return contato;
            }
        }

        return null;
    }
}