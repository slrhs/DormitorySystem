package com.hyr.dto;

import com.hyr.entity.SystemAdmin;

public class SystemAdminDto {
    private Integer code;//记录用户名错误/密码错误
    private SystemAdmin systemAdmin;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        this.systemAdmin = systemAdmin;
    }
}
