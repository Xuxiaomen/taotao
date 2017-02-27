package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/**
 * 内容插入controller
 * 
 * @author Administrator
 *
 */
@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/content/query/list")
	@ResponseBody
	public EUDataGridResult getTbContentList(int page, int rows, long categoryId) {
		EUDataGridResult result = contentService.getTbContentList(page, rows, categoryId);
 		return result;
	}

	
	@RequestMapping("/content/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent tbContent) {
		TaotaoResult result = contentService.insertContent(tbContent);
		return result;
	}
	
}
