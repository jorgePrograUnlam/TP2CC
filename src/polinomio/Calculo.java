package polinomio;

public class Calculo {

	// utilza el triangulo de pascal
	// http://masc.cs.gmu.edu/wiki/BinomialCoefficients
	// es no recursivo

	// O(N^2)
	public static long combinatoria(int n, int r) {
		int i, j;
		long[] b = new long[n + 1];
		b[0] = 1;
		// O(N) 1..N
		for (i = 1; i <= n; i++) {
			b[i] = 1;
			// O(N) N..1
			for (j = i - 1; j > 0; j--)
				b[j] = b[j]+b[j-1];
		}
		return b[r];
	}

	// es recursivo
	//O(N^2)
	public static double combinatoriaRecursiva(int i, int j) {
		if (i == j || j == 0) {
			return 1;
		}

		else
			return combinatoriaRecursiva(i - 1, j - 1) + combinatoriaRecursiva(i - 1, j);
	}
}
