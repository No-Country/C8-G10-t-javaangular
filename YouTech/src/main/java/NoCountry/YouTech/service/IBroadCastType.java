package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.broadCastType.BroadCastTypeDTO;
import NoCountry.YouTech.dto.tag.Tag2UpdateDTO;
import NoCountry.YouTech.dto.tag.TagResponseDTO;

import java.util.List;

public interface IBroadCastType {
    List<BroadCastTypeDTO> getBroadCastTypeActive(short status);

    BroadCastTypeDTO update(BroadCastTypeDTO dto, Long id);

    boolean delete(Long id);
}
