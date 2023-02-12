package com.mg.backend.food.entity;

import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Getter
@Entity
@DynamicUpdate
@NoArgsConstructor
@ToString
@Data
@Table(name = "foodtype")
public class FoodType implements Serializable {

    @Id
    @Column(name = "foodtypeid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodtypeId;

    @Column(name = "foodname")
    private String foodName;

    @Column(name = "categoryid")
    Long categoryId;

    @Column(name = "persontype")
    Long persontype;

    @Builder
    public FoodType(Long foodtypeId, String foodName, Long categoryId, Long persontype) {

        this.foodtypeId = foodtypeId;
        this.foodName = foodName;
        this.categoryId = categoryId;
        this.persontype = persontype;
    }

    public void update(String foodName, Long categoryId, Long persontype) {
        this.foodName = foodName;
        this.categoryId = categoryId;
        this.persontype = persontype;
    }

}
