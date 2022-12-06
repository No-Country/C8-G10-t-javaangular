package NoCountry.YouTech.controlador;

import NoCountry.YouTech.dto.contentCreator.ContentCreator2UpdateDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.tag.Tag2UpdateDTO;
import NoCountry.YouTech.dto.tag.TagResponseDTO;
import NoCountry.YouTech.service.ITag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final ITag service;

    @PutMapping("/{id}")
    public ResponseEntity<TagResponseDTO> update(@RequestBody Tag2UpdateDTO dto, @PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(dto, id));
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) throws Exception {
        return service.delete(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TagResponseDTO>> getAll() {
        return ResponseEntity.status(OK).body(service.getAllTags());
    }



}
