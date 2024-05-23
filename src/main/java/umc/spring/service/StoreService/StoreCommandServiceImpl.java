package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository  storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store createStore(StoreRequestDTO.StoreInfoDto request, Long regionId) {
        Region region = regionRepository.findById(regionId).orElseThrow(()->new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        Store store = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();

        return storeRepository.save(store);
    }
}
