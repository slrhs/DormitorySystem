package com.hyr.service;

import com.hyr.entity.Dormitory;

import java.util.List;

public interface DormitoryService {
    public List<Dormitory> list();
    public List<Dormitory> avaliableList();
    public List<Dormitory> search(String key,String value);
    public void save(Dormitory dormitory);
    public void update(Dormitory dormitory);
    public void delete(Integer id);
    public List<Dormitory> findByBuildingId(Integer buildingId);
}
