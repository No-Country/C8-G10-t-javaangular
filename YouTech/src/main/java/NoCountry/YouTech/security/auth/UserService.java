package NoCountry.YouTech.security.auth;

import NoCountry.YouTech.dto.auth.AuthenticationRequestDTO;
import NoCountry.YouTech.dto.auth.AuthenticationResponseDTO;
import NoCountry.YouTech.dto.auth.RegisterResponseDTO;
import NoCountry.YouTech.dto.user.UserRequestDTO;
import NoCountry.YouTech.dto.user.UserResponseDTO;
import NoCountry.YouTech.entities.ContentCreator;
import NoCountry.YouTech.entities.User;
import NoCountry.YouTech.exception.AlreadyExistsException;
import NoCountry.YouTech.exception.BadRequestException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.repository.ContentCreatorRepository;
import NoCountry.YouTech.repository.UserRepository;

import NoCountry.YouTech.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final ContentCreatorRepository creatorRepository;

    private final GenericMapper mapper;

    private final MessageSource messageSource;

    private final PasswordEncoder passwordEncoder;

    private final CustomAuthenticatorManager authenticatorManager;

    private final JwtUtils jwtUtils;

    private final CustomDetailsService userDetailsService;

    public RegisterResponseDTO save(UserRequestDTO dto) {
        User userCheck = repository.findByEmail(dto.getEmail());
        if (userCheck != null)
            throw new AlreadyExistsException(messageSource.getMessage("email-already-exists", null, Locale.US));

        User newUser = mapper.map(dto, User.class);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser = repository.save(newUser);

        ContentCreator newContentCreator = mapper.map(dto, ContentCreator.class);
        newContentCreator.setIdUser(newUser);
        creatorRepository.save(newContentCreator);

        RegisterResponseDTO registerResponseDto = mapper.map(newUser, RegisterResponseDTO.class);
        AuthenticationRequestDTO authenticationRequest = new AuthenticationRequestDTO(dto.getEmail(), dto.getPassword());
        AuthenticationResponseDTO token = authenticate(authenticationRequest);
        registerResponseDto.setToken(token.getJwt());
        return registerResponseDto;
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO dto) {
        final Authentication authentication = authenticatorManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
                && authentication.isAuthenticated()) {

            SecurityContextHolder.getContext().setAuthentication(authentication);

            final UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getEmail());
            final String jwt = jwtUtils.generateToken(userDetails);

            return new AuthenticationResponseDTO(jwt);
        } else {
            throw new BadRequestException(messageSource.getMessage("user-not-found", null, Locale.US));
        }
    }
}
