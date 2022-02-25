package com.diepvusinhtu1.ecommerce.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private @NotBlank String categoryName;

    private @NotBlank String description;

    private @NotBlank String imageUrl;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "menu_path")
    private Long menuPath;

    public Category() {
    }

    public Category(Long id, @NotBlank String categoryName, @NotBlank String description, @NotBlank String imageUrl, Long parentId) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.parentId = parentId;
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
