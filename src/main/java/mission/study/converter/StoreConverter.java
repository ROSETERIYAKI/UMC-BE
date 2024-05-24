package mission.study.converter;

import mission.study.domain.Store;
import mission.study.web.dto.StoreRequestDTO;
import mission.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinStoreDTO request) {
        // 입력으로 받은 DTO 에서 region 을 제외한 값들로 엔티티 생성
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .build();
    }
}
