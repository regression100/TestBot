package Bot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStanding {
    private String tgid;
    private String firstname;
    private String lastname;
    private String username;
    private int count;
    private int matematika_count;
    private int ingliz_tili_count;
    private float ball;
}
