package proyecto_2_00000262792.Persistencia;

import proyecto_2_00000262792.*;

public interface IPersistenciaFachada {

    /*
    Path path = Paths.get("C:\\Users\\Central\\Documents\\NetBeansProjects\\proyecto_2_00000262792\\src\\proyecto_2_00000262792\\Archivos\\Inventario.txt");
        if( Files.notExists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
     */
    public void agregarPaciente(Paciente paciente);
    public Paciente obtenerPacientePorId(int id);
    //Lista de pacientes aqui

    public void agregarMedico(Medico medico);
    public Medico obtenerMedicoPorId(int id);
    //Lista de medicos aqui

    public void agregarEspecialidad(Especialidad especialidad);
    public Especialidad obtenerEspecialidadPorId(int id);
    //Lista de especialidades aqui

    public void agregarEquipoMedico(EquipoMedico equipoMedico);
    public void actualizarCantidadEquipo(int id, int cantidad);
    //Lista de equipos medicos aqui

    public void programarConsulta(Consulta consulta);
    //ListarConsultas aqui
}


