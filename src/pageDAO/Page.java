package pageDAO;

public class Page {

    private Integer id = 0;
    private String companyName = "";
    private String email = "";
    private String site = "";
    private String category_1 = "";
    private String category_2 = "";
    private String category_3 = "";
    private String region = "";
    private String federal_district = "";
    private String city = "";
    private String country = "";

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSite() {
        return site;
    }

    public void setCategory_1(String category_1) {
        this.category_1 = category_1;
    }

    public String getCategory_1() {
        return category_1;
    }

    public void setCategory_2(String category_2) {
        this.category_2 = category_2;
    }

    public String getCategory_2() {
        return category_2;
    }

    public void setCategory_3(String category_3) {
        this.category_3 = category_3;
    }

    public String getCategory_3() {
        return category_3;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setFederalDistrict(String federal_district) {
        this.federal_district = federal_district;
    }

    public String getFederalDistrict() {
        return federal_district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

}
