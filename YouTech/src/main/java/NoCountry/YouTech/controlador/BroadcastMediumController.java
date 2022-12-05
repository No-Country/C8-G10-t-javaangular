package NoCountry.YouTech.controlador;

import NoCountry.YouTech.dto.broadcastMedium.BroadcastMediumRequestDTO;
import NoCountry.YouTech.service.IContentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/broadcast_medium")
@RequiredArgsConstructor
public class BroadcastMediumController {

    private final IContentCreator service;

    @PostMapping
    public ResponseEntity<?> registerBroadcastMedium(Principal principal, @RequestBody BroadcastMediumRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveBroadcastMedium(principal.getName(),dto));
    }

}
