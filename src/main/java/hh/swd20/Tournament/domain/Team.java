	package hh.swd20.Tournament.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long teamid;
	
	private String name;
	private String city;  // the city where the team comes from
	private String coach; //name of the headcoach
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
	@JsonIgnoreProperties("team")  // one way to avoid infinite loop during JSON serialization/deserialization
	private List<Player> players;

	public Team() {}
	
	public Team(String name, String city, String coach) {
		this.name = name;
		this.city = city;
		this.coach = coach;
	}

	public long getTeamid() {
		return teamid;
	}

	public void setTeamid(long teamid) {
		this.teamid = teamid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [teamid=" + teamid + ", name=" + name + ", city=" + city + ", coach=" + coach;
	}
	
	
//	 + ", players="
//		+ players + "]";
	
}
