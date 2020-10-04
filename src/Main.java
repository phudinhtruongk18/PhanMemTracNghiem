import Jav.CD;
import Jav.khoidong;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
    new khoidong();
    //    chuongtrinhtiensu();
    }

    public static int MAX;
    public static Scanner cin = new Scanner(System.in);
    public static HashMap<Integer, CD> CDlist = new HashMap<>();

    public static void addCD(int size, int MAX, CD cd) {
        if (CDlist.containsKey(cd.getCDcode())) {
            System.out.println(cd.getCDcode() + " CD is already exist in Phu's store!");
        } else if (size <= MAX) {
            CDlist.put(cd.getCDcode(), cd);
        } else System.out.println("\nOut Of sLot!\nYou have to put it in another store!");
    }

    public static CD insertCD() {
        System.out.println("Moi ban nhap CD code :");
        int code=0;
        code= kiemtra(code);
        System.out.println("Moi ban nhap CD name :");
        String name = cin.nextLine();
        System.out.println("Moi ban nhap CD's Singer :");
        String singer = cin.nextLine();
        System.out.println("Moi ban nhap num of songs :");
        int num=0;
        num = kiemtra(num);
        System.out.println("Moi ban nhap Price of songs :");
        float pri = cin.nextFloat();
        return new CD(code, name, singer, num, pri);
    }

    public static void inCDlist() {
        System.out.println("\nDANH SACH PHU'S REMIX TUYEN CHON ");
        int i = 1;
        for (CD value : CDlist.values()) {
            System.out.println("\nPHU'S remix list No." + i++);
            value.inCD();
        }
    }

    public static void sapxeplist() {
        CD[] CDarray = new CD[CDlist.size()];
        int index = 0;
        for (CD cd1 : CDlist.values()) {
            CDarray[index] = cd1;
            index++;
        }
        for (int i = 0; i < index - 1; i++) {
            for (int j = i; j < index; j++) {
                if (CDarray[i].getPri() > CDarray[j].getPri()) {
                    CD TEMP;
                    TEMP = CDarray[i];
                    CDarray[i] = CDarray[j];
                    CDarray[j] = TEMP;
                }
            }
        }
        System.out.println("Danh sach after sap xep :");
        for (CD cd1 : CDarray) {
            cd1.inCD();
        }
        System.out.println("Sap xep thanh cong !");
        pressAnyKeyToContinue();

    }

    public static void sapseptucaoxuongthap() {
        CD[] CDarray1 = new CD[CDlist.size()];
        int index = 0;
        for (CD cd1 : CDlist.values()) {
            CDarray1[index] = cd1;
            index++;
        }
        for (int i = 0; i < index - 1; i++) {
            for (int j = i; j < index; j++) {
                if (CDarray1[i].getPri() < CDarray1[j].getPri()) {
                    CD TEMP;
                    TEMP = CDarray1[i];
                    CDarray1[i] = CDarray1[j];
                    CDarray1[j] = TEMP;
                }
            }
        }
        System.out.println("Danh sach after sap xep :");
        for (CD cd1 : CDarray1) {
            cd1.inCD();
        }
        System.out.println("Sap xep thanh cong !");
        pressAnyKeyToContinue();

    }

    public static void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public static void cout(String a) {
        System.out.println(a);
    }
//      c++

    public static int kiemtra(int test) {
        do {
            try {
                cout("-------------");
                test = cin.nextInt();
            } catch (Exception e) {
                System.out.println("Loi : " + e + "\n Chi nhap ki tu Integer! Vui long chay lai chuong trinh!");
                System.exit(1);
            }
        } while (false);
        cin.nextLine();//xoa enter
        return test;
    }

    public static void chuongtrinhtiensu(){
        System.out.println("Nhap so luong toi da cua cua hang :");
        MAX = kiemtra(MAX)-1;
        int luachon = 0;
        do {
            System.out.println("Nhap lua chon cua ban :");
            System.out.println("1 : ADD CD");
            System.out.println("2 : SUM CD in store");
            System.out.println("3 : SUM price of Phu's store");
            System.out.println("4 : Sort songs of Phu's store for price from low to high");
            System.out.println("5 : Sort songs of Phu's store for price from Hight to Low");
            System.out.println("6 : Print Phu's store songs list");
            System.out.println("7 : Check this CD store later");
            luachon = kiemtra(luachon);
            switch (luachon) {
                case 1 -> {
                    CD newCD = insertCD();
                    addCD(0, MAX, newCD);// coi lan size XXXX
                }
                case 2 -> {
                    System.out.println("So luong bai hat REMIX cua cua hang :" + CDlist.size());
                    pressAnyKeyToContinue();
                }
                case 3 -> {
                    float priOfStore = 0;
                    for (CD value : CDlist.values()) {
                        priOfStore += value.getPri();
                    }
                    System.out.println("Tong gia tri tat ca CD cua cua hang :" + priOfStore + " $ la my~");
                    pressAnyKeyToContinue();
                }
                case 4 -> sapxeplist();
                case 5 -> sapseptucaoxuongthap();
                case 6 -> {
                    inCDlist();
                    pressAnyKeyToContinue();
                }
                case 7 -> System.out.println("GOOD BIGHT! \n");
                default -> {
                    System.out.println("Wrong insert? Try agarin! \n");
                    pressAnyKeyToContinue();
                }
            }
        } while (luachon != 7);

    }
}