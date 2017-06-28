package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.domain.Board;

import cn.itcast.jk.utils.Page;

public interface BoardService {
	//查询所有，带条件查询
		public List<Board> find(String hql, Class<Board> entityClass, Object[] params);
		
		//获取一条记录
		public Board get(Class<Board> entityClass, Serializable id);
		
		//分页查询，将数据封装到一个page分页工具类对象
		public Page<Board> findPage(String hql, Page<Board> page, Class<Board> entityClass, Object[] params);
		
		//新增和修改保存
		public void saveOrUpdate(Board entity);
		
		//批量新增和修改保存
		public void saveOrUpdateAll(Collection<Board> entitys);
		
		//单条删除，按id
		public void deleteById(Class<Board> entityClass, Serializable id);
		
		//批量删除
		public void delete(Class<Board> entityClass, Serializable[] ids);

}
