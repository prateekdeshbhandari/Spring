package com.xworkz.Wine.service;

import com.xworkz.Wine.dto.WineDTO;

import java.util.List;

public interface WineService {
   boolean validateAndSave(WineDTO dto);
   List<WineDTO>getShowAlll();
   WineDTO getEdit(Integer id);


}
