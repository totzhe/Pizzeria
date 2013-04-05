package models;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 05.04.13
 * Time: 14:00
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "dish_sort")
public class DishSort {

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

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
