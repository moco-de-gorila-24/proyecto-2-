package proyecto_2_00000262792;

import proyecto_2_00000262792.Persistencia.PersistenciaFachada;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public void mostrar(){
        setTitle("Hospital");
        setSize(800,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panelMenuBar = new JPanel();
        setLayout(new BorderLayout());
        JMenuBar menuBar = new JMenuBar();

        JMenu Paciente = new JMenu("Paciente");
        JMenuItem agregarPaciente = new JMenuItem("Agregar paciente");
        JMenuItem buscarPacientePorId = new JMenuItem("Buscar paciente por id");
        JMenuItem listarPacientes = new JMenuItem("Listar pacientes");


        Paciente.add(agregarPaciente);
        Paciente.add(buscarPacientePorId);
        Paciente.add(listarPacientes);
        menuBar.add(Paciente);

        JMenu Medico = new JMenu("Medico");
        JMenuItem agregarMedico = new JMenuItem("Agregar medico");
        JMenuItem buscarMedicoPorId = new JMenuItem("Buscar medico por id");
        JMenuItem listarMedicos = new JMenuItem("Listar medicos");

        Medico.add(agregarMedico);
        Medico.add(buscarMedicoPorId);
        Medico.add(listarMedicos);
        menuBar.add(Medico);

        JMenu Especialidad = new JMenu("Especialidad");
        JMenuItem agregarEspecialidad = new JMenuItem("Agregar especialidad");
        JMenuItem buscarEspecialidadPorId = new JMenuItem("Buscar especialidad por id");
        JMenuItem listarEspecialidades = new JMenuItem("Listar especialidades");

        Especialidad.add(agregarEspecialidad);
        Especialidad.add(buscarEspecialidadPorId);
        Especialidad.add(listarEspecialidades);
        menuBar.add(Especialidad);

        JMenu EquipoMedico = new JMenu("Equipo medico");
        JMenuItem agregarEquipoMedico = new JMenuItem("Agregar equipo medico");
        JMenuItem actualizarCantidadEquipo = new JMenuItem("Actualizar cantidad de equipo medico");
        JMenuItem listarEquipoMedico = new JMenuItem("Listar equipo medico");

        EquipoMedico.add(agregarEquipoMedico);
        EquipoMedico.add(actualizarCantidadEquipo);
        EquipoMedico.add(listarEquipoMedico);
        menuBar.add(EquipoMedico);

        JMenu Consulta = new JMenu("Consulta");
        JMenuItem programarConsulta = new JMenuItem("Programar consulta");
        JMenuItem listarConsultas = new JMenuItem("Listar consultas");

        Consulta.add(programarConsulta);
        Consulta.add(listarConsultas);
        menuBar.add(Consulta);

        panelMenuBar.add(menuBar);
        add(panelMenuBar, BorderLayout.CENTER);

        setVisible(true);
    }
}
