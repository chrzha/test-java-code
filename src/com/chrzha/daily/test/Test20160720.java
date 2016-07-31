package com.chrzha.daily.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.endplay.feeds.jobs.dto.StateCountyDTO;
import com.endplay.feeds.jobs.dto.WeatherAlertDTO;

public class Test20160720 {

    public static void main(String[] args) {
        WeatherAlertDTO weatherAlertDTO = new WeatherAlertDTO();
        StateCountyDTO stateCounty = new StateCountyDTO();
        stateCounty.setCountyCode("36065");
        stateCounty.setCountyName("Oneida");
        
        List<StateCountyDTO> targetAreas = new ArrayList<StateCountyDTO>();
        targetAreas.add(stateCounty);
        weatherAlertDTO.setTargetAreas(targetAreas);
        StateCountyDTO existingStateCountyDTO = new StateCountyDTO();
        existingStateCountyDTO.setCountyCode("36065");
        if (weatherAlertDTO.getTargetAreas().contains(existingStateCountyDTO)) {
            System.out.println("true");
        }
    }
     

}
