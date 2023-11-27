package com.example.oauth.dto.st11.response;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class BenefitDto {
    public int Discount;
    public int Mileage;
    public int Point;
}
