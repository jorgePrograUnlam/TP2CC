package polinomio;
import java.text.DecimalFormat;

public class Polinomio {

	private int grado;
	private double[] coeficientes;

	public Polinomio(double[] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = determinarGradoPolinomio(coeficientes);
	}

	private int determinarGradoPolinomio(double[] coeficientes) {
		int i = 0;
		int n = this.coeficientes.length - 1;
		while (coeficientes[i] == 0 && i < this.coeficientes.length) {
			n--;
			i++;
		}
		return n;
	}

	// eficiencia O(N^2)
	public double evaluarMSucesivas(double x) {

		double sumadorDeTerminos = 0;

		// O(N) 0...N
		for (int i = 0; i < this.coeficientes.length; i++) {

			double potenciaDeX = 1;

			// O(N) N...0
			for (int k = this.grado - i; k > 0; k--)
				potenciaDeX = potenciaDeX * x;

			sumadorDeTerminos += this.coeficientes[i] * potenciaDeX;

		}

		return sumadorDeTerminos;
	}

	// eficiencia O(N^2)
	public double evaluarRecursiva(double x) {

		double sumadorDeTerminos = 0;

		// O(N) 0...N
		for (int i = 0; i < this.coeficientes.length; i++) {

			// O(N) N...0
			sumadorDeTerminos += this.coeficientes[i] * potencia(x, this.grado - i);
		}

		return sumadorDeTerminos;
	}

	// sin considarar el exponente
	// eficiencia O(N)
	private double potencia(double x, int grado) throws StackOverflowError {

		if (grado == 0)
			return 1;
		// O(N) se repite N..0
		return x * potencia(x, grado - 1);
	}

	// eficiencia O(N LOG N)
	public double evaluarRecursivaPar(double x) {

		double sumadorDeTerminos = 0;

		// O(N) 0...N
		for (int i = 0; i < this.coeficientes.length; i++) {
			// O( LOG N)
			sumadorDeTerminos += this.coeficientes[i] * potenciaPar(x, this.grado - i);
		}

		return sumadorDeTerminos;
	}

	// considerando exponente par
	// eficiencia O(LOG N)
	private double potenciaPar(double x, int grado) {

		// O(1)
		if (grado == 0)
			return 1;

		// O(LOG N) se ejecuta mas
		if (grado % 2 == 0)
			return potenciaPar(x * x, grado / 2);

		// O(N)
		return x * potenciaPar(x, grado - 1);
	}

	// almacenando las potencias de X ya calculadas
	// eficiencia O(N)
	public double evaluarProgDinamica(double x) {
		double resultado = 0;

		double[] potenciasDeX = new double[grado + 1];
		potenciasDeX[grado] = 1;

		// O(N)
		for (int i = grado - 1; i >= 0; i--)
			potenciasDeX[i] = potenciasDeX[i + 1] * x;

		// O(N)
		for (int i = 0; i < this.coeficientes.length; i++)
			resultado += coeficientes[i] * potenciasDeX[i];

		return resultado;
	}

	// que ejecute en un tiempo menor que al anterior
	// con la misma complejidad
	// eficiencia O(N)
	public double evaluarMejorada(double x) {
		double resultado = 0;
		double potenciaAcumalativaDeX = 1;
		// O(N) N...0
		for (int i = grado; i >= 0; i--) {
			resultado += coeficientes[i] * potenciaAcumalativaDeX;
			potenciaAcumalativaDeX *= x;
		}
		return resultado;
	}

	// eficiencia O(N)
	public double evaluarPow(double x) {

		double sumadorDeTerminos = 0;
		// O(N) 0...N
		for (int i = 0; i < this.coeficientes.length; i++) {

			// eficiencia Math.pow O(1)
			// lo calcula mediante series
			sumadorDeTerminos += this.coeficientes[i] * Math.pow(x, grado - i);

		}
		return sumadorDeTerminos;
	}

	// eficiencia O(N)
	public double evaluarHorner(double x) {

		double resultado = 0;
		for (int i = 0; i < this.coeficientes.length; i++)
			resultado = resultado * x + coeficientes[i];
		return resultado;
	}

	@Override
	public String toString() {
		String resultado = new String();
		int grado = this.grado;
		DecimalFormat f = new DecimalFormat("##0.###E0");

		for (int k = 0; k < coeficientes.length; k++) {

			if (coeficientes[k] > 0)
				if (grado != 0)
					resultado += "+" + f.format(coeficientes[k]) + "X^" + grado + " ";
				else
					resultado += "+" + f.format(coeficientes[k]) + " ";
			else if (grado != 0)
				resultado += f.format(coeficientes[k]) + "X^" + grado + " ";
			else
				resultado += f.format(coeficientes[k]) + " ";

			grado--;
		}
		return resultado;
	}
}
