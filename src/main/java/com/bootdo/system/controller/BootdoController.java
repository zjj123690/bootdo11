package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.BootdoDO;
import com.bootdo.system.service.BootdoService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-14 08:51:57
 */
 
@Controller
@RequestMapping("/system/bootdo")
public class BootdoController {
	@Autowired
	private BootdoService bootdoService;
	
	@GetMapping()
	@RequiresPermissions("system:bootdo:bootdo")
	String Bootdo(){
	    return "system/bootdo/bootdo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:bootdo:bootdo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BootdoDO> bootdoList = bootdoService.list(query);
		int total = bootdoService.count(query);
		PageUtils pageUtils = new PageUtils(bootdoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:bootdo:add")
	String add(){
	    return "system/bootdo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:bootdo:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		BootdoDO bootdo = bootdoService.get(id);
		model.addAttribute("bootdo", bootdo);
	    return "system/bootdo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:bootdo:add")
	public R save( BootdoDO bootdo){
		if(bootdoService.save(bootdo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:bootdo:edit")
	public R update( BootdoDO bootdo){
		bootdoService.update(bootdo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:bootdo:remove")
	public R remove( Integer id){
		if(bootdoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:bootdo:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		bootdoService.batchRemove(ids);
		return R.ok();
	}
	
}
