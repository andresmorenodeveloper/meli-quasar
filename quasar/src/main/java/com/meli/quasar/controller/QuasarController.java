package com.meli.quasar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.meli.quasar.dto.InfoSatelliteDto;
import com.meli.quasar.dto.SateliteOutDto;
import com.meli.quasar.exceptions.LocationException;
import com.meli.quasar.exceptions.MessageException;
import com.meli.quasar.service.QuasarServiceImp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.*;

@CrossOrigin
@RestController
@RequestMapping("/center/comunication")
public class QuasarController {
	
	@Autowired
	QuasarServiceImp quasarService;
	
	@PostMapping(path = "/topsecret", produces = "application/json")
	@ApiOperation(value = "Consultar Datos de Facturacion.", notes = "Servicio para consultar datos de la facturacion de una suscripcion.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Datos de la facturacion encontrado con éxito"),
	@ApiResponse(code = 404, message = "Datos de la facturacion no encontrado") })
	public ResponseEntity<SateliteOutDto> topSecret(RequestEntity<InfoSatelliteDto> request) {
		 try {
	            return ResponseEntity.status(HttpStatus.OK).body(quasarService.operatrionQuasarCalculate(request));
	        } catch (MessageException e){
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
	        } catch (LocationException e){
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
	        }
	}
}
