package hu.me.iit.gyak.gyak.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class saveNewLicitDto {

    @NotNull
    @Min(1)
    private Integer userId;
    @NotNull
    @Min(1)
    private Integer licit;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLicit() {
        return licit;
    }

    public void setLicit(Integer licit) {
        this.licit = licit;
    }
}
