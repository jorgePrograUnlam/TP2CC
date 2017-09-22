package polinomio;

public class BinomioDeNewton {

	// Binomio de la forma (ax + b)^n
	private double a;
	private double b;
	private int n;
	private long[] tartaglia;

	public BinomioDeNewton(double a, double b, int n) {
		this.a = a;
		this.b = b;
		this.n = n;
		this.tartaglia = generarTrianguloDeTartaglia(n);
	}

	// utilza el triangulo de pascal
	// http://masc.cs.gmu.edu/wiki/BinomialCoefficients
	// O(N^2)
	private long[] generarTrianguloDeTartaglia(int n) {
		int i, j;
		long[] pascal = new long[n + 1];
		pascal[0] = 1;
		// O(N) 1..N
		for (i = 1; i <= n; i++) {
			pascal[i] = 1;
			// O(N) N..1
			for (j = i - 1; j > 0; j--)
				pascal[j] = pascal[j] + pascal[j - 1];
		}
		return pascal;
	}

	// O(N^1)
	public double getCoeficienteK(int k) {
		double r1 = this.tartaglia[k]; // O(1)
		double r2 = Math.pow(a, k); // O(1)
		double r3 = Math.pow(b, n - k);// O(1)

		return r1*r2*r3;
	}
	 
	
	// O(N^2)
	public double getCoeficienteKRecursiva(int k) {
		int i,j;
		
		if(k<0 || k > n)
			return 0;
		
		i=n;
		j=k;		
				
		return combinatoriaRecursiva(i, j) * Math.pow(a, k) * Math.pow(b, n - k);
		
	}
	
	// es recursivo
	// O(N^2)
	private double combinatoriaRecursiva(int i, int j) {
		if (i == j || j == 0) {
			return 1;
		}

		else
			return combinatoriaRecursiva(i - 1, j - 1) + combinatoriaRecursiva(i - 1, j);
	}

	// no recursivo
	// O(N)
	public Polinomio getFormaPolinomica() {

		double[] coeficientes = new double[n + 1];

		int i = 0;
		// O(N)
		for (int k = n; k >= 0; k--) {
			coeficientes[i] = getCoeficienteK(k); // O(N^1)
			i++;
		}

		return new Polinomio(coeficientes);

	}
	
	
	// O(N^3)
	public Polinomio getFormaPolinomicaRecursivo() {

		double[] coeficientes = new double[n + 1];

		int i = 0;
		// O(N)
		for (int k = n; k >= 0; k--) {
			coeficientes[i] = getCoeficienteKRecursiva(k); // O(N^3)
			i++;
		}

		return new Polinomio(coeficientes);

	}

}
