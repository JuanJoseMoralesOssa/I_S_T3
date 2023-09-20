package tarea3;

/**
 * Student clase que representa a un estudiante con sus atributos
*/
public class Student {
    /**
     * Atributos de la clase
     */
    private String id;
    private String name;
    private String lastName;

    /**
     * Constructor de la clase Student
     * @param id
     * @param name
     * @param lastName
     */
    Student(String id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    /**
     * Getters de la clase
     */

    /**
     * getname
     * @return String nombre del estudiante
     */
    public String getname() {
        return name;
    }

    /**
     * getId
     * @return String id del estudiante
     */
    public String getId() {
        return id;
    }

    /**
     * getLastName
     * @return String apellido del estudiante
     */
    public String getlastName() {
        return lastName;
    }

    /**
     * toString metodo que retorna un string con los atributos del estudiante
     * @return String con los atributos del estudiante pero con el formato json
     */
    @Override
    public String toString() {
        return "{" + "\"id\":\"" + getId() + "\", \"nombre\":\"" + getname() + "\", \"apellido\":\"" + getlastName() + "\"}";
    }
}
