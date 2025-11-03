package com.example.aw20251102_4.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExtendedIngredient {
    private Long id;
    private String aisle;
    private String image;
    private String consistency;
    private String name;

    @JsonProperty("nameClean")
    private String nameClean;

    private String original;

    @JsonProperty("originalName")
    private String originalName;

    private Double amount;
    private String unit;
    private List<String> meta;

    private Measures measures;

    public Long getId() {
        return id;
    }

    public String getAisle() {
        return aisle;
    }

    public String getImage() {
        return image;
    }

    public String getConsistency() {
        return consistency;
    }

    public String getName() {
        return name;
    }

    public String getNameClean() {
        return nameClean;
    }

    public String getOriginal() {
        return original;
    }

    public String getOriginalName() {
        return originalName;
    }

    public Double getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public List<String> getMeta() {
        return meta;
    }

    public Measures getMeasures() {
        return measures;
    }

    public static class Measures {
        private Measure us;
        private Measure metric;

        public Measure getUs() {
            return us;
        }

        public Measure getMetric() {
            return metric;
        }
    }

    public static class Measure {
        private Double amount;

        @JsonProperty("unitShort")
        private String unitShort;

        @JsonProperty("unitLong")
        private String unitLong;

        public Double getAmount() {
            return amount;
        }

        public String getUnitShort() {
            return unitShort;
        }

        public String getUnitLong() {
            return unitLong;
        }
    }
}
