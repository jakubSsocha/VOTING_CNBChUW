package Objects;

public class Voting {

    private int voting_id;
    private String voting_title;
    private String voting_description;
    private String voting_status;

    public int getVoting_id() {
        return voting_id;
    }

    public void setVoting_id(int voting_id) {
        this.voting_id = voting_id;
    }

    public String getVoting_title() {
        return voting_title;
    }

    public void setVoting_title(String voting_title) {
        this.voting_title = voting_title;
    }

    public String getVoting_description() {
        return voting_description;
    }

    public void setVoting_description(String voting_description) {
        this.voting_description = voting_description;
    }

    public String getVoting_status() {
        return voting_status;
    }

    public void setVoting_status(String voting_status) {
        this.voting_status = voting_status;
    }

    public Voting(String voting_title, String voting_description, String voting_status) {
        this.voting_title = voting_title;
        this.voting_description = voting_description;
        this.voting_status = voting_status;
    }

    public Voting(){

    }

    @Override
    public String toString() {
        return "Voting{" +
                "voting_id=" + voting_id +
                ", voting_title='" + voting_title + '\'' +
                ", voting_description='" + voting_description + '\'' +
                ", voting_status='" + voting_status + '\'' +
                '}';
    }
}
