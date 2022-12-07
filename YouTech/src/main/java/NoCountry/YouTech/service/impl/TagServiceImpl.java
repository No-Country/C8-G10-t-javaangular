package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.tag.Tag2UpdateDTO;
import NoCountry.YouTech.dto.tag.TagResponseDTO;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.exception.NotFoundException;
import NoCountry.YouTech.exception.UnableToUpdateEntityException;
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

    public TagResponseDTO update(Tag2UpdateDTO dto, Long id) {
        Tag tag = getTagById(id);
        try{
            Tag updatedTag = mapper.map(dto, Tag.class);
            updatedTag.setIdTag(tag.getIdTag());
            updatedTag.setStatus((byte)1);
            repository.save(updatedTag);
            return mapper.map(updatedTag, TagResponseDTO.class);
        } catch (Exception E) {
            throw new UnableToUpdateEntityException(
                    messageSource.getMessage("unable-to-update-tag", new Object[] {id}, Locale.US));
        }
    }

    private Tag getTagById(Long id) {
        return repository.findById(id.intValue()).orElseThrow(
                ()-> new NotFoundException(
                        messageSource.getMessage("tag-not-found", new Object[] {id}, Locale.US))
        );
    }

    public boolean delete(Long id){
        Tag tag = getTagById(id);
        try{
            Tag tagToDelete = mapper.map(tag, Tag.class);
            tagToDelete.setIdTag(tag.getIdTag());
            tagToDelete.setStatus((byte)0);
            repository.save(tagToDelete);
            return true;
        }catch (Exception E) {
            return false;
        }
    }
}
