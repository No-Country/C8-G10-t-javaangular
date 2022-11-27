package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorRequestDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.entities.ContentCreator;

import java.util.List;

public interface IContentCreator {

    ContentCreatorResponseDTO update(ContentCreatorRequestDTO dto, Long id);
    List<ContentCreatorResponseDTO> getAllContentCreators();
}
