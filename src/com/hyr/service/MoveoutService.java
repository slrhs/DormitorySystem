package com.hyr.service;

import com.hyr.entity.Moveout;

import java.util.List;

public interface MoveoutService {
    public void save(Moveout moveout);
    public List<Moveout> list();
    public List<Moveout> search(String key,String value);
}
