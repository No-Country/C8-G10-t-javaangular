package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.tag.TagResponseDTO;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.model.ContentCreator;
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

    private final TagRepository repository;
    private final MessageSource messageSource;
    private final GenericMapper mapper;

    public List<TagResponseDTO> getAllTags(short status) {
        List<Tag> tags = repository.findByStatus(status);
        if (tags.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(tags, TagResponseDTO.class);
    }
}
