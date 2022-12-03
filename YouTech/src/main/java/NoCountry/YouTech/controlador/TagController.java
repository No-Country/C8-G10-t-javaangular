package NoCountry.YouTech.controlador;

import NoCountry.YouTech.model.Tag;
import NoCountry.YouTech.service.ITag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final ITag service;

    @GetMapping("/all")
    public ResponseEntity<List<Tag>> getAll() { return ResponseEntity.status(OK).body(service.getAllTags());
    }
}
