package com.zm.ams.dao;

import java.sql.SQLException;

import java.util.List;
import java.util.Optional;

import com.zm.ams.dto.SearchCriteria;
import com.zm.ams.dto.ValidDto;

public interface AmsDao <T extends ValidDto, S extends SearchCriteria> {
	Optional<T> get(int id) throws SQLException;
    
    List<T> getAll() throws SQLException;
    
    List<T> getBySearchCriteria(S criteria) throws SQLException;
    
    void save(T t) throws SQLException;
    
    void update(T t, String... params) throws SQLException;
    
    void delete(T t) throws SQLException;
    
    int getId(T t) throws SQLException;
    
    boolean isExist(T t) throws SQLException;

	
}
