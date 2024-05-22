package mission.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.code.status.ErrorStatus;
import mission.study.apiPayload.exception.handler.FoodCategoryHandler;
import mission.study.converter.StoreConverter;
import mission.study.domain.Region;
import mission.study.domain.Store;
import mission.study.repository.RegionRepository;
import mission.study.repository.StoreRepository;
import mission.study.web.dto.StoreRequestDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    @Override
    public Store joinStore(StoreRequestDTO.JoinDTO request) {
        Store store = StoreConverter.toStore(request);
        Region region = regionRepository.findById(request.getRegion()).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.REGION_NOT_FOUND));
        store.setRegion(region);
        storeRepository.save(store);
        return store;
    }
}
