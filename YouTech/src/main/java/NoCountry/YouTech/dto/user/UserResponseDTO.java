package NoCountry.YouTech.dto.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Long idUser;
    private String email;
    private String password;
    private short status;
    private boolean isAdmin;
}
