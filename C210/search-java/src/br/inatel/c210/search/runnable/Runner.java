package br.inatel.c210.search.runnable;

import java.util.List;
import java.util.stream.Collectors;

import br.inatel.c210.search.algorithm.AStar;
import br.inatel.c210.search.algorithm.Dijkstra;
import br.inatel.c210.search.heuristic.Heuristic;
import br.inatel.c210.search.heuristic.impl.Chebyshev;
import br.inatel.c210.search.heuristic.impl.Euclidean;
import br.inatel.c210.search.heuristic.impl.Manhattan;
import br.inatel.c210.search.model.Graph;
import br.inatel.c210.search.model.Node;

public class Runner
{
    public static void main(String[] args)
    {
        Graph graph = new Graph();

        // cities with their names and grid coordinates
        Node americana = new Node("Americana", 100.0, 100.0);
        Node barueri = new Node("Barueri", 140.0, 20.0);
        Node campinas = new Node("Campinas", 120.0, 80.0);
        Node capivari = new Node("Capivari", 80.0, 70.0);
        Node indaiatuba = new Node("Indaiatuba", 110.0, 60.0);
        Node itu = new Node("Itu", 100.0, 40.0);
        Node jundiai = new Node("Jundiai", 140.0, 50.0);
        Node limeira = new Node("Limeira", 90.0, 120.0);
        Node piracicaba = new Node("Piracicaba", 60.0, 100.0);
        Node salto = new Node("Salto", 100.0, 50.0);
        Node saoPaulo = new Node("Sao Paulo", 160.0, 10.0);
        Node tiete = new Node("Tiete", 60.0, 60.0);

        // americana
        graph.connect(americana, limeira, 27.5);
        graph.connect(americana, campinas, 38.0);

        // barueri
        graph.connect(barueri, salto, 78.1);
        graph.connect(barueri, saoPaulo, 59.6);

        // campinas
        graph.connect(campinas, americana, 37.7);
        graph.connect(campinas, capivari, 53.4);
        graph.connect(campinas, indaiatuba, 27.8);
        graph.connect(campinas, jundiai, 39.3);

        // capivari
        graph.connect(capivari, tiete, 27.2);
        graph.connect(capivari, piracicaba, 40.2);
        graph.connect(capivari, limeira, 64.8);
        graph.connect(capivari, campinas, 53.7);
        graph.connect(capivari, salto, 37.0);

        // indaiatuba
        graph.connect(indaiatuba, campinas, 28.2);
        graph.connect(indaiatuba, salto, 19.2);

        // itu
        graph.connect(itu, tiete, 55.4);
        graph.connect(itu, salto, 7.6);
        graph.connect(itu, jundiai, 48.4);
        graph.connect(itu, barueri, 75.4);

        // jundiai
        graph.connect(jundiai, campinas, 39.2);
        graph.connect(jundiai, itu, 48.1);
        graph.connect(jundiai, saoPaulo, 59.6);

        // limeira
        graph.connect(limeira, piracicaba, 39.7);
        graph.connect(limeira, capivari, 65.0);
        graph.connect(limeira, americana, 26.9);

        // piracicaba
        graph.connect(piracicaba, tiete, 44.7);
        graph.connect(piracicaba, capivari, 36.4);
        graph.connect(piracicaba, limeira, 39.0);

        // salto
        graph.connect(salto, capivari, 39.5);
        graph.connect(salto, itu, 7.9);
        graph.connect(salto, indaiatuba, 16.6);

        // sao paulo
        graph.connect(saoPaulo, barueri, 33.5);
        graph.connect(saoPaulo, jundiai, 58.7);

        // tiete
        graph.connect(tiete, piracicaba, 44.1);
        graph.connect(tiete, capivari, 30.1);
        graph.connect(tiete, itu, 57.9);

        // heuristics
        Heuristic chebyshev = new Chebyshev();
        Heuristic manhattan = new Manhattan();
        Heuristic euclidean = new Euclidean();

        // tests (AStar)
        System.err.println("Testes do A* de Limeira a Sao Paulo com diferentes heuristicas");
        displayResult(AStar.run(graph, limeira, saoPaulo, chebyshev));
        displayResult(AStar.run(graph, limeira, saoPaulo, euclidean));
        displayResult(AStar.run(graph, limeira, saoPaulo, manhattan));
        System.err.println("Testes do A* entre diversas cidades com diferentes heuristicas");
        displayResult(AStar.run(graph, piracicaba, campinas, chebyshev));
        displayResult(AStar.run(graph, indaiatuba, capivari, euclidean));
        displayResult(AStar.run(graph, americana, tiete, manhattan));

        // tests (Dijkstra)
        System.err.println("Teste do Dijkstra de Limeira a Sao Paulo");
        displayResult(Dijkstra.run(graph, limeira, saoPaulo));
        System.err.println("Teste do Dijkstra entre diversas cidades");
        displayResult(Dijkstra.run(graph, piracicaba, campinas));
        displayResult(Dijkstra.run(graph, indaiatuba, capivari));
        displayResult(Dijkstra.run(graph, americana, tiete));
    }

    private static void displayResult(List<Node> path)
    {
        System.out.println(path.stream().map(Node::getLabel).collect(Collectors.joining(" -> ")));
    }
}
