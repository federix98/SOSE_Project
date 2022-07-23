package it.univaq.disim.sose.ratingupdater.model;

import org.json.JSONObject;

public class RatingOperationResponse {

	private String message;
	
	private Boolean outcome;

	public RatingOperationResponse(String message, Boolean outcome) {
		super();
		this.message = message;
		this.outcome = outcome;
	}

	@Override
	public String toString() {
		return "InsertResponse [message=" + message + ", outcome=" + outcome + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getOutcome() {
		return outcome;
	}

	public void setOutcome(Boolean outcome) {
		this.outcome = outcome;
	}
	
	public String getJSONResponse() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Message", this.message);
		jsonObject.put("Outcome", this.outcome);
		return jsonObject.toString();
	}
	
	
}
