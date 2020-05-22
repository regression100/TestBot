package TajribaUchun;


import java.sql.*;
import java.util.Scanner;

public class AsosiyFanKalitlar {
    static int var=96;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        String url="jdbc:postgresql://localhost:5432/TestBot";
        String user="postgres", pass="mahmudxon";



        Scanner scannerNum=new Scanner(System.in);
        Scanner scannerString=new Scanner(System.in);
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,user,pass);
//        connection.setAutoCommit(false);
        statement=connection.createStatement();


        int n;


        char x,y,z;
        while (true){
            System.out.println("1. Kalit tuzishni ishlatish");
            System.out.println("2. Chiqish");

            if (scannerNum.nextInt()==1){
                System.out.println("Testlar sonini kiriting:");
                n=scannerNum.nextInt();
                for (int k = 1; k <=n ; k++) {
                    String matematika="",ingliz_tili="",temp="";
                    int ma=0,mb=0,mc=0,md=0;
                    int ia=0,ib=0,ic=0,id=0;

                    System.out.println(k+" - test uchun :");
                    System.out.println("**********************************************");
                    for (int i = 1; i <=30 ; i++) {
                        x = (char) ((int) (Math.random() * 4) +1);
                        y = (char) ((int) (Math.random() * 4) +1);
//                System.out.println( i+") "+(char) (var+x));
                        matematika+=(char)(var+x);
                        ingliz_tili+=(char)(var+y);



                        switch (x){
                            case 1:
                                ma++;
                                break;
                            case 2:
                                mb++;
                                break;
                            case 3:
                                mc++;
                                break;
                            case 4:
                                md++;
                                break;
                        }
                        switch (y){
                            case 1:
                                ia++;
                                break;
                            case 2:
                                ib++;
                                break;
                            case 3:
                                ic++;
                                break;
                            case 4:
                                id++;
                                break;
                        }

                    }
                    System.out.println("Matematika : "+matematika);
                    System.out.println("a = "+ma);
                    System.out.println("b = "+mb);
                    System.out.println("c = "+mc);
                    System.out.println("d = "+md);
                    System.out.println("Ingliz tili : "+ingliz_tili);
                    System.out.println("a = "+ia);
                    System.out.println("b = "+ib);
                    System.out.println("c = "+ic);
                    System.out.println("d = "+id);

                    temp="'"+matematika+"','"+ingliz_tili+"'";
                    statement.execute("insert into kalitlarAsosiy(matematika, ingliz_tili) values ("+temp+")");

                    System.out.println("**********************************************");
                    System.out.println();
                }
            }
            else {
                break;
            }
        }


















    }
}
