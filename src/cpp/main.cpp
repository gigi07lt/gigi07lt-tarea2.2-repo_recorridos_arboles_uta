#include <iostream>
#include <queue>
using namespace std;


// Estructura que representa cada nodo del árbol binario
struct Nodo {
    int dato;              // Valor almacenado en el nodo
    Nodo* izquierda;       // Puntero al hijo izquierdo
    Nodo* derecha;         // Puntero al hijo derecho

    // Constructor del nodo
    Nodo(int valor) {
        dato = valor;
        izquierda = nullptr;
        derecha = nullptr;
    }
};

// Recorrido Preorden: Raíz -> Izquierda -> Derecha
void preorden(Nodo* raiz) {
    if (raiz == nullptr) return;

    cout << raiz->dato << " ";
    preorden(raiz->izquierda);
    preorden(raiz->derecha);
}

// Recorrido Inorden: Izquierda -> Raíz -> Derecha
void inorden(Nodo* raiz) {
    if (raiz == nullptr) return;

    inorden(raiz->izquierda);
    cout << raiz->dato << " ";
    inorden(raiz->derecha);
}

// Recorrido Postorden: Izquierda -> Derecha -> Raíz
void postorden(Nodo* raiz) {
    if (raiz == nullptr) return;

    postorden(raiz->izquierda);
    postorden(raiz->derecha);
    cout << raiz->dato << " ";
}

// Recorrido BFS: visita los nodos por niveles usando una cola
void bfs(Nodo* raiz) {
    if (raiz == nullptr) return;

    queue<Nodo*> cola;
    cola.push(raiz);

    while (!cola.empty()) {
        Nodo* actual = cola.front();
        cola.pop();

        cout << actual->dato << " ";

        if (actual->izquierda != nullptr) cola.push(actual->izquierda);
        if (actual->derecha != nullptr) cola.push(actual->derecha);
    }
}

// Cuenta todos los nodos del árbol de forma recursiva
int contarNodos(Nodo* raiz) {
    if (raiz == nullptr) return 0;

    return 1 + contarNodos(raiz->izquierda) + contarNodos(raiz->derecha);
}

// Cuenta los nodos hoja, es decir, los que no tienen hijos
int contarHojas(Nodo* raiz) {
    if (raiz == nullptr) return 0;

    if (raiz->izquierda == nullptr && raiz->derecha == nullptr)
        return 1;

    return contarHojas(raiz->izquierda) + contarHojas(raiz->derecha);
}

int main() {
    // Creación del árbol base
    Nodo* raiz = new Nodo(10);
    raiz->izquierda = new Nodo(5);
    raiz->derecha = new Nodo(15);
    raiz->izquierda->izquierda = new Nodo(2);
    raiz->izquierda->derecha = new Nodo(7);
    raiz->derecha->izquierda = new Nodo(12);
    raiz->derecha->derecha = new Nodo(20);

    // Nuevos nodos agregados para el Ejercicio 2
    raiz->izquierda->izquierda->izquierda = new Nodo(1);
    raiz->izquierda->izquierda->derecha = new Nodo(3);
    raiz->derecha->derecha->izquierda = new Nodo(18);
    raiz->derecha->derecha->derecha = new Nodo(25);

    cout << "RECORRIDOS DE ARBOLES BINARIOS - UTA" << endl;

    cout << "Preorden: ";
    preorden(raiz);

    cout << "\nInorden: ";
    inorden(raiz);

    cout << "\nPostorden: ";
    postorden(raiz);

    cout << "\nBFS: ";
    bfs(raiz);

    // Resultados de los ejercicios 3 y 4
    cout << "\nTotal de nodos: " << contarNodos(raiz);
    cout << "\nTotal de hojas: " << contarHojas(raiz);

    cout << endl;
    return 0;}