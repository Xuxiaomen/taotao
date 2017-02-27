package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	EUDataGridResult getTbContentList(int page, int rows, long categoryId); 
	TaotaoResult insertContent(TbContent tbContent);
}
