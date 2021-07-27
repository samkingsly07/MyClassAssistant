package com.google.firebase.database.connection;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class CompoundHash {
    private final List<String> hashes;
    private final List<List<String>> posts;

    public CompoundHash(List<List<String>> posts2, List<String> hashes2) {
        if (posts2.size() != hashes2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.posts = posts2;
        this.hashes = hashes2;
    }

    public List<List<String>> getPosts() {
        return Collections.unmodifiableList(this.posts);
    }

    public List<String> getHashes() {
        return Collections.unmodifiableList(this.hashes);
    }
}
