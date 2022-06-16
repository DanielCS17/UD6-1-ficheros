import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        final String PATH = "data/plane.dat";

        FileInputStream inputStream;
        BufferedInputStream bufferedInput;
        ObjectInputStream objectInput;

	    boolean state = false;
        String option;

        Plane F18 = null;

        Scanner sc = new Scanner(System.in);

        try {

            inputStream = new FileInputStream(PATH);
            bufferedInput = new BufferedInputStream(inputStream);
            objectInput = new ObjectInputStream(bufferedInput);

            try {

                F18 = (Plane) objectInput.readObject();

                System.out.println("¡Se ha cargado el fichero correctamente!");

            } catch (IOException e) {
                System.out.println("ERROR! Se ha producido un fallo en la E/S");
            } catch (ClassNotFoundException e) {
                System.out.println("ERROR! Se ha producido un fallo intentando leer el fichero");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("AVISO! No se ha encontrado el fichero, se creará uno al cerrar la sesion");

        } catch (IOException e) {
            System.out.println("ERROR! Se ha producido un fallo en la E/S");
        }


        FileOutputStream outputFile = null;
        BufferedOutputStream bufferedOutput = null;
        ObjectOutputStream objectOutput = null;

        while (state == false){

            System.out.println("\n<<<<<<<<<< MENÚ DE VUELO >>>>>>>>>>");
            System.out.println("1 - Inicializar F-18");
            System.out.println("2 - Alternar estado de los flaps");
            System.out.println("3 - Alternar estado de el tren de aterrizaje");
            System.out.println("4 - Armar sistema de eyección");
            System.out.println("5 - Eyectar piloto");
            System.out.println("Q - Salir");
            System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
            System.out.print(": ");

            option = sc.next();

            switch (option){
                case "1":
                    System.out.println("Introduzca el número de litros de combustible cargados:");
                    float fuelLevel = sc.nextInt();
                    System.out.println("Introduzca apodo del piloto:");
                    String pilotCallSign = sc.next();
                    System.out.println("Introduzca número de escuadrón:");
                    String squadNumber = sc.next();

                    F18 = new Plane(fuelLevel, pilotCallSign, squadNumber);

                    System.out.println(F18);

                    break;
                case "2":
                    F18.toggleFlaps();
                    System.out.println(F18);

                    break;
                case "3":
                    F18.toggleLandingGear();
                    System.out.println(F18);

                    break;
                case "4":
                    F18.ejectionSystem();
                    System.out.println(F18);

                    break;
                case "5":
                    F18.setSeatOccupation();
                    System.out.println(F18);

                    break;
                case "Q":
                    try {
                        outputFile = new FileOutputStream(PATH);
                        bufferedOutput = new BufferedOutputStream(outputFile);
                        objectOutput = new ObjectOutputStream(bufferedOutput);

                        objectOutput.writeObject(F18);

                    } catch (FileNotFoundException e) {
                        System.out.println("ERROR! No existe la ruta indicada");
                    } catch (IOException e) {
                        System.out.println("ERROR! Se ha producido un fallo en la E/S");
                    } finally {
                        try  {
                            if (objectOutput != null) objectOutput.close();
                            if (bufferedOutput != null) objectOutput.close();
                            if (outputFile != null) objectOutput.close();
                        } catch (IOException e) {
                            System.out.println("ERROR! No se ha podido cerrar el fichero");
                        }
                    }
                    state = true;
                    System.out.println("bye...");
                    break;
            }
        }
    }
}
