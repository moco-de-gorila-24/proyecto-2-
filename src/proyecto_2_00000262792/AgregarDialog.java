package proyecto_2_00000262792;

import proyecto_2_00000262792.Persistencia.PersistenciaFachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class AgregarDialog extends JDialog {

    public AgregarDialog(){

    }

    public void agregarPaciente(){
        setSize(550,400);
        setTitle("Agregar paciente");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panelCentro = new JPanel();
        JPanel panelSur = new JPanel();
        panelCentro.setLayout(new GridLayout(4,2,10,60));

        JLabel labelId = new JLabel("Ingrese el id del paciente");
        JLabel labelNombre = new JLabel("Ingrese el nombre del paciente");
        JLabel labelEdad = new JLabel("Ingrese la edad del paciente");
        JLabel labelDireccion = new JLabel("Ingrese la direccion del paciente");

        JTextField textFieldId = new JTextField(10);
        JTextField textFieldNombre = new JTextField(15);
        JTextField textFieldEdad = new JTextField(10);
        JTextField textFieldDireccion = new JTextField(25);

        JButton button = new JButton("Agregar");
        button.setSize(new Dimension(10, 5));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int opcion = JOptionPane.showConfirmDialog(null, "Seguro que quiere agregar este paciente?");

                    if(textFieldId.getText().isEmpty() || textFieldNombre.getText().isEmpty() || textFieldEdad.getText().isEmpty() || textFieldDireccion.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "no puede dejar ningun campo vacio");
                        return;
                    }

                   /*
                   condicion que valida si ya existe
                   if(Integer.parseInt(textFieldId.getText()).){

                   }
                    */

                    if(Integer.parseInt(textFieldId.getText()) < 0){
                        JOptionPane.showMessageDialog(null, "Esta id no es valida");
                        return;
                    }

                    if(opcion == JOptionPane.YES_OPTION){
                        Paciente paciente = new Paciente(Integer.parseInt(textFieldId.getText()),textFieldNombre.getText(),Integer.parseInt(textFieldEdad.getText()),textFieldDireccion.getText());
                        PersistenciaFachada persistenciaFachada = new PersistenciaFachada();

                        persistenciaFachada.agregarPaciente(paciente);

                        JOptionPane.showMessageDialog(null, "paciente agregado con exito");
                    }


                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar un dato valido");
                    return;
                }

            }
        });

        panelCentro.add(labelId);
        panelCentro.add(textFieldId);

        panelCentro.add(labelNombre);
        panelCentro.add(textFieldNombre);

        panelCentro.add(labelEdad);
        panelCentro.add(textFieldEdad);

        panelCentro.add(labelDireccion);
        panelCentro.add(textFieldDireccion);
        panelSur.add(button);
        add(panelCentro, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void agregarEspecialidad(){
        setSize(450,250);
        setTitle("Agregar paciente");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panelCentro = new JPanel();
        JPanel panelSur = new JPanel();
        JPanel panelNorte = new JPanel();
        panelCentro.setLayout(new GridLayout(2,2, 10,105));

        JButton button = new JButton("Agregar");
        button.setSize(new Dimension(10,5));

        JLabel label1 = new JLabel("Ingrese el id");
        JTextField id = new JTextField(10);

        JLabel label2  = new JLabel("Ingrese el nombre de la especialidad");
        JTextField nombre = new JTextField(10);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Especialidad especialidad = new Especialidad(Integer.parseInt(id.getText()), nombre.getText());
                PersistenciaFachada persistenciaFachada = new PersistenciaFachada();

                try{

                    int opcion = JOptionPane.showConfirmDialog(null, "Desea agregar esta especialidad");

                    if(id.getText().isEmpty() || nombre.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "No puede dejar un campo vacio");
                        return;
                    }

                    if(id.getText().isEmpty()  && nombre.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "No puede dejar ambos campos vacios");
                        return;
                    }

                    if(Integer.parseInt(id.getText()) < 0){
                        JOptionPane.showMessageDialog(null, "No se pueden ingresar numeros negativos");
                        return;
                    }

                    if(opcion == JOptionPane.YES_OPTION){
                        persistenciaFachada.agregarEspecialidad(especialidad);
                        JOptionPane.showMessageDialog(null,"Especialidad agregada correctamente");
                    }


                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Dato no valido ");
                }

                catch(InputMismatchException ex){
                    JOptionPane.showMessageDialog(null, "Error al recibir el dato");
                }

            }
        });

        panelCentro.add(label1);
        panelCentro.add(id);

        panelCentro.add(label2);
        panelCentro.add(nombre);
        panelSur.add(button);

        add(panelNorte,BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        setVisible(true);
    }


}
