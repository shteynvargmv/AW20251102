package com.example.aw20251102_4.model;

import java.util.List;

public class RecipeMatchResponse {
    private Long id;
    private String title;
    private String image;
    private String imageType;
    private Integer usedIngredientCount;
    private Integer missedIngredientCount;
    private List<Ingredient> missedIngredients;
    private List<Ingredient> usedIngredients;
    private List<Ingredient> unusedIngredients;
    private Integer likes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public Integer getUsedIngredientCount() {
        return usedIngredientCount;
    }

    public void setUsedIngredientCount(Integer usedIngredientCount) {
        this.usedIngredientCount = usedIngredientCount;
    }

    public Integer getMissedIngredientCount() {
        return missedIngredientCount;
    }

    public void setMissedIngredientCount(Integer missedIngredientCount) {
        this.missedIngredientCount = missedIngredientCount;
    }

    public List<Ingredient> getMissedIngredients() {
        return missedIngredients;
    }

    public void setMissedIngredients(List<Ingredient> missedIngredients) {
        this.missedIngredients = missedIngredients;
    }

    public List<Ingredient> getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(List<Ingredient> usedIngredients) {
        this.usedIngredients = usedIngredients;
    }

    public List<Ingredient> getUnusedIngredients() {
        return unusedIngredients;
    }

    public void setUnusedIngredients(List<Ingredient> unusedIngredients) {
        this.unusedIngredients = unusedIngredients;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
