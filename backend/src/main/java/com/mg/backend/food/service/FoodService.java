package com.mg.backend.food.service;

import com.mg.backend.common.entity.Result;
import com.mg.backend.food.dto.FoodTypeRequestDto;

public interface FoodService {

    public Result createFoodType(FoodTypeRequestDto dto);

    public Result retrieveFoodTypeList();

    public Result retrieveFoodType(String foodName);

    public Result retrieveFoodTypeChoice(FoodTypeRequestDto dto);

    public Result updateFoodType(FoodTypeRequestDto dto);

    public Result deleteFoodType(long foodTypeId);
}
