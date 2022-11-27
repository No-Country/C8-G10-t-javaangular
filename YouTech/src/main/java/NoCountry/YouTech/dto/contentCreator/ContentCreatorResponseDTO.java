package NoCountry.YouTech.dto.contentCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentCreatorResponseDTO {
    private Integer idContentCreator;
    private String name;
    private String lastName;
    private String idPseudonym;
    private String imageProfile;
}
