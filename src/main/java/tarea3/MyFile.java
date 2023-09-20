package tarea3;

// import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * MyFile Clase encargada de leer el archivo csv y crear el archivo json
 */
public class MyFile {
    private File file;
    // private Gson gson; // otra forma de resolver el ejercicio

    /**
     * Constructor
     * MyFile
     * @param file
     */
    MyFile(File file) {
        this.file = file;
    }

    /*
     * Getters and Setters
     */

    /**
     * getFile
     * @return file
     */
    public File getFile() {
        return file;
    }

    // Otra solucion del ejercicio
    // public Gson getGson() {
    //     return gson;
    // }

    // public void setGson(Gson gson) {
    //     this.gson = gson;
    // }

    /**
     * isValidFile
     * Confirma si el archivo termina con la extension .csv
     * @param file
     * @return boolean true si es valido, false si no lo es
     */
    public boolean isValidFile(File file) {
        if (file.getName().endsWith(".csv")) {
            return true;
        }
        return false;
    }

    /**
     * readCSV
     * Lee el archivo csv y lo convierte en un ArrayList de objetos
     * de estudiantes
     * @return ArrayList<Student> students
     */
    public ArrayList<Student> readCSV() {
        // Se crea el arraylist de estudiantes
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            // se lee el archivo csv
            Scanner reader = new Scanner(getFile());

            while (reader.hasNext()) {
                String line = reader.next();
                // por cada linea me va a agregar la informacion a el array de estudiantes
                splitLine(line, students);
            }

            // Se crea el json con el resultado
            createJson(students);

        } catch (FileNotFoundException e) {
            // Si no encunetra el archivo
            System.out.println("No se encontro el archivo csv en la ruta especificada.");
        }

        return students;
    }

    /**
     * splitLine Separa la linea del archivo csv y la agrega al arraylist de estudiantes
     * verifica por medio de un for que el csv si tenga la informacion, se la asigna a una variable
     * y luego crea un objeto de tipo estudiante y lo agrega al arraylist, si no tiene la informacion
     * guarda un string vacio
     * @param line linea del archivo csv
     * @param students arraylist de estudiantes
     */
    public void splitLine(String line, ArrayList<Student> students) {
        String[] parts = line.split(",");
        String id = "";
        String name = "";
        String lastName = "";
        for (int index = 0; index < parts.length; index++) {
            switch (index) {
                case 0:
                    id = parts[0];
                    break;
                case 1:
                    name = parts[1];
                    break;
                case 2:
                    lastName = parts[2];
                    break;
            }
        }
        Student s = new Student(id, name, lastName);
        students.add(s);
    }

    /**
     * createJson Crea el archivo json con el arraylist de estudiantes
     *  y lo guarda en la misma ruta del archivo con el mismo nombre
     *  pero con extension .json en vez de .csv
     * @param students arraylist de estudiantes
     */
    public void createJson(ArrayList<Student> students) {
        try {
            String filePath = getFile().getPath();
            String newFilePath = filePath.substring(0, filePath.length() - 4) + ".json";
            Formatter f = new Formatter(newFilePath);
            String message = "[";
            for (Student student : students) {
                message += student;
                message += ",";
            }
            message = message.substring(0, message.length() - 1);
            message += "]";
            f.format(message);

            // Otra solucion del ejercicio
            // Gson g = new Gson();
            // setGson(g);
            // String json = gson.toJson(students);
            // System.out.println(json);
            // f.format(json);

            f.close();
        } catch (Exception e) {
            System.out.println("Error al crear el archivo json");
        }

    }

}
