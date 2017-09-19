package test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import polinomio.Polinomio;

public class TestPolinomio {
	private Polinomio pol;
	private double solucion;

	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void queNoSeConsiderenLosCerosUbicadosAlprincipioDelPolinomio(){
		Assert.assertEquals(2,new Polinomio(new double []{0,0,1,1,1}).getGrado());
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
	
	@Test
	public void evaluarRecursiva() {

		pol = new Polinomio(new double[]{1, 2, 3});
		solucion = pol.evaluarRecursiva(5);

		Assert.assertTrue(38 == solucion);

		pol = new Polinomio(new double[]{0, 1, 2});
		solucion = pol.evaluarRecursiva(7);

		Assert.assertTrue(9 == solucion);

		pol = new Polinomio(new double[]{2.6, 1.1, -5.2});
		solucion = pol.evaluarRecursiva(1);

		Assert.assertTrue(-1.5 == solucion);

		pol = new Polinomio(new double[]{2.15, 1.1, -7.7});
		solucion = pol.evaluarRecursiva(2.2);

		Assert.assertTrue(5.126 == solucion);

		pol = new Polinomio(new double[]{-10357.303, -24831.97, -23814.181, -11419.055,-2737.755,-262.554 });
		solucion = pol.evaluarRecursiva(2.2);

		Assert.assertTrue(-1.4306083186649603E6 == solucion);

	}
	
	@Test
	public void evaluarRecursivaPar() {

		pol = new Polinomio(new double[]{1, 2, 3});
		solucion = pol.evaluarRecursivaPar(5);

		Assert.assertTrue(38 == solucion);

		pol = new Polinomio(new double[]{0, 1, 2});
		solucion = pol.evaluarRecursivaPar(7);

		Assert.assertTrue(9 == solucion);

		pol = new Polinomio(new double[]{2.6, 1.1, -5.2});
		solucion = pol.evaluarRecursivaPar(1);

		Assert.assertTrue(-1.5 == solucion);

		pol = new Polinomio(new double[]{2.15, 1.1, -7.7});
		solucion = pol.evaluarRecursivaPar(2.2);

		Assert.assertTrue(5.126 == solucion);

		pol = new Polinomio(new double[]{-10357.303, -24831.97, -23814.181, -11419.055,-2737.755,-262.554 });
		solucion = pol.evaluarRecursivaPar(2.2);

		Assert.assertTrue(-1.4306083186649603E6 == solucion);

	}
	
	@Test
	public void evaluarProgramacionDinamica() {

		pol = new Polinomio(new double[]{1, 2, 3});
		solucion = pol.evaluarProgDinamica(5);

		Assert.assertTrue(38 == solucion);

		pol = new Polinomio(new double[]{0, 1, 2});
		solucion = pol.evaluarProgDinamica(7);

		Assert.assertTrue(9 == solucion);

		pol = new Polinomio(new double[]{2.6, 1.1, -5.2});
		solucion = pol.evaluarProgDinamica(1);

		Assert.assertTrue(-1.5 == solucion);

		pol = new Polinomio(new double[]{2.15, 1.1, -7.7});
		solucion = pol.evaluarProgDinamica(2.2);

		Assert.assertTrue(5.126 == solucion);

		pol = new Polinomio(new double[]{-10357.303, -24831.97, -23814.181, -11419.055,-2737.755,-262.554 });
		solucion = pol.evaluarProgDinamica(2.2);

		Assert.assertTrue(-1.4306083186649603E6 == solucion);

	}
	
	@Test
	public void evaluarDinamicaMejorada() {

		pol = new Polinomio(new double[]{1, 2, 3});
		solucion = pol.evaluarMejorada(5);

		Assert.assertEquals(38 , solucion ,0.00000001);

		pol = new Polinomio(new double[]{0, 1, 2});
		solucion = pol.evaluarMejorada(7);

		Assert.assertEquals(9 , solucion ,0.00000001);

		pol = new Polinomio(new double[]{2.6, 1.1, -5.2});
		solucion = pol.evaluarMejorada(1);

		Assert.assertEquals(-1.5 , solucion, 0.00000001);

		pol = new Polinomio(new double[]{2.15, 1.1, -7.7});
		solucion = pol.evaluarMejorada(2.2);

		Assert.assertEquals(5.126 , solucion ,0.00000001);

		pol = new Polinomio(new double[]{-10357.303, -24831.97, -23814.181, -11419.055,-2737.755,-262.554 });
		solucion = pol.evaluarMejorada(2.2);

		Assert.assertEquals(-1.4306083186649603E6 , solucion ,0.00000001);

	}
	
	@Test
	public void evaluarPow() {

		pol = new Polinomio(new double[]{1, 2, 3});
		solucion = pol.evaluarPow(5);

		Assert.assertTrue(38 == solucion);

		pol = new Polinomio(new double[]{0, 1, 2});
		solucion = pol.evaluarPow(7);

		Assert.assertTrue(9 == solucion);

		pol = new Polinomio(new double[]{2.6, 1.1, -5.2});
		solucion = pol.evaluarPow(1);

		Assert.assertTrue(-1.5 == solucion);

		pol = new Polinomio(new double[]{2.15, 1.1, -7.7});
		solucion = pol.evaluarPow(2.2);

		Assert.assertTrue(5.126 == solucion);

		pol = new Polinomio(new double[]{-10357.303, -24831.97, -23814.181, -11419.055,-2737.755,-262.554 });
		solucion = pol.evaluarPow(2.2);

		Assert.assertTrue(-1.4306083186649603E6 == solucion);

	}

	@Test
	public void evaluarHorner() {

		pol = new Polinomio(new double[]{1, 2, 3});
		solucion = pol.evaluarHorner(5);

		Assert.assertTrue(38 == solucion);

		pol = new Polinomio(new double[]{0, 1, 2});
		solucion = pol.evaluarHorner(7);

		Assert.assertTrue(9 == solucion);

		pol = new Polinomio(new double[]{2.6, 1.1, -5.2});
		solucion = pol.evaluarHorner(1);

		Assert.assertTrue(-1.5 == solucion);

		pol = new Polinomio(new double[]{2.15, 1.1, -7.7});
		solucion = pol.evaluarHorner(2.2);

		Assert.assertTrue(5.126 == solucion);

		pol = new Polinomio(new double[]{-10357.303, -24831.97, -23814.181, -11419.055,-2737.755,-262.554 });
		solucion = pol.evaluarHorner(2.2);

		Assert.assertEquals(-1.4306083186649603E6 , solucion, 0.00000001);

	}
	
	@Test
	public void todosLosMetedosResuelvenIgual() {
		pol = new Polinomio(new double[]{255.256, -256.15, 8.95, 7888.125, 456258.159, -11111.9});
		solucion = pol.evaluarHorner(0.6);

		Assert.assertEquals(265471.30526656, pol.evaluarMSucesivas(0.6), 0.00000001);
		Assert.assertEquals(265471.30526656, pol.evaluarRecursiva(0.6), 0.00000001);
		Assert.assertEquals(265471.30526656, pol.evaluarRecursivaPar(0.6), 0.00000001);
		Assert.assertEquals(265471.30526656, pol.evaluarProgDinamica(0.6), 0.00000001);
		Assert.assertEquals(265471.30526656, pol.evaluarMejorada(0.6), 0.00000001);
		Assert.assertEquals(265471.30526656, pol.evaluarPow(0.6), 0.00000001);
		Assert.assertEquals(265471.30526656, pol.evaluarHorner(0.6), 0.00000001);

	}

}
