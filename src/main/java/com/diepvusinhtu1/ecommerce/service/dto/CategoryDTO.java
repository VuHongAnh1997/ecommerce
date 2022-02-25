package com.diepvusinhtu1.ecommerce.service.dto;

public class CategoryDTO {

    private Long id;

    private String categoryName;

    private String description;

    private String imageUrl;

    private Long parentId;

    private Long menuPath;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String categoryName, String description, String imageUrl, Long parentId, Long menuPath) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.parentId = parentId;
        this.menuPath = menuPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(Long menuPath) {
        this.menuPath = menuPath;
    }
}

