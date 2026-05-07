import java.util.LinkedList;
import java.util.Queue;

// Clase que representa cada nodo del árbol binario
class Nodo {
    int dato; // Valor almacenado en el nodo
    Nodo izquierda; // Referencia al hijo izquierdo
    Nodo derecha; // Referencia al hijo derecho

    // Constructor del nodo
    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class Main {

    // Recorrido Preorden: Raíz -> Izquierda -> Derecha
    public static void preorden(Nodo raiz) {
        if (raiz == null)
            return;

        System.out.print(raiz.dato + " ");

        preorden(raiz.izquierda);
        preorden(raiz.derecha);
    }

    // Recorrido Inorden: Izquierda -> Raíz -> Derecha
    public static void inorden(Nodo raiz) {
        if (raiz == null)
            return;

        inorden(raiz.izquierda);

        System.out.print(raiz.dato + " ");

        inorden(raiz.derecha);
    }

    // Recorrido Postorden: Izquierda -> Derecha -> Raíz
    public static void postorden(Nodo raiz) {
        if (raiz == null)
            return;

        postorden(raiz.izquierda);
        postorden(raiz.derecha);

        System.out.print(raiz.dato + " ");
    }

    // Recorrido BFS: recorre el árbol por niveles usando una cola
    public static void bfs(Nodo raiz) {
        if (raiz == null)
            return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {

            // Obtiene el nodo actual de la cola
            Nodo actual = cola.poll();

            System.out.print(actual.dato + " ");

            // Agrega hijos a la cola si existen
            if (actual.izquierda != null)
                cola.add(actual.izquierda);

            if (actual.derecha != null)
                cola.add(actual.derecha);
        }
    }

    // Función recursiva para contar todos los nodos del árbol
    public static int contarNodos(Nodo raiz) {
        if (raiz == null)
            return 0;

        return 1 + contarNodos(raiz.izquierda) + contarNodos(raiz.derecha);
    }

    // Función recursiva para contar nodos hoja
    public static int contarHojas(Nodo raiz) {
        if (raiz == null)
            return 0;

        // Verifica si el nodo no tiene hijos
        if (raiz.izquierda == null && raiz.derecha == null)
            return 1;

        return contarHojas(raiz.izquierda) + contarHojas(raiz.derecha);
    }

    public static void main(String[] args) {

        // Creación del árbol binario base
        Nodo raiz = new Nodo(10);

        raiz.izquierda = new Nodo(5);
        raiz.derecha = new Nodo(15);

        raiz.izquierda.izquierda = new Nodo(2);
        raiz.izquierda.derecha = new Nodo(7);

        raiz.derecha.izquierda = new Nodo(12);
        raiz.derecha.derecha = new Nodo(20);

        // Nuevos nodos agregados para el Ejercicio 2
        raiz.izquierda.izquierda.izquierda = new Nodo(1);
        raiz.izquierda.izquierda.derecha = new Nodo(3);

        raiz.derecha.derecha.izquierda = new Nodo(18);
        raiz.derecha.derecha.derecha = new Nodo(25);

        System.out.println("RECORRIDOS DE ARBOLES BINARIOS - UTA");

        // Mostrar recorrido Preorden
        System.out.print("Preorden: ");
        preorden(raiz);

        // Mostrar recorrido Inorden
        System.out.print("\nInorden: ");
        inorden(raiz);

        // Mostrar recorrido Postorden
        System.out.print("\nPostorden: ");
        postorden(raiz);

        // Mostrar recorrido BFS
        System.out.print("\nBFS: ");
        bfs(raiz);

        // Resultados de los ejercicios 3 y 4
        System.out.print("\nTotal de nodos: " + contarNodos(raiz));
        System.out.print("\nTotal de hojas: " + contarHojas(raiz));

        System.out.println();
    }
}
