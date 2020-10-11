package congnghepm;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class ketthuc extends JFrame implements ActionListener{
    private final JButton nutXuatKQ;
    private final JButton nutThiLai;
    String tempName;
    Clip clip1;
    public ketthuc(int soCH,String name,float totalTime,int wrong) {
        tempName = name;
        Icon iconThiLai = new ImageIcon("thilai.png");
        JLabel maxtext= new JLabel();
        maxtext.setText("Nguoi thi : "+name);
        maxtext.setBounds(70, 60, 400, 30);
        add(maxtext);
        JLabel maxtext1= new JLabel();
        maxtext1.setText("Da luyen tap "+soCH+" cau hoi trong "+(int)totalTime/60+"p"+(int)totalTime%60+"s");
        maxtext1.setBounds(70, 80, 400, 30);
        add(maxtext1);
        JLabel maxtext2= new JLabel();
        maxtext2.setText("Da chon sai "+wrong+" lan");
        maxtext2.setBounds(70, 100, 400, 30);
        add(maxtext2);
        setTitle("KET QUA LUYEN TAP");
        setSize(410, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //xu ly button
        nutXuatKQ = new JButton("xuat ket qua");
        nutThiLai = new JButton(iconThiLai);
        addButton(nutXuatKQ,150);
        addButton(nutThiLai,230);
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
    int check;
    public void addButton(JButton yeah, int y) {
        yeah.setBounds(120, y, 150, 40);
        add(yeah);
        yeah.addActionListener(this);
    }

    public static void main(String[] args){
        float i= 8;
        new ketthuc(69,"test main",i,8);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nutXuatKQ)
            check = 1;
        else if (e.getSource() == nutThiLai)
            check = 2;
        switch (check) {
            case 1:
                //xu ly mo file txt de kiem tra
                break;
            case 2:
                dispose();
                clip1.stop();
                new RealApp(tempName);

                break;

        }
    }
}
