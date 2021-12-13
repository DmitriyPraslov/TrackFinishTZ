package com.example.trackfinishtz.beans;

import com.example.trackfinishtz.data.Position;

import java.util.List;

public class PositionBean {
    private List<Position> positions;

    public PositionBean() {
    }

    public PositionBean(List<Position> positions) {
        this.positions = positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public int getSize(){
        return positions.size();
    }
}
