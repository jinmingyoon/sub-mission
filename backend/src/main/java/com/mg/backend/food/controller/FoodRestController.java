package com.mg.backend.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mg.backend.common.entity.Result;
import com.mg.backend.food.dto.FoodTypeRequestDto;
import com.mg.backend.food.service.FoodService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = { "1. FoodRestApi" })
@RestController
@RequestMapping(value = "api/v1/food")
public class FoodRestController {

    @Autowired
    FoodService foodService;

    @ApiOperation(value = "모든 음식 종류 조회", notes = "모든 음식 종류을 조회합니다.")
    @GetMapping("/types")
    @ResponseBody
    public Result retrieveFoodTypeList() {
        return foodService.retrieveFoodTypeList();

    }

    @ApiOperation(value = "음식이름이 일치하는 데이터을 반환하는 메소드", notes = "특정 음식을 조회합니다.")
    @GetMapping("/type/{foodName}")
    @ResponseBody
    public Result retrieveFoodType(
            @ApiParam(value = "음식 이름", required = true) @RequestParam String foodName) {
        return foodService.retrieveFoodType(foodName);
    }

    @ApiOperation(value = "특정 음식 조회조건이 일치하는 데이터 중 랜덤으로 반환하는 메소드", notes = "특정 조건별 음식 랜덤으로 조회합니다.")
    @GetMapping("/type")
    @ResponseBody
    public Result retrieveFoodTypeChoice(FoodTypeRequestDto dto) {
        return foodService.retrieveFoodTypeChoice(dto);
    }

    @ApiOperation(value = "음식 정보 생성하는 메소드", notes = "음식 정보을 생성합니다.")
    @PostMapping("/type")
    @ResponseBody
    public Result createFoodType(@ModelAttribute FoodTypeRequestDto dto) {
        return foodService.createFoodType(dto);
    }

    @ApiOperation(value = "음식 정보 수정하는 메소드", notes = "음식 정보을 수정합니다.")
    @PutMapping("/type")
    @ResponseBody
    public Result updateFoodType(@ModelAttribute FoodTypeRequestDto dto) {
        return foodService.updateFoodType(dto);
    }

    @ApiOperation(value = "음식 정보 삭제하는 메소드", notes = "음식 정보을 삭제합니다.")
    @DeleteMapping("/type")
    @ResponseBody
    public Result deleteFoodType(@RequestParam long foodtypeId) {
        return foodService.deleteFoodType(foodtypeId);
    }

}
