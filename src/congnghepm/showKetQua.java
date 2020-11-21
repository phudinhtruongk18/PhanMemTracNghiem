package congnghepm;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class showKetQua extends JFrame implements ActionListener {
    private final JButton nutOK;
    private final JButton next;
    private final JButton pre;
    private final JLabel cauHoi = new JLabel();
    private final JLabel dapanA = new JLabel();
    private final JLabel dapanB = new JLabel();
    private final JLabel dapanC = new JLabel();
    private final JLabel dapanD = new JLabel();
    private final JLabel cauHoi1 = new JLabel();
    private final JLabel dapanA1 = new JLabel();
    private final JLabel dapanB1 = new JLabel();
    private final JLabel dapanC1 = new JLabel();
    private final JLabel dapanD1 = new JLabel();
    private final JLabel cauHoi2 = new JLabel();
    private final JLabel dapanA2 = new JLabel();
    private final JLabel dapanB2 = new JLabel();
    private final JLabel dapanC2 = new JLabel();
    private final JLabel dapanD2 = new JLabel();
    private final JLabel cauHoi3 = new JLabel();
    private final JLabel dapanA3 = new JLabel();
    private final JLabel dapanB3 = new JLabel();
    private final JLabel dapanC3 = new JLabel();
    private final JLabel dapanD3 = new JLabel();
    private static final List<Question> listCauHoi1 = new ArrayList<>();
    private static List<Anwser> listDA1;

    static {
        listDA1 = new ArrayList<>();
    }

    int sttCauHoi;

    {
        sttCauHoi = docFileByBufferChar();
    }

    Clip clip1;

    public showKetQua() {
        Icon iconOk = new ImageIcon("anh\\okeynha.png");
        Icon iconNe = new ImageIcon("anh\\nex.png");
        Icon iconPr = new ImageIcon("anh\\pre.png");

        Image iconTest = Toolkit.getDefaultToolkit().getImage("anh\\show.jpg");
        setIconImage(iconTest);

        JLabel tieuDe = new JLabel();
        tieuDe.setText("Đáp án của " + sttCauHoi + " câu hỏi");
        tieuDe.setFont(new Font("Verdana", Font.PLAIN, 18));
        tieuDe.setBounds(280, 20, 400, 30);
        add(tieuDe);

        nutOK = new JButton(iconOk);
        addButton(nutOK, 330);
        next = new JButton(iconNe);
        addButton1(next, 731);
        pre = new JButton(iconPr);
        addButton1(pre, 0);
        themcauhois(0);

        setTitle("Tat ca cau hoi");
        setSize(800, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //xu ly button
        try {
            URL url = getClass().getClassLoader().getResource("thiendang.wav");
            assert url != null;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip1 = AudioSystem.getClip();
            clip1.open(audioIn);
            clip1.start();
        } catch (
                UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }


    public void themcauhois(int tempsttCauHoi) {
        if (tempsttCauHoi >= 0) {
            if (sttCauHoi <= tempsttCauHoi) addLabel(cauHoi, "HẾT CÂU HỎI ", 60, 60);
            else themcauhoi(cauHoi, tempsttCauHoi, 80);
            if (sttCauHoi <= tempsttCauHoi + 1) addLabel(cauHoi1, "HẾT CÂU HỎI ", 60, 80 + 100);
            else themcauhoi1(cauHoi1, tempsttCauHoi + 1, 80 + 120);
            if (sttCauHoi <= tempsttCauHoi + 2) addLabel(cauHoi2, "HẾT CÂU HỎI ", 60, 80 + 220);
            else themcauhoi2(cauHoi2, tempsttCauHoi + 2, 80 + 240);
            if (sttCauHoi <= tempsttCauHoi + 3) addLabel(cauHoi3, "HẾT CÂU HỎI ", 60, 80 + 340);
            else themcauhoi3(cauHoi3, tempsttCauHoi + 3, 80 + 360);
        }
    }

    public void themcauhoi(JLabel tempLabel, int temp, int y) {
        addLabel(tempLabel, "Câu " + (temp + 1) + ": " + listCauHoi1.get(temp).getQue(), 60, y - 20);
        listDA1 = listCauHoi1.get(temp).getTraloi();                         //se thay doi
        addLabel(dapanA, listDA1.get(0).getAn1(), 80, y);
        if (listDA1.get(0).getTypee()) dapanA.setText("--> " + listDA1.get(0).getAn1());
        addLabel(dapanB, listDA1.get(1).getAn1(), 80, y + 20);
        if (listDA1.get(1).getTypee()) dapanB.setText("--> " + listDA1.get(1).getAn1());
        addLabel(dapanC, listDA1.get(2).getAn1(), 80, y + 40);
        if (listDA1.get(2).getTypee()) dapanC.setText("--> " + listDA1.get(2).getAn1());
        addLabel(dapanD, listDA1.get(3).getAn1(), 80, y + 60);
        if (listDA1.get(3).getTypee()) dapanD.setText("--> " + listDA1.get(3).getAn1());
    }

    public void themcauhoi1(JLabel tempLabel, int temp, int y) {
        addLabel(tempLabel, "Câu " + (temp + 1) + ": " + listCauHoi1.get(temp).getQue(), 60, y - 20);
        listDA1 = listCauHoi1.get(temp).getTraloi();                         //se thay doi
        addLabel(dapanA1, listDA1.get(0).getAn1(), 80, y);
        if (listDA1.get(0).getTypee()) dapanA1.setText("--> " + listDA1.get(0).getAn1());
        addLabel(dapanB1, listDA1.get(1).getAn1(), 80, y + 20);
        if (listDA1.get(1).getTypee()) dapanB1.setText("--> " + listDA1.get(1).getAn1());
        addLabel(dapanC1, listDA1.get(2).getAn1(), 80, y + 40);
        if (listDA1.get(2).getTypee()) dapanC1.setText("--> " + listDA1.get(2).getAn1());
        addLabel(dapanD1, listDA1.get(3).getAn1(), 80, y + 60);
        if (listDA1.get(3).getTypee()) dapanD1.setText("--> " + listDA1.get(3).getAn1());
    }

    public void themcauhoi2(JLabel tempLabel, int temp, int y) {
        addLabel(tempLabel, "Câu " + (temp + 1) + ": " + listCauHoi1.get(temp).getQue(), 60, y - 20);
        listDA1 = listCauHoi1.get(temp).getTraloi();                         //se thay doi
        addLabel(dapanA2, listDA1.get(0).getAn1(), 80, y);
        if (listDA1.get(0).getTypee()) dapanA2.setText("--> " + listDA1.get(0).getAn1());
        addLabel(dapanB2, listDA1.get(1).getAn1(), 80, y + 20);
        if (listDA1.get(1).getTypee()) dapanB2.setText("--> " + listDA1.get(1).getAn1());
        addLabel(dapanC2, listDA1.get(2).getAn1(), 80, y + 40);
        if (listDA1.get(2).getTypee()) dapanC2.setText("--> " + listDA1.get(2).getAn1());
        addLabel(dapanD2, listDA1.get(3).getAn1(), 80, y + 60);
        if (listDA1.get(3).getTypee()) dapanD2.setText("--> " + listDA1.get(3).getAn1());
    }

    public void themcauhoi3(JLabel tempLabel, int temp, int y) {
        addLabel(tempLabel, "Câu " + (temp + 1) + ": " + listCauHoi1.get(temp).getQue(), 60, y - 20);
        listDA1 = listCauHoi1.get(temp).getTraloi();                         //se thay doi
        addLabel(dapanA3, listDA1.get(0).getAn1(), 80, y);
        if (listDA1.get(0).getTypee()) dapanA3.setText("--> " + listDA1.get(0).getAn1());
        addLabel(dapanB3, listDA1.get(1).getAn1(), 80, y + 20);
        if (listDA1.get(1).getTypee()) dapanB3.setText("--> " + listDA1.get(1).getAn1());
        addLabel(dapanC3, listDA1.get(2).getAn1(), 80, y + 40);
        if (listDA1.get(2).getTypee()) dapanC3.setText("--> " + listDA1.get(2).getAn1());
        addLabel(dapanD3, listDA1.get(3).getAn1(), 80, y + 60);
        if (listDA1.get(3).getTypee()) dapanD3.setText("--> " + listDA1.get(3).getAn1());
    }

    int check;

    public void addButton(JButton yeah, int x) {
        yeah.setBounds(x, 550, 100, 100);
        add(yeah);
        yeah.addActionListener(this);
    }

    public void addButton1(JButton yeah, int x) {
        yeah.setBounds(x, 250, 55, 55);
        add(yeah);
        yeah.addActionListener(this);
    }

    public void addLabel(JLabel temp, String str1, int x, int y) {
        temp.setText(str1);
        temp.setFont(new Font("Verdana", Font.PLAIN, 13));
        temp.setBounds(x, y, 700, 30);
        add(temp);
    }

    int sttHienTai = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nutOK)
            check = 1;
        if (e.getSource() == next)
            check = 2;
        if (e.getSource() == pre)
            check = 3;
        switch (check) {
            case 1 -> {
                dispose();
                clip1.stop();
            }
            case 2 -> {
                themcauhois(sttHienTai += 4);
                if (sttHienTai>sttCauHoi) sttHienTai=sttCauHoi;

            }
            case 3 -> {
                themcauhois(sttHienTai -= 4);
                if (sttHienTai<0) sttHienTai=0;
            }
        }
    }

    public static int docFileByBufferChar() {
        int num = 0;
        try {
//            File f = new File("125CauCongNghePM2.txt");
            File f = new File("125CauCongNghePM2.txt");
            FileReader read = new FileReader(f);
            BufferedReader b = new BufferedReader(read);
            String d;
            if ((d = b.readLine()) != null)
                num = Integer.parseInt(d);
            //lay so cau hoi de chay for de doc
            for (int i = 0; i <= num - 1; i++) {
//                System.out.println(i);
                d = b.readLine();
                boolean temp1 = false;
                if (Integer.parseInt(d) == 1) temp1 = true;
                d = b.readLine();
                String temp2 = d;
                Question a = new Question(temp2, temp1);
                //sau khi co du lieu cau hoi lay du lieu cau tra loi
                for (int j = 0; j < 4; j++) {
                    d = b.readLine();
                    String temp01 = d;
                    //lay cau tra loi
                    d = b.readLine();
                    float temp02 = Float.parseFloat(d);
                    d = b.readLine();
                    boolean temp03 = false;
                    if (Integer.parseInt(d) == 1) temp03 = true;
                    Anwser tl = new Anwser(temp01, temp02, temp03);
                    a.them(tl);
                }
//                a.show();
                listCauHoi1.add(a);
            }
            b.close();
        } catch (Exception ex) {/*...*/}
        return num;
    }
}
