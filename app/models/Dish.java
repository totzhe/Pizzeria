package models;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 07.04.13
 * Time: 1:51
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }  */

    /*@Column(name = "sort_id")
    private int sortId;
    public int getSortId() {
        return sortId;
    }

    public void setSortId(int id) {
        this.sortId = id;
    } */

    /*@ManyToOne
        @Id
        @JoinColumn(name="sort_id", referencedColumnName="id", table = "dish_sort") */
    @ManyToOne(fetch=FetchType.LAZY)
    private DishSort sort;

    public DishSort getSort() {
        return sort;
    }

    public void setSort(DishSort sort) {
        this.sort = sort;
    }

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "weight")
    private float weight;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Column(name = "price")
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Column(name = "ingredients")
    private String ingredients;

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "pic_path")
    private String picturePath;

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
