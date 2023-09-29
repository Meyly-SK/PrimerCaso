package ClasificacionGlucosa.main;

public class GlucosaClasificacion {

	public static final int Normal = 0;
	
	public static final int PreDiabetes = 1;
	
	public static final int Diabetes = 2;
	
	public int ClasificarGlucosa(int nivelGlucosa) {
		if ( nivelGlucosa < 99) {
			return Normal;
		} else if (nivelGlucosa >= 100 && nivelGlucosa <= 125) {
			return PreDiabetes;
		} else {
			return Diabetes;
		}
	}
}
