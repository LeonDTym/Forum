package com.twopythons.forum.model.service;

public interface Voteable {

    void upvote(Long voteableId, Long userId);
    void downvote(Long voteableId, Long userId);

}
