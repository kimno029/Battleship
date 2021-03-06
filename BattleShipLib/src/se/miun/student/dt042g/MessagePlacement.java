package se.miun.student.dt042g;

@SuppressWarnings("serial")
public class MessagePlacement extends Message {
	
	private final ShipPlacement shipPlacement;
	
	
	
	
	public MessagePlacement(ShipPlacement shipPlacement){
		super(EnumHeader.PLACEMENT);
		
		this.shipPlacement = shipPlacement;
	}
	
	public ShipPlacement getShipPlacement(){
		return shipPlacement;
	}
	
}
