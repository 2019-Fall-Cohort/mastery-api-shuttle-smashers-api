package org.wcci.apimastery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String country;
	public Gender gender;
	@JsonIgnore
	@ManyToOne
	private Team team;

	public Player() {
	}

	public Player(String name, String country, Gender gender, Team team) {
		this.name = name;
		this.country = country;
		this.gender = gender;
		this.team = team;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	 
	public String getCountry() {
		return country;
	}
	
	public String getGender() {
		switch (gender) {
			case MALE: 
				return "Male";
			case FEMALE:
				return "Female";
			case MIXED:
				return "Mixed";
			default:
				return "default";
		}
	}
	
	public Team getTeam() {
		return team;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (gender != other.gender)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", country=" + country + ", gender=" + gender + ", team=" + team
				+ "]";
	}

	

}
