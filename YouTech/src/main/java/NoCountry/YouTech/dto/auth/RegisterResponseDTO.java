package NoCountry.YouTech.dto.auth;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponseDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String photo;

    private String token;
}
