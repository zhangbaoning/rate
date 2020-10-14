package me.baoning.ratejava.dao;

import me.baoning.ratejava.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project,Integer> {
}
