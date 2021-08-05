package consts;

public enum CitiesNames {
    KIYV("Kyiv"), LVIV("Lviv");
    private String cityName;

    CitiesNames(String cityName){
        this.cityName=cityName;
    }

    public String getCityName(){
        return cityName;
    }
}
