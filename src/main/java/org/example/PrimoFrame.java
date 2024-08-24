package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimoFrame extends JFrame {

    private TextAreaPanel textAreaPanel ;
    private JButton button1;
    private BarraStrumenti barraStrumenti;
    private PannelloForm pannelloForm;


    public PrimoFrame(){
        super("Pagina iniziale");
        setLayout(new BorderLayout());

        button1 = new JButton("aggiungi");
        textAreaPanel = new TextAreaPanel();
        barraStrumenti = new BarraStrumenti();
        pannelloForm = new PannelloForm();

        barraStrumenti.setTextListener(new TextListener() {
            @Override
            public void testoEmesso(String testo) {
                textAreaPanel.appendiTesto(testo);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    textAreaPanel.appendiTesto("ciao \n");
            }
        });
        pannelloForm.setFormListener(new FormListener() {
            @Override
            public void formEventListener(FormEvent fe) {
                String marca = fe.getMarca();
                String modello = fe.getModello();
                boolean vendita = fe.isVendita();
                String targa = fe.getTarga();
                String cambio = fe.getCambio();

                textAreaPanel.appendiTesto("marcha:" + marca +"\n"+"modello:" +modello +"\n"+"venduta: "+vendita+"\n"+"targa:"+targa+"\n"+ "cambio"+ cambio+"\n");
            }
        });

        add(barraStrumenti, BorderLayout.PAGE_START);
        //add(button1,BorderLayout.PAGE_END);
        add(textAreaPanel,BorderLayout.CENTER);
        add(pannelloForm, BorderLayout.LINE_START);


        setLocationRelativeTo(null);
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
}
