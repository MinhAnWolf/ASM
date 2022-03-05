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
@Table(name = "Share", uniqueConstraints = { @UniqueConstraint(columnNames = { "UserId", "VideoId" }) })
public class Shares {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private Users user;
	@ManyToOne
	@JoinColumn(name = "VideoId")
	private Video video;
	private String Emails;
	@Temporal(TemporalType.DATE)
	private Date ShareDate = new Date();

	public Shares() {

	}
	
	
	
	public Shares(Users user, Video video, String email, Date shareDate) {
		this.user = user;
		this.video = video;
		Emails = email;
		ShareDate = shareDate;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public String getEmail() {
		return Emails;
	}

	public void setEmail(String email) {
		Emails = email;
	}

	public Date getShareDate() {
		return ShareDate;
	}

	public void setShareDate(Date shareDate) {
		ShareDate = shareDate;
	}

}
