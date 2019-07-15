package com.swemel.spring.prof.chapter3.domain;

public interface ArtworkSender {

    void sendArtwork(String artworkPath);

    String getFriendlyName();

    String getShortName();
}
