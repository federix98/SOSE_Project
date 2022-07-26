package it.univaq.disim.sose.util;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import it.univaq.disim.sose.service.AggregateRatingsResponse;

public class MessageAsyncHandler implements AsyncHandler<AggregateRatingsResponse>{

	private AggregateRatingsResponse aggregateRatingsResponse;
	
	@Override
	public void handleResponse(Response<AggregateRatingsResponse> res) {
		// TODO Auto-generated method stub
		try {
			aggregateRatingsResponse = res.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AggregateRatingsResponse getAggregateRatingsResponse() {
		return aggregateRatingsResponse;
	}


}
