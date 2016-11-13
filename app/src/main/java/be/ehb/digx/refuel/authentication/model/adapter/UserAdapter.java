package be.ehb.digx.refuel.authentication.model.adapter;

import com.google.firebase.auth.FirebaseUser;

import be.ehb.digx.refuel.domain.model.User;

/**
 * Created by richsoft on 13/11/2016.
 * Adapter for the User class
 */

public class UserAdapter {

    /**
     * Adapts FirebaseUser to User
     * @param firebaseUser
     * @return
     */
    public static User adapt (FirebaseUser firebaseUser){
        User user = new User();
        user.setAnonymous(firebaseUser.isAnonymous());
        user.setDisplayName(firebaseUser.getDisplayName());
        user.setPhotoUrl(firebaseUser.getPhotoUrl());
        user.setProviderId(firebaseUser.getProviderId());
        user.setProviders(firebaseUser.getProviders());
        user.setUid(firebaseUser.getUid());
        return user;
    }
}
