package ssm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 请假单
 */
@Entity
@Table(name="mms_LeaveBill")
public class LeaveBill {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;//主键ID
	private Integer days;// 请假天数
	private String content;// 请假原因
	private Date leaveDate = new Date();// 请假时间
	private String remark;// 备注
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="userid")//外键
	private Emp user;// 请假人
	private Integer state=0;// 请假单状态 0初始录入,1.开始审批,2为审批完成
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Emp getUser() {
		return user;
	}
	public void setUser(Emp user) {
		this.user = user;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
