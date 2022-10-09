package com.example.laba2.service;

import com.example.laba2.entity.Vote;
import com.example.laba2.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService implements IVoteService {

    @Autowired
    private VoteRepository voteRepository;

    public Vote vote(Long userId, Long petitionId) {
        Vote vote = new Vote(userId, petitionId);
        if (voteRepository.findByUserIdAndPetitionId(userId, petitionId).isPresent()) {
            System.out.println("Throw corresponded exception");
            return null;
        }
        return this.voteRepository.save(vote); // TODO autoincrement for db
    }

    public List<Vote> getAll() {
        return (List<Vote>) this.voteRepository.findAll();
    }

    public Vote getById(Long id) {
        // TODO check if exist
        Optional<Vote> vote = this.voteRepository.findById(id);
        // TODO throw corresponded error
        return vote.orElse(null);
    }
}