package com.bootdo.system.dao;

import com.bootdo.system.domain.BootdoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-14 08:51:57
 */
@Mapper
public interface BootdoDao {

	BootdoDO get(Integer id);
	
	List<BootdoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BootdoDO bootdo);
	
	int update(BootdoDO bootdo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
