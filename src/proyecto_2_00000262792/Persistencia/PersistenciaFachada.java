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

            if(!existeIdPacientes(idString) == true){
                writer.write( paciente.getId() + " " +  paciente.getNombre()  + " " + paciente.getEdad() + " " + paciente.getDireccion() );
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Paciente agregado con exito");
                return;
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathMedicos.toString(), true))) {
            String idString = String.valueOf(medico.getId());

            if(!existeIdMedicos(idString) == true){
                writer.write( medico.getId() + " " +  medico.getNombre()  + " " + medico.getEspecialidad().getId() + " " + medico.getEspecialidad().getNombre() );
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Medico agregado con exito");
                return;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir datos");
        }
    }

    @Override
    public Medico obtenerMedicoPorId(int id) {
        return null;
    }

    @Override
    public void agregarEspecialidad(Especialidad especialidad) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(pathEspecialidades.toString(),true))){

            if(!existeIdEspecialidad(String.valueOf(especialidad.getId()))){
                writer.write( especialidad.getId() + " " + especialidad.getNombre());
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Especialidad agregada con exito");
                return;
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al escribir los datos");
        }
    }

    @Override
    public Especialidad obtenerEspecialidadPorId(int id) {
        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get(pathEspecialidades.toString()));
            String linea;

            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith(((String.valueOf(id))))){
                    String[] datos = linea.split(" ");

                    if(datos.length >= 2) {
                        int idEspecialidad = Integer.parseInt(datos[0]);
                        String nombreEspecialidad = datos[1];

                        Especialidad especialidad = new Especialidad(idEspecialidad, nombreEspecialidad);

                        return especialidad;
                    }
                }
            }
        }
        catch (NullPointerException | IOException ex){
            JOptionPane.showMessageDialog(null, "Especialidad no encontrada");
        }
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
    public boolean existeIdPacientes(String id) throws IOException {
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

    public boolean existeIdMedicos(String id) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(pathMedicos.toString()));
        String linea;

        while ((linea = reader.readLine()) != null) {
            if (linea.contains(id)) {
                JOptionPane.showMessageDialog(null, "Este id ya lo ocupa otro medico");

                return true;
            }
        }
        return false;
    }

    public boolean existeIdEspecialidad(String id) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(pathEspecialidades.toString()));
        String linea;

        while ((linea = reader.readLine()) != null) {
            if (linea.contains(id)) {
                JOptionPane.showMessageDialog(null, "Este id ya lo ocupa otra Especialidad");
                return true;
            }
        }
        return false;
    }

}

