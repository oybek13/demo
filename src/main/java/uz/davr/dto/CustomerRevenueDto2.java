package uz.davr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

//@SuperBuilder
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerRevenueDto2 {
    @JsonProperty("branch")
    private String branch;
    @JsonProperty("id_client")
    private String idClient;
    @JsonProperty("date_open")
    private String dateOpen;
    @JsonProperty("name")
    private String name;
    @JsonProperty("inn_pinfl")
    private String innPinfl;
    @JsonProperty("manager")
    private String manager;
    @JsonProperty("activ")
    private String activ;
    @JsonProperty("rate")
    private String rate;
    @JsonProperty("doxod_sum")
    private String doxodSum;
    @JsonProperty("doxod_kassa")
    private String doxodKassa;
    @JsonProperty("cdo")
    private String cdo;
    @JsonProperty("ibk")
    private String ibk;
    @JsonProperty("mbk")

    private String mbk;
    @JsonProperty("doxod_val")

    private String doxodVal;
    @JsonProperty("doxod_convr")

    private String doxodConvr;


    public CustomerRevenueDto2() {
    }

    public CustomerRevenueDto2(String branch, String idClient, String dateOpen, String name, String innPinfl, String manager, String activ, String rate, String doxodSum, String doxodKassa, String cdo, String ibk, String mbk, String doxodVal, String doxodConvr) {
        this.branch = branch;
        this.idClient = idClient;
        this.dateOpen = dateOpen;
        this.name = name;
        this.innPinfl = innPinfl;
        this.manager = manager;
        this.activ = activ;
        this.rate = rate;
        this.doxodSum = doxodSum;
        this.doxodKassa = doxodKassa;
        this.cdo = cdo;
        this.ibk = ibk;
        this.mbk = mbk;
        this.doxodVal = doxodVal;
        this.doxodConvr = doxodConvr;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(String dateOpen) {
        this.dateOpen = dateOpen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInnPinfl() {
        return innPinfl;
    }

    public void setInnPinfl(String innPinfl) {
        this.innPinfl = innPinfl;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getActiv() {
        return activ;
    }

    public void setActiv(String activ) {
        this.activ = activ;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDoxodSum() {
        return doxodSum;
    }

    public void setDoxodSum(String doxodSum) {
        this.doxodSum = doxodSum;
    }

    public String getDoxodKassa() {
        return doxodKassa;
    }

    public void setDoxodKassa(String doxodKassa) {
        this.doxodKassa = doxodKassa;
    }

    public String getCdo() {
        return cdo;
    }

    public void setCdo(String cdo) {
        this.cdo = cdo;
    }

    public String getIbk() {
        return ibk;
    }

    public void setIbk(String ibk) {
        this.ibk = ibk;
    }

    public String getMbk() {
        return mbk;
    }

    public void setMbk(String mbk) {
        this.mbk = mbk;
    }

    public String getDoxodVal() {
        return doxodVal;
    }

    public void setDoxodVal(String doxodVal) {
        this.doxodVal = doxodVal;
    }

    public String getDoxodConvr() {
        return doxodConvr;
    }

    public void setDoxodConvr(String doxodConvr) {
        this.doxodConvr = doxodConvr;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomerRevenueDto2.class.getSimpleName() + "[", "]")
                .add("branch='" + branch + "'")
                .add("idClient='" + idClient + "'")
                .add("dateOpen='" + dateOpen + "'")
                .add("name='" + name + "'")
                .add("innPinfl='" + innPinfl + "'")
                .add("manager='" + manager + "'")
                .add("activ='" + activ + "'")
                .add("rate='" + rate + "'")
                .add("doxodSum='" + doxodSum + "'")
                .add("doxodKassa='" + doxodKassa + "'")
                .add("cdo='" + cdo + "'")
                .add("ibk='" + ibk + "'")
                .add("mbk='" + mbk + "'")
                .add("doxodVal='" + doxodVal + "'")
                .add("doxodConvr='" + doxodConvr + "'")
                .toString();
    }
}
