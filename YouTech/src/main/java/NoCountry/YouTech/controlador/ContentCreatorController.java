package NoCountry.YouTech.controlador;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.service.IContentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/content_creator")
@RequiredArgsConstructor
public class ContentCreatorController {

    private final IContentCreator service;

    @PutMapping("/{id}")
    public ResponseEntity<ContentCreatorResponseDTO> update(@RequestBody ContentCreator2UpdateDTO dto, @PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(dto, id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContentCreatorResponseDTO>> getAll() { return ResponseEntity.status(OK).body(service.getAllContentCreators());
    }

    @GetMapping("/find")
    public ResponseEntity<List<ContentCreatorResponseDTO>> find(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        return ResponseEntity.status(OK).body(service.findContentCreators(name, null));
    }

}
