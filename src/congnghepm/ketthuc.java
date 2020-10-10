package congnghepm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ketthuc extends JFrame implements ActionListener{
    private JButton nutXuatKQ;
    private JButton nutThiLai;
    public ketthuc() {
        JLabel maxtext= new JLabel();
        maxtext.setText("Xin moi ban nhap ten (Enter de bat dau thi)");
        maxtext.setBounds(70, 60, 400, 30);
        add(maxtext);
        setTitle("KET QUA LUYEN TAP");
        setSize(410, 280);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void maxsachActionPerformed(ActionEvent actionEvent) {

    }

    public static void main(String[] args){
        new ketthuc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
