package proyecto_2_00000262792.Persistencia;

import proyecto_2_00000262792.*;

public interface IPersistenciaFachada {

    public void agregarPaciente(Paciente paciente);
    public void obtenerPacientePorId(int id);
    //Lista de pacientes aqui

    public void agregarMedico(Medico medico);
    public void obtenerMedicoPorId(int id);
    //Lista de medicos aqui

    public void agregarEspecialidad(Especialidad especialidad);
    public void obtenerEspecialidadPorId(int id);
    //Lista de especialidades aqui

    public void agregarEquipoMedico(EquipoMedico equipoMedico);
    public void actualizarCantidadEquipo(int id, int cantidad);
    //Lista de equipos medicos aqui

    public void programarConsulta(Consulta consulta);
    //ListarConsultas aqui
}


