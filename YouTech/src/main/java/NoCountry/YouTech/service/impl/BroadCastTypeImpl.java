package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.broadCastType.BroadCastTypeDTO;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.model.BroadcastType;
import NoCountry.YouTech.repository.BroadcastTypeRepository;
import NoCountry.YouTech.service.IBroadCastType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BroadCastTypeImpl implements IBroadCastType {
    private final BroadcastTypeRepository broadcastTypeRepository;
    private final MessageSource messageSource;
    private final GenericMapper mapper;

    @Override
    public List<BroadCastTypeDTO> getBroadCastTypeActive(short status) {
        List<BroadcastType> broadcastTypes = this.broadcastTypeRepository.findByStatus(status);

        if (broadcastTypes.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return broadcastTypes.stream().map(item -> new BroadCastTypeDTO(item.getIdBroadcastType(), item.getDescription())).collect(Collectors.toList());
    }
}
