package Objects;

import DAO.Result_DAO;

import java.util.List;

public class VotingResults {

    private int voting_id = 0;
    private int TAK = 0;
    private int NIE = 0;
    private int WST = 0;
    private int votes = 0;
    private int ableToVotes = 0;
    private int quorum = 0;
    private boolean valid;

    public VotingResults(int voting_id) {

        Result_DAO result_dao = new Result_DAO();
        List<Result> resultList = result_dao.findAllVotingId(voting_id);

        this.voting_id = voting_id;
        this.ableToVotes = resultList.size();

        if (ableToVotes != 0) {
            double testquorum = (double) ableToVotes / 2.0;
            this.quorum = (int) Math.round(testquorum);
        }

        for (Result r : resultList) {
            if (r.getVote() == null) {

            } else {
                if (r.getVote().equals("TAK")) {
                    TAK++;
                    votes++;
                }
                if (r.getVote().equals("NIE")) {
                    NIE++;
                    votes++;
                }
                if (r.getVote().equals("WST")) {
                    WST++;
                    votes++;
                }
            }
        }

        this.valid=isVotingValid(quorum);

    }

    public int getQuorum() {
        return quorum;
    }

    public boolean isValid() {
        return valid;
    }

    public int getVoting_id() {
        return voting_id;
    }

    public int getTAK() {
        return TAK;
    }

    public int getNIE() {
        return NIE;
    }

    public int getWST() {
        return WST;
    }

    public int getVotes() {
        return votes;
    }

    public int getAbleToVotes() {
        return ableToVotes;
    }

    private boolean isVotingValid(int quorum) {
        if (quorum > 0) {
            if (votes >= quorum) {
                return true;
            }
        }
        return false;
    }

        @Override
        public String toString () {
            return "VotingResults{" +
                    "voting_id=" + voting_id +
                    ", TAK=" + TAK +
                    ", NIE=" + NIE +
                    ", WST=" + WST +
                    ", votes=" + votes +
                    ", ableToVotes=" + ableToVotes +
                    '}';
        }
    }
