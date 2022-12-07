package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.tag.Tag2UpdateDTO;
import NoCountry.YouTech.dto.tag.TagResponseDTO;
import NoCountry.YouTech.model.Tag;

import java.util.List;

public interface ITag {
    List<TagResponseDTO> getAllTags(short status);
    TagResponseDTO update(Tag2UpdateDTO dto, Long id);

    boolean delete(Long id);
}
