import {Video} from "./video.model";

export class Playlist {
    public playlistName?: string;
    public playlistId?: string;
    public videos?: Video[];

    constructor(playlistName?: string,
                playlistId?: string,
                videos?: Video[]) {
        this.playlistName = playlistName ? playlistName : null;
        this.playlistId = playlistId;
        this.videos = videos ? videos : null;
    }
}
