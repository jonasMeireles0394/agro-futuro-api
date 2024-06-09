package com.example.agro_futuro_api.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "cultivation")
public class CultivationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_user;
    private LocalDate planting_date;
    private LocalDate harvest_date;
    private String varieties;
    private Double area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public LocalDate getPlanting_date() {
        return planting_date;
    }

    public void setPlanting_date(LocalDate planting_date) {
        this.planting_date = planting_date;
    }

    public LocalDate getHarvest_date() {
        return harvest_date;
    }

    public void setHarvest_date(LocalDate harvest_date) {
        this.harvest_date = harvest_date;
    }

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
