package com.mg.backend.food.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mg.backend.common.entity.ErrorCode;
import com.mg.backend.common.entity.ErrorResponse;
import com.mg.backend.common.entity.Result;
import com.mg.backend.food.dto.FoodTypeRequestDto;
import com.mg.backend.food.dto.FoodTypeResponseDto;
import com.mg.backend.food.entity.FoodType;
import com.mg.backend.food.repository.FoodRepository;

import lombok.RequiredArgsConstructor;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository repository;

    @Override
    public Result createFoodType(FoodTypeRequestDto params) {
        FoodType foodType = repository.save(params.toEntity());
        Result result = new Result();
        result.setPayload(foodType);
        return result;
    }

    @Override
    public Result retrieveFoodTypeList() {
        List<FoodType> list = repository.findAll();
        Result result = new Result();
        result.setPayload(list.stream().map(FoodTypeResponseDto::new).collect(Collectors.toList()));
        return result;
    }

    @Override
    public Result retrieveFoodType(String foodName) {
        FoodType foodTypeData = repository.findByfoodName(foodName);
        Result result = new Result();
        if (foodTypeData != null) {
            result.setPayload(foodTypeData);
        } else {
            result.setError(new ErrorResponse(ErrorCode.POSTS_NOT_FOUND));
        }
        return result;
    }

    @Override
    public Result deleteFoodType(long foodTypeId) {
        Result result = new Result();
        FoodType foodTypeData = repository.findByfoodtypeId(foodTypeId);
        if (foodTypeData != null) {
            FoodType deleteData = foodTypeData;
            repository.delete(deleteData);
        } else {
            result.setError(new ErrorResponse(ErrorCode.POSTS_NOT_FOUND));
        }
        return result;
    }

    @Override
    public Result retrieveFoodTypeChoice(FoodTypeRequestDto dto) {
        List<FoodType> foodTypeData = repository.findBycategoryIdAndPersontype(dto.getCategoryId(),
                dto.getPersontype());
        Result result = new Result();
        if (!foodTypeData.isEmpty()) {
            int ranNum = rand(0, foodTypeData.size() - 1);

            result.setPayload(foodTypeData.get(ranNum));
        } else {
            result.setError(new ErrorResponse(ErrorCode.POSTS_NOT_FOUND));
        }
        return result;
    }

    public static int rand(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range");
        }

        Random rand = new Random();

        return rand.ints(min, (max + 1)) // IntStream
                .findFirst() // OptionalInt
                .getAsInt(); // int
    }

    @Override
    @Transactional
    public Result updateFoodType(FoodTypeRequestDto dto) {
        FoodType entity = repository.findByfoodtypeId(dto.getFoodtypeId());
        Result result = new Result();
        if (entity != null) {
            entity.update(dto.getFoodName(), dto.getCategoryId(),
                    dto.getPersontype());
            result.setPayload(entity);
        } else {
            result.setError(new ErrorResponse(ErrorCode.POSTS_NOT_FOUND));
        }
        return result;
    }

}
