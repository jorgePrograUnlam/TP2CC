package polinomio;
public class BinomioDeNewton {

	// Binomio de la forma (ax + b)^n
	private double a;
	private double b;
	private int n;

	public BinomioDeNewton(double a, double b, int n) {
		this.a = a;
		this.b = b;
		this.n = n;
	}

	// O(N^2)
	public double getCoeficienteK(int k) {
		double r1 = Calculo.combinatoria(n, k); // O(N^2)
		double r2 = Math.pow(a, k); // O(1)
		double r3 = Math.pow(b, n - k);// O(1)

		return r1*r2*r3;
	}

	// no recursivo
	// O(N^3)
	public Polinomio getFormaPolinomica() {

		double[] coeficientes = new double[n + 1];

		int i = 0;
		// O(N)
		for (int k = n; k >= 0; k--) {
			coeficientes[i] = getCoeficienteK(k); // O(N^2)
			i++;
		}

		return new Polinomio(coeficientes);

	}

}
