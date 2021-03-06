package se.miun.student.dt042g;

@SuppressWarnings("serial")
public class MessageLobbyStatus extends Message {
	private final EnumLobbyState state;
	
	public MessageLobbyStatus(EnumLobbyState state){
		super(EnumHeader.LOBBYSTATUS);
		this.state = state;
	}
	
	public EnumLobbyState getState(){
		return state;
	}
}