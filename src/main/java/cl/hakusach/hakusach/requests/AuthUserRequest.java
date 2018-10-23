package cl.hakusach.hakusach.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthUserRequest {

	private String username;
    private String password;
    // TODO: Preguntar acerca de como debe ser el login.
    //private String rol;

}