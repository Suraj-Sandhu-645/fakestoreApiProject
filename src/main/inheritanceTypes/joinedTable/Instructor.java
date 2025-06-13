package com.ecommerce.productservicenovember2024.experimentation.inheritanceTypes.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructors")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User{
    private String module;
}
