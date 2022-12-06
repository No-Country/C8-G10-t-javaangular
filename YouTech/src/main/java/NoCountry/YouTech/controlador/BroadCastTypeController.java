package NoCountry.YouTech.controlador;

import NoCountry.YouTech.dto.broadCastType.BroadCastTypeDTO;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.service.IBroadCastType;
import NoCountry.YouTech.service.IContentCreator;
import NoCountry.YouTech.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
