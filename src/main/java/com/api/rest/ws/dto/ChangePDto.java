package com.api.rest.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChangePDto {
	private String newpassword;
	private String id;

	public String getNewpassword() {
		return newpassword;
	}
	

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	


}
