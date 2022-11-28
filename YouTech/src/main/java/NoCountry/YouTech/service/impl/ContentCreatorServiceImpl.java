package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.exception.UnableToUpdateEntityException;
import NoCountry.YouTech.model.ContentCreator;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.exception.NotFoundException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.repository.ContentCreatorRepository;
import NoCountry.YouTech.service.IContentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ContentCreatorServiceImpl implements IContentCreator {

    private final ContentCreatorRepository creatorRepository;
    private final GenericMapper mapper;
    private final MessageSource messageSource;


    public ContentCreatorResponseDTO update(ContentCreator2UpdateDTO dto, Long id) {
        ContentCreator creator = getCreatorById(id);
        try{
            ContentCreator updatedContentCreator = mapper.map(dto, ContentCreator.class);
            updatedContentCreator.setIdContentCreator(creator.getIdContentCreator());
            creatorRepository.save(updatedContentCreator);
            return mapper.map(updatedContentCreator, ContentCreatorResponseDTO.class);
        } catch (Exception E) {
            throw new UnableToUpdateEntityException(
                    messageSource.getMessage("unable-to-update-content-creator", new Object[] {id}, Locale.US));
        }
    }

    private ContentCreator getCreatorById(Long id) {
        return creatorRepository.findById(id.intValue()).orElseThrow(
                ()-> new NotFoundException(
                        messageSource.getMessage("content-creator-not-found", new Object[] {id}, Locale.US))
        );
    }

    public List<ContentCreatorResponseDTO> getAllContentCreators() {
        List<ContentCreator> creators =creatorRepository.findAll();
        if (creators.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(creators, ContentCreatorResponseDTO.class);
    }
}
