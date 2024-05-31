package umc.spring.service.StoreService;

import org.hibernate.query.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.StoreInfoDto request, Long regionId);

    boolean existsStore(Long storeId);

    Store findById(Long storeId);

}
