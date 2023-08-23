import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Map<String, Double> articulos = new HashMap<>();
        
        articulos.put("Camiseta", 7.99);
        articulos.put("Pantalón", 6.99);
        articulos.put("Zapatos", 4.99);
        articulos.put("Frutas", 2.99);
        articulos.put("Pasta", 4.99);
        articulos.put("Herramientas", 14.99);
        articulos.put("Chaqueta", 18.00);
        articulos.put("Pizza", 2.99);
        articulos.put("Shorts", 6.99);
        articulos.put("Carne", 5.99);
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Añadir articulo");
            System.out.println("2. Consultar articulo");
            System.out.println("3. Listar articulos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del articulo: ");
                    String articulo = scanner.nextLine();
                    System.out.print("Ingrese el precio del articulo: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();
                    articulos.put(articulo, precio);
                    System.out.println("Articulo agregado correctamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del articulo a consultar: ");
                    articulo = scanner.nextLine();
                    if (articulos.containsKey(articulo)) {
                        System.out.println("Precio del articulo " + articulo + ": " + articulos.get(articulo));
                    } else {
                        System.out.println("El articulo no existe en la base de datos.");
                    }
                    break;
                case 3:
                    System.out.println("Listado de articulos:");
                    for (Map.Entry<String, Double> entry : articulos.entrySet()) {
                        System.out.println("Articulo: " + entry.getKey() + ", Precio: " + entry.getValue());
                    }
                    break;
                case 4:
                    System.out.println("Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción invalida. Por favor, seleccione una opción valida.");
            }
        }
    }
}
