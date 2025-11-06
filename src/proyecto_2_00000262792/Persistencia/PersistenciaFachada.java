package proyecto_2_00000262792.Persistencia;

import proyecto_2_00000262792.*;


import javax.swing.*;
import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.nio.file.*;

public class PersistenciaFachada implements IPersistenciaFachada{
    Path pathPacientes = Paths.get("C:\\Users\\Central\\Documents\\NetBeansProjects\\proyecto_2_00000262792\\src\\proyecto_2_00000262792\\Archivos\\Pacientes.txt");
    Path pathMedicos = Paths.get("C:\\Users\\Central\\Documents\\NetBeansProjects\\proyecto_2_00000262792\\src\\proyecto_2_00000262792\\Archivos\\Medicos.txt");
    Path pathConsultas = Paths.get("C:\\Users\\Central\\Documents\\NetBeansProjects\\proyecto_2_00000262792\\src\\proyecto_2_00000262792\\Archivos\\Consultas.txt");
    Path pathInventario = Paths.get("C:\\Users\\Central\\Documents\\NetBeansProjects\\proyecto_2_00000262792\\src\\proyecto_2_00000262792\\Archivos\\Inventario.txt");
    Path pathEspecialidades = Paths.get("C:\\Users\\Central\\Documents\\NetBeansProjects\\proyecto_2_00000262792\\src\\proyecto_2_00000262792\\Archivos\\Especialidades.txt");
    Path pathEquipoMedico = Paths.get("C:\\Users\\Central\\Documents\\NetBeansProjects\\proyecto_2_00000262792\\src\\proyecto_2_00000262792\\Archivos\\EquipoMedico.txt");



    @Override
    public void agregarPaciente(Paciente paciente) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathPacientes.toString(), true))) {
            String idString = String.valueOf(paciente.getId());

            if(!existeId(idString) == true){
                writer.write( paciente.getId() + " " +  paciente.getNombre()  + " " + paciente.getEdad() + " " + paciente.getDireccion() );
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Paciente agregado con exito");
            }


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir datos");
        }
    }

    @Override
    public Paciente obtenerPacientePorId(int id) throws IOException {
        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get(pathPacientes.toString()));
            String linea;

            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith(((String.valueOf(id))))){
                    String[] datos = linea.split(" ");

                    if(datos.length >= 4){
                        int idPaciente = Integer.parseInt(datos[0]);
                        String nombrePaciente = datos[1];
                        int edadPaciente = Integer.parseInt(datos[2]);
                        String direccion = datos[3];
                        Paciente paciente = new Paciente(idPaciente, nombrePaciente, edadPaciente, direccion);

                        return paciente;
                    }
                }
            }
        }
        catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Paciente no encontrado");
        }

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
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(pathEspecialidades.toString(),true))){

            writer.write( especialidad.getId() + " " + especialidad.getNombre());
            writer.newLine();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al escribir los datos");
        }
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
    public boolean existeId(String id) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(pathPacientes.toString()));
        String linea;

        while ((linea = reader.readLine()) != null) {
            if (linea.contains(id)) {
                JOptionPane.showMessageDialog(null, "Este id ya lo ocupa otro paciente");

                return true;
            }

        }


        return false;
    }
}

