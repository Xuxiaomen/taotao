package com.taotao.portal.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbContent;
import com.taotao.portal.service.ContentService;
/**
 * 调用服务层服务，查询内容列表
 * @author Administrator
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_AN_URL}")
	private String REST_INDEX_AN_URL;
	
	@Override
	public String getContentList() {
		// 调用服务层的服务
		// 利用http client 请求rest服务器，返回为字符串
		String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AN_URL);
		
		try {
			//把字符串转换成TaoTaoResult
			TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
			//取内容列表 并生成结果的Map list
			List<TbContent> list = (List<TbContent>) taotaoResult.getData();
			List<Map> resultList = new ArrayList<>();
			//创建一个jsp页面要求的pojo列表
			for (TbContent tbContent : list) {
				Map map = new HashMap<>();
				map.put("src", tbContent.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcV", tbContent.getPic2());
				map.put("heightB", 240);
				map.put("widthB", 550);
				map.put("href", tbContent.getUrl());
				map.put("alt", tbContent.getSubTitle());
				resultList.add(map);
			}	
			// 将map list 转换城json字符串并返回
			return JsonUtils.objectToJson(resultList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}