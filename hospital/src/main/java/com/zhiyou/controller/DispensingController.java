package com.zhiyou.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.pojo.Condition;
import com.zhiyou.pojo.Dispensing;
import com.zhiyou.pojo.Medicine;
import com.zhiyou.pojo.Registrationinfor;
import com.zhiyou.pojo.Result;
import com.zhiyou.service.DispensingService;


@Controller
@RequestMapping
public class DispensingController {
	@Autowired
	private  DispensingService dispensingService;
	
	@RequestMapping(value="/selectDispensingByCondition.do",method={RequestMethod.POST})
	@ResponseBody
	public Result selectDispensingByCondition(Condition condition){
		System.out.println("进来了");
		System.out.println(condition.getPageNum());
		Result result = null;
		PageHelper.startPage(condition.getPageNum(), 5);
		List<Dispensing> dispensing_list = dispensingService.selectDispensingByCondition(condition);
		PageInfo<Dispensing> pageInfo = new PageInfo<>(dispensing_list);
		System.out.println(dispensing_list.size());
		if(dispensing_list.size()>0){
			result = Result.success(1012, "请求成功",pageInfo);
		}else{
			result =  Result.fail(1011, "没有找到相关信息",pageInfo);
		}
		return result;
	}
	//通过di_id查找相应 的药品信息
	@RequestMapping(value="/selectDispensingByDi_id.do",method={RequestMethod.POST})
	@ResponseBody
	public Result selectDispensingByDi_id(Integer di_id){
		Result result = null;
		Dispensing dispensing = dispensingService.selectDispensingByDi_id(di_id);
		
		if(dispensing!=null){
			result = Result.success(1012, "请求成功",dispensing);
		}else{
			result =  Result.fail(1011, "没有找到相关信息",dispensing);
		}
		return result;
	}
	@RequestMapping(value="/dispensing.do",method={RequestMethod.POST})
	@ResponseBody
	public Result dispensing(Condition condition){
		Result result = null;
		int i  = dispensingService.dispensing(condition);
		if(i>0){
			result = Result.success(1012, "发药成功");
		}else{
			result =  Result.fail(1011, "发药失败");
		}
		return result;
	}
	@RequestMapping(value="/dispensingAll.do",method={RequestMethod.POST})
	@ResponseBody
	public Result dispensingAll(@RequestParam(value="ids[]")Integer[] ids){
		System.out.println(Arrays.toString(ids));
		ArrayList<Integer> idsList = new ArrayList<>();
		Collections.addAll(idsList, ids);
		Result result = null;
		List<Registrationinfor> registrationinfor_list = dispensingService.dispensingAll(idsList);
		System.out.println(registrationinfor_list.size());
		if(registrationinfor_list.size()>0){
			result = Result.success(1012, "发药成功",registrationinfor_list);
		}else{
			result =  Result.fail(1011, "发药失败",registrationinfor_list);
		}
		return result;
	}
	@RequestMapping(value="/searchAllMedicine.do",method={RequestMethod.POST})
	@ResponseBody
	public Result searchAllMedicine(){
		Result result = null;
		List<Medicine> medicine_list = dispensingService.searchAllMedicine();
		System.out.println(medicine_list.size());
		if(medicine_list.size()>0){
			result = Result.success(1012, "请求成功",medicine_list);
		}else{
			result =  Result.fail(1011, "请求失败",medicine_list);
		}
		return result;
	}
	@RequestMapping(value="/addDispensing.do",method={RequestMethod.POST})
	@ResponseBody
	public Result addDispensing(@RequestParam(value="ids[]")Integer[] ids,Integer m_id,Integer di_counts){
		Result result = null;
		Dispensing dispensing = null;
		List<Dispensing> dispensing_list = new ArrayList<Dispensing>();
		for(int i=0; i<ids.length; i++){
			dispensing = new Dispensing(m_id,ids[i],di_counts,di_counts);
			dispensing_list.add(dispensing);
		}
		/*System.out.println(dispensing_list.size());*/
		int i = dispensingService.addDispensing(dispensing_list);
		System.out.println("数据库更新了");
		if(i>0){
			result = Result.success(1012, "发药成功");
		}else{
			result =  Result.fail(1011, "发药失败");
		}
		return result;
	}
	
	//在新增数据之前查询 是否存在 药  未发放完毕  却又  新增发药记录 的 这是不允许的 会存在重复的记录
	@RequestMapping(value="/searchRepetitionInfo.do",method={RequestMethod.POST})
	@ResponseBody
	public Result searchRepetitionInfo(@RequestParam(value="ids[]")Integer[] ids){
		System.out.println(Arrays.toString(ids));
		ArrayList<Integer> idsList = new ArrayList<>();
		Collections.addAll(idsList, ids);
		Result result = null;
		/*System.out.println(dispensing_list.size());*/
		List<Dispensing> dispensing_list = dispensingService.searchRepetitionInfo(idsList);
		if(dispensing_list.size()>0){
			result = Result.success(1012, "请求成功",dispensing_list);
		}else{
			result =  Result.fail(1011, "请求失败",dispensing_list);
		}
		return result;
	}
	//通过di_id查找相应 的药品信息
		@RequestMapping(value="/updateDispensingByDi_id.do",method={RequestMethod.POST})
		@ResponseBody
		public Result updateDispensingByDi_id(Integer di_id){
			Result result = null;
			int i  = dispensingService.updateDispensingByDi_id(di_id);
			
			if(i>0){
				result = Result.success(1012, "请求成功");
			}else{
				result =  Result.fail(1011, "没有找到相关信息");
			}
			return result;
		}
}
