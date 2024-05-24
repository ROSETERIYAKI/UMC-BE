package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @ColumnDefault("'0.0'")
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    // 여기서 missionList 추가
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    // 가게 만들때 지역 넣기
    public void setRegion(Region region) {
        this.region = region;
        region.getStoreList().add(this);
    }

    // missionList의 Getter 메서드
    public List<Mission> getMissionList() {
        return missionList;
    }
}
