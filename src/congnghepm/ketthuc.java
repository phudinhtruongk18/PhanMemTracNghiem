package congnghepm;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
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
        Image iconTest = Toolkit.getDefaultToolkit().getImage("anh\\ketqua.png");
        setIconImage(iconTest);
        tempName = name;
        Icon iconThiLai = new ImageIcon("anh\\thilai.png");
        Icon iconXemKetQua = new ImageIcon("anh\\xemketqua.png");
        addLabel("Người thi "+name,40);
        addLabel("Đã luyện tập "+soCH+" câu hỏi trong "+(int)totalTime/60+"p"+(int)totalTime%60+"s",70);
        addLabel("Đã chọn sai "+wrong+" lần",100);

        setTitle("KET QUA LUYEN TAP");
        setSize(290, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //xu ly button
        nutXuatKQ = new JButton(iconXemKetQua);
        nutThiLai = new JButton(iconThiLai);
        addButton(nutXuatKQ,15);
        addButton(nutThiLai,145);
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
        new ketthuc(69,"test main",i,8);
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
            case 1 -> { new showKetQua();
            }
            case 2 -> {
                dispose();
                clip1.stop();
                new start(tempName);
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
