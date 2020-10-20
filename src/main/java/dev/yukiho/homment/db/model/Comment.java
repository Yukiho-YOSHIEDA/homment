package dev.yukiho.homment.db.model;

import java.util.Date;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.id
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.user_from
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    private Integer userFrom;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.user_to
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    private Integer userTo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.room_id
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    private Integer roomId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.created_at
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    private String comment;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.id
     *
     * @return the value of comment.id
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.id
     *
     * @param id the value for comment.id
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.user_from
     *
     * @return the value of comment.user_from
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public Integer getUserFrom() {
        return userFrom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.user_from
     *
     * @param userFrom the value for comment.user_from
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public void setUserFrom(Integer userFrom) {
        this.userFrom = userFrom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.user_to
     *
     * @return the value of comment.user_to
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public Integer getUserTo() {
        return userTo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.user_to
     *
     * @param userTo the value for comment.user_to
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public void setUserTo(Integer userTo) {
        this.userTo = userTo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.room_id
     *
     * @return the value of comment.room_id
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.room_id
     *
     * @param roomId the value for comment.room_id
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.created_at
     *
     * @return the value of comment.created_at
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.created_at
     *
     * @param createdAt the value for comment.created_at
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment
     *
     * @return the value of comment.comment
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment
     *
     * @param comment the value for comment.comment
     *
     * @mbg.generated Wed Oct 21 05:35:11 JST 2020
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}