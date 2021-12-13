package com.example.trackfinishtz.data;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private List<Position> positionList;

    public Role() {
        positionList = new ArrayList<>();
    }

    public boolean addPosition (Position position) {
        return positionList.add(position);
    }

    public boolean removePosition (Position position) {
        return positionList.remove(position);
    }
}
