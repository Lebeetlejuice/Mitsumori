package com.example.Mistumori.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.sql.Blob;
import java.util.Date;

@Entity
@Data
@Table(name= "ESTIMATION")
public class Estimation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max= 20)
    private String brand;

    @Size(max= 20)
    @NotBlank
    private String name;
    @Size(max= 20)
    @NotBlank
    private String categorie;

    @Size(max= 20)
    @NotBlank
    private String etat_du_produit;

    private Integer price;

    @NotNull
    private Date date;

    @Lob
    private byte[] img;

    @Size(max= 150)
    @NotBlank
    private String Description;

    private Long users_id;

    public Long getUser_id() {
        return users_id;
    }

    public void setUser_id(Long users_id) {
        this.users_id = users_id;
    }

    public Estimation(Long users_id) {
        this.users_id = users_id;
    }

    public Estimation(){

    }


    public Estimation(long id, String brand, String categorie, String name, Integer price, Date date, String description, User user) {
        this.id = id;
        this.brand = brand;
        this.categorie = categorie;
        this.price = price;
        this.name = name;
        this.date = date;
        Description = description;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
