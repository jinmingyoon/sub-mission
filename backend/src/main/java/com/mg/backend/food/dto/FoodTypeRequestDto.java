package com.mg.backend.food.dto;

import javax.persistence.*;

import com.mg.backend.food.entity.FoodType;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodTypeRequestDto {

    @Id
    @Setter
    @Column(name = "foodtypeid")
    private Long foodtypeId;

    @Setter
    @Column(name = "foodname")
    private String foodName;

    @Setter
    @Column(name = "categoryid")
    Long categoryId;

    @Setter
    @Column(name = "persontype")
    Long persontype;

    public FoodType toEntity() {
        return FoodType.builder()
                .foodtypeId(foodtypeId)
                .foodName(foodName)
                .categoryId(categoryId)
                .persontype(persontype)
                .build();
    }

}
