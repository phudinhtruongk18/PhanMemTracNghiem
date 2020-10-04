package Jav;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class khoidong extends JFrame implements ActionListener{
    public JTextField maxsach;
    public khoidong() {
        JLabel maxtext= new JLabel();
        maxtext.setText("Maximum number of books (Enter to insert)");
        maxtext.setBounds(70, 60, 400, 30);

        maxsach=new JTextField();
        maxsach.setBounds(140, 110, 100, 30);
        maxsach.addActionListener(this::maxsachActionPerformed);
        add(maxsach);
        add(maxtext);
        setTitle("Nhap thong tin");
        setSize(410, 280);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void maxsachActionPerformed(ActionEvent actionEvent) {
        if(!maxsach.getText().matches("[0-9]*")){
            JOptionPane.showMessageDialog(this,"Nhập sai, MAX phải có dạng Int\n");
        }
        else {JOptionPane.showMessageDialog(this, "MAX của bạn được chấp nhận.");
            setVisible(false);
            new ungdund(Integer.parseInt(maxsach.getText()));
        }
    }

    public static void main(String[] args){
        new khoidong();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
