package congnghepm;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static congnghepm.Question.docFileByBufferChar;
import static congnghepm.Question.getListCauHoi;

public class RealTest extends JFrame implements ActionListener {
    private static List<Question> listQUES = new ArrayList<>();
    private static List<Anwser> listDA = new ArrayList<>();
    private final JProgressBar tiendo;
    private final JButton button1;
    private final JButton button2;
    private final JButton button4;
    private final JButton button3;
    private final JLabel maxtext;
    int socauhoi = docFileByBufferChar();
    long batDauThi;
    Clip clip1;
    String name;
    int check, checkRW = 0, checkWrong = 0;

    public RealTest(String nameTesterr) {
        Image iconTest = Toolkit.getDefaultToolkit().getImage("anh\\test.png");
        setIconImage(iconTest);
        name = nameTesterr;
        System.out.println(socauhoi);
        listQUES = getListCauHoi();                                   //se thay doi
        listDA = listQUES.get(0).getTraloi();                         //se thay doi
        setSize(800, 310);
        setVisible(true);
        setTitle("Cong Nghe Phan Mem");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        maxtext = new JLabel();
        maxtext.setSize(800, 80);
        maxtext.setHorizontalAlignment(SwingConstants.CENTER);
        add(maxtext);
//set vitri cau hoi
        tiendo = new JProgressBar(0, socauhoi);
        tiendo.setBounds(10, 222, 765, 32);
        tiendo.setStringPainted(true);
        add(tiendo);
        //hien thi tien do tra loi
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        laplaicai(button1, 100);
        laplaicai(button2, 155);
        laplaicai2(button3, 100);
        laplaicai2(button4, 155);
        laplaisetCOLOR();
//set vitri cau cau tra loi
        laplaicaiTEXT();                            //sep lap
        maxtext.setText(listQUES.get(0).getQue());  //se thay doi
        try {
            URL url = getClass().getClassLoader().getResource("helltaker.wav");
            assert url != null;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip1 = AudioSystem.getClip();
            clip1.open(audioIn);
            clip1.start();
        } catch (
                UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
//        amThanh("welcome.wav");
        batDauThi = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        new RealTest("Phu DInh");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1)
            check = 1;
        else if (e.getSource() == button2)
            check = 2;
        else if (e.getSource() == button3)
            check = 3;
        else if (e.getSource() == button4)
            check = 4;
        switch (check) {
            case 1 -> laplaiEvent(button1, 0);
            case 2 -> laplaiEvent(button2, 1);
            case 3 -> laplaiEvent(button3, 2);
            case 4 -> laplaiEvent(button4, 3);
        }

    }

    public void laplaicai(JButton yeah, int y) {
        yeah.setBounds(10, y, 375, 50);
        add(yeah);
        yeah.addActionListener(this);
    }

    public void laplaicai2(JButton yeah, int y) {
        yeah.setBounds(400, y, 375, 50);
        add(yeah);
        yeah.addActionListener(this);
    }

    public void laplaicaiTEXT() {                   //se lap lai
        button1.setText(listDA.get(0).getAn1());
        button2.setText(listDA.get(1).getAn1());
        button3.setText(listDA.get(2).getAn1());
        button4.setText(listDA.get(3).getAn1());
    }

    int sttCauHoi = 0;

    public void laplaisetCOLOR() {                   //se lap lai
        button1.setBackground(Color.white);
        button2.setBackground(Color.white);
        button3.setBackground(Color.white);
        button4.setBackground(Color.white);
    }

    public void laplaiEvent(JButton nut, int index) {
        if (listDA.get(index).getTypee()) {
//            amThanh("hi.wav");
            {
                if (checkRW == 0) System.out.println("Back phat bach trung" + checkRW);
                checkRW = 0;
            }
        } else {
            checkRW++;
            checkWrong++;
            if (checkRW != 0) System.out.println("sai lan thu " + checkRW);
        }
        sttCauHoi++;
        if (sttCauHoi == socauhoi) {
            System.out.println("bAN BAN THI XONG");
            setEnabled(false);
            long ketThucThi = System.currentTimeMillis();
            float totalTime = (ketThucThi - batDauThi) / 1000F;
            dispose();
            clip1.stop();
            new ketthuc(socauhoi, name, totalTime, checkWrong);
        }else {
            tiendo.setValue(sttCauHoi);
            System.out.println("stt:" + sttCauHoi);
            maxtext.setText(listQUES.get(sttCauHoi).getQue());
            listDA = listQUES.get(sttCauHoi).getTraloi();
            laplaicaiTEXT();                            //sep lap
            laplaisetCOLOR();
        }
    }

    public void amThanh(String music) {
        try {
            URL url = getClass().getClassLoader().getResource(music);
            assert url != null;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

        } catch (
                UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
