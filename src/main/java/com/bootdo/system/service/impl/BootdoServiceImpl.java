package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.BootdoDao;
import com.bootdo.system.domain.BootdoDO;
import com.bootdo.system.service.BootdoService;



@Service
public class BootdoServiceImpl implements BootdoService {
	@Autowired
	private BootdoDao bootdoDao;
	
	@Override
	public BootdoDO get(Integer id){
		return bootdoDao.get(id);
	}
	
	@Override
	public List<BootdoDO> list(Map<String, Object> map){
		return bootdoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bootdoDao.count(map);
	}
	
	@Override
	public int save(BootdoDO bootdo){
		return bootdoDao.save(bootdo);
	}
	
	@Override
	public int update(BootdoDO bootdo){
		return bootdoDao.update(bootdo);
	}
	
	@Override
	public int remove(Integer id){
		return bootdoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return bootdoDao.batchRemove(ids);
	}
	
}
