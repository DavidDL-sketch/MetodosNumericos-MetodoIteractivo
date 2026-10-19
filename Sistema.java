public class Sistema {
    private final double[][] A;
    private final double[] b;
    private final double[] x0;
    private final double tolerancia;

    public Sistema() {
        // Matriz de coeficientes del sistema de ecuaciones dado
        this.A = new double[][]{
                {5, 1, 1},
                {1, 4, 1},
                {1, 2, 5}
        };
        // Vector de términos independientes
        this.b = new double[]{7, 6, 8};
        // Vector de aproximación inicial X^(0)
        this.x0 = new double[]{0, 0, 0};
        // Tolerancia establecida
        this.tolerancia = 0.0001;
    }

    public double[][] getA() { return A; }
    public double[] getB() { return b; }
    public double[] getX0() { return x0; }
    public double getTolerancia() { return tolerancia; }
}
