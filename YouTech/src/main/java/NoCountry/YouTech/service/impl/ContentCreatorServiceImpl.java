package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumContentCreatorResponseDTO;
import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumRequestDTO;
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
import NoCountry.YouTech.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    @Transactional
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

    public ContentCreatorResponseDTO getById(Integer id) {
        Optional<ContentCreator> contentCreator = creatorRepository.findById(id);
        if (!contentCreator.isPresent()) {
            new NotFoundException(
                    messageSource.getMessage("content-creator-not-found", new Object[]{id}, Locale.US));
        }
        return mapper.map(contentCreator.get(), ContentCreatorResponseDTO.class);

    }

    public List<ContentCreatorResponseDTO> getAllContentCreators() {
        List<ContentCreator> creators = creatorRepository.findAll();
        if (creators.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(creators, ContentCreatorResponseDTO.class);
    }

    @Transactional
    public String saveBroadcastMedium(String email, BroadcastMediumRequestDTO dto) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user-not-found",
                        null, Locale.US))
        );
        ContentCreator creator = user.getContentCreator();
        BroadcastMedium broadcastMedium = mapper.map(dto, BroadcastMedium.class);
        broadcastMedium.setStatus((int)Util.STATUS_ACTIVE);
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

        return messageSource.getMessage("info-positive", null, Locale.US);
    }

    @Override
    public List<BroadcastMediumContentCreatorResponseDTO> getAllBroadcastMedium(Integer idContentCreator) {
        List<BroadcastMedium> broadcastMediumList = broadcastMediumRepository.getAllBroadcastMedium(idContentCreator);
        if (broadcastMediumList.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }

        return broadcastMediumList.stream().map((item) -> {

            List<BroadcastMediumContentCreatorResponseDTO.broadcastMediumTagList> broadcastMediumBroadcastMediumTagListList =
                    item.getBroadcastMediumTagList().stream().limit(5).map(
                                    (itemMediumTag) -> new BroadcastMediumContentCreatorResponseDTO.broadcastMediumTagList(itemMediumTag.getIdTag().getIdTag(), itemMediumTag.getIdTag().getDescription()))
                            .collect(Collectors.toList());

            BroadcastMediumContentCreatorResponseDTO broadcastMediumContentCreatorResponseDTO =
                    new BroadcastMediumContentCreatorResponseDTO(
                            item.getIdBroadcastMedium(), item.getUrImage(), item.getName(), item.getIdBroadcastType().getIdBroadcastType(), item.getIdBroadcastType().getDescription(), item.getUrl(), broadcastMediumBroadcastMediumTagListList);

            return broadcastMediumContentCreatorResponseDTO;
        }).collect(Collectors.toList());
    }

    public List<ContentCreatorResponseDTO> findContentCreators(String name, int[] tags) {
        System.out.println(" name ---: " + name);
        System.out.println(" response ---: " + creatorRepository.findLikeName(name));
        List<ContentCreatorResponseDTO> creators =creatorRepository.findLikeLastName(name);
        System.out.println(" list ---: " + creators);
        return null;
    }

}
