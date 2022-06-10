package com.meli.quasar.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Satelite {

	private double distance;
    private String name;
    private List<String> message;
    
}
