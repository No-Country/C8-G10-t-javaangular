package NoCountry.YouTech.service.impl;

import NoCountry.YouTech.dto.broadCastType.BroadCastTypeDTO;
import NoCountry.YouTech.dto.tag.TagResponseDTO;
import NoCountry.YouTech.exception.EmptyListException;
import NoCountry.YouTech.exception.NotFoundException;
import NoCountry.YouTech.exception.UnableToUpdateEntityException;
import NoCountry.YouTech.mapper.GenericMapper;
import NoCountry.YouTech.model.BroadcastType;
import NoCountry.YouTech.model.Tag;
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

    @Override
    public BroadCastTypeDTO update(BroadCastTypeDTO dto, Long id) {
        BroadcastType bct = getBCTById(id);
        try{
            BroadcastType updatedBCT = mapper.map(dto, BroadcastType.class);
            updatedBCT.setIdBroadcastType(bct.getIdBroadcastType());
            updatedBCT.setStatus((byte)1);
            broadcastTypeRepository.save(updatedBCT);
            return mapper.map(updatedBCT, BroadCastTypeDTO.class);
        } catch (Exception E) {
            throw new UnableToUpdateEntityException(
                    messageSource.getMessage("unable-to-update-tag", new Object[] {id}, Locale.US));
        }
    }

    private BroadcastType getBCTById(Long id) {
        return broadcastTypeRepository.findById(id.intValue()).orElseThrow(
                ()-> new NotFoundException(
                        messageSource.getMessage("tag-not-found", new Object[] {id}, Locale.US))
        );
    }

    public boolean delete(Long id){
        BroadcastType bct = getBCTById(id);
        try{
            BroadcastType bctToDelete = mapper.map(bct, BroadcastType.class);
            bctToDelete.setIdBroadcastType(bct.getIdBroadcastType());
            bctToDelete.setStatus((byte)0);
            broadcastTypeRepository.save(bctToDelete);
            return true;
        }catch (Exception E) {
            return false;
        }
    }
}
