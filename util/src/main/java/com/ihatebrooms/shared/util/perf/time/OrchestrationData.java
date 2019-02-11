package com.ihatebrooms.shared.util.perf.time;

import java.util.Map;

import lombok.Data;

@Data
public class OrchestrationData {

	protected String objectId;
	protected Map<String, Integer> methodCounts;
	protected long startTime;
	protected long endTime;

	public OrchestrationData(int objectId) {
		this.objectId = Integer.toString(objectId);
	}
}
