package me.baoning.ratejava.controller;

import me.baoning.ratejava.dao.ProjectDao;
import me.baoning.ratejava.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("project")
public class ProjectController {
    @Autowired
    ProjectDao dao;
    @PostMapping("add")
    public @ResponseBody Map add(@RequestBody Project project){
        dao.save(project);
        //System.out.println(project);
        return new HashMap();
    }

}
