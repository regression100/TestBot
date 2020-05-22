package Bot;

import lombok.SneakyThrows;

import java.sql.*;

public class Methods implements InerfaceMethods{
    Connection connection=null;
    Statement statement=null;
    Statement statement2=null;
    ResultSet resultSet=null;
    private String url="jdbc:postgresql://localhost:5432/TestBot";
    private String userDB="postgres", pass="mahmudxon";
    private static int testindex=2;
//    int n=0;
//    String matematika;
//    String ingliz_tili;
    String temp2="";



    @Override
    public void changeUserInformation(User user) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        statement2=connection.createStatement();
        resultSet=statement.executeQuery("select username,firstname,lastname from users where tgid='"+user.getTgID()+"'");
        if (resultSet.next()){
            if (!resultSet.getString(1).equals(user.getUserName())){
                statement2.execute("update users set username='"+user.getUserName()+"' where tgid='"+user.getTgID()+"'");
//                System.out.println(user.getUserName());
            }
            if (!resultSet.getString(2).equals(user.getFirstName())){
                statement2.execute("update users set firstname='"+user.getFirstName()+"' where tgid='"+user.getTgID()+"'");
            }
            if (!resultSet.getString(3).equals(user.getLastName())){
                statement2.execute("update users set lastname='"+user.getLastName()+"' where tgid='"+user.getTgID()+"'");
            }
        }
        System.out.println(user.getUserName());
    }

    @Override
    public void addUser(User user) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();



        temp2="'"+user.getTgID()+"','"+user.getUserName()+"','"+user.getFirstName()+"','"+user.getLastName()+"',"+0;
        statement.execute("insert into users(tgid, username,firstname,lastname,testindex) values ("+temp2+")");



    }

    @Override
    public void addResult(String tgid, String resultIndexses, int n) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        statement.execute("update users set t"+""+n+"index='"+resultIndexses+"' where users.tgid='"+tgid+"'");
        statement.execute("update users set testindex='"+testindex+"' where users.tgid='"+tgid+"'");

    }

    @Override
    public boolean Tekshiruvchi(User user) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();

        String matematika;
        String ingliz_tili;
        int togriJavoblarSoni=0;
        char[] javob;
        char[] togriJavob;
        String javoblar;
        int n=0;

        if (user.getAnswer().substring(0, 1).equals(String.valueOf(testindex))){


            n=Integer.parseInt(user.getAnswer().substring(0,1));

            if (findResult(user.getTgID(),n)){
                return false;
            }
            else {
                System.out.println(user.getAnswer());
//            n=Integer.parseInt(javoblar.substring(0,1));


//            resultSet=statement.executeQuery("select t"+""+n+"index from users where users.tgid='"+user.getTgID()+"'");
//            if (!resultSet.next()){
                resultSet=statement.executeQuery("select * from kalitlarasosiy where id="+n);
                String wrongIndex="";
                while (resultSet.next()){
                    matematika=resultSet.getString(2);
                    ingliz_tili=resultSet.getString(3);
//                ona_tili=resultSet.getString(4);
                    javob=user.getAnswer().toCharArray();
                    togriJavob=("1"+matematika+ingliz_tili).toCharArray();
                    System.out.println(matematika);
                    System.out.println(ingliz_tili);
//                System.out.println(ona_tili);
                    System.out.println(togriJavob);

                    int tekshirish_uzunligi=0;
                    if (user.getAnswer().length()>61){
                        tekshirish_uzunligi=61;
                    }
                    else {
                        tekshirish_uzunligi=user.getAnswer().length();
                    }

                    for (int i = 1; i <tekshirish_uzunligi; i++) {
                        if (togriJavob[i]==javob[i]){
                            togriJavoblarSoni++;
                        }
                        else {
                            wrongIndex+=i+" ";
                        }
                    }
                    for (int i = tekshirish_uzunligi; i <61 ; i++) {
                        wrongIndex+=i+" ";
                    }



                    System.out.println(togriJavoblarSoni);

                    System.out.println();
                }
                System.out.println(user.getTgID());
                System.out.println(wrongIndex);
                System.out.println(n);

                addResult(user.getTgID(), wrongIndex, n);
                return true;
            }




            }
            else {
                return false;
            }
//            }
//        else {
//            return false;
//        }


    }

    @Override
    public boolean findUser(String tgid) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        resultSet=statement.executeQuery("select id from users where tgid='"+tgid+"'");
        if (resultSet.next()){
            return true;
        }
        else {
            return false;
        }

    }

    @SneakyThrows
    @Override
    public boolean findResult(String tgid, int n) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        resultSet=statement.executeQuery("select testindex from users where tgid='"+tgid+"'");
        if (resultSet.next()){
            if (resultSet.getInt(1)==n){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }



    }
}
