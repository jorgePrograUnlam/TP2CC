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
	 
	
	// O(n)?????????
	public double getCoeficienteKRecursiva(int k) {
		int i,j;
		
		if(k<0 || k > n)
			return 0;
		
		i=n;
		j=k;
		
		if(j==0 || i==j) 
			return Math.pow(a,n-k)*Math.pow(b,k);
		
		
	}
	
	public double calculo(int i, int j) {
		if(i==j || j==0) {
			return 1;
		}
		
		else return calculo(i-1, j-1) + calculo(i-1, j);
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

		return new Polinomio(n, coeficientes);

	}
	
	public Polinomio getFormaPolinomica2() {

		double[] coeficientes = new double[n + 1];

		int i = 0;
		// O(N)
		for (int k = n; k >= 0; k--) {
			coeficientes[i] = getCoeficienteKRecursiva(k); // O(N^2)
			i++;
		}

		return new Polinomio(n, coeficientes);

	}

	public void mostrarMatriz(double mat[][],int n, int k) {
		
		for(int i=0 ; i<n;i++) {
			for(int j=0 ; j<k; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	

}
