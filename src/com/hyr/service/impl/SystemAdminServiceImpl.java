package com.hyr.service.impl;

import com.hyr.dao.SystemAdminDao;
import com.hyr.dao.impl.SystemAdminDaoImpl;
import com.hyr.dto.SystemAdminDto;
import com.hyr.entity.SystemAdmin;
import com.hyr.service.SystemAdminService;

public class SystemAdminServiceImpl implements SystemAdminService {

    private SystemAdminDao systemAdminDao=new SystemAdminDaoImpl() ;

    @Override
    public SystemAdminDto login(String username, String password) {
        //1通过username查找数据库
        //2查询结果为空，username错误
        //3不为空，再判断password
        SystemAdmin systemAdmin = this.systemAdminDao.findByUsername(username);
        SystemAdminDto systemAdminDto = new SystemAdminDto();
        if(systemAdmin == null){
            systemAdminDto.setCode(-1);
            systemAdminDto.setSystemAdmin(null);
        } else {
            if(!systemAdmin.getPassword().equals(password)){
                systemAdminDto.setCode(-2);
                systemAdminDto.setSystemAdmin(null);
            } else {
                systemAdminDto.setCode(0);
                systemAdminDto.setSystemAdmin(systemAdmin);
            }
        }
        return systemAdminDto;
    }
}
