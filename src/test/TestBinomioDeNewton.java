package test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import polinomio.BinomioDeNewton;
import polinomio.Polinomio;

public class TestBinomioDeNewton {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void coeficienteCubo() {

		BinomioDeNewton bin = new BinomioDeNewton(5, 4, 3);

		Assert.assertTrue(125 == bin.getCoeficienteK(3));
		Assert.assertTrue(125 == bin.getCoeficienteKRecursiva(3));
	}

	@Test
	public void coeficienteCuadrado() {

		BinomioDeNewton bin = new BinomioDeNewton(5, 4, 3);

		Assert.assertTrue(300 == bin.getCoeficienteK(2));
		Assert.assertTrue(300 == bin.getCoeficienteKRecursiva(2));
	}

	@Test
	public void coeficienteLineal() {

		BinomioDeNewton bin = new BinomioDeNewton(5, 4, 3);

		Assert.assertTrue(240 == bin.getCoeficienteK(1));
		Assert.assertTrue(240 == bin.getCoeficienteKRecursiva(1));
	}

	@Test
	public void coeficienteIndependiente() {

		BinomioDeNewton bin = new BinomioDeNewton(5, 4, 3);

		Assert.assertTrue(64 == bin.getCoeficienteK(0));
		Assert.assertTrue(64 == bin.getCoeficienteKRecursiva(0));
	}

	@Test
	public void polinomioResultanteNoRecursivo() {

		BinomioDeNewton bin = new BinomioDeNewton(2, 4, 3);
		Polinomio binomioResuelto = bin.getFormaPolinomica();
		Polinomio polinomioEsperado = new Polinomio(new double[]{8, 48, 96, 64});

		Assert.assertTrue(Arrays.equals(binomioResuelto.getCoeficientes(), polinomioEsperado.getCoeficientes()));
	}

	@Test
	public void polinomioResultanteRecursivo() {

		BinomioDeNewton bin = new BinomioDeNewton(2, 4, 3);
		Polinomio binomioResuelto = bin.getFormaPolinomicaRecursivo();
		Polinomio polinomioEsperado = new Polinomio(new double[]{8, 48, 96, 64});

		Assert.assertTrue(Arrays.equals(binomioResuelto.getCoeficientes(), polinomioEsperado.getCoeficientes()));
	}

}
