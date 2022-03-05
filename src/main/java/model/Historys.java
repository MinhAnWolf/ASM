package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "history", uniqueConstraints = { @UniqueConstraint(columnNames = { "UserId", "VideoId" }) })
public class Historys {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private Users users;
	@ManyToOne
	@JoinColumn(name = "VideoId")
	private Video video;
	@Temporal(TemporalType.DATE)
	Date historyDate = new Date();

	public Historys() {
	}
		
	public Historys(Users users, Video video, Date historyDate) {
		this.users = users;
		this.video = video;
		this.historyDate = historyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Date getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
	}

}
