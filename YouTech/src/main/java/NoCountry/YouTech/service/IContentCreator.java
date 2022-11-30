package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.model.ContentCreator;

import java.util.List;

public interface IContentCreator {

    ContentCreatorResponseDTO update(String jwt, ContentCreator2UpdateDTO dto);
    List<ContentCreatorResponseDTO> getAllContentCreators();
    ContentCreator getById(Integer id);
}
