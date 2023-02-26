package org.example.model;

//Artist Name, Track Title, Album Title, Track Number
//Year, The Number of Reviews, The Number of Copies Sold.
public class Audio {
	public Audio(String id, String name, String track_title, String album_title, String track_num, String num_review,
			String num_copy_sold, String year) {
		super();
		this.id = id;
		this.name = name;
		this.track_title = track_title;
		this.album_title = album_title;
		this.track_num = track_num;
		this.num_review = num_review;
		this.num_copy_sold = num_copy_sold;
		this.year = year;
	}

	private String id;
	private String name;
	private String track_title;
	private String album_title;
	private String track_num;
	private String num_review;
	private String num_copy_sold;
	private String year;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}

	public void setYear(String id) {
		this.year = year;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrack_title() {
		return track_title;
	}

	public void setTrack_title(String track_title) {
		this.track_title = track_title;
	}

	public String getAlbum_title() {
		return album_title;
	}

	public void setAlbum_title(String album_title) {
		this.album_title = album_title;
	}

	public String getTrack_num() {
		return track_num;
	}

	public void setTrack_num(String track_num) {
		this.track_num = track_num;
	}

	public String getNum_review() {
		return num_review;
	}

	public void setNum_review(String num_review) {
		this.num_review = num_review;
	}

	public String getNum_copy_sold() {
		return num_copy_sold;
	}

	public void setNum_copy_sold(String num_copy_sold) {
		this.num_copy_sold = num_copy_sold;
	}

}
