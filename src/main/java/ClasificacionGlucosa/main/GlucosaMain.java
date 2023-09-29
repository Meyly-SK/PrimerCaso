package ClasificacionGlucosa.main;

import java.util.Random;

public class GlucosaMain {
	
	public static void main(String[] args) throws InterruptedException {
		
		int[] nivel1 = generarNivelGlucosa(10);
		int[] nivel2 = generarNivelGlucosa(10);
		int[] nivel3 = generarNivelGlucosa(10);
		
		int[] resultado = new int[30];
		
		GlucosaHilo hilo1 = new GlucosaHilo( nivel1, resultado);
		GlucosaHilo hilo2 = new GlucosaHilo( nivel2, resultado);
		GlucosaHilo hilo3 = new GlucosaHilo( nivel3, resultado);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		hilo1.join();
		hilo2.join();
		hilo3.join();
		
		int contarNormal = contarGlucosa(resultado, GlucosaClasificacion.Normal);
		int contarPreDiabetes = contarGlucosa(resultado, GlucosaClasificacion.PreDiabetes);
		int contarDiabetes = contarGlucosa(resultado, GlucosaClasificacion.Diabetes);
		
		System.out.println("Resultados: ");
		System.out.println("Normal: " + ((double) contarNormal / resultado.length) * 100 + "%");
		System.out.println("Prediabetes: " + ((double) contarPreDiabetes / resultado.length) * 100 + "%");
		System.out.println("Diabetes: " + ((double) contarDiabetes / resultado.length) * 100 + "%");
	}
	
	private static int[] generarNivelGlucosa(int cantidad) {
		int[] nivel = new int[cantidad];
		
		Random random = new Random();
		for(int i = 0; i< cantidad; i++) {
			nivel[i] = random.nextInt(150);
		}
		return nivel;
	}
	
	private static int contarGlucosa(int[] lista, int valor) {
		int contar = 0;
		for(int i : lista) {
			if (i == valor) {
				contar++;
			}
		}
		
		return contar;
	}
}
