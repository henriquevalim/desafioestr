import java.util.*;

public class CargoFast {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Cidade A = new Cidade("A");
        Cidade B = new Cidade("B");
        Cidade C = new Cidade("C");
        Cidade D = new Cidade("D");
        Cidade E = new Cidade("E");

        grafo.adicionarCidade(A);
        grafo.adicionarCidade(B);
        grafo.adicionarCidade(C);
        grafo.adicionarCidade(D);
        grafo.adicionarCidade(E);

        grafo.adicionarEstrada(A, B, 10, 5);
        grafo.adicionarEstrada(B, C, 20, 15);
        grafo.adicionarEstrada(C, E, 25, 10);
        grafo.adicionarEstrada(B, D, 30, 20);
        grafo.adicionarEstrada(A, E, 50, 40);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Cidade de partida: ");
        String partida = scanner.nextLine();
        System.out.print("Cidade de destino: ");
        String destino = scanner.nextLine();
        System.out.print("Custo máximo: ");
        int custoMaximo = scanner.nextInt();
        scanner.nextLine(); // Consome a linha após o inteiro

        System.out.print("Estradas bloqueadas (separadas por vírgula, ex: B-C): ");
        String bloqueadasInput = scanner.nextLine();
        Set<Estrada> bloqueadas = new HashSet<>();
        for (String bloqueio : bloqueadasInput.split(",")) {
            String[] partes = bloqueio.split("-");
            Cidade cidadeOrigem = new Cidade(partes[0]);
            Cidade cidadeDestino = new Cidade(partes[1]);
            for (Estrada estrada : grafo.getEstradas(cidadeOrigem)) {
                if (estrada.getCidadeDestino().equals(cidadeDestino)) {
                    bloqueadas.add(estrada);
                }
            }
        }

        Cidade cidadePartida = new Cidade(partida);
        Cidade cidadeDestino = new Cidade(destino);

        List<Cidade> caminho = Dijkstra.encontrarRota(grafo, cidadePartida, cidadeDestino, custoMaximo, bloqueadas);

        if (caminho == null) {
            System.out.println("Nenhuma rota viável dentro do custo máximo.");
        } else {
            System.out.println("Rota encontrada: " + caminho);
        }

        scanner.close();
    }
}
