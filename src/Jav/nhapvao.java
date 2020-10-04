package Jav;

import javax.swing.*;

public class nhapvao extends JDialog {
    private JTextField codCD;
    private JTextField namCD;
    private JTextField sinCD;
    private JTextField numCD;
    private JTextField priCD;


    public nhapvao() {
        setSize(400, 500 / 2 - 10);
        setLayout(null);
        setLocationRelativeTo(null);

///        setVisible(true);

        codCD = new JTextField();
        namCD = new JTextField();
        sinCD = new JTextField();
        numCD = new JTextField();
        priCD = new JTextField();
        JLabel note1 = new JLabel();
        JLabel note2 = new JLabel();
        JLabel note3 = new JLabel();
        //
        JLabel note4 = new JLabel();
        JLabel sinLB = new JLabel();

        note1.setText("CD Code :");
        note2.setText("CD Name :");
        note3.setText("Num of songs :");
        note4.setText("Pri of songs :");
        sinLB.setText("CD's Singer :");
        laplaicainut2(note1, 20 - 5);
        laplaicainut2(note2, 35 + 5);
        laplaicainut2(note3, 55 + 10);
        laplaicainut2(note4, 75 + 15);
        laplaicainut2(sinLB, 95 + 20);
        laplaicainut3(codCD, 20);
        laplaicainut3(namCD, 40 + 5);
        laplaicainut3(numCD, 60 + 10);
        laplaicainut3(priCD, 80 + 15);
        laplaicainut3(sinCD, 100 + 20);

        //
        JButton okButton = new JButton("ADD CD");
        okButton.setBounds(50 * 4 - 10, 150, 120, 40);
        add(okButton);
        okButton.addActionListener(this::okButtonActionPerformed);
//

        //
        codCD.addActionListener(this::codCDActionPerformed);
        namCD.addActionListener(this::namCDActionPerformed);
        numCD.addActionListener(this::numCDActionPerformed);
        sinCD.addActionListener(this::sinCDActionPerformed);
        priCD.addActionListener(this::priCDActionPerformed);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //kiem tra loi
//        addWindowFocusListener();
    }
    public CD getData(){
        new nhapvao();
        setVisible(true);

        CD temp1= new CD(1,getCDnam(),getCDsin(),1,5);
        //Integer.parseInt(getCDcod()),Integer.parseInt(getCDnum()),Float.parseFloat(getCDpri())
        System.out.println(temp1);
        return temp1;
    }

    public void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        codCD.setText(null);
        namCD.setText(null);
        numCD.setText(null);
        priCD.setText(null);
        sinCD.setText(null);
        //JOptionPane.showMessageDialog(this, "nhap thanh cong"+codesong+namesong);
        dispose();
    }
//        else{
//
//        }
    // TODO add your handling code here:


    private void codCDActionPerformed(java.awt.event.ActionEvent evt) {
        if (!codCD.getText().matches("[0-9]*"))
            JOptionPane.showMessageDialog(this, "Nhập sai, ID phải có dạng Int\n");
        else JOptionPane.showMessageDialog(this, "ID của bạn được chấp nhận.");
    }

    private void namCDActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Name của bạn được chấp nhận.");
    }

    private void sinCDActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Singer name của bạn được chấp nhận.");
    }

    private void numCDActionPerformed(java.awt.event.ActionEvent evt) {
        if (!numCD.getText().matches("[0-9]*"))
            JOptionPane.showMessageDialog(this, "Nhập sai, so bai phải có dạng Int\n");
        else JOptionPane.showMessageDialog(this, "so bai hat của bạn được chấp nhận.");
    }

    private void priCDActionPerformed(java.awt.event.ActionEvent evt) {
        if (!priCD.getText().matches("[0-9]*"))
            JOptionPane.showMessageDialog(this, "Nhập sai, so tien phải có dạng so thuc\n");
        else JOptionPane.showMessageDialog(this, "so tien cua của bạn được chấp nhận.");
    }

    public void laplaicainut2(JLabel yeah, int y) {
        yeah.setBounds(50, y, 300, 30);
        this.add(yeah);
        //    yeah.addActionListener(this);
    }

    public void laplaicainut3(JTextField yeah, int y) {
        yeah.setBounds(150, y, 200, 20);
        this.add(yeah);
        //    yeah.addActionListener(this);
    }
    public String getCDcod() {
        return codCD.getText();
    }
    public String getCDnam() {
        return namCD.getText();
    }
    public String getCDsin() {
        return sinCD.getText();
    }
    public String getCDnum() {
        return numCD.getText();
    }
    public String getCDpri() {
        return priCD.getText();
    }


}
