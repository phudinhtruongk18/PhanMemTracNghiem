package congnghepm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class start extends JFrame implements ActionListener {
    public JTextField nameTester;
    private JButton diThi;
    private JButton diOnThi;
    private final JLabel maxtext = new JLabel();

    public start() {
        Icon iconPractice = new ImageIcon("anh\\practice.png");
        Icon iconTest = new ImageIcon("anh\\test.png");
        maxtext.setText("Xin moi ban nhap ten (Enter de kiem tra ten)");
        maxtext.setBounds(70, 40, 400, 30);
        nameTester = new JTextField();
        nameTester.setBounds(93, 90, 200, 30);
        nameTester.addActionListener(this::maxsachActionPerformed);
        add(nameTester);
        add(maxtext);
        diOnThi = new JButton(iconPractice);
        addButton(diOnThi, 50);
        diThi = new JButton(iconTest);
        addButton(diThi, 230);
        setTitle("Nhap thong tin");
        setSize(410, 220);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public start(String tempName) {
        start again = new start();
        again.maxtext.setText(tempName+" vui long chon che do thi!");
        again.nameTester.setText(tempName);
        again.nameTester.setVisible(false);
        again.diThi.setVisible(true);
        again.diOnThi.setVisible(true);
        again.setSize(410, 300);
    }

    public void addButton(JButton yeah, int x) {
        yeah.setBounds(x, 100, 100, 107);
        add(yeah);
        yeah.setVisible(false);
        yeah.addActionListener(this);
    }

    private void maxsachActionPerformed(ActionEvent actionEvent) {
        if (nameTester.getText().matches(".*[0-9].*")) {
            JOptionPane.showMessageDialog(this, "Ten nguoi chu phai robot dau ma number khong z?\n");
            diThi.setVisible(false);
            diOnThi.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Ten cua ban duoc chap nhan");
            maxtext.setText(nameTester.getText()+" vui long chon che do thi!");
            nameTester.setVisible(false);
            diThi.setVisible(true);
            diOnThi.setVisible(true);
            setSize(410, 300);
        }
    }

    public static void main(String[] args) {
        new start();
    }

    int check;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == diThi)
            check = 1;
        else if (e.getSource() == diOnThi)
            check = 2;
        switch (check) {
            case 1 -> {
                new RealTest(nameTester.getText());
                setVisible(false);
            }

            case 2 -> {
                new practice(nameTester.getText());
                setVisible(false);
            }
        }
    }
}
