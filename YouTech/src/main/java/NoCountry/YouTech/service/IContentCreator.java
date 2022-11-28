package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;

import java.util.List;

public interface IContentCreator {

    ContentCreatorResponseDTO update(ContentCreator2UpdateDTO dto, Long id);
    List<ContentCreatorResponseDTO> getAllContentCreators();
}
