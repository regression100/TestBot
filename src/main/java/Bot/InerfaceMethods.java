package Bot;

import java.sql.SQLException;

public interface InerfaceMethods {
    void changeUserInformation(User user) throws ClassNotFoundException, SQLException;
    void addUser(User user) throws SQLException, ClassNotFoundException;
    void addResult(String id, String resultIndexses,int n) throws ClassNotFoundException, SQLException;
    boolean Tekshiruvchi(User user) throws SQLException, ClassNotFoundException;
    boolean findUser(String tgid) throws SQLException, ClassNotFoundException;
    boolean findResult(String tgid, int n) throws ClassNotFoundException, SQLException;
}
