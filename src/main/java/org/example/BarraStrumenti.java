package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BarraStrumenti extends JPanel implements ActionListener {

    private JButton buongionro;
    private JButton buonasera;
    private JComboBox tavoli;
    private JButton addTable;

    private TextListener textListener;

    public BarraStrumenti(){

        tavoli = new JComboBox();
        buongionro = new JButton("Buongiorno");
        buonasera = new JButton("Buonasera");
        addTable = new JButton("Auto");


        buongionro.addActionListener(this);
        buonasera.addActionListener(this);
        addTable.addActionListener(this);
        tavoli.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(buongionro);
        add(buonasera);
        add(addTable);
        add(tavoli);
    }

    public ArrayList<Tavolo>  start(){
        ArrayList<Tavolo> tmp = new ArrayList<>();
        for(int i = 0; i < 34; ++i){
            Tavolo tmp1 = new Tavolo();
            tmp1.setOccupanti(0);
            tmp1.setOrdine("0",0);
            tmp.add(i,tmp1);
        }
        return tmp;
    }

    public void setTextListener(TextListener textListener){
        this.textListener = textListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(textListener != null){
            Object azione = e.getSource();
            JButton premuto = (JButton) azione;

            if(premuto == buongionro){
                textListener.testoEmesso("Buongiorno\n");
            } else if(premuto == buonasera){
                textListener.testoEmesso("Buonasera\n");
            }
        }
        if(e.getSource() == addTable){

        }
    }



}
