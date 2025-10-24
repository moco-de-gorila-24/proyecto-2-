package proyecto_2_00000262792;

public class Medico {
    int id;
    String nombre;
    Especialidad especialidad;

    public Medico(){

    }



    public Medico(int id, String nombre, Especialidad especialidad){
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
