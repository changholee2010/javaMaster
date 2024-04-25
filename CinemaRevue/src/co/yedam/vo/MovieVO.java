package co.yedam.vo;

public class MovieVO {
	private String movieCode;
	private String movieName;
	private String directorName;
	private String movieType;
	private String genre;

	private String runningRoom;

	public String getRunningRoom() {
		return runningRoom;
	}

	public void setRunningRoom(String runningRoom) {
		this.runningRoom = runningRoom;
	}

	public String getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "MovieVO [movieCode=" + movieCode + ", movieName=" + movieName + ", directorName=" + directorName
				+ ", movieType=" + movieType + ", genre=" + genre + "]";
	}

}
