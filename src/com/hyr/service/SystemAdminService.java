package com.hyr.service;

import com.hyr.dto.SystemAdminDto;

public interface SystemAdminService {
    public SystemAdminDto login(String username, String password);
}
