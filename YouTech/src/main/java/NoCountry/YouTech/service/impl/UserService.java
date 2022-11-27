package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.user.UserRequestDTO;
import NoCountry.YouTech.dto.user.UserResponseDTO;
import NoCountry.YouTech.entities.ContentCreator;
import NoCountry.YouTech.entities.User;
import NoCountry.YouTech.exception.AlreadyExistsException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.repository.ContentCreatorRepository;
import NoCountry.YouTech.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final ContentCreatorRepository creatorRepository;

    private final GenericMapper mapper;

    private final MessageSource messageSource;

    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO save(UserRequestDTO dto) {
        User userCheck = repository.findByEmail(dto.getEmail());
        if (userCheck != null)
            throw new AlreadyExistsException(messageSource.getMessage("email-already-exists", null, Locale.US));

        User newUser = mapper.map(dto, User.class);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser = repository.save(newUser);

        //líneas nuevas para que persista también el creador de contenido
        ContentCreator newContentCreator = mapper.map(dto, ContentCreator.class);
        newContentCreator.setIdUser(newUser);
        creatorRepository.save(newContentCreator);

        UserResponseDTO userResponseDto = mapper.map(newUser, UserResponseDTO.class);
        return userResponseDto;
    }
}
