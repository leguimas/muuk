package br.com.dextra.comercial.muuk.domain.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.dextra.common.persistence.BaseEntity;

/**
 * You must have create a view VW_MUUK_OPORTUNITIES with opportunities
 * information.
 */
@Entity
@Table(name = "VW_MUUK_OPPORTUNITIES")
public class Opportunity extends BaseEntity {

	private static final long serialVersionUID = 5727791379540709862L;

	@Column(name = "ACCOUNT_NAME")
	private String accountName;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BUSINESS_EXECUTIVE_NAME")
	private String businessExecutiveName;

	@Column(name = "BUSINESS_EXECUTIVE_AVATAR")
	private String businessExecutiveAvatar;

	@Column(name = "BUSINESS_EXECUTIVE_COLOR")
	private String businessExecutiveColor;

	@Column(name = "PROJECT_MANAGER_NAME")
	private String projectManagerName;

	@Column(name = "PROJECT_MANAGER_AVATAR")
	private String projectManagerAvatar;

	@Column(name = "PROJECT_MANAGER_COLOR")
	private String projectManagerColor;

	@Column(name = "PRE_SALES_NAME")
	private String preSalesName;

	@Column(name = "PRE_SALES_AVATAR")
	private String preSalesAvatar;

	@Column(name = "PRE_SALES_COLOR")
	private String preSalesColor;

	@Column(name = "TECHINICAL_TEAM_NAME")
	private String techinicalTeamName;

	@Column(name = "TECHINICAL_TEAM_AVATAR")
	private String techinicalTeamAvatar;

	@Column(name = "TECHINICAL_TEAM_COLOR")
	private String techinicalTeamColor;

	@Column(name = "STATUS_CODE")
	private String statusCode;

	public String getAccountName() {
		return accountName;
	}

	public String getName() {
		return name;
	}

	public String getBusinessExecutiveName() {
		return businessExecutiveName;
	}

	public String getBusinessExecutiveAvatar() {
		return businessExecutiveAvatar;
	}

	public String getBusinessExecutiveColor() {
		return businessExecutiveColor;
	}

	public String getProjectManagerName() {
		return projectManagerName;
	}

	public String getProjectManagerAvatar() {
		return projectManagerAvatar;
	}

	public String getProjectManagerColor() {
		return projectManagerColor;
	}

	public String getPreSalesName() {
		return preSalesName;
	}

	public String getPreSalesAvatar() {
		return preSalesAvatar;
	}

	public String getPreSalesColor() {
		return preSalesColor;
	}

	public String getTechinicalTeamName() {
		return techinicalTeamName;
	}

	public String getTechinicalTeamAvatar() {
		return techinicalTeamAvatar;
	}

	public String getTechinicalTeamColor() {
		return techinicalTeamColor;
	}

	public String getStatusCode() {
		return statusCode;
	}

}