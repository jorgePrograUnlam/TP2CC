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
	public void evaluarMSucesivas() {

		Polinomio pol;
		double solucion;

		pol = new Polinomio(new double[]{1, 2, 3});
		solucion = pol.evaluarMSucesivas(5);

		Assert.assertTrue(38 == solucion);

		pol = new Polinomio(new double[]{0, 1, 2});
		solucion = pol.evaluarMSucesivas(7);

		Assert.assertTrue(9 == solucion);

		pol = new Polinomio(new double[]{2.6, 1.1, -5.2});
		solucion = pol.evaluarMSucesivas(1);

		Assert.assertTrue(-1.5 == solucion);

		pol = new Polinomio(new double[]{2.15, 1.1, -7.7});
		solucion = pol.evaluarMSucesivas(2.2);

		Assert.assertTrue(5.126 == solucion);

		pol = new Polinomio(new double[]{-10357.303, -24831.97, -23814.181, -11419.055,-2737.755,-262.554 });
		solucion = pol.evaluarMSucesivas(2.2);

		Assert.assertTrue(-1.4306083186649603E6 == solucion);

	}

}
