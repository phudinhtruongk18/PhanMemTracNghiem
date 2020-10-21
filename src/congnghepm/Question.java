package congnghepm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private boolean typ;
    private String que;
    private List<Anwser> traloi = new ArrayList<Anwser>();
    private static List<Question> listCauHoi = new ArrayList<Question>();
    public Question(String ques, boolean type) {
        this.que = ques;
        this.typ = type;
    }
    public String getQue() {
        return que;
    }
    public List<Anwser> getTraloi() {
        return traloi;
    }
    public static List<Question> getListCauHoi() {
        return listCauHoi;
    }
    public void show() {
        System.out.println("cau hoi :" + que);
        int i = 1;
        for (Anwser a : traloi) {
            System.out.println("Dap an " + i++);
            System.out.println(a);
        }
    }
    public void them(Anwser a) {
        traloi.add(a);
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
                listCauHoi.add(a);
            }
//            while ((d = b.readLine()) != null) {
//                System.out.println(d);
//            }
            b.close();
        } catch (Exception ex) {/*...*/}
        return num;
    }
//    public void ghiketqua() {
//        File f = new File("TestGhiFile.txt");
//        FileWriter fw = null;
//        try {
//            fw = new FileWriter(f);
//            fw.write("cau hoi :" + this.que);
//            int tempNu = 1;
//            for (Anwser a : this.traloi) {
//                fw.write("Dap an " + tempNu++);
//            }
//        } catch (Exception ex) {/*...*/} finally {
//            try {
//                fw.close();
//            } catch (IOException ex) {/*...*/}
//        }
//    }
}