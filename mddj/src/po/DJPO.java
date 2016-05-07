package po;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "登记表")

public class DJPO {
	private Integer ID;
	private String bianhao;
	private String dengji;
	private Integer yeshu;
	private String unitSend;
	private String unitreceive;
	private boolean fabubiaozhi;
	private boolean mdbiaozhi;
	private Integer unitNum;
	private String title;
	private String qianpiren;
	private String jingbanren;
	private String qingkuang;
	private Date date;
	private Time time;
	private String fawenzihao;

	@Id
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	@Column(name = "编号")
	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	@Column(name = "等级")
	public String getDengji() {
		return dengji;
	}

	public void setDengji(String dengji) {
		this.dengji = dengji;
	}

	@Column(name = "页数")
	public Integer getYeshu() {
		return yeshu;
	}

	public void setYeshu(Integer yeshu) {
		if (yeshu == null|| yeshu < 0) {
			this.yeshu = 0;
		} else {
			this.yeshu = yeshu;
		}
	}

	@Column(name = "成文机关")
	public String getUnitSend() {
		return unitSend;
	}

	public void setUnitSend(String unitSend) {
		this.unitSend = unitSend;
	}

	@Column(name = "收文机关")
	public String getUnitreceive() {
		return unitreceive;
	}

	public void setUnitreceive(String unitreceive) {
		this.unitreceive = unitreceive;
	}

	@Column(name = "发布标志")
	public boolean getFabubiaozhi() {
		return fabubiaozhi;
	}

	public void setFabubiaozhi(boolean fabubiaozhi) {
		this.fabubiaozhi = fabubiaozhi;
	}

	@Column(name="明电标志")
	public boolean isMdbiaozhi() {
		return mdbiaozhi;
	}

	public void setMdbiaozhi(boolean mdbiaozhi) {
		this.mdbiaozhi = mdbiaozhi;
	}

	@Column(name = "单位数")
	public Integer getUnitNum() {
		return unitNum;
	}

	public void setUnitNum(Integer unitNum) {
		if (unitNum == null || unitNum < 0) {
			this.unitNum = 0;
		} else {
			this.unitNum = unitNum;
		}
	}

	@Column(name = "标题")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "签批人")
	public String getQianpiren() {
		return qianpiren;
	}

	public void setQianpiren(String qianpiren) {
		this.qianpiren = qianpiren;
	}

	@Column(name = "经办人")
	public String getJingbanren() {
		return jingbanren;
	}

	public void setJingbanren(String jingbanren) {
		this.jingbanren = jingbanren;
	}

	@Column(name = "办理情况")
	public String getQingkuang() {
		return qingkuang;
	}

	public void setQingkuang(String qingkuang) {
		this.qingkuang = qingkuang;
	}

	@Column(name = "收文日期")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "收文时间")
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Column(name = "发文字号")
	public String getFawenzihao() {
		return fawenzihao;
	}

	public void setFawenzihao(String fawenzihao) {
		this.fawenzihao = fawenzihao;
	}
}
