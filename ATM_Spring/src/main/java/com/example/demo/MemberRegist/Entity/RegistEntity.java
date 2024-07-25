package com.example.demo.MemberRegist.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "table1")
public class RegistEntity {
	
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "id")
	private String id;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "zandaka")
	private String zandaka;

}
