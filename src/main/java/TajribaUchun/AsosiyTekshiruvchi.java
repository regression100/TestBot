
package TajribaUchun;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.Scanner;

public class AsosiyTekshiruvchi {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        String url="jdbc:postgresql://localhost:5432/TestBot";
        String user="postgres", pass="mahmudxon";

        int n;

        Scanner scannerNum=new Scanner(System.in);
        Scanner scannerString=new Scanner(System.in);
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,user,pass);
//        connection.setAutoCommit(false);
        statement=connection.createStatement();

        String matematika;
        String ingliz_tili;
        int togriJavoblarSoni=0;
        char[] javob;
        char[] togriJavob;
        String javoblar;
        char[] javobM;
        char[] javobI;
        int mtogri=0,itogri=0;

        int id=0;


        String temp2="";
        User user1=new User();
        System.out.println("Telegram id ni kiriting");
        user1.setTgID(scannerString.nextLine());
        System.out.println("Username ni kiriting");
        user1.setUserName(scannerString.nextLine());
        temp2="'"+user1.getTgID()+"','"+user1.getUserName()+"'";
        statement.execute("insert into users(tgid, username) values ("+temp2+")");







//        n=scannerNum.nextInt();
        System.out.println("Javoblarni kiriting:");
        javoblar=scannerString.next();
        javoblar=javoblar.toLowerCase();
        javoblar.replace(" ","");
        javob=javoblar.toCharArray();
        n=Integer.parseInt(String.valueOf(javob[0]));
        if (n<=30&&n>=1){


            System.out.println(javob);
//            n=Integer.parseInt(javoblar.substring(0,1));




            resultSet=statement.executeQuery("select * from kalitlarasosiy where id="+n);
            String wrongIndex="";
            while (resultSet.next()){
                matematika=resultSet.getString(2);
                ingliz_tili=resultSet.getString(3);
//                ona_tili=resultSet.getString(4);
                togriJavob=("1"+matematika+ingliz_tili).toCharArray();
                System.out.println(matematika);
                System.out.println(ingliz_tili);
//                System.out.println(ona_tili);
                System.out.println(togriJavob);

                int tekshirish_uzunligi=0;
                if (javoblar.length()>61){
                    tekshirish_uzunligi=61;
                }
                else {
                    tekshirish_uzunligi=javoblar.length();
                }

                for (int i = 1; i <tekshirish_uzunligi; i++) {
                    if (togriJavob[i]==javob[i]){
                        togriJavoblarSoni++;
                    }
                    else {
                        wrongIndex+=i;
                    }
                }
                for (int i = tekshirish_uzunligi; i <61 ; i++) {
                    wrongIndex+=i;
                }



                System.out.println(togriJavoblarSoni);

//            System.out.print("matematika = "+resultSet.getString(2));
//            System.out.print("   tarix = "+resultSet.getString(3));
//            System.out.print("   ona tili = "+resultSet.getString(4));
                System.out.println();
            }

            statement.execute("update users set t"+""+n+"index='"+wrongIndex+"' where users.tgid='"+user1.getTgID()+"'");
//            while (resultSet.next()){
//                System.out.println(resultSet.getString(1));
//                System.out.println(resultSet.getString(2));
//                System.out.println(resultSet.getString(n+7));
//
//            }

        }
        else {
            System.out.println("Javoblar noto'g'ri formatda kiritilgan!");
        }







    }
}
