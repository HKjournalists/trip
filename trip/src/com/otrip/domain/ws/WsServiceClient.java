package com.otrip.domain.ws;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ws_service_client database table.
 * 
 */
@Entity
@Table(name="ws_service_client")
@NamedQuery(name="WsServiceClient.findAll", query="SELECT w FROM WsServiceClient w")
public class WsServiceClient extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_create_time")
	private Date fdCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_update_time")
	private Date fdUpdateTime;

	@Column(name="fs_client_account")
	private String fsClientAccount;

	@Column(name="fs_client_password")
	private String fsClientPassword;

	public WsServiceClient() {
	}

	public String getFsId() {
		return this.fsId;
	}

	public void setFsId(String fsId) {
		this.fsId = fsId;
	}

	public Date getFdCreateTime() {
		return this.fdCreateTime;
	}

	public void setFdCreateTime(Date fdCreateTime) {
		this.fdCreateTime = fdCreateTime;
	}

	public Date getFdUpdateTime() {
		return this.fdUpdateTime;
	}

	public void setFdUpdateTime(Date fdUpdateTime) {
		this.fdUpdateTime = fdUpdateTime;
	}

	public String getFsClientAccount() {
		return this.fsClientAccount;
	}

	public void setFsClientAccount(String fsClientAccount) {
		this.fsClientAccount = fsClientAccount;
	}

	public String getFsClientPassword() {
		return this.fsClientPassword;
	}

	public void setFsClientPassword(String fsClientPassword) {
		this.fsClientPassword = fsClientPassword;
	}

}