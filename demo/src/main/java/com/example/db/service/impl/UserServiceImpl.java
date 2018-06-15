package com.example.db.service.impl;

import com.example.db.bean.User;
import com.example.db.mapper.UserMapper;
import com.example.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author flysLi
 * @date 2018/6/15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    /**
     * 测试试用；忽略
     *
     * @return
     */
    public List getUserById() {
        String sql = "select * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            if (entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + ":" + value);
                }
            }
        }
        return list;
    }
}
