package NoCountry.YouTech.service;

import NoCountry.YouTech.dto.broadCastType.BroadCastTypeDTO;

import java.util.List;

public interface IBroadCastType {
    List<BroadCastTypeDTO> getBroadCastTypeActive(short status);
}
