public class MovieInfo {
    String shortTitle; 	// simplified movie title, e.g. "Gangster Squad"
    String fullTitle;		// full movie title including the year, e.g. "Gangster Squad (2012)"
    int ID;							// integer ID of the movie

    public MovieInfo(int id, String s, String f) {
        ID = id;
        shortTitle = s;
        fullTitle = f;
    }

}
