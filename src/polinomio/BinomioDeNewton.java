package polinomio;

import java.util.Arrays;

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
	 
	// 0(n*k)
	public double getCoeficienteKDinamicaNoRec(int k) {
		if(k<=0 || k > n+1  )
			return 0;
		
		double matrizCoeficientes[][] = new double[n+1][k];
		
		for(int i=0;i < n+1;i++){
			matrizCoeficientes[i][0] = 1;
		}
		
		for(int j=0;j < k && j<n+1;j++){
			matrizCoeficientes[j][j] = 1;
		}
		
		for(int i=2;i < n+1 ;i++){
			for(int j=1;j < i && j<k ;j++) {
				matrizCoeficientes[i][j] = matrizCoeficientes[i-1][j-1]+matrizCoeficientes[i-1][j];
			}
		}
		
		return matrizCoeficientes[n][k-1];
	}
	
	
	// O(n)?????????
	public double getCoeficienteKDinamicaRec(int k) {
		int i,j;
			
		if(k<=0 || k > n+1)
			return 0;
		i=n-1;
		j=k-1;
			
		double matrizCoeficientes[][] = new double[n+1][k];
			
		return matrizCoeficientes[n][k-1] = calculo(matrizCoeficientes,i,j);
			
	}
	
	public double calculo(double mat[][],int i, int j) {
		if(i==j || j==0) 
			return mat[i][j] = 1;
		
		else return calculo(mat, i-1, j-1) + calculo(mat, i-1, j);
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
	
	public void printMatrix(double mat[][],int n, int k) {
		
		for(int i=0 ; i<n;i++) {
			for(int j=0 ; j<k; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	

}
