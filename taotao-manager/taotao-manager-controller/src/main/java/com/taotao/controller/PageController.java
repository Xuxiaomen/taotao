package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 页面跳转
 * @author Xumeng
 *
 */
@Controller

public class PageController {
	/**
	 * 打开首页
	 * @return
	 */
	@RequestMapping("/")
	public String showindex() {
		return "index";
	}
	/**
	 * 展示其他页面
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}
}
