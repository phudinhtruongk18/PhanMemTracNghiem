package congnghepm;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class showKetQua extends JFrame implements ActionListener{
    private final JButton nutOK;
    public showKetQua() {
        Icon iconOk = new ImageIcon("anh\\okeynha.png");
        addLabel("Người thi "+name,40);
        nutOK = new JButton(iconOk);
        addButton(nutOK,15);

        setTitle("Dap an");
        setSize(290, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //xu ly button
        try
        {
            URL url = getClass().getClassLoader().getResource("thiendang.wav");
            assert url != null;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip1 = AudioSystem.getClip();
            clip1.open(audioIn);
            clip1.start();
        } catch(
                UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        float i= 8;
        new showKetQua(69,"test main",i,8);
    }

    int check;
    public void addButton(JButton yeah,int x) {
        yeah.setBounds(x, 150, 120, 120);
        add(yeah);
        yeah.addActionListener(this);
    }
    public void addLabel(String str1, int y) {
        JLabel nameLabel= new JLabel(str1);
        nameLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
        nameLabel.setBounds(20, y, 400, 30);
        add(nameLabel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nutXuatKQ)
            check = 1;
        else if (e.getSource() == nutThiLai)
            check = 2;
        switch (check) {
            case 1 -> { //inKetQua();
            }
            case 2 -> {
                dispose();
                clip1.stop();
                new RealApp(tempName);
            }
        }
    }
//    public void inKetQua() {
//        try { FileOutputStream fos = new FileOutputStream("ketqualuyenQuiz.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject("temp");
//            fos.getFD();
//            fos.close();
//            oos.close();
//        } catch (IOException ex) {
//            System.out.println("Loi khong the ghi file: "+ex);
//        }
//    }
}
