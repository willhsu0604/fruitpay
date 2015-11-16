package com.fruitpay.base.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ShipmentPeriod database table.
 * 
 */
@Entity
@NamedQuery(name="ShipmentPeriod.findAll", query="SELECT s FROM ShipmentPeriod s")
public class ShipmentPeriod extends AbstractDataBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="period_id")
	private int periodId;

	@Column(name="period_desc")
	private String periodDesc;

	@Column(name="period_name")
	private String periodName;
	
	@Column(name="duration")
	private Integer duration;

	public ShipmentPeriod() {
	}

	public int getPeriodId() {
		return this.periodId;
	}

	public void setPeriodId(int periodId) {
		this.periodId = periodId;
	}

	public String getPeriodDesc() {
		return this.periodDesc;
	}

	public void setPeriodDesc(String periodDesc) {
		this.periodDesc = periodDesc;
	}

	public String getPeriodName() {
		return this.periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}