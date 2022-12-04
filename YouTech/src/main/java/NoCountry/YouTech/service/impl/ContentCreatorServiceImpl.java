package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumRequestDTO;
import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.model.BroadcastMedium;
import NoCountry.YouTech.model.ContentCreator;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.exception.NotFoundException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.model.User;
import NoCountry.YouTech.repository.BroadcastMediumRepository;
import NoCountry.YouTech.repository.ContentCreatorRepository;
import NoCountry.YouTech.repository.UserRepository;
import NoCountry.YouTech.service.IContentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentCreatorServiceImpl implements IContentCreator {

    private final ContentCreatorRepository creatorRepository;
    private final UserRepository repository;
    private final BroadcastMediumRepository broadcastMediumRepository;
    private final GenericMapper mapper;
    private final MessageSource messageSource;


    public ContentCreatorResponseDTO update(String email, ContentCreator2UpdateDTO dto, Integer id) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user-not-found",
                        null, Locale.US))
        );
        
        /*
        TODO Jimy hay que modificar en la DB el orden de las entidades que se van creando en la tabla CC
        if (entity.getIdContentCreator() != user.getIdUser().intValue()) {
            throw new EntityNotFoundException(messageSource.getMessage("content-creator-not-found", new Object[]{id}, Locale.US));
        }*/

        ContentCreator updatedContentCreator = mapper.map(dto, ContentCreator.class);
        updatedContentCreator.setIdContentCreator(getContentCreatorById(id).getIdContentCreator());
        updatedContentCreator = creatorRepository.save(updatedContentCreator);
        return mapper.map(updatedContentCreator, ContentCreatorResponseDTO.class);
    }

    private ContentCreator getContentCreatorById(Integer id) {
        Optional<ContentCreator> entity = this.creatorRepository.findById(id);
        if (entity.isEmpty()) {
            throw new NotFoundException(messageSource.getMessage("content-creator-not-found", new Object[]{id}, Locale.US));
        }
        return entity.get();
    }


    public ContentCreator getById(Integer id) {
        return creatorRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        messageSource.getMessage("content-creator-not-found", new Object[]{id}, Locale.US))
        );
    }

    public List<ContentCreatorResponseDTO> getAllContentCreators() {
        List<ContentCreator> creators = creatorRepository.findAll();
        if (creators.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(creators, ContentCreatorResponseDTO.class);
    }

    public BroadcastMediumResponseDTO saveBroadcastMedium(String email, BroadcastMediumRequestDTO dto, Integer id) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user-not-found",
                        null, Locale.US))
        );
        ContentCreator creator = getById(id);
        if (creator.getIdContentCreator() != user.getIdUser().intValue()) {
            throw new EntityNotFoundException(messageSource.getMessage("content-creator-not-found", new Object[]{id}, Locale.US));
        }
        BroadcastMedium entity = mapper.map(dto, BroadcastMedium.class);
        entity.setIdContentCreator(creator);
        entity = broadcastMediumRepository.save(entity);
        return mapper.map(entity, BroadcastMediumResponseDTO.class);
    }
}
