package tarea3;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor ingresa el nombre con la ruta completa del archivo csv: ");
        String path = sc.nextLine();

        File file = new File(path);
        if (!file.exists()) { // si el archivo no existe
            System.out.println("El archivo no se encuentra.");
        } else {
            if (!file.isFile()) { // si no es un archivo
                System.out.println("La ruta no es un archivo.");
            } else {
                MyFile myFile = new MyFile(file); // se crea un objeto de tipo MyFile para leer el archivo

                if (!myFile.isValidFile(file)) { // si no es un archivo csv
                    System.out.println("El archivo no se leyo porque no era de tipo csv");
                } else {
                    // Lee el archivo csv, lo convierte a json y guarda el resultado en un archivo con el mismo nombre
                    System.out.println(myFile.readCSV());
                }
            }
        }

        sc.close();
    }
}
