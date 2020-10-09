package congnghepm;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class soundTest extends JFrame {
       public soundTest() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Test Sound Clip");
            this.setSize(300, 200);
            this.setVisible(true);


        }

        public static void main(String[] args) {
            new soundTest();
        }
    }

