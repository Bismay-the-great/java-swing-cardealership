package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelloForm extends JPanel {
    private JLabel labelMarca;
    private JLabel labelModello;

    private JTextField filedMarca;
    private JTextField filedModello;

    private JButton bottoneAggiungi;

    private JLabel labelVendita;
    private JCheckBox checkBoxVendita;

    private JLabel labelTarga;
    private JTextField fieldTarga;

    private FormListener formListener;

    private  JLabel labelCambio;
    private JRadioButton radioButtonManuale;
    private JRadioButton radioButtonAutomatico;
    private ButtonGroup gruppoRadioCambio;

    public PannelloForm(){
        setPreferredSize(new Dimension(300,100));
        setLayout(new GridBagLayout());

        Border borderInterno = BorderFactory.createTitledBorder("Aggiungi auto");
        Border borderEsterno = BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale = BorderFactory.createCompoundBorder(borderInterno,borderEsterno);

        setBorder(bordoFinale);

        labelMarca = new JLabel("Marca:");
        filedMarca = new JTextField("scrivi",20);

        labelModello = new JLabel("Modello:");
        filedModello = new JTextField("scirvi",20);

         labelVendita = new JLabel("Vendita");
        checkBoxVendita = new JCheckBox();
        labelTarga = new JLabel("Targa");
        fieldTarga = new JTextField(15);

        labelTarga.setEnabled(false);
        fieldTarga.setEnabled(false);

        labelCambio = new JLabel("Cambio");
        radioButtonManuale = new JRadioButton("Manuale");
        radioButtonManuale.setActionCommand("manuale");
        radioButtonAutomatico= new JRadioButton("Automatico");
        radioButtonAutomatico.setActionCommand("automatico");
        gruppoRadioCambio = new ButtonGroup();
        gruppoRadioCambio.add(radioButtonManuale);
        gruppoRadioCambio.add(radioButtonAutomatico);

        checkBoxVendita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selezione = checkBoxVendita.isSelected();

                labelTarga.setEnabled(selezione);
                fieldTarga.setEnabled(selezione);

                if(!selezione){
                    fieldTarga.setText("");
                }
            }
        });
        bottoneAggiungi = new JButton("Aggiungi Item");




        bottoneAggiungi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = filedMarca.getText();
                String modello = filedModello.getText();
                boolean vendita = checkBoxVendita.isSelected();
                String targa = fieldTarga.getText();
                String cambio = gruppoRadioCambio.getSelection().getActionCommand();


                FormEvent formEvent = new FormEvent(this,marca,modello,vendita,targa,cambio);
                if(formListener != null){
                    formListener.formEventListener(formEvent);
                }
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);
        add(labelMarca, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);

        add(filedMarca, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);

        add(labelModello, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);

        add(filedModello, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);

        add(labelCambio, gbc);
// cambio
        gbc.gridx = 1;
        gbc.gridy = 2;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);

        add(radioButtonManuale, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);

        add(radioButtonAutomatico, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridwidth = 2;
        gbc.gridheight = 1;

        gbc.anchor = GridBagConstraints.PAGE_START;
        add(bottoneAggiungi, gbc);


        gbc.gridx = 0;
        gbc.gridy = 4;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);

        add(labelVendita, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);

        add(checkBoxVendita, gbc);


        gbc.gridx = 0;
        gbc.gridy = 5;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);

        add(labelTarga, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);


        add(fieldTarga, gbc);
    }

    public void setFormListener(FormListener formListener){
        this.formListener = formListener;
    }

}
