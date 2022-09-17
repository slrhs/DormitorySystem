package com.hyr.service.impl;

import com.hyr.dao.DormitoryDao;
import com.hyr.dao.StudentDao;
import com.hyr.dao.impl.DormitoryDaoImpl;
import com.hyr.dao.impl.StudentDaoImpl;
import com.hyr.entity.Dormitory;
import com.hyr.service.DormitoryService;

import java.util.ArrayList;
import java.util.List;

public class DormitoryServiceImpl implements DormitoryService {

    private DormitoryDao dormitoryDao=new DormitoryDaoImpl();
    private StudentDao studentDao=new StudentDaoImpl();

    @Override
    public List<Dormitory> list() {
        return this.dormitoryDao.list();
    }

    @Override
    public List<Dormitory> avaliableList() {
        return this.dormitoryDao.avaliableList();
    }

    @Override
    public List<Dormitory> search(String key, String value) {
        if(value.equals("")) return this.dormitoryDao.list();
        return this.dormitoryDao.search(key, value);
    }

    @Override
    public void save(Dormitory dormitory) {
        Integer save = this.dormitoryDao.save(dormitory);
        if(save != 1) throw new RuntimeException("添加宿舍信息失败");
    }

    @Override
    public void update(Dormitory dormitory) {
        Integer update = this.dormitoryDao.update(dormitory);
        if(update != 1) throw new RuntimeException("更新宿舍信息失败");
    }

    @Override
    public void delete(Integer id) {
        List<Integer> studentIdList = this.studentDao.findStudentIdByDormitoryId(id);
        List<Integer> idTmp=new ArrayList<>();
        idTmp.add(id);
        for (Integer studentId : studentIdList) {
            Integer availableId = this.dormitoryDao.availableId(idTmp);
            Integer updateDorimtory = this.studentDao.updateDorimtory(studentId, availableId);
            Integer subAvailable = this.dormitoryDao.subAvailable(availableId);
            if(updateDorimtory != 1 || subAvailable != 1) throw new RuntimeException("学生更换宿舍失败");
        }
        Integer delete = this.dormitoryDao.deleteById(id);
        if(delete != 1) throw new RuntimeException("删除宿舍信息失败");
    }

    @Override
    public List<Dormitory> findByBuildingId(Integer buildingId) {
        return this.dormitoryDao.findByBuildingId(buildingId);
    }
}
