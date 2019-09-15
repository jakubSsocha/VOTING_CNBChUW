package Objects;

import java.util.Date;

public class Result {

    private int id;
    private int voting_id;
    private int user_id;
    private String vote;
    private boolean isNew;
    private boolean isActive;
    private Date created;
    private Date modified;

    public Result(int voting_id, int user_id) {
        this.voting_id = voting_id;
        this.user_id = user_id;
    }

    public Result(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoting_id() {
        return voting_id;
    }

    public void setVoting_id(int voting_id) {
        this.voting_id = voting_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public boolean getIsActive(){
        return isActive;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", voting_id=" + voting_id +
                ", user_id=" + user_id +
                ", vote='" + vote + '\'' +
                ", modified=" + modified +
                '}';
    }
}
