package com.example.agro_futuro_api.controllers;

import com.example.agro_futuro_api.dtos.CultivationRecordDto;
import com.example.agro_futuro_api.models.CultivationModel;
import com.example.agro_futuro_api.repositories.CultivationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CultivationController {
    @Autowired
    CultivationRepository cultivationRepository;

    @PostMapping("/planting")
    public ResponseEntity<CultivationModel> saveCultivation(@RequestBody @Valid CultivationRecordDto cultivationRecordDto){
        var cultivationModel = new CultivationModel();
        BeanUtils.copyProperties(cultivationRecordDto, cultivationModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(cultivationRepository.save(cultivationModel));
    }

    @GetMapping("/planting")
    public ResponseEntity<List<CultivationModel>> getAllCultivation(){
        return ResponseEntity.status(HttpStatus.OK).body(cultivationRepository.findAll());
    }

    @GetMapping("planting/{id}")
    public ResponseEntity<Object> getOneCultivation(@PathVariable(value = "id") Integer id) {
        Optional<CultivationModel> cultivationOptional = cultivationRepository.findById(id);
        if (cultivationOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cultivo não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cultivationOptional.get());
    }
    @PutMapping("/planting/{id}")
    public ResponseEntity<CultivationModel> updateCultivation(@PathVariable(value = "id") Integer id, @RequestBody @Valid CultivationRecordDto cultivationRecordDto) {
        Optional<CultivationModel> cultivationOptional = cultivationRepository.findById(id);
        if (cultivationOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        var cultivationModel = cultivationOptional.get();
        BeanUtils.copyProperties(cultivationRecordDto, cultivationModel);
        return ResponseEntity.status(HttpStatus.OK).body(cultivationRepository.save(cultivationModel));
    }

    @DeleteMapping("/planting/{id}")
    public ResponseEntity<String> deleteCultivation(@PathVariable(value = "id") Integer id) {
        Optional<CultivationModel> cultivationOptional = cultivationRepository.findById(id);
        if (cultivationOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cultivo não encontrado!");
        }
        cultivationRepository.delete(cultivationOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Plantio deletado com sucesso!");
    }
}
