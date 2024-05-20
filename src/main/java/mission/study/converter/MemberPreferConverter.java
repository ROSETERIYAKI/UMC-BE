package mission.study.converter;

import mission.study.domain.FoodCategory;
import mission.study.domain.mapping.MemberPrefer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    // 카테고리 정보만 담긴 리스트 -> 해당 정보를 포함하는 MemberPrefer 객체 생성 후 리스트에 담아 리턴
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
       return foodCategoryList.stream()
               .map(foodCategory ->
                       MemberPrefer.builder()
                               .foodCategory(foodCategory)
                               .build())
               .collect(Collectors.toList());
    }
}
