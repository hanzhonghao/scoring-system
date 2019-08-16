package com.hx2hospital.service;

import com.hx2hospital.model.Material;
import com.hx2hospital.model.SummarPoints;

import java.util.List;

public interface MaterialService {

    public List<Material> getMaterialList();

    public Material findMaterialById(long id);

    public void save(Material material);

    public void edit(Material material);

    public void delete(long id);

    public SummarPoints summarPoints(List<Material> material);


}
