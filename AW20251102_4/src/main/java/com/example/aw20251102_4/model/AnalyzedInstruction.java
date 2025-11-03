package com.example.aw20251102_4.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AnalyzedInstruction {
    private String name;
    private List<Step> steps;

    public String getName() {
        return name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public static class Step {
        private Integer number;
        private String step;
        private List<Ingredient> ingredients;
        private List<Equipment> equipment;
        private Length length;

        public Integer getNumber() {
            return number;
        }

        public String getStep() {
            return step;
        }

        public List<Ingredient> getIngredients() {
            return ingredients;
        }

        public List<Equipment> getEquipment() {
            return equipment;
        }

        public Length getLength() {
            return length;
        }
    }

    public static class Ingredient {
        private Long id;
        private String name;

        @JsonProperty("localizedName")
        private String localizedName;

        private String image;

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLocalizedName() {
            return localizedName;
        }

        public String getImage() {
            return image;
        }
    }

    public static class Equipment {
        private Long id;
        private String name;

        @JsonProperty("localizedName")
        private String localizedName;

        private String image;

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLocalizedName() {
            return localizedName;
        }

        public String getImage() {
            return image;
        }
    }

    public static class Length {
        private Integer number;
        private String unit;

        public Integer getNumber() {
            return number;
        }

        public String getUnit() {
            return unit;
        }
    }
}
