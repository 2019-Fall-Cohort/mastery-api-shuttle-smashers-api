package org.wcci.apimastery.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String flagUrl;
	private Gender gender;
	@OneToMany(mappedBy = "team")
	private List<Player> players;

	public Team() {
	}

	public Team(String name, String flagUrl, Gender gender) {
		this.name = name;
		this.flagUrl = flagUrl;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
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

	public List<Player> getPlayers() {
		return players;
	}
	
	public String getFlagUrl() {
		return flagUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flagUrl == null) ? 0 : flagUrl.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
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
		Team other = (Team) obj;
		if (flagUrl == null) {
			if (other.flagUrl != null)
				return false;
		} else if (!flagUrl.equals(other.flagUrl))
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
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", flagUrl=" + flagUrl + ", gender=" + gender + ", players="
				+ players + "]";
	}

}
