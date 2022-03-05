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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Favorite", uniqueConstraints = { @UniqueConstraint(columnNames = { "UserId", "VideoId" }) })
public class Favorites {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne @JoinColumn(name = "UserId")
	private Users user;
	@ManyToOne @JoinColumn(name = "VideoId")
	private Video video;
	@Temporal(TemporalType.DATE)
	private Date LikeDate = new Date();
	
	public Favorites() {
			
	}
	
	
	
	public Favorites(Users user, Video video, Date likeDate) {
		this.user = user;
		this.video = video;
		LikeDate = likeDate;
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

	public Date getLikeDate() {
		return LikeDate;
	}

	public void setLikeDate(Date likeDate) {
		LikeDate = likeDate;
	}

}
