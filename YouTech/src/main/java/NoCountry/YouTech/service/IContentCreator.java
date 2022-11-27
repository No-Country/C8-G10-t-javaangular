package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorRequestDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.entities.ContentCreator;

public interface IContentCreator {
    ContentCreatorResponseDTO create(ContentCreatorRequestDTO dto);
    public ContentCreatorResponseDTO update(ContentCreatorRequestDTO dto, Long id);
}
