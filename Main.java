public class Main {
    public static void main(String[] args) {
        // Instancia del sistema de ecuaciones (Módulo 1)
        Sistema sistema = new Sistema();

        // Ejecución secuencial de ambos métodos (Módulo 2)
        MetodosIterativos.resolverJacobi(sistema);
        MetodosIterativos.resolverGaussSeidel(sistema);
    }
}
