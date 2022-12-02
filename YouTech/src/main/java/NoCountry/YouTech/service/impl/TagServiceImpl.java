package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.tag.TagResponseDTO;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.model.Tag;
import NoCountry.YouTech.repository.TagRepository;
import NoCountry.YouTech.service.ITag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements ITag {

    private final TagRepository tagRepository;
    private final GenericMapper mapper;
    private final MessageSource messageSource;



    public List<TagResponseDTO> getAllTags() {
        List<Tag> tags =tagRepository.findAll();
        if (tags.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(tags, TagResponseDTO.class);
    }
}
