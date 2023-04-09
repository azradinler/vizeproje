import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
//import java.util.Properties;
//import javax.mail.*;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.InternetAddress;
public class main {
    public static void main(String[] args) throws Exception {
        int secim,sec,x,i;
        Scanner menusec= new Scanner(System.in);
        //menü ekranı oluşturma.
        System.out.println("1- Elit üye ekleme");
        System.out.println("2- Genel Üye ekleme");
        System.out.println("3- Mail Gönderme");
        //hangi işlem seçileceğini belirleme.
        secim = menusec.nextInt();
        switch (secim) {
            case 1: {
                System.out.println("kaç kişi kaydetmek istiyorsunuz?");
                x = menusec.nextInt();
                BufferedWriter bw = new BufferedWriter(new FileWriter("elit.txt" ,true));//elit kullanıcı file oluşturuldu iki farklı file sayesinde alt alta eklemek daha kolay oldugu için tercih ettim.
                for(i=0;i<x;i++){//döngüyle istediğimiz sayıda kullanıcı değeri alınır kayıt edilir.
                    System.out.println("isim giriniz:");
                    Scanner scan=new Scanner(System.in);
                    String alinancevap = scan.nextLine();
                    bw.write(alinancevap+"\t");
                    System.out.println("soyisim giriniz:");
                    String soyad= scan.nextLine();
                    bw.write(soyad+"\t");
                    System.out.println("mail giriniz:");
                    String cevap = scan.nextLine();
                    bw.write(cevap);//file içerisine yaz.
                    bw.newLine();
                }
                bw.close();//dosyayı kapattık
                file.doSomething();//sonda kayıt olsun diye iki file birleştirmek için kullanılan class çalıştırıldı.
            break;
            }
            case 2 :{
                System.out.println("kaç kişi kaydetmek istiyorsunuz?");
                x = menusec.nextInt();
                BufferedWriter bw = new BufferedWriter(new FileWriter("genel.txt" ,true));//genel üyelri ilk olarak burda tutuyoruz.
                for(i=0;i<x;i++){
                    System.out.println("isim giriniz:");
                    Scanner scan=new Scanner(System.in);
                    String alinancevap = scan.nextLine();
                    bw.write(alinancevap+"\t");
                    System.out.println("soyisim giriniz:");
                    String soyad= scan.nextLine();
                    bw.write(soyad+"\t");
                    System.out.println("mail giriniz:");
                    String cevap = scan.nextLine();
                    bw.write(cevap);
                    bw.newLine();//bir sonraki satıra geçirme.
                }
                bw.close();//dosyayı kapattık
                file.doSomething();//iki file bişleştirmek için kullanılan class çalıştırıldı.
                break;
            }
            case 3 :{
                System.out.println("1- Elit üyelere mail");
                System.out.println("2- Genel üyelere mail");
                System.out.println("3- Tüm üyelere mail");
                sec = menusec.nextInt();
                switch (sec){
                    case 1:{
                        System.out.println("işlem gerçekleştirilemedi.");
                        break;
                    }
                    case 2 : {
                        System.out.println("işlem gerçekleştirilemiyor.");
                        break;
                    }
                    case 3: {
                        System.out.println("işlem gerçekleştirilemedi");
                        break;
                    }}
            break;
            }
        }
    }}
//mail gonderme kod uygulamasını yapabildim ancak file içerisinde mailleri almayı yapamadığım için çalıştıramadım.
/*class mailse {
    public static void doSomething() throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.transport.protocol","smtp");
        Session session =Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("xxx@gmail.com","xxxx");
            }
        });
        System.out.println("bir mesaj değeri giriniz:");
        Message message =new MimeMessage(session);
        Scanner scan=new Scanner(System.in);
        String alinancevap = scan.nextLine();
        message.setText(alinancevap);
        Address addressTo =new InternetAddress(" ");
        message.setRecipient(Message.RecipientType.TO,addressTo);
        // multiple message.addRecipient();
        Transport.send(message);
    }
}*/
class file {//dosyaların birleştirilmesi için kullanılan class
    public static void doSomething() throws Exception{
        PrintWriter pw = new PrintWriter("kullanıcılar.txt");
        pw.println("#elit üye");
        File f = new File("elit.txt");
        BufferedReader br =new BufferedReader(new FileReader("elit.txt"));//ilk dosya içindeki verileri okuyup yazıyor.
        if (f.createNewFile());
        String line = br.readLine();
        while(line!=null){
            pw.println(line);
            line=br.readLine();
        }
        pw.println("#genel üye");
        f = new File("genel.txt");
        if (f.createNewFile());
        br=new BufferedReader(new FileReader("genel.txt"));//ikinci dosya içindeki verileri okuyup yazıyor.
        line = br.readLine();
        while(line!=null){
            pw.println(line);
            line=br.readLine();
        }
        pw.flush();
        br.close();//dosyayı kapattık
        pw.close();//dosyayı kapattık
    }
}