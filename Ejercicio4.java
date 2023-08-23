import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        ArrayList<Double> carrito = new ArrayList<>();
        double precioTotal = 0.0;
        double iva = 0.21;

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

        System.out.println("Bienvenido a la aplicacion de gestion de ventas y stock!");

        while (true) {
            System.out.println("1. Agregar articulo al carrito");
            System.out.println("2. Mostrar resumen de la compra");
            System.out.println("3. Consultar articulo en stock");
            System.out.println("4. Listar articulos en stock");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del articulo: ");
                    String articulo = scanner.nextLine();
                    if (articulos.containsKey(articulo)) {
                        double precioArticulo = articulos.get(articulo);
                        carrito.add(precioArticulo);
                        precioTotal += precioArticulo;
                        System.out.println("Articulo agregado al carrito.");
                    } else {
                        System.out.println("El artículo no existe en el stock.");
                    }
                    break;
                case 2:
                    double totalIva = precioTotal * iva;
                    double totalConIva = precioTotal + totalIva;

                    System.out.println("\nResumen de la compra:");
                    System.out.println("Numero de articulos en el carrito: " + carrito.size());
                    System.out.println("Precio total bruto: " + precioTotal);
                    System.out.println("IVA aplicado (21%): " + totalIva);
                    System.out.println("Precio total con IVA: " + totalConIva);
                    System.out.print("Introduzca el dinero pagado: ");
                    
                    double cantidadPagada = scanner.nextDouble();
                    double cambio = cantidadPagada - totalConIva;
                    
                    System.out.println("Cambio a devolver: " + cambio);

                    carrito.clear();
                    precioTotal = 0.0;
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del articulo a consultar en stock: ");
                    articulo = scanner.nextLine();
                    if (articulos.containsKey(articulo)) {
                        System.out.println("Precio del articulo " + articulo + ": " + articulos.get(articulo));
                    } else {
                        System.out.println("El articulo no existe en el stock.");
                    }
                    break;
                case 4:
                    System.out.println("Listado de articulos en stock:");
                    for (Map.Entry<String, Double> entry : articulos.entrySet()) {
                        System.out.println("Articulo: " + entry.getKey() + ", Precio: " + entry.getValue());
                    }
                    break;
                case 5:
                    System.out.println("Hasta luego!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
            }
        }
    }
}
