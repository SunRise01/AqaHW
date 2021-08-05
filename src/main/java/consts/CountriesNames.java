package consts;

public enum CountriesNames {
    UKRAINE("Ukraine"), BELARUS(" Belarus ");
    private String countryName;

    CountriesNames(String countryName){
        this.countryName=countryName;
    }

    public String getCountryName(){
        return countryName;
    }
}
