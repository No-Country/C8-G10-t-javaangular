package NoCountry.YouTech.controlador;

import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumRequestDTO;
import NoCountry.YouTech.service.IContentCreator;
import NoCountry.YouTech.util.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/broadcast_medium")
@RequiredArgsConstructor
public class BroadcastMediumController {

    private final IContentCreator service;

    @PostMapping
    public ResponseEntity<?> registerBroadcastMedium(Principal principal, @RequestBody BroadcastMediumRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveBroadcastMedium(principal.getName(), dto));
    }

    @GetMapping("/{idContentCreator}")
    public ResponseEntity<?> getAllBroadcastMedium(@PathVariable Integer idContentCreator) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.getAllBroadcastMedium(idContentCreator));
    }
}
