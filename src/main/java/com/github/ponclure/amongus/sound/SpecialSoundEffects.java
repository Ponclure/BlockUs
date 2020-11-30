package com.github.ponclure.amongus.sound;

public enum SpecialSoundEffects {

    REPORT_BODY("body"),
    DOOR_CLOSE("door_close"),
    DOOR_OPEN("door_open"),
    EJECT("eject"),
    MEETING("meeting"),
    CHAT_NOTIFICATION("notification"),
    SELECT_VOTE("select"),
    VOTE("vote"),
    VOTE_LOCK("vote_lock"),
    IMPOSTER_KILL("impostor_kill"),
    KILL_ALIEN("kill_alien"),
    KILL_GUN("kill_gun"),
    KILL_NECK("kill_neck"),
    SABATOGE("sabatoge"),
    VENT("vent"),
    VICTORY_IMPOSTER("victory_impostor"),
    CONNECT("connect"),
    DISCONNECT("disconnect"),
    CREWMATE_KILLED("crewmate_killed"),
    VICTORY_CREWMATE("victory_crewmate"),
    TASK_COMPLETE("task_complete"),
    TASK_PROGRESS("task_progress"),
    AMBIENCE("ambience");

    private final String name;

    SpecialSoundEffects(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
