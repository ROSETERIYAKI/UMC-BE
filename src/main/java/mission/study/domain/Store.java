package mission.study.domain;

import jakarta.persistence.*;
import lombok.*;
import mission.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = true, length = 50)
    private String address;

    private Float score;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    public void setRegion(Region region) {
        if (this.region != null) // 이미 회원이 존재하면 회원 삭제 후 새로 추가하기 -> 수정 위해
            region.getStoreList().remove(this);
        this.region = region;
        region.getStoreList().add(this);
    }
}
