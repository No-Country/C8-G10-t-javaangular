package NoCountry.YouTech.dto.jwt;

import NoCountry.YouTech.Projection.IPContentCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtDTO {
    String email;
    String name;
    String lastName;
    boolean admin;


}
