package Bot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String tgID;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String answer;
    private String resultIndexses;

}
