package org.elsys.cardgame.engine;

public abstract class Operation  implements org.elsys.cardgame.api.Operation{
	private String name;
	
	public Operation(String name){
		this.name = name;
	}
	public String getName() {
		return this.name;
	};

	public abstract void execute();
}
