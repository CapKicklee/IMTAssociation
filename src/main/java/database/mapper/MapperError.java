package database.mapper;

import java.util.ArrayList;
import java.util.List;

class MapperError {

    private MapperErrorType mapperErrorType;
    private List<String> complements;

    public MapperError(MapperErrorType mapperErrorType) {
        this.mapperErrorType = mapperErrorType;
        complements = new ArrayList<>();
    }

    public MapperErrorType getMapperErrorType() {
        return mapperErrorType;
    }

    public void addComplement(String complement) {
        this.complements.add(complement);
    }

    @Override
    public String toString() {
        return "MapperError{" +
                "mapperErrorType=" + mapperErrorType +
                ", complements=" + complements +
                '}';
    }
}
