package com.riri.grocerystore.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class JBCstore {


    @NotNull
    @Min(0)
    private double total;



    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
