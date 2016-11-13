package be.ehb.digx.refuel.domain.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by richsoft on 13/11/2016.
 * Keeps data about the user that is logged in
 */

public class User {

    @NonNull
    private String uid;

    @NonNull
    private String providerId;

    @Nullable
    private boolean anonymous;

    @Nullable
    private List<String> providers;

    @Nullable
    private String displayName;

    @Nullable
    private Uri photoUrl;

    @Nullable
    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(@Nullable boolean anonymous) {
        this.anonymous = anonymous;
    }

    @Nullable
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(@Nullable String displayName) {
        this.displayName = displayName;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(@Nullable Uri photoUrl) {
        this.photoUrl = photoUrl;
    }

    @NonNull
    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(@NonNull String providerId) {
        this.providerId = providerId;
    }

    @Nullable
    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(@Nullable List<String> providers) {
        this.providers = providers;
    }

    @NonNull
    public String getUid() {
        return uid;
    }

    public void setUid(@NonNull String uid) {
        this.uid = uid;
    }
}
