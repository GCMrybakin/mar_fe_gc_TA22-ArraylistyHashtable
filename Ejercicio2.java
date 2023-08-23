import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Double> articulos = new ArrayList<>();
        double precioTotal = 0.0;
        double iva = 0.21;
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la caja del supermercado!");

        while (true) {
            System.out.print("Ingrese el precio del artículo (0 para finalizar): ");
            double precio = scanner.nextDouble();

            if (precio == 0) {
                break;
            }

            articulos.add(precio);
            precioTotal += precio;
        }

        double totalIva = precioTotal * iva;
        double totalConIva = precioTotal + totalIva;

        System.out.println("\n");
        System.out.println("Resumen de la compra:");
        System.out.println("Numero de articulos: " + articulos.size());
        System.out.println("Precio total bruto: " + precioTotal);
        System.out.println("IVA aplicado (21%): " + totalIva);
        System.out.println("Precio total con IVA: " + totalConIva);
        System.out.println("\n");
        System.out.print("Introduce el dinero pagado: ");
        double cantidadPagada = scanner.nextDouble();
        double cambio = cantidadPagada - totalConIva;

        System.out.println("Cambio a devolver: " + cambio);
        System.out.println("Gracias por su compra!");

        scanner.close();
    }
}
