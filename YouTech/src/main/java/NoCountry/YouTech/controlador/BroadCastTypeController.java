package NoCountry.YouTech.controlador;

import NoCountry.YouTech.dto.broadCastType.BroadCastTypeDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.dto.tag.Tag2UpdateDTO;
import NoCountry.YouTech.dto.tag.TagResponseDTO;
import NoCountry.YouTech.service.IBroadCastType;
import NoCountry.YouTech.service.IContentCreator;
import NoCountry.YouTech.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/broadcast-type")
@RequiredArgsConstructor
public class BroadCastTypeController {

    private final IBroadCastType service;

    @GetMapping("/actives")
    public ResponseEntity<List<BroadCastTypeDTO>> getAll() {
        return ResponseEntity.status(OK).body(service.getBroadCastTypeActive(Util.STATUS_ACTIVE));
    }

    /*TODO HACER ESTE CRUD, MODIFICARLOS PARA BROADCAST*/
    @PutMapping("/{id}")
    public ResponseEntity<BroadCastTypeDTO> update(@RequestBody BroadCastTypeDTO dto, @PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(dto, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    }
}
