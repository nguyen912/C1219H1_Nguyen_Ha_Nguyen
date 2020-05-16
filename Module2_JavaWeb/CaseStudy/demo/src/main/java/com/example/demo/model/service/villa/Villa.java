package com.example.demo.model.service.villa;

import com.example.demo.model.service.Service;

import javax.persistence.*;
import javax.xml.ws.BindingType;


@Entity
@Table(name = "villa")
public class Villa extends Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Villa(String name) {
        super(name);
    }

    public Villa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
