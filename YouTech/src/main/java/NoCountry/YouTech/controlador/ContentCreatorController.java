package NoCountry.YouTech.controlador;

import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumRequestDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.model.ContentCreator;
import NoCountry.YouTech.service.IContentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/content_creator")
@RequiredArgsConstructor
public class ContentCreatorController {

    private final IContentCreator service;

    @PostMapping
    public ResponseEntity<ContentCreatorResponseDTO> update(Principal principal, @RequestBody ContentCreator2UpdateDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(principal.getName(), dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContentCreatorResponseDTO>> getAll() { return ResponseEntity.status(OK).body(service.getAllContentCreators());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentCreatorResponseDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.status(OK).body(service.getById(id));
    }



}
