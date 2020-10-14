package me.baoning.ratejava.dao;

import me.baoning.ratejava.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeDao  extends JpaRepository<Grade,Integer> {
}
