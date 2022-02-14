package com.example.countryservice.entities;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "error",
    "msg",
    "data"
})
@Generated("jsonschema2pojo")
//Generalized Pojo for Post Request to countries.now api
public class PostResponse {

    private boolean error;
    private String msg;
    private PostResponseData data;

    
    /** 
     * @return boolean
     */
    @JsonIgnore
    public boolean isError() {
        return error;
    }

    
    /** 
     * @param error
     */
    @JsonProperty("error")
    public void setError(boolean error) {
        this.error = error;
    }

    
    /** 
     * @return String
     */
    @JsonIgnore
    public String getMsg() {
        return msg;
    }

    
    /** 
     * @param msg
     */
    @JsonProperty("msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    
    /** 
     * @return PostResponseData
     */
    @JsonProperty("data")
    public PostResponseData getData() {
        return data;
    }

    
    /** 
     * @param data
     */
    @JsonProperty("data")
    public void setData(PostResponseData data) {
        this.data = data;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PostResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("error");
        sb.append('=');
        sb.append(this.error);
        sb.append(',');
        sb.append("msg");
        sb.append('=');
        sb.append(((this.msg == null)?"<null>":this.msg));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
