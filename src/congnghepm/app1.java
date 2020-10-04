//package congnghepm;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
//
//import static congnghepm.Question.docFileByBufferChar;
//import static congnghepm.Question.getListCauHoi;
//
//public class RealApp extends JFrame implements ActionListener {
//    private static List<Question> listQUES = new ArrayList<Question>();
//    private static List<Anwser> listDA = new ArrayList<Anwser>();
//    private JButton button1;
//    private JButton button2;
//    private JButton button4;
//    private JButton button3;
//
//    private RealApp()  {
//        docFileByBufferChar();
//        listQUES=getListCauHoi();
//        setSize(800, 280);
//        setVisible(true);
//        setTitle("Cong Nghe Phan Mem");
//        setLayout(null);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        JLabel maxtext= new JLabel();
//        maxtext.setSize( 800, 120);
//        maxtext.setHorizontalAlignment(SwingConstants.CENTER);
////set vitri cau hoi
//        laplaicai(button1, 100);
//        laplaicai(button2, 155);
//        laplaicai2(button3, 100);
//        laplaicai2(button4, 155);
////set vitri cau cau tra loi
//        maxtext.setText(listQUES.get(0).getQue());
//        listDA=listQUES.get(0).getTraloi();
//        button1 = new JButton("A");
//        button2 = new JButton("B");
//        button3 = new JButton("C");
//        button4 = new JButton("D");
////        button1 = new JButton(listDA.get(0).getAn1());
////        button2 = new JButton(listDA.get(1).getAn1());
////        button3 = new JButton(listDA.get(2).getAn1());
////        button4 = new JButton(listDA.get(3).getAn1());
//
//        add(maxtext);
//    }
//
//    public static void main(String[] args) {
//        new RealApp();
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//    public void laplaicai(JButton yeah, int y) {
//        yeah.setBounds(50, y, 200, 50);
//        add(yeah);
//        yeah.addActionListener(this);
//    }
//    public void laplaicai2(JButton yeah, int y) {
//        yeah.setBounds(400, y, 200, 50);
//        add(yeah);
//        yeah.addActionListener(this);
//    }
//}
