package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.model.ContentCreator;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.exception.NotFoundException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.model.User;
import NoCountry.YouTech.repository.ContentCreatorRepository;
import NoCountry.YouTech.repository.UserRepository;
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
    private final UserRepository repository;
    private final GenericMapper mapper;
    private final MessageSource messageSource;


    public ContentCreatorResponseDTO update(String userName, ContentCreator2UpdateDTO dto) {
        User user = repository.findByEmail(userName).orElseThrow(
                ()-> new NotFoundException(
                        messageSource.getMessage("user-not-found", null, Locale.US))
        );
        ContentCreator updatedContentCreator = mapper.map(dto, ContentCreator.class);
        creatorRepository.save(updatedContentCreator);
        return mapper.map(updatedContentCreator, ContentCreatorResponseDTO.class);
    }


    public List<ContentCreatorResponseDTO> getAllContentCreators() {
        List<ContentCreator> creators =creatorRepository.findAll();
        if (creators.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(creators, ContentCreatorResponseDTO.class);
    }

    public ContentCreator getById(Integer id) {
        return creatorRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(
                        messageSource.getMessage("content-creator-not-found", new Object[] {id}, Locale.US))
        );
    }
}
