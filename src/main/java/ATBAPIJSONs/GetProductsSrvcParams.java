package ATBAPIBeans;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 07/07/2017.
 */
public class GetProductsSrvcParams {

    private String title="";
    private Integer firstProduct=0;
    private Integer lastProduct=0;
    private String countryCode="";
    private String cityCode="";
    private int priceFrom=0;
    private int priceTo=0;
    private boolean discount=false;
    private String country="";
    private String city="";
    private String code="";
    private ZonedDateTime startDate=null;
    private ZonedDateTime endDate=null;
    private List<String> categories=new ArrayList<>();

    public int getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(int priceFrom) {
        this.priceFrom = priceFrom;
    }

    public int getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(int priceTo) {
        this.priceTo = priceTo;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getFirstProduct() {
        return firstProduct;
    }

    public void setFirstProduct(Integer firstProduct) {
        this.firstProduct = firstProduct;
    }

    public Integer getLastProduct() {
        return lastProduct;
    }

    public void setLastProduct(Integer lastProduct) {
        this.lastProduct = lastProduct;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }


}
