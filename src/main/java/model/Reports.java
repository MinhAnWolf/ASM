package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reports {
	@Id
	private Serializable group;
	private Serializable count;
	private Long likes;
	private Date newest;
	private Date oldest;

	public Reports() {

	}

	public Reports(Serializable group,Serializable count, Date newest) {
		this.group = group;
		this.newest = newest;
		this.count = count;
	}
		

	public Serializable getCount() {
		return count;
	}

	public void setCount(Serializable count) {
		this.count = count;
	}

	public Serializable getGroup() {
		return group;
	}

	public void setGroup(Serializable group) {
		this.group = group;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}

}
