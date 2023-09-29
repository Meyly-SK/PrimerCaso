package ClasificacionGlucosa.main;

public class GlucosaHilo extends Thread{
	
	private int[] nivelGlucosa;
	
	private int[] resultado;
	
	private GlucosaClasificacion clasificacion;
	
	public GlucosaHilo(int[] nivelGlucosa, int[] resultado) {
		this.nivelGlucosa = nivelGlucosa;
		this.resultado = resultado;
		this.clasificacion = new GlucosaClasificacion();
	}
	
	@Override
	public void run() {
		for(int i = 0; i < nivelGlucosa.length; i++) {
			int clasiGlucosa = clasificacion.ClasificarGlucosa(nivelGlucosa[i]);
			resultado[i] = clasiGlucosa;
		}
	}
}
