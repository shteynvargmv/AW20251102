package com.example.aw20251102_4.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RecipeDetail {
    private Long id;
    private String title;
    private String image;

    @JsonProperty("imageType")
    private String imageType;

    @JsonProperty("readyInMinutes")
    private Integer readyInMinutes;

    private Integer servings;

    @JsonProperty("sourceUrl")
    private String sourceUrl;

    private Boolean vegetarian;
    private Boolean vegan;

    @JsonProperty("glutenFree")
    private Boolean glutenFree;

    @JsonProperty("dairyFree")
    private Boolean dairyFree;

    @JsonProperty("veryHealthy")
    private Boolean veryHealthy;

    private Boolean cheap;

    @JsonProperty("veryPopular")
    private Boolean veryPopular;

    private Boolean sustainable;

    @JsonProperty("lowFodmap")
    private Boolean lowFodmap;

    @JsonProperty("weightWatcherSmartPoints")
    private Integer weightWatcherSmartPoints;

    private String gaps;

    @JsonProperty("preparationMinutes")
    private Integer preparationMinutes;

    @JsonProperty("cookingMinutes")
    private Integer cookingMinutes;

    @JsonProperty("aggregateLikes")
    private Integer aggregateLikes;

    @JsonProperty("healthScore")
    private Double healthScore;

    @JsonProperty("creditsText")
    private String creditsText;

    private String license;

    @JsonProperty("sourceName")
    private String sourceName;

    @JsonProperty("pricePerServing")
    private Double pricePerServing;

    @JsonProperty("extendedIngredients")
    private List<ExtendedIngredient> extendedIngredients;

    private String summary;
    private List<String> cuisines;

    @JsonProperty("dishTypes")
    private List<String> dishTypes;

    private List<String> diets;
    private List<String> occasions;
    private String instructions;

    @JsonProperty("analyzedInstructions")
    private List<AnalyzedInstruction> analyzedInstructions;

    @JsonProperty("originalId")
    private Long originalId;

    @JsonProperty("spoonacularScore")
    private Double spoonacularScore;

    @JsonProperty("spoonacularSourceUrl")
    private String spoonacularSourceUrl;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getImageType() {
        return imageType;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public Integer getServings() {
        return servings;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public Boolean getDairyFree() {
        return dairyFree;
    }

    public Boolean getVeryHealthy() {
        return veryHealthy;
    }

    public Boolean getCheap() {
        return cheap;
    }

    public Boolean getVeryPopular() {
        return veryPopular;
    }

    public Boolean getSustainable() {
        return sustainable;
    }

    public Boolean getLowFodmap() {
        return lowFodmap;
    }

    public Integer getWeightWatcherSmartPoints() {
        return weightWatcherSmartPoints;
    }

    public String getGaps() {
        return gaps;
    }

    public Integer getPreparationMinutes() {
        return preparationMinutes;
    }

    public Integer getCookingMinutes() {
        return cookingMinutes;
    }

    public Integer getAggregateLikes() {
        return aggregateLikes;
    }

    public Double getHealthScore() {
        return healthScore;
    }

    public String getCreditsText() {
        return creditsText;
    }

    public String getLicense() {
        return license;
    }

    public String getSourceName() {
        return sourceName;
    }

    public Double getPricePerServing() {
        return pricePerServing;
    }

    public List<ExtendedIngredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    public String getSummary() {
        return summary;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public List<String> getDishTypes() {
        return dishTypes;
    }

    public List<String> getDiets() {
        return diets;
    }

    public List<String> getOccasions() {
        return occasions;
    }

    public String getInstructions() {
        return instructions;
    }

    public List<AnalyzedInstruction> getAnalyzedInstructions() {
        return analyzedInstructions;
    }

    public Long getOriginalId() {
        return originalId;
    }

    public Double getSpoonacularScore() {
        return spoonacularScore;
    }

    public String getSpoonacularSourceUrl() {
        return spoonacularSourceUrl;
    }
}
