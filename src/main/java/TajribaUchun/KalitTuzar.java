package TajribaUchun;

import java.sql.*;
import java.util.Scanner;

public class KalitTuzar {
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
                    String matematika="",tarix="",onaTili="",temp="";
                    int ma=0,mb=0,mc=0,md=0;
                    int ta=0,tb=0,tc=0,td=0;
                    int oa=0,ob=0,oc=0,od=0;
                    System.out.println(k+" - test uchun :");
                    System.out.println("**********************************************");
                    for (int i = 1; i <=15 ; i++) {
                        x = (char) ((int) (Math.random() * 4) +1);
                        y = (char) ((int) (Math.random() * 4) +1);
                        z = (char) ((int) (Math.random() * 4) +1);
//                System.out.println( i+") "+(char) (var+x));
                        matematika+=(char)(var+x);
                        tarix+=(char)(var+y);
                        onaTili+=(char)(var+z);


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
                                ta++;
                                break;
                            case 2:
                                tb++;
                                break;
                            case 3:
                                tc++;
                                break;
                            case 4:
                                td++;
                                break;
                        }
                        switch (z){
                            case 1:
                                oa++;
                                break;
                            case 2:
                                ob++;
                                break;
                            case 3:
                                oc++;
                                break;
                            case 4:
                                od++;
                                break;
                        }
                    }
                    System.out.println("Matematika : "+matematika);
                    System.out.println("a = "+ma);
                    System.out.println("b = "+mb);
                    System.out.println("c = "+mc);
                    System.out.println("d = "+md);
                    System.out.println("Tarix : "+tarix);
                    System.out.println("a = "+ta);
                    System.out.println("b = "+tb);
                    System.out.println("c = "+tc);
                    System.out.println("d = "+td);
                    System.out.println("Ona tili : "+onaTili);
                    System.out.println("a = "+oa);
                    System.out.println("b = "+ob);
                    System.out.println("c = "+oc);
                    System.out.println("d = "+od);
                    temp="'"+matematika+"','"+tarix+"','"+onaTili+"'";
                    statement.execute("insert into kalitlar(matematika, tarix, ona_tili) values ("+temp+")");

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
