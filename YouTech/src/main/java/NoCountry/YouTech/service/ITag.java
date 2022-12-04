package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.tag.TagResponseDTO;

import java.util.List;

public interface ITag {

    List<TagResponseDTO> getAllTags();
}
