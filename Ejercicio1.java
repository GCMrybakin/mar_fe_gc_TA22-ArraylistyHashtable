import java.util.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        List<String> nombresAlumnos = Arrays.asList("Pablo", "Jose", "Juan");
        List<List<Double>> calificacionesPorAlumno = Arrays.asList(
            Arrays.asList(9.5, 8.0, 7.2),
            Arrays.asList(7.0, 6.5, 8.5),
            Arrays.asList(6.8, 7.8, 8.2)
        );

        Map<String, Double> notasMedias = calcularNotasMedias(nombresAlumnos, calificacionesPorAlumno);

        for (Map.Entry<String, Double> entry : notasMedias.entrySet()) {
        	System.out.printf("Alumno: %s, Nota Media: %.1f\n", entry.getKey(), entry.getValue());
        }
        
        double notaMediaGeneral = calcularNotaMediaGeneral(notasMedias);
        System.out.printf("Nota Media General: %.1f\n", notaMediaGeneral);
    }

    public static Map<String, Double> calcularNotasMedias(List<String> nombres, List<List<Double>> calificacionesPorAlumno) {
        Map<String, Double> notasMedias = new HashMap<>();

        if (nombres.size() != calificacionesPorAlumno.size()) {
            throw new IllegalArgumentException("Las listas de nombres y calificaciones deben tener la misma longitud.");
        }

        for (int i = 0; i < nombres.size(); i++) {
            String alumno = nombres.get(i);
            List<Double> calificaciones = calificacionesPorAlumno.get(i);

            Double sumaCalificaciones = 0.0;
            for (Double calificacion : calificaciones) {
                sumaCalificaciones += calificacion;
            }

            Double notaMedia = sumaCalificaciones / calificaciones.size();
            notasMedias.put(alumno, notaMedia);
        }

        return notasMedias;
    }
    
    
    public static double calcularNotaMediaGeneral(Map<String, Double> notasMedias) {
        double sumaNotas = 0.0;
        for (Double notaMedia : notasMedias.values()) {
            sumaNotas += notaMedia;
        }
        return sumaNotas / notasMedias.size();
    }
}
