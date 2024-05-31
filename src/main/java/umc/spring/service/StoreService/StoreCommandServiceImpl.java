package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository  storeRepository;
    private final RegionRepository regionRepository;
    private final MissionRepository missionRepository;

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

    @Override
    public boolean existsStore(Long storeId) {

        return storeRepository.existsById(storeId);
    }

    @Override
    public Store findById(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(()-> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
    }

}
