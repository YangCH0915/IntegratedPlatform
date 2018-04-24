package com.xinruiyun.platform.entity;
/**
 * 归属地
 * @author Administrator
 *
 */
public class QCellCore {

	private Long id;
	/**
	 * 号段
	 */
	private String sectionNo;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 运营商
	 */
	private String operator;
	/**
	 * 区号
	 */
	private String areaCode;
	/**
	 * 邮政编码
	 */
	private String zipCode;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSectionNo() {
		return sectionNo;
	}
	public void setSectionNo(String sectionNo) {
		this.sectionNo = sectionNo;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "QCellCore [id=" + id + ", sectionNo=" + sectionNo + ", province=" + province + ", city=" + city
				+ ", operator=" + operator + ", areaCode=" + areaCode + ", zipCode=" + zipCode + "]";
	}
}
