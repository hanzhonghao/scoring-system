package com.hx2hospital.web;

import com.hx2hospital.model.Material;
import com.hx2hospital.model.SummarPoints;
import com.hx2hospital.service.MaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MaterialController {

    @Resource
    MaterialService materialService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/listMaterial";
    }

    @RequestMapping("/listMaterial")
    public String list(Model model) {
        List<Material> materials = materialService.getMaterialList();
        model.addAttribute("materials", materials);
        return "material/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "material/materialsAdd";
    }

    @RequestMapping("/add")
    public String add(Material material) {
        materialService.save(material);
        return "redirect:/listMaterial";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Material material=materialService.findMaterialById(id);
        model.addAttribute("material", material);
        return "material/materialEdit";
    }

    @RequestMapping("/edit")
    public String edit(Material material) {
        materialService.edit(material);
        return "redirect:/listMaterial";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        materialService.delete(id);
        return "redirect:/listMaterial";
    }

    @RequestMapping("/summar")
    public String toSummar(Model model) {
        List<Material> materials = materialService.getMaterialList();

        SummarPoints summarPoints = materialService.summarPoints(materials);

        model.addAttribute("summarPoints", summarPoints);
        return "material/summarPoint";
    }

}
