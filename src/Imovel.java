public abstract class Imovel {
    protected String endereco;
    protected int numero;
    protected boolean alugado;
    private Proprietario proprietario;
    private Inquilino inquilino;

    public Imovel(String endereco, int numero, Proprietario proprietario) {
        this.endereco = endereco;
        this.numero = numero;
        this.proprietario = proprietario;
        this.alugado = false;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public abstract boolean estaAlugado();

    public String contatoProprietario() {
        return proprietario.getTelefone();
    }

    public abstract Integer calcularAluguel(int meses);

    @Override
    public String toString() {
        return
                "Endereco= '" + endereco + '\'' +
                ", Numero= " + numero +

                ", Proprietario= " + proprietario.getNome();
    }
}
