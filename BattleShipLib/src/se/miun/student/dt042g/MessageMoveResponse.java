package se.miun.student.dt042g;

@SuppressWarnings("serial")
public class MessageMoveResponse extends Message {
	private final EnumMoveResult result;
	
	MessageMoveResponse(EnumMoveResult result){
		super(EnumHeader.MOVERESPONSE);		
		this.result = result;
	}
	
	public EnumMoveResult getResponse(){
		return result;
	}
}
