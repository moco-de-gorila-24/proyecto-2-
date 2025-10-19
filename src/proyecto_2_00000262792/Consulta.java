package proyecto_2_00000262792;

public class Consulta {
    int id;
    Paciente paciente;
    Medico medico;
    String fecha;

    public Consulta(){

    }

    public Consulta(int id, Paciente paciente, Medico medico, String fecha){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
