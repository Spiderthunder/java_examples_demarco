package org.protor.sandbox.Aromano;

public abstract class AbstractTerrestrialVehicle extends AbstractVehicle {
	
private	EnumGroundContactType  groundContactType = EnumGroundContactType.WHEELS;


	public AbstractTerrestrialVehicle(EnumEngineType type) {
		super(type);
		
	}

	public AbstractTerrestrialVehicle(String name, EnumEngineType type) {
		super(name, type);
		
	}

	public EnumGroundContactType getGroundContactType() {
		return groundContactType;
	}

	public void setGroundContactType(EnumGroundContactType groundContactType) {
		this.groundContactType = groundContactType;
	}
	

}
