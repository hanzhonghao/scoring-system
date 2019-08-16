package com.hx2hospital.service.impl;

import com.hx2hospital.model.Material;
import com.hx2hospital.model.SummarPoints;
import com.hx2hospital.repository.MaterialRepository;
import com.hx2hospital.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> getMaterialList() {
        return materialRepository.findAll();
    }

    @Override
    public Material findMaterialById(long id) {
        return materialRepository.findById(id);
    }

    @Override
    public void save(Material material) {
        materialRepository.save(material);
    }

    @Override
    public void edit(Material material) {
        materialRepository.save(material);
    }

    @Override
    public void delete(long id) {
        materialRepository.deleteById(id);
    }

    @Override
    public SummarPoints summarPoints(List<Material> materials) {
        SummarPoints summarPoints = new SummarPoints();
        int result =0;
        for (Material material:materials){
            int point = material.getPoint();
            result = result+point;
        }
        summarPoints.setPoint(result);
        return summarPoints;
    }

}
