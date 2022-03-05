package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "fillVideo",query = "select o from Video o"),
	@NamedQuery(name = "findVideo",query = "select o from Video o where id=:idVid"),
})

@Entity
@Table(name = "Video")
public class Video {
	@Id
	private String id;
	private String Title;
	private String poster;
	private int Views;
	private String Description;
	private boolean Active;
	@OneToMany(mappedBy = "video")
	private List<Favorites> favorites;

	public Video() {

	}
	
	
	
	public Video(String id, String title, String poster, int views, String description, boolean active) {
		this.id = id;
		Title = title;
		this.poster = poster;
		Views = views;
		Description = description;
		Active = active;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getViews() {
		return Views;
	}

	public void setViews(int views) {
		Views = views;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public List<Favorites> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	}

}
