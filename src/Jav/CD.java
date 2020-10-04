package Jav;



public class CD{
    private int CDcode;
    private String CDname;
    private String Singer;
    private int Num;
    private float Pri;

    public CD(int code, String name, String mtp,int num,float pri){
        CDcode = code;
        CDname = name;
        Singer = mtp;
        Num = num;
        Pri = pri;
    }
    public void inCD(){
        System.out.println("\nCD code: "+CDcode+"\nCD name: "+CDname);
        System.out.println("Singer: "+Singer+"\nNum of songs: "+Num+"\nPri of songs: "+Pri);
    }
    public int getCDcode(){
        return CDcode ;
    }
    public String getCDname(){
        return CDname;
    }
    public String getSinger(){
        return Singer;
    }
    public int getNum(){
        return Num;
    }
    public float getPri(){
        return Pri;
    }

    @Override
    public String toString() {
        return "CD{" +
                "CDcode=" + CDcode +
                ", CDname='" + CDname + '\'' +
                ", Singer='" + Singer + '\'' +
                ", Num=" + Num +
                ", Pri=" + Pri +
                '}';
    }
}
