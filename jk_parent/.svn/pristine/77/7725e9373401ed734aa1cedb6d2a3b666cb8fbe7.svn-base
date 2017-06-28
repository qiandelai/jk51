package cn.itcast.jk.action.cargo;

import java.util.List;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Feedback;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.FeedbackService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SysConstant;

/**
 * @Description:	Feedback
 * @Author:			24K纯帅
 * @Company:
 * @CreateDate:		2017-6-9 17:18:49
 */

public class FeedbackAction extends BaseAction implements ModelDriven<Feedback> {
	//注入service
	private FeedbackService feedbackService;
	public void setFeedbackService(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	//model驱动
	private Feedback model = new Feedback();
	public Feedback getModel() {
		return this.model;
	}

	//作为属性驱动，接收并封装页面参数
	private Page page = new Page();			//封装页面的参数，主要当前页参数
	public void setPage(Page page) {
		this.page = page;
	}


	//列表展示
	public String list(){
		String hql = "from Feedback where 1=1  ";			//查询所有内容
		
        //细粒度代码start
        User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
        if(user.getUserInfo().getDegree() == 4){
            hql += " and createBy = '"+user.getId()+"' ";
        }else if(user.getUserInfo().getDegree() == 3){
            hql += " and createDept = '"+user.getDept().getId()+"' ";
        }else if(user.getUserInfo().getDegree() == 2){
            
        }else if(user.getUserInfo().getDegree() == 1){
            
        }else if(user.getUserInfo().getDegree() == 0){
            
        }
        //细粒度代码end
        hql += " or isShare = 1 order by createTime desc";
		
		//给页面提供分页数据
		page.setUrl("feedbackAction_list");		//配置分页按钮的转向链接
		page = feedbackService.findPage(hql, page, Feedback.class, null);
		super.push(page);
		return "plist";						//page list
	}

	//转向新增页面
	public String tocreate(){
		//准备数据

		return "pcreate";
	}
	
	//新增保存
	public String insert(){
	    //细粒度代码start
	    User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
	    model.setCreateBy(user.getId());
	    model.setCreateDept(user.getDept().getId());
	    //细粒度代码end 
	      
		feedbackService.saveOrUpdate(model);

		return "alist";			//返回列表，重定向action_list
	}

	//转向修改页面
	public String toupdate(){

		//准备修改的数据
		Feedback obj = feedbackService.get(Feedback.class, model.getId());
		//压入栈顶
		super.push(obj);

		return "pupdate";
	}

	//修改保存
	public String update(){
	    //调用service方法保存数据到数据库
		feedbackService.saveOrUpdate(model);

		return "alist";
	}

	/*//删除一条
	public String deleteById(){
		feedbackService.deleteById(Feedback.class, model.getId());

		return "alist";
	}*/


	//删除多条
      public String delete() {
            // 调用service方法遍历删除
            feedbackService.delete(Feedback.class, model.getId().split(", "));

            return "alist";
      }

	//查看
	public String toview(){
	    //根据id获取对象
		Feedback obj = feedbackService.get(Feedback.class, model.getId());
		 //压入栈顶
		super.push(obj);

		return "pview";			//转向查看页面
	}

	//解决问题页面
      public String toresolve() {
            //根据id获取对象
            Feedback obj = feedbackService.get(Feedback.class, model.getId());
            //压入栈顶
            super.push(obj);

            return "toresolve";
      }
      
      //保存解决问题
      public String resolve() {
            //调用service方法保存数据到数据库
            feedbackService.saveOrUpdate(model);
            
            return "alist";
      }



}
