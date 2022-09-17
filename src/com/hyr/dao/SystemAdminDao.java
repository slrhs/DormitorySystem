package com.hyr.dao;

import com.hyr.entity.SystemAdmin;

public interface SystemAdminDao {
    public SystemAdmin findByUsername(String username);
}
