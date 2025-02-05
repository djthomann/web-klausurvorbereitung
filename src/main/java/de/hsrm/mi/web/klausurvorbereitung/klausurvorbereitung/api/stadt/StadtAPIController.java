package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.api.stadt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.entitities.stadt.Stadt;
import de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.services.stadt.StadtService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/stadt")
public class StadtAPIController {
    
    Logger logger = LoggerFactory.getLogger(StadtAPIController.class);

    @Autowired
    private StadtService stadtService;

    @GetMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
    public String getStaedte() throws JsonProcessingException {
        
        List<Stadt> staedte = stadtService.alleStaedteHolen();
        List<StadtDTO> staedteDTOs = new ArrayList<>();

        for(Stadt s : staedte) {
            staedteDTOs.add(StadtDTO.fromStadt(s));
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        json = objectMapper.writeValueAsString(staedteDTOs);

        return json;
    }
    

    @GetMapping(value="/{nummer}", produces=MediaType.APPLICATION_JSON_VALUE)
    public String getStadt(@PathVariable("nummer") int nummer) throws JsonProcessingException {
        
        Optional<Stadt> s = stadtService.holeStadtMitId(nummer);

        if(s.isPresent()) {
            StadtDTO dto = StadtDTO.fromStadt(s.get());
            ObjectMapper objectMapper = new ObjectMapper();
            String json;
            json = objectMapper.writeValueAsString(dto);
            return json;
        } else {
            return HttpStatus.NOT_FOUND.toString();
        }
    }

    @PutMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
    public String putMethodName(@RequestParam("name") String name, @RequestParam("einwohner") int einwohner) throws JsonProcessingException {
        Stadt s = stadtService.speichereStadt(new Stadt(name, einwohner));
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        json = objectMapper.writeValueAsString(s);
        return json; 
    }
    

}
