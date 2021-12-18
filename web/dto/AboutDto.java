package com.example.registrationLoginSecurityThymeleaf.web.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

public class AboutDto {

    private  Long weight;
    private Date record_date;

    public AboutDto() {
    }

    public AboutDto(Long weight, Date record_date) {
        this.weight = weight;
        this.record_date = record_date;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }
}
