package api;

import java.time.ZonedDateTime;
import java.util.List;

public class ResultDTO {

    private int id;
    private String name;
    private String description;
    private ZonedDateTime modified;
    private ThumbnailDTO thumbnail;
    private String resourceURI;
    private ComicsDTO comics;
    private SeriesDTO series;
    private StoriesDTO stories;
    private EventsDTO events;
    private List<UrlDTO> urls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getModified() {
        return modified;
    }

    public void setModified(ZonedDateTime modified) {
        this.modified = modified;
    }

    public ThumbnailDTO getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailDTO thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public ComicsDTO getComics() {
        return comics;
    }

    public void setComics(ComicsDTO comics) {
        this.comics = comics;
    }

    public SeriesDTO getSeries() {
        return series;
    }

    public void setSeries(SeriesDTO series) {
        this.series = series;
    }

    public StoriesDTO getStories() {
        return stories;
    }

    public void setStories(StoriesDTO stories) {
        this.stories = stories;
    }

    public EventsDTO getEvents() {
        return events;
    }

    public void setEvents(EventsDTO events) {
        this.events = events;
    }

    public List<UrlDTO> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlDTO> urls) {
        this.urls = urls;
    }
}
