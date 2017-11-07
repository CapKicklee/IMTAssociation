package db.mapper;

import errors.mapper.MapperError;
import errors.mapper.MapperErrorType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe représentant le résultat de map contenant le résultat du map
 * ainsi que les éventuelles erreurs rencontrées
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class MapperResult {

    private Optional<Mappable> mapped;
    private List<MapperError> mapperErrors;

    public MapperResult(Optional<Mappable> mapped) {
        this.mapped = mapped;
        this.mapperErrors = new ArrayList<MapperError>();
    }

    public MapperResult() {
        this.mapperErrors = new ArrayList<MapperError>();
    }

    public Optional<Mappable> getMapped() {
        return mapped;
    }

    public void setMapped(Optional<Mappable> mapped) {
        this.mapped = mapped;
    }

    public List<MapperError> getMapperErrors() {
        return this.mapperErrors;
    }

    public void addMapError(MapperError mapperError) {
        this.mapperErrors.add(mapperError);
    }

    @Override
    public String toString() {
        return "MapperResult{" +
                "mapped=" + mapped +
                ", mapperErrors=" + mapperErrors +
                '}';
    }

    public boolean hasErrors() {
        return !mapperErrors.isEmpty();
    }
}
