package uz.davr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientIncomeRequest {
    @JsonProperty("BRANCH")
    private String branch;
    @JsonProperty("DATE_BEG")
    private String dateBeg;
    @JsonProperty("DATE_END")
    private String dateEnd;
    @JsonProperty("ID_CLIENT")
    private String idClient;

    public ClientIncomeRequest() {
    }

    public ClientIncomeRequest(String branch, String dateBeg, String dateEnd, String idClient) {
        this.branch = branch;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.idClient = idClient;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(String dateBeg) {
        this.dateBeg = dateBeg;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
}
