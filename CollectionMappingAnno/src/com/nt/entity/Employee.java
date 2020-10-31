package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

@Entity
@Table(name = "EMPLOYEE_COLLECTION")
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 20)
	private String name;
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_HOBBIES",joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "id"))
	@Column(name="HOBBIE",length=25)
	private Set<String> hobbies;
	@ElementCollection
	@Column(name="FRIEND",length = 20)
	@CollectionTable(name = "EMPLOYEE_FRIENDS",joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "id"))
	@OrderColumn(name="FRIEND_NO")
	@ListIndexBase(value=1)
	private List<String> friends;
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_ACCOUNTS",joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "id"))
	@Column(name="ACCOUNT_NO",length = 20)
	@MapKeyColumn(name="BANK_NAME",length=10)
	private Map<String,Long> bankAccounts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set hobbies) {
		this.hobbies = hobbies;
	}
	public List getFriends() {
		return friends;
	}
	public void setFriends(List friends) {
		this.friends = friends;
	}
	public Map<String, Long> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(Map<String, Long> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", hobbies=" + hobbies + ", friends=" + friends
				+ ", bankAccounts=" + bankAccounts + "]";
	}
	
	

}
