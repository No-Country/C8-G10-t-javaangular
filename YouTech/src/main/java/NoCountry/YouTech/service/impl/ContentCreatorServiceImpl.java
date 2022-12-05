package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumRequestDTO;
import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.model.*;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.exception.NotFoundException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.repository.BroadcastMediumRepository;
import NoCountry.YouTech.repository.BroadcastMediumTagRepository;
import NoCountry.YouTech.repository.ContentCreatorRepository;
import NoCountry.YouTech.repository.UserRepository;
import NoCountry.YouTech.service.IContentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentCreatorServiceImpl implements IContentCreator {

    private final ContentCreatorRepository creatorRepository;
    private final UserRepository repository;
    private final BroadcastMediumRepository broadcastMediumRepository;
    private final BroadcastMediumTagRepository broadcastMediumTagRepository;
    private final GenericMapper mapper;
    private final MessageSource messageSource;


    public ContentCreatorResponseDTO update(String email, ContentCreator2UpdateDTO dto) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user-not-found",
                        null, Locale.US))
        );
        
        /*
        TODO Jimy hay que modificar en la DB el orden de las entidades que se van creando en la tabla CC
        if (entity.getIdContentCreator() != user.getIdUser().intValue()) {
            throw new EntityNotFoundException(messageSource.getMessage("content-creator-not-found", new Object[]{id}, Locale.US));
        }*/

        ContentCreator updatedContentCreator = user.getContentCreator();
        updatedContentCreator.update(dto);
        creatorRepository.save(updatedContentCreator);
        return mapper.map(updatedContentCreator, ContentCreatorResponseDTO.class);
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

    public String saveBroadcastMedium(String email, BroadcastMediumRequestDTO dto) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user-not-found",
                        null, Locale.US))
        );
        ContentCreator creator = user.getContentCreator();
        BroadcastMedium broadcastMedium = mapper.map(dto, BroadcastMedium.class);
        broadcastMedium.setIdBroadcastType(new BroadcastType(dto.getIdBroadcastType()));
        broadcastMedium.setIdContentCreator(creator);


        List<BroadcastMediumTag> listTags = dto.getBroadcastMediumTagList().stream().map((item) -> {
            BroadcastMediumTag broadcastMediumTag = new BroadcastMediumTag();
            broadcastMediumTag.setIdBroadcastMedium(broadcastMedium);
            broadcastMediumTag.setIdTag(new Tag(item));
            return broadcastMediumTag;
        }).collect(Collectors.toList());

        broadcastMedium.setBroadcastMediumTagList(listTags);
        broadcastMediumRepository.save(broadcastMedium);
        return messageSource.getMessage("info-positive",null, Locale.US);
    }
}
