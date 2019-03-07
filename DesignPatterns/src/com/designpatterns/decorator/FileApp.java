package com.designpatterns.decorator;


public class FileApp {

    public static void main(String[] args) {

        FileReader fr = new FileReader("data.txt");
        System.out.println(fr.read());


        Compression c1 = new Compression(fr);
        System.out.println(c1.read());

        Encryption e1 = new Encryption(fr);
        System.out.println(e1.read());

        Compression c2 = new Compression(e1);
        System.out.println(c2.read());

        Encryption e2 = new Encryption(c1);
        System.out.println(e2.read());

        // Decorator
        /*try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("filename.ext")));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

}
