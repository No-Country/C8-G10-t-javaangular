package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.auth.AuthenticationRequestDTO;
import NoCountry.YouTech.dto.auth.AuthenticationResponseDTO;
import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumContentCreatorResponseDTO;
import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumRequestDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseForEditionDTO;
import NoCountry.YouTech.dto.jwt.JwtDTO;
import NoCountry.YouTech.model.*;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.exception.NotFoundException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.projection.IPContentCreator;
import NoCountry.YouTech.projection.IPContentCreatorForEdition;
import NoCountry.YouTech.repository.BroadcastMediumRepository;
import NoCountry.YouTech.repository.BroadcastMediumTagRepository;
import NoCountry.YouTech.repository.ContentCreatorRepository;
import NoCountry.YouTech.repository.UserRepository;
import NoCountry.YouTech.security.auth.UserService;
import NoCountry.YouTech.security.jwt.JwtUtils;
import NoCountry.YouTech.service.IContentCreator;
import NoCountry.YouTech.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    @Transactional
    public String update(String email, ContentCreator2UpdateDTO dto) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user-not-found",
                        null, Locale.US))
        );
        
        /*
        TODO Jimy hay que modificar en la DB el orden de las entidades que se van creando en la tabla CC
        if (entity.getIdContentCreator() != user.getIdUser().intValue()) {
            throw new EntityNotFoundException(messageSource.getMessage("content-creator-not-found", new Object[]{id}, Locale.US));
        }*/
//        User userUpdate = new User();

        if (dto.getPassword() != null && user.getPassword() != dto.getPassword()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getEmail() != null && user.getEmail() != dto.getEmail()) {
            user.setEmail(dto.getEmail());
        }


        if (user.getEmail() != null || user.getPassword() != null) {
            repository.save(user);
        }

        ContentCreator updatedContentCreator = user.getContentCreator();
        updatedContentCreator.update(dto);
        creatorRepository.save(updatedContentCreator);

        JwtDTO jwtDTO = new JwtDTO(updatedContentCreator.getIdContentCreator(), user.getEmail(), updatedContentCreator.getName(), updatedContentCreator.getLastName(), updatedContentCreator.getImageProfile(), user.getIsAdmin());
        final String jwt = jwtUtils.generateToken(jwtDTO);

        return jwt;
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

        List<ContentCreatorResponseDTO> contentCreatorResponseDTOList = creators.stream().map(item -> {
            ContentCreatorResponseDTO contentCreatorResponseDTO = mapper.map(item, ContentCreatorResponseDTO.class);
            contentCreatorResponseDTO.setCountBroadcastMedium(item.getBroadcastMediumList().size());
            return contentCreatorResponseDTO;
        }).collect(Collectors.toList());

        return contentCreatorResponseDTOList;
    }

    @Transactional
    public String saveBroadcastMedium(String email, BroadcastMediumRequestDTO dto) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user-not-found",
                        null, Locale.US))
        );
        ContentCreator creator = user.getContentCreator();
        BroadcastMedium broadcastMedium = mapper.map(dto, BroadcastMedium.class);
        broadcastMedium.setStatus((int) Util.STATUS_ACTIVE);
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

    @Transactional
    @Override
    public String updateBroadcastMedium(String email, Integer idBroadcastMedium, BroadcastMediumRequestDTO dto) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user-not-found",
                        null, Locale.US))
        );

        BroadcastMedium broadcastMedium = broadcastMediumRepository.findById(idBroadcastMedium).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("broadcast-medium-not-found",
                        new Object[]{idBroadcastMedium}, Locale.US))
        );

        broadcastMedium.setName(dto.getName());
        broadcastMedium.setDescription(dto.getDescription());
        broadcastMedium.setUrl(dto.getUrl());
        broadcastMedium.setIdBroadcastType(new BroadcastType(dto.getIdBroadcastType()));
        broadcastMedium.setNameImage(dto.getNameImage());
        broadcastMedium.setUrImage(dto.getUrImage());

        List listIdTag = dto.getBroadcastMediumTagList().stream().map((item) -> item.longValue()).collect(Collectors.toList());
        broadcastMediumTagRepository.deleteAllById(listIdTag);

        List<BroadcastMediumTag> listBroadcastMediumTag = dto.getBroadcastMediumTagList().stream().map((item) -> new BroadcastMediumTag(item.longValue())).collect(Collectors.toList());
        broadcastMedium.setBroadcastMediumTagList(listBroadcastMediumTag);
        broadcastMediumRepository.save(broadcastMedium);

        return messageSource.getMessage("info-success", null, Locale.US);
    }

    @Transactional
    @Override
    public String deleteBroadcastMedium(String email, Integer idBroadcastMedium) {
        repository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user-not-found",
                        null, Locale.US))
        );
        broadcastMediumRepository.deleteById(idBroadcastMedium);

        return messageSource.getMessage("info-success", null, Locale.US);

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
                            item.getIdBroadcastMedium(), item.getUrImage(), item.getNameImage(),
                            item.getName(), item.getDescription(), item.getIdBroadcastType().getIdBroadcastType(),
                            item.getIdBroadcastType().getDescription(), item.getUrl(),
                            broadcastMediumBroadcastMediumTagListList);

            return broadcastMediumContentCreatorResponseDTO;
        }).collect(Collectors.toList());
    }

    public List<ContentCreatorResponseDTO> findContentCreators(String name, int[] tags) {
        System.out.println(" name ---: " + name);
        System.out.println(" response ---: " + creatorRepository.findLikeName(name));
        List<ContentCreatorResponseDTO> creators = creatorRepository.findLikeLastName(name);
        System.out.println(" list ---: " + creators);
        return null;
    }

    @Override
    public ContentCreatorResponseForEditionDTO getForEdition(Integer idContentCreator) {
        IPContentCreatorForEdition ipContentCreatorForEdition = creatorRepository.findForEdition(idContentCreator);

        if (ipContentCreatorForEdition == null) {
            new NotFoundException(
                    messageSource.getMessage("content-creator-not-found", new Object[]{idContentCreator}, Locale.US));
        }
        return mapper.map(ipContentCreatorForEdition, ContentCreatorResponseForEditionDTO.class);
    }

}
