
// Class Episode represents an individual podcast episode.
// This is the equivalent of an individual "Node" in our class examples.
class Episode
{
    private String title; // episode title
    private double duration; // episode duration (minutes)

    public Episode next; // reference to next episode in playlist
    public Episode prev; // reference to previous episode in playlist

    public Episode(String title, double duration, Episode next, Episode prev)
    {
        this.title = title;
        this.duration = duration;
        this.next = next;
        this.prev = prev;
    }

    public String getTitle()
    {
        return this.title;
    }

    public double getDuration()
    {
        return this.duration;
    }

    public String toString()
    {
        return "("+ this.title + "|" + this.duration + "MIN)" ;
    }
}
