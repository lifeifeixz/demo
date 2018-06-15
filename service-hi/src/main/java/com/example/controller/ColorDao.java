package com.example.controller;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author flysLi
 * @date 2018/2/27
 */
@Transactional
public interface ColorDao extends CrudRepository<Color, Integer> {
    List<Color> findByColor(String color);
}
