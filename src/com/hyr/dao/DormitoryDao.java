package com.hyr.dao;

import com.hyr.entity.Dormitory;

import java.util.List;

public interface DormitoryDao {
    public List<Dormitory> list();
    public List<Dormitory> search(String key,String value);
    public Integer save(Dormitory dormitory);
    public List<Dormitory> avaliableList();
    public Integer subAvailable(Integer id);
    public Integer addAvailable(Integer id);
    public List<Integer> findDormitoryIdByBuildingId(Integer id);
    public Integer availableId(List<Integer> dormitoryIdList);
    public Integer update(Dormitory dormitory);
    public Integer deleteById(Integer id);
    public List<Dormitory> findByBuildingId(Integer id);
}
