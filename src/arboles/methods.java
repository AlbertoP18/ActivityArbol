package arboles;

import static arboles.Arboles.*;
import javax.swing.JOptionPane;

public class methods {

    public static void crear_arbol() {
        if (raiz == null) {
            raiz = new Arboles.cliente();
            raiz.name = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
            raiz.saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo del cliente"));
            raiz.izq = null;
            raiz.der = null;
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamemte");
        } else {
            JOptionPane.showMessageDialog(null, "El arbol ya ha sido creado");
        }
    }

    public static void insertar_nodo() {
        if (raiz != null) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
            insertar(raiz, nombre);
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamemte");
        } else {
            JOptionPane.showMessageDialog(null, "El arbol no ha sido creado");
        }
    }

    public static void insertar(cliente aux, String dato) {
        cliente aux1 = null;
        if (dato.compareTo(aux.name) < 0) {
            if (aux.izq == null) {
                aux1 = new cliente();
                aux1.name = dato;
                aux1.saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo del cliente"));
                aux1.der = null;
                aux1.izq = null;
                aux.izq = aux1;
            } else {
                insertar(aux.izq, dato);
            }
        } else {
            if (dato.compareTo(aux.name) > 0) {
                if (aux.der == null) {
                    aux1 = new cliente();
                    aux1.name = dato;
                    aux1.saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo del cliente"));
                    aux1.der = null;
                    aux1.izq = null;
                    aux.der = aux1;
                } else {
                    insertar(aux.der, dato);
                }
            }
        }
    }

    public static void inorden(cliente aux) {
        if (raiz != null) {
            if (aux != null) {
                inorden(aux.izq);
                m += aux.name + ": " + aux.saldo + "\n";
                inorden(aux.der);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arbol no ha sido creado");
        }
    }

    public static void preorden(cliente aux) {
        if (raiz != null) {
            if (aux != null) {
                m += aux.name + ": " + aux.saldo + "\n";
                preorden(aux.izq);
                preorden(aux.der);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arbol no ha sido creado");
        }
    }

    public static void postorden(cliente aux) {
        if (raiz != null) {
            if (aux != null) {
                postorden(aux.izq);   
                postorden(aux.der);
                 m += aux.name + ": " + aux.saldo + "\n";
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arbol no ha sido creado");
        }
    }

    public static void saldoTotal(cliente aux) {
        if (raiz != null) {
            if (aux != null) {
                saldoTotal(aux.izq);
                total += aux.saldo;
                saldoTotal(aux.der);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arbol no ha sido creado");
        }
    }

    public static void mejorPromedio() {
        if (raiz != null) {
            ramaIzq(raiz);
            ramaDer(raiz);
            if (ramaIzq > ramaDer) {
                JOptionPane.showMessageDialog(null, "La rama con mayor promedio es la izquierda con: " + ramaIzq);
            } else {
                if (ramaIzq < ramaDer) {
                    JOptionPane.showMessageDialog(null, "La rama con mayor promedio es la Derecha " + ramaDer);
                } else {
                    JOptionPane.showMessageDialog(null, "Son iguales");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arbol no ha sido creado");
        }
    }

    public static void ramaIzq(cliente aux) {
        if (aux != null) {
            ramaIzq(aux.izq);
            ramaIzq += aux.saldo;
            contIzq++;
        }
    }

    public static void ramaDer(cliente aux) {
        if (aux != null) {
            ramaDer(aux.der);
            ramaDer += aux.saldo;
            contDer++;
        }
    }

    public static void actualizarSaldo(cliente aux) {
        aux.saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo saldo"));
        JOptionPane.showMessageDialog(null, "Cliente actualizado");
    }

    public static boolean buscar(String buscar, cliente aux, cliente aux1) {
        boolean bo = true;
        if (aux != null) {
            if (buscar.equals(aux.name)) {
                if (opcion.equals("4")) {
                    eliminar(aux, aux1);
                    System.out.println("1");
                } else {
                    if (opcion.equals("6")) {
                        actualizarSaldo(aux);
                        System.out.println("2");
                    }
                }
                bo = false;
            } else {
                if (buscar.compareTo(aux.name) < 0) {
                    aux1 = aux;
                    buscar(buscar, aux.izq, aux1);
                } else {
                    aux1 = aux;
                    buscar(buscar, aux.der, aux1);
                }
            }
        }
        return bo;
    }

    public static void eliminar(cliente aux, cliente aux1) {
        if (aux.izq == null && aux.der == null) {
            if (raiz == aux) {
                raiz = null;
            } else {
                if (aux == aux1.izq) {
                    aux1.izq = null;
                } else {
                    aux1.der = null;
                }
            }
            aux = null;
        } else {
            if (aux.izq == null && aux.der != null) {
                if (aux == raiz) {
                    raiz = raiz.der;
                } else {
                    if (aux == aux1.izq) {
                        aux1.izq = aux.der;
                    } else {
                        aux1.der = aux1.der;
                    }
                }
            } else {
                if (aux.izq != null && aux.der == null) {
                    if (aux == raiz) {
                        raiz = raiz.izq;
                    } else {
                        if (aux == aux1.izq) {
                            aux1.izq = aux.izq;
                        } else {
                            aux1.der = aux.izq;
                        }
                    }
                } else {
                    cliente aux2 = aux.der, auxp2 = null;
                    while (aux2.izq != null) {
                        auxp2 = aux2;
                        aux2 = aux2.izq;
                    }
                    aux.name = aux2.name;
                    aux.saldo = aux2.saldo;
                    if (aux.der == aux2) {
                        aux.der = aux2.der;
                    } else {
                        auxp2.izq = aux2.der;
                    }
                    aux2 = null;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente eliminado");
    }

    public static void salarioMayor1(cliente aux) {
        if (raiz != null) {
            if (aux != null) {
                salarioMayor1(aux.izq);
                if (aux.saldo > 1000000) {
                    mi += aux.name + ": " + aux.saldo + "\n";
                }
                salarioMayor1(aux.der);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El arbol no ha sido creado");
        }
    }

}
