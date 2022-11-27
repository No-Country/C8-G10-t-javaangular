package NoCountry.YouTech.controlador;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorRequestDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.service.IContentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/content_creator")
@RequiredArgsConstructor
public class ContentCreatorController {

    private final IContentCreator service;

    @PutMapping("/{id}")
    public ResponseEntity<ContentCreatorResponseDTO> update(@RequestBody ContentCreatorRequestDTO dto, @PathVariable Long id) {
        return ResponseEntity.status(OK).body(service.update(dto, id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContentCreatorResponseDTO>> getAll() { return ResponseEntity.status(OK).body(service.getAllContentCreators());
    }

}
