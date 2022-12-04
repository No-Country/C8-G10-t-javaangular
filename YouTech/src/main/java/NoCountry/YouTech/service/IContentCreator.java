package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumRequestDTO;
import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.model.ContentCreator;

import java.util.List;

public interface IContentCreator {

    ContentCreatorResponseDTO update(String email, ContentCreator2UpdateDTO dto, Integer id) ;
    List<ContentCreatorResponseDTO> getAllContentCreators();
    ContentCreator getById(Integer id);
    BroadcastMediumResponseDTO saveBroadcastMedium(String email, BroadcastMediumRequestDTO dto, Integer id);
}
