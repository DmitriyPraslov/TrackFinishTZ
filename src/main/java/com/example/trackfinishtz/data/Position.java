package com.example.trackfinishtz.data;

public class Position {
    private String positionName;
    private boolean changeWorkTimePermission;

    public Position(String positionName, boolean changeWorkTimePermission) {
        this.positionName = positionName;
        this.changeWorkTimePermission = changeWorkTimePermission;
    }

    public String getPositionName() {
        return positionName;
    }

    public boolean isChangeWorkTimePermission() {
        return changeWorkTimePermission;
    }
}
