package com.hyr.service.impl;

import com.hyr.dao.DormitoryAdminDao;
import com.hyr.dao.impl.DormitoryAdminDaoImpl;
import com.hyr.dto.DormitoryAdminDto;
import com.hyr.entity.DormitoryAdmin;
import com.hyr.service.DormitoryAdminService;

import java.util.List;

public class DormitoryAdminServiceImpl implements DormitoryAdminService {

    private DormitoryAdminDao dormitoryAdminDao=new DormitoryAdminDaoImpl();
    //controller层负责接受请求，以及最后把结果给他响应传过去
    //service负责处理业务逻辑
    //dao专门查数据库
    @Override
    public List<DormitoryAdmin> list() {
        return this.dormitoryAdminDao.list();
    }

    @Override
    public List<DormitoryAdmin> search(String key, String value) {
        if(value.equals("")) return this.dormitoryAdminDao.list();
        return this.dormitoryAdminDao.search(key, value);
    }

    @Override
    public void save(DormitoryAdmin dormitoryAdmin) {
        Integer save=this.dormitoryAdminDao.save(dormitoryAdmin);
        if(save!=1) throw new RuntimeException("宿管信息添加失败");
    }

    @Override
    public void update(DormitoryAdmin dormitoryAdmin) {
        Integer update=this.dormitoryAdminDao.update(dormitoryAdmin);
        if(update!=1) throw new RuntimeException("宿管信息修改失败");

    }

    @Override
    public void delete(Integer id) {
        Integer delete=this.dormitoryAdminDao.delete(id);
        if(delete!=1) throw new RuntimeException("宿管信息删除失败");
    }

    @Override
    public DormitoryAdminDto login(String username, String password) {
        //1、通过username查询数据库
        //2、查询结果为空，username错误
        //3、查询结果不为空，再判断password是否正确
        DormitoryAdmin dormitoryAdmin = this.dormitoryAdminDao.findByUsername(username);
        DormitoryAdminDto dormitoryAdminDto = new DormitoryAdminDto();
        if(dormitoryAdmin == null){
            dormitoryAdminDto.setCode(-1);
        } else {
            if(!dormitoryAdmin.getPassword().equals(password)){
                dormitoryAdminDto.setCode(-2);
            } else {
                dormitoryAdminDto.setCode(0);
                dormitoryAdminDto.setDormitoryAdmin(dormitoryAdmin);
            }
        }
        return dormitoryAdminDto;
    }

}
