package Objects;

import java.util.Date;

public class Voting {

    private int id;
    private String title;
    private String description;
    private Date created;
    private Date closedDate;
    private boolean isNew;
    private boolean isActive;
    private boolean isClosed;

    public Voting(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Voting(){

    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
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

    public boolean getIsActive(){
        return isActive;
    }

    @Override
    public String toString() {
        return "Voting{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", closedDate=" + closedDate +
                ", isNew=" + isNew +
                ", isActive=" + isActive +
                ", isClosed=" + isClosed +
                '}';
    }
}
