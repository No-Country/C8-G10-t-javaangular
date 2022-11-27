package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorRequestDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.entities.ContentCreator;
import NoCountry.YouTech.exception.AlreadyExistsException;
import NoCountry.YouTech.exception.NotFoundException;
import NoCountry.YouTech.exception.UnableToUpdateEntityException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.repository.ContentCreatorRepository;
import NoCountry.YouTech.service.IContentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentCreatorServiceImpl implements IContentCreator {

    private final ContentCreatorRepository repository;

    private final GenericMapper mapper;
    private final MessageSource messageSource;

    public ContentCreatorResponseDTO create(ContentCreatorRequestDTO dto) {
        List<ContentCreator> creators =repository.findAll();

        creators.forEach( c -> {
                if (repository.findByName(c.getName()).equalsIgnoreCase(dto.getName())) {
                    throw new AlreadyExistsException(
                        messageSource.getMessage("content-creator-name-already-exists", null, Locale.US));
                }
        });

        ContentCreator contentCreator =mapper.map(dto, ContentCreator.class);
        contentCreator = repository.save(contentCreator);

        return mapper.map(contentCreator, ContentCreatorResponseDTO.class);
    }

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
}
