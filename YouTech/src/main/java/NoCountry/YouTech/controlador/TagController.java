package NoCountry.YouTech.controlador;

import NoCountry.YouTech.dto.tag.TagResponseDTO;
import NoCountry.YouTech.service.ITag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final ITag service;


    @GetMapping("/all")
    public ResponseEntity<List<TagResponseDTO>> getAll() { return ResponseEntity.status(OK).body(service.getAllTags());
    }



}
