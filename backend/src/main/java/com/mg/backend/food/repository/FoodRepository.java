package com.mg.backend.food.repository;

import org.springframework.stereotype.Repository;

import com.mg.backend.food.entity.FoodType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FoodRepository extends JpaRepository<FoodType, String> {

    FoodType findByfoodName(String foodName);

    List<FoodType> findBycategoryIdAndPersontype(Long categoryId, Long persontype);

    FoodType findByfoodtypeId(Long foodtypeId);

}
