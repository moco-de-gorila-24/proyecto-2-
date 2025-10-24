package proyecto_2_00000262792.Persistencia;

import proyecto_2_00000262792.*;


import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class PersistenciaFachada implements IPersistenciaFachada{
    Path path = Paths.get("C:\\Users\\Central\\Documents\\NetBeansProjects\\proyecto_2_00000262792\\src\\proyecto_2_00000262792\\Archivos\\Pacientes.txt");

    @Override
    public void agregarPaciente(Paciente paciente) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString(), true))) {

            // El segundo parámetro 'true' permite agregar (no sobrescribir)
            writer.write("Id: " + paciente.getId() + " Nombre: " + paciente.getNombre() + " Edad: " + paciente.getEdad() + " Direccion: " + paciente.getDireccion() );
            writer.newLine(); // Salto de línea

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir datos");
        }
    }

    @Override
    public Paciente obtenerPacientePorId(int id) {
        return null;
    }

    @Override
    public void agregarMedico(Medico medico) {

    }

    @Override
    public Medico obtenerMedicoPorId(int id) {
        return null;
    }

    @Override
    public void agregarEspecialidad(Especialidad especialidad) {

    }

    @Override
    public Especialidad obtenerEspecialidadPorId(int id) {
        return null;
    }

    @Override
    public void agregarEquipoMedico(EquipoMedico equipoMedico) {

    }

    @Override
    public void actualizarCantidadEquipo(int id, int cantidad) {

    }

    @Override
    public void programarConsulta(Consulta consulta) {

    }
}
