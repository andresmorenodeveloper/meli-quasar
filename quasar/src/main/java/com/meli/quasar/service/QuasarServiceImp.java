package com.meli.quasar.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.meli.quasar.dto.InfoSatelliteDto;
import com.meli.quasar.dto.SateliteOutDto;
import com.meli.quasar.exceptions.LocationException;
import com.meli.quasar.exceptions.MessageException;
import com.meli.quasar.model.Coordinate;
import com.meli.quasar.model.Satelite;

@Service
public class QuasarServiceImp {

	private final static Coordinate KENOBI_POSICICON = new Coordinate(-500, -200);
	private final static Coordinate SKYWALKER_POSICICON = new Coordinate(100, -100);
	private final static Coordinate SATO_POSICICON = new Coordinate(500, 100);

	@Autowired
	QuasarProcessService quasarProcessService;

	public SateliteOutDto operatrionQuasarCalculate(RequestEntity<InfoSatelliteDto> request) throws MessageException, LocationException {
		InfoSatelliteDto satelite = request.getBody();
		
		Satelite sateliteKenobi = (Satelite) satelite.getSatellites().get(0);
		Satelite sateliteSkywalker = (Satelite) satelite.getSatellites().get(1);
		Satelite sateliteSato = (Satelite) satelite.getSatellites().get(2);
		
		return new SateliteOutDto(
				quasarProcessService.getLocation(SKYWALKER_POSICICON, SATO_POSICICON, KENOBI_POSICICON,
						sateliteKenobi.getDistance(), sateliteSkywalker.getDistance(), sateliteSato.getDistance()),
				quasarProcessService.getMessage(satelite.getMessages()));
	}

}
