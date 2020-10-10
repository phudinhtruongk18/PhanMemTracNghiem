package congnghepm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class start extends JFrame implements ActionListener{
    public JTextField nameTester;
    public start() {
        JLabel maxtext= new JLabel();
        maxtext.setText("Xin moi ban nhap ten (Enter de bat dau thi)");
        maxtext.setBounds(70, 60, 400, 30);
        nameTester =new JTextField();
        nameTester.setBounds(93, 110, 200, 30);
        nameTester.addActionListener(this::maxsachActionPerformed);
        add(nameTester);
        add(maxtext);
        setTitle("Nhap thong tin");
        setSize(410, 280);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void maxsachActionPerformed(ActionEvent actionEvent) {
        if(nameTester.getText().matches("[0-9]*")){
            JOptionPane.showMessageDialog(this,"Ten nguoi chu phai robot dau ma number khong z?\n");
        }
        else {JOptionPane.showMessageDialog(this, "Ten cua ban duoc chap nhan");
            setVisible(false);
            new RealApp(nameTester.getText());
        }
    }

    public static void main(String[] args){
        new start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
