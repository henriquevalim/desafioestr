import java.util.*;

public class Dijkstra {

    public static List<Cidade> encontrarRota(Grafo grafo, Cidade inicio, Cidade fim, int custoMaximo, Set<Estrada> bloqueadas) {
        Map<Cidade, Integer> distancias = new HashMap<>();
        Map<Cidade, Cidade> predecessores = new HashMap<>();
        PriorityQueue<Cidade> pq = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (Cidade cidade : grafo.getCidades()) {
            distancias.put(cidade, Integer.MAX_VALUE);
        }

        distancias.put(inicio, 0);
        pq.add(inicio);

        while (!pq.isEmpty()) {
            Cidade cidadeAtual = pq.poll();

            if (cidadeAtual.equals(fim)) {
                break;
            }

            for (Estrada estrada : grafo.getEstradas(cidadeAtual)) {
                if (bloqueadas.contains(estrada)) continue;

                Cidade vizinho = estrada.getCidadeDestino();
                int novoCusto = distancias.get(cidadeAtual) + estrada.getCusto();

                if (novoCusto <= custoMaximo && novoCusto < distancias.getOrDefault(vizinho, Integer.MAX_VALUE)) {
                    distancias.put(vizinho, novoCusto);
                    predecessores.put(vizinho, cidadeAtual);
                    pq.add(vizinho);
                }
            }
        }

        List<Cidade> caminho = new ArrayList<>();
        Cidade atual = fim;
        while (atual != null) {
            caminho.add(atual);
            atual = predecessores.get(atual);
        }
        Collections.reverse(caminho);

        if (caminho.isEmpty() || distancias.get(fim) == Integer.MAX_VALUE) {
            return null;
        }

        return caminho;
    }
}
