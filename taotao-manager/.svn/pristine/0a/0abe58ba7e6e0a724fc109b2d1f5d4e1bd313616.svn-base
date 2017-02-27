package com.taotao.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

/**
 * 内容分类管理service
 * 
 * @author Administrator
 *
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EUTreeNode> getCategoryList(Long parentId) {
		// 根据parentID查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			resultList.add(node);
		}
		return resultList;
	}

	@Override
	public TaotaoResult insertContentCategory(Long parentId, String name) {
		// 创建一个pojo
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		// 添加记录
		contentCategoryMapper.insert(contentCategory);
		// 查看父节点的isParent列是否为true，如果不是true改成true;
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			// 更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		return TaotaoResult.ok(contentCategory);
	}

	@Override
	public TaotaoResult updateContentCategory(Long id, String name) {
		TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);

		if (contentCategory == null) {
			return TaotaoResult.build(-1, "没有找到记录");
		} else {
			contentCategory.setName(name);
			int result = contentCategoryMapper.updateByPrimaryKey(contentCategory);
			if (result > 0) {
				return TaotaoResult.ok();
			}
		}
		return TaotaoResult.build(-1, "操作失败");
	}

	@Override
	public TaotaoResult deleteContentCategory(Long id) {

		// 按照id查询记录
		TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);

		if (contentCategory == null) {
			return TaotaoResult.build(-1, "没有找到记录");
		} else {
			// 自身节点属性
			if (contentCategory.getIsParent()) {
				// 是父节点
				// 批量删除
				TbContentCategoryExample example = new TbContentCategoryExample();
				Criteria criteria = example.createCriteria();
				criteria.andParentIdEqualTo(contentCategory.getId());
				// 删除子节点
				contentCategoryMapper.deleteByExample(example);
				// 删除自己
				contentCategoryMapper.deleteByPrimaryKey(id);
				
			} else {
				// 是子节点
				// 查询出父节点
				// 判断同级子节点数
				// 根据parentID查询节点列表
				TbContentCategoryExample example = new TbContentCategoryExample();
				Criteria criteria = example.createCriteria();
				criteria.andParentIdEqualTo(contentCategory.getParentId());
				// 执行查询
				List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);

				if (list.size() > 1) {
					// 数量大于等于2
					// 删除
					contentCategoryMapper.deleteByPrimaryKey(id);
				} else {
					// 等于1
					// 删除并改写父节点属性
					contentCategoryMapper.deleteByPrimaryKey(id);
					TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(contentCategory.getParentId());
					parent.setIsParent(false);
					contentCategoryMapper.updateByPrimaryKey(parent);
				}
			}
		}

		return null;
	}
}
