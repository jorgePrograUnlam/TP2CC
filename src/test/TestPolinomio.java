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
	public void evaluarEnCeroMSucesivas() {

		Polinomio pol = new Polinomio(3, new double[]{2, 7, -5});
		double solucion = pol.evaluarMSucesivas(0);

		Assert.assertEquals(0, solucion, 0.0f);
	}

}
