package test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import polinomio.Polinomio;

public class TestPolinomio {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void polinomioGrado5() {
		Assert.assertEquals(5, new Polinomio(new double[]{1, 0, 0, 0, 0, 1}).getGrado());
		Assert.assertEquals(5, new Polinomio(new double[]{0.2, 0, 0, 0, 0, 0}).getGrado());
		Assert.assertEquals(5, new Polinomio(new double[]{1, 1.5, 2.7, 1, 0, 1}).getGrado());
	}

	@Test
	public void polinomioGrado4() {
		Assert.assertEquals(4, new Polinomio(new double[]{0, 1, 0, 1, 0, 0}).getGrado());
		Assert.assertEquals(4, new Polinomio(new double[]{0, 0, 0.001, 0, 0, 0, 1}).getGrado());
		Assert.assertEquals(4, new Polinomio(new double[]{0, 1, 0, 1, 1, 1}).getGrado());
	}

	@Test
	public void polinomioGrado1() {
		Assert.assertEquals(1, new Polinomio(new double[]{0, 0, 1.27, 0}).getGrado());
		Assert.assertEquals(1, new Polinomio(new double[]{0, 0, 0, 1, 1}).getGrado());
	}

	@Test
	public void polinomioGrado0() {
		Assert.assertEquals(0, new Polinomio(new double[]{0}).getGrado());
		Assert.assertEquals(0, new Polinomio(new double[]{0.25}).getGrado());
		Assert.assertEquals(0, new Polinomio(new double[]{0, 0, 0, 0, 0, 0, 5.75}).getGrado());
	}

	@Test
	public void polinomioVacio() {
		double coeficientes[] = {};
		Polinomio polinomio = new Polinomio(coeficientes);
		Assert.assertEquals(0, polinomio.getGrado());
	}

	@Test
	public void evaluarEnCeroMSucesivas() {

		Polinomio pol = new Polinomio(new double[]{2, 7, -5});
		double solucion = pol.evaluarMSucesivas(0);

		Assert.assertEquals(-5, solucion, 0.0f);
	}

}
