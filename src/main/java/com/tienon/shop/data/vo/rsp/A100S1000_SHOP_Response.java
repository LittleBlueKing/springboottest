package com.tienon.shop.data.vo.rsp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class A100S1000_SHOP_Response {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nm")
    private String nm;

    @JsonProperty("tm")
    private String tm;

    @Override
    public String toString() {
        return "A100S1000_SHOP_Response{" +
                "id=" + id +
                ", nm='" + nm + '\'' +
                ", tm='" + tm + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }
}
