package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorRequestDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.entities.ContentCreator;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.exception.NotFoundException;
import NoCountry.YouTech.exception.UnableToUpdateEntityException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.repository.ContentCreatorRepository;
import NoCountry.YouTech.service.IContentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentCreatorServiceImpl implements IContentCreator {

    private final ContentCreatorRepository repository;

    private final GenericMapper mapper;
    private final MessageSource messageSource;

    public ContentCreatorResponseDTO update(ContentCreatorRequestDTO dto, Long id) {
        ContentCreator entity = getContentCreatorById(id);
        try {
            ContentCreator updatedEntity = mapper.map(dto, ContentCreator.class);
            updatedEntity.setIdUser(entity.getIdUser());
            return mapper.map(updatedEntity, ContentCreatorResponseDTO.class);
        } catch (Exception e) {
            throw new UnableToUpdateEntityException(messageSource.getMessage("unable-to-update-content-creator", new Object[] {id}, Locale.US));
        }
    }

    private ContentCreator getContentCreatorById(Long id) {
        Optional<ContentCreator> entity = repository.findById(id.compareTo(id));
        if (entity.isEmpty())
            throw new NotFoundException(messageSource.getMessage("content-creator-not-found", new Object[] {id} ,Locale.US));
        return entity.get();
    }

    public List<ContentCreatorResponseDTO> getAllContentCreators() {
        List<ContentCreator> creators =repository.findAll();
        if (creators.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(creators, ContentCreatorResponseDTO.class);
    }
}
