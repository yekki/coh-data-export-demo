/***************************************************************************
 *
 * PoC code for evaluating purpose only. No guarantee of quality.
 *
 ***************************************************************************/

package com.oracle.poc.coherence.model;

import com.tangosol.io.pof.annotation.Portable;
import com.tangosol.io.pof.annotation.PortableProperty;


@Portable
public class Employee {
	@PortableProperty(0)
	private String id;

	@PortableProperty(1)
	private String firstName;

	@PortableProperty(2)
	private String lastName;

	@PortableProperty(3)
	private String gender;

	@PortableProperty(4)
	private String favSports;

	@PortableProperty(5)
	private String phoneNumber;

	@PortableProperty(6)
	private String email;

	@PortableProperty(7)
	private String wechat;

	@PortableProperty(8)
	private String company;

	@PortableProperty(9)
	private String spouse;

	@PortableProperty(10)
	private String manager;

	@PortableProperty(11)
	private String title;

	@PortableProperty(12)
	private String expertise;

	@PortableProperty(13)
	private String addr1;

	@PortableProperty(14)
	private String addr2;

	@PortableProperty(15)
	private String addr3;

	@PortableProperty(16)
	private String badgeNo;

	@PortableProperty(17)
	private String joinDate;

	@PortableProperty(18)
	private String empNo;

	@PortableProperty(19)
	private String comments;

	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param favSports
	 * @param phoneNumber
	 * @param email
	 * @param wechat
	 * @param company
	 * @param spouse
	 * @param manager
	 * @param title
	 * @param expertise
	 * @param addr1
	 * @param addr2
	 * @param addr3
	 * @param badgeNo
	 * @param joinDate
	 * @param empNo
	 * @param comments
	 */
	public Employee(String id, String firstName, String lastName, String gender, String favSports, String phoneNumber,
			String email, String wechat, String company, String spouse, String manager, String title, String expertise,
			String addr1, String addr2, String addr3, String badgeNo, String joinDate, String empNo, String comments) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.favSports = favSports;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.wechat = wechat;
		this.company = company;
		this.spouse = spouse;
		this.manager = manager;
		this.title = title;
		this.expertise = expertise;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.badgeNo = badgeNo;
		this.joinDate = joinDate;
		this.empNo = empNo;
		this.comments = comments;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the favSports
	 */
	public String getFavSports() {
		return favSports;
	}

	/**
	 * @param favSports
	 *            the favSports to set
	 */
	public void setFavSports(String favSports) {
		this.favSports = favSports;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the wechat
	 */
	public String getWechat() {
		return wechat;
	}

	/**
	 * @param wechat
	 *            the wechat to set
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the spouse
	 */
	public String getSpouse() {
		return spouse;
	}

	/**
	 * @param spouse
	 *            the spouse to set
	 */
	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager
	 *            the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the expertise
	 */
	public String getExpertise() {
		return expertise;
	}

	/**
	 * @param expertise
	 *            the expertise to set
	 */
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	/**
	 * @return the addr1
	 */
	public String getAddr1() {
		return addr1;
	}

	/**
	 * @param addr1
	 *            the addr1 to set
	 */
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	/**
	 * @return the addr2
	 */
	public String getAddr2() {
		return addr2;
	}

	/**
	 * @param addr2
	 *            the addr2 to set
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	/**
	 * @return the addr3
	 */
	public String getAddr3() {
		return addr3;
	}

	/**
	 * @param addr3
	 *            the addr3 to set
	 */
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	/**
	 * @return the badgeNo
	 */
	public String getBadgeNo() {
		return badgeNo;
	}

	/**
	 * @param badgeNo
	 *            the badgeNo to set
	 */
	public void setBadgeNo(String badgeNo) {
		this.badgeNo = badgeNo;
	}

	/**
	 * @return the joinDate
	 */
	public String getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate
	 *            the joinDate to set
	 */
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo
	 *            the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", favSports=" + favSports + ", phoneNumber=" + phoneNumber + ", email=" + email + ", wechat="
				+ wechat + ", company=" + company + ", spouse=" + spouse + ", manager=" + manager + ", title=" + title
				+ ", expertise=" + expertise + ", addr1=" + addr1 + ", addr2=" + addr2 + ", addr3=" + addr3
				+ ", badgeNo=" + badgeNo + ", joinDate=" + joinDate + ", empNo=" + empNo + ", comments=" + comments
				+ "]";
	}

}
