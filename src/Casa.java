public class Casa extends Imovel{
    int valorAluguel;

    public Casa(String endereco, int numero, Proprietario proprietario, int valorAluguel){
        super(endereco, numero, proprietario);
        this.valorAluguel = valorAluguel;
    }

    public int getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(int valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    @Override
    public boolean estaAlugado() {
        if (alugado) {
            System.out.println("A casa está alugada.");
        } else {
            System.out.println("A casa está disponível.");
        }
        return alugado;
    }

    @Override
    public Integer calcularAluguel(int meses) {
        double total = valorAluguel * meses;
        if (meses >= 36) total *= 0.80;
        else if (meses >= 24) total *= 0.75;
        else if (meses >= 12) total *= 0.70;
        return (int) total;
    }

    @Override
    public String toString() {
        return "\nCasa | " + super.toString() + " | Valor aluguel: R$" + valorAluguel;
    }


}
