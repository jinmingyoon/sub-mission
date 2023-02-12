package com.mg.backend.food.dto;

import javax.persistence.Column;

import com.mg.backend.food.entity.FoodType;

import lombok.Getter;

@Getter
public class FoodTypeResponseDto {

    @Column(name = "foodtypeid")
    private Long foodtypeId;

    @Column(name = "foodname")
    private String foodName;

    @Column(name = "categoryid")
    Long categoryId;

    @Column(name = "persontype")
    Long persontype;

    public FoodTypeResponseDto(FoodType entity) {
        this.foodtypeId = entity.getFoodtypeId();
        this.foodName = entity.getFoodName();
        this.categoryId = entity.getCategoryId();
        this.persontype = entity.getPersontype();

    }

}
