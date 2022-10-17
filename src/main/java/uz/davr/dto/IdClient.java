package uz.davr.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class IdClient {

    private String branch;
    private String  idClient;

    public IdClient() {
    }

    public IdClient(String branch, String id_client) {
        this.branch = branch;
        this.idClient = id_client;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getId_client() {
        return idClient;
    }

    public void setId_client(String id_client) {
        this.idClient = id_client;
    }
}
