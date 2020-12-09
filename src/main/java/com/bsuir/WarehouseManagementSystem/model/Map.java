package com.bsuir.WarehouseManagementSystem.model;


import javax.persistence.*;

@Entity
@Table(name = "Map")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "rows_amount")
    private Integer rowsAmount;
    @Column(name = "columns_amount")
    private Integer columnsAmount;
    @Column(name = "floors_amount")
    private Integer floorsAmount;

    public Map() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRowsAmount() {
        return rowsAmount;
    }

    public void setRowsAmount(Integer rowsAmount) {
        this.rowsAmount = rowsAmount;
    }

    public Integer getColumnsAmount() {
        return columnsAmount;
    }

    public void setColumnsAmount(Integer columnsAmount) {
        this.columnsAmount = columnsAmount;
    }

    public Integer getFloorsAmount() {
        return floorsAmount;
    }

    public void setFloorsAmount(Integer floorsAmount) {
        this.floorsAmount = floorsAmount;
    }
}
