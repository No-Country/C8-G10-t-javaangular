package NoCountry.YouTech.controlador;

import NoCountry.YouTech.dto.contentCreator.ContentCreatorRequestDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.service.IContentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /*@GetPutMapping //get by id ... listado por usuario
    public ResponseEntity<ContentCreatorResponseDTO> createNewActivity(@RequestBody ContentCreatorRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }*/

}
