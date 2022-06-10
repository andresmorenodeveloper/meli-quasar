package com.meli.quasar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.quasar.exceptions.MessageException;
import com.meli.quasar.model.Coordinate;
import com.meli.quasar.utils.UtilsMessage;

@Service
public class QuasarProcessService {

	@Autowired
	QuasarProcessCoordinateService quasarProcessSerivce;
	
	@Autowired
	UtilsMessage utilMesaMessage;

	public Coordinate getLocation(Coordinate coordinateKenobi,Coordinate coordinateSkywalker,Coordinate coordinateSato,double distancesKenoby,double distenceskywalker,double distanceSoto) {
		return quasarProcessSerivce.getCoordinate(coordinateKenobi, coordinateSkywalker, coordinateSato,distancesKenoby, distenceskywalker, distanceSoto);
	}

	public String getMessage(List<List<String>> messages) throws MessageException {
		
		List<String> msgPhrases = utilMesaMessage.getMsgPhrases(messages);
		
		if (!utilMesaMessage.validateMessagesSize(messages, msgPhrases.size())) {
			throw new MessageException("Tamaño del mensaje incorrecto");
		}

		utilMesaMessage.removeGap(messages, msgPhrases.size());

		String message = utilMesaMessage.completeMessage(messages);

		if (!utilMesaMessage.validateMessagePhrases(msgPhrases, message)) {
			throw new MessageException("No se puede conocer el mensaje");
		}

		return message;
	}

}
