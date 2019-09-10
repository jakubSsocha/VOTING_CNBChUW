package Objects;

public class Result {

    private int result_id;
    private int voting_id;
    private int user_id;
    private String result_vote;
    private String status;

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
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

    public String getResult_vote() {
        return result_vote;
    }

    public void setResult_vote(String result_vote) {
        this.result_vote = result_vote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Result(int voting_id, int user_id, String result_vote, String status) {
        this.voting_id = voting_id;
        this.user_id = user_id;
        this.result_vote = result_vote;
        this.status = status;
    }

    public Result(){

    }

    public Result(int voting_id, int user_id, String status) {
        this.voting_id = voting_id;
        this.user_id = user_id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result_id=" + result_id +
                ", voting_id=" + voting_id +
                ", user_id=" + user_id +
                ", result_vote='" + result_vote + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
