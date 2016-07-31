package br.com.desafio.spotippos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="properties")
public class Properties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private Integer x;
	
	@Column
	private Integer y;
	
	@Column
	private Integer price;
	
	@Column
	private String description;
	
	@Column
	private Integer beds;
	
	@Column
	private Integer baths;
	
	@Column
	private String[] provinces;
	
	@Column
	private Integer squareMeters;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getBeds() {
		return beds;
	}
	public void setBeds(Integer beds) {
		this.beds = beds;
	}
	public Integer getBaths() {
		return baths;
	}
	public void setBaths(Integer baths) {
		this.baths = baths;
	}
	public Integer getSquareMeters() {
		return squareMeters;
	}
	public void setSquareMeters(Integer squareMeters) {
		this.squareMeters = squareMeters;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String[] getProvinces() {
		return provinces;
	}
	public void setProvinces(String[] provinces) {
		this.provinces = provinces;
	}
	
	
	
	
}
