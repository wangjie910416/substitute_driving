package com.royal.app.controller.ow;

import com.royal.app.common.base.BaseController;
import com.royal.app.common.page.ResultData;
import com.royal.ow.domain.Slide;
import com.royal.ow.service.ISlideService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 幻灯片 信息操作处理
 * 
 * @author royal
 * @date 2018-12-13
 */
@Controller
@RequestMapping("/ow/slide")
public class SlideController extends BaseController
{
    private String prefix = "ow/slide";
	
	@Autowired
	private ISlideService slideService;
	
	@RequiresPermissions("ow:slide:view")
	@GetMapping()
	public String slide()
	{
	    return prefix + "/slide";
	}
	


	/**
	 * 查询幻灯片列表For 官网
	 */

	@PostMapping("/list")
	@ResponseBody
	public ResultData list(@RequestBody  Slide slide)
	{
		startPage();
        List<Slide> list = slideService.selectSlideListForOw(slide);
		return getDataPage(list);
	}



	
}
