package dev.yukiho.homment.db.model;

import java.util.Date;

public class Room {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.id
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.name
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.created_at
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    private Date createdAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.id
     *
     * @return the value of room.id
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.id
     *
     * @param id the value for room.id
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.name
     *
     * @return the value of room.name
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.name
     *
     * @param name the value for room.name
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.created_at
     *
     * @return the value of room.created_at
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.created_at
     *
     * @param createdAt the value for room.created_at
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}