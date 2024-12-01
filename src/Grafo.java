import java.util.*;

public class Grafo {
    private Map<Cidade, List<Estrada>> adjacencias;

    public Grafo() {
        adjacencias = new HashMap<>();
    }

    public void adicionarCidade(Cidade cidade) {
        adjacencias.putIfAbsent(cidade, new ArrayList<>());
    }

    public void adicionarEstrada(Cidade origem, Cidade destino, int distancia, int custo) {
        adjacencias.get(origem).add(new Estrada(destino, distancia, custo));
        adjacencias.get(destino).add(new Estrada(origem, distancia, custo)); // Grafo não direcionado
    }

    public List<Estrada> getEstradas(Cidade cidade) {
        return adjacencias.getOrDefault(cidade, new ArrayList<>());
    }

    public Set<Cidade> getCidades() {
        return adjacencias.keySet();
    }
}
