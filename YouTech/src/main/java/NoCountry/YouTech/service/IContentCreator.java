package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumContentCreatorResponseDTO;
import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumRequestDTO;
import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.model.ContentCreator;

import java.util.List;

public interface IContentCreator {

    ContentCreatorResponseDTO update(String email, ContentCreator2UpdateDTO dto);

    List<ContentCreatorResponseDTO> getAllContentCreators();

    ContentCreatorResponseDTO getById(Integer id);

    String saveBroadcastMedium(String email, BroadcastMediumRequestDTO dto);

    List<BroadcastMediumContentCreatorResponseDTO> getAllBroadcastMedium(Integer idContentCreator);

}
