package Objects;

import java.util.Date;

public class ActiveVotingsOfUserToVote {

    private int id;
    private Date created;
    private String title;
    private String description;
    private String vote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "ActiveVotingsOfUserToVote{" +
                "id=" + id +
                ", created=" + created +
                ", title='" + title + '\'' +
                ", Description='" + description + '\'' +
                ", vote='" + vote + '\'' +
                '}';
    }
}
