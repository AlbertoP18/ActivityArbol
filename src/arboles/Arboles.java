package arboles;

import static arboles.methods.*;
import javax.swing.JOptionPane;

public class Arboles {

    public static class cliente {

        String name;
        double saldo;
        cliente izq, der;
    }

    public static cliente raiz = null;
    public static String m = "";
    public static String mi = "";
    public static int contDer = 0, contIzq = 0;
    public static double ramaIzq = 0, ramaDer = 0;
    public static String opcion;
    public static double total;

    public static void main(String[] args) {

        do {
            opcion = (JOptionPane.showInputDialog("Seleccione que desea hacer: \n"
                    + "\n1. Crear arbol"
                    + "\n2. Ingresar cliente nuevo"
                    + "\n3. Mostrar inorden clientes"
                    + "\n4. Mostrar postorden clientes"
                    + "\n5. Mostrar preorden clientes"
                    + "\n6. Eliminar cliente"
                    + "\n7. Mejor promedio entre rama izq y derecha"
                    + "\n8. Actualizar Saldo de un cliente"
                    + "\n9. Saldo total de los clientes"
                    + "\n10. Clientes con salario mayores a 1 millon"
                    + "\n\n(0. Salir)"));

            switch (opcion) {
                case "1":
                    crear_arbol();
                    break;
                case "2":
                    insertar_nodo();
                    break;
                case "3":
                    inorden(raiz);
                    if (raiz != null) {
                        JOptionPane.showMessageDialog(null, m);
                        m = "";
                    }
                    break;
                case "4":
                    postorden(raiz);
                    if (raiz != null) {
                        JOptionPane.showMessageDialog(null, m);
                        m = "";
                    }
                    break;
                case "5":
                    preorden(raiz);
                    if (raiz != null) {
                        JOptionPane.showMessageDialog(null, m);
                        m = "";
                    }
                    break;

                case "6":
                    if (raiz != null) {
                        String nom = JOptionPane.showInputDialog("Ingrese el nombre de la persona que desea buscar");
                        cliente aux1 = null;
                        boolean bo = buscar(nom, raiz, aux1);
                        if (bo) {
                            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El arbol no ha sido creado");
                    }
                    break;
                case "7":
                    mejorPromedio();
                    break;

                case "8":
                    if (raiz != null) {
                        String nome = JOptionPane.showInputDialog("Ingrese el nombre de la persona a la que desea cambiarle el saldo");
                        cliente aux11 = null;
                        boolean bo = buscar(nome, raiz, aux11);
                        if (bo == true) {
                            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El arbol no ha sido creado");
                    }
                    break;
                case "9":
                    saldoTotal(raiz);
                    if (raiz != null) {
                        JOptionPane.showMessageDialog(null, "El saldo total de todos los clientes es de: " + total);
                        total = 0;
                    }
                    break;
                case "10":
                    salarioMayor1(raiz);
                    if (raiz != null) {
                        JOptionPane.showMessageDialog(null, mi);
                        mi = "";
                    }
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida, reintente");
                    break;
            }
        } while (0 == 0);
    }

}
