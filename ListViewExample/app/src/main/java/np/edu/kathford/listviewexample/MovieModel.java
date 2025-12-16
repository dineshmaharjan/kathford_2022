package np.edu.kathford.listviewexample;

public class MovieModel {
    private int id;
    private String name;
    private String duration;
    private String description;
    private String poster;

    public MovieModel(int id, String name,
                      String duration,
                      String description, String poster){
        this.id=id;
        this.name=name;
        this.duration=duration;
        this.poster=poster;
        this.description=description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setId(int id) {
        this.id=id;
    }

    public int getId(){
        return id;
    }


}
