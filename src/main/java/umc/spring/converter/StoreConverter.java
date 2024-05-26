package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreResponseDTO;

public class StoreConverter {
    public static StoreResponseDTO.StoreResultDTO toStoreResultDTO(Store store){
        return StoreResponseDTO.StoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
