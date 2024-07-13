package serializition;

import java.io.*;

public class SerializationAndDeSerilization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
           // writeObject();
             readObject();
    }
    //objeleri osyaya yazdırmak icin method

    public static void writeObject() throws IOException {

        System.out.println("User objeleri olusturuldu");
        User user1=new User(10L,"Mahmut","122356");
        User user2=new User(10L,"Mahmut","122356");
        User user3=new User(10L,"Mahmut","122356");

        //Verileri dosyaya yazdırma islemi yapar.

        FileOutputStream fos=new FileOutputStream("user.txt");
        //NEsneleri yazdırmak istiyoruz.
        ObjectOutputStream out=new ObjectOutputStream(fos);
        //ObjectOutputStream ile bu nesneleri yazailmek icin serilestirilebilmesi lazım.

        out.writeObject(user1);
        out.writeObject(user2);
        out.writeObject(user3);

        out.close();
    }

    //user.txt dosyasından objeleri okuyalım

    public static void readObject() throws IOException, ClassNotFoundException {

        FileInputStream fis=new FileInputStream("user.txt");

        ObjectInputStream input=new ObjectInputStream(fis);
        User user1=(User) input.readObject();
        User user2=(User) input.readObject();
        User user3=(User) input.readObject();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        fis.close();
        input.close();


    }
}
