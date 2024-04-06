package com.dating.app.services;

import com.dating.app.models.Profile;
import com.dating.app.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProfileService {
    
    private final ProfileRepository profileRepository;
    
    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
    
    @Transactional
    public Profile createProfile(Profile newProfile) {
        return profileRepository.save(newProfile);
    }
    
    public Profile getProfileById(Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        if (profile.isPresent()) {
            return profile.get();
        } else {
            throw new RuntimeException("Profile not found for id :: " + id);
        }
    }
    
    @Transactional
    public Profile updateProfile(Long id, Profile updatedProfile) {
        Optional<Profile> profileToUpdate = profileRepository.findById(id);
        if (profileToUpdate.isPresent()) {
            Profile profile = profileToUpdate.get();
            
            // TODO: add the update logic for all fields in Profile model
            
            return profileRepository.save(profile);
        } else {
            throw new RuntimeException("Profile not found for id :: " + id);
        }
    }
    
    @Transactional
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
    
}