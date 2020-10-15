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

public class showKetQua extends JFrame implements ActionListener{
    private final JButton nutOK;
    private final JButton next;
    private final JButton pre;
    private JLabel tieuDe = new JLabel();

    private static final List<Question> listCauHoi1 = new ArrayList<>();
    private static List<Anwser> listDA1 = new ArrayList<>();

    Clip clip1;
    public showKetQua() {
        Icon iconOk = new ImageIcon("anh\\okeynha.png");
        Icon iconNe = new ImageIcon("anh\\nex.png");
        Icon iconPr = new ImageIcon("anh\\pre.png");
        int sttCauHoi = docFileByBufferChar();

        tieuDe.setText("Đáp án của "+sttCauHoi+" câu hỏi");
        tieuDe.setFont(new Font("Verdana", Font.PLAIN, 18));
        tieuDe.setBounds(280, 20, 400, 30);
        add(tieuDe);
        listDA1 = listCauHoi1.get(0).getTraloi();                         //se thay doi
        addLabel(cauHoi,"Câu 1: "+listCauHoi1.get(0).getQue(),60,60);
        addLabel(dapanA,listDA1.get(0).getAn1(),80,80);
        if(listDA1.get(0).getTypee() == true) dapanA.setText("--> "+listDA1.get(0).getAn1());
        addLabel(dapanB,listDA1.get(1).getAn1(),80,100);
        if(listDA1.get(1).getTypee() == true) dapanB.setText("--> "+listDA1.get(1).getAn1());
        addLabel(dapanC,listDA1.get(2).getAn1(),80,120);
        if(listDA1.get(2).getTypee() == true) dapanC.setText("--> "+listDA1.get(2).getAn1());
        addLabel(dapanD,listDA1.get(3).getAn1(),80,140);
        if(listDA1.get(3).getTypee() == true) dapanD.setText("--> "+listDA1.get(3).getAn1());

        nutOK = new JButton(iconOk);
        addButton(nutOK,330);
        next = new JButton(iconNe);
        addButton1(next,731);
        pre = new JButton(iconPr);
        addButton1(pre,0);

        setTitle("Tat ca cau hoi");
        setSize(800, 800);
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
        new showKetQua();
    }

    public void addButton(JButton yeah,int x) {
        JLabel cauHoi= new JLabel();
        JLabel dapanA= new JLabel();
        JLabel dapanB= new JLabel();
        JLabel dapanC= new JLabel();
        JLabel dapanD= new JLabel();
        JLabel cauHoi1= new JLabel();
        JLabel dapanA1= new JLabel();
        JLabel dapanB1= new JLabel();
        JLabel dapanC1= new JLabel();
        JLabel dapanD1= new JLabel();
    }


    int check;
    public void addButton(JButton yeah,int x) {
        yeah.setBounds(x, 550, 100, 100);
        add(yeah);
        yeah.addActionListener(this);
    }
    public void addButton1(JButton yeah,int x) {
        yeah.setBounds(x, 250, 55, 55);
        add(yeah);
        yeah.addActionListener(this);
    }
    public void addLabel(JLabel temp,String str1, int x, int y) {
        temp.setText(str1);
        temp.setFont(new Font("Verdana", Font.PLAIN, 13));
        temp.setBounds(x, y, 700, 30);
        add(temp);
    }
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

            }
            case 3 -> {

            }
        }
    }
    public static int docFileByBufferChar() {
        int num = 0;
        try {
//            File f = new File("CongNghePM2.txt");
            File f = new File("CongNghePM.txt");
            FileReader read = new FileReader(f);
            BufferedReader b = new BufferedReader(read);
            String d;
            if ((d = b.readLine()) != null)
                num = Integer.parseInt(d);
            //lay so cau hoi de chay for de doc
            for (int i = 0; i <= num-1; i++) {
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
