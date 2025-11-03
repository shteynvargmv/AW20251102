package com.example.aw20251102_1.model;

import java.util.ArrayList;

public class CountryApiResponse {
        public Name name;
        public ArrayList<String> tld;
        public String cca2;
        public String ccn3;
        public String cioc;
        public boolean independent;
        public String status;
        public boolean unMember;
        public Currencies currencies;
        public Idd idd;
        public ArrayList<String> capital;
        public ArrayList<String> altSpellings;
        public String region;
        public String subregion;
        public Languages languages;
        public ArrayList<Double> latlng;
        public boolean landlocked;
        public ArrayList<String> borders;
        public double area;
        public Demonyms demonyms;
        public String cca3;
        public Translations translations;
        public String flag;
        public Maps maps;
        public int population;
        public Gini gini;
        public String fifa;
        public Car car;
        public ArrayList<String> timezones;
        public ArrayList<String> continents;
        public Flags flags;
        public CoatOfArms coatOfArms;
        public String startOfWeek;
        public CapitalInfo capitalInfo;
        public PostalCode postalCode;

    public Name getName() {
        return name;
    }

    public ArrayList<String> getTld() {
        return tld;
    }

    public String getCcn3() {
        return ccn3;
    }

    public String getCca2() {
        return cca2;
    }

    public String getCioc() {
        return cioc;
    }

    public boolean isIndependent() {
        return independent;
    }

    public String getStatus() {
        return status;
    }

    public boolean isUnMember() {
        return unMember;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public Idd getIdd() {
        return idd;
    }

    public ArrayList<String> getCapital() {
        return capital;
    }

    public ArrayList<String> getAltSpellings() {
        return altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public Languages getLanguages() {
        return languages;
    }

    public ArrayList<Double> getLatlng() {
        return latlng;
    }

    public boolean isLandlocked() {
        return landlocked;
    }

    public ArrayList<String> getBorders() {
        return borders;
    }

    public double getArea() {
        return area;
    }

    public Demonyms getDemonyms() {
        return demonyms;
    }

    public String getCca3() {
        return cca3;
    }

    public Translations getTranslations() {
        return translations;
    }

    public String getFlag() {
        return flag;
    }

    public Maps getMaps() {
        return maps;
    }

    public int getPopulation() {
        return population;
    }

    public Gini getGini() {
        return gini;
    }

    public String getFifa() {
        return fifa;
    }

    public Car getCar() {
        return car;
    }

    public ArrayList<String> getTimezones() {
        return timezones;
    }

    public ArrayList<String> getContinents() {
        return continents;
    }

    public Flags getFlags() {
        return flags;
    }

    public CoatOfArms getCoatOfArms() {
        return coatOfArms;
    }

    public String getStartOfWeek() {
        return startOfWeek;
    }

    public CapitalInfo getCapitalInfo() {
        return capitalInfo;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }
}

