package com.meli.quasar.dto;

import com.meli.quasar.model.Coordinate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SateliteOutDto {

	private Coordinate coordinate;
	private String message;
	
	public SateliteOutDto(Coordinate coordinate, String message) {
		this.setCoordinate(coordinate);
		this.message =message;
	}
	


}

