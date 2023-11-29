package com.example.oauth.dto.st11.response;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    public double ProductCode;
    public String ProductName;
    public int ProductPrice;
    public String ProductImage;
    public String ProductImage100;
    public String ProductImage110;
    public String ProductImage120;
    public String ProductImage130;
    public String ProductImage140;
    public String ProductImage150;
    public String ProductImage170;
    public String ProductImage200;
    public String ProductImage250;
    public String ProductImage270;
    public String ProductImage300;
    public String Text1;
    public String Text2;
    public String SellerNick;
    public String Seller;
    public int SellerGrd;
    public int Rating;
    public String DetailPageUrl;
    public int SalePrice;
    public String Delivery;
    public int ReviewCount;
    public int BuySatisfy;
    public String MinorYn;
    public BenefitDto Benefit;
}
