/**
 * @autor Javier Blanco Rodríguez
 * Programacion B - PAC 6 de la UF5
 * Curso Académico: 2021-2022 - Segundo semestre
 * Profesor: Mario Gago
 * */

 //importamos paquetes
import java.util.Iterator;
import java.util.Scanner;
import java.util.InputMismatchException;


public class main {

    public static void main(String[] args) {
        
    

    
        //Creamos Usuario
        Usuario usuario = new Usuario();
        System.out.println("Datos del usuario");
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce el nombre del usuario: "); usuario.setNombre(sc.nextLine());
        do {
            try { //  Control e errores
                System.out.println("Introduce la edad del usuario: ");
                usuario.setEdad(sc.nextInt());

            } catch (InputMismatchException e) {
                System.out.println("La edad debe ser un número");
            }
            sc.nextLine(); //finalizamos lectura del int
        }while(usuario.getEdad() <= 0);



        boolean userCreated = false; // Variable  de  control  para  el  setDNI
        do{
            System.out.println("Introduce el DNI del usuario válido: ");
            String dni = sc.nextLine();
            userCreated = usuario.setDNI(dni);
        }while (!userCreated);

        System.out.println("Usuario creado correctamente \nDatos de Usuario");
        System.out.println(usuario.toString()); // control e imprimimos  datos  del  usuario 



        Cuenta cuenta = new Cuenta(usuario);

        // Creamos variables   auxilares  para  no definirlas  en  el  bucle
        int option;  //OPCION  DEL  MENU (DE 0 A 5)

        String auxDesc; //  AUXILIAR PARA PEDIR DESCRIPCION INGRESO/GASTO

        double auxImp; // AUXILIAR PARA PEDIR IMPORTE INGRESO/GASTO

        double saldo; //

        Iterator<Gasto> iteratorG;

        Iterator<Ingreso> iteratorI;

        Gasto gasto;
        
        Ingreso ingreso;

        // CREAMOS  MENU  DE  OPCIONES

        do {
            menu(); // PARA IMPRIMIR MENU

            option = sc.nextInt(); // PEDIMOS OPCION DE EJECUCION

            sc.nextLine(); //  LEEMOS EL CARACTER ENTER  QUE QUEDA DEPSUES DEL nextInt()


            if (option > 5 || option < 0) {
                System.out.println("Opción no valida");
            }else{
                switch (option) {
                    case 1:
                    case 2: // Ingreso o gasto
                        if (option == 1) {
                            System.out.print("Introduce la descripción del gasto: ");
                        } else {
                            System.out.print("Introduce la descripción del ingreso: ");
                        }

                        auxDesc = sc.nextLine();
                        auxImp = 0; //  Dejamos auxiliar siempre a 0   antes  de  pedirlo


                        do { //  Solicitud de control y  errores
                            try {
                                System.out.print("Introduce el importe: ");
                                auxImp = sc.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.println("Valor númerico incorrecto");
                            }
                            sc.nextLine(); // finalizar  la  lectura  del  Double
                        } while (auxImp <= 0);



                        if (option == 1) { //Agregamos   gasto o  ingreso
                            saldo = cuenta.addGastos(auxDesc, auxImp);
                        } else {
                            saldo = cuenta.addIngresos(auxDesc, auxImp);
                        }

                        System.out.println("Saldo restante: " + saldo + "€");
                        break;

                    case 3: //  Mostramos gastos
                        System.out.println("Gastos registrados:");
                        iteratorG = cuenta.getGastos().iterator();
                        while (iteratorG.hasNext()) {
                            System.out.println(iteratorG.next().toString());

                        }
                        break;

                    case 4: // Mostramos ingresos
                        System.out.println("Ingresos registrados:");
                        iteratorI = cuenta.getIngresos().iterator();
                        while (iteratorI.hasNext()) {
                            System.out.println(iteratorI.next().toString());
                        }
                        break;

                    case 5:
                        System.out.println("\nEl saldo de la cuenta es de: " + cuenta.getSaldo() + "€" );
                        break;
                }
            }
            }while(option != 0);



        sc.close(); //Cierre del Scanner
        System.out.println("Fin del programa");
        System.out.println("Gracias por utilizar la aplicación");

    }



    private static void menu(){  // Creamos método para el menu
       
        System.out.println("Realiza una nueva acción");
        System.out.println("1 - Introduce un nuevo gasto");
        System.out.println("2 - Introduce un nuevo ingreso");
        System.out.println("3 - Mostrar gastos");
        System.out.println("4 - Mostrar ingresos");
        System.out.println("5 - Mostrar saldo");
        System.out.println("0 - Salir");
        System.out.print("\nOpción: ");
    }
}
