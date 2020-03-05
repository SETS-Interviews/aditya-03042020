package com.ibm.part.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Single table reference to store both SaaS and SW date
 * where id is the primary key -- unique key which stores part numbers
 */
@Document
public class PartNumber {

	@Id
	public String id;
	public String dealRegGroup;
	public String startDate;
	public String endDate;
	public String addDate;
	public String modifiedDate;
	public String activeFlag;
	public String dealType;

	public PartNumber() {}

	public PartNumber(final String id, final String dealRegGroup, final String startDate, final String endDate, final String activeFlag, final String addDate, final String modifiedDate, final String dealType) {
		this.id = id;
		this.dealRegGroup = dealRegGroup;
		this.startDate = startDate;
		this.endDate = endDate;
		this.addDate = addDate;
		this.modifiedDate = modifiedDate;
		this.activeFlag = activeFlag;
		this.dealType = dealType;
	}

	public PartNumber(final String id, final String dealRegGroup, final String startDate, final String endDate, final String addDate, final String modifiedDate, final String dealType) {
		this.id = id;
		this.dealRegGroup = dealRegGroup;
		this.startDate = startDate;
		this.endDate = endDate;
		this.addDate = addDate;
		this.modifiedDate = modifiedDate;
		this.dealType = dealType;
	}

	@Override
	public String toString() {
		return "PartNumber{" +
				"id='" + id + '\'' +
				", dealRegGroup='" + dealRegGroup + '\'' +
				", startDate='" + startDate + '\'' +
				", endDate='" + endDate + '\'' +
				", addDate='" + addDate + '\'' +
				", modifiedDate='" + modifiedDate + '\'' +
				", activeFlag='" + activeFlag + '\'' +
				", dealType='" + dealType + '\'' +
				'}';
	}
}

