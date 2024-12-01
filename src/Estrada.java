public class Estrada {
    private Cidade cidadeDestino;
    private int distancia;
    private int custo;

    public Estrada(Cidade cidadeDestino, int distancia, int custo) {
        this.cidadeDestino = cidadeDestino;
        this.distancia = distancia;
        this.custo = custo;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getCusto() {
        return custo;
    }
}
