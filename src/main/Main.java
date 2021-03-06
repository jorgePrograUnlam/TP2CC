package main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import polinomio.BinomioDeNewton;
import polinomio.Polinomio;

public class Main {


	public static void main(String[] args) {
		
		probarReslucionDePolinomio();
		probarBinomioDeNewton();
		
	}

	public static void probarBinomioDeNewton() {
		Random random = new Random();
		double a = random.nextDouble() * random.nextInt(20) - 10;
		double b = random.nextDouble() * random.nextInt(20) - 10;
		int n = random.nextInt(30);


		BinomioDeNewton bin1 = new BinomioDeNewton(a, b, n);

		System.out.println("Binomio de newton de grado " + n + ": NO RECURSIVO");
		Calendar tiempoInicial = new GregorianCalendar();
		System.out.println(bin1.getFormaPolinomica());
		Calendar tiempoFinal = new GregorianCalendar();
		System.out.println(
				" tiempo:" + (tiempoFinal.getTimeInMillis() - tiempoInicial.getTimeInMillis()) + " binomio newton desarrollo: n^" + n);

		System.out.println("Binomio de newton de grado " + n + ": RECURSIVO");
		tiempoInicial = new GregorianCalendar();
		System.out.println(bin1.getFormaPolinomicaRecursivo());
		tiempoFinal = new GregorianCalendar();
		System.out.println(
				" tiempo:" + (tiempoFinal.getTimeInMillis() - tiempoInicial.getTimeInMillis()) + " binomio newton desarrollo: n^" + n);
	}

	public static void probarReslucionDePolinomio() {
		int grado = 5000;
		double solucion;
		double valorX = 0.8;

		Random random = new Random();
		double[] coeficientes = new double[grado + 1];
		for (int i = 0; i < grado + 1; i++) {
			coeficientes[i] = random.nextDouble() * random.nextInt(20) - 10;
		}

		Polinomio polinomioAleatorio = new Polinomio(coeficientes);

		solucion = 0;
		Calendar tiempoInicial = new GregorianCalendar();
		solucion = polinomioAleatorio.evaluarMSucesivas(valorX);
		Calendar tiempoFinal = new GregorianCalendar();
		System.out.println("solucion: " + solucion + " tiempo:"
				+ (tiempoFinal.getTimeInMillis() - tiempoInicial.getTimeInMillis())
				+ " multiplicaciones: n^2");

		solucion = 0;
		tiempoInicial = new GregorianCalendar();
		try {
			solucion = polinomioAleatorio.evaluarRecursiva(valorX);
		} catch (StackOverflowError e) {
			System.err.println("stack oveflow recursivo");
		}
		tiempoFinal = new GregorianCalendar();
		System.out.println("solucion: " + solucion + " tiempo:"
				+ (tiempoFinal.getTimeInMillis() - tiempoInicial.getTimeInMillis())
				+ " recursivo : n^2");

		solucion = 0;
		tiempoInicial = new GregorianCalendar();
		solucion = polinomioAleatorio.evaluarRecursivaPar(valorX);
		tiempoFinal = new GregorianCalendar();
		System.out.println("solucion: " + solucion + " tiempo:"
				+ (tiempoFinal.getTimeInMillis() - tiempoInicial.getTimeInMillis())
				+ " recursivo par: n log n");

		solucion = 0;
		tiempoInicial = new GregorianCalendar();
		solucion = polinomioAleatorio.evaluarPow(valorX);
		tiempoFinal = new GregorianCalendar();
		System.out.println("solucion: " + solucion + " tiempo:"
				+ (tiempoFinal.getTimeInMillis() - tiempoInicial.getTimeInMillis())
				+ " pow de java: n");

		solucion = 0;
		tiempoInicial = new GregorianCalendar();
		solucion = polinomioAleatorio.evaluarProgDinamica(valorX);
		tiempoFinal = new GregorianCalendar();
		System.out.println("solucion: " + solucion + " tiempo:"
				+ (tiempoFinal.getTimeInMillis() - tiempoInicial.getTimeInMillis())
				+ " prog dinamica: n");

		solucion = 0;
		tiempoInicial = new GregorianCalendar();
		solucion = polinomioAleatorio.evaluarMejorada(valorX);
		tiempoFinal = new GregorianCalendar();
		System.out.println("solucion: " + solucion + " tiempo:"
				+ (tiempoFinal.getTimeInMillis() - tiempoInicial.getTimeInMillis())
				+ " prog mejorada: n");

		solucion = 0;
		tiempoInicial = new GregorianCalendar();
		solucion = polinomioAleatorio.evaluarHorner(valorX);
		tiempoFinal = new GregorianCalendar();
		System.out.println("solucion: " + solucion + " tiempo:"
				+ (tiempoFinal.getTimeInMillis() - tiempoInicial.getTimeInMillis())
				+ " hornet: n");

	}
}
