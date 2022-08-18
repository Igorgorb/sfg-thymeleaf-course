package guru.springframework.comands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author igorg
 * @date 16 серп. 2022 р.
 */
public class LoginCommand {

  @NotEmpty
  @Size(min = 4, max = 8)
  private String username;
  
  @NotEmpty
  @Size(min = 8, max = 16)
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  
}
