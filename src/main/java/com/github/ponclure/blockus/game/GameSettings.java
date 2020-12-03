package com.github.ponclure.blockus.game;

import com.google.common.collect.ImmutableMap;

public class GameSettings {

    private final int impostorCount;
    private final int commonTaskCount;
    private final int longTaskCount;
    private final int shortTaskCount;
    private final int emergencyMeetingCount;
    private final long emergencyMeetingCooldown;
    private final long killCooldown;
    private final long discussionTime;
    private final long votingTime;
    private final double velocity;
    private final double killDistance;
    private final double impostorVision;
    private final double crewmateVision;
    private final boolean isConfirmingEjections;
    private final boolean isTasksVisual;

    private GameSettings(Builder builder) {
        impostorCount = builder.impostorCount;
        commonTaskCount = builder.commonTaskCount;
        longTaskCount = builder.longTaskCount;
        shortTaskCount = builder.shortTaskCount;
        emergencyMeetingCooldown = builder.emergencyMeetingCooldown;
        emergencyMeetingCount = builder.emergencyMeetingCount;
        killCooldown = builder.killCooldown;
        discussionTime = builder.discussionTime;
        votingTime = builder.votingTime;
        velocity = builder.velocity;
        killDistance = builder.killDistance;
        impostorVision = builder.impostorVision;
        crewmateVision = builder.crewmateVision;
        isConfirmingEjections = builder.isConfirmingEjections;
        isTasksVisual = builder.isTasksVisual;
    }

    public int getImpostorCount() {
        return impostorCount;
    }

    public int getCommonTaskCount() {
        return commonTaskCount;
    }

    public int getLongTaskCount() {
        return longTaskCount;
    }

    public int getShortTaskCount() {
        return shortTaskCount;
    }

    public int getEmergencyMeetingCount() {
        return emergencyMeetingCount;
    }

    public long getEmergencyMeetingCooldown() {
        return emergencyMeetingCooldown;
    }

    public long getKillCooldown() {
        return killCooldown;
    }

    public long getDiscussionTime() {
        return discussionTime;
    }

    public long getVotingTime() {
        return votingTime;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getKillDistance() {
        return killDistance;
    }

    public double getImpostorVision() {
        return impostorVision;
    }

    public double getCrewmateVision() {
        return crewmateVision;
    }

    public boolean isConfirmingEjections() {
        return isConfirmingEjections;
    }

    public boolean isTasksVisual() {
        return isTasksVisual;
    }

    public static final class Builder {

        private int impostorCount = 2;
        private int commonTaskCount = 1;
        private int longTaskCount = 2;
        private int shortTaskCount = 2;
        private int emergencyMeetingCount = 2;
        private long emergencyMeetingCooldown = 20 * 20;
        private long killCooldown = 25 * 20;
        private long discussionTime = 30 * 20;
        private long votingTime = 60 * 20;
        private double velocity = 1.25;
        private double killDistance = 0;
        private double impostorVision = 1.6;
        private double crewmateVision = 1.2;
        private boolean isConfirmingEjections = false;
        private boolean isTasksVisual = true;

        public Builder setCommonTaskCount(int commonTaskCount) {
            this.commonTaskCount = commonTaskCount;
            return this;
        }

        public Builder setLongTaskCount(int longTaskCount) {
            this.longTaskCount = longTaskCount;
            return this;
        }

        public Builder setShortTaskCount(int shortTaskCount) {
            this.shortTaskCount = shortTaskCount;
            return this;
        }

        public Builder setEmergencyMeetingCount(int emergencyMeetingCount) {
            this.emergencyMeetingCount = emergencyMeetingCount;
            return this;
        }

        public Builder setEmergencyMeetingCooldown(long emergencyMeetingCooldown) {
            this.emergencyMeetingCooldown = emergencyMeetingCooldown;
            return this;
        }

        public Builder setKillCooldown(long killCooldown) {
            this.killCooldown = killCooldown;
            return this;
        }

        public Builder setDiscussionTime(long discussionTime) {
            this.discussionTime = discussionTime;
            return this;
        }

        public Builder setVotingTime(long votingTime) {
            this.votingTime = votingTime;
            return this;
        }

        public Builder setVelocity(double velocity) {
            this.velocity = velocity;
            return this;
        }

        public Builder setKillDistance(KillDistance killDistance) {
            if (killDistance != null) {
                this.killDistance = killDistance.i;
            }
            return this;
        }

        public Builder setImpostorVision(double impostorVision) {
            this.impostorVision = impostorVision;
            return this;
        }

        public Builder setCrewmateVision(double crewmateVision) {
            this.crewmateVision = crewmateVision;
            return this;
        }

        public Builder setConfirmingEjections(boolean confirmingEjections) {
            isConfirmingEjections = confirmingEjections;
            return this;
        }

        public Builder setTasksVisual(boolean tasksVisual) {
            isTasksVisual = tasksVisual;
            return this;
        }

        public Builder setImpostorCount(int impostorCount) {
            this.impostorCount = impostorCount;
            return this;
        }

        public static Builder of(GameSettings settings) {
            Builder builder = new Builder();
            builder.impostorCount = settings.impostorCount;
            builder.commonTaskCount = settings.commonTaskCount;
            builder.longTaskCount = settings.longTaskCount;
            builder.shortTaskCount = settings.shortTaskCount;
            builder.emergencyMeetingCooldown = settings.emergencyMeetingCooldown;
            builder.emergencyMeetingCount = settings.emergencyMeetingCount;
            builder.killCooldown = settings.killCooldown;
            builder.discussionTime = settings.discussionTime;
            builder.votingTime = settings.votingTime;
            builder.velocity = settings.velocity;
            builder.killDistance = settings.killDistance;
            builder.impostorVision = settings.impostorVision;
            builder.crewmateVision = settings.crewmateVision;
            builder.isConfirmingEjections = settings.isConfirmingEjections;
            builder.isTasksVisual = settings.isTasksVisual;
            return builder;
        }

        public GameSettings build() {
            return new GameSettings(this);
        }
    }

    public enum KillDistance {
        SHORT(0),
        MEDIUM(1),
        LONG(2);

        private final static ImmutableMap<String, KillDistance> MAP;

        static {
            ImmutableMap.Builder<String, KillDistance> builder = ImmutableMap.builder();
            for (KillDistance value : KillDistance.values()) {
                builder.put(value.name(), value);
            }
            MAP = builder.build();
        }

        private final int i;

        KillDistance(int i) {
            this.i = i;
        }

        public static KillDistance getBy(String str) {
            return MAP.get(str.toUpperCase());
        }
    }

}
