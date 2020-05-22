package Bot;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OfflineStandingsAnalyzer {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        ArrayList<UserStanding> users=new ArrayList<>();
        ArrayList<String> wrongs=new ArrayList<>();
        ArrayList<Integer> wrongsCount=new ArrayList<>();
        int wrongAnswers=0;
        char[] temp;
//        char[] wrongs;
        Connection connection=null;
        Statement statement=null;
        Statement statement2=null;
        Statement statement3=null;
        ResultSet resultSet=null;
        String url="jdbc:postgresql://localhost:5432/TestBot";
        String userDB="postgres", pass="mahmudxon";
        wrongsCount.add(1);
        for (int i = 0; i <60 ; i++) {
            wrongsCount.add(0);
        }

        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        resultSet=statement.executeQuery("select t2index,tgid,firstname,lastname,username from users");
        while (resultSet.next()){
            wrongs=new ArrayList<>();
            UserStanding user=new UserStanding();

            if (resultSet.getString(1)!=null){
                temp=resultSet.getString(1).toCharArray();
                for (int i = 0; i <temp.length ; i++) {
                    if (temp[i]==' '){
                        if (i>2){
                            if (temp[i-2]!=' '){
                                wrongs.add(((temp[i-2]+""+temp[i-1])));
                            }
                            else {
                                wrongs.add(String.valueOf(temp[i-1]));
                            }
                        }
                        else {
                            wrongs.add(String.valueOf(temp[i-1]));
                        }
                    }
                }
                user.setCount(60-wrongs.size());
                user.setTgid(resultSet.getString(2));
                user.setFirstname(resultSet.getString(3));
                user.setLastname(resultSet.getString(4));
                user.setUsername(resultSet.getString(5));
                user.setBall((float) (user.getCount()*3.1));
                int k=1;
//                statement3.execute("insert into testanalyzer values (1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
                for (String wrong:wrongs) {
                    wrongsCount.set(Integer.parseInt(wrong), wrongsCount.get(Integer.parseInt(wrong))+1);
//                    statement2.execute("update testanalyzer set v"+Integer.parseInt(wrong)+"=v"+Integer.parseInt(wrong)+"+"+1+" where id=1");
                    if (Integer.parseInt(wrong)<=30){
                        user.setMatematika_count(user.getMatematika_count()+1);
                    }
                    else {
                        user.setIngliz_tili_count(user.getIngliz_tili_count()+1);
                    }
                }
                
                user.setMatematika_count(30-user.getMatematika_count());
                user.setIngliz_tili_count(30-user.getIngliz_tili_count());
                users.add(user);
//                System.out.println(user.toString());


            }
        }
//        for (int i = 0; i <wrongs.size() ; i++) {
//            System.out.println(wrongs.get(i));
//        }

        users.sort(new Comparator<UserStanding>() {
            @Override
            public int compare(UserStanding o1, UserStanding o2) {
                if (o1.getBall() == o2.getBall())
                    return 0;
                return o1.getBall() > o2.getBall() ? -1 : 1;

            }
        });
        String userTemp="";
        String wrongs_count="";
        statement.execute("insert into testanalyzer(id) values (2)");
        for (int i = 1; i <wrongsCount.size() ; i++) {
            statement.execute("update testanalyzer set v"+i+"="+wrongsCount.get(i)+" where id=2");
        }


        for (int i = 0; i <users.size() ; i++) {
            userTemp="'"+users.get(i).getTgid()+"','"+users.get(i).getFirstname()+"','"+users.get(i).getLastname()+"','"+users.get(i).getUsername()+"',"+users.get(i).getCount()+","+users.get(i).getMatematika_count()+","+users.get(i).getIngliz_tili_count()+","+users.get(i).getBall();
            statement.execute("insert into standings2(tgid,firstname,lastname,username,count,matematika_count,ingliz_tili_count,ball) values ("+userTemp+")");
            System.out.println(users.get(i));
        }
        for (int wronsc: wrongsCount) {
            System.out.println(wronsc);
        }


    }
}
