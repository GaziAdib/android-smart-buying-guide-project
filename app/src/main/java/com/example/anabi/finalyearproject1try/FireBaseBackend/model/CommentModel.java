package com.example.anabi.finalyearproject1try.FireBaseBackend.model;

public class CommentModel {

    String comment,userName,userUID,userImage,commentID;

    public CommentModel(){}

    public CommentModel(String comment, String userName, String userUID, String userImage,String commentID) {
        this.comment = comment;
        this.userName = userName;
        this.userUID = userUID;
        this.userImage = userImage;
        this.commentID = commentID;
    }

    public String getCommentID(){
        return commentID;
    }

    public String getComment() {
        return comment;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserUID() {
        return userUID;
    }

    public String getUserImage() {
        return userImage;
    }
}
