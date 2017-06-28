package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.UserService;
import cn.itcast.jk.utils.Encrypt;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SysConstant;
import cn.itcast.jk.utils.UtilFuns;

public class UserServiceImpl implements UserService {
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	private SimpleMailMessage mailMessage;
	private JavaMailSenderImpl mailSender;
	public void setMailMessage(SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}
	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}
	@Override
	public List<User> find(String hql, Class<User> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}
	@Override
	public User get(Class<User> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}
	@Override
	public Page<User> findPage(String hql, Page<User> page, Class<User> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}
	@Override
	public void saveOrUpdate(final User entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			String uuid = UUID.randomUUID().toString().replace("-", "");
			entity.setId(uuid);
			entity.getUserInfo().setId(uuid);
			entity.setPassword(Encrypt.md5(SysConstant.DEFAULT_PASS, entity.getUserName()));
			new Thread(new Runnable() {
				public void run() {
					mailMessage.setTo(entity.getUserInfo().getEmail());
					mailMessage.setSubject("欢迎入职本公司！");
					mailMessage.setText(entity.getUserInfo().getName()+":欢迎加入本公司，您的登录名是："
							+entity.getUserName()+"，初始化密码是："+SysConstant.DEFAULT_PASS+"。");
					mailSender.send(mailMessage);
				}
			}).start();
		}
		baseDao.saveOrUpdate(entity);
	}
	@Override
	public void saveOrUpdateAll(Collection<User> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}
	@Override
	public void deleteById(Class<User> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);
	}
	@Override
	public void delete(Class<User> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);
	}
	
}
