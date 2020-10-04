package Jav;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ungdund extends JFrame implements ActionListener {

    public static HashMap<Integer, CD> CDlist = new HashMap<>();
    private final JButton nut1, nut2, nut3, nut4, nut5, nut6;
    private final JProgressBar quatrinh;
    public nhapvao nv;

    public ungdund(int maxsach) {
        ImageIcon anhdep = new ImageIcon(getClass().getResource("/nen.jpg"));
        JLabel mylabel = new JLabel(anhdep);
        mylabel.setSize(700, 500);
        // anh background
        nut1 = new JButton("Them CD");
        nut1.setBounds(150, 50, 200 / 2, 35);
        add(nut1);
//        nut1.addActionListener(this);

        nut1.addActionListener(this::btnShowDialogActionPerformed);
        //pack();
// the first button
        nut2 = new JButton("So luong CD cua cua hang");
        nut3 = new JButton("SUM price of Phu's store");
        nut4 = new JButton("Sort Phu's store -  low $ to high");
        nut5 = new JButton("Sort Phu's store -  high $ to low");
        nut6 = new JButton("Print Phu's store songs list");

        laplaicainut(nut2, 150);
        laplaicainut(nut3, 200);
        laplaicainut(nut4, 250);
        laplaicainut(nut5, 300);
        laplaicainut(nut6, 350);
// them cac nut
        quatrinh = new JProgressBar(0, maxsach);
        quatrinh.setBounds(50, 110, 300, 20);
        add(quatrinh);
        quatrinh.setStringPainted(true);



        setTitle("Phu's CD store");
        setSize(700, 500);
        add(mylabel);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //int MAX = get;
    int sosach = 1;

    //
    int check;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nut1)
            check = 1;
        else if (e.getSource() == nut2)
            check = 2;
        else if (e.getSource() == nut3)
            check = 3;
        else if (e.getSource() == nut4)
            check = 4;
        else if (e.getSource() == nut5)
            check = 5;
        else if (e.getSource() == nut6)
            check = 6;
//        else if (e.getSource() == nut7)
//            check = 7;
        //            case 7: {
        //                JOptionPane.showMessageDialog(this, "So CD la erro!");
        //            }break;
        switch (check) {
//            case 1: {
//                //JOptionPane.showMessageDialog(this, "Vui long nhap thong tin CD");
//                if (sosach == 5 + 1) {
//                    JOptionPane.showMessageDialog(this, "Full cd");
//                    break;
//                }
//
//                System.out.println("non");
////
//
//
//
//                //CDlist.put(nv.codesong, temp);
//                //temp.inCD();
////                    quatrinh.setValue(sosach++);
////                    int i = 1;
////                    for (CD value : CDlist.values()) {
////                        System.out.println("\nPHU'S remix list No." + i++);
////                        value.inCD();
////                    }
////                JOptionPane.showMessageDialog(this, "done");
//
//
//            }
//            break;
            case 2:
                JOptionPane.showMessageDialog(this, "Tat ca sach trong store la :" + CDlist.size());
                break;
            case 3:
                JOptionPane.showMessageDialog(this, "SUM price is ");
                break;
            case 4:
                JOptionPane.showMessageDialog(this, "Sau khi sap xep!");
                break;
            case 5:
                JOptionPane.showMessageDialog(this, "Sau khi sap xep brub!");
                break;
            case 6: {
                JOptionPane.showMessageDialog(this, "Tat ca sach la!");
                int i = 1;
                for (CD value : CDlist.values()) {
                    System.out.println("\nPHU'S remix list No." + i++);
                    value.inCD();
                }
            }
            break;
        }

    }

    public void laplaicainut(JButton yeah, int y) {
        yeah.setBounds(50, y, 300, 35);
        add(yeah);
        yeah.addActionListener(this);
    }

    private void btnShowDialogActionPerformed(java.awt.event.ActionEvent evt) {
        nv=new nhapvao();
        setEnabled(false);
        CD temp = nv.getData();
//        CDlist.put(temp.getCDcode(),temp);
//        nv.setVisible(false);
        setEnabled(true);

    }
}
