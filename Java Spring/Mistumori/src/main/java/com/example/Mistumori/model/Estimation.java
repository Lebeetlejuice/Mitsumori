package com.example.Mistumori.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank
    private Integer price;

    @NotBlank
    private Date date;

    @Size(max= 150)
    @NotBlank
    private String Description;

    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
