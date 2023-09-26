package com.example.wxmp.repository;

import com.example.wxmp.entity.NetworkHookLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NetworkRepository extends JpaRepository<NetworkHookLog, Long> {
    // 可以添加自定义的查询方法
}
