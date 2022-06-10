package com.meli.quasar.dto;

import java.util.ArrayList;
import java.util.List;
import com.meli.quasar.model.Satelite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoSatelliteDto {

	private List<Satelite> satellites;
	
	 public List<List<String>> getMessages(){
	        List<List<String>> messages = new ArrayList<List<String>>();
	        for(Satelite s : satellites){
	            messages.add(s.getMessage());
	        }
	        return  messages;
	    }
}
