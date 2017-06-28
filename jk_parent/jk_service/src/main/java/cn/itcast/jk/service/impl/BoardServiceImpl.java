package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Board;
import cn.itcast.jk.service.BoardService;
import cn.itcast.jk.utils.Page;

public class BoardServiceImpl implements BoardService {
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public List<Board> find(String hql, Class<Board> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board get(Class<Board> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Board> findPage(String hql, Page<Board> page, Class<Board> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Board entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdateAll(Collection<Board> entitys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Class<Board> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Class<Board> entityClass, Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

}
