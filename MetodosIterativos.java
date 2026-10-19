import java.util.Arrays;

public class MetodosIterativos {

    // Calcula el error absoluto máximo (norma infinito) entre iteraciones
    private static double calcularError(double[] xNuevo, double[] xViejo) {
        double maxError = 0;
        for (int i = 0; i < xNuevo.length; i++) {
            double error = Math.abs(xNuevo[i] - xViejo[i]);
            if (error > maxError) {
                maxError = error;
            }
        }
        return maxError;
    }

    public static void resolverJacobi(Sistema sistema) {
        double[][] A = sistema.getA();
        double[] b = sistema.getB();
        double[] x = Arrays.copyOf(sistema.getX0(), sistema.getX0().length);
        double tol = sistema.getTolerancia();
        int n = b.length;
        int iteraciones = 0;

        System.out.println("\n=== MÉTODO DE JACOBI ===");
        System.out.printf("%-10s %-12s %-12s %-12s %-12s\n", "Iter", "x1", "x2", "x3", "Error");

        while (true) {
            double[] xNuevo = new double[n];
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * x[j];
                    }
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            iteraciones++;
            double error = calcularError(xNuevo, x);
            System.out.printf("%-10d %-12.6f %-12.6f %-12.6f %-12.6f\n", iteraciones, xNuevo[0], xNuevo[1], xNuevo[2], error);

            x = xNuevo;
            if (error < tol || iteraciones > 100) break;
        }
        System.out.println("Resultado final Jacobi: " + Arrays.toString(x) + " en " + iteraciones + " iteraciones.");
    }

    public static void resolverGaussSeidel(Sistema sistema) {
        double[][] A = sistema.getA();
        double[] b = sistema.getB();
        double[] x = Arrays.copyOf(sistema.getX0(), sistema.getX0().length);
        double tol = sistema.getTolerancia();
        int n = b.length;
        int iteraciones = 0;

        System.out.println("\n=== MÉTODO DE GAUSS-SEIDEL ===");
        System.out.printf("%-10s %-12s %-12s %-12s %-12s\n", "Iter", "x1", "x2", "x3", "Error");

        while (true) {
            double[] xViejo = Arrays.copyOf(x, n);
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * x[j]; // Actualización inmediata
                    }
                }
                x[i] = (b[i] - suma) / A[i][i];
            }

            iteraciones++;
            double error = calcularError(x, xViejo);
            System.out.printf("%-10d %-12.6f %-12.6f %-12.6f %-12.6f\n", iteraciones, x[0], x[1], x[2], error);

            if (error < tol || iteraciones > 100) break;
        }
        System.out.println("Resultado final Gauss-Seidel: " + Arrays.toString(x) + " en " + iteraciones + " iteraciones.");
    }
}
