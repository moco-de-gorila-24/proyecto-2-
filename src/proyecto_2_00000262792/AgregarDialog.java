package proyecto_2_00000262792;

import proyecto_2_00000262792.Persistencia.PersistenciaFachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarDialog extends JDialog {

    public AgregarDialog(){
        setSize(550,400);
        setTitle("Agregar paciente");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panelCentro = new JPanel();
        JPanel panelSur = new JPanel();
        panelCentro.setLayout(new GridLayout(4,2,10,55));




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
}
