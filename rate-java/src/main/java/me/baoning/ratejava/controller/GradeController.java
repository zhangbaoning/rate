package me.baoning.ratejava.controller;

import me.baoning.ratejava.dao.GradeDao;
import me.baoning.ratejava.entity.Grade;
import me.baoning.ratejava.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("grade")
public class GradeController {
    @Autowired
    GradeDao gradeDao;

    @PostMapping("add")
    @ResponseBody
    public Map<String, Object> add(@RequestBody Grade grade) {
        Map<String, Object> map = new HashMap<>();

        try {
            gradeDao.save(grade);
            map.put("status", true);

        } catch (DataIntegrityViolationException e) {
            map.put("status", false);
            map.put("reason", "重复提交");
        }

        return map;
    }
    @GetMapping("statistics/{projectId}")
    public @ResponseBody Map getByProject(@PathVariable("projectId") int projectId) {
        Map returnMap = new HashMap();
        Grade grade = new Grade();
        grade.setProjectId(projectId);
        Example example = Example.of(grade, ExampleMatcher.matching().withIgnorePaths("id"));
        List<Grade> gradeList = gradeDao.findAll(example);
        int scores_60 = 0;
        int scores_70 = 0;
        int scores_80 = 0;
        int scores_90 = 0;
        int scores_100 = 0;
        for (Grade grade1 : gradeList) {
            if (grade1.getScores() < 60) {
                scores_60++;
            } else if (grade1.getScores() <= 70) {
                scores_70++;
            } else if (grade1.getScores() <= 80) {
                scores_80++;
            } else if (grade1.getScores() <= 90) {
                scores_90++;
            } else {
                scores_100++;
            }
        }
        List scoresList = new ArrayList<>();
        scoresList.add(scores_60);
        scoresList.add(scores_70);
        scoresList.add(scores_80);
        scoresList.add(scores_90);
        scoresList.add(scores_100);
        returnMap.put("scores",scoresList);
        return returnMap;
    }
}
