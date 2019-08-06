package com.chzm.model.avtivity;

public class PlayRole {

    private Long id;

    private String playerRoleName;

    private String brokenStrokes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerRoleName() {
        return playerRoleName;
    }

    public void setPlayerRoleName(String playerRoleName) {
        this.playerRoleName = playerRoleName;
    }

    public String getBrokenStrokes() {
        return brokenStrokes;
    }

    public void setBrokenStrokes(String brokenStrokes) {
        this.brokenStrokes = brokenStrokes;
    }
}
