package com.app.service;

import com.app.entities.Voter;

public interface VoterService {

	String registerVoterService(Voter voter);

	Voter login(String vId, String pass);

}
