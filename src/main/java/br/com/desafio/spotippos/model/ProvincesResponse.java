package br.com.desafio.spotippos.model;

import com.google.gson.annotations.SerializedName;

public class ProvincesResponse {
	
	@SerializedName(value="Gode")
	private Province gode;
	
	@SerializedName(value="Ruja")
	private Province ruja;
	
	@SerializedName(value="Jaby")
	private Province jaby;
	
	@SerializedName(value="Scavy")
	private Province scavy;
	
	@SerializedName(value="Groola")
	private Province groola;
	
	@SerializedName(value="Nova")
	private Province nova;
	
	public Province getGode() {
		return gode;
	}
	
	public void setGode(Province gode) {
		this.gode = gode;
	}
	
	public Province getRuja() {
		return ruja;
	}
	
	public void setRuja(Province ruja) {
		this.ruja = ruja;
	}
	
	public Province getJaby() {
		return jaby;
	}
	
	public void setJaby(Province jaby) {
		this.jaby = jaby;
	}
	
	public Province getScavy() {
		return scavy;
	}
	
	public void setScavy(Province scavy) {
		this.scavy = scavy;
	}
	
	public Province getGroola() {
		return groola;
	}
	
	public void setGroola(Province groola) {
		this.groola = groola;
	}
	
	public Province getNova() {
		return nova;
	}
	
	public void setNova(Province nova) {
		this.nova = nova;
	}	
}
