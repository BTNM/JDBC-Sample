package database;

public class Artist {
    int artistId;
    String name;

    public Artist (int artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }

    public String getName() {
        return name;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setName(String name) {
        this.name = name;
    }


}
