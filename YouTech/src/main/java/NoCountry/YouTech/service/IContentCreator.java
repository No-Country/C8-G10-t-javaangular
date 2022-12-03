package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.model.ContentCreator;

import java.security.Principal;
import java.util.List;

public interface IContentCreator {

    ContentCreatorResponseDTO update(String email, ContentCreator2UpdateDTO dto, Long id) ;
    List<ContentCreatorResponseDTO> getAllContentCreators();
    ContentCreator getById(Integer id);
}
